//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

public class TimeUtils
{
    private long previousTime;
    private long ms;
    
    public long getTime() {
        return System.currentTimeMillis() - this.previousTime;
    }
    
    public short convert(final float n) {
        return (short)(1000.0f / n);
    }
    
    public void reset() {
        this.previousTime = this.getCurrentTime();
    }
    
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
    
    public TimeUtils() {
        this.previousTime = -1L;
        this.ms = this.getCurrentMS();
    }
    
    public boolean hasReached(final float n) {
        return this.getCurrentMS() - this.ms > n;
    }
    
    public long getCurrentMS() {
        return System.currentTimeMillis();
    }
    
    public long get() {
        return this.previousTime;
    }
    
    public boolean check(final float n) {
        return this.getCurrentTime() - this.previousTime >= n;
    }
}
