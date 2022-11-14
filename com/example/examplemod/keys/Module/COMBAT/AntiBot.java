//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import com.example.examplemod.Utils.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class AntiBot extends Module
{
    public AntiBot() {
        super("AntiBot", 0, Module$Category.COMBAT);
    }
    
    @SubscribeEvent
    public void onUpdate(final RenderWorldLastEvent renderWorldLastEvent) {
        if (this.toggled) {
            final Iterator iterator = this.mc.world.playerEntities.iterator();
            while (true) {
                Label_0303: {
                    if (!iterator.hasNext()) {
                        break Label_0303;
                    }
                    final EntityPlayer entityPlayer = iterator.next();
                    if (entityPlayer.isInvisible() && entityPlayer != this.mc.player && !FriendManager.isFriend(entityPlayer.getUniqueID())) {
                        this.mc.world.removeEntity((Entity)entityPlayer);
                        this.mc.world.spawnEntity((Entity)new EntityLightningBolt((World)this.mc.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));
                    }
                    if (entityPlayer.noClip && entityPlayer.getDistance((Entity)this.mc.player) <= 7.0f && entityPlayer != this.mc.player && !FriendManager.isFriend(entityPlayer.getUniqueID())) {
                        this.mc.world.removeEntity((Entity)entityPlayer);
                        this.mc.world.spawnEntity((Entity)new EntityLightningBolt((World)this.mc.world, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, true));
                    }
                    Label_0300: {
                        if (this.mc.getConnection().getPlayerInfo(entityPlayer.getName()) != null || entityPlayer == this.mc.player || FriendManager.isFriend(entityPlayer.getUniqueID())) {
                            break Label_0300;
                        }
                        this.mc.world.removeEntity((Entity)entityPlayer);
                        final WorldClient world = this.mc.world;
                        final WorldClient world2 = this.mc.world;
                        final double posX = entityPlayer.posX;
                        final double posY = entityPlayer.posY;
                        final double posZ = entityPlayer.posZ;
                        final boolean b = true;
                        try {
                            world.spawnEntity((Entity)new EntityLightningBolt((World)world2, posX, posY, posZ, b));
                            continue;
                        }
                        catch (Exception ex) {}
                    }
                }
                break;
            }
        }
    }
}
