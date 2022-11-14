//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.PLAYER;

import net.minecraft.entity.*;
import net.minecraftforge.fml.common.gameevent.*;
import com.example.examplemod.Utils.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.util.math.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.example.examplemod.keys.Module.*;

public class MCF extends Module
{
    private Entity entity;
    private boolean isPressed;
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent$PlayerTickEvent tickEvent$PlayerTickEvent) {
        FriendManager.doCheck = true;
        final RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
        if (Mouse.isButtonDown(2)) {
            if (!this.isPressed) {
                this.isPressed = true;
                if (objectMouseOver != null && objectMouseOver.typeOfHit == RayTraceResult$Type.ENTITY) {
                    this.entity = objectMouseOver.entityHit;
                    FriendManager.toggleFriend(this.entity.getUniqueID());
                }
            }
        }
        else {
            this.isPressed = false;
        }
    }
    
    public MCF() {
        super("MCF", 24, Module$Category.PLAYER);
        this.isPressed = false;
    }
}
