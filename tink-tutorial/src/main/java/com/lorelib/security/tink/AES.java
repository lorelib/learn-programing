package com.lorelib.security.tink;

import com.google.crypto.tink.*;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.proto.KeyTemplate;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author listening
 * @date 2019-09-18 11:35 AM
 * @since v1.0
 */
public class AES {
    private static final String DEFAULT_KEYSET_PATH = "/opt/keyset.sec";

    private String keysetPath;
    private KeyTemplate keyTemplate;
    private String associatedData;

    public AES() {
    }

    public AES(KeyTemplate keyTemplate, String associatedData) {
        this.keyTemplate = keyTemplate;
        this.associatedData = associatedData;
    }

    public AES(String keysetPath, KeyTemplate keyTemplate, String associatedData) {
        this.keysetPath = keysetPath;
        this.keyTemplate = keyTemplate;
        this.associatedData = associatedData;
    }

    public static AES newInstanceWithAES128GCM(String associatedData) {
        return new AES(DEFAULT_KEYSET_PATH, AeadKeyTemplates.AES128_GCM, associatedData);
    }

    public static AES newInstance(KeyTemplate keyTemplate, String associatedData) {
        return new AES(DEFAULT_KEYSET_PATH, keyTemplate, associatedData);
    }

    public static AES newInstance(String keysetPath, KeyTemplate keyTemplate, String associatedData) {
        return new AES(keysetPath, keyTemplate, associatedData);
    }

    /**
     * 加密，返回Base64
     *
     * @param plaintext
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public String encryptionToBase64(String plaintext) throws GeneralSecurityException, IOException {
        byte[] ciphertext = encryption(plaintext.getBytes());
        return bytes2Base64(ciphertext);
    }

    /**
     * 解密Base64字符串
     *
     * @param ciphertext
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public String decryptionBase64(String ciphertext) throws GeneralSecurityException, IOException {
        byte[] plaintext = decryption(base642Bytes(ciphertext));
        return new String(plaintext, "UTF-8");
    }

    /**
     * 加密，返回16进制
     *
     * @param plaintext
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public String encryptionToHex(String plaintext) throws GeneralSecurityException, IOException {
        byte[] ciphertext = encryption(plaintext.getBytes());
        return bytes2HexStr(ciphertext);
    }

    /**
     * 解密16进制字符串
     *
     * @param ciphertext  16进制字符串
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public String decryptionHex(String ciphertext) throws GeneralSecurityException, IOException {
        byte[] plaintext = decryption(hexStr2Bytes(ciphertext));
        return new String(plaintext, "UTF-8");
    }

    /**
     * 加密
     *
     * @param plaintext
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public byte[] encryption(byte[] plaintext) throws GeneralSecurityException, IOException {
        KeysetHandle keysetHandle = getKeysetHandle();
        Aead aead = AeadFactory.getPrimitive(keysetHandle);
        byte[] ciphertext = aead.encrypt(plaintext, associatedData.getBytes());
        return ciphertext;
    }

    /**
     * 解密
     *
     * @param ciphertext
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public byte[] decryption(byte[] ciphertext) throws GeneralSecurityException, IOException {
        KeysetHandle keysetHandle = getKeysetHandle();
        Aead aead = AeadFactory.getPrimitive(keysetHandle);
        byte[] plaintext = aead.decrypt(ciphertext, associatedData.getBytes());
        return plaintext;
    }

    /**
     * 获取密钥
     *
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private KeysetHandle getKeysetHandle() throws IOException, GeneralSecurityException {
        TinkConfig.register();
        File keyset = new File(keysetPath);
        if (keyset.exists()) {
            return CleartextKeysetHandle.read(JsonKeysetReader.withFile(keyset));
        }
        KeysetHandle handle = KeysetHandle.generateNew(keyTemplate);
        CleartextKeysetHandle.write(handle, JsonKeysetWriter.withFile(keyset));
        return handle;
    }

    /**
     * 字节转16进制字符串
     *
     * @param bytes
     * @return
     */
    private static String bytes2HexStr(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 16进制转字节数组
     *
     * @param str
     * @return
     */
    private static byte[] hexStr2Bytes(String str) {
        byte digest[] = new byte[str.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = str.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    /**
     * 字节转64进制
     *
     * @param bytes
     * @return
     */
    public static String bytes2Base64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 64进制转字节
     *
     * @param base64
     * @return
     */
    public static byte[] base642Bytes(final String base64) {
        return Base64.decodeBase64(base64);
    }

}
