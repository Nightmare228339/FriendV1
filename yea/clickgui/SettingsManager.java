//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.clickgui;

import com.example.examplemod.keys.Module.*;
import java.util.*;

public class SettingsManager
{
    private ArrayList settings;
    
    public ArrayList getSettingsByMod(final Module obj) {
        final ArrayList<Setting> list = new ArrayList<Setting>();
        for (final Setting e : this.getSettings()) {
            if (e.getParentMod().equals(obj)) {
                list.add(e);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public Setting getSettingByName(final String b, final String anotherString) {
        for (final Setting setting : this.getSettings()) {
            if (setting.getName().equalsIgnoreCase(anotherString) && Objects.equals(setting.getParentMod().name, b)) {
                return setting;
            }
        }
        return null;
    }
    
    public ArrayList getSettings() {
        return this.settings;
    }
    
    public void rSetting(final Setting e) {
        this.settings.add(e);
    }
    
    public SettingsManager() {
        this.settings = new ArrayList();
    }
}
