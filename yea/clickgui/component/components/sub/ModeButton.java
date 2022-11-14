//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component.components.sub;

import yea.clickgui.component.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.*;
import yea.clickgui.component.components.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import font.*;

public class ModeButton extends Component
{
    private int x;
    private boolean hovered;
    private Module mod;
    private Setting set;
    private int y;
    private Button parent;
    private int offset;
    private int modeIndex;
    
    public void updateComponent(final int n, final int n2) {
        this.hovered = this.isMouseOnButton(n, n2);
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
    }
    
    public void setOff(final int offset) {
        this.offset = offset;
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.isMouseOnButton(n, n2) && n3 == 0 && this.parent.open) {
            if (this.modeIndex + 1 >= this.set.getOptions().size()) {
                this.modeIndex = 0;
            }
            else {
                ++this.modeIndex;
            }
            this.set.setValString(this.set.getOptions().get(this.modeIndex));
        }
    }
    
    public void renderComponent() {
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth() * 1, this.parent.parent.getY() + this.offset + 12, this.hovered ? new Color(12959422).getRGB() : new Color(12959422).getRGB());
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        FontUtils.fr.drawString(this.set.getTitle() + ": " + this.set.getOptions().get(this.modeIndex), (double)((this.parent.parent.getX() + 7) * 2), (float)((this.parent.parent.getY() + this.offset + 2) * 2 + 5), new Color(23).getRGB());
        GL11.glPopMatrix();
    }
    
    public ModeButton(final Setting set, final Button parent, final Module mod, final int offset) {
        this.set = set;
        this.parent = parent;
        this.mod = mod;
        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
        this.offset = offset;
        this.modeIndex = 0;
        set.setValString(set.getOptions().get(0));
    }
    
    public boolean isMouseOnButton(final int n, final int n2) {
        return n > this.x && n < this.x + 88 && n2 > this.y && n2 < this.y + 12;
    }
}
