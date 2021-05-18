package pl.edu.wat.backend.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.wat.backend.jpa.StatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invitation {
    private int id;
    private StatusEnum status;
}
