//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package font;

import net.minecraft.util.*;
import java.awt.*;
import net.minecraft.client.*;

public class FontUtils_Wtermark
{
    public static MinecraftFontRenderer fr;
    
    static {
        FontUtils_Wtermark.fr = new MinecraftFontRenderer(getFontFromTTF(new ResourceLocation("fonts/neverlose900.ttf"), 40.0f, 0), true, true);
    }
    
    public static Font getFontFromTTF(final ResourceLocation resourceLocation, final float size, final int fontFormat) {
        final Font font = Font.createFont(fontFormat, Minecraft.getMinecraft().getResourceManager().getResource(resourceLocation).getInputStream());
        try {
            return font.deriveFont(size);
        }
        catch (Exception ex) {
            return null;
        }
    }
}
