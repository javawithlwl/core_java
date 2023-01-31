package com.careerit.iplstats.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

    private String message;
    private HttpStatus httpStatus;
    private String path;
    private LocalDateTime dateTime;
}
