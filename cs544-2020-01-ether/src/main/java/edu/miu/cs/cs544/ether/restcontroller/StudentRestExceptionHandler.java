package edu.miu.cs.cs544.ether.restcontroller;

import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.restcontroller.customexpection.StudentErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class StudentRestExceptionHandler  {
    //Add an exception handler for StudentNotFoundException
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc){
//        //create StudentErrorResponse
//
//        return null;
//    }
//    //Add another exception handler ... to catch any exception(catch all)
}
