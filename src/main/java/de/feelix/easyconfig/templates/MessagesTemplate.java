package de.feelix.easyconfig.templates;

import de.feelix.easyconfig.PluginConfig;
import de.feelix.easyconfig.utils.TextUtils;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Class to create a MessagesConfig
 */
public abstract class MessagesTemplate extends PluginConfig {

    /**
     * Reference to the Prefix
     */
    protected final String prefixVariable;

    /**
     * Constructor of MessagesTemplate
     *
     * @param plugin reference to the Plugin
     */
    public MessagesTemplate(@NotNull Plugin plugin) {
        this(plugin, "", null);
    }

    /**
     * Constructor of MessagesTemplate
     *
     * @param plugin     reference to the Plugin
     * @param folderName the folderName
     */
    public MessagesTemplate(@NotNull Plugin plugin, @NotNull String folderName) {
        this(plugin, folderName, null);
    }

    /**
     * Constructor of MessagesTemplate
     *
     * @param plugin         reference to the Plugin
     * @param folderName     the folderName
     * @param prefixVariable the prefixVariable
     */
    public MessagesTemplate(@NotNull Plugin plugin, @NotNull String folderName, @Nullable String prefixVariable) {
        super(plugin, folderName, "messages");
        this.prefixVariable = Objects.requireNonNull(prefixVariable, "%prefix%");
    }

    @Override
    public void addDefault() {
        this.add("prefix", plugin.getDescription().getName() + " §7>>");
        this.add("load", "%prefix% §6Plugin load§7...");
        this.add("enable", "%prefix% §aPlugin enabled");
        this.add("disable", "%prefix% §cPlugin disabled");
        addOtherMessages();
    }

    /**
     * Prepared Method to add other Messages
     */
    protected abstract void addOtherMessages();


    /**
     * Getter for the Prefix
     *
     * @return the Prefix
     */
    public String getPrefix() {
        return this.getFromConfig("prefix");
    }

    /**
     * Getter for the LoadMessage
     *
     * @return the LoadMessage as a Component
     */
    public TextComponent getLoadComponent() {
        return TextUtils.checkOther(this.getFromConfig("load"), prefixVariable, this.getPrefix()).asComponent();
    }

    /**
     * Getter for the LoadMessage
     *
     * @return the LoadMessage as a String
     */
    public String getLoadString() {
        return TextUtils.checkOther(this.getFromConfig("load"), prefixVariable, this.getPrefix()).asString();
    }

    /**
     * Getter for the EnableMessage
     *
     * @return the EnableMessage as a Component
     */
    public TextComponent getEnableComponent() {
        return TextUtils.checkOther(this.getFromConfig("enable"), prefixVariable, this.getPrefix()).asComponent();
    }

    /**
     * Getter for the EnableMessage
     *
     * @return the EnableMessage as a String
     */
    public String getEnableString() {
        return TextUtils.checkOther(this.getFromConfig("enable"), prefixVariable, this.getPrefix()).asString();
    }

    /**
     * Getter for the DisableMessage
     *
     * @return the DisableMessage as a Component
     */
    public TextComponent getDisableComponent() {
        return TextUtils.checkOther(this.getFromConfig("disable"), prefixVariable, this.getPrefix()).asComponent();
    }

    /**
     * Getter for the DisableMessage
     *
     * @return the DisableMessage as a String
     */
    public String getDisableString() {
        return TextUtils.checkOther(this.getFromConfig("disable"), "%prefix%", this.getPrefix()).asString();
    }
}
