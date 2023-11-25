package com.quancm.tincode.services;

/**
 *
 * @author caomi
 */

// Import các thư viện cần thiết

public class WordServiceSingleton {

    private static WordService instance;

    private WordServiceSingleton() {
        // Khởi tạo WordService nếu chưa có instance
        instance = new WordService();
    }

    public static WordService getInstance() {
        if (instance == null) {
            synchronized (WordServiceSingleton.class) {
                if (instance == null) {
                    new WordServiceSingleton();
                }
            }
        }
        return instance;
    }
}
