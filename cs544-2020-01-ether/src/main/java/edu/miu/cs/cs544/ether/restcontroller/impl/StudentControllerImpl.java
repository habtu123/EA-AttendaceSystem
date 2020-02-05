package edu.miu.cs.cs544.ether.restcontroller.impl;

import edu.miu.cs.cs544.ether.dal.entity.Student;
import edu.miu.cs.cs544.ether.exception.StudentNotFoundException;
import edu.miu.cs.cs544.ether.restcontroller.StudentController;
import edu.miu.cs.cs544.ether.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "View a list of available Student", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(value = "/Students", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    //@Secured({"ROLE_ADMIN","ROLE_FACULTY"})
    public List<Student> getAll() {
        return studentService.getAll();
    }

//    @ApiOperation(value = "View a particular Student", response = List.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

//    @GetMapping(value="/StudentId/{StudentId}",produces = MediaType.APPLICATION_JSON_VALUE)
//    @Override
//    public Student getById(@PathVariable Long Id) {
//        return studentService.getById(Id);
//    }
    
    @ApiOperation(value = "View a particular Student by StudentId", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping(value="/Students/StudentId/{StudentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Student getByStudentId(@PathVariable  String StudentId) throws StudentNotFoundException  {
        return studentService.getByStudentId(StudentId);
    }

    @ApiOperation(value = "Create new Student", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/Students",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Student create(@RequestBody @Valid Student Student) {
        return studentService.create(Student);
    }



    @ApiOperation(value = "Update a particular Student", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @Override
    @PutMapping(value = "/Students/StudentId/{StudentId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student update(@RequestBody @Valid Student Student,@PathVariable String StudentId ) throws StudentNotFoundException {
        Student currentStudent=studentService.getByStudentId(StudentId);
        if (currentStudent==null)
           throw new StudentNotFoundException("StudentId Not Found- "+ StudentId);
        studentService.update(Student);
        return Student;
    }

    @ApiOperation(value = "Delete a particular Student", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @Override
    @DeleteMapping(value = "/Students/StudentId/{StudentId}")
    public void delete(@PathVariable String StudentId) {
        Student Student=studentService.getByStudentId(StudentId);
        if (Student!=null)
            studentService.delete(Student);
    }
}
