package net.daporkchop.pepsiproxy.pe.server;

import com.google.common.cache.CacheBuilder;
import net.daporkchop.pepsiproxy.api.IServer;
import net.marfgamer.jraknet.server.RakNetServer;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.utils.Packet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class PeServer implements IServer<PeServerSession, Packet, RakNetServer> {
    public final RakNetServer rakNetServer;
    public List<PeServerSession> clients = new ArrayList<PeServerSession>();
    public PepsiRakNetServerListener listener;

    /**
     * super short-term cache, removed items if they are not used for more than 10 seconds
     * keeps ram nice and clean
     */
    public ConcurrentMap<Object, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.SECONDS)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build().asMap();

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
