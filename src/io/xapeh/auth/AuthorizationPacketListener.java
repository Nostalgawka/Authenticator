package io.xapeh.auth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.Arrays;

public class AuthorizationPacketListener implements PluginMessageListener {
    private static final AuthorizationData authData = AuthorizationPlugin.getPluginInstance().getAuthData();

    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if(authData.getPlayer(player.getName()) == null) authData.updatePlayer(new AuthPlayer(player.getName()));
        if(Arrays.equals(bytes, "Chujnia".getBytes())) {
            authData.getPlayer(player.getName()).setAuthorizated(true);
            Bukkit.broadcastMessage(ChatColor.GREEN + "Gracz " + player.getName() + " dolaczyl na serwer z uzyciem systemu autoryzacji \"NostalgawkaTM's JebacDisa\"");
        }
        else Bukkit.broadcastMessage(ChatColor.RED + "Gracz " + player.getName() + " uzyl niepoprawnego pakietu logowania! (" + Arrays.toString(bytes) + ")");
    }
}
