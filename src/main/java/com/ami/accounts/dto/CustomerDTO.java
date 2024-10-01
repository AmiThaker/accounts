package com.ami.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        name="Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDTO {

    @NotEmpty(message="Name cannot be null or empty!")
    @Size(min=3,max=30,message="the length of the name should be between 3 and 30")
    @Schema(
            name="Name of the Customer",
            example = "Ami"
    )
    private String name;
    @NotEmpty(message="Email cannot be null or empty!")
    @Email(message="Email should be a valid value")
    @Schema(
            name="Email of the Customer",
            example = "customer@gmail.com"
    )
    private String email;
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{10})",message="Mobile Number should be 10 digits")
    @Schema(
            name="Mobile Number of the Customer",
            example="1234567890"
    )
    private String mobileNumber;
    private AccountsDTO accountsDTO;
}
