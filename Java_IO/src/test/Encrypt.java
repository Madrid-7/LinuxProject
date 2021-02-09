package test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Encrypt {
    public static void main(String[] args) throws IOException {
        String secretKey = "useless";

        String srcPath = "chinese.txt";
        String destPath = "something-useless.txt";

        try (InputStream is = new FileInputStream(srcPath)) {
            try (OutputStream os = new FileOutputStream(destPath)) {
                byte[] buffer = new byte[4096];

                int len;
                while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                    encrypt(buffer, 0, len, secretKey);
                    os.write(buffer, 0, len);
                }
                os.flush();
            }
        }
    }

    private static byte calcSecretKey(String secretKey) throws IOException {
        byte k = 0;
        for (byte b : secretKey.getBytes(StandardCharsets.UTF_8)) {
            k += b;
        }
        return k;
    }

    private static void encrypt(byte[] buffer, int offset, int length, String secretKey) throws IOException {
        // 把每一个 byte 都 + 一个值（从密钥计算得出）
        for (int i = 0; i < length; i++) {
            buffer[i + offset] = (byte) (buffer[i + offset] + calcSecretKey(secretKey));
        }
    }
}
