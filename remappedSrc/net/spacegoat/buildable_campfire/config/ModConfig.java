package net.spacegoat.buildable_campfire.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.util.Formatting;
import net.spacegoat.buildable_campfire.ModMain;

@Config(name = ModMain.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/oak_log.png")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Excluded
    private transient static boolean registered = false;
    public static synchronized ModConfig getConfig() {
        if (!registered) {
            AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
            registered = true;
        }
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    @ConfigEntry.Gui.TransitiveObject
    public Gameplay Gameplay = new Gameplay();
    public static class Gameplay{
        @Comment("Players can pick Campfire Logs by right-clicking them with ")
        public boolean campfireLogsArePickable = true;
        @Comment("Plays a sound effect when you pick a Campfire Log.")
        public boolean playSoundWhenCampfireLogGetsPicked = true;
        @Comment("Deletes Campfire and Soul Campfire Blocks' recipes, so you will need to build them instead.")
        public boolean deleteCampfireBlockRecipes = true;
        @Comment("Campfire Logs Block will drop its item form depending on how much log it has.")
        public boolean enableCampfireLogDrops = true;
        public boolean enableChoppingLogs = true;
        @Comment("You can use any log on a Stone Cutter to craft 2 Campfire Logs")
        public boolean enableLogToCampfireLogRecipes = true;
        @Comment("Shows a text under the item's name explaining the use of the Campfire Log.")
        public boolean enableItemTooltip = true;
        @Comment("The tooltip itself. Leave empty/null if you want it to be default.")
        public String tooltip = null;
        @Comment("The color of the tooltip text.")
        public Formatting tooltipColor = Formatting.GRAY;
        @Comment("The amount of light Campfire Log gives off to its surroundings.")
        public int campfireLogLuminance = 0;
    }
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("campfire_block")
    public CampfireBlock CampfireBlock = new CampfireBlock();
    public static class CampfireBlock {
        public boolean enableBuildableCampfire = true;
        @Comment("Should your Campfire be lit when you build it?")
        public boolean campfireIsLitWhenBuild = false;
        @Comment("Plays a sound effect when you right-click a finished Campfire Template with a coal or charcoal.")
        public boolean playSoundEffect = true;
        @Comment("The amount of Coal/Charcoal you will need to build a Campfire.")
        public int howMuchCoalBuildingACampfireTakes = 1;
    }
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("soul_campfire_block")
    public SoulCampfireBlock SoulCampfireBlock = new SoulCampfireBlock();
    public static class SoulCampfireBlock {
        public boolean enableBuildableSoulCampfire = true;
        @Comment("Should your Soul Campfire be lit when you build it?")
        public boolean soulCampfireIsLitWhenBuild = false;
        @Comment("Plays a sound effect when you right-click a finished Campfire Template with Soul Sand.")
        public boolean playSoundEffect = true;
        @Comment("The amount of Soul Sand you will need to build a Soul Campfire.")
        public int howMuchSoulSandBuildingASoulCampfireTakes = 1;
    }
}