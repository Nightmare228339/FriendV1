//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.keys.Module.COMBAT;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import com.example.examplemod.keys.Module.*;
import com.example.examplemod.*;
import yea.clickgui.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import java.util.*;
import java.util.function.*;
import com.example.examplemod.Utils.*;

public class AimBot extends Module
{
    public static Minecraft mc;
    public float[] facing;
    private Entity entity;
    
    public static boolean canSeeEntityAtFov(final Entity entity, final float n) {
        return angleDifference((float)(Math.toDegrees(Math.atan2(entity.posZ - AimBot.mc.player.posZ, entity.posX - AimBot.mc.player.posX)) - 90.0), AimBot.mc.player.rotationYaw) <= n;
    }
    
    private static boolean lambda$onUpdate$11(final double n, final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player) <= n;
    }
    
    public boolean isMoving() {
        return false;
    }
    
    public float[] rotations_trio(final EntityPlayer entityPlayer) {
        final double n = entityPlayer.posX - AimBot.mc.player.posX;
        final double n2 = entityPlayer.posY - (AimBot.mc.player.posY + AimBot.mc.player.getEyeHeight()) + 0.5;
        final double n3 = entityPlayer.posZ - AimBot.mc.player.posZ;
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, (double)MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    private static Float lambda$onUpdate$4(final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player);
    }
    
    private static boolean lambda$onUpdate$5(final double n, final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player) <= n;
    }
    
    private static boolean lambda$onUpdate$9(final EntityPlayer entityPlayer) {
        return entityPlayer != AimBot.mc.player;
    }
    
    private static boolean lambda$onUpdate$2(final double n, final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player) <= n;
    }
    
    public static void clickMouse(final int n) {
        final Robot robot = new Robot();
        while (true) {
            if (n == 0) {
                robot.mousePress(16);
                final Robot robot2 = robot;
                final int buttons = 16;
                try {
                    robot2.mouseRelease(buttons);
                    return;
                    Label_0033: {
                        robot.mousePress(4096);
                    }
                    robot.mouseRelease(4096);
                    return;
                }
                // iftrue(Label_0033:, n == 1)
                catch (AWTException ex) {
                    ex.printStackTrace();
                }
                return;
            }
            continue;
        }
    }
    
    private static Float lambda$onUpdate$10(final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player);
    }
    
    public AimBot() {
        super("AimBot Beta", 0, Module$Category.COMBAT);
        final ArrayList<String> list = new ArrayList<String>();
        final ArrayList<String> list2 = new ArrayList<String>();
        ExampleMod.instance.settingsManager.rSetting(new Setting("Circle", (Module)this, false));
        list.add("Head");
        list.add("Body");
        list2.add("Classic");
        list2.add("Circle");
        ExampleMod.instance.settingsManager.rSetting(new Setting("Mode", (Module)this, (ArrayList)list, "Mode"));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Range", (Module)this, 4.2, 1.0, 100.0, false));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Fov", (Module)this, 40.0, 1.0, 40.0, true));
        ExampleMod.instance.settingsManager.rSetting(new Setting("Aim", (Module)this, (ArrayList)list2, "Aim"));
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent$Post renderGameOverlayEvent$Post) {
        final float n = (float)ExampleMod.instance.settingsManager.getSettingByName(this.name, "Fov").getValDouble();
        final boolean valBoolean = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Circle").getValBoolean();
        if (renderGameOverlayEvent$Post.getType() == RenderGameOverlayEvent$ElementType.TEXT) {
            final ScaledResolution scaledResolution = new ScaledResolution(AimBot.mc);
            if (valBoolean) {
                RenderUtils.drawCircle((float)(scaledResolution.getScaledWidth() / 2), (float)(scaledResolution.getScaledHeight() / 2), (float)(n * 3.5), new Color(15814993).getRGB(), 360);
            }
        }
    }
    
    private static Float lambda$onUpdate$1(final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player);
    }
    
    private static boolean lambda$onUpdate$8(final double n, final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player) <= n;
    }
    
    @SubscribeEvent
    public void onUpdate(final RenderWorldLastEvent renderWorldLastEvent) {
        final float n = (float)ExampleMod.instance.settingsManager.getSettingByName(this.name, "Fov").getValDouble();
        final String valString = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Mode").getValString();
        final double valDouble = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Range").getValDouble();
        final String valString2 = ExampleMod.instance.settingsManager.getSettingByName(this.name, "Aim").getValString();
        if (Objects.equals(valString2, "Circle")) {
            final ScaledResolution scaledResolution = new ScaledResolution(AimBot.mc);
            if (Objects.equals(valString, "Head")) {
                final EntityPlayer entityPlayer = (EntityPlayer)AimBot.mc.world.playerEntities.stream().filter(AimBot::lambda$onUpdate$0).min(Comparator.comparing((Function<? super T, ? extends Comparable>)AimBot::lambda$onUpdate$1)).filter(AimBot::lambda$onUpdate$2).orElse(null);
                final float n2 = n;
                if (entityPlayer != null && AimBot.mc.player.canEntityBeSeen((Entity)entityPlayer) && !FriendManager.isFriend(entityPlayer.getUniqueID()) && canSeeEntityAtFov((Entity)entityPlayer, n2 * 3.5f) && !entityPlayer.isInvisible()) {
                    if (n2 > 40.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 2.0f);
                    }
                    if (n2 > 50.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 3.0f);
                    }
                    if (n2 > 60.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 5.0f);
                    }
                    if (n2 > 70.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 6.0f);
                    }
                    if (n2 > 80.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 7.0f);
                    }
                    if (n2 > 90.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer, n2 / 8.0f);
                    }
                    AimBot.mc.player.rotationYaw = this.rotations(entityPlayer)[0];
                    AimBot.mc.player.rotationPitch = this.rotations(entityPlayer)[1];
                }
            }
            else if (Objects.equals(valString, "Body")) {
                final EntityPlayer entityPlayer2 = (EntityPlayer)AimBot.mc.world.playerEntities.stream().filter(AimBot::lambda$onUpdate$3).min(Comparator.comparing((Function<? super T, ? extends Comparable>)AimBot::lambda$onUpdate$4)).filter(AimBot::lambda$onUpdate$5).orElse(null);
                final float n3 = n;
                if (entityPlayer2 != null && AimBot.mc.player.canEntityBeSeen((Entity)entityPlayer2) && !FriendManager.isFriend(entityPlayer2.getUniqueID()) && canSeeEntityAtFov((Entity)entityPlayer2, n * 3.5f) && !entityPlayer2.isInvisible()) {
                    if (n3 > 40.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 2.0f);
                    }
                    if (n3 > 50.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 3.0f);
                    }
                    if (n3 > 60.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 5.0f);
                    }
                    if (n3 > 70.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 6.0f);
                    }
                    if (n3 > 80.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 7.0f);
                    }
                    if (n3 > 90.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer2, n3 / 8.0f);
                    }
                    AimBot.mc.player.rotationYaw = this.rotations_two(entityPlayer2)[0];
                    AimBot.mc.player.rotationPitch = this.rotations_two(entityPlayer2)[1];
                }
            }
            else if (Objects.equals(valString, "Legs")) {
                final EntityPlayer entityPlayer3 = (EntityPlayer)AimBot.mc.world.playerEntities.stream().filter(AimBot::lambda$onUpdate$6).min(Comparator.comparing((Function<? super T, ? extends Comparable>)AimBot::lambda$onUpdate$7)).filter(AimBot::lambda$onUpdate$8).orElse(null);
                final float n4 = n;
                if (entityPlayer3 != null && AimBot.mc.player.canEntityBeSeen((Entity)entityPlayer3) && !FriendManager.isFriend(entityPlayer3.getUniqueID()) && canSeeEntityAtFov((Entity)entityPlayer3, n * 3.5f) && !entityPlayer3.isInvisible()) {
                    if (n4 > 40.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 2.0f);
                    }
                    if (n4 > 50.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 3.0f);
                    }
                    if (n4 > 60.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 5.0f);
                    }
                    if (n4 > 70.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 6.0f);
                    }
                    if (n4 > 80.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 7.0f);
                    }
                    if (n4 > 90.0f) {
                        canSeeEntityAtFov((Entity)entityPlayer3, n4 / 8.0f);
                    }
                    AimBot.mc.player.rotationYaw = this.rotations_two(entityPlayer3)[0];
                    AimBot.mc.player.rotationPitch = this.rotations_two(entityPlayer3)[1];
                }
            }
        }
        else if (Objects.equals(valString2, "Classic")) {
            final EntityPlayer entityPlayer4 = (EntityPlayer)AimBot.mc.world.playerEntities.stream().filter(AimBot::lambda$onUpdate$9).min(Comparator.comparing((Function<? super T, ? extends Comparable>)AimBot::lambda$onUpdate$10)).filter(AimBot::lambda$onUpdate$11).orElse(null);
            if (entityPlayer4 != null && AimBot.mc.player.canEntityBeSeen((Entity)entityPlayer4) && !FriendManager.isFriend(entityPlayer4.getUniqueID())) {
                AimBot.mc.player.rotationYaw = this.rotations(entityPlayer4)[0];
                AimBot.mc.player.rotationPitch = this.rotations(entityPlayer4)[1];
            }
        }
    }
    
    static {
        AimBot.mc = Minecraft.getMinecraft();
    }
    
    public float[] rotations(final EntityPlayer entityPlayer) {
        final double n = entityPlayer.posX - AimBot.mc.player.posX;
        final double n2 = entityPlayer.posY - (AimBot.mc.player.posY + AimBot.mc.player.getEyeHeight()) + 1.5;
        final double n3 = entityPlayer.posZ - AimBot.mc.player.posZ;
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, (double)MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    public static double angleDifference(final double n, final double n2) {
        float n3 = (float)(Math.abs(n - n2) % 360.0);
        if (n3 > 180.0f) {
            n3 = 360.0f - n3;
        }
        return n3;
    }
    
    public float[] rotations_two(final EntityPlayer entityPlayer) {
        final double n = entityPlayer.posX - AimBot.mc.player.posX;
        final double n2 = entityPlayer.posY - (AimBot.mc.player.posY + AimBot.mc.player.getEyeHeight()) + 1.0;
        final double n3 = entityPlayer.posZ - AimBot.mc.player.posZ;
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, (double)MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    private static boolean lambda$onUpdate$6(final EntityPlayer entityPlayer) {
        return entityPlayer != AimBot.mc.player;
    }
    
    private static boolean lambda$onUpdate$3(final EntityPlayer entityPlayer) {
        return entityPlayer != AimBot.mc.player;
    }
    
    private static boolean lambda$onUpdate$0(final EntityPlayer entityPlayer) {
        return entityPlayer != AimBot.mc.player;
    }
    
    private static Float lambda$onUpdate$7(final EntityPlayer entityPlayer) {
        return entityPlayer.getDistance((Entity)AimBot.mc.player);
    }
}
