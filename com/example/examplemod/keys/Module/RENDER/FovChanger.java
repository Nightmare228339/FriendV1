//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import com.example.examplemod.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.*;

public class FovChanger extends Module
{
    public void onDisable() {
        this.mc.gameSettings.fovSetting = 100.0f;
    }
    
    public void onEnable() {
        final double valDouble = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Range").getValDouble();
        if (this.toggled) {
            this.mc.gameSettings.fovSetting = (float)valDouble;
        }
    }
    
    public FovChanger() {
        super("Fov", 0, Module$Category.RENDER);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Range", (Module)this, 4.2, 1.0, 100.0, false));
    }
}
