package com.vika.way.pre.algorithm.leetcode.midium.S501_600;


public class S535EncodeAndDecodeTinyURL {

    final int priKey = 77;
    final int pubKey = 66;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] chars = longUrl.toCharArray();
        int key = priKey ^ pubKey;
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= key;
        }
        return "http://" + new String(chars);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        char[] chars = shortUrl.substring(7).toCharArray();
        int key = priKey ^ pubKey;
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= key;
        }
        return new String(chars);
    }
}
