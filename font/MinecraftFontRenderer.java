//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package font;

import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import java.util.*;
import net.minecraft.client.renderer.*;

public class MinecraftFontRenderer extends CFont
{
    CFont$CharData[] italicChars;
    String colorcodeIdentifiers;
    DynamicTexture texItalic;
    DynamicTexture texItalicBold;
    CFont$CharData[] boldItalicChars;
    CFont$CharData[] boldChars;
    DynamicTexture texBold;
    int[] colorCode;
    
    public int drawPassword(final String s, final double n, final float n2, final int n3) {
        return (int)this.drawString(s.replaceAll(".", "."), n, n2, n3, false, 8.0f);
    }
    
    private float getCharWidthFloat(final char ch) {
        if (ch == '§') {
            return -1.0f;
        }
        if (ch == ' ') {
            return 2.0f;
        }
        final int index = "\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u001f01RS^_tu~\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u05d2\ufffd\ufffd\ufffd\ufffd\ufffd\u046a\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u0002$abVUcQW]\\[\u0010\u00144,\u001c\u0000<^_ZTif`PlghdeYXRSkj\u0018\f\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u00fc\u0126\ufffd\ufffd\ufffd\u001e\u0005\b)a\ufffded !\ufffdH\ufffd\u0019\ufffd\u001a\u007f\ufffd\ufffd\u0000".indexOf(ch);
        if (ch > '\0' && index != -1) {
            return this.charData[index].width / 2.0f - 4.0f;
        }
        if (this.charData[ch].width / 2.0f - 4.0f != 0.0f) {
            final int n = (int)(this.charData[ch].width / 2.0f - 4.0f) >>> 4;
            int n2 = (int)(this.charData[ch].width / 2.0f - 4.0f) & 0xF;
            return (float)((++n2 - (n & 0xF)) / 2 + 1);
        }
        return 0.0f;
    }
    
    public String trimStringToWidth(final String s, final int n, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        float n2 = 0.0f;
        final int n3 = b ? (s.length() - 1) : 0;
        final int n4 = b ? -1 : 1;
        int n5 = 0;
        boolean b2 = false;
        for (int index = n3; index >= 0 && index < s.length() && n2 < n; index += n4) {
            final char char1 = s.charAt(index);
            final float charWidthFloat = this.getCharWidthFloat(char1);
            if (n5 != 0) {
                n5 = 0;
                if (char1 != 'l' && char1 != 'L') {
                    if (char1 == 'r' || char1 == 'R') {
                        b2 = false;
                    }
                }
                else {
                    b2 = true;
                }
            }
            else if (charWidthFloat < 0.0f) {
                n5 = 1;
            }
            else {
                n2 += charWidthFloat;
                if (b2) {
                    ++n2;
                }
            }
            if (n2 > n) {
                break;
            }
            if (b) {
                sb.insert(0, char1);
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    public int drawString(final String s, final double n, final float n2, final int n3) {
        return (int)this.drawString(s, n, n2, n3, false, 8.3f);
    }
    
    public float drawCenteredString(final String s, final float n, final float n2, final int n3) {
        return (float)this.drawString(s, n - (float)(this.getStringWidth(s) / 2.0), n2, n3);
    }
    
    private void drawLine(final double n, final double n2, final double n3, final double n4, final float n5) {
        GL11.glDisable(3553);
        GL11.glLineWidth(n5);
        GL11.glBegin(1);
        GL11.glVertex2d(n, n2);
        GL11.glVertex2d(n3, n4);
        GL11.glEnd();
        GL11.glEnable(3553);
    }
    
    public int drawSmoothString(final String s, final double n, final float n2, final int n3) {
        return (int)this.drawSmoothString(s, n, n2, n3, false);
    }
    
    private void setupBoldItalicIDs() {
        this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
        this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
        this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
    }
    
    public String trimStringToWidth(final String s, final int n) {
        return this.trimStringToWidth(s, n, false);
    }
    
    public float drawNoBSCenteredString(final String s, final float n, final float n2, final int n3) {
        return (float)this.drawNoBSString(s, n - (float)(this.getStringWidth(s) / 2.0), n2, n3);
    }
    
    public void setFont(final Font font) {
        super.setFont(font);
        this.setupBoldItalicIDs();
    }
    
    public double getPasswordWidth(final String s) {
        return this.getStringWidth(s.replaceAll(".", "."), 8.0f);
    }
    
    public double getStringWidth(final String s) {
        if (s == null) {
            return 0.0;
        }
        float n = 0.0f;
        final CFont$CharData[] charData = this.charData;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '§') {
                "0123456789abcdefklmnor".indexOf(char1);
                ++i;
            }
            else if (char1 < charData.length) {
                n += charData[char1].width - 8.3f + this.charOffset;
            }
        }
        return n / 2.0f;
    }
    
    public void setFractionalMetrics(final boolean fractionalMetrics) {
        super.setFractionalMetrics(fractionalMetrics);
        this.setupBoldItalicIDs();
    }
    
    private void setupMinecraftColorcodes() {
        for (int i = 0; i < 32; ++i) {
            final int n = (i >> 3 & 0x1) * 85;
            int n2 = (i >> 2 & 0x1) * 170 + n;
            int n3 = (i >> 1 & 0x1) * 170 + n;
            int n4 = (i & 0x1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this.colorCode[i] = ((n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | (n4 & 0xFF));
        }
    }
    
    public List formatString(final String s, final double n) {
        final ArrayList<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        char c = '\uffff';
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            final char c2 = charArray[i];
            if (c2 == '§' && i < charArray.length - 1) {
                c = charArray[i + 1];
            }
            if (this.getStringWidth(sb.toString() + c2) < n) {
                sb.append(c2);
            }
            else {
                list.add(sb.toString());
                sb = new StringBuilder("\ufffd" + c + c2);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return list;
    }
    
    public void setAntiAlias(final boolean antiAlias) {
        super.setAntiAlias(antiAlias);
        this.setupBoldItalicIDs();
    }
    
    public List wrapWords(final String e, final double n) {
        final ArrayList<String> list = new ArrayList<String>();
        if (this.getStringWidth(e) > n) {
            final String[] split = e.split(" ");
            StringBuilder sb = new StringBuilder();
            char c = '\uffff';
            for (final String str : split) {
                for (int j = 0; j < str.toCharArray().length; ++j) {
                    if (str.toCharArray()[j] == '§' && j < str.toCharArray().length - 1) {
                        c = str.toCharArray()[j + 1];
                    }
                }
                if (this.getStringWidth((Object)sb + str + " ") < n) {
                    sb.append(str).append(" ");
                }
                else {
                    list.add(sb.toString());
                    sb = new StringBuilder("\ufffd" + c + str + " ");
                }
            }
            if (sb.length() > 0) {
                if (this.getStringWidth(sb.toString()) < n) {
                    list.add("\ufffd" + c + (Object)sb + " ");
                    final StringBuilder sb2 = new StringBuilder();
                }
                else {
                    list.addAll(this.formatString(sb.toString(), n));
                }
            }
        }
        else {
            list.add(e);
        }
        return list;
    }
    
    public int drawNoBSString(final String s, final double n, final float n2, final int n3) {
        return (int)this.drawNoBSString(s, n, n2, n3, false);
    }
    
    public double getStringWidth(final String s, final float n) {
        if (s == null) {
            return 0.0;
        }
        float n2 = 0.0f;
        final CFont$CharData[] charData = this.charData;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '§') {
                "0123456789abcdefklmnor".indexOf(char1);
                ++i;
            }
            else if (char1 < charData.length) {
                n2 += charData[char1].width - n + this.charOffset;
            }
        }
        return n2 / 2.0f;
    }
    
    public float drawSmoothString(final String s, double n, double n2, final int n3, final boolean b) {
        --n;
        if (s == null) {
            return 0.0f;
        }
        CFont$CharData[] array = this.charData;
        final float n4 = (n3 >> 24 & 0xFF) / 255.0f;
        int n5 = 0;
        int n6 = 0;
        boolean b2 = false;
        boolean b3 = false;
        n *= 2.0;
        n2 = (n2 - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n4);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.tex.getGlTextureId());
        GL11.glBindTexture(3553, this.tex.getGlTextureId());
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '§') {
                int index = 21;
                try {
                    index = "0123456789abcdefklmnor".indexOf(s.charAt(i + 1));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (index < 16) {
                    n5 = 0;
                    n6 = 0;
                    b3 = false;
                    b2 = false;
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    array = this.charData;
                    if (index < 0) {
                        index = 15;
                    }
                    if (b) {
                        index += 16;
                    }
                    final int n7 = this.colorCode[index];
                    GlStateManager.color((n7 >> 16 & 0xFF) / 255.0f, (n7 >> 8 & 0xFF) / 255.0f, (n7 & 0xFF) / 255.0f, n4);
                }
                else if (index != 16) {
                    if (index == 17) {
                        n5 = 1;
                        if (n6 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texBold.getGlTextureId());
                            array = this.boldChars;
                        }
                    }
                    else if (index == 18) {
                        b2 = true;
                    }
                    else if (index == 19) {
                        b3 = true;
                    }
                    else if (index == 20) {
                        n6 = 1;
                        if (n5 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                            array = this.italicChars;
                        }
                    }
                    else {
                        n5 = 0;
                        n6 = 0;
                        b3 = false;
                        b2 = false;
                        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n4);
                        GlStateManager.bindTexture(this.tex.getGlTextureId());
                        array = this.charData;
                    }
                }
                ++i;
            }
            else if (char1 < array.length) {
                GL11.glBegin(4);
                this.drawChar(array, char1, (float)n, (float)n2);
                GL11.glEnd();
                if (b2) {
                    this.drawLine(n, n2 + array[char1].height / 2, n + array[char1].width - 8.0, n2 + array[char1].height / 2, 1.0f);
                }
                if (b3) {
                    this.drawLine(n, n2 + array[char1].height - 2.0, n + array[char1].width - 8.0, n2 + array[char1].height - 2.0, 1.0f);
                }
                n += array[char1].width - 8.3f + this.charOffset;
            }
        }
        GL11.glHint(3155, 4352);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return (float)n / 2.0f;
    }
    
    public int getHeight() {
        return (this.fontHeight - 8) / 2;
    }
    
    public String trimStringToWidthPassword(String replaceAll, final int n, final boolean b) {
        replaceAll = replaceAll.replaceAll(".", ".");
        return this.trimStringToWidth(replaceAll, n, b);
    }
    
    public float drawString(final String s, double n, double n2, int n3, final boolean b, final float n4) {
        --n;
        if (s == null) {
            return 0.0f;
        }
        if (n3 == 553648127) {
            n3 = 16777215;
        }
        if ((n3 & 0xFC000000) == 0x0) {
            n3 |= 0xFF000000;
        }
        if (b) {
            n3 = ((n3 & 0xFCFCFC) >> 2 | (n3 & 0xFF000000));
        }
        CFont$CharData[] array = this.charData;
        final float n5 = (n3 >> 24 & 0xFF) / 255.0f;
        int n6 = 0;
        int n7 = 0;
        boolean b2 = false;
        boolean b3 = false;
        n *= 2.0;
        n2 = (n2 - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n5);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.tex.getGlTextureId());
        GL11.glBindTexture(3553, this.tex.getGlTextureId());
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '§') {
                int index = 21;
                final String s2 = "0123456789abcdefklmnor";
                final char char2 = s.charAt(i + 1);
                try {
                    index = s2.indexOf(char2);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (index < 16) {
                    n6 = 0;
                    n7 = 0;
                    b3 = false;
                    b2 = false;
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    array = this.charData;
                    if (index < 0) {
                        index = 15;
                    }
                    if (b) {
                        index += 16;
                    }
                    final int n8 = this.colorCode[index];
                    GlStateManager.color((n8 >> 16 & 0xFF) / 255.0f, (n8 >> 8 & 0xFF) / 255.0f, (n8 & 0xFF) / 255.0f, n5);
                }
                else if (index != 16) {
                    if (index == 17) {
                        n6 = 1;
                        if (n7 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texBold.getGlTextureId());
                            array = this.boldChars;
                        }
                    }
                    else if (index == 18) {
                        b2 = true;
                    }
                    else if (index == 19) {
                        b3 = true;
                    }
                    else if (index == 20) {
                        n7 = 1;
                        if (n6 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                            array = this.italicChars;
                        }
                    }
                    else {
                        n6 = 0;
                        n7 = 0;
                        b3 = false;
                        b2 = false;
                        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n5);
                        GlStateManager.bindTexture(this.tex.getGlTextureId());
                        array = this.charData;
                    }
                }
                ++i;
            }
            else if (char1 < array.length) {
                GL11.glBegin(4);
                this.drawChar(array, char1, (float)n, (float)n2);
                GL11.glEnd();
                if (b2) {
                    this.drawLine(n, n2 + array[char1].height / 2, n + array[char1].width - 8.0, n2 + array[char1].height / 2, 1.0f);
                }
                if (b3) {
                    this.drawLine(n, n2 + array[char1].height - 2.0, n + array[char1].width - 8.0, n2 + array[char1].height - 2.0, 1.0f);
                }
                n += array[char1].width - n4 + this.charOffset;
            }
        }
        GL11.glHint(3155, 4352);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return (float)n / 2.0f;
    }
    
    public float drawNoBSString(final String s, double n, double n2, final int n3, final boolean b) {
        --n;
        if (s == null) {
            return 0.0f;
        }
        CFont$CharData[] array = this.charData;
        final float n4 = (n3 >> 24 & 0xFF) / 255.0f;
        int n5 = 0;
        int n6 = 0;
        boolean b2 = false;
        boolean b3 = false;
        n *= 2.0;
        n2 = (n2 - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n4);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.tex.getGlTextureId());
        GL11.glBindTexture(3553, this.tex.getGlTextureId());
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '§') {
                int index = 21;
                final String s2 = "0123456789abcdefklmnor";
                final int index2 = i + 1;
                try {
                    index = s2.indexOf(s.charAt(index2));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (index < 16) {
                    n5 = 0;
                    n6 = 0;
                    b3 = false;
                    b2 = false;
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    array = this.charData;
                    if (index < 0) {
                        index = 15;
                    }
                    if (b) {
                        index += 16;
                    }
                    final int n7 = this.colorCode[index];
                    GlStateManager.color((n7 >> 16 & 0xFF) / 255.0f, (n7 >> 8 & 0xFF) / 255.0f, (n7 & 0xFF) / 255.0f, n4);
                }
                else if (index != 16) {
                    if (index == 17) {
                        n5 = 1;
                        if (n6 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texBold.getGlTextureId());
                            array = this.boldChars;
                        }
                    }
                    else if (index == 18) {
                        b2 = true;
                    }
                    else if (index == 19) {
                        b3 = true;
                    }
                    else if (index == 20) {
                        n6 = 1;
                        if (n5 != 0) {
                            GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                            array = this.boldItalicChars;
                        }
                        else {
                            GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                            array = this.italicChars;
                        }
                    }
                    else {
                        n5 = 0;
                        n6 = 0;
                        b3 = false;
                        b2 = false;
                        GlStateManager.color((n3 >> 16 & 0xFF) / 255.0f, (n3 >> 8 & 0xFF) / 255.0f, (n3 & 0xFF) / 255.0f, n4);
                        GlStateManager.bindTexture(this.tex.getGlTextureId());
                        array = this.charData;
                    }
                }
                ++i;
            }
            else if (char1 < array.length) {
                GL11.glBegin(4);
                this.drawChar(array, char1, (float)n, (float)n2);
                GL11.glEnd();
                if (b2) {
                    this.drawLine(n, n2 + array[char1].height / 2, n + array[char1].width - 8.0, n2 + array[char1].height / 2, 1.0f);
                }
                if (b3) {
                    this.drawLine(n, n2 + array[char1].height - 2.0, n + array[char1].width - 8.0, n2 + array[char1].height - 2.0, 1.0f);
                }
                n += array[char1].width - 8.3f + this.charOffset;
            }
        }
        GL11.glHint(3155, 4352);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return (float)n / 2.0f;
    }
    
    public float drawCenteredStringWithShadow(final String s, final float n, final float n2, final int n3) {
        return (float)this.drawStringWithShadow(s, n - (float)(this.getStringWidth(s) / 2.0), n2, n3);
    }
    
    public MinecraftFontRenderer(final Font font, final boolean b, final boolean b2) {
        super(font, b, b2);
        this.boldChars = new CFont$CharData[256];
        this.italicChars = new CFont$CharData[256];
        this.boldItalicChars = new CFont$CharData[256];
        this.colorCode = new int[32];
        this.colorcodeIdentifiers = "0123456789abcdefklmnor";
        this.setupMinecraftColorcodes();
        this.setupBoldItalicIDs();
    }
    
    public int drawStringWithShadow(final String s, final double n, final float n2, final int n3) {
        return (int)Math.max(this.drawString(s, n + 0.8999999761581421, n2 + 0.5, n3, true, 8.3f), this.drawString(s, n, n2, n3, false, 8.3f));
    }
}
