package edu.miu.cs.cs544.ether.restcontroller;

import edu.miu.cs.cs544.ether.dal.entitiy.Student;
import edu.miu.cs.cs544.ether.service.customexpection.StudentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class StudentRestExceptionHandler  {
    //Add an exception handler for StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<Student> handlerException(StudentNotFoundException exc){
        //create StudentErrorResponse

        return null;
    }
    //Add another exception handler ... to catch any exception(catch all)
}
