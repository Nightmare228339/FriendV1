//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import java.awt.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;

public class RenderUtils
{
    public static void trace_mobs(final Minecraft minecraft, final Entity entity, final float n, final int n2) {
        if (minecraft.getRenderManager().renderViewEntity != null) {
            GL11.glDisable(2929);
            GL11.glDisable(2896);
            GL11.glLineWidth(2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask(false);
            GL11.glColor4d(0.0, (n2 == 1) ? 1.0 : 1.0, 0.0, 1.0);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glBegin(1);
            final RenderManager getRenderManager = minecraft.getRenderManager();
            final Vec3d rotateYaw = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(minecraft.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(minecraft.player.rotationYaw));
            GL11.glVertex3d(rotateYaw.x, minecraft.player.getEyeHeight() + rotateYaw.y, rotateYaw.z);
            GL11.glVertex3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n - getRenderManager.viewerPosX, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n - getRenderManager.viewerPosY + 0.25, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n - getRenderManager.viewerPosZ);
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
        }
    }
    
    public static void drawESP(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5) {
        final double n6 = Wrapper.INSTANCE.mc().getRenderManager().viewerPosX - 0.4;
        final double viewerPosY = Wrapper.INSTANCE.mc().getRenderManager().viewerPosY;
        final double viewerPosZ = Wrapper.INSTANCE.mc().getRenderManager().viewerPosZ;
        final double n7 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n5 - n6;
        final double n8 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n5 + entity.height / 3.2f - viewerPosY;
        final double n9 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n5 - viewerPosZ;
        final float playerViewY = Wrapper.INSTANCE.mc().getRenderManager().playerViewY;
        final float playerViewX = Wrapper.INSTANCE.mc().getRenderManager().playerViewX;
        final boolean b = Wrapper.INSTANCE.mc().getRenderManager().options.thirdPersonView == 2;
        GL11.glPushMatrix();
        GlStateManager.translate(n7, n8, n9);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((b ? -1 : 1) * playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(1.0f);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glColor4f(n, n2, n3, n4);
        GL11.glBegin(3);
        GL11.glVertex3d(0.55, -0.2, 0.0);
        GL11.glVertex3d(0.55, 1.9, 0.0);
        GL11.glVertex3d(-1.15, 1.9, 0.0);
        GL11.glVertex3d(-1.15, -0.2, 0.0);
        GL11.glVertex3d(0.55, -0.2, 0.0);
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        try {
            GL11.glPopMatrix();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void getPlayerHealth(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5) {
        final double n6 = Wrapper.INSTANCE.mc().getRenderManager().viewerPosX - 0.4;
        final double viewerPosY = Wrapper.INSTANCE.mc().getRenderManager().viewerPosY;
        final double viewerPosZ = Wrapper.INSTANCE.mc().getRenderManager().viewerPosZ;
        final double n7 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n5 - n6;
        final double n8 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n5 + entity.height / 3.2f - viewerPosY;
        final double n9 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n5 - viewerPosZ;
        final float playerViewY = Wrapper.INSTANCE.mc().getRenderManager().playerViewY;
        final float playerViewX = Wrapper.INSTANCE.mc().getRenderManager().playerViewX;
        final boolean b = Wrapper.INSTANCE.mc().getRenderManager().options.thirdPersonView == 2;
        GL11.glPushMatrix();
        GlStateManager.translate(n7, n8, n9);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((b ? -1 : 1) * playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(1.0f);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glColor4f(n, n2, n3, n4);
        GL11.glBegin(3);
        GL11.glVertex3d(-1.5, -0.2, 0.0);
        GL11.glVertex3d(-1.5, ((EntityLivingBase)entity).getHealth() / ((EntityLivingBase)entity).getMaxHealth() * (entity.height + 0.2), 0.0);
        GL11.glVertex3d(-1.5, -0.2, 0.0);
        try {
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glDisable(2848);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void drawESPMobe(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5) {
        final double viewerPosX = Wrapper.INSTANCE.mc().getRenderManager().viewerPosX;
        final double viewerPosY = Wrapper.INSTANCE.mc().getRenderManager().viewerPosY;
        final double viewerPosZ = Wrapper.INSTANCE.mc().getRenderManager().viewerPosZ;
        final double n6 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n5 - viewerPosX;
        final double n7 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n5 + entity.height / 2.0f - viewerPosY;
        final double n8 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n5 - viewerPosZ;
        final float playerViewY = Wrapper.INSTANCE.mc().getRenderManager().playerViewY;
        final float playerViewX = Wrapper.INSTANCE.mc().getRenderManager().playerViewX;
        final boolean b = Wrapper.INSTANCE.mc().getRenderManager().options.thirdPersonView == 2;
        GL11.glPushMatrix();
        GlStateManager.translate(n6, n7, n8);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((b ? -1 : 1) * playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(1.0f);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glColor4f(n, n2, n3, n4);
        GL11.glBegin(1);
        GL11.glVertex3d(0.0, 1.0, 0.0);
        GL11.glVertex3d(-0.5, 0.5, 0.0);
        GL11.glVertex3d(0.0, 1.0, 0.0);
        GL11.glVertex3d(0.5, 0.5, 0.0);
        GL11.glVertex3d(0.0, 0.0, 0.0);
        GL11.glVertex3d(-0.5, 0.5, 0.0);
        GL11.glVertex3d(0.0, 0.0, 0.0);
        GL11.glVertex3d(0.5, 0.5, 0.0);
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glDisable(2848);
        final int n9 = 3042;
        try {
            GL11.glDisable(n9);
            GL11.glPopMatrix();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void blockESP(final BlockPos blockPos) {
        GL11.glPushMatrix();
        final double n = blockPos.getX() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        final double n2 = blockPos.getY() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        final double n3 = blockPos.getZ() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        RenderGlobal.renderFilledBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0), 0.0f, 1.0f, 0.0f, 0.5f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void drawRect(double n, double n2, double n3, double n4, final int n5) {
        if (n < n3) {
            final double n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            final double n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        final float n8 = (n5 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n5 & 0xFF) / 255.0f;
        final Tessellator getInstance = Tessellator.getInstance();
        final BufferBuilder getBuffer = getInstance.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(n9, n10, n11, n8);
        getBuffer.begin(7, DefaultVertexFormats.POSITION);
        getBuffer.pos(n, n4, 0.0).endVertex();
        getBuffer.pos(n3, n4, 0.0).endVertex();
        getBuffer.pos(n3, n2, 0.0).endVertex();
        getBuffer.pos(n, n2, 0.0).endVertex();
        getInstance.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void NoneCode(final Entity entity) {
        final double n = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        final double n2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        final double n3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glPushMatrix();
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glTranslatef((float)n, (float)n2, (float)n3);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glLineWidth(3.0f);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glBegin(3);
        GL11.glVertex3d(entity.width + 0.1, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.1, entity.height + 0.4, 0.0);
        GL11.glVertex3d(-entity.width - 0.1, entity.height + 0.4, 0.0);
        GL11.glVertex3d(-entity.width - 0.1, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.1, -0.4, 0.0);
        GL11.glEnd();
        GL11.glLineWidth(0.7f);
        GL11.glColor3f(255.0f, 255.0f, 255.0f);
        GL11.glBegin(3);
        GL11.glVertex3d(entity.width + 0.1, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.1, entity.height + 0.4, 0.0);
        GL11.glVertex3d(-entity.width - 0.1, entity.height + 0.4, 0.0);
        GL11.glVertex3d(-entity.width - 0.1, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.1, -0.4, 0.0);
        GL11.glEnd();
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glLineWidth(3.0f);
        GL11.glBegin(3);
        GL11.glVertex3d(entity.width + 0.4, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.4, entity.height + 0.4, 0.0);
        GL11.glEnd();
        GL11.glColor3f((float)Color.GRAY.getRed(), (float)Color.GRAY.getGreen(), (float)Color.GRAY.getBlue());
        GL11.glLineWidth(0.7f);
        GL11.glBegin(3);
        GL11.glVertex3d(entity.width + 0.4, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.4, entity.height + 0.4, 0.0);
        GL11.glEnd();
        GL11.glColor3f(0.0f, 255.0f, 0.0f);
        GL11.glBegin(3);
        GL11.glVertex3d(entity.width + 0.4, -0.4, 0.0);
        GL11.glVertex3d(entity.width + 0.4, ((EntityPlayer)entity).getHealth() / ((EntityPlayer)entity).getMaxHealth() * (entity.height + 0.4), 0.0);
        GL11.glEnd();
        GL11.glBegin(3);
        GL11.glEnd();
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glColor3f(255.0f, 255.0f, 255.0f);
        try {
            GL11.glPopMatrix();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void renderEntity(final EntityLivingBase entityLivingBase, final int n, final int n2, final int n3) {
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
        GL11.glPushAttrib(524288);
        GL11.glDisable(3089);
        GlStateManager.clear(256);
        GL11.glPopAttrib();
        GlStateManager.enableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GuiInventory.drawEntityOnScreen(n2, n3, n, 1.0f, 1.0f, entityLivingBase);
        GlStateManager.popMatrix();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
    }
    
    public static void drawCircle(final float n, final float n2, final float n3, final int n4, final int n5) {
        final float n6 = (n4 >> 24 & 0xFF) / 255.0f;
        final float n7 = (n4 >> 16 & 0xFF) / 255.0f;
        final float n8 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n9 = (n4 & 0xFF) / 255.0f;
        final boolean glIsEnabled = GL11.glIsEnabled(3042);
        final boolean glIsEnabled2 = GL11.glIsEnabled(2848);
        final boolean glIsEnabled3 = GL11.glIsEnabled(3553);
        if (!glIsEnabled) {
            GL11.glEnable(3042);
        }
        if (!glIsEnabled2) {
            GL11.glEnable(2848);
        }
        if (glIsEnabled3) {
            GL11.glDisable(3553);
        }
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(n7, n8, n9, n6);
        GL11.glLineWidth(2.5f);
        GL11.glBegin(3);
        for (int i = 0; i <= n5; ++i) {
            GL11.glVertex2d(n + Math.sin(i * 3.141592653589793 / 180.0) * n3, n2 + Math.cos(i * 3.141592653589793 / 180.0) * n3);
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        if (glIsEnabled3) {
            GL11.glEnable(3553);
        }
        if (!glIsEnabled2) {
            GL11.glDisable(2848);
        }
        if (!glIsEnabled) {
            GL11.glDisable(3042);
        }
    }
    
    public static void FillLine(final Entity entity, final AxisAlignedBB axisAlignedBB) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        RenderGlobal.renderFilledBox(axisAlignedBB, 0.0f, 0.0f, 1.0f, 0.3f);
        RenderGlobal.drawSelectionBoundingBox(axisAlignedBB, 0.0f, 0.0f, 1.0f, 0.8f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
    
    public static Vec3d getRenderPos(double n, double n2, double n3) {
        n -= Minecraft.getMinecraft().getRenderManager().viewerPosX;
        n2 -= Minecraft.getMinecraft().getRenderManager().viewerPosY;
        n3 -= Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        return new Vec3d(n, n2, n3);
    }
    
    public static void drawImage(final ResourceLocation resourceLocation, final int n, final int n2, final int n3, final int n4) {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        Gui.drawModalRectWithCustomSizedTexture(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    public static void trace_item(final Minecraft minecraft, final Entity entity, final float n, final int n2) {
        if (minecraft.getRenderManager().renderViewEntity != null) {
            GL11.glDisable(2929);
            GL11.glDisable(2896);
            GL11.glLineWidth(2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask(false);
            GL11.glColor4d(1.0, (n2 == 1) ? 0.0 : 0.0, 0.0, 1.0);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glBegin(1);
            final RenderManager getRenderManager = minecraft.getRenderManager();
            final Vec3d rotateYaw = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(minecraft.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(minecraft.player.rotationYaw));
            GL11.glVertex3d(rotateYaw.x, minecraft.player.getEyeHeight() + rotateYaw.y, rotateYaw.z);
            GL11.glVertex3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n - getRenderManager.viewerPosX, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n - getRenderManager.viewerPosY + 0.25, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n - getRenderManager.viewerPosZ);
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
        }
    }
    
    public static void putVertex3d(final Vec3d vec3d) {
        GL11.glVertex3d(vec3d.x, vec3d.y, vec3d.z);
    }
    
    public static void FillLine_mobs(final Entity entity, final AxisAlignedBB axisAlignedBB) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        RenderGlobal.renderFilledBox(axisAlignedBB, 0.0f, 1.0f, 0.0f, 0.3f);
        RenderGlobal.drawSelectionBoundingBox(axisAlignedBB, 0.0f, 1.0f, 0.0f, 0.8f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
    
    public static void drawFilledCircle(final int n, final int n2, final float n3, final Color color) {
        final int n4 = 50;
        final double n5 = 6.283185307179586 / n4;
        GL11.glPushAttrib(8192);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        for (int i = 0; i < n4; ++i) {
            final float n6 = (float)(n3 * Math.sin(i * n5));
            final float n7 = (float)(n3 * Math.cos(i * n5));
            GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
            GL11.glVertex2f(n + n6, n2 + n7);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }
    
    public static void rectangleBordered(final double n, final double n2, final double n3, final double n4, final double n5, final int n6, final int n7) {
        drawRect(n + n5, n2 + n5, n3 - n5, n4 - n5, n6);
        drawRect(n + n5, n2, n3 - n5, n2 + n5, n7);
        drawRect(n, n2, n + n5, n4, n7);
        drawRect(n3 - n5, n2, n3, n4, n7);
        drawRect(n + n5, n4 - n5, n3 - n5, n4, n7);
    }
    
    public static void glColor(final int n) {
        GlStateManager.color((n >> 16 & 0xFF) / 255.0f, (n >> 8 & 0xFF) / 255.0f, (n & 0xFF) / 255.0f, (n >> 24 & 0xFF) / 255.0f);
    }
    
    public static void trace(final Minecraft minecraft, final Entity entity, final float n, final int n2) {
        if (minecraft.getRenderManager().renderViewEntity != null) {
            GL11.glDisable(2929);
            GL11.glDisable(2896);
            GL11.glLineWidth(2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask(false);
            GL11.glColor4d(0.0, (n2 == 1) ? 1.0 : 0.0, 1.0, 1.0);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glBegin(1);
            final RenderManager getRenderManager = minecraft.getRenderManager();
            final Vec3d rotateYaw = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(minecraft.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(minecraft.player.rotationYaw));
            GL11.glVertex3d(rotateYaw.x, minecraft.player.getEyeHeight() + rotateYaw.y, rotateYaw.z);
            GL11.glVertex3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * n - getRenderManager.viewerPosX, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * n - getRenderManager.viewerPosY + 0.25, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * n - getRenderManager.viewerPosZ);
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
        }
    }
    
    public static void drawBorderedRect(final double n, final double n2, final double n3, final double n4, final float n5, final int n6, final int n7) {
        Gui.drawRect((int)n, (int)n2, (int)n3, (int)n4, n7);
        final float n8 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n6 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n9, n10, n11, n8);
        GL11.glLineWidth(n5);
        GL11.glBegin(1);
        GL11.glVertex2d(n, n2);
        GL11.glVertex2d(n, n4);
        GL11.glVertex2d(n3, n4);
        GL11.glVertex2d(n3, n2);
        GL11.glVertex2d(n, n2);
        GL11.glVertex2d(n3, n2);
        GL11.glVertex2d(n, n4);
        GL11.glVertex2d(n3, n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
    }
    
    public static void FillLine_item(final Entity entity, final AxisAlignedBB axisAlignedBB) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        RenderGlobal.renderFilledBox(axisAlignedBB, 1.0f, 0.0f, 0.0f, 0.3f);
        RenderGlobal.drawSelectionBoundingBox(axisAlignedBB, 1.0f, 0.0f, 0.0f, 0.8f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
}
