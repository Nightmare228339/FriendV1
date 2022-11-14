//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraftforge.client.event.*;
import com.example.examplemod.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.*;

public class ViewModel extends Module
{
    @SubscribeEvent
    public void onRender(final RenderSpecificHandEvent renderSpecificHandEvent) {
        GL11.glTranslated(ExampleMod.instance.settingsManager.getSettingByName(this.name, "X").getValDouble(), ExampleMod.instance.settingsManager.getSettingByName(this.name, "Y").getValDouble(), -ExampleMod.instance.settingsManager.getSettingByName(this.name, "Z").getValDouble());
    }
    
    public ViewModel() {
        super("ViewModel", 0, Module$Category.RENDER);
        ExampleMod.instance.settingsManager.rSetting(new Setting("X", (Module)this, 4.2, -100.0, 100.0, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Y", (Module)this, 4.2, -100.0, 100.0, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Z", (Module)this, 4.2, -100.0, 100.0, false));
    }
}
