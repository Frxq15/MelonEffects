package org.melonmc.meloneffects.effects;

import org.bukkit.entity.Player;

public abstract class Effect {

    public Effect() {}

    public abstract String getName();

    public abstract void performEffect(Player p);


}
