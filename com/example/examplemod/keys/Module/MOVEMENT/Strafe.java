//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.MOVEMENT;

import net.minecraft.client.*;
import com.example.examplemod.Utils.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Strafe extends Module
{
    public static Minecraft mc;
    
    public static float getSpeed() {
        return (float)Math.sqrt(Strafe.mc.player.motionX * Strafe.mc.player.motionX + Strafe.mc.player.motionZ * Strafe.mc.player.motionZ);
    }
    
    public static void strafe(final float n) {
        if (!isMoving()) {
            return;
        }
        final double direction = SpeedUtils.getDirection();
        Strafe.mc.player.motionX = -Math.sin(direction) * n;
        Strafe.mc.player.motionZ = Math.cos(direction) * n;
    }
    
    public Strafe() {
        super("Strafe", 0, Module$Category.MOVEMENT);
    }
    
    static {
        Strafe.mc = Minecraft.getMinecraft();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent$PlayerTickEvent tickEvent$PlayerTickEvent) {
        strafe();
    }
    
    public static void strafe() {
        strafe(getSpeed());
    }
    
    public static boolean isMoving() {
        return Strafe.mc.player != null && (Strafe.mc.player.movementInput.moveForward != 0.0f || Strafe.mc.player.movementInput.moveStrafe != 0.0f);
    }
}
