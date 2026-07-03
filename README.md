# Random Morph Mod

A Minecraft Forge mod for 1.20.1 that automatically morphs you into a random mob every X minutes using the Remorphed mod!

## ✨ Features

- 🔄 **Automatic Morphing**: Configurable morph interval (1-60 minutes)
- 🎨 **Particle Effects**: Choose from 8 different particle types
- 🔊 **Mob-Specific Sounds**: Each mob plays its unique ambient sound when morphing
- 💬 **Chat Notifications**: Get a message telling you which mob you became
- ⚙️ **Fully Configurable**: Adjust all settings in `randommorph-config.toml`
- 🧟 **50+ Mobs**: Supports all vanilla mobs and compatible with Remorphed's mob registry

## 📥 Installation

### Requirements
- **Minecraft**: 1.20.1
- **Forge**: 47.3.0 or higher
- **Remorphed Mod**: Any recent version

### Steps
1. Download `randommorph-1.0.0.jar` from the [Releases](https://github.com/papasigh000-maker/RandomMorphMod/releases)
2. Place it in your `mods` folder (`%appdata%\.minecraft\mods` on Windows, `~/.minecraft/mods` on Mac/Linux)
3. Launch Minecraft with the Forge profile
4. First run will create `randommorph-config.toml` in your config folder

## ⚙️ Configuration

Edit `config/randommorph-config.toml` to customize:

```toml
[general]
# Time between morphs in minutes (default: 5)
morphInterval = 5

# Particle type: WITCH, CRIMSON_SPORE, MYCELIUM, SOUL, HAPPY_VILLAGER, EXPLOSION, PORTAL, ENCHANT
particleType = "WITCH"

# Enable particle effects on morph
enableParticles = true

# Enable mob-specific sounds on morph
enableSounds = true

# Enable chat messages when morphing
enableMessages = true
```

### Particle Types Available
- **WITCH** - Purple sparkles (default)
- **CRIMSON_SPORE** - Red particles
- **MYCELIUM** - Green spores
- **SOUL** - Blue soul particles
- **HAPPY_VILLAGER** - Green happy particles
- **EXPLOSION** - Explosion effect
- **PORTAL** - Purple portal particles
- **ENCHANT** - Enchanting glow

## 🧟 Supported Mobs (50+)

### Hostile Mobs
Zombie, Skeleton, Creeper, Spider, Cave Spider, Enderman, Witch, Wither Skeleton, Stray, Husk, Drowned, Zombified Piglin, Blaze, Ghast, Magma Cube, Slime, Piglin, Piglin Brute, Warden, Guardian, Elder Guardian, Shulker, Hoglin, Zoglin, Strider

### Passive Mobs
Cow, Pig, Sheep, Chicken, Horse, Donkey, Mule, Wolf, Cat, Ocelot, Rabbit, Bat, Fox, Panda, Polar Bear, Bee, Cod, Salmon, Squid, Dolphin, Tropical Fish, Villager, Wandering Trader, Iron Golem, Snow Golem

## 🎮 How to Use

Simply play normally! The mod automatically:
1. Counts down the configured time interval
2. Transforms you into a random mob
3. Plays the mob's ambient sound
4. Shows particles around you
5. Displays a chat message with the mob name

## 🐛 Troubleshooting

### "You morphed into a..." message but no visual changes?
- Ensure Remorphed mod is installed and working
- Check that you've killed the mob before in-game
- Verify Remorphed is compatible with your mod setup

### Particles not showing?
- Make sure `enableParticles = true` in config
- Check that particles aren't disabled in Minecraft settings

### No sounds?
- Verify `enableSounds = true` in config
- Check your game volume isn't muted

### Morph interval not working?
- Config changes require game restart
- Verify config file syntax is correct

## 📝 License

MIT License - Feel free to use and modify!

## 🤝 Support

For issues, feature requests, or questions, please visit the [GitHub repository](https://github.com/papasigh000-maker/RandomMorphMod)

## 👾 Credits

Created for use with the [Remorphed mod](https://github.com/ToCraft/Remorphed) by ToCraft