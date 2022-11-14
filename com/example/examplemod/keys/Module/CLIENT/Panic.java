//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.CLIENT;

import org.lwjgl.opengl.*;
import com.example.examplemod.*;
import java.util.*;
import com.example.examplemod.keys.Module.*;

public class Panic extends Module
{
    public static boolean isPanic;
    
    @Override
    public void onEnable() {
        Panic.isPanic = true;
        Display.setTitle("Minecraft 1.12.2");
        for (final Module module : Client.modules) {
            if (module != this) {
                module.setToggled(false);
            }
        }
    }
    
    public Panic() {
        super("Panic", 210, Module$Category.CLIENT);
    }
    
    @Override
    public void onDisable() {
        Panic.isPanic = false;
        Display.setTitle(Client.name);
    }
    
    static {
        Panic.isPanic = false;
    }
}
