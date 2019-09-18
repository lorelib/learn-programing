package com.lorelib.security.tink;

import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author listening
 * @date 2019-09-17 3:46 PM
 * @since v1.0
 */
public class AESTest {
    @Test
    public void encryptionTest() throws GeneralSecurityException, IOException {
        AES aes = AES.newInstanceWithAES128GCM("XXX");
        String cipher = aes.encryptionToBase64("abc");
        String cipherHex = aes.encryptionToHex("abc");
        System.out.println(cipher + " | " + cipherHex);
    }

    @Test
    public void decryptionTest() throws GeneralSecurityException, IOException {
        AES aes = AES.newInstanceWithAES128GCM("XXX");
        String plaintext = aes.decryptionBase64("ARUZljkT5nMXUYS8DYwKMCUkQLzLXVst+LbNL8BGiYrYsncv");
        String plaintextHex = aes.decryptionHex("0115199639536578A8EB40A4C5EE62A2C68DC2E29492648BDCC065EB886C28E1782E0FC0");
        System.out.println(plaintext + " | " + plaintextHex);
    }
}
