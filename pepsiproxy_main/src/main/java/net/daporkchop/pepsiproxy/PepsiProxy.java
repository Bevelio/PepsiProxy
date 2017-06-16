package net.daporkchop.pepsiproxy;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import net.daporkchop.pepsiproxy.api.IProxy;
import net.daporkchop.pepsiproxy.pc.client.PcClient;
import net.daporkchop.pepsiproxy.pc.client.PcClientListener;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PepsiRakNetServerListener;
import net.daporkchop.pepsiproxy.pe.server.raknet.RakNetServerTools;
import net.daporkchop.pepsiproxy.proxy.PeToPcProxy;

public class PepsiProxy {
    private static PepsiProxy INSTANCE;

    public IProxy proxy;

    public static void main(String[] args)  {
        new PepsiProxy().start(args);
    }

    public static PepsiProxy getINSTANCE()  {
        return INSTANCE;
    }

    public void start(String[] args) {
        INSTANCE = this;
        //TODO: config, this is currently hardcoded PE!!!
        System.out.println("Starting PepsiProxy...");
        PeServer server = new PeServer(RakNetServerTools.newServer(19133, 1000, "\u00A7cPepsi\u00A79Proxy \u00A7ftest server", 113, "1.1.0"));
        System.out.println("PE server created!");
        server.rakNetServer.setListener(new PepsiRakNetServerListener(server));
        System.out.println("Event listener initalized!");
        server.rakNetServer.startThreaded();
        System.out.println("Done! Accepting connections now!");
        MinecraftProtocol protocol = new MinecraftProtocol("_DaPorkchop_");
        Client protocolLibClient = new Client("play.extremecraft.net", 25565, protocol, new TcpSessionFactory());
        PcClientListener pcClientListener;
        protocolLibClient.getSession().addListener(pcClientListener = new PcClientListener());
        PcClient client = new PcClient(server, protocolLibClient, protocol, pcClientListener);
        PeToPcProxy proxy = new PeToPcProxy(server, client);
        this.proxy = proxy;
    }
}
