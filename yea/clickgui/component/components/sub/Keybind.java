//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component.components.sub;

import yea.clickgui.component.*;
import yea.clickgui.component.components.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import font.*;
import org.lwjgl.input.*;

public class Keybind extends Component
{
    private Button parent;
    private boolean binding;
    private boolean hovered;
    private int offset;
    private int y;
    private int x;
    
    public void renderComponent() {
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth() * 1, this.parent.parent.getY() + this.offset + 12, this.hovered ? new Color(12959422).getRGB() : new Color(12959422).getRGB());
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        FontUtils.fr.drawString(this.binding ? " PRESS KEY " : ("Key: " + Keyboard.getKeyName(this.parent.mod.getKey())), (double)((this.parent.parent.getX() + 7) * 2), (float)((this.parent.parent.getY() + this.offset + 2) * 2 + 5), new Color(1376256).getRGB());
        GL11.glPopMatrix();
    }
    
    public boolean isMouseOnButton(final int n, final int n2) {
        return n > this.x && n < this.x + 88 && n2 > this.y && n2 < this.y + 12;
    }
    
    public Keybind(final Button parent, final int offset) {
        this.parent = parent;
        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
        this.offset = offset;
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.isMouseOnButton(n, n2) && n3 == 0 && this.parent.open) {
            this.binding = !this.binding;
        }
    }
    
    public void updateComponent(final int n, final int n2) {
        this.hovered = this.isMouseOnButton(n, n2);
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
    }
    
    public void setOff(final int offset) {
        this.offset = offset;
    }
    
    public void keyTyped(final char c, final int key) {
        if (this.binding && key != 211) {
            this.parent.mod.setKey(key);
            this.binding = false;
        }
        else if (this.binding && key == 211) {
            this.parent.mod.setKey(0);
            this.binding = false;
        }
    }
}
