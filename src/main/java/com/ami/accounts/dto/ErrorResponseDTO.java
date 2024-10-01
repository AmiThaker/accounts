package com.ami.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name="ErrorResponse",
        description = "Schema to hold Error Response"
)
public class ErrorResponseDTO {

    @Schema(
            description = "API Path invoked by the client"
    )
    private String apiPath;
    @Schema(
            description = "Error Code representing the error happened"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error Message representing the error happened"
    )
    private String errorMessage;
    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime errorTime;
}
