package net.hide0.connect.discord.connectdiscord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.webhook.WebhookBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.net.URL;
import java.util.Objects;

public class Discord {
    public static String token = Config.getToken();
    public static String channelId = Config.getChannelId();
    public static String webhookUrl = Config.getWebhookUrl();
    public static String Message;
    public static String avatarImage;

    public static void main(String[] args) {
        if (Objects.equals(token, "Discord BotのTokenを入力してください")) {
            Main.onPostLog("config.ymlにTokenを入力してください");
        }
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(event -> {
                    if (Objects.equals(event.getChannel().getIdAsString(), channelId)) {
                        onCheckWebhookExist(event);
                        onChatPost(event);
                    }
                }
        );
    }

    public static void onChatPost(MessageCreateEvent event) {
        if (!event.getMessageAuthor().isBotUser()) {
            Main.onPostChat(event.getMessageContent());
        }
    }

    public static void onCheckWebhookExist(MessageCreateEvent event) {
        //Nullはありえない
        ServerTextChannel channel = event.getServerTextChannel().get();
        URL webhook = new WebhookBuilder(channel)
                .setName("Minecraft Server Connect Discord Webhook")
                .create().join()
                .getUrl();
        webhookUrl = String.valueOf(webhook);
        Config.setWebhookUrl(webhookUrl);

    }
}
