package net.daporkchop.pepsiproxy.proxy;

import net.daporkchop.pepsiproxy.api.IProxy;
import net.daporkchop.pepsiproxy.pc.client.PcClient;
import net.daporkchop.pepsiproxy.pe.server.raknet.PeServer;

import java.util.ArrayList;
import java.util.List;

public class PeToPcProxy implements IProxy<PeServer, PcClient> {
    public final PeServer server;
    public final List<PcClient> clients = new ArrayList<>();

    public PeToPcProxy(PeServer server, PcClient... clients)    {
        this.server = server;
        for (PcClient client : clients) {
            this.clients.add(client);
        }
    }

    public PeServer getServer() {
        return server;
    }

    public List<PcClient> getClients() {
        return clients;
    }
}
