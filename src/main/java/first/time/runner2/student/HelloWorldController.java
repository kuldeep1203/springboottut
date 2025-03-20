package first.time.runner2.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@RestController
public class HelloWorldController {

    private final StudentService studentService;

    public HelloWorldController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
           @Valid @RequestBody StudentDto dto
    ){
       return  this.studentService.saveStudent(dto);
    }

    @GetMapping("/students/{student_id}")
    public StudentResponseDto findStudentById( @PathVariable("student_id") Integer id){
         return studentService.findStudentById(id);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findallStudents(){
        return studentService.findallStudents();
    }


    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto>  findAllStudentByName(@PathVariable("student-name") String id){
        return studentService.findAllByFirstname(id);
    }

    @ DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
         studentService.delete(id);
    }

    //Exception handler to intercept the exceptions occuring in controller methods
    //<?> wildcard response type
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String,String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }





    // Assuming Order is a custom class

}
