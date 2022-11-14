//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

import net.minecraft.client.*;
import net.minecraft.util.text.*;
import com.example.examplemod.*;

public class ChatUtils
{
    private static final String prefix;
    
    public static void sendMessage(final String str) {
        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(ChatUtils.prefix + str));
    }
    
    static {
        prefix = "[" + Client.cName + " ] ";
    }
}
