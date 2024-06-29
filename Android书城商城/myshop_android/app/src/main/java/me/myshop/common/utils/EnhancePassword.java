package me.myshop.common.utils;

public class EnhancePassword {
    public static String coding(String password) {
        /**
        try {
            password = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return password;
    }

    public static String decoding(String password) {
        /**
        try {
            byte[] bytes = Base64.getDecoder().decode(password);
            password = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return password;
    }
}
