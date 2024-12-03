package ma.nabil.ebanking.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorDto {
    private String message;
    private int status;
    private LocalDateTime timestamp = LocalDateTime.now();
}