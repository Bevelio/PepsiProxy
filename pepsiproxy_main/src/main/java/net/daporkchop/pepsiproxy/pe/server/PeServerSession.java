package net.daporkchop.pepsiproxy.pe.server;

import net.daporkchop.pepsiproxy.api.ISession;
import net.daporkchop.pepsiproxy.api.ITranslatorRegistry;
import net.daporkchop.pepsiproxy.pc.client.PcClient;
import net.marfgamer.jraknet.session.RakNetClientSession;

public class PeServerSession implements ISession {
    public final RakNetClientSession session;
    public final PeServer server;
    public final PcClient client;

    public PeServerSession(RakNetClientSession session, PeServer server, PcClient client) {
        this.session = session;
        this.server = server;
        this.client = client;
    }

    public ITranslatorRegistry getTranslator() {
        return null;
        //TODO
    }
}
