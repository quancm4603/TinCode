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
public class Word {
    private int id;             // ID của word trong database
    private String word;        // Thuộc tính keyword của một từ
    private String definition;  // Nghĩa của một từ 
    private String original;    // Nguồn gốc của từ đó
    private String example;     // Ví dụ của từ đó
}
