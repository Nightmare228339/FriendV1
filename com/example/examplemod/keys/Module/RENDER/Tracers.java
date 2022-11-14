//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraft.entity.*;
import net.minecraftforge.client.event.*;
import com.example.examplemod.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import com.example.examplemod.Utils.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.*;
import net.minecraftforge.event.entity.player.*;

public class Tracers extends Module
{
    static final boolean $assertionsDisabled;
    public static Entity attackEntity;
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent renderWorldLastEvent) {
        final boolean valBoolean = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Player").getValBoolean();
        final boolean valBoolean2 = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Mobs").getValBoolean();
        final boolean valBoolean3 = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Item").getValBoolean();
        final boolean valBoolean4 = ExampleMod.instance.settingsManager.getSettingByName(this.name, "AttackTrace").getValBoolean();
        if (valBoolean && Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
            final boolean viewBobbing = this.mc.gameSettings.viewBobbing;
            this.mc.gameSettings.viewBobbing = false;
            this.mc.gameSettings.viewBobbing = viewBobbing;
            GL11.glPushMatrix();
            GL11.glEnable(2848);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glLineWidth(1.5f);
            for (final Entity entity : this.mc.world.loadedEntityList) {
                if (entity != this.mc.player) {
                    if (!(entity instanceof EntityPlayer)) {
                        continue;
                    }
                    assert this.mc.getRenderViewEntity() != null;
                    this.mc.player.getDistance(entity);
                    final double n = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) - this.mc.getRenderManager().viewerPosX;
                    final double n2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) - this.mc.getRenderManager().viewerPosY;
                    final double n3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) - this.mc.getRenderManager().viewerPosZ;
                    if (FriendManager.isFriend(entity.getUniqueID())) {
                        GL11.glColor4f(0.0f, 255.0f, 0.0f, 255.0f);
                    }
                    else {
                        GL11.glColor4f(255.0f, 255.0f, 255.0f, 255.0f);
                    }
                    final Vec3d rotateYaw = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(this.mc.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(this.mc.player.rotationYaw));
                    GL11.glBegin(2);
                    GL11.glVertex3d(rotateYaw.x, this.mc.player.getEyeHeight() + rotateYaw.y, rotateYaw.z);
                    GL11.glVertex3d(n, n2 + 1.1, n3);
                    GL11.glEnd();
                }
            }
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDisable(2848);
            GL11.glPopMatrix();
        }
        if (valBoolean2) {
            for (final Entity entity2 : this.mc.world.loadedEntityList) {
                if (entity2 != null && entity2 != this.mc.player && entity2 instanceof EntityPig) {
                    RenderUtils.trace_mobs(this.mc, entity2, this.mc.getRenderPartialTicks(), 1);
                }
            }
            for (final Entity entity3 : this.mc.world.loadedEntityList) {
                if (entity3 != null && entity3 != this.mc.player && entity3 instanceof EntityHorse) {
                    RenderUtils.trace_mobs(this.mc, entity3, this.mc.getRenderPartialTicks(), 1);
                }
            }
            for (final Entity entity4 : this.mc.world.loadedEntityList) {
                if (entity4 != null && entity4 != this.mc.player && entity4 instanceof EntityWolf) {
                    RenderUtils.trace_mobs(this.mc, entity4, this.mc.getRenderPartialTicks(), 1);
                }
            }
            for (final Entity entity5 : this.mc.world.loadedEntityList) {
                if (entity5 != null && entity5 != this.mc.player && entity5 instanceof EntityPolarBear) {
                    RenderUtils.trace_mobs(this.mc, entity5, this.mc.getRenderPartialTicks(), 1);
                }
            }
        }
        if (valBoolean3) {
            for (final Entity entity6 : this.mc.world.loadedEntityList) {
                if (entity6 != null && entity6 != this.mc.player && entity6 instanceof EntityItem) {
                    RenderUtils.trace_item(this.mc, entity6, this.mc.getRenderPartialTicks(), 1);
                }
            }
        }
        if (valBoolean4 && Tracers.attackEntity != null && !Tracers.attackEntity.isDead && this.mc.player.getDistance(Tracers.attackEntity) < 10.0f) {
            RenderUtils.trace(this.mc, Tracers.attackEntity, this.mc.getRenderPartialTicks(), 0);
        }
    }
    
    public Tracers() {
        super("Tracers", 0, Module$Category.RENDER);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Player", (Module)this, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Mobs", (Module)this, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Item", (Module)this, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("AttackTrace", (Module)this, false));
    }
    
    @SubscribeEvent
    public void onAttack(final AttackEntityEvent attackEntityEvent) {
        Tracers.attackEntity = attackEntityEvent.getTarget();
    }
    
    static {
        $assertionsDisabled = !Tracers.class.desiredAssertionStatus();
        Tracers.attackEntity = null;
    }
}
