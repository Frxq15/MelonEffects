package org.melonmc.meloneffects.effects.killeffects;

import org.bukkit.entity.Player;
import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.effects.Effect;
import org.melonmc.meloneffects.effects.KillEffect;

public class LightningEffect extends Effect {
    private final MelonEffects plugin;
    public LightningEffect(MelonEffects plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return "Lightning";
    }

    @Override
    public void performEffect(Player p) {
        p.getWorld().strikeLightning(p.getLocation());
    }
}
