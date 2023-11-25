package com.quancm.tincode.services;

/**
 *
 * @author caomi
 */

// Import các thư viện cần thiết

public class UserServiceSingleton {

    private static UserService instance;

    private UserServiceSingleton() {
        // Khởi tạo UserService nếu chưa có instance
        instance = new UserService();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserServiceSingleton.class) {
                if (instance == null) {
                    new UserServiceSingleton();
                }
            }
        }
        return instance;
    }
}

