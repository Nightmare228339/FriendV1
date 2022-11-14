//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod;

import org.apache.logging.log4j.*;
import yea.clickgui.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import java.lang.reflect.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.common.*;
import com.example.examplemod.keys.*;
import com.example.examplemod.Utils.Value.UI.*;
import net.minecraft.init.*;
import net.minecraftforge.fml.common.*;

@Mod(modid = "frend", name = "FriendClient Mod", version = "1.0.0")
public class ExampleMod
{
    private static Logger logger;
    public static final String MODID;
    public ClickGuiManager clickGui;
    public static final String VERSION;
    public static ExampleMod instance;
    public static final String NAME;
    public SettingsManager settingsManager;
    
    public static String getVersion() {
        return "1.0.0";
    }
    
    static {
        VERSION = "1.0.0";
        MODID = " Crack by NightMare";
        NAME = "FriendClient Mod Crack by NightMare";
    }
    
    public static void setSession(final Session value) {
        final Class<? extends Minecraft> class1 = Minecraft.getMinecraft().getClass();
        Field field = null;
        for (final Field field2 : class1.getDeclaredFields()) {
            if (field2.getType().isInstance(value)) {
                field = field2;
            }
        }
        if (field == null) {
            throw new IllegalStateException("Session Null");
        }
        field.setAccessible(true);
        field.set(Minecraft.getMinecraft(), value);
        field.setAccessible(false);
        final String string = "FriendlClient  Crack by NightMare 1.12.2 | User: " + Minecraft.getMinecraft().getSession().getUsername();
        try {
            Display.setTitle(Client.name = string);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Mod$EventHandler
    public void init(final FMLInitializationEvent fmlInitializationEvent) {
        this.clickGui = new ClickGuiManager();
        ExampleMod.instance = this;
        this.settingsManager = new SettingsManager();
        Client.startup();
        MinecraftForge.EVENT_BUS.register((Object)new key());
        MinecraftForge.EVENT_BUS.register((Object)new ui());
        ExampleMod.logger.info("DIRT BLOCK >> {}", (Object)Blocks.DIRT.getRegistryName());
    }
}
