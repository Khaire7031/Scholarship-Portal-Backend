package com.pdk.scolarship.Dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    private String gender;

    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    private String location;

    @NotEmpty(message = "Contact number cannot be empty")
    @Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits")
    private String contactNumber;
}
