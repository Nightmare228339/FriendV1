//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component.components;

import com.example.examplemod.keys.Module.*;
import yea.clickgui.component.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import font.*;
import com.example.examplemod.*;
import com.example.examplemod.Utils.Value.UI.*;
import net.minecraft.util.*;
import com.example.examplemod.Utils.*;
import java.util.*;
import net.minecraft.client.*;
import yea.clickgui.*;
import yea.clickgui.component.components.sub.*;

public class Button extends Component
{
    public Module mod;
    public int height;
    public int offset;
    private ArrayList subcomponents;
    public FontRenderer fr;
    public boolean open;
    private boolean isHovered;
    public Frame parent;
    
    public void renderComponent() {
        Gui.drawRect(this.parent.getX(), this.parent.getY() + this.offset, this.parent.getX() + this.parent.getWidth(), this.parent.getY() + 12 + this.offset, this.isHovered ? new Color(16777215).getRGB() : new Color(16777215).getRGB());
        FontUtils_button.fr.drawString(this.mod.getName(), (double)(this.parent.getX() + 5), (float)(this.parent.getY() + this.offset + 6), this.mod.isEnabled() ? (ExampleMod.instance.settingsManager.getSettingByName("ClickGUI", "Rainbow").getValBoolean() ? ui.rainbow(300) : new Color(3047935).hashCode()) : new Color(7105644).getRGB());
        if (this.subcomponents.size() >= 2) {
            RenderUtils.drawImage(new ResourceLocation("textures/trio-two.png"), this.parent.getX() + this.parent.getWidth() - 10, this.parent.getY() + this.offset + 1, 10, 10);
        }
        if (this.open && !this.subcomponents.isEmpty()) {
            final Iterator<Component> iterator = this.subcomponents.iterator();
            while (iterator.hasNext()) {
                iterator.next().renderComponent();
            }
        }
    }
    
    public int getHeight() {
        if (this.open) {
            return 12 * (this.subcomponents.size() + 1);
        }
        return 12;
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        if (this.isMouseOnButton(n, n2) && n3 == 0) {
            this.mod.toggle();
        }
        if (this.isMouseOnButton(n, n2) && n3 == 1) {
            this.open = !this.open;
            this.parent.refresh();
        }
        final Iterator<Component> iterator = this.subcomponents.iterator();
        while (iterator.hasNext()) {
            iterator.next().mouseClicked(n, n2, n3);
        }
    }
    
    public void keyTyped(final char c, final int n) {
        final Iterator<Component> iterator = this.subcomponents.iterator();
        while (iterator.hasNext()) {
            iterator.next().keyTyped(c, n);
        }
    }
    
    public void setOff(final int offset) {
        this.offset = offset;
        int off = this.offset + 12;
        final Iterator<Component> iterator = (Iterator<Component>)this.subcomponents.iterator();
        while (iterator.hasNext()) {
            iterator.next().setOff(off);
            off += 12;
        }
    }
    
    public Button(final Module mod, final Frame parent, final int offset) {
        this.fr = Minecraft.getMinecraft().fontRenderer;
        this.mod = mod;
        this.parent = parent;
        this.offset = offset;
        this.height = 12;
        this.subcomponents = new ArrayList();
        this.open = false;
        int n = offset + 12;
        if (ExampleMod.instance.settingsManager.getSettingsByMod(mod) != null) {
            for (final Setting setting : ExampleMod.instance.settingsManager.getSettingsByMod(mod)) {
                if (setting.isCombo()) {
                    this.subcomponents.add(new ModeButton(setting, this, mod, n));
                    n += 12;
                }
                if (setting.isSlider()) {
                    this.subcomponents.add(new Slider(setting, this, n));
                    n += 12;
                }
                if (setting.isCheck()) {
                    this.subcomponents.add(new Checkbox(setting, this, n));
                    n += 12;
                }
            }
        }
        this.subcomponents.add(new Keybind(this, n));
    }
    
    public boolean isMouseOnButton(final int n, final int n2) {
        return n > this.parent.getX() && n < this.parent.getX() + this.parent.getWidth() && n2 > this.parent.getY() + this.offset && n2 < this.parent.getY() + 12 + this.offset;
    }
    
    public void mouseReleased(final int n, final int n2, final int n3) {
        final Iterator<Component> iterator = this.subcomponents.iterator();
        while (iterator.hasNext()) {
            iterator.next().mouseReleased(n, n2, n3);
        }
    }
    
    public void updateComponent(final int n, final int n2) {
        this.isHovered = this.isMouseOnButton(n, n2);
        if (!this.subcomponents.isEmpty()) {
            final Iterator<Component> iterator = this.subcomponents.iterator();
            while (iterator.hasNext()) {
                iterator.next().updateComponent(n, n2);
            }
        }
    }
}
