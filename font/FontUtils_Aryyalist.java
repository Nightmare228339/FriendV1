//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package font;

import net.minecraft.util.*;
import java.awt.*;
import net.minecraft.client.*;
import java.io.*;

public class FontUtils_Aryyalist
{
    public static MinecraftFontRenderer fr;
    
    static {
        FontUtils_Aryyalist.fr = new MinecraftFontRenderer(getFontFromTTF(new ResourceLocation("fonts/rubik.ttf"), 16.0f, 0), true, true);
    }
    
    public static Font getFontFromTTF(final ResourceLocation resourceLocation, final float size, final int fontFormat) {
        final InputStream getInputStream = Minecraft.getMinecraft().getResourceManager().getResource(resourceLocation).getInputStream();
        try {
            return Font.createFont(fontFormat, getInputStream).deriveFont(size);
        }
        catch (Exception ex) {
            return null;
        }
    }
}
