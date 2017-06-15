package net.daporkchop.pepsiproxy.api;

import java.util.List;

public interface IProxy<serverType extends IServer, clientType extends IClient> {
    public serverType getServer();

    public List<clientType> getClients();

    public default void addClient(clientType toAdd) {
        getClients().add(toAdd);
    }

    public default void removeClient(clientType toRemove) {
        getClients().remove(toRemove);
    }
}
