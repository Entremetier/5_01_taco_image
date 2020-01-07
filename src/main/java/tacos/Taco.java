package tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min = 5, message = "Name muss mindestens 5 Zeichen besitzen")
    private String name;

    @Size(min = 1, message = "Es muss mindestens eine Zutat ausgewählt werden")
    private List<String> ingredients;
}
