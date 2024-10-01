package com.ami.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Accounts",
        description = "Schema to hold Account Information"
)
public class AccountsDTO {
    //private Long customerId;
    @Schema(name="Account Number",description = "Account Number of Bank Account",example = "123456789")
    @NotEmpty(message="Account number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account Number should be in numeric format")
    private Long accountNumber;
    @Schema(name = "Account Type",description = "Account Type of Bank Account", example = "Savings")
    @NotEmpty(message="Account Type cannot be null or empty")
    private String accountType;
    @Schema(name="Branch Address", description="Branch Address of the Bank",example = "Churchgate,Mumbai")
    @NotEmpty(message="Branch Address cannot be null or empty")
    private String branchAddress;
}
