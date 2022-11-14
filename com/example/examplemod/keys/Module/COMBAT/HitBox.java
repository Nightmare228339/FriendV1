//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import com.example.examplemod.keys.Module.*;
import com.example.examplemod.*;
import yea.clickgui.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import com.example.examplemod.Utils.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class HitBox extends Module
{
    public HitBox() {
        super("HitBox", 0, Module$Category.COMBAT);
        ExampleMod.instance.settingsManager.rSetting(new Setting("Size", (Module)this, 1.0, 0.1, 4.0, false));
    }
    
    @SubscribeEvent
    public void onUpdate(final RenderWorldLastEvent renderWorldLastEvent) {
        if (this.toggled) {
            final float n = (float)ExampleMod.instance.settingsManager.getSettingByName(this.name, "Size").getValDouble();
            for (final EntityPlayer entityPlayer : this.mc.world.playerEntities) {
                if (entityPlayer != null && entityPlayer != this.mc.player) {
                    entityPlayer.setEntityBoundingBox(new AxisAlignedBB(entityPlayer.posX - n, entityPlayer.getEntityBoundingBox().minY, entityPlayer.posZ - n, entityPlayer.posX + n, entityPlayer.getEntityBoundingBox().maxY, entityPlayer.posZ + n));
                }
            }
        }
        else {
            for (final EntityPlayer entityPlayer2 : this.mc.world.playerEntities) {
                if (entityPlayer2 != null && entityPlayer2 != this.mc.player && !FriendManager.isFriend(entityPlayer2.getUniqueID())) {
                    entityPlayer2.setEntityBoundingBox(new AxisAlignedBB(entityPlayer2.posX - 0.30000001192092896, entityPlayer2.getEntityBoundingBox().minY, entityPlayer2.posZ - 0.30000001192092896, entityPlayer2.posX + 0.30000001192092896, entityPlayer2.getEntityBoundingBox().maxY, entityPlayer2.posZ + 0.30000001192092896));
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
    }
}
