package com.randommorph.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class RandomMorphConfig {
    public static final ForgeConfigSpec SERVER_CONFIG;
    public static final ServerConfig SERVER;

    static {
        Pair<ServerConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER = pair.getLeft();
        SERVER_CONFIG = pair.getRight();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.IntValue morphInterval;
        public final ForgeConfigSpec.EnumValue<ParticleType> particleType;
        public final ForgeConfigSpec.BooleanValue enableParticles;
        public final ForgeConfigSpec.BooleanValue enableSounds;
        public final ForgeConfigSpec.BooleanValue enableMessages;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Random Morph Configuration").push("general");

            morphInterval = builder
                .comment("Time between morphs in minutes (default: 5)")
                .defineInRange("morphInterval", 5, 1, 60);

            particleType = builder
                .comment("Particle type: WITCH, CRIMSON_SPORE, MYCELIUM, SOUL, HAPPY_VILLAGER, EXPLOSION, PORTAL, ENCHANT")
                .defineEnum("particleType", ParticleType.WITCH);

            enableParticles = builder
                .comment("Enable particle effects on morph")
                .define("enableParticles", true);

            enableSounds = builder
                .comment("Enable mob-specific sounds on morph")
                .define("enableSounds", true);

            enableMessages = builder
                .comment("Enable chat messages when morphing")
                .define("enableMessages", true);

            builder.pop();
        }
    }

    public enum ParticleType {
        WITCH,
        CRIMSON_SPORE,
        MYCELIUM,
        SOUL,
        HAPPY_VILLAGER,
        EXPLOSION,
        PORTAL,
        ENCHANT
    }
}