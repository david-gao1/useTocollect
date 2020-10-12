package com.practise.usedate;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usedate {
    public static void main(String[] args) {
        //线程安全类获取时间
        getTimeByDTF();
        //（具有时间格式的）字符串转为时间戳
        getTimeStampbyString();
    }

    private static void getTimeByDTF() {
        final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss");
        final String updateTime = TIME_FORMAT.format(LocalDateTime.now());
        System.out.println(updateTime);
    }

    private static void getTimeStampbyString() {
        String tsStr = "2020-09-27 10:57:23";
        Timestamp ts = Timestamp.valueOf(tsStr);  // 2011-05-09 11:49:45.0
        final long time = ts.getTime(); //转为时间戳
        System.out.println(time);
    }


    public static String generateSignature(String secureId, long timestamp, int randomValue, String secureKey) throws UnsupportedEncodingException {
        Base64 base64 = new Base64();
        byte[] baseStr = base64.encode(HmacUtils.hmacSha1(secureKey, secureId + timestamp + randomValue));
        String result = URLEncoder.encode(new String(baseStr), "UTF-8");
        return result;
    }
}
