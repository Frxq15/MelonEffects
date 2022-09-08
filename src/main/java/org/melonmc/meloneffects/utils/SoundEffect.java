package org.melonmc.meloneffects.utils;

import org.bukkit.Sound;

public enum SoundEffect {
    NONE(Sound.AMBIENCE_CAVE),
    EXPLOSION(Sound.EXPLODE),
    FALL(Sound.FALL_BIG),
    HORSE(Sound.HORSE_HIT),
    SKELETON(Sound.SKELETON_DEATH),
    ORB(Sound.ORB_PICKUP),
    LEVELUP(Sound.LEVEL_UP),
    PLING(Sound.NOTE_PLING),
    PIANO(Sound.NOTE_PIANO),
    PICKUP(Sound.ITEM_PICKUP),
    GOLEM(Sound.IRONGOLEM_DEATH),
    CREEPER(Sound.CREEPER_HISS),
    ANVIL(Sound.ANVIL_LAND),
    BAT(Sound.BAT_DEATH),
    //6 more
    FIREWORK(Sound.FIREWORK_BLAST),
    FIREBALL(Sound.GHAST_FIREBALL),
    OINK(Sound.PIG_DEATH),
    WITHER(Sound.WITHER_DEATH),
    ZOMBIE(Sound.ZOMBIE_DEATH),
    VILLAGER(Sound.VILLAGER_HIT),
    DRAGON(Sound.ENDERDRAGON_GROWL);

    private final Sound sound;

    SoundEffect(Sound sound) {
        this.sound = sound;
    }
    public Sound getSoundEffect() {
        return sound;
    }
}
