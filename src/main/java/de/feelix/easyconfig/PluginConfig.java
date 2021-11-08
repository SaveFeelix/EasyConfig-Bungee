package de.feelix.easyconfig;

import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Default Class to create a PluginConfig
 */
public abstract class PluginConfig extends EasyConfig {

    /**
     * Reference to the Plugin
     */
    protected final Plugin plugin;

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param fileName the name of the File
     */
    public PluginConfig(@NotNull Plugin plugin, @NotNull String fileName) {
        this(plugin, "", fileName);
    }

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param folderName the name of the Folder
     * @param fileName the name of the File
     */
    public PluginConfig(@NotNull Plugin plugin, @NotNull String folderName, @NotNull String fileName) {
        super("plugins/" + plugin.getDescription().getName() + "/" + folderName, fileName);
        this.plugin = plugin;
    }
}
