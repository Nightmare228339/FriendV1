//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

import net.minecraft.client.*;

public class SpeedUtils
{
    public static Minecraft mc;
    
    static {
        SpeedUtils.mc = Minecraft.getMinecraft();
    }
    
    public static void speed(final double n) {
        final Minecraft getMinecraft = Minecraft.getMinecraft();
        double n2 = getMinecraft.player.movementInput.moveForward;
        final double n3 = getMinecraft.player.movementInput.moveStrafe;
        float rotationYaw = getMinecraft.player.rotationYaw;
        if (n2 == 0.0 && n3 == 0.0) {
            getMinecraft.player.motionX = 0.0;
            getMinecraft.player.motionZ = 0.0;
        }
        else if (n2 != 0.0) {
            if (n3 > 0.0) {
                rotationYaw += ((n2 > 0.0) ? -45 : 45);
            }
            else if (n3 < 0.0) {
                rotationYaw += ((n2 > 0.0) ? 45 : -45);
            }
            final double n4 = 0.0;
            if (n2 > 0.0) {
                n2 = 1.0;
            }
            else if (n2 < 0.0) {
                n2 = -1.0;
            }
            getMinecraft.player.motionX = n2 * n * Math.cos(Math.toRadians(rotationYaw + 90.0)) + n4 * n * Math.sin(Math.toRadians(rotationYaw + 90.0));
            getMinecraft.player.motionZ = n2 * n * Math.sin(Math.toRadians(rotationYaw + 90.0)) + n4 * n * Math.cos(Math.toRadians(rotationYaw + 90.0));
        }
    }
    
    public static double getDirection() {
        float rotationYaw = SpeedUtils.mc.player.rotationYaw;
        if (SpeedUtils.mc.player.moveForward < 0.0f) {
            rotationYaw += 180.0f;
        }
        float n = 1.0f;
        if (SpeedUtils.mc.player.moveForward < 0.0f) {
            n = -0.5f;
        }
        else if (SpeedUtils.mc.player.moveForward > 0.0f) {
            n = 0.5f;
        }
        if (SpeedUtils.mc.player.moveStrafing > 0.0f) {
            rotationYaw -= 90.0f * n;
        }
        if (SpeedUtils.mc.player.moveStrafing < 0.0f) {
            rotationYaw += 90.0f * n;
        }
        return Math.toRadians(rotationYaw);
    }
}
