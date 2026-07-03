package com.randommorph.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import java.util.HashMap;
import java.util.Map;

public class MobSoundMap {

    private static final Map<String, SoundEvent> MOB_SOUNDS = new HashMap<>();

    static {
        // Hostile mobs
        MOB_SOUNDS.put("minecraft:zombie", SoundEvents.ZOMBIE_AMBIENT);
        MOB_SOUNDS.put("minecraft:skeleton", SoundEvents.SKELETON_AMBIENT);
        MOB_SOUNDS.put("minecraft:creeper", SoundEvents.CREEPER_PRIMED);
        MOB_SOUNDS.put("minecraft:spider", SoundEvents.SPIDER_AMBIENT);
        MOB_SOUNDS.put("minecraft:cave_spider", SoundEvents.CAVE_SPIDER_AMBIENT);
        MOB_SOUNDS.put("minecraft:enderman", SoundEvents.ENDERMAN_AMBIENT);
        MOB_SOUNDS.put("minecraft:witch", SoundEvents.WITCH_AMBIENT);
        MOB_SOUNDS.put("minecraft:wither_skeleton", SoundEvents.SKELETON_AMBIENT);
        MOB_SOUNDS.put("minecraft:stray", SoundEvents.SKELETON_AMBIENT);
        MOB_SOUNDS.put("minecraft:husk", SoundEvents.ZOMBIE_AMBIENT);
        MOB_SOUNDS.put("minecraft:drowned", SoundEvents.DROWNED_AMBIENT);
        MOB_SOUNDS.put("minecraft:zombified_piglin", SoundEvents.ZOMBIFIED_PIGLIN_AMBIENT);
        MOB_SOUNDS.put("minecraft:blaze", SoundEvents.BLAZE_AMBIENT);
        MOB_SOUNDS.put("minecraft:ghast", SoundEvents.GHAST_AMBIENT);
        MOB_SOUNDS.put("minecraft:magma_cube", SoundEvents.MAGMA_CUBE_AMBIENT);
        MOB_SOUNDS.put("minecraft:slime", SoundEvents.SLIME_JUMP);
        MOB_SOUNDS.put("minecraft:piglin", SoundEvents.PIGLIN_AMBIENT);
        MOB_SOUNDS.put("minecraft:piglin_brute", SoundEvents.PIGLIN_BRUTE_AMBIENT);
        MOB_SOUNDS.put("minecraft:warden", SoundEvents.WARDEN_AMBIENT);
        MOB_SOUNDS.put("minecraft:guardian", SoundEvents.GUARDIAN_AMBIENT);
        MOB_SOUNDS.put("minecraft:elder_guardian", SoundEvents.ELDER_GUARDIAN_AMBIENT);
        MOB_SOUNDS.put("minecraft:shulker", SoundEvents.SHULKER_AMBIENT);
        MOB_SOUNDS.put("minecraft:hoglin", SoundEvents.HOGLIN_AMBIENT);
        MOB_SOUNDS.put("minecraft:zoglin", SoundEvents.ZOGLIN_AMBIENT);
        MOB_SOUNDS.put("minecraft:strider", SoundEvents.STRIDER_AMBIENT);

        // Passive mobs
        MOB_SOUNDS.put("minecraft:cow", SoundEvents.COW_AMBIENT);
        MOB_SOUNDS.put("minecraft:pig", SoundEvents.PIG_AMBIENT);
        MOB_SOUNDS.put("minecraft:sheep", SoundEvents.SHEEP_AMBIENT);
        MOB_SOUNDS.put("minecraft:chicken", SoundEvents.CHICKEN_AMBIENT);
        MOB_SOUNDS.put("minecraft:horse", SoundEvents.HORSE_AMBIENT);
        MOB_SOUNDS.put("minecraft:donkey", SoundEvents.DONKEY_AMBIENT);
        MOB_SOUNDS.put("minecraft:mule", SoundEvents.MULE_AMBIENT);
        MOB_SOUNDS.put("minecraft:wolf", SoundEvents.WOLF_AMBIENT);
        MOB_SOUNDS.put("minecraft:cat", SoundEvents.CAT_AMBIENT);
        MOB_SOUNDS.put("minecraft:ocelot", SoundEvents.OCELOT_AMBIENT);
        MOB_SOUNDS.put("minecraft:rabbit", SoundEvents.RABBIT_AMBIENT);
        MOB_SOUNDS.put("minecraft:bat", SoundEvents.BAT_AMBIENT);
        MOB_SOUNDS.put("minecraft:fox", SoundEvents.FOX_AMBIENT);
        MOB_SOUNDS.put("minecraft:panda", SoundEvents.PANDA_AMBIENT);
        MOB_SOUNDS.put("minecraft:polar_bear", SoundEvents.POLAR_BEAR_AMBIENT);
        MOB_SOUNDS.put("minecraft:bee", SoundEvents.BEE_AMBIENT);
        MOB_SOUNDS.put("minecraft:cod", SoundEvents.COD_AMBIENT);
        MOB_SOUNDS.put("minecraft:salmon", SoundEvents.SALMON_AMBIENT);
        MOB_SOUNDS.put("minecraft:squid", SoundEvents.SQUID_AMBIENT);
        MOB_SOUNDS.put("minecraft:dolphin", SoundEvents.DOLPHIN_AMBIENT);
        MOB_SOUNDS.put("minecraft:tropical_fish", SoundEvents.TROPICAL_FISH_AMBIENT);

        // NPCs
        MOB_SOUNDS.put("minecraft:villager", SoundEvents.VILLAGER_AMBIENT);
        MOB_SOUNDS.put("minecraft:wandering_trader", SoundEvents.WANDERING_TRADER_AMBIENT);
        MOB_SOUNDS.put("minecraft:iron_golem", SoundEvents.IRON_GOLEM_STEP);
        MOB_SOUNDS.put("minecraft:snow_golem", SoundEvents.SNOW_GOLEM_SHOOT);
    }

    public static SoundEvent getMobSound(String mobId) {
        return MOB_SOUNDS.getOrDefault(mobId, SoundEvents.ENCHANTMENT_TABLE_USE);
    }

    public static String[] getAvailableMobs() {
        return new String[]{
            "minecraft:zombie", "minecraft:skeleton", "minecraft:creeper", "minecraft:spider",
            "minecraft:cave_spider", "minecraft:enderman", "minecraft:witch", "minecraft:wither_skeleton",
            "minecraft:stray", "minecraft:husk", "minecraft:drowned", "minecraft:zombified_piglin",
            "minecraft:cow", "minecraft:pig", "minecraft:sheep", "minecraft:chicken", "minecraft:horse",
            "minecraft:donkey", "minecraft:mule", "minecraft:wolf", "minecraft:cat", "minecraft:ocelot",
            "minecraft:rabbit", "minecraft:bat", "minecraft:fox", "minecraft:panda", "minecraft:polar_bear",
            "minecraft:bee", "minecraft:cod", "minecraft:salmon", "minecraft:squid", "minecraft:dolphin",
            "minecraft:tropical_fish", "minecraft:villager", "minecraft:wandering_trader", "minecraft:iron_golem",
            "minecraft:snow_golem", "minecraft:shulker", "minecraft:guardian", "minecraft:elder_guardian",
            "minecraft:slime", "minecraft:magma_cube", "minecraft:blaze", "minecraft:ghast", "minecraft:piglin",
            "minecraft:piglin_brute", "minecraft:strider", "minecraft:hoglin", "minecraft:zoglin", "minecraft:warden"
        };
    }
}