package net.daporkchop.pepsiproxy;

import net.daporkchop.pepsiproxy.api.IProxy;
import net.daporkchop.pepsiproxy.pe.server.raknet.PeServer;
import net.daporkchop.pepsiproxy.pe.server.raknet.PepsiRakNetServerListener;
import net.daporkchop.pepsiproxy.pe.server.raknet.RakNetServerTools;

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
    }
}
