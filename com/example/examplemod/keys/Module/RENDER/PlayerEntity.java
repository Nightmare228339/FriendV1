//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.RENDER;

import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import com.example.examplemod.Utils.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class PlayerEntity extends Module
{
    public PlayerEntity() {
        super("PlayerEntity", 0, Module$Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent$Post renderGameOverlayEvent$Post) {
        switch (PlayerEntity$1.$SwitchMap$net$minecraftforge$client$event$RenderGameOverlayEvent$ElementType[renderGameOverlayEvent$Post.getType().ordinal()]) {
            case 1: {
                RenderUtils.renderEntity((EntityLivingBase)this.mc.player, 30, 20, 120);
                break;
            }
        }
    }
}
