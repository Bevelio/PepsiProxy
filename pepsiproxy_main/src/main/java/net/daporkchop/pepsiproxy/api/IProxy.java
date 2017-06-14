package net.daporkchop.pepsiproxy.api;

public interface IProxy {
    public void addSession(ISession session);

    public void removeSession(ISession session);
}
