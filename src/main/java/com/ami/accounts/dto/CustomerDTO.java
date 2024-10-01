package com.ami.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @NotEmpty(message="Name cannot be null or empty!")
    @Size(min=3,max=30,message="the length of the name should be between 3 and 30")
    private String name;
    @NotEmpty(message="Email cannot be null or empty!")
    @Email(message="Email should be a valid value")
    private String email;
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{10})",message="Mobile Number should be 10 digits")
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
