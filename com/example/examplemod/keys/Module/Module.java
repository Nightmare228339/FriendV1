//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module;

import net.minecraft.client.*;
import net.minecraftforge.common.*;

public class Module
{
    public boolean toggled;
    public int keyCode;
    public String name;
    public Module$Category category;
    public Minecraft mc;
    
    public boolean isEnabled() {
        return this.toggled;
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
    
    public Module(final String name, final int keyCode, final Module$Category category) {
        this.mc = Minecraft.getMinecraft();
        this.name = name;
        this.keyCode = keyCode;
        this.category = category;
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void setKey(final int keyCode) {
        this.keyCode = keyCode;
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getKey() {
        return this.keyCode;
    }
    
    public Module$Category getCategory() {
        return this.category;
    }
}
