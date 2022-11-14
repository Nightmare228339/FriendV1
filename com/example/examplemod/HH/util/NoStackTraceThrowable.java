//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.HH.util;

import com.example.examplemod.*;

public class NoStackTraceThrowable extends RuntimeException
{
    @Override
    public String toString() {
        return "" + ExampleMod.getVersion();
    }
    
    public NoStackTraceThrowable(final String message) {
        super(message);
        this.setStackTrace(new StackTraceElement[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
