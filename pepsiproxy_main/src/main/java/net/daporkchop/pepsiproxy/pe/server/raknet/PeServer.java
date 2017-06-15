package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.daporkchop.pepsiproxy.api.IServer;
import net.marfgamer.jraknet.server.RakNetServer;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.utils.Packet;

import java.util.ArrayList;
import java.util.List;

public class PeServer implements IServer<PeServerSession, Packet, RakNetServer> {
    public final RakNetServer rakNetServer;
    public List<PeServerSession> clients = new ArrayList<PeServerSession>();
    public PepsiRakNetServerListener listener;

    public PeServer(RakNetServer rakNetServer) {
        this.rakNetServer = rakNetServer;
    }

    public List<PeServerSession> getClients() {
        return clients;
    }

    public void recievePacket(Packet packet)    {
        //TODO
    }

    public PeServerSession getPeSessionFromRakNetClientSession(RakNetClientSession session) {
        for (PeServerSession peSession : clients) {
            if (peSession.session == session)   {
                return peSession;
            }
        }

        return null;
    }

    public RakNetServer getNetServer() {
        return rakNetServer;
    }
}
