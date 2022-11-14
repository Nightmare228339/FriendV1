//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui;

import java.util.*;
import com.example.examplemod.keys.Module.*;

public class Setting
{
    private ArrayList options;
    private double dval;
    private String name;
    private boolean bval;
    private int color;
    private Module parent;
    private String sval;
    private double max;
    private boolean onlyint;
    private String mode;
    private String text;
    private double min;
    private String title;
    
    public void setValDouble(final double dval) {
        this.dval = dval;
    }
    
    public void setValBoolean(final boolean bval) {
        this.bval = bval;
    }
    
    public boolean isSlider() {
        return this.mode.equalsIgnoreCase("Slider");
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isCheck() {
        return this.mode.equalsIgnoreCase("Check");
    }
    
    public ArrayList getOptions() {
        return this.options;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public double getValDouble() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return this.dval;
    }
    
    public Module getParentMod() {
        return this.parent;
    }
    
    public boolean onlyInt() {
        return this.onlyint;
    }
    
    public boolean isMode() {
        return this.mode.equalsIgnoreCase("ModeButton");
    }
    
    public Setting(final String name, final Module parent, final boolean bval) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.bval = bval;
        this.mode = "Check";
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public double getMin() {
        return this.min;
    }
    
    public String getValString() {
        return this.sval;
    }
    
    public Setting(final String name, final Module parent, final ArrayList options, final String title) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.options = options;
        this.title = title;
        this.mode = "Combo";
    }
    
    public String getString() {
        return this.text;
    }
    
    public void setValString(final String sval) {
        this.sval = sval;
    }
    
    public Setting(final String name, final Module parent, final double dval, final double min, final double max, final boolean onlyint) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.dval = dval;
        this.min = min;
        this.max = max;
        this.onlyint = onlyint;
        this.mode = "Slider";
    }
    
    public double getMax() {
        return this.max;
    }
    
    public boolean isCombo() {
        return this.mode.equalsIgnoreCase("Combo");
    }
    
    public boolean getValBoolean() {
        return this.bval;
    }
}
