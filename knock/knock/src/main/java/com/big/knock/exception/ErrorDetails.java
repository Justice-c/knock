package com.big.knock.exception;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
