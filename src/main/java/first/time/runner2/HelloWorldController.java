package first.time.runner2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    private final StudentService studentService;

    public HelloWorldController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ){
        this.studentService.saveStudent(dto);
        //return " Request accepeted and message is ";
    }

    @GetMapping("/students/{student_id}")
    public Student findStudentById( @PathVariable("student_id") Integer id){
         return studentService.findStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> findallStudents(){
         return studentService.findallStudents();
    }


    @GetMapping("/students/search/{student-name}")
    public List<Student>  findAllStudents(@PathVariable("student-name") String id){
        return studentService.findAllStudents(id);
    }

    @ DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
         studentService.delete(id);
    }





    // Assuming Order is a custom class

}
