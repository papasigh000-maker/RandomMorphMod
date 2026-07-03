package com.randommorph.event;

import com.randommorph.config.RandomMorphConfig;
import com.randommorph.util.MobSoundMap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import java.util.Random;

@Mod.EventBusSubscriber(modid = "randommorph", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RandomMorphHandler {
    
    private static final String MORPH_TIMER_TAG = "RandomMorphTimer";
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) {
            return;
        }

        Player player = event.player;
        CompoundTag data = player.getPersistentData();
        int timer = data.getInt(MORPH_TIMER_TAG);

        int morphIntervalTicks = RandomMorphConfig.SERVER.morphInterval.get() * 20 * 60;

        timer++;

        if (timer >= morphIntervalTicks) {
            morphToRandomMob(player);
            timer = 0;
        }

        data.putInt(MORPH_TIMER_TAG, timer);
    }

    private static void morphToRandomMob(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            String[] remorphedMobs = MobSoundMap.getAvailableMobs();
            
            if (remorphedMobs.length == 0) {
                return;
            }

            String randomMob = remorphedMobs[RANDOM.nextInt(remorphedMobs.length)];
            
            executeMorphCommand(serverPlayer, randomMob);
            
            if (RandomMorphConfig.SERVER.enableParticles.get()) {
                playMorphParticles(serverPlayer);
            }
            
            if (RandomMorphConfig.SERVER.enableSounds.get()) {
                playMorphSound(serverPlayer, randomMob);
            }
            
            if (RandomMorphConfig.SERVER.enableMessages.get()) {
                sendMorphMessage(serverPlayer, randomMob);
            }
        }
    }

    private static void executeMorphCommand(ServerPlayer player, String mobId) {
        try {
            player.getServer().getCommands().performCommand(
                player.createCommandSourceStack(),
                "morph " + mobId
            );
        } catch (Exception e) {
            // Fallback
        }
    }

    private static void playMorphParticles(ServerPlayer player) {
        RandomMorphConfig.ParticleType particleType = RandomMorphConfig.SERVER.particleType.get();
        
        for (int i = 0; i < 20; i++) {
            double offsetX = (RANDOM.nextDouble() - 0.5) * 2;
            double offsetY = RANDOM.nextDouble() * 2;
            double offsetZ = (RANDOM.nextDouble() - 0.5) * 2;

            var particleOptions = getParticleType(particleType);

            player.serverLevel().sendParticles(
                particleOptions,
                player.getX() + offsetX,
                player.getY() + offsetY,
                player.getZ() + offsetZ,
                1,
                0, 0, 0,
                0.5
            );
        }
    }

    private static net.minecraft.core.particles.ParticleOptions getParticleType(RandomMorphConfig.ParticleType type) {
        return switch (type) {
            case WITCH -> net.minecraft.core.particles.ParticleTypes.WITCH;
            case CRIMSON_SPORE -> net.minecraft.core.particles.ParticleTypes.CRIMSON_SPORE;
            case MYCELIUM -> net.minecraft.core.particles.ParticleTypes.MYCELIUM;
            case SOUL -> net.minecraft.core.particles.ParticleTypes.SOUL;
            case HAPPY_VILLAGER -> net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER;
            case EXPLOSION -> net.minecraft.core.particles.ParticleTypes.EXPLOSION;
            case PORTAL -> net.minecraft.core.particles.ParticleTypes.PORTAL;
            case ENCHANT -> net.minecraft.core.particles.ParticleTypes.ENCHANT;
        };
    }

    private static void playMorphSound(ServerPlayer player, String mobId) {
        var soundEvent = MobSoundMap.getMobSound(mobId);
        
        if (soundEvent != null) {
            player.serverLevel().playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                soundEvent,
                SoundSource.PLAYERS,
                1.0f,
                1.0f
            );
        }
    }

    private static void sendMorphMessage(ServerPlayer player, String mobId) {
        String mobName = formatMobName(mobId);
        player.displayClientMessage(
            Component.literal("§6[Random Morph] §rYou morphed into a §c" + mobName + "§r!"),
            false
        );
    }

    private static String formatMobName(String mobId) {
        String[] parts = mobId.split(":");
        String name = parts[parts.length - 1];
        return name.substring(0, 1).toUpperCase() + name.substring(1).replace("_", " ");
    }
}