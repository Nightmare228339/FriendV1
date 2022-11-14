//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import net.minecraft.entity.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.*;
import com.example.examplemod.*;
import net.minecraft.entity.player.*;
import com.example.examplemod.Utils.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class TriggerBot extends Module
{
    Entity entity;
    
    public TriggerBot() {
        super("Triggerbot", 0, Module$Category.COMBAT);
        this.entity = this.mc.pointedEntity;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent$PlayerTickEvent tickEvent$PlayerTickEvent) {
        final RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
        ExampleMod.instance.settingsManager.getSettingByName(this.name, "OnlyCritical").getValBoolean();
        if (objectMouseOver != null && objectMouseOver.typeOfHit == RayTraceResult$Type.ENTITY) {
            this.entity = objectMouseOver.entityHit;
            if (this.entity instanceof EntityPlayer && this.entity != this.mc.player && !FriendManager.isFriend(this.entity.getUniqueID()) && Minecraft.getMinecraft().player.getCooledAttackStrength(0.0f) == 1.0f) {
                Minecraft.getMinecraft().playerController.attackEntity((EntityPlayer)Minecraft.getMinecraft().player, this.entity);
                Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                Minecraft.getMinecraft().player.resetCooldown();
            }
        }
    }
}
