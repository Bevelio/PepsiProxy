package net.daporkchop.pepsiproxy.api;

import java.util.List;

public interface IServer<T extends ISession> {
    public default void addSession(T session)    {
        getClients().add(session);
    }

    public default void removeSession(T session) {
        getClients().remove(session);
    }

    public List<T> getClients();
}
