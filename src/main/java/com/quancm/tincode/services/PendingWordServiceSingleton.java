package com.quancm.tincode.services;

/**
 *
 * @author caomi
 */

// Import các thư viện cần thiết

public class PendingWordServiceSingleton {

    private static PendingWordService instance;

    private PendingWordServiceSingleton() {
        // Khởi tạo WordService nếu chưa có instance
        instance = new PendingWordService();
    }

    public static PendingWordService getInstance() {
        if (instance == null) {
            synchronized (PendingWordServiceSingleton.class) {
                if (instance == null) {
                    new PendingWordServiceSingleton();
                }
            }
        }
        return instance;
    }
}
