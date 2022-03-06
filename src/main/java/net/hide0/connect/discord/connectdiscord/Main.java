package net.hide0.connect.discord.connectdiscord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("▃▅▅▆▆▇▇ Connect Discord ▇▇▆▆▅▅▃\nConnect Discordが起動しました!\n\n◊◊◊◊≡  Create by Hide0  ≡◊◊◊◊");
    }

    @Override
    public void onDisable() {
        getLogger().info("Connect Discordを終了させました...");
    }

    public static void onPostLog(String Message) {
        Bukkit.getLogger().info(Message);
    }
    public static void onPostChat(String Message) {
        Bukkit.getServer().broadcastMessage(Message);
    }
}
