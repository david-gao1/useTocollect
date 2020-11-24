package com.practise.useAES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class AESUtils {
    private static final String SECURERANDOM_SEED = "portal";

    /**
     * AES加密字符串
     *
     * @param content 需要被加密的字符串
     * @return 密文
     */
    public static String encrypt(String content) throws Exception {
        return useAESMode(content, Cipher.ENCRYPT_MODE);
    }


    /**
     * 解密
     *
     * @param content AES加密过的内容
     * @return 明文
     */
    public static String decrypt(String content) throws Exception {
        return useAESMode(content, Cipher.DECRYPT_MODE);
    }


    /**
     * 加密或解密
     *
     *
     * @param content 待加密字串或密文
     * @param mode    Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE
     * @return
     * @throws Exception
     */
    private static String useAESMode(String content, int mode) throws Exception {
        //1、生成AES的私钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(SECURERANDOM_SEED.getBytes());
        keyGenerator.init(128, random);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        //2、加密/解密
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, key);
        byte[] bytes = content.getBytes(StandardCharsets.ISO_8859_1);
        byte[] result = cipher.doFinal(bytes);
        return new String(result, StandardCharsets.ISO_8859_1);
    }


}