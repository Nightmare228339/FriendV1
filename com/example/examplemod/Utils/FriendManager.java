//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.example.examplemod.Utils;

import java.util.*;

public class FriendManager
{
    public static boolean doCheck;
    private static ArrayList friends;
    
    static {
        FriendManager.doCheck = false;
        FriendManager.friends = new ArrayList();
    }
    
    public static void toggleFriend(final UUID uuid) {
        if (isFriend(uuid)) {
            removeFriend(uuid);
        }
        else {
            addFriend(uuid);
        }
    }
    
    public static void clearFriends() {
        FriendManager.friends.clear();
    }
    
    public static int getNumFriends() {
        return FriendManager.friends.size();
    }
    
    public static void addFriend(final UUID e) {
        FriendManager.friends.add(e);
    }
    
    public static boolean isFriend(final UUID uuid) {
        if (FriendManager.doCheck) {
            final Iterator<UUID> iterator = FriendManager.friends.iterator();
            while (iterator.hasNext()) {
                if (uuid == iterator.next()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void removeFriend(final UUID uuid) {
        for (int i = 0; i < FriendManager.friends.size(); ++i) {
            if (FriendManager.friends.get(i) == uuid) {
                FriendManager.friends.remove(i);
            }
        }
    }
}
