//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import net.minecraftforge.client.event.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.Utils.*;
import com.example.examplemod.keys.Module.*;

public class WallHack extends Module
{
    @SubscribeEvent
    public void onRenderWorldLast(final RenderWorldLastEvent renderWorldLastEvent) {
        GlStateManager.clear(256);
        RenderHelper.enableStandardItemLighting();
        final Iterator<Entity> iterator = this.mc.world.loadedEntityList.iterator();
        while (iterator.hasNext()) {
            this.render(iterator.next(), renderWorldLastEvent.getPartialTicks());
        }
    }
    
    void render(final Entity entity, final float n) {
        if (entity == null || entity == Wrapper.INSTANCE.player()) {
            return;
        }
        if (entity == Wrapper.INSTANCE.mc().getRenderViewEntity() && Wrapper.INSTANCE.mcSettings().thirdPersonView == 0) {
            return;
        }
        Wrapper.INSTANCE.mc().entityRenderer.disableLightmap();
        Wrapper.INSTANCE.mc().getRenderManager().renderEntityStatic(entity, n, false);
        Wrapper.INSTANCE.mc().entityRenderer.enableLightmap();
    }
    
    public WallHack() {
        super("WallHack", 0, Module$Category.RENDER);
    }
}
