/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket113.xml
 */
package net.daporkchop.pepsiproxy.pe.misc;

import net.daporkchop.pepsiproxy.util.Zlib;
import sul.utils.Stream;

import java.util.Arrays;

public class LoginBody extends Stream {

    public byte[] chain = new byte[0];
    public byte[] clientData = new byte[0];

    public LoginBody() {
    }

    public LoginBody(byte[] chain, byte[] clientData) {
        this.chain = chain;
        this.clientData = clientData;
    }

    @Override
    public int length() {
        return chain.length + clientData.length + 13;
    }

    @Override
    public byte[] encode() {
        this._buffer = new byte[this.length()];
        this.writeLittleEndianInt((int) chain.length);
        this.writeBytes(chain);
        this.writeLittleEndianInt((int) clientData.length);
        this.writeBytes(clientData);
        byte[] _this = this.getBuffer();
        this._buffer = new byte[10 + _this.length];
        this._index = 0;
        this.writeVaruint(_this.length);
        this.writeBytes(_this);
        return this.getBuffer();
    }

    @Override
    public void decode(byte[] buffer) {
        this._buffer = Zlib.inflate(buffer);
        final int _length = this.readVaruint();
        final int _length_index = this._index;
        this._buffer = this.readBytes(_length);
        this._index = 0;
        int bnyl = readLittleEndianInt();
        chain = this.readBytes(bnyl);
        int bnavdrde = readLittleEndianInt();
        clientData = this.readBytes(bnavdrde);
        this._index += _length_index;
    }

    @Override
    public String toString() {
        return "LoginBody(chain: " + Arrays.toString(this.chain) + ", clientData: " + Arrays.toString(this.clientData) + ")";
    }


}