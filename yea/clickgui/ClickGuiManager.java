//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui;

import net.minecraft.client.gui.*;
import yea.clickgui.component.*;
import java.util.*;
import java.io.*;
import com.example.examplemod.keys.Module.*;

public class ClickGuiManager extends GuiScreen
{
    public static ArrayList frames;
    public static int color;
    
    protected void mouseClicked(final int n, final int n2, final int n3) throws IOException {
        for (final Frame frame : ClickGuiManager.frames) {
            if (frame.isWithinHeader(n, n2) && n3 == 0) {
                frame.setDrag(true);
                frame.dragX = n - frame.getX();
                frame.dragY = n2 - frame.getY();
            }
            if (frame.isWithinHeader(n, n2) && n3 == 1) {
                frame.setOpen(!frame.isOpen());
            }
            if (frame.isOpen() && !frame.getComponents().isEmpty()) {
                final Iterator iterator2 = frame.getComponents().iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().mouseClicked(n, n2, n3);
                }
            }
        }
    }
    
    protected void keyTyped(final char c, final int n) {
        for (final Frame frame : ClickGuiManager.frames) {
            if (frame.isOpen() && n != 1 && !frame.getComponents().isEmpty()) {
                final Iterator iterator2 = frame.getComponents().iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().keyTyped(c, n);
                }
            }
        }
        if (n == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
    }
    
    public void initGui() {
    }
    
    protected void mouseReleased(final int n, final int n2, final int n3) {
        final Iterator<Frame> iterator = ClickGuiManager.frames.iterator();
        while (iterator.hasNext()) {
            iterator.next().setDrag(false);
        }
        for (final Frame frame : ClickGuiManager.frames) {
            if (frame.isOpen() && !frame.getComponents().isEmpty()) {
                final Iterator iterator3 = frame.getComponents().iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().mouseReleased(n, n2, n3);
                }
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    public void drawScreen(final int n, final int n2, final float n3) {
        for (final Frame frame : ClickGuiManager.frames) {
            frame.renderFrame(this.fontRenderer);
            frame.updatePosition(n, n2);
            final Iterator iterator2 = frame.getComponents().iterator();
            while (iterator2.hasNext()) {
                iterator2.next().updateComponent(n, n2);
            }
        }
    }
    
    public ClickGuiManager() {
        ClickGuiManager.frames = new ArrayList();
        final int x = 10;
        int y = 10;
        final Module$Category[] values = Module$Category.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final Frame e = new Frame(values[i]);
            e.setY(y);
            e.setX(x);
            ClickGuiManager.frames.add(e);
            y += 20;
        }
    }
}
