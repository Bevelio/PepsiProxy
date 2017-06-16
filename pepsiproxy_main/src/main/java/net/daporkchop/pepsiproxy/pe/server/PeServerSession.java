package net.daporkchop.pepsiproxy.pe.server;

import net.daporkchop.pepsiproxy.api.ISession;
import net.daporkchop.pepsiproxy.api.ITranslatorRegistry;
import net.marfgamer.jraknet.session.RakNetSession;

public class PeServerSession implements ISession {
    public final RakNetSession session;
    public final PeServer server;

    public PeServerSession(RakNetSession session, PeServer server) {
        this.session = session;
        this.server = server;
    }

    public ITranslatorRegistry getTranslator() {
        return null;
        //TODO
    }
}
