package com.yaao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 获取微信所需的签名
 *
 * @author GuTianHao
 */
public class SignUtil {

    public SignUtil() {
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String checktext = null;
        if (signature != null) {
            String[] paramArr = {
                    token, timestamp, nonce
            };
            Arrays.sort(paramArr);
            String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                byte[] digest = md.digest(content.toString().getBytes());
                checktext = byteToStr(digest);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return checktext == null ? false : checktext.equals(signature.toUpperCase());
    }

    private static String byteToStr(byte[] byteArrays) {
        String str = "";
        for (int i = 0; i < byteArrays.length; i++) {
            str = (new StringBuilder(String.valueOf(str))).append(byteToHexStr(byteArrays[i])).toString();
        }

        return str;
    }

    private static String byteToHexStr(byte myByte) {
        char[] digit = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'
        };
        char[] tampArr = new char[2];
        tampArr[0] = digit[myByte >>> 4 & 0xf];
        tampArr[1] = digit[myByte & 0xf];
        String str = new String(tampArr);
        return str;
    }

    private static String token = "gth";

}