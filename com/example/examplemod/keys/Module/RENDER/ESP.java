//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraft.util.math.*;
import net.minecraftforge.client.event.*;
import com.example.examplemod.*;
import net.minecraft.entity.player.*;
import com.example.examplemod.Utils.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.*;

public class ESP extends Module
{
    AxisAlignedBB boxx;
    AxisAlignedBB box;
    private static List glowed;
    
    static {
        ESP.glowed = new ArrayList();
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent renderWorldLastEvent) {
        final String valString = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Player").getValString();
        final String valString2 = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Mob").getValString();
        final boolean valBoolean = ExampleMod.instance.settingsManager.getSettingByName(this.name, "ItemBox").getValBoolean();
        if (Objects.equals(valString, "2D")) {
            if (this.toggled) {
                for (final EntityPlayer entityPlayer : this.mc.world.playerEntities) {
                    if (entityPlayer instanceof EntityPlayer && entityPlayer != this.mc.player) {
                        RenderUtils.drawESP((Entity)entityPlayer, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f);
                        RenderUtils.getPlayerHealth((Entity)entityPlayer, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                }
            }
        }
        else if (Objects.equals(valString, "NoneCode")) {
            if (this.toggled) {
                for (final EntityPlayer entityPlayer2 : this.mc.world.playerEntities) {
                    if (entityPlayer2 instanceof EntityPlayer && entityPlayer2 != this.mc.player) {
                        RenderUtils.NoneCode((Entity)entityPlayer2);
                    }
                }
            }
        }
        else if (Objects.equals(valString, "Box")) {
            for (final Entity entity : this.mc.world.playerEntities) {
                if (entity != this.mc.player && entity != null) {
                    RenderUtils.FillLine(entity, this.box = new AxisAlignedBB(entity.getEntityBoundingBox().minX - 0.05 - entity.posX + ((float)((float)entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity.getEntityBoundingBox().minY - entity.posY + ((float)((float)entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity.getEntityBoundingBox().minZ - 0.05 - entity.posZ + ((float)((float)entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity.getEntityBoundingBox().maxX + 0.05 - entity.posX + ((float)((float)entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity.getEntityBoundingBox().maxY + 0.1 - entity.posY + ((float)((float)entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity.getEntityBoundingBox().maxZ + 0.05 - entity.posZ + ((float)((float)entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
        }
        else if (Objects.equals(valString, "None")) {}
        if (Objects.equals(valString2, "2D")) {
            if (this.toggled) {
                for (final Entity entity2 : this.mc.world.loadedEntityList) {
                    if (entity2 instanceof EntityWolf) {
                        RenderUtils.drawESPMobe(entity2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                    if (entity2 instanceof EntityHorse) {
                        RenderUtils.drawESPMobe(entity2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                    if (entity2 instanceof EntityZombie) {
                        RenderUtils.drawESPMobe(entity2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                    if (entity2 instanceof EntityPig) {
                        RenderUtils.drawESPMobe(entity2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                    if (entity2 instanceof EntityPolarBear) {
                        RenderUtils.drawESPMobe(entity2, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                    }
                }
            }
        }
        else if (Objects.equals(valString2, "Box")) {
            for (final Entity entity3 : this.mc.world.loadedEntityList) {
                if (entity3 instanceof EntityPig) {
                    RenderUtils.FillLine_mobs(entity3, this.box = new AxisAlignedBB(entity3.getEntityBoundingBox().minX - 0.05 - entity3.posX + ((float)((float)entity3.lastTickPosX + (entity3.posX - entity3.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity3.getEntityBoundingBox().minY - entity3.posY + ((float)((float)entity3.lastTickPosY + (entity3.posY - entity3.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity3.getEntityBoundingBox().minZ - 0.05 - entity3.posZ + ((float)((float)entity3.lastTickPosZ + (entity3.posZ - entity3.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity3.getEntityBoundingBox().maxX + 0.05 - entity3.posX + ((float)((float)entity3.lastTickPosX + (entity3.posX - entity3.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity3.getEntityBoundingBox().maxY + 0.1 - entity3.posY + ((float)((float)entity3.lastTickPosY + (entity3.posY - entity3.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity3.getEntityBoundingBox().maxZ + 0.05 - entity3.posZ + ((float)((float)entity3.lastTickPosZ + (entity3.posZ - entity3.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
            for (final Entity entity4 : this.mc.world.loadedEntityList) {
                if (entity4 instanceof EntityWolf) {
                    RenderUtils.FillLine_mobs(entity4, this.box = new AxisAlignedBB(entity4.getEntityBoundingBox().minX - 0.05 - entity4.posX + ((float)((float)entity4.lastTickPosX + (entity4.posX - entity4.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity4.getEntityBoundingBox().minY - entity4.posY + ((float)((float)entity4.lastTickPosY + (entity4.posY - entity4.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity4.getEntityBoundingBox().minZ - 0.05 - entity4.posZ + ((float)((float)entity4.lastTickPosZ + (entity4.posZ - entity4.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity4.getEntityBoundingBox().maxX + 0.05 - entity4.posX + ((float)((float)entity4.lastTickPosX + (entity4.posX - entity4.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity4.getEntityBoundingBox().maxY + 0.1 - entity4.posY + ((float)((float)entity4.lastTickPosY + (entity4.posY - entity4.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity4.getEntityBoundingBox().maxZ + 0.05 - entity4.posZ + ((float)((float)entity4.lastTickPosZ + (entity4.posZ - entity4.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
            for (final Entity entity5 : this.mc.world.loadedEntityList) {
                if (entity5 instanceof EntityZombie) {
                    RenderUtils.FillLine_mobs(entity5, this.box = new AxisAlignedBB(entity5.getEntityBoundingBox().minX - 0.05 - entity5.posX + ((float)((float)entity5.lastTickPosX + (entity5.posX - entity5.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity5.getEntityBoundingBox().minY - entity5.posY + ((float)((float)entity5.lastTickPosY + (entity5.posY - entity5.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity5.getEntityBoundingBox().minZ - 0.05 - entity5.posZ + ((float)((float)entity5.lastTickPosZ + (entity5.posZ - entity5.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity5.getEntityBoundingBox().maxX + 0.05 - entity5.posX + ((float)((float)entity5.lastTickPosX + (entity5.posX - entity5.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity5.getEntityBoundingBox().maxY + 0.1 - entity5.posY + ((float)((float)entity5.lastTickPosY + (entity5.posY - entity5.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity5.getEntityBoundingBox().maxZ + 0.05 - entity5.posZ + ((float)((float)entity5.lastTickPosZ + (entity5.posZ - entity5.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
            for (final Entity entity6 : this.mc.world.loadedEntityList) {
                if (entity6 instanceof EntityPolarBear) {
                    RenderUtils.FillLine_mobs(entity6, this.boxx = new AxisAlignedBB(entity6.getEntityBoundingBox().minX - 0.05 - entity6.posX + ((float)((float)entity6.lastTickPosX + (entity6.posX - entity6.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity6.getEntityBoundingBox().minY - entity6.posY + ((float)((float)entity6.lastTickPosY + (entity6.posY - entity6.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity6.getEntityBoundingBox().minZ - 0.05 - entity6.posZ + ((float)((float)entity6.lastTickPosZ + (entity6.posZ - entity6.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity6.getEntityBoundingBox().maxX + 0.05 - entity6.posX + ((float)((float)entity6.lastTickPosX + (entity6.posX - entity6.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity6.getEntityBoundingBox().maxY + 0.1 - entity6.posY + ((float)((float)entity6.lastTickPosY + (entity6.posY - entity6.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity6.getEntityBoundingBox().maxZ + 0.05 - entity6.posZ + ((float)((float)entity6.lastTickPosZ + (entity6.posZ - entity6.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
            for (final Entity entity7 : this.mc.world.loadedEntityList) {
                if (entity7 instanceof EntityHorse) {
                    RenderUtils.FillLine_mobs(entity7, this.boxx = new AxisAlignedBB(entity7.getEntityBoundingBox().minX - 0.05 - entity7.posX + ((float)((float)entity7.lastTickPosX + (entity7.posX - entity7.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity7.getEntityBoundingBox().minY - entity7.posY + ((float)((float)entity7.lastTickPosY + (entity7.posY - entity7.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity7.getEntityBoundingBox().minZ - 0.05 - entity7.posZ + ((float)((float)entity7.lastTickPosZ + (entity7.posZ - entity7.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity7.getEntityBoundingBox().maxX + 0.05 - entity7.posX + ((float)((float)entity7.lastTickPosX + (entity7.posX - entity7.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity7.getEntityBoundingBox().maxY + 0.1 - entity7.posY + ((float)((float)entity7.lastTickPosY + (entity7.posY - entity7.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity7.getEntityBoundingBox().maxZ + 0.05 - entity7.posZ + ((float)((float)entity7.lastTickPosZ + (entity7.posZ - entity7.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
        }
        else if (Objects.equals(valString, "None")) {}
        if (valBoolean) {
            for (final Entity entity8 : this.mc.world.loadedEntityList) {
                if (entity8 instanceof EntityItem) {
                    RenderUtils.FillLine_item(entity8, this.boxx = new AxisAlignedBB(entity8.getEntityBoundingBox().minX - 0.05 - entity8.posX + ((float)((float)entity8.lastTickPosX + (entity8.posX - entity8.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity8.getEntityBoundingBox().minY - entity8.posY + ((float)((float)entity8.lastTickPosY + (entity8.posY - entity8.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity8.getEntityBoundingBox().minZ - 0.05 - entity8.posZ + ((float)((float)entity8.lastTickPosZ + (entity8.posZ - entity8.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity8.getEntityBoundingBox().maxX + 0.05 - entity8.posX + ((float)((float)entity8.lastTickPosX + (entity8.posX - entity8.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity8.getEntityBoundingBox().maxY + 0.1 - entity8.posY + ((float)((float)entity8.lastTickPosY + (entity8.posY - entity8.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity8.getEntityBoundingBox().maxZ + 0.05 - entity8.posZ + ((float)((float)entity8.lastTickPosZ + (entity8.posZ - entity8.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
                }
            }
        }
    }
    
    public ESP() {
        super("ESP", 0, Module$Category.RENDER);
        this.box = null;
        final ArrayList<String> list = new ArrayList<String>();
        final ArrayList<String> list2 = new ArrayList<String>();
        ExampleMod.instance.settingsManager.rSetting(new Setting("ItemBox", (Module)this, false));
        list.add("None");
        list.add("2D");
        list.add("NoneCode");
        list.add("Box");
        list2.add("None");
        list2.add("2D");
        list2.add("Box");
        ExampleMod.instance.settingsManager.rSetting(new Setting("Player", (Module)this, (ArrayList)list, "Player"));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Mob", (Module)this, (ArrayList)list2, "Mob"));
    }
    
    public void onDisable() {
        final Iterator<Entity> iterator = ESP.glowed.iterator();
        while (iterator.hasNext()) {
            iterator.next().setGlowing(false);
        }
        ESP.glowed.clear();
        super.onDisable();
    }
}
