package de.feelix.easyconfig.templates;

import de.feelix.easyconfig.PluginConfig;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Class to create a DataBaseTemplate Config
 */
public abstract class DataBaseTemplate extends PluginConfig {

    /**
     * Default Constructor
     * @param plugin the Plugin
     */
    public DataBaseTemplate(@NotNull Plugin plugin) {
        super(plugin, "database");
    }

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param folderName the folderName
     */
    public DataBaseTemplate(@NotNull Plugin plugin, @NotNull String folderName) {
        super(plugin, folderName, "database");
    }

    @Override
    public void addDefault() {
        this.add("isEnabled", false);
        this.add("host", "yourHost");
        this.add("port", 3306);
        this.add("database", "yourDatabase");
        this.add("user", "yourUser");
        this.add("password", "yourPassword");
        addOtherDefault();
    }

    /**
     * Prepared Method to add other Default Values
     */
    protected abstract void addOtherDefault();

    /**
     * Getter for isEnabled
     * @return isEnabled
     */
    public Boolean isEnabled() {
        return this.getFromConfig("isEnabled");
    }

    /**
     * Setter for isEnabled
     * @param value isEnabled
     */
    public void isEnabled(boolean value) {
        this.set("isEnabled", value);
    }

    /**
     * Getter for the Host
     * @return the Host
     */
    public String getHost() {
        return this.getFromConfig("host");
    }

    /**
     * Setter for the Host
     * @param host the Host
     */
    public void setHost(String host) {
        this.set("host", host);
    }

    /**
     * Getter for the Port
     * @return the Port
     */
    public Integer getPort() {
        return this.getFromConfig("port");
    }

    /**
     * Setter for the Port
     * @param port the Port
     */
    public void setPort(Integer port) {
        this.set("port", port);
    }

    /**
     * Getter for the Database
     * @return the Database
     */
    public String getDatabase() {
        return this.getFromConfig("database");
    }

    /**
     * Setter for the Database
     * @param database the Database
     */
    public void setDatabase(String database) {
        this.set("database", database);
    }

    /**
     * Getter for the User
     * @return the User
     */
    public String getUser() {
        return this.getFromConfig("user");
    }

    /**
     * Setter for the User
     * @param user the User
     */
    public void setUser(String user) {
        this.set("user", user);
    }

    /**
     * Getter for the Password
     * @return the password
     */
    public String getPassword() {
        return this.getFromConfig("password");
    }

    /**
     * Setter for the Password
     * @param password the Password
     */
    public void setPassword(String password) {
        this.set("password", password);
    }
}
