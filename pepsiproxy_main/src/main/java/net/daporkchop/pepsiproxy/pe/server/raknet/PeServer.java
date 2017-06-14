package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.daporkchop.pepsiproxy.api.IServer;
import net.daporkchop.pepsiproxy.api.PeSession;
import net.daporkchop.pepsiproxy.pe.server.raknet.PepsiRakNetServerListener;

import java.util.ArrayList;
import java.util.List;

public class PeServer implements IServer<PeSession> {
    public List<PeSession> clients = new ArrayList<PeSession>();
    public PepsiRakNetServerListener listener;

    public List<PeSession> getClients()  {
        return clients;
    }
}
