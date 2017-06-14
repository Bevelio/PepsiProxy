package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.daporkchop.pepsiproxy.api.IServer;
import net.daporkchop.pepsiproxy.pe.PeSession;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.utils.Packet;

import java.util.ArrayList;
import java.util.List;

public class PeServer implements IServer<PeSession, Packet> {
    public List<PeSession> clients = new ArrayList<PeSession>();
    public PepsiRakNetServerListener listener;

    public List<PeSession> getClients()  {
        return clients;
    }

    public void recievePacket(Packet packet)    {
        //TODO
    }

    public PeSession getPeSessionFromRakNetClientSession(RakNetClientSession session)   {
        for (PeSession peSession : clients) {
            if (peSession.session == session)   {
                return peSession;
            }
        }

        return null;
    }
}
