package net.daporkchop.pepsiproxy.api;

import net.marfgamer.jraknet.session.RakNetSession;

public class PeSession implements ISession {
    public final RakNetSession session;

    public PeSession(RakNetSession session) {
        this.session = session;
    }
}
