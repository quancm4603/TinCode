package com.quancm.tincode.models;

/**
 *
 * @author caomi
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id; // ID trong database của user
    private String username; // username
    private String password; // password
}