package tacos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message="Bitte Namen angeben")
    private String deliveryName;

    @NotBlank(message="Bitte Straße angeben")
    private String deliveryStreet;

    @NotBlank(message="Bitte Stadt angeben")
    private String deliveryCity;

    @NotBlank(message="Bitte Bundesland angeben")
    private String deliveryState;

    @NotBlank(message="Bitte Postleitzahl angeben")
    private String deliveryZip;

    @CreditCardNumber(message="Bitte Kreditkartennummer angeben")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Ablaufdatum im Format MM/YY angeben")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Bitte CVV angeben")
    private String ccCVV;

  /*
  //tag::allButDetailProperties[]
  ...

  //end::allButDetailProperties[]
   */

    //tag::allButDetailProperties[]
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
//end::allButDetailProperties[]
