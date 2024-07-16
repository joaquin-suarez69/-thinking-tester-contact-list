package models;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String phone;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
