package io.xapeh.auth;

import java.util.HashMap;

public class AuthorizationData {
    private HashMap<String, AuthPlayer> players = new HashMap<>();

    public void updatePlayer(AuthPlayer player) {
        players.put(player.getPlayerName(), player);
    }

    public AuthPlayer getPlayer(String playerName) {
        return players.get(playerName);
    }
}
