package net.Skin0oz.loakmod.client.fx;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * FX client-side :
 * - Séquence de 3 pentagrammes successifs
 * - Position figée au lancement
 * - Orienté face au joueur (normale = look au cast)
 *
 * Utilisation recommandée :
 * - Au clic (use) : ManaWandParticle.startTriplePentagram(particle, ratio)
 * - Chaque tick (runtime client) : ManaWandParticle.clientTick(particle, ratio)
 */
public final class ManaWandParticle {

    static ParticleOptions spellParticle = ParticleTypes.ENCHANTED_HIT;
    private ManaWandParticle() {}

    // ===================== NBT =====================
    private static final String KEY_ACTIVE = "triple_penta_active";
    private static final String KEY_START  = "triple_penta_start";

    private static final String KEY_CX = "triple_penta_cx";
    private static final String KEY_CY = "triple_penta_cy";
    private static final String KEY_CZ = "triple_penta_cz";

    private static final String KEY_NX = "triple_penta_nx";
    private static final String KEY_NY = "triple_penta_ny";
    private static final String KEY_NZ = "triple_penta_nz";

    // ===================== TIMING =====================
    private static final int PHASE_TICKS = 14;
    private static final int TOTAL_TICKS = PHASE_TICKS * 3;

    // ===================== API : START (au clic) =====================

    /**
     * Initialise la séquence sur le stack tenu (main/offhand) du joueur local.
     * À appeler au clic (use), côté client.
     */
    public static void startTriplePentagram(double densityRatio) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.level == null || mc.player == null) return;

        Level level = mc.level;
        Player player = mc.player;
        if (!level.isClientSide) return;

        ItemStack stack = getHeldStack(player);
        if (stack.isEmpty()) return;

        // Démarre (init NBT si pas actif)
        triplePentagramSequence(level, player, stack, spellParticle, densityRatio);
    }

    // ===================== API : TICK (runtime client) =====================

    /**
     * À appeler 1 fois par tick (via ton LoakClientRuntime).
     * Continue la séquence si active sur le stack tenu.
     */
    public static void clientTick(double densityRatio) {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.level == null || mc.player == null) return;

        Level level = mc.level;
        Player player = mc.player;
        if (!level.isClientSide) return;

        ItemStack stack = getHeldStack(player);
        if (stack.isEmpty()) return;

        // Continue uniquement si déjà actif
        if (stack.hasTag() && stack.getTag().getBoolean(KEY_ACTIVE)) {
            triplePentagramSequence(level, player, stack, spellParticle, densityRatio);
        }
    }

    // ===================== CORE : Séquence multi-tick =====================

    /**
     * Implémentation interne : calcule phase + spawn particules.
     */
    private static void triplePentagramSequence(Level level, Player player, ItemStack stack,
                                                ParticleOptions particle, double densityRatio) {
        if (!level.isClientSide || player == null || stack == null || particle == null) return;

        // clamp ratio
        if (densityRatio < 0.1) densityRatio = 0.1;
        if (densityRatio > 6.0) densityRatio = 6.0;

        var tag = stack.getOrCreateTag();
        long now = level.getGameTime();

        // ===================== INITIALISATION =====================
        if (!tag.getBoolean(KEY_ACTIVE)) {
            tag.putBoolean(KEY_ACTIVE, true);
            tag.putLong(KEY_START, now);

            // position figée devant le joueur + offset bas
            Vec3 center = player.getEyePosition()
                    .add(player.getLookAngle().normalize().scale(2.2))
                    .add(0.0, -0.25, 0.0);

            tag.putDouble(KEY_CX, center.x);
            tag.putDouble(KEY_CY, center.y);
            tag.putDouble(KEY_CZ, center.z);

            // orientation figée (normale du plan)
            Vec3 normal = player.getLookAngle().normalize();
            tag.putDouble(KEY_NX, normal.x);
            tag.putDouble(KEY_NY, normal.y);
            tag.putDouble(KEY_NZ, normal.z);
        }

        long start = tag.getLong(KEY_START);
        long elapsed = now - start;

        // ===================== FIN =====================
        if (elapsed < 0 || elapsed >= TOTAL_TICKS) {
            tag.remove(KEY_ACTIVE);
            // optionnel : nettoyage complet
            // tag.remove(KEY_START); tag.remove(KEY_CX); ...
            return;
        }

        // ===================== THROTTLE (adapté au ratio) =====================
        // ratio ↑ => on dessine un peu plus souvent (jusqu'à 1 tick)
        int drawEvery = (int) Math.round(5.0 / densityRatio);
        if (drawEvery < 1) drawEvery = 1;
        if ((now % drawEvery) != 0) return;

        // ===================== PHASE =====================
        int phase = (int) (elapsed / PHASE_TICKS);
        double phaseProg = (elapsed % PHASE_TICKS) / (double) PHASE_TICKS;

        // ===================== PARAMÈTRES BASE =====================
        double radius;
        int edgePtsBase;
        double yOff;

        if (phase == 0) {
            radius = 0.9;
            edgePtsBase = 6;
            yOff = 0.00;
        } else if (phase == 1) {
            radius = 1.4;
            edgePtsBase = 8;
            yOff = 0.05;
        } else {
            radius = 1.9;
            edgePtsBase = 10;
            yOff = 0.10;
        }

        int edgePts = (int) Math.round(edgePtsBase * densityRatio);
        if (edgePts < 2) edgePts = 2;
        if (edgePts > 60) edgePts = 60;

        double pulse = 0.15 * Math.sin(phaseProg * Math.PI);
        double finalRadius = radius + pulse;
        double angle = now * 0.18;

        Vec3 center = new Vec3(
                tag.getDouble(KEY_CX),
                tag.getDouble(KEY_CY) + yOff,
                tag.getDouble(KEY_CZ)
        );

        Vec3 normal = new Vec3(
                tag.getDouble(KEY_NX),
                tag.getDouble(KEY_NY),
                tag.getDouble(KEY_NZ)
        ).normalize();

        double tangentialSpeed = 0.035 * (0.85 + 0.15 * Math.min(densityRatio, 3.0));

        pentagramMovingFacing(
                level,
                particle,
                center,
                normal,
                finalRadius,
                angle,
                edgePts,
                tangentialSpeed
        );
    }

    // ===================== HELPERS =====================

    private static ItemStack getHeldStack(Player player) {
        ItemStack stack = player.getMainHandItem();
        if (stack.isEmpty()) stack = player.getOffhandItem();
        return stack;
    }

    private static void pentagramMovingFacing(
            Level level,
            ParticleOptions particle,
            Vec3 center,
            Vec3 normal,
            double radius,
            double angle,
            int edgePts,
            double tangentialSpeed
    ) {
        // base orthonormée du plan
        Vec3 up = Math.abs(normal.y) < 0.99 ? new Vec3(0, 1, 0) : new Vec3(1, 0, 0);
        Vec3 right = normal.cross(up).normalize();
        Vec3 forward = right.cross(normal).normalize();

        Vec3[] v = new Vec3[5];

        for (int i = 0; i < 5; i++) {
            double a = angle + (Math.PI * 2.0) * (i / 5.0);
            Vec3 offset = right.scale(Math.cos(a) * radius).add(forward.scale(Math.sin(a) * radius));
            v[i] = center.add(offset);
        }

        int[] order = {0, 2, 4, 1, 3, 0};

        for (int i = 0; i < order.length - 1; i++) {
            Vec3 A = v[order[i]];
            Vec3 B = v[order[i + 1]];
            Vec3 delta = B.subtract(A);

            for (int p = 0; p <= edgePts; p++) {
                double t = (double) p / (double) edgePts;
                Vec3 pos = A.add(delta.scale(t));

                Vec3 radial = pos.subtract(center);
                Vec3 tangent = normal.cross(radial);
                if (tangent.lengthSqr() > 1.0e-9) {
                    tangent = tangent.normalize().scale(tangentialSpeed);
                } else {
                    tangent = Vec3.ZERO;
                }

                level.addParticle(
                        particle,
                        pos.x, pos.y, pos.z,
                        tangent.x, tangent.y, tangent.z
                );
            }
        }
    }
}