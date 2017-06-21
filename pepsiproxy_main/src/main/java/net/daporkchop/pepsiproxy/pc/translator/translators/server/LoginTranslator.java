package net.daporkchop.pepsiproxy.pc.translator.translators.server;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import net.daporkchop.pepsiproxy.api.IPcTranslator;
import net.daporkchop.pepsiproxy.pc.client.PcClient;
import net.daporkchop.pepsiproxy.pc.client.PcClientListener;
import net.daporkchop.pepsiproxy.pe.misc.LoginPacketCustom;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.session.RakNetClientSession;

public class LoginTranslator implements IPcTranslator<LoginPacketCustom> {
    public Packet[] toPc(LoginPacketCustom packet, RakNetClientSession session, PeServer server, PeServerSession serverSession) {
        System.out.println(packet.toString());
        MinecraftProtocol protocol = new MinecraftProtocol("_DaPorkchop_");
        System.out.println("a");
        Client protocolLibClient = new Client("play.extremecraft.net", 25565, protocol, new TcpSessionFactory());
        System.out.println("b");
        PcClientListener pcClientListener = new PcClientListener();
        System.out.println("c");
        protocolLibClient.getSession().addListener(pcClientListener);
        System.out.println("d");
        PcClient client = new PcClient(server, protocolLibClient, protocol, pcClientListener);
        System.out.println("e");
        server.clients.add(serverSession = new PeServerSession(session, server, client));
        System.out.println("f");
        serverSession.clientLoginInfo = packet;

        System.out.println("g");
        //PeServerUtils.doHandshake1(serverSession);

        System.out.println("h");
        return null;
        //TODO
    }
}
