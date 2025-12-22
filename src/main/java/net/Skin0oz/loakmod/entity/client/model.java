package net.Skin0oz.loakmod.entity.client;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.Skin0oz.loakmod.entity.custom.RhinoEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.geom.ModelPart;
import net.Skin0oz.loakmod.entity.animations.ModAnimationDefinition;

public class model<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Rammus;
	private final ModelPart corps;
	private final ModelPart Tete;
	private final ModelPart torse;
	private final ModelPart carapacepique;
	private final ModelPart carapace;
	private final ModelPart pique;
	private final ModelPart pique6;
	private final ModelPart pique9;
	private final ModelPart pique14;
	private final ModelPart pique7;
	private final ModelPart pique13;
	private final ModelPart pique11;
	private final ModelPart pique8;
	private final ModelPart pique12;
	private final ModelPart pique10;
	private final ModelPart pique2;
	private final ModelPart pique3;
	private final ModelPart pique4;
	private final ModelPart pique16;
	private final ModelPart pique18;
	private final ModelPart pique15;
	private final ModelPart pique17;
	private final ModelPart pique5;
	private final ModelPart Brasdroit;
	private final ModelPart Canne;
	private final ModelPart corde;
	private final ModelPart brasgauche2;
	private final ModelPart JambeDroite;
	private final ModelPart pieddroit;
	private final ModelPart JambeGauche;
	private final ModelPart piedgauche;

	public model(ModelPart root) {
		this.Rammus = root.getChild("Rammus");
		this.corps = Rammus.getChild("corps");
		this.Tete = Rammus.getChild("corps").getChild("Tete");
		this.torse = Rammus.getChild("corps").getChild("torse");

		this.carapacepique = Rammus.getChild("corps").getChild("carapacepique");
		this.carapace = Rammus.getChild("corps").getChild("carapacepique").getChild("carapace");

		this.pique = Rammus.getChild("corps").getChild("carapacepique").getChild("pique");
		this.pique2 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique2");
		this.pique3 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique3");
		this.pique4 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique4");
		this.pique5 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique5");
		this.pique6 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique6");
		this.pique7 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique7");
		this.pique8 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique8");
		this.pique9 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique9");
		this.pique10 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique10");
		this.pique11 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique11");
		this.pique12 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique12");
		this.pique13 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique13");
		this.pique14 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique14");
		this.pique15 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique15");
		this.pique16 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique16");
		this.pique17 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique17");
		this.pique18 = Rammus.getChild("corps").getChild("carapacepique").getChild("pique18");

		this.Brasdroit = Rammus.getChild("Brasdroit");
		this.Canne = Rammus.getChild("Brasdroit").getChild("Canne");
		this.corde = Rammus.getChild("Brasdroit").getChild("Canne").getChild("corde");

		this.brasgauche2 = Rammus.getChild("brasgauche2");

		this.JambeDroite = Rammus.getChild("JambeDroite");
		this.pieddroit = Rammus.getChild("JambeDroite").getChild("pieddroit");

		this.JambeGauche = Rammus.getChild("JambeGauche");
		this.piedgauche = Rammus.getChild("JambeGauche").getChild("piedgauche");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Rammus = partdefinition.addOrReplaceChild("Rammus", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4733F, 16.7099F, -0.3282F, 0.0F, -1.5708F, 0.0F));

		PartDefinition corps = Rammus.addOrReplaceChild("corps", CubeListBuilder.create(), PartPose.offset(0.5428F, 1.7898F, -0.3129F));

		PartDefinition Tete = corps.addOrReplaceChild("Tete", CubeListBuilder.create().texOffs(32, 47).addBox(-3.0F, -2.0F, -1.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0161F, -4.4997F, -0.3588F));

		PartDefinition torse = corps.addOrReplaceChild("torse", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -6.0F, -4.0F, 8.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0161F, 0.5003F, -0.3588F));

		PartDefinition carapacepique = corps.addOrReplaceChild("carapacepique", CubeListBuilder.create().texOffs(80, 61).addBox(-0.0483F, 9.5009F, 3.9235F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.9678F, -15.0006F, 0.7177F));

		PartDefinition carapace = carapacepique.addOrReplaceChild("carapace", CubeListBuilder.create().texOffs(28, 56).addBox(6.0F, -7.0F, 5.0F, 1.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(80, 53).addBox(3.0F, -6.0F, 7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(18, 78).addBox(4.0F, -6.0F, 7.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(80, 57).addBox(2.0F, -6.0F, 7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(84, 0).addBox(1.0F, -6.0F, 7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(80, 25).addBox(-2.0F, -6.0F, 7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(66, 15).addBox(-3.0F, -6.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(84, 3).addBox(0.0F, -6.0F, 7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(78, 13).addBox(5.0F, -6.0F, 7.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(50, 55).addBox(-2.0F, -7.0F, 6.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(58, 21).addBox(1.0F, -8.0F, 5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 61).addBox(7.0F, -7.0F, 5.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(8.0F, -6.0F, -3.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(-0.01F))
				.texOffs(18, 40).addBox(8.0F, -7.0F, -2.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(34, 28).addBox(6.0F, -8.0F, -3.0F, 2.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(-6.0F, -8.0F, -3.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, 13).addBox(-6.0F, -7.0F, 3.0F, 12.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-5.0F, -9.0F, -2.0F, 11.0F, 1.0F, 6.0F, new CubeDeformation(0.01F))
				.texOffs(0, 35).addBox(-6.0F, -9.0F, -1.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(54, 31).addBox(-7.0F, -8.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(60, 8).addBox(-7.0F, -7.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(58, 23).addBox(-7.0F, -7.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 17).addBox(-6.0F, -7.0F, -4.0F, 12.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 21).addBox(-4.0F, -6.0F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(54, 45).addBox(-2.0F, -7.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(40, 26).addBox(1.0F, -8.0F, -4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 56).addBox(6.0F, -7.0F, -5.0F, 1.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 61).addBox(7.0F, -7.0F, -4.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 68).addBox(3.0F, -6.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(76, 83).addBox(1.0F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(80, 23).addBox(-2.0F, -6.0F, -6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(36, 17).addBox(-3.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(80, 83).addBox(0.0F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(72, 27).addBox(2.0F, -6.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(60, 72).addBox(4.0F, -6.0F, -6.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.02F))
				.texOffs(74, 6).addBox(5.0F, -6.0F, -6.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.02F)), PartPose.offset(3.9517F, 15.5009F, -1.0765F));

		PartDefinition pique = carapacepique.addOrReplaceChild("pique", CubeListBuilder.create().texOffs(16, 61).addBox(-1.0047F, 3.5F, -1.0765F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition cube_r1 = pique.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = pique.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(80, 63).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0663F, 0.0F, 0.6279F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r3 = pique.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(68, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0047F, 5.0F, -0.0765F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique6 = carapacepique.addOrReplaceChild("pique6", CubeListBuilder.create().texOffs(26, 74).addBox(-1.0047F, 3.5F, -1.0765F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 3.0F, -5.0F, 0.48F, 0.0F, -0.0436F));

		PartDefinition cube_r4 = pique6.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = pique6.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(82, 12).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0663F, 0.0F, 0.6279F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r6 = pique6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(68, 31).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0047F, 5.0F, -0.0765F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique9 = carapacepique.addOrReplaceChild("pique9", CubeListBuilder.create().texOffs(76, 0).addBox(-1.0047F, 3.5F, -1.0765F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 3.0F, -5.0F, 0.48F, 0.0F, -0.0436F));

		PartDefinition cube_r7 = pique9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(76, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = pique9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 82).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0663F, 0.0F, 0.6279F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r9 = pique9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 71).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0047F, 5.0F, -0.0765F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique14 = carapacepique.addOrReplaceChild("pique14", CubeListBuilder.create().texOffs(8, 78).addBox(-1.0047F, 3.5F, -0.9235F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 3.0F, 4.847F, -0.48F, -0.2618F, -0.0436F));

		PartDefinition cube_r10 = pique14.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(80, 5).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r11 = pique14.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(20, 83).addBox(-0.9384F, 1.5F, -0.0456F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0663F, 0.0F, -0.6279F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r12 = pique14.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(44, 72).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0047F, 5.0F, 0.0765F, 0.0F, 0.8727F, 0.0F));

		PartDefinition pique7 = carapacepique.addOrReplaceChild("pique7", CubeListBuilder.create().texOffs(74, 43).addBox(-1.0023F, -0.25F, -1.0383F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(7.1435F, 6.3409F, -3.3024F, 0.7418F, -0.1745F, -0.2182F));

		PartDefinition cube_r13 = pique7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(54, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0024F, -3.75F, 0.0383F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = pique7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(82, 42).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r15 = pique7.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(68, 37).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 1.25F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique13 = carapacepique.addOrReplaceChild("pique13", CubeListBuilder.create().texOffs(60, 77).addBox(-1.0023F, -0.25F, -0.9617F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(7.1435F, 6.3409F, 3.1494F, -0.7418F, 0.1745F, -0.2182F));

		PartDefinition cube_r16 = pique13.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(4, 80).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0024F, -3.75F, -0.0383F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r17 = pique13.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(16, 83).addBox(-0.9384F, 1.5F, -0.0456F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, -0.6662F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r18 = pique13.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(36, 72).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 1.25F, 0.0383F, 0.0F, 0.8727F, 0.0F));

		PartDefinition pique11 = carapacepique.addOrReplaceChild("pique11", CubeListBuilder.create().texOffs(76, 32).addBox(-1.0023F, -0.25F, -1.0383F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(7.1435F, 6.3409F, -3.3024F, 0.7418F, -0.1745F, -0.2182F));

		PartDefinition cube_r19 = pique11.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(30, 79).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0024F, -3.75F, 0.0383F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = pique11.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(8, 83).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r21 = pique11.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 72).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 1.25F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique8 = carapacepique.addOrReplaceChild("pique8", CubeListBuilder.create().texOffs(74, 48).addBox(-1.0024F, -0.25F, -1.0383F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(11.1435F, 7.3409F, -3.3024F, 1.0472F, -0.9599F, -0.3491F));

		PartDefinition cube_r22 = pique8.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(72, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -3.75F, 0.0383F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = pique8.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(82, 46).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r24 = pique8.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(70, 15).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0024F, 1.25F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique12 = carapacepique.addOrReplaceChild("pique12", CubeListBuilder.create().texOffs(76, 37).addBox(-1.0024F, -0.25F, -0.9617F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(11.1435F, 7.3409F, 3.1494F, -1.0472F, 0.9599F, -0.3491F));

		PartDefinition cube_r25 = pique12.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 80).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -3.75F, -0.0383F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r26 = pique12.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(12, 83).addBox(-0.9384F, 1.5F, -0.0456F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, -0.6662F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r27 = pique12.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(72, 21).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0024F, 1.25F, 0.0383F, 0.0F, 0.8727F, 0.0F));

		PartDefinition pique10 = carapacepique.addOrReplaceChild("pique10", CubeListBuilder.create().texOffs(76, 27).addBox(-1.0024F, -0.25F, -1.0383F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(11.1435F, 7.3409F, -3.3024F, 1.0472F, -0.9599F, -0.3491F));

		PartDefinition cube_r28 = pique10.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(26, 79).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -3.75F, 0.0383F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r29 = pique10.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(62, 82).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -3.75F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r30 = pique10.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(8, 72).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0024F, 1.25F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique2 = carapacepique.addOrReplaceChild("pique2", CubeListBuilder.create().texOffs(0, 61).addBox(-1.0023F, -4.75F, -1.0383F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(4.8467F, 8.2471F, -0.031F, 0.0F, 0.5672F, 0.0873F));

		PartDefinition cube_r31 = pique2.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(80, 67).addBox(-0.5F, 1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0024F, -8.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r32 = pique2.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(34, 78).addBox(-0.9384F, 0.5F, -0.9544F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -8.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r33 = pique2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, -3.25F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique3 = carapacepique.addOrReplaceChild("pique3", CubeListBuilder.create().texOffs(64, 57).addBox(-1.0024F, -0.75F, -1.0383F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(10.3774F, 5.5516F, -0.031F, 0.0F, 0.0873F, 0.3927F));

		PartDefinition cube_r34 = pique3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(38, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r35 = pique3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(80, 71).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r36 = pique3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(28, 68).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique4 = carapacepique.addOrReplaceChild("pique4", CubeListBuilder.create().texOffs(64, 64).addBox(-1.0023F, -0.75F, -1.0383F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 8.5516F, -0.031F, 0.0F, 0.0873F, 0.9163F));

		PartDefinition cube_r37 = pique4.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(42, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r38 = pique4.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(80, 75).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r39 = pique4.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(52, 72).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique16 = carapacepique.addOrReplaceChild("pique16", CubeListBuilder.create().texOffs(48, 65).addBox(-1.0023F, -0.75F, -1.0383F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 10.5516F, 2.969F, -0.1745F, 0.0873F, 1.3526F));

		PartDefinition cube_r40 = pique16.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(34, 83).addBox(-0.5F, 1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r41 = pique16.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(84, 6).addBox(-0.9384F, 2.5F, -0.9544F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r42 = pique16.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(72, 60).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique18 = carapacepique.addOrReplaceChild("pique18", CubeListBuilder.create().texOffs(66, 47).addBox(-1.0023F, -0.75F, -0.9617F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 10.5516F, -4.122F, 0.1745F, -0.0873F, 1.3526F));

		PartDefinition cube_r43 = pique18.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(46, 83).addBox(-0.5F, 1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, -0.0382F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r44 = pique18.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(84, 27).addBox(-0.9384F, 2.5F, -0.0456F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, -0.6662F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r45 = pique18.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 74).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, 0.0383F, 0.0F, 0.8727F, 0.0F));

		PartDefinition pique15 = carapacepique.addOrReplaceChild("pique15", CubeListBuilder.create().texOffs(56, 65).addBox(-1.0023F, -0.75F, -1.0383F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 15.5516F, 2.969F, -0.3054F, 0.2618F, 1.4835F));

		PartDefinition cube_r46 = pique15.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(38, 83).addBox(-0.5F, 1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r47 = pique15.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(84, 18).addBox(-0.9384F, 2.5F, -0.9544F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r48 = pique15.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(72, 66).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition pique17 = carapacepique.addOrReplaceChild("pique17", CubeListBuilder.create().texOffs(66, 8).addBox(-1.0023F, -0.75F, -0.9617F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 15.5516F, -4.122F, 0.3054F, -0.2618F, 1.4835F));

		PartDefinition cube_r49 = pique17.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(42, 83).addBox(-0.5F, 1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, -0.0382F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r50 = pique17.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(24, 84).addBox(-0.9384F, 2.5F, -0.0456F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, -0.6662F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r51 = pique17.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(72, 72).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, 0.0383F, 0.0F, 0.8727F, 0.0F));

		PartDefinition pique5 = carapacepique.addOrReplaceChild("pique5", CubeListBuilder.create().texOffs(72, 54).addBox(-1.0023F, 0.25F, -1.0383F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(13.3774F, 13.5516F, -0.031F, 0.0F, 0.0873F, 1.4399F));

		PartDefinition cube_r52 = pique5.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(46, 78).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -4.25F, 0.0382F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r53 = pique5.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(80, 79).addBox(-0.9384F, 1.5F, -0.9544F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -4.25F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r54 = pique5.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(40, 65).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.75F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition Brasdroit = Rammus.addOrReplaceChild("Brasdroit", CubeListBuilder.create(), PartPose.offset(-0.1229F, -2.1601F, 6.3282F));

		PartDefinition cube_r55 = Brasdroit.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(64, 23).addBox(-1.9142F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.7751F, 4.9606F, 1.5F, 0.0F, -0.4363F, -0.7854F));

		PartDefinition cube_r56 = Brasdroit.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(60, 11).addBox(-1.9142F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-4.3608F, 6.3748F, 1.5F, 0.0F, -0.48F, -0.6109F));

		PartDefinition cube_r57 = Brasdroit.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(82, 50).addBox(-3.9142F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.015F)), PartPose.offsetAndRotation(-4.7941F, 6.6782F, 2.4768F, 0.0F, -1.0472F, -0.6109F));

		PartDefinition cube_r58 = Brasdroit.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(82, 16).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.015F)), PartPose.offsetAndRotation(-6.8138F, 5.9994F, 0.9811F, 0.0F, -1.2217F, -0.7854F));

		PartDefinition cube_r59 = Brasdroit.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(68, 6).addBox(-1.1789F, -1.1993F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.4215F, 4.1928F, -0.5F, 0.0F, -0.6545F, 0.4363F));

		PartDefinition cube_r60 = Brasdroit.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(54, 38).addBox(-8.0F, -1.0F, -2.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 56).addBox(-4.0F, -0.5F, -2.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3504F, -0.0498F, 0.0F, 0.0F, 0.3491F, -0.7854F));

		PartDefinition Canne = Brasdroit.addOrReplaceChild("Canne", CubeListBuilder.create().texOffs(40, 56).addBox(-0.4288F, -2.2088F, -1.2503F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-7.7573F, 4.9332F, -1.3631F, 0.2618F, 0.0F, -0.9599F));

		PartDefinition cube_r61 = Canne.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(24, 61).addBox(-0.712F, 1.2912F, -1.0736F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0023F, -13.5F, 0.0383F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r62 = Canne.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(68, 77).addBox(-0.7321F, 5.2912F, -1.5301F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.064F, -13.5F, 0.6662F, 0.0F, -0.8727F, 0.0F));

		PartDefinition cube_r63 = Canne.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(60, 0).addBox(-0.7937F, -1.7088F, -1.5757F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.0023F, 0.5F, -0.0383F, 0.0F, -0.8727F, 0.0F));

		PartDefinition corde = Canne.addOrReplaceChild("corde", CubeListBuilder.create(), PartPose.offset(0.5068F, -11.22F, -0.1369F));

		PartDefinition cube_r64 = corde.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(16, 68).addBox(0.5F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9989F, 2.2777F, -1.8916F, -0.1618F, 0.038F, 0.9278F));

		PartDefinition brasgauche2 = Rammus.addOrReplaceChild("brasgauche2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4733F, -2.2099F, -4.6718F, -0.2182F, -0.1309F, 0.0F));

		PartDefinition cube_r65 = brasgauche2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(14, 56).addBox(-4.0F, -1.5F, -1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r66 = brasgauche2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(68, 43).addBox(-3.9142F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.015F)), PartPose.offsetAndRotation(-5.4102F, 6.6984F, -1.3949F, 0.0F, 1.0472F, -0.6109F));

		PartDefinition cube_r67 = brasgauche2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(18, 70).addBox(-1.9142F, -0.5F, -0.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-5.0104F, 6.4246F, -0.5F, 0.0F, 0.48F, -0.6109F));

		PartDefinition cube_r68 = brasgauche2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(78, 19).addBox(-1.9142F, -0.5F, -0.4F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-6.4246F, 5.0104F, -0.5F, 0.0F, 0.4363F, -0.7854F));

		PartDefinition cube_r69 = brasgauche2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(80, 10).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.015F)), PartPose.offsetAndRotation(-7.4391F, 6.0179F, 0.1031F, 0.0F, 1.2217F, -0.7854F));

		PartDefinition cube_r70 = brasgauche2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(18, 68).addBox(-2.1789F, -1.1993F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-6.0711F, 4.2426F, 0.5F, 0.0F, 0.3927F, 0.0436F));

		PartDefinition cube_r71 = brasgauche2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(50, 47).addBox(-8.8F, -2.5F, -2.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, -0.7854F));

		PartDefinition JambeDroite = Rammus.addOrReplaceChild("JambeDroite", CubeListBuilder.create(), PartPose.offset(0.0267F, 1.2901F, 3.3282F));

		PartDefinition cube_r72 = JambeDroite.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(54, 26).addBox(-3.5F, -1.5F, -1.0F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition pieddroit = JambeDroite.addOrReplaceChild("pieddroit", CubeListBuilder.create(), PartPose.offset(0.5F, 5.0F, 1.5F));

		PartDefinition cube_r73 = pieddroit.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(50, 83).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-3.0F, 0.5F, -1.0F, -0.2618F, 0.0F, -1.5708F));

		PartDefinition cube_r74 = pieddroit.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(68, 54).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-3.0F, 0.5F, 1.0F, 0.1309F, 0.0F, -1.5708F));

		PartDefinition cube_r75 = pieddroit.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(56, 57).addBox(-3.5F, -3.5F, -2.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.5F, -2.5F, 0.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition JambeGauche = Rammus.addOrReplaceChild("JambeGauche", CubeListBuilder.create(), PartPose.offset(0.0267F, 1.2901F, -4.6718F));

		PartDefinition cube_r76 = JambeGauche.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(40, 21).addBox(-3.5F, -1.5F, -1.0F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition piedgauche = JambeGauche.addOrReplaceChild("piedgauche", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.5F));

		PartDefinition cube_r77 = piedgauche.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(72, 83).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.0F, -0.1309F, 0.0F, -1.5708F));

		PartDefinition cube_r78 = piedgauche.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(48, 57).addBox(-1.0F, -3.0F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r79 = piedgauche.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(54, 83).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-2.5F, 0.5F, 1.0F, 0.1745F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(
			T entity,
			float limbSwing,
			float limbSwingAmount,
			float ageInTicks,
			float netHeadYaw,
			float headPitch
	) {
		// Reset pose
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation((RhinoEntity) entity,netHeadYaw,headPitch,ageInTicks);

		this.animateWalk(ModAnimationDefinition.WALK,limbSwing,limbSwingAmount, 2f,2.5f);
		this.animate(((RhinoEntity) entity).idleAnimationState, ModAnimationDefinition.IDLE, ageInTicks, 1f);
	}

	private void animate(AnimationState idleAnimationState, AnimationDefinition idle) {
	}

	private void applyHeadRotation(RhinoEntity pEntity,float pNetHeadYaw, float pHeadPitch, float pAgeInTicks){
		pNetHeadYaw = Mth.clamp(pNetHeadYaw,-30.0F,30.0F);
		pHeadPitch= Mth.clamp(pHeadPitch,0,0);

		this.Tete.yRot = pNetHeadYaw * ((float)Math.PI/180F);
		this.Tete.xRot = pHeadPitch * ((float)Math.PI/180F);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Rammus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Rammus;
	}






}