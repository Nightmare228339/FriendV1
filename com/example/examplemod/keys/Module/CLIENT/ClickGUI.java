//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.CLIENT;

import com.example.examplemod.keys.Module.*;
import com.example.examplemod.*;
import yea.clickgui.*;

public class ClickGUI extends Module
{
    public ClickGUI() {
        super("ClickGUI", 0, Module$Category.CLIENT);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Rainbow", (Module)this, false));
    }
}
