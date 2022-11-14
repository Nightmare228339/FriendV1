//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.MOVEMENT;

import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.potion.*;
import java.util.*;
import com.example.examplemod.Utils.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class NoSnowDown extends Module
{
    @SubscribeEvent
    public void onPlayerTick(final TickEvent$PlayerTickEvent tickEvent$PlayerTickEvent) {
        if (this.mc.player.isPotionActive((Potion)Objects.requireNonNull(Potion.getPotionById(2)))) {
            SpeedUtils.speed(0.23000000417232513);
        }
    }
    
    public NoSnowDown() {
        super("NoSnowDown", 0, Module$Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onInput(final InputUpdateEvent inputUpdateEvent) {
        if (Minecraft.getMinecraft().world != null && Minecraft.getMinecraft().player != null) {
            if (this.mc.player.isHandActive() && !this.mc.player.isRiding()) {
                final MovementInput movementInput = this.mc.player.movementInput;
                movementInput.moveStrafe /= 0.2f;
                final MovementInput movementInput2 = this.mc.player.movementInput;
                movementInput2.moveForward /= 0.2f;
            }
            if (this.mc.player.isSneaking()) {
                final MovementInput movementInput3 = this.mc.player.movementInput;
                movementInput3.moveStrafe /= 0.3f;
                final MovementInput movementInput4 = this.mc.player.movementInput;
                movementInput4.moveForward /= 0.3f;
            }
        }
    }
}
