//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component.components.sub;

import yea.clickgui.component.*;
import yea.clickgui.*;
import yea.clickgui.component.components.*;
import java.math.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import com.example.examplemod.*;
import com.example.examplemod.Utils.Value.UI.*;
import com.example.examplemod.Utils.*;
import org.lwjgl.opengl.*;
import font.*;

public class Slider extends Component
{
    private double renderWidth;
    private Setting set;
    private boolean dragging;
    private int offset;
    private int x;
    private int y;
    private Button parent;
    private boolean hovered;
    
    private static double roundToPlace(final double val, final int newScale) {
        if (newScale < 0) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(val).setScale(newScale, RoundingMode.HALF_UP).doubleValue();
    }
    
    public boolean isMouseOnButtonD(final int n, final int n2) {
        return n > this.x && n < this.x + (this.parent.parent.getWidth() / 2 + 1) && n2 > this.y && n2 < this.y + 12;
    }
    
    public void mouseReleased(final int n, final int n2, final int n3) {
        this.dragging = false;
    }
    
    public void renderComponent() {
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth(), this.parent.parent.getY() + this.offset + 12, new Color(12959422).getRGB());
        final int n = (int)(this.set.getValDouble() / this.set.getMax() * this.parent.parent.getWidth());
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX(), this.parent.parent.getY() + this.offset + 12, new Color(16777215).getRGB());
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset + 8, this.parent.parent.getX() + 88, this.parent.parent.getY() + this.offset + 12, Color.GRAY.darker().darker().darker().getRGB());
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset + 8, this.parent.parent.getX() + (int)this.renderWidth, this.parent.parent.getY() + this.offset + 12, ExampleMod.instance.settingsManager.getSettingByName("ClickGUI", "Rainbow").getValBoolean() ? ui.rainbow(300) : new Color(3047935).hashCode());
        RenderUtils.drawFilledCircle(this.parent.parent.getX() + (int)this.renderWidth, this.parent.parent.getY() + this.offset + 9, 3.0f, new Color(3));
        RenderUtils.drawFilledCircle(this.parent.parent.getX() + (int)this.renderWidth, this.parent.parent.getY() + this.offset + 9, 2.0f, new Color(3047935));
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        FontUtils.fr.drawString(this.set.getName() + ": " + this.set.getValDouble(), (double)(this.parent.parent.getX() * 2 + 15), (float)((this.parent.parent.getY() + this.offset - 1) * 2 + 5), new Color(23).getRGB());
        GL11.glPopMatrix();
    }
    
    public void updateComponent(final int n, final int n2) {
        this.hovered = (this.isMouseOnButtonD(n, n2) || this.isMouseOnButtonI(n, n2));
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
        final double n3 = Math.min(88, Math.max(0, n - this.x));
        final double min = this.set.getMin();
        final double max = this.set.getMax();
        this.renderWidth = 88.0 * (this.set.getValDouble() - min) / (max - min);
        if (this.dragging) {
            if (n3 == 0.0) {
                this.set.setValDouble(this.set.getMin());
            }
            else {
                this.set.setValDouble(roundToPlace(n3 / 88.0 * (max - min) + min, 2));
            }
        }
    }
    
    public boolean isMouseOnButtonI(final int n, final int n2) {
        return n > this.x + this.parent.parent.getWidth() / 2 && n < this.x + this.parent.parent.getWidth() && n2 > this.y && n2 < this.y + 12;
    }
    
    public void setOff(final int offset) {
        this.offset = offset;
    }
    
    public Slider(final Setting set, final Button parent, final int offset) {
        this.dragging = false;
        this.set = set;
        this.parent = parent;
        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
        this.offset = offset;
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.isMouseOnButtonD(n, n2) && n3 == 0 && this.parent.open) {
            this.dragging = true;
        }
        if (this.isMouseOnButtonI(n, n2) && n3 == 0 && this.parent.open) {
            this.dragging = true;
        }
    }
}
