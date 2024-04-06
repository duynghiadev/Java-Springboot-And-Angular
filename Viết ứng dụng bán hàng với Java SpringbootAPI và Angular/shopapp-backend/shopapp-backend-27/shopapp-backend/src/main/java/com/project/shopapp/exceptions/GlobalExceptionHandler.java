package com.project.shopapp.exceptions;


import com.project.shopapp.responses.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice // Chỉ định lớp này xử lý ngoại lệ chung
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseObject> handleGeneralException(Exception exception) {
        return ResponseEntity.internalServerError().body(
           ResponseObject.builder()
                   .status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .message(exception.getMessage())
                   .build()
        );
    }
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleResourceNotFoundException(DataNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseObject.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build());
    }

}
