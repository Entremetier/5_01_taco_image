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

  // end::allButValidation[]
  @NotNull
  @Size(min=5, message="Name muss mindestens 5 Zeichen haben")
  // tag::allButValidation[]
  private String name;
  // end::allButValidation[]
  @Size(min=1, message="Mindestens eine Zutat muss ausgewählt werden")
  // tag::allButValidation[]
  private List<String> ingredients;

}
//end::allButValidation[]
//tag::end[]