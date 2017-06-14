package net.daporkchop.pepsiproxy.api;

/**
 * Talks with the server that the proxy connects to
 */
public interface IClient {
    public IServer getServerLinked();
}
