package net.daporkchop.pepsiproxy.pe;

import net.daporkchop.pepsiproxy.api.ISession;
import net.daporkchop.pepsiproxy.api.ITranslator;
import net.marfgamer.jraknet.session.RakNetSession;

public class PeSession implements ISession {
    public final RakNetSession session;

    public PeSession(RakNetSession session) {
        this.session = session;
    }

    public ITranslator getTranslator()  {
        return null;
        //TODO
    }
}
