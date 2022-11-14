//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui.component;

import java.util.*;
import java.awt.*;
import com.example.examplemod.Utils.*;
import com.example.examplemod.Utils.Value.UI.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import font.*;
import com.example.examplemod.*;
import com.example.examplemod.keys.Module.*;
import yea.clickgui.component.components.*;

public class Frame
{
    public Module$Category category;
    public int dragY;
    private int x;
    public int dragX;
    private boolean open;
    private int width;
    public ArrayList components;
    private boolean isDragging;
    private int y;
    public static int color;
    private int barHeight;
    
    public boolean isOpen() {
        return this.open;
    }
    
    public void refresh() {
        int barHeight = this.barHeight;
        for (final Component component : this.components) {
            component.setOff(barHeight);
            barHeight += component.getHeight();
        }
    }
    
    public void renderFrame(final FontRenderer fontRenderer) {
        RenderUtils.drawFilledCircle(this.x + 1, this.y + 6, 7.2f, new Color(-1381654));
        RenderUtils.drawFilledCircle(this.x + 85, this.y + 6, 7.2f, new Color(-1381654));
        Gui.drawRect(this.x, this.y - 1, this.x + this.width, this.y, ExampleMod.instance.settingsManager.getSettingByName("ClickGUI", "Rainbow").getValBoolean() ? ui.rainbow(300) : new Color(-1381654, true).hashCode());
        Gui.drawRect(this.x, this.y, this.x + this.width, this.y + 13, ExampleMod.instance.settingsManager.getSettingByName("ClickGUI", "Rainbow").getValBoolean() ? ui.rainbow(300) : new Color(-1381654, true).hashCode());
        RenderUtils.drawImage(new ResourceLocation("textures/two.png"), this.x + 10, this.y - 2, 17, 17);
        Font_Modules.fr.drawString(this.category.name(), (double)(this.x + 30), (float)(this.y + 2), new Color(23).getRGB());
        if (this.open && !this.components.isEmpty()) {
            final Iterator<Component> iterator = this.components.iterator();
            while (iterator.hasNext()) {
                iterator.next().renderComponent();
            }
        }
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public boolean isWithinHeader(final int n, final int n2) {
        return n >= this.x && n <= this.x + this.width && n2 >= this.y && n2 <= this.y + this.barHeight;
    }
    
    public void updatePosition(final int n, final int n2) {
        if (this.isDragging) {
            this.setX(n - this.dragX);
            this.setY(n2 - this.dragY);
        }
    }
    
    public void setDrag(final boolean isDragging) {
        this.isDragging = isDragging;
    }
    
    public Frame(final Module$Category category) {
        this.components = new ArrayList();
        this.category = category;
        this.width = 88;
        this.x = 0;
        this.y = 60;
        this.dragX = 0;
        this.barHeight = 12;
        this.open = false;
        this.isDragging = false;
        int barHeight = this.barHeight;
        final Iterator<Module> iterator = Client.getModulesInCategory(this.category).iterator();
        while (iterator.hasNext()) {
            this.components.add(new Button((Module)iterator.next(), this, barHeight));
            barHeight += 12;
        }
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setOpen(final boolean open) {
        this.open = open;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public ArrayList getComponents() {
        return this.components;
    }
}
