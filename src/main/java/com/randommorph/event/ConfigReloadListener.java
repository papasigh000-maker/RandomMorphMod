package com.randommorph.event;

import com.randommorph.RandomMorphMod;
import com.randommorph.config.RandomMorphConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;

public class ConfigReloadListener {
    public static void register() {
        ModLoadingContext.getInstance().registerConfig(
            ModConfig.Type.SERVER,
            RandomMorphConfig.SERVER_CONFIG,
            "randommorph-config.toml"
        );
    }
}