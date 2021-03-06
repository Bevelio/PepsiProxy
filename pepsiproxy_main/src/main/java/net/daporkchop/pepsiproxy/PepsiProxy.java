package net.daporkchop.pepsiproxy;

import net.daporkchop.pepsiproxy.api.IProxy;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PepsiRakNetServerListener;
import net.daporkchop.pepsiproxy.pe.server.raknet.RakNetServerTools;
import net.daporkchop.pepsiproxy.pe.translator.PePacketGenerator;

public class PepsiProxy {
    public static boolean pe_mode = true;
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
        PePacketGenerator.refreshMethods();
        //TODO: config, this is currently hardcoded PE!!!
        System.out.println("Starting PepsiProxy...");
        PeServer server = new PeServer(RakNetServerTools.newServer(19133, 1000, "\u00A7cPepsi\u00A79Proxy \u00A7ftest server", 113, "1.1.0"));
        System.out.println("PE server created!");
        server.rakNetServer.setListener(new PepsiRakNetServerListener(server));
        System.out.println("Event listener initalized!");
        server.rakNetServer.startThreaded();
        System.out.println("Done! Accepting connections now!");
    }
}
