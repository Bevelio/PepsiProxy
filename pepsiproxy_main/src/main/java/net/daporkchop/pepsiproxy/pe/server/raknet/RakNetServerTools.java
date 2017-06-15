package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.marfgamer.jraknet.identifier.MCPEIdentifier;
import net.marfgamer.jraknet.server.RakNetServer;

public class RakNetServerTools {
    /**
     * Makes a new RakNetServer.
     * @param port the port to listen on
     * @param maxPlayers the maximum amount of players that the server will accept
     * @param motd the server's MOTD
     * @param protocol the integer protocol version
     * @param protocolVersion the user-friendly version string
     * @param extraArgs optional. first field is the world name, second is the gamemode name. can be empty. having more than 2 fields here will throw an IllegalStateException.
     * @return a full RakNetServer
     */
    public static RakNetServer newServer(int port, int maxPlayers, String motd, int protocol, String protocolVersion, String... extraArgs) {
        if (extraArgs.length > 2)   {
            throw new IllegalStateException("extraArgs may be no longer than 2!");
        }
        return new RakNetServer(port, maxPlayers, new MCPEIdentifier(motd, protocol, protocolVersion, 0, maxPlayers, System.currentTimeMillis(), extraArgs.length > 0 ? extraArgs[0] : "", extraArgs.length > 1 ? extraArgs[1] : ""));
    }

    public static void changeOnlinePlayers(RakNetServer server, int newOnline)  {
        ((MCPEIdentifier) server.getIdentifier()).setOnlinePlayerCount(newOnline);
    }

    public static void changeMOTD(RakNetServer server, String newMotd)  {
        ((MCPEIdentifier) server.getIdentifier()).setServerName(newMotd);
    }
}
