package io.xapeh.auth;

public class AuthPlayer {
    private String playerName;
    private boolean isAuthorizated;

    public String getPlayerName() {
        return playerName;
    }

    public boolean isAuthorizated() {
        return isAuthorizated;
    }

    public AuthPlayer(String playerName) {
        this.playerName = playerName;
        this.isAuthorizated = false;
    }

    public void setAuthorizated(boolean isAuthorizated) {
        this.isAuthorizated = isAuthorizated;
        AuthorizationPlugin.getPluginInstance().getAuthData().updatePlayer(this);
    }
}
