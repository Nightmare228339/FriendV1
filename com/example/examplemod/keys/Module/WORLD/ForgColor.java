//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.WORLD;

import net.minecraftforge.client.event.*;
import java.awt.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;

public class ForgColor extends Module
{
    @SubscribeEvent
    public void fog(final EntityViewRenderEvent$FogColors entityViewRenderEvent$FogColors) {
        entityViewRenderEvent$FogColors.setGreen((float)new Color(21).getGreen());
        entityViewRenderEvent$FogColors.setRed(0.0f);
        entityViewRenderEvent$FogColors.setBlue(0.0f);
    }
    
    public ForgColor() {
        super("FogColor", 0, Module$Category.WORLD);
    }
}
