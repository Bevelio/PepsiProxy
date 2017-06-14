package net.daporkchop.pepsiproxy.pc.client;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import net.daporkchop.pepsiproxy.api.IClient;
import net.daporkchop.pepsiproxy.api.IServer;

public class PcClient implements IClient {
    public final IServer server;
    public final Client client;
    public final MinecraftProtocol protocol;

    public PcClient(IServer server, Client client, MinecraftProtocol protocol)  {
        this.server = server;
        this.client = client;
        this.protocol = protocol;
    }

    public IServer getServerLinked()    {
        return server;
    }
}
