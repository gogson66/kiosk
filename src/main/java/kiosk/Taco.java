package kiosk;

import lombok.Data;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;



@Data
public class Taco {

    private long id;

    private Instant createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 charcters long")
    private String name;

    @NotNull(message = "You must have at least one ingredient")
    private List<Ingredient> ingredients;
}
