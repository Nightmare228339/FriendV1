//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.PLAYER;

import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.client.entity.*;
import com.example.examplemod.keys.Module.*;

public class BlockReach extends Module
{
    public void onEnable() {
        final EntityPlayerSP player = this.mc.player;
        ((EntityPlayer)player).getEntityAttribute(EntityPlayer.REACH_DISTANCE);
        ((EntityPlayer)player).getEntityAttribute(EntityPlayer.REACH_DISTANCE).applyModifier(new AttributeModifier(((EntityPlayer)player).getUniqueID(), "custom_reach", 0.5, 1));
    }
    
    public BlockReach() {
        super("BlockReach", 0, Module$Category.PLAYER);
    }
    
    public void onDisable() {
        this.mc.player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).removeModifier(this.mc.player.getUniqueID());
    }
}
