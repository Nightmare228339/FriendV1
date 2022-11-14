//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.client.multiplayer.*;

public class BlockObject extends Module
{
    public static BlockPos Block;
    public static Entity entity;
    AxisAlignedBB box;
    
    public static void FillLine(final Entity entity, final AxisAlignedBB axisAlignedBB) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        RenderGlobal.drawSelectionBoundingBox(axisAlignedBB, 0.25882354f, 0.9607843f, 0.85490197f, 1.0f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
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
        RenderGlobal.renderFilledBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0), 0.25882354f, 0.9607843f, 0.85490197f, 0.39215687f);
        RenderGlobal.drawBoundingBox(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0, 0.25882354f, 0.9607843f, 0.85490197f, 1.0f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public BlockObject() {
        super("BlockObject", 0, Module$Category.RENDER);
        this.box = null;
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent renderWorldLastEvent) {
        final RayTraceResult objectMouseOver = this.mc.objectMouseOver;
        while (true) {
            if (objectMouseOver != null) {
                BlockObject.Block = objectMouseOver.getBlockPos();
                final Block block = getBlock(BlockObject.Block);
                try {
                    if (block != Blocks.AIR) {
                        blockESP(BlockObject.Block);
                    }
                }
                catch (Exception ex) {
                    final RayTraceResult objectMouseOver2 = Minecraft.getMinecraft().objectMouseOver;
                    if (objectMouseOver2 != null) {
                        BlockObject.entity = objectMouseOver2.entityHit;
                        this.box = new AxisAlignedBB(BlockObject.entity.getEntityBoundingBox().minX - 0.05 - BlockObject.entity.posX + ((float)((float)BlockObject.entity.lastTickPosX + (BlockObject.entity.posX - BlockObject.entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), BlockObject.entity.getEntityBoundingBox().minY - BlockObject.entity.posY + ((float)((float)BlockObject.entity.lastTickPosY + (BlockObject.entity.posY - BlockObject.entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), BlockObject.entity.getEntityBoundingBox().minZ - 0.05 - BlockObject.entity.posZ + ((float)((float)BlockObject.entity.lastTickPosZ + (BlockObject.entity.posZ - BlockObject.entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), BlockObject.entity.getEntityBoundingBox().maxX + 0.05 - BlockObject.entity.posX + ((float)((float)BlockObject.entity.lastTickPosX + (BlockObject.entity.posX - BlockObject.entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), BlockObject.entity.getEntityBoundingBox().maxY + 0.1 - BlockObject.entity.posY + ((float)((float)BlockObject.entity.lastTickPosY + (BlockObject.entity.posY - BlockObject.entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), BlockObject.entity.getEntityBoundingBox().maxZ + 0.05 - BlockObject.entity.posZ + ((float)((float)BlockObject.entity.lastTickPosZ + (BlockObject.entity.posZ - BlockObject.entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ));
                        FillLine(BlockObject.entity, this.box);
                    }
                }
                return;
            }
            continue;
        }
    }
    
    public static Block getBlock(final BlockPos blockPos) {
        final WorldClient world = Minecraft.getMinecraft().world;
        try {
            return world.getBlockState(blockPos).getBlock();
        }
        catch (NullPointerException ex) {
            return null;
        }
    }
}
