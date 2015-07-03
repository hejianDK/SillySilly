package com.marlabs.trainee.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by Rico on 7/1/15.
 */
public class Utils {
    public static byte[] digest (String s) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(s.getBytes());
    }
}
