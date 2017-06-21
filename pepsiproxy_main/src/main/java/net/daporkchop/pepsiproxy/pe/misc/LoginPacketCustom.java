package net.daporkchop.pepsiproxy.pe.misc;

import net.daporkchop.pepsiproxy.util.LoginPacketPayload;
import sul.protocol.pocket113.play.Login;
import sul.utils.Packet;

public class LoginPacketCustom extends Packet {
    public static final byte ID = (byte) 1;

    public static final boolean CLIENTBOUND = false;
    public static final boolean SERVERBOUND = true;
    // version
    public static final byte VANILLA = 0;
    public static final byte EDUCATION = 1;
    /**
     * Version of the protocol used by the player.
     */
    public int protocol = 113;
    /**
     * Edition that the player is using to join the server. The different editions may
     * have different features and servers may block the access from unaccepted editions
     * of the game.
     */
    public byte version;
    /**
     * Payload that contains 2 JWTs (with each length indicated by an unsigned little-endian
     * 32-bits integer) with more informations about the player and its account.
     */
    public LoginPacketPayload body;

    public LoginPacketCustom() {
    }

    public LoginPacketCustom(int protocol, byte version, LoginPacketPayload body) {
        this.protocol = protocol;
        this.version = version;
        this.body = body;
    }

    public static LoginPacketCustom fromBuffer(byte[] buffer) {
        LoginPacketCustom ret = new LoginPacketCustom();
        ret.decode(buffer);
        return ret;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public int length() {
        return body.length + 6;
    }

    @Override
    public byte[] encode() {
        this._buffer = new byte[this.length()];
        this.writeBigEndianByte(ID);
        this.writeBigEndianInt(protocol);
        this.writeBigEndianByte(version);
        //TODO: this.writeBytes(body.encode());
        return this.getBuffer();
    }

    @Override
    public void decode(byte[] buffer) {
        this._buffer = buffer;
        readBigEndianByte();
        protocol = readBigEndianInt();
        version = readBigEndianByte();
        body = LoginPacketPayload.decode(this.readBytes(this.readVaruint()));
    }

    @Override
    public String toString() {
        return "DaPorkchop_Login(protocol: " + this.protocol + ", version: " + this.version + ", body: " + this.body.toString() + ")";
    }
}
