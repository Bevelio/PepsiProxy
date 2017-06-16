package net.daporkchop.pepsiproxy.api;

/**
 * A connection between a Minecraft client and the proxy's target server, runs though an IServer and an IClient
 */
public interface ISession<serverType extends IServer, clientType extends IClient> {
    public ITranslatorRegistry getTranslator();
}
