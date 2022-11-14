//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.HH.manager;

import com.example.examplemod.HH.util.*;
import java.util.*;

public class HWIDManager
{
    public static final String pastebinURL;
    public static List hwids;
    
    public static void hwidCheck() {
        HWIDManager.hwids = URLReader.readURL();
        if (!HWIDManager.hwids.contains(SystemUtil.getSystemInfo())) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
    
    static {
        pastebinURL = "https://pastebin.com/raw/3g0NPS0F";
        HWIDManager.hwids = new ArrayList();
    }
}
