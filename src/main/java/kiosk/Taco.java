package kiosk;

import lombok.Data;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Data
public class Taco {

    private long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 charcters long")
    private String name;

    @NotNull(message = "You must have at least one ingredient")
    private List<String> ingredients;
}
