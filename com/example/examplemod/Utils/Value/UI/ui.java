//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils.Value.UI;

import net.minecraftforge.client.event.*;
import com.example.examplemod.keys.Module.CLIENT.*;
import net.minecraft.client.*;
import java.awt.*;
import com.example.examplemod.*;
import com.example.examplemod.keys.Module.*;
import net.minecraft.potion.*;
import net.minecraft.client.gui.*;
import font.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ui
{
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent$Post renderGameOverlayEvent$Post) {
        switch (ui$1.$SwitchMap$net$minecraftforge$client$event$RenderGameOverlayEvent$ElementType[renderGameOverlayEvent$Post.getType().ordinal()]) {
            case 1: {
                if (!Panic.isPanic) {
                    int n = 10;
                    final int[] array = { 1 };
                    final Minecraft getMinecraft = Minecraft.getMinecraft();
                    final FontRenderer fontRenderer = getMinecraft.fontRenderer;
                    final ScaledResolution scaledResolution = new ScaledResolution(getMinecraft);
                    final int n2 = 10;
                    String.valueOf(getMinecraft.player.posX);
                    FontUtils_Wtermark.fr.drawString("Friend v1", 3.0, 2.0f, new Color(6065914).getRGB());
                    FontUtils_button.fr.drawString("X:  " + String.valueOf((int)getMinecraft.player.posX), 5.0, 40.0f, new Color(16316664).getRGB());
                    FontUtils_button.fr.drawString("Y:  " + String.valueOf((int)getMinecraft.player.posY), 30.0, 40.0f, new Color(16316664).getRGB());
                    final MinecraftFontRenderer fr = FontUtils_button.fr;
                    final String string = "Z:  " + String.valueOf((int)getMinecraft.player.posZ);
                    final double n3 = 50.0;
                    final float n4 = 40.0f;
                    final int rgb = 16316664;
                    try {
                        fr.drawString(string, n3, n4, new Color(rgb).getRGB());
                    }
                    catch (Exception ex) {
                        Gui.drawRect(5, 5, 200, 14, new Color(1381653).hashCode());
                        Gui.drawRect(5, 5, 200, 4, rainbow(300));
                        FontUtils.fr.drawString(Client.cName + "\u0012\ufffdf | " + getMinecraft.getSession().getUsername() + " | FPS: \u0012\ufffda" + Minecraft.getDebugFPS(), 10.0, (float)n2, -1);
                    }
                    final ArrayList<Module> list = new ArrayList<Module>();
                    for (final Module e : Client.modules) {
                        if (e.toggled) {
                            list.add(e);
                        }
                    }
                    list.sort(ui::lambda$onRender$0);
                    for (final PotionEffect potionEffect : getMinecraft.player.getActivePotionEffects()) {
                        if (potionEffect.getPotion().isBeneficial()) {
                            n = 36;
                        }
                        if (potionEffect.getPotion().isBadEffect()) {
                            n = 72;
                        }
                    }
                    for (final Module module : list) {
                        Gui.drawRect(scaledResolution.getScaledWidth(), n, scaledResolution.getScaledWidth() - 2, n + 10, rainbow(array[0] * 300));
                        FontUtils_Aryyalist.fr.drawStringWithShadow(module.name, (double)(scaledResolution.getScaledWidth() - 10 - fontRenderer.getStringWidth(module.name)), (float)(n + 3), rainbow(array[0] * 300));
                        n += 10;
                        final int[] array2 = array;
                        final int n5 = 0;
                        ++array2[n5];
                    }
                    break;
                }
                Minecraft.getMinecraft().fontRenderer.drawString("FPS: " + Minecraft.getDebugFPS(), 5, 5, -1);
                break;
            }
        }
    }
    
    private static int lambda$onRender$0(final Minecraft minecraft, final Module module, final Module module2) {
        return minecraft.fontRenderer.getStringWidth(module2.getName()) - minecraft.fontRenderer.getStringWidth(module.getName());
    }
    
    public static int rainbow(final int n) {
        return Color.getHSBColor((float)(Math.ceil((System.currentTimeMillis() + n) / 20.0) % 360.0 / 360.0), 0.5f, 1.0f).getRGB();
    }
}
