package kiosk;

import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Data
public class Taco {

    @NotNull
    @Size(min=5, message="Name must be at least 5 charcters long")
    private String name;

    @Size(min=1, message="You must have at least one ingredient")
    private List<String> ingredients;
}
