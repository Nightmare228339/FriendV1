//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import java.awt.*;
import com.example.examplemod.Utils.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.util.math.*;

public class TargetHUD extends Module
{
    private double enemyHP;
    private Entity entity;
    private EntityPlayer entityPlayer;
    private double enemyDistance;
    private double healthBarWidth;
    private boolean show;
    private String enemyNickname;
    
    public TargetHUD() {
        super("TargetHUD", 0, Module$Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent renderGameOverlayEvent) {
        final RenderGameOverlayEvent$ElementType type = renderGameOverlayEvent.getType();
        renderGameOverlayEvent.getType();
        if (!type.equals((Object)RenderGameOverlayEvent$ElementType.TEXT)) {
            return;
        }
        if (this.show && this.mc.world != null && this.mc.player != null) {
            final double n = 60.0;
            final double n2 = -250.0;
            final float n3 = (float)new ScaledResolution(this.mc).getScaledWidth();
            final float n4 = (float)(n3 / 2.0f - n);
            final float n5 = (float)(n3 / 2.0f + n2);
            final double n6 = 97.0 * MathHelper.clamp((double)(Math.round(this.enemyHP) / 20.0f), 0.0, 1.0);
            final String value = String.valueOf(Math.round(this.enemyHP) * 5L);
            RenderUtils.drawBorderedRect((int)(n4 + 125.5), (int)(n5 - 9.5), (int)(n4 + 265.0f), (int)(n5 + 30.5f), 2.0f, new Color(16777215).getRGB(), new Color(16087529).getRGB());
            Gui.drawRect((int)(n4 + 166.0f), (int)(n5 + 6.0f), (int)(n4 + 263.0f), (int)(n5 + 15.0f), new Color(40, 40, 40, 255).getRGB());
            Gui.drawRect((int)(n4 + 166.0f), (int)(n5 + 6.0f), (int)(n4 + 166.0f + this.healthBarWidth), (int)(n5 + 15.0f), new Color(38143).getRGB());
            Gui.drawRect((int)(n4 + 166.0f), (int)(n5 + 6.0f), (int)(n4 + 166.0f + n6), (int)(n5 + 15.0f), new Color(14788199).getRGB());
            this.mc.fontRenderer.drawStringWithShadow(value, n4 + 128.0f + 46.0f - this.mc.fontRenderer.getStringWidth(value) / 2.0f, n5 + 19.5f, -1);
            this.mc.fontRenderer.drawStringWithShadow("d", n4 + 128.0f + 46.0f + this.mc.fontRenderer.getStringWidth(value), n5 + 19.5f, new Color(16711680).getRGB());
            this.mc.fontRenderer.drawStringWithShadow(this.entity.getName(), n4 + 167.0f, n5 - 5.0f, -1);
            final ResourceLocation getLocationSkin = Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.entity.getUniqueID()).getLocationSkin();
            final int n7 = (int)(n4 + 127.0f);
            final int n8 = (int)(n5 - 8.0f);
            try {
                this.drawHead(getLocationSkin, n7, n8);
            }
            catch (Exception ex) {}
        }
    }
    
    public void drawHead(final ResourceLocation resourceLocation, final int n, final int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        Gui.drawScaledCustomSizeModalRect(n, n2, 8.0f, 8.0f, 8, 8, 37, 37, 64.0f, 64.0f);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent$PlayerTickEvent tickEvent$PlayerTickEvent) {
        final RayTraceResult objectMouseOver = this.mc.objectMouseOver;
        if (objectMouseOver != null) {
            if (objectMouseOver.typeOfHit == RayTraceResult$Type.ENTITY) {
                this.entity = objectMouseOver.entityHit;
                if (this.entity instanceof EntityPlayer) {
                    this.entityPlayer = (EntityPlayer)this.entity;
                    this.enemyNickname = this.entityPlayer.getName();
                    this.enemyHP = this.entityPlayer.getHealth();
                    this.enemyDistance = this.entityPlayer.getDistance((Entity)this.mc.player);
                    this.show = true;
                }
                else {
                    this.show = false;
                }
            }
            else {
                this.show = false;
            }
        }
    }
}
