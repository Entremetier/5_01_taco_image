package tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "Namen eingeben")
    private String name;

    @NotBlank(message = "Straße eingeben")
    private String street;

    @NotBlank(message = "Stadt eingeben")
    private String city;

    @NotBlank(message = "Bundesland eingeben")
    private String state;

    @NotBlank(message = "Postleizzahl eingeben")
    private String zip;

    @CreditCardNumber(message = "Kreditkartennummer eingeben")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9] 1[0-2])([\\/])([1-9] [0-9])$", message = "CVV im Format MM/YY eingeben")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "CVV eingeben")
    private String ccCVV;

}
