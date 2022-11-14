//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import com.example.examplemod.Utils.*;
import net.minecraft.item.*;
import java.util.function.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ArmorHUD extends Module
{
    private int armourCompress;
    private int offHandHeldItemCount;
    private int armourSpacing;
    
    int getItemsOffHand(final Item item) {
        return Wrapper.INSTANCE.inventory().offHandInventory.stream().filter(ArmorHUD::lambda$getItemsOffHand$0).mapToInt(ItemStack::getCount).sum();
    }
    
    private static boolean lambda$getItemsOffHand$0(final Item item, final ItemStack itemStack) {
        return itemStack.getItem() == item;
    }
    
    public ArmorHUD() {
        super("ArmorHUD", 0, Module$Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent$Text renderGameOverlayEvent$Text) {
        final ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.mc());
        final RenderItem getRenderItem = Wrapper.INSTANCE.mc().getRenderItem();
        GlStateManager.enableTexture2D();
        final int n = scaledResolution.getScaledWidth() / 2;
        int n2 = 0;
        final int n3 = scaledResolution.getScaledHeight() - 55 - (Wrapper.INSTANCE.player().isInWater() ? 10 : 0);
        for (final ItemStack itemStack : Wrapper.INSTANCE.inventory().armorInventory) {
            ++n2;
            if (itemStack.isEmpty()) {
                continue;
            }
            final int n4 = n - 90 + (9 - n2) * this.armourSpacing + this.armourCompress;
            GlStateManager.enableDepth();
            getRenderItem.zLevel = 200.0f;
            getRenderItem.renderItemAndEffectIntoGUI(itemStack, n4, n3);
            getRenderItem.renderItemOverlayIntoGUI(Wrapper.INSTANCE.fontRenderer(), itemStack, n4, n3, "");
            getRenderItem.zLevel = 0.0f;
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            final String s = (itemStack.getCount() > 1) ? (itemStack.getCount() + "") : "";
            Wrapper.INSTANCE.fontRenderer().drawStringWithShadow(s, (float)(n4 + 19 - 2 - Wrapper.INSTANCE.fontRenderer().getStringWidth(s)), (float)(n3 - 30), 16777215);
            final int n5 = 100 - (int)((1.0f - (itemStack.getMaxDamage() - (float)itemStack.getItemDamage()) / itemStack.getMaxDamage()) * 100.0f);
            Wrapper.INSTANCE.fontRenderer().drawStringWithShadow(n5 + "", (float)(n4 + 8 - Wrapper.INSTANCE.fontRenderer().getStringWidth(n5 + "") / 2), (float)(n3 - 11), 16777215);
        }
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        this.armourCompress = 2;
        this.armourSpacing = 20;
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
    }
}
