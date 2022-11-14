//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.HH.util;

import java.util.*;
import java.net.*;
import java.io.*;

public class URLReader
{
    public static List readURL() {
        final ArrayList<String> list = new ArrayList<String>();
        final URL url = new URL("https://pastebin.com/raw/3g0NPS0F");
        try {
            String line;
            while ((line = new BufferedReader(new InputStreamReader(url.openStream())).readLine()) != null) {
                list.add(line.substring(7));
            }
        }
        catch (Exception ex) {}
        return list;
    }
}
