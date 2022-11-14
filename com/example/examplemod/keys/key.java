//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys;

import net.minecraftforge.fml.common.gameevent.*;
import org.lwjgl.input.*;
import com.example.examplemod.keys.Module.CLIENT.*;
import net.minecraft.client.*;
import com.example.examplemod.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class key
{
    @SubscribeEvent
    public void onKeyInput(final InputEvent$KeyInputEvent inputEvent$KeyInputEvent) {
        if (Keyboard.isKeyDown(Keyboard.getEventKey()) && Keyboard.getEventKey() != 0) {
            Client.keyPress(Keyboard.getEventKey());
            if (Keyboard.getEventKey() == 54 && !Panic.isPanic) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)ExampleMod.instance.clickGui);
            }
        }
    }
}
