//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraft.client.entity.*;
import com.example.examplemod.keys.Module.CLIENT.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import com.example.examplemod.keys.Module.*;

public class FakePlayer extends Module
{
    EntityOtherPlayerMP fakePlayer;
    
    public void onDisable() {
        if (!Panic.isPanic) {
            this.mc.world.removeEntityFromWorld(this.fakePlayer.getEntityId());
        }
    }
    
    public void onEnable() {
        (this.fakePlayer = new EntityOtherPlayerMP((World)this.mc.world, this.mc.player.getGameProfile())).setEntityId(-1882);
        this.fakePlayer.copyLocationAndAnglesFrom((Entity)this.mc.player);
        this.fakePlayer.rotationYawHead = this.mc.player.rotationYawHead;
        this.mc.world.addEntityToWorld(this.fakePlayer.getEntityId(), (Entity)this.fakePlayer);
    }
    
    public FakePlayer() {
        super("FakePlayer", 0, Module$Category.RENDER);
    }
}
