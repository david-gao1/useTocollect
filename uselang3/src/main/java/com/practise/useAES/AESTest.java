package com.practise.useAES;

public class AESTest {

    public static void main(String[] args) throws Exception {
        String password = "xie121ssadasfds__sda_____gfsgdaf1";
        final String encrypt = AESUtils.encrypt(password);
        final String decrypt = AESUtils.decrypt(encrypt);
        System.out.println(decrypt);
    }
}