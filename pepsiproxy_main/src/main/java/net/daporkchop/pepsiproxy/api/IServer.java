package net.daporkchop.pepsiproxy.api;

import java.util.List;

/**
 * Handles all client connections
 */
public interface IServer<clientType extends ISession, clientPacketType extends Object, serverType extends Object> {
    public default void addSession(clientType session) {
        getClients().add(session);
    }

    public default void removeSession(clientType session) {
        getClients().remove(session);
    }

    public List<clientType> getClients();

    public void recievePacket(clientPacketType type);

    public serverType getNetServer();
}
