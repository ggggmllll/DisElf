package com.gumuluo.diself;

import java.io.*;

public class FileDispose {

    private static class ByteUtils {
        public static short bytesToShort(byte[] data, boolean isLittleEndian) {
            short val;
            if (isLittleEndian) {
                val = (short) ((short) data[1] << 8 | (short) data[0]);
            } else {
                val = (short) ((short) data[0] << 8 | (short) data[1]);
            }
            return val;
        }

        public static int bytesToInt(byte[] data, boolean isLittleEndian) {
            int val;
            if (isLittleEndian) {
                val = (int) data[3] << 24 | (int) data[2] << 16 | (int) data[1] << 8 | (int) data[0];
            } else {
                val = (int) data[0] << 24 | (int) data[1] << 16 | (int) data[2] << 8 | (int) data[3];
            }
            return val;
        }

        public static long bytesToLong(byte[] data, boolean isLittleEndian) {
            long val;
            if (isLittleEndian) {
                val = (long) data[7] << 56 | (long) data[6] << 48 | (long) data[5] << 40 | data[4] << 32 |
                        data[3] << 24 | data[2] << 16 | data[1] << 8 | data[0];
            } else {
                val = (long) data[0] << 56 | (long) data[1] << 48 | (long) data[2] << 40 | data[3] << 32 |
                        data[4] << 24 | data[5] << 16 | data[6] << 8 | data[7];
            }
            return val;
        }
    }

    private final BufferedInputStream bufferedInputStream;
    private final boolean isLittleEndian;

    public FileDispose(String path) throws IOException {
        this.bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        this.bufferedInputStream.mark(0);
        byte[] ident = this.readBytes(0, 16);
        if (ident[0] != 0x7f || ident[1] != 'E' || ident[2] != 'L' || ident[3] != 'F')
            throw new IOException("error magic number");
        if (ident[4] != 1 && ident[4] != 2)
            throw new IOException("error class");
        if (ident[5] != 1 && ident[5] != 2)
            throw new IOException("error encode");
        this.isLittleEndian = ident[5] == 1;
    }

    private void seek(long offset) throws IOException {
        this.bufferedInputStream.reset();
        this.bufferedInputStream.skip(offset);
    }

    public byte[] readBytes(long offset, int size) throws IOException {
        this.seek(offset);
        byte[] arr = new byte[size];
        this.bufferedInputStream.read(arr);
        return arr;
    }

    public byte readByte(long offset) throws IOException {
        byte[] val = this.readBytes(offset, 1);
        return val[1];
    }

    public short readShort(long offset) throws IOException {
        byte[] val = this.readBytes(offset, 2);
        return ByteUtils.bytesToShort(val, this.isLittleEndian);
    }

    public int readInt(long offset) throws IOException {
        byte[] val = this.readBytes(offset, 4);
        return ByteUtils.bytesToInt(val, this.isLittleEndian);
    }

    public long readLong(long offset) throws IOException {
        byte[] val = this.readBytes(offset, 8);
        return ByteUtils.bytesToLong(val, this.isLittleEndian);
    }
}