package com.marlabs.trainee.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Rico on 7/1/15.
 */
public class Utils {
    public static byte[] digest (String s){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }catch (NoSuchAlgorithmException e){
            //should be a logger here.
            System.out.println("fail to digest password");
        }
        return md.digest(s.getBytes());
    }
    public static LocalDate DateToLocalDate(Date date, ZoneId zid){
        return LocalDateTime.ofInstant(date.toInstant(),zid).toLocalDate();
    }
    public static  Date LocalDateToDate(LocalDate localDate, ZoneId zid){
        return Date.from(localDate.atStartOfDay().atZone(zid).toInstant());
    }
}
