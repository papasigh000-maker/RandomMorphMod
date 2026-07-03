package com.randommorph;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;

@Mod("randommorph")
public class RandomMorphMod {
    
    public static final String MOD_ID = "randommorph";
    
    public RandomMorphMod() {
        IEventBus modEventBus = FXModLoadingContext.getInstance().getModEventBus();
        modEventBus.addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        // Client setup
    }
}