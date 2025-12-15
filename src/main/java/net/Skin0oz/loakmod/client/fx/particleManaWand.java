package net.Skin0oz.loakmod.client.fx;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

/**
 * FX particules (client-side) pour tests et effets visuels.
 *
 * Règles d'utilisation :
 * - Appeler UNIQUEMENT côté client (level.isClientSide == true)
 * - Contrôler la fréquence (tick modulo) pour les effets "idle"
 */
public final class particleManaWand {

    private particleManaWand() {}

    // ---------- Couleurs Dust pratiques ----------
    public static DustParticleOptions dust(float r, float g, float b, float scale) {
        return new DustParticleOptions(new Vector3f(r, g, b), scale);
    }

    public static DustParticleOptions purple(float scale) {
        return dust(0.65f, 0.15f, 1.0f, scale);
    }

    // ---------- Utilitaires ----------
    public static Vec3 jitter(Level level, double j) {
        if (j <= 0) return Vec3.ZERO;
        double ox = (level.random.nextDouble() - 0.5) * j;
        double oy = (level.random.nextDouble() - 0.5) * j;
        double oz = (level.random.nextDouble() - 0.5) * j;
        return new Vec3(ox, oy, oz);
    }

    /**
     * Interpolation de particules sur un segment A->B.
     */
    public static void line(Level level, ParticleOptions particle, Vec3 a, Vec3 b,
                            int points, double jitter, Vec3 velocity) {
        if (points <= 0) points = 1;
        Vec3 delta = b.subtract(a);

        for (int i = 0; i <= points; i++) {
            double t = (double) i / (double) points;
            Vec3 p = a.add(delta.scale(t)).add(jitter(level, jitter));
            level.addParticle(particle, p.x, p.y, p.z, velocity.x, velocity.y, velocity.z);
        }
    }

    /**
     * Rayon "shoot" en ligne droite : start=yeux, end=raycast (bloc/entité) puis ligne de dust violette.
     * Idéal pour test visuel.
     */
    public static void shootRayDust(Level level, Player player,
                                    double range, int points,
                                    DustParticleOptions dust, double jitter, double forwardOffset) {
        Vec3 start = player.getEyePosition().add(player.getLookAngle().scale(forwardOffset));

        HitResult hit = player.pick(range, 0.0F, false);
        Vec3 end = hit.getLocation();

        // Ligne principale
        line(level, dust, start, end, points, jitter, Vec3.ZERO);

        // Petit "burst" à l'impact
        impactBurst(level, dust, end, 12, 0.15, 0.02);
    }

    /**
     * Burst d'impact (petite explosion de particules) au point P.
     */
    public static void impactBurst(Level level, ParticleOptions particle,
                                   Vec3 p, int count, double spread, double speed) {
        for (int i = 0; i < count; i++) {
            double vx = (level.random.nextDouble() - 0.5) * spread;
            double vy = (level.random.nextDouble() - 0.5) * spread;
            double vz = (level.random.nextDouble() - 0.5) * spread;
            level.addParticle(particle, p.x, p.y, p.z, vx * speed, vy * speed, vz * speed);
        }
    }

    /**
     * Cercle de particules autour d'un point (plan XZ).
     * angleOffsetRad te permet d'animer en tournant (ex: time).
     */
    public static void circleXZ(Level level, ParticleOptions particle,
                                Vec3 center, double radius,
                                int points, double angleOffsetRad,
                                double yOffset, Vec3 velocity) {
        if (points <= 0) points = 1;

        for (int i = 0; i < points; i++) {
            double a = angleOffsetRad + (Math.PI * 2.0) * ((double) i / (double) points);
            double x = center.x + Math.cos(a) * radius;
            double z = center.z + Math.sin(a) * radius;
            double y = center.y + yOffset;
            level.addParticle(particle, x, y, z, velocity.x, velocity.y, velocity.z);
        }
    }

    /**
     * Orbite idle : petites particules qui tournent autour d'un point.
     * Appel typique : une fois toutes les N ticks.
     */
    public static void idleOrbit(Level level, ParticleOptions particle,
                                 Vec3 center, double radius, int points,
                                 long gameTime, double yBobAmp, double yBobSpeed,
                                 Vec3 velocity) {
        double t = gameTime * 0.05; // vitesse rotation
        double y = Math.sin(gameTime * yBobSpeed) * yBobAmp;
        circleXZ(level, particle, center, radius, points, t, y, velocity);
    }

    /**
     * Spirale verticale simple autour d'un point.
     * Appel typique en idle: une fois toutes les N ticks.
     */
    public static void spiral(Level level, ParticleOptions particle,
                              Vec3 center, double radius,
                              int points, long gameTime,
                              double height, double turns,
                              Vec3 velocity) {
        if (points <= 0) points = 1;

        double t = gameTime * 0.05;
        for (int i = 0; i < points; i++) {
            double f = (double) i / (double) points;
            double angle = t + (Math.PI * 2.0) * turns * f;
            double y = center.y + height * f;

            double x = center.x + Math.cos(angle) * radius;
            double z = center.z + Math.sin(angle) * radius;

            level.addParticle(particle, x, y, z, velocity.x, velocity.y, velocity.z);
        }
    }

    /**
     * Ligne ondulée (style "waviness" Bolt) entre A et B.
     * waveAmp: amplitude, waveFreq: fréquence.
     */
    public static void wavyLine(Level level, ParticleOptions particle,
                                Vec3 a, Vec3 b, int points,
                                double waveAmp, double waveFreq,
                                long gameTime, Vec3 velocity) {
        if (points <= 0) points = 1;

        Vec3 delta = b.subtract(a);
        Vec3 dir = delta.normalize();
        // Un vecteur "side" approximatif pour décaler (perpendiculaire)
        Vec3 up = new Vec3(0, 1, 0);
        Vec3 side = dir.cross(up);
        if (side.lengthSqr() < 1.0e-6) side = new Vec3(1, 0, 0);
        side = side.normalize();

        for (int i = 0; i <= points; i++) {
            double f = (double) i / (double) points;
            Vec3 p = a.add(delta.scale(f));
            double wave = waveAmp * Math.sin((gameTime * 0.1) + f * waveFreq * Math.PI * 2.0);
            Vec3 offset = side.scale(wave);
            Vec3 out = p.add(offset);
            level.addParticle(particle, out.x, out.y, out.z, velocity.x, velocity.y, velocity.z);
        }
    }
}
