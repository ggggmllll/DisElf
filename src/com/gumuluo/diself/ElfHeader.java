package com.gumuluo.diself;

import java.io.IOException;

public class ElfHeader {

    private byte[] e_ident;
    private short e_type;
    private short e_machine;
    private int e_version;
    private long e_entry;
    private long e_phoff;
    private long e_shoff;
    private int e_flags;
    private short e_ehsize;
    private short e_phentsize;
    private short e_phnum;
    private short e_shentsize;
    private short e_shnum;
    private short e_shstrndx;
    private FileDispose fileDispose;

    public ElfHeader(FileDispose fileDispose) throws IOException {
        this.fileDispose = fileDispose;
        this.e_ident = fileDispose.readBytes(0, 16);
        boolean is32 = e_ident[(int) ElfMacroDefinition.EI_CLASS.getValue()] == ElfMacroDefinition.ELFCLASS32.getValue();
        this.e_type = this.fileDispose.readShort(16);
        this.e_machine = this.fileDispose.readShort(18);
        this.e_version =  this.fileDispose.readInt(20);
        if (is32)
            constructor32();
        else
            constructor64();
    }

    private void constructor32() throws IOException {
        this.e_entry = this.fileDispose.readInt(24);
        this.e_phoff = this.fileDispose.readInt(28);
        this.e_shoff = this.fileDispose.readInt(32);
        this.e_flags = this.fileDispose.readInt(36);
        this.e_ehsize = this.fileDispose.readShort(40);
        this.e_phentsize = this.fileDispose.readShort(42);
        this.e_phnum = this.fileDispose.readShort(44);
        this.e_shentsize = this.fileDispose.readShort(46);
        this.e_shnum = this.fileDispose.readShort(48);
        this.e_shstrndx = this.fileDispose.readShort(50);
    }

    private void constructor64() throws IOException {
        this.e_entry = this.fileDispose.readLong(24);
        this.e_phoff = this.fileDispose.readLong(32);
        this.e_shoff = this.fileDispose.readLong(40);
        this.e_flags = this.fileDispose.readInt(48);
        this.e_ehsize = this.fileDispose.readShort(52);
        this.e_phentsize = this.fileDispose.readShort(54);
        this.e_phnum = this.fileDispose.readShort(56);
        this.e_shentsize = this.fileDispose.readShort(58);
        this.e_shnum = this.fileDispose.readShort(60);
        this.e_shstrndx = this.fileDispose.readShort(62);
    }

    public byte[] getE_ident() {
        return e_ident;
    }

    public short getE_type() {
        return e_type;
    }

    public short getE_machine() {
        return e_machine;
    }

    public int getE_version() {
        return e_version;
    }

    public long getE_entry() {
        return e_entry;
    }

    public long getE_phoff() {
        return e_phoff;
    }

    public long getE_shoff() {
        return e_shoff;
    }

    public int getE_flags() {
        return e_flags;
    }

    public short getE_ehsize() {
        return e_ehsize;
    }

    public short getE_phentsize() {
        return e_phentsize;
    }

    public short getE_phnum() {
        return e_phnum;
    }

    public short getE_shentsize() {
        return e_shentsize;
    }

    public short getE_shnum() {
        return e_shnum;
    }

    public short getE_shstrndx() {
        return e_shstrndx;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("e_type:"+this.e_type+"\n");
        stringBuffer.append("e_machine:"+this.e_machine+"\n");
        stringBuffer.append("e_version:"+this.e_version+"\n");
        stringBuffer.append("e_entry:"+this.e_entry+"\n");
        stringBuffer.append("e_phoff:"+String.format("%x", this.e_phoff)+"\n");
        stringBuffer.append("e_shoff:"+String.format("%x", this.e_shoff)+"\n");
        stringBuffer.append("e_flags:"+this.e_flags+"\n");
        stringBuffer.append("e_ehsize:"+this.e_ehsize+"\n");
        stringBuffer.append("e_phentsize:"+this.e_phentsize+"\n");
        stringBuffer.append("e_phnum:"+this.e_phnum+"\n");
        stringBuffer.append("e_shentsize:"+this.e_shentsize+"\n");
        stringBuffer.append("e_shnum:"+this.e_shnum+"\n");
        stringBuffer.append("e_shstrndx:"+this.e_shstrndx+"\n");
        return stringBuffer.toString();
    }
}