package de.feelix.easyconfig.templates;

import de.feelix.easyconfig.PluginConfig;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Class to create a PlayerTemplate
 */
public abstract class PlayerTemplate extends PluginConfig {

    /**
     * Default Constructor
     * @param plugin the Plugin
     */
    public PlayerTemplate(@NotNull Plugin plugin) {
        super(plugin, "players");
    }

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param folderName the name of the Folder
     */
    public PlayerTemplate(@NotNull Plugin plugin, @NotNull String folderName) {
        super(plugin, folderName, "players");
    }

    /**
     * Prepared Method to add a Player to the Config
     * @param player the Player
     */
    public abstract void addPlayer(@NotNull ProxiedPlayer player);

    /**
     * Prepared Method to remove a Player from a Config
     * @param player the Player
     */
    public abstract void removePlayer(@NotNull ProxiedPlayer player);


    /**
     * Prepared Method to add one or more Players
     * @param players the players
     */
    protected void addPlayers(@NotNull ProxiedPlayer... players) {
        Arrays.asList(players).forEach(this::addPlayer);
    }

    /**
     * Prepared Method to add one or more Players
     * @param players the players
     */
    protected void addPlayers(@NotNull List<ProxiedPlayer> players) {
        players.forEach(this::addPlayer);
    }

    /**
     * Prepared Method to add all OnlinePlayers
     */
    protected void addOnlinePlayer() {
        ProxyServer.getInstance().getPlayers().forEach(this::addPlayer);
    }

    /**
     * Prepared Method to remove one or more players
     * @param players the Players
     */
    protected void removePlayers(@NotNull ProxiedPlayer... players) {
        Arrays.asList(players).forEach(this::removePlayer);
    }

    /**
     * Prepared Method to remove one or more players
     * @param players the Players
     */
    protected void removePlayers(@NotNull List<ProxiedPlayer> players) {
        players.forEach(this::removePlayer);
    }

    /**
     * Method to override the original Add Method
     * @param player the Player
     * @param key the Key
     * @param value the Value
     */
    protected void add(@NotNull ProxiedPlayer player, @NotNull String key, @NotNull Object value) {
        super.add(player.getUniqueId() + "." + key, value);
    }
    /**
     * Method to override the original Set Method
     * @param player the Player
     * @param key the Key
     * @param value the Value
     */
    protected void set(@NotNull ProxiedPlayer player, @NotNull String key, @NotNull Object value) {
        super.set(player.getUniqueId() + "." + key, value);
    }

    /**
     * Method to override the original AddAndSet Method
     * @param player the Player
     * @param key the Key
     * @param value the Value
     */
    protected void addAndSet(@NotNull ProxiedPlayer player, @NotNull String key, @NotNull Object value) {
        super.addAndSet(player.getUniqueId() + "." + key, value);
    }



    /**
     * Method to override the original Remove Method
     * @param player the Player
     * @param key the Key
     */
    protected void remove(@NotNull ProxiedPlayer player, @NotNull String key) {
        super.remove(player.getUniqueId() + "." + key);
    }
}
