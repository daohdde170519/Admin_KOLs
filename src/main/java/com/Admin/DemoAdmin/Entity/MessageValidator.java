/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAO
 */
public class MessageValidator {

    // Danh sách các domain hợp lệ
    private static final List<String> VALID_DOMAINS = Arrays.asList("facebook.com", "instagram.com", "whatsapp.com", "tiktok.com");

    // Danh sách các từ khóa liên quan đến profile
    private static final List<String> PROFILE_KEYWORDS = Arrays.asList("profile", "bio", "introduction", "cv", "resume");

    // Mẫu regex để tìm các URL
    private static final Pattern URL_PATTERN = Pattern.compile("https?://[^\\s/$.?#].[^\\s]*");

    public static boolean isMessageValid(String message) {
        // Kiểm tra từ khóa liên quan đến profile
        for (String keyword : PROFILE_KEYWORDS) {
            if (message.toLowerCase().contains(keyword)) {
                return false;  // Nếu có từ khóa liên quan đến profile, trả về false
            }
        }

        // Tìm tất cả các URL trong đoạn chat
        Matcher matcher = URL_PATTERN.matcher(message);
        boolean hasValidUrl = false;
        while (matcher.find()) {
            String url = matcher.group();
            if (!isValidDomain(url) || isInvalidTikTokProfile(url)) {
                return false;  // Nếu tìm thấy URL không hợp lệ hoặc là profile TikTok, trả về false
            } else {
                hasValidUrl = true;  // Nếu tìm thấy URL hợp lệ, ghi nhận lại
            }
        }

        // Nếu tin nhắn không chứa URL hoặc chỉ chứa URL hợp lệ, trả về true
        return hasValidUrl || !message.contains("http");
    }

    private static boolean isValidDomain(String url) {
        for (String domain : VALID_DOMAINS) {
            if (url.contains(domain)) {
                return true;  // URL thuộc domain hợp lệ
            }
        }
        return false;  // URL không thuộc domain hợp lệ
    }

    private static boolean isInvalidTikTokProfile(String url) {
        if (url.contains("tiktok.com") && !url.contains("video")) {
            return true;  // URL TikTok không chứa từ khóa "video" là profile, trả về false
        }
        return false;  // URL TikTok hợp lệ
    }
        public static void main(String[] args) {
        // Test case 1: Valid Facebook link
        String message1 = "https://twitter.com/example/status/1234567890";
        System.out.println(isMessageValid(message1));}
}
