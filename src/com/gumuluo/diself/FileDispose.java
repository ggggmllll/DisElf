package com.gumuluo.diself;

import java.io.*;

public class FileDispose {

    private static class ByteUtils {
        public static short bytesToShort(byte[] data, boolean isLittleEndian) {
            short val;
            if (isLittleEndian) {
                val = (short) ((data[1] & 0xFF) << 8 | (data[0] & 0xFF));
            } else {
                val = (short) ((data[0] & 0xFF) << 8 | (data[1] & 0xFF));
            }
            return val;
        }

        public static int bytesToInt(byte[] data, boolean isLittleEndian) {
            int val;
            if (isLittleEndian) {
                val = (data[3] & 0xFF) << 24 | (data[2] & 0xFF) << 16 | (data[1] & 0xFF) << 8 | (data[0] & 0xFF);
            } else {
                val = (data[0] & 0xFF) << 24 | (data[1] & 0xFF) << 16 | (data[2] & 0xFF) << 8 | (data[3] & 0xFF);
            }
            return val;
        }

        public static long bytesToLong(byte[] data, boolean isLittleEndian) {
            long val;
            if (isLittleEndian) {
                val = (long) (data[7] & 0xFF) << 56 | (long) (data[6] & 0xFF) << 48 | (long) (data[5] & 0xFF) << 40 |
                        (long) (data[4] & 0xFF) << 32 | (long) (data[3] & 0xFF) << 24 | (data[2] & 0xFF) << 16 |
                        (data[1] & 0xFF) << 8 | (data[0] & 0xFF);
            } else {
                val = (long) (data[0] & 0xFF) << 56 | (long) (data[1] & 0xFF) << 48 | (long) (data[2] & 0xFF) << 40 |
                        (long) (data[3] & 0xFF) << 32 | (long) (data[4] & 0xFF) << 24 | (data[5] & 0xFF) << 16 |
                        (data[6] & 0xFF) << 8 | (data[7] & 0xFF);
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