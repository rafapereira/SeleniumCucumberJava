package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private String lastName;
    private String contactFirstName;
    private String phone;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String creditLimit;
}