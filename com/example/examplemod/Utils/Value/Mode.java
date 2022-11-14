//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils.Value;

public class Mode
{
    private String name;
    private boolean toggled;
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public Mode(final String name, final boolean toggled) {
        this.name = name;
        this.toggled = toggled;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
    }
    
    public String getName() {
        return this.name;
    }
}
