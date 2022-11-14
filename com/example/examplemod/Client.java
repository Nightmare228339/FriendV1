//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod;

import java.util.concurrent.*;
import yea.clickgui.*;
import org.lwjgl.opengl.*;
import com.example.examplemod.keys.Module.PLAYER.*;
import com.example.examplemod.keys.Module.WORLD.*;
import com.example.examplemod.keys.Module.MOVEMENT.*;
import com.example.examplemod.keys.Module.RENDER.*;
import com.example.examplemod.keys.Module.COMBAT.*;
import com.example.examplemod.keys.Module.CLIENT.*;
import com.example.examplemod.keys.Module.*;
import java.util.*;

public class Client
{
    private static final Client INSTANCE;
    public static CopyOnWriteArrayList modules;
    public static String name;
    public static ClickGuiManager clickGuiManager;
    public static String cName;
    
    static {
        Client.name = "FriendClient 1.12.2 | https://vk.com/rose1colored";
        Client.cName = "FriendClient";
        Client.modules = new CopyOnWriteArrayList();
        INSTANCE = new Client();
    }
    
    public static final Client getInstance() {
        return Client.INSTANCE;
    }
    
    public static void keyPress(final int n) {
        for (final Module module : Client.modules) {
            if (module.getKey() == n) {
                module.toggle();
            }
        }
    }
    
    public static void startup() {
        Display.setTitle(Client.name);
        Client.modules.add(new BlockObject());
        Client.modules.add(new ESP());
        Client.modules.add(new ClickGUI());
        Client.modules.add(new FakePlayer());
        Client.modules.add(new NameTags());
        Client.modules.add(new BlockReach());
        Client.modules.add(new FullBright());
        Client.modules.add(new ViewModel());
        Client.modules.add(new TargetHUD());
        Client.modules.add(new Tracers());
        Client.modules.add(new FovChanger());
        Client.modules.add(new WallHack());
        Client.modules.add(new AntiBot());
        Client.modules.add(new Sprint());
        Client.modules.add(new HitBox());
        Client.modules.add(new Strafe());
        Client.modules.add(new MCF());
        Client.modules.add(new ForgColor());
        Client.modules.add(new AimBot());
        Client.modules.add(new Particles());
        Client.modules.add(new PlayerEntity());
        Client.modules.add(new NoSnowDown());
        Client.modules.add(new ArmorHUD());
        Client.modules.add(new AntiAim());
        Client.modules.add(new Panic());
        Client.clickGuiManager = new ClickGuiManager();
    }
    
    public static ArrayList getModulesInCategory(final Module$Category module$Category) {
        final ArrayList<Module> list = new ArrayList<Module>();
        for (final Module e : Client.modules) {
            if (e.getCategory().name().equalsIgnoreCase(module$Category.name())) {
                list.add(e);
            }
        }
        return list;
    }
}
