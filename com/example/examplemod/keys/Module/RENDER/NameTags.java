//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;

public class NameTags extends Module
{
    @SubscribeEvent
    public void onRender(final RenderLivingEvent$Specials$Pre renderLivingEvent$Specials$Pre) {
        final EntityLivingBase entity = renderLivingEvent$Specials$Pre.getEntity();
        if (!(entity instanceof EntityPlayer) || entity == this.mc.player) {
            return;
        }
        if (entity.isDead || entity.getHealth() < 0.0f || entity.isInvisible()) {
            return;
        }
        GL11.glPushMatrix();
        final Vec3d vec3d = new Vec3d(renderLivingEvent$Specials$Pre.getX(), renderLivingEvent$Specials$Pre.getY() + entity.height / 1.5, renderLivingEvent$Specials$Pre.getZ());
        GL11.glTranslated(vec3d.x, vec3d.y + 1.0, vec3d.z);
        final double max = Math.max(1.0, vec3d.distanceTo(new Vec3d(0.0, 0.0, 0.0)) / 6.0);
        GL11.glScaled(max, max, max);
        EntityRenderer.drawNameplate(this.mc.fontRenderer, entity.getDisplayName().getFormattedText() + "  " + (int)Math.ceil(entity.getHealth()) * 5 + "% " + (int)Math.ceil(entity.getDistance((Entity)this.mc.player)), 0.0f, 0.0f, 0.0f, 0, this.mc.getRenderManager().playerViewY, this.mc.getRenderManager().playerViewX, this.mc.gameSettings.thirdPersonView == 2, false);
        GL11.glPopMatrix();
        renderLivingEvent$Specials$Pre.setCanceled(true);
    }
    
    public NameTags() {
        super("NameTags", 0, Module$Category.RENDER);
    }
}
