package edu.miu.cs.cs544.ether.restcontroller.customexpection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler  {
    //Add an exception handler for StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc){
        //create StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    //Add another exception handler ... to catch any exception(catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(Exception exc){
        //create StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
