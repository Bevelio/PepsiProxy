package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.daporkchop.pepsiproxy.api.ISession;
import net.daporkchop.pepsiproxy.api.ITranslator;
import net.marfgamer.jraknet.session.RakNetSession;

public class PeServerSession implements ISession {
    public final RakNetSession session;

    public PeServerSession(RakNetSession session) {
        this.session = session;
    }

    public ITranslator getTranslator()  {
        return null;
        //TODO
    }
}
