package pl.edu.wat.backend.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private int phone_number;
    private String email;
}
