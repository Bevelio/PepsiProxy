package net.daporkchop.pepsiproxy.api;

/**
 * A connection between a Minecraft client and an IServer
 */
public interface ISession {
    public ITranslator getTranslator();
}
