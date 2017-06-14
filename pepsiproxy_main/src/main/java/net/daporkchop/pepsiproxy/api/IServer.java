package net.daporkchop.pepsiproxy.api;

import java.util.List;

/**
 * Handles all client connections
 */
public interface IServer<T extends ISession, clientPacketType extends Object> {
    public default void addSession(T session)    {
        getClients().add(session);
    }

    public default void removeSession(T session) {
        getClients().remove(session);
    }

    public List<T> getClients();

    public void recievePacket(clientPacketType type);
}
