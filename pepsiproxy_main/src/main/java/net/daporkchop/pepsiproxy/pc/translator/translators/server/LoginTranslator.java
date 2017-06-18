package net.daporkchop.pepsiproxy.pc.translator.translators.server;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import net.daporkchop.pepsiproxy.api.IPcTranslator;
import net.daporkchop.pepsiproxy.pc.client.PcClient;
import net.daporkchop.pepsiproxy.pc.client.PcClientListener;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.protocol.pocket113.play.Login;

public class LoginTranslator implements IPcTranslator<Login> {
    public Packet[] toPc(Login packet, RakNetClientSession session, PeServer server, PeServerSession serverSession) {
        MinecraftProtocol protocol = new MinecraftProtocol("_DaPorkchop_");
        Client protocolLibClient = new Client("play.extremecraft.net", 25565, protocol, new TcpSessionFactory());
        PcClientListener pcClientListener;
        protocolLibClient.getSession().addListener(pcClientListener = new PcClientListener());
        PcClient client = new PcClient(server, protocolLibClient, protocol, pcClientListener);
        server.clients.add(new PeServerSession(session, server, client));
        return null;
        //TODO
    }
}
