package com.ami.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {
    //private Long customerId;
    @NotEmpty(message="Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account Number should be in numeric format")
    private Long accountNumber;
    @NotEmpty(message="Account Type cannot be null or empty")
    private String accountType;
    @NotEmpty(message="Brancg Address cannot be null or empty")
    private String branchAddress;
}
