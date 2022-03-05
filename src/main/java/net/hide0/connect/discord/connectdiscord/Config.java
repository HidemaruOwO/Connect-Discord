package net.hide0.connect.discord.connectdiscord;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
    private static Plugin plugin = null;
    private static FileConfiguration config = null;

    public Config(Plugin plugin) {
        Config.plugin = plugin;
        // ロードする
        load();
    }

    /**
     * 設定をロードします
     */
    public static void load() {
        // 設定ファイルを保存
        plugin.saveDefaultConfig();
        if (config != null) { // configが非null == リロードで呼び出された
            plugin.reloadConfig();
        }
        if (config == null) {
            config.set("token", "Discord BotのTokenを入力してください");
            config.set("channelId", "ゲームチャットと連携させるテキストチャンネルのIDを入力してください");
            config.set("webhookUrl", "Botが自動で入力します");
            plugin.saveDefaultConfig();
        }
        config = plugin.getConfig();
    }

    public static String getToken() {
        return config.getString("token");
    }

    public static String getChannelId() {
        return config.getString("channelId");
    }

    public static String getWebhookUrl() {
        return config.getString("webhookUrl");
    }
    public static void setWebhookUrl(String URL) {
        config.set("webhookUrl",URL);
        load();
    }
}
