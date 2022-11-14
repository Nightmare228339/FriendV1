//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import com.example.examplemod.keys.Module.*;
import java.util.*;
import net.minecraft.potion.*;

public class FullBright extends Module
{
    public FullBright() {
        super("FullBright", 0, Module$Category.RENDER);
    }
    
    public void onDisable() {
        this.mc.player.removePotionEffect((Potion)Objects.requireNonNull(Potion.getPotionById(16)));
    }
    
    public void onEnable() {
        if (this.toggled) {
            this.mc.player.addPotionEffect(new PotionEffect((Potion)Objects.requireNonNull(Potion.getPotionById(16)), 999999, 1));
        }
    }
}
