//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.network.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.gui.*;

public class Wrapper
{
    public static volatile Wrapper INSTANCE;
    
    public InventoryPlayer inventory() {
        return this.player().inventory;
    }
    
    static {
        Wrapper.INSTANCE = new Wrapper();
    }
    
    public EntityPlayerSP player() {
        return Wrapper.INSTANCE.mc().player;
    }
    
    public WorldClient world() {
        return Wrapper.INSTANCE.mc().world;
    }
    
    public void sendPacket(final Packet packet) {
        this.player().connection.sendPacket(packet);
    }
    
    public Minecraft mc() {
        return Minecraft.getMinecraft();
    }
    
    public GameSettings mcSettings() {
        return Wrapper.INSTANCE.mc().gameSettings;
    }
    
    public FontRenderer fontRenderer() {
        return Wrapper.INSTANCE.mc().fontRenderer;
    }
}
