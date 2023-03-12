package com.gumuluo.diself;

import java.io.IOException;

public class ProgramHeader {
    private final long offset;
    private final FileDispose fileDispose;
    private int p_type;
    private long p_offset;
    private long p_vaddr;
    private long p_paddr;
    private long p_filesz;
    private long p_memsz;
    private int p_flags;
    private long p_align;

    public ProgramHeader(FileDispose fileDispose, long offset, boolean is32) throws IOException {
        this.fileDispose = fileDispose;
        this.offset = offset;
        if (is32)
            constructor32();
        else
            constructor64();
    }

    private void constructor32() throws IOException {
        this.p_type = this.fileDispose.readInt(this.offset + 0);
        this.p_offset = this.fileDispose.readInt(this.offset + 4);
        this.p_vaddr = this.fileDispose.readInt(this.offset + 8);
        this.p_paddr = this.fileDispose.readInt(this.offset + 12);
        this.p_filesz = this.fileDispose.readInt(this.offset + 16);
        this.p_memsz = this.fileDispose.readInt(this.offset + 20);
        this.p_flags = this.fileDispose.readInt(this.offset + 24);
        this.p_align = this.fileDispose.readInt(this.offset + 28);
    }

    private void constructor64() throws IOException {
        this.p_type = this.fileDispose.readInt(this.offset + 0);
        this.p_flags = this.fileDispose.readInt(this.offset + 4);
        this.p_offset = this.fileDispose.readLong(this.offset + 8);
        this.p_vaddr = this.fileDispose.readLong(this.offset + 16);
        this.p_paddr = this.fileDispose.readLong(this.offset + 24);
        this.p_filesz = this.fileDispose.readLong(this.offset + 32);
        this.p_memsz = this.fileDispose.readLong(this.offset + 40);
        this.p_align = this.fileDispose.readLong(this.offset + 48);
    }

    public int getP_type() {
        return p_type;
    }

    public long getP_offset() {
        return p_offset;
    }

    public long getP_vaddr() {
        return p_vaddr;
    }

    public long getP_paddr() {
        return p_paddr;
    }

    public long getP_filesz() {
        return p_filesz;
    }

    public long getP_memsz() {
        return p_memsz;
    }

    public int getP_flags() {
        return p_flags;
    }

    public long getP_align() {
        return p_align;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("p_type:"+this.p_type+"\n");
        stringBuffer.append("p_offset:"+this.p_offset+"\n");
        stringBuffer.append("p_vaddr:"+this.p_vaddr+"\n");
        stringBuffer.append("p_paddr:"+this.p_paddr+"\n");
        stringBuffer.append("p_filesz:"+this.p_filesz+"\n");
        stringBuffer.append("p_memsz:"+this.p_memsz+"\n");
        stringBuffer.append("p_flags:"+this.p_flags+"\n");
        stringBuffer.append("p_align:"+this.p_align+"\n");
        return stringBuffer.toString();
    }
}
