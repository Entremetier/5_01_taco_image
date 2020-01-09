// tag::all[]
// tag::allButValidation[]
package tacos;
import java.util.List;
// end::allButValidation[]
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
// tag::allButValidation[]
import lombok.Data;

@Data
public class Taco {

  @NotNull
  @Size(min = 5, message = "Name muss mindestens 5 Zeichen haben")
  private String name;

  @Size(min = 1, message = "Es muss mindestens eine Zutat ausgewählt werden")
  private List<String> ingredients;
}