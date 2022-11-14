//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui;

import net.minecraft.client.gui.*;
import java.util.*;

public class Effect
{
    private int _fallingSpeed;
    private int _y;
    private int _x;
    private int _size;
    
    public int getX() {
        return this._x;
    }
    
    public void setX(final int x) {
        this._x = x;
    }
    
    public void Update(final ScaledResolution scaledResolution) {
        Gui.drawRect(this.getX(), this.getY(), this.getX() + this._size, this.getY() + this._size, -1714829883);
        this.setY(this.getY() + this._fallingSpeed);
        if (this.getY() > scaledResolution.getScaledHeight() + 10 || this.getY() < -10) {
            this.setY(-10);
            final Random random = new Random();
            this._fallingSpeed = random.nextInt(10) + 1;
            this._size = random.nextInt(4) + 1;
        }
    }
    
    public Effect(final int x, final int y, final int fallingSpeed, final int size) {
        this._x = x;
        this._y = y;
        this._fallingSpeed = fallingSpeed;
        this._size = size;
    }
    
    public int getY() {
        return this._y;
    }
    
    public void setY(final int y) {
        this._y = y;
    }
}
