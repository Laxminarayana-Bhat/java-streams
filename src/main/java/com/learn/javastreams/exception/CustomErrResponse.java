package com.learn.javastreams.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomErrResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
