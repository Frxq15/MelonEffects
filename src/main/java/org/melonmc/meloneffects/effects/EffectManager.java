package org.melonmc.meloneffects.effects;

import org.bukkit.entity.Player;
import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.effects.killeffects.LightningEffect;

public class EffectManager {
    private LightningEffect lightningEffect;
    private final MelonEffects plugin;

    public EffectManager(MelonEffects plugin) {
        this.plugin = plugin;
    }
    public void registerEffects() {
        lightningEffect = new LightningEffect(plugin);
    }
    public void perform(Player player, KillEffect killEffect) {
        switch(killEffect.name().toUpperCase()) {
            case "LIGHTNING":
                getLightningEffect().performEffect(player);
        }
    }
    public LightningEffect getLightningEffect() { return lightningEffect; }

}
