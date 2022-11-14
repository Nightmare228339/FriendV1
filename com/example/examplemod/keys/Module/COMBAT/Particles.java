//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import com.example.examplemod.keys.Module.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Particles extends Module
{
    public Particles() {
        super("Particles", 0, Module$Category.COMBAT);
    }
    
    @SubscribeEvent
    public void onAttack(final AttackEntityEvent attackEntityEvent) {
        for (int i = 12; i >= 0; --i) {
            this.mc.player.onCriticalHit(attackEntityEvent.getTarget());
        }
    }
}
