package io.xapeh.auth;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuthorizationPlugin extends JavaPlugin implements Listener {
    private static AuthorizationPlugin INSTANCE;

    private AuthorizationData authData;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        authData.getPlayer(e.getPlayer().getName()).setAuthorizated(false);
    }

    @Override
    public void onEnable() {
        AuthorizationPlugin.INSTANCE = this;

        this.authData = new AuthorizationData();

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "Jebac|Disa", new AuthorizationPacketListener());
    }

    AuthorizationData getAuthData() {
        return authData;
    }

    public static AuthorizationPlugin getPluginInstance() {
        return INSTANCE;
    }

}
