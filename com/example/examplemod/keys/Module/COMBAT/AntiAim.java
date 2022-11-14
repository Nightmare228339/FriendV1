//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import scala.util.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;

public class AntiAim extends Module
{
    public static final Random r;
    
    public static int getRandomInRange(final int n, final int n2) {
        return (int)(n2 + (n - n2) * AntiAim.r.nextDouble());
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent$ClientTickEvent tickEvent$ClientTickEvent) {
        final float n = this.mc.player.rotationYaw + getRandomInRange(25, -25);
        this.mc.player.rotationYawHead = n;
        this.mc.player.renderYawOffset = n;
    }
    
    static {
        r = new Random();
    }
    
    public AntiAim() {
        super("AntiAim", 0, Module$Category.COMBAT);
    }
}
