//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils.Value;

public class Value
{
    private String name;
    private Object defaultValue;
    public Object value;
    
    public Object getValue() {
        return this.value;
    }
    
    public void setValue(final Object value) {
        this.value = value;
    }
    
    public Object getDefaultValue() {
        return this.defaultValue;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Value(final String name, final Object o) {
        this.name = name;
        this.defaultValue = o;
        this.value = o;
    }
}
