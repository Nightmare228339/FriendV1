//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component.components.sub;

import yea.clickgui.component.*;
import yea.clickgui.*;
import yea.clickgui.component.components.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import font.*;
import com.example.examplemod.Utils.*;

public class Checkbox extends Component
{
    private int offset;
    private int y;
    private boolean hovered;
    private Setting op;
    private Button parent;
    private int x;
    
    public void updateComponent(final int n, final int n2) {
        this.hovered = this.isMouseOnButton(n, n2);
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.isMouseOnButton(n, n2) && n3 == 0 && this.parent.open) {
            this.op.setValBoolean(!this.op.getValBoolean());
        }
    }
    
    public Checkbox(final Setting op, final Button parent, final int offset) {
        this.op = op;
        this.parent = parent;
        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
        this.offset = offset;
    }
    
    public void renderComponent() {
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth() * 1, this.parent.parent.getY() + this.offset + 12, this.hovered ? new Color(12959422).getRGB() : new Color(12959422).getRGB());
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        FontUtils.fr.drawString(this.op.getName(), (double)((this.parent.parent.getX() + 10 + 4) * 2 + 5), (float)((this.parent.parent.getY() + this.offset + 2) * 2 + 4), new Color(21).getRGB());
        GL11.glPopMatrix();
        if (this.op.getValBoolean()) {
            RenderUtils.drawFilledCircle(this.parent.parent.getX() + 4 + 4, this.parent.parent.getY() + this.offset + 7, 3.0f, new Color(23));
            RenderUtils.drawFilledCircle(this.parent.parent.getX() + 4 + 4, this.parent.parent.getY() + this.offset + 7, 2.0f, new Color(5089518));
        }
        else {
            RenderUtils.drawFilledCircle(this.parent.parent.getX() + 4 + 4, this.parent.parent.getY() + this.offset + 7, 3.0f, new Color(23));
        }
    }
    
    public boolean isMouseOnButton(final int n, final int n2) {
        return n > this.x && n < this.x + 88 && n2 > this.y && n2 < this.y + 12;
    }
    
    public void setOff(final int offset) {
        this.offset = offset;
    }
}
