package first.time.runner2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    private final StudentRepository repository;

     public HelloWorldController(StudentRepository repository){
         this.repository = repository;
     }


    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "HelloWorld";
    }

    @GetMapping(path = "/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    // The @ResponseStatus annotation in Spring is used to mark a method or an exception class with a specific HTTP status code that should be sent in the HTTP response.
    // When applied to a method, it will instruct Spring to automatically set the status code for the HTTP response whenever that method is called.
    public String helloWorld2() {
        return "HelloWorld2";
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ){
        return repository.save(student);
        //return "Request accepeted and message is ";
    }

    @GetMapping("/students/{student_id}")
    public Student findStudentById( @PathVariable("student_id") Integer id){
         return repository.findById(id).orElse(new Student());
    }
    @GetMapping("/students")
    public List<Student> findallStudents(){
         return repository.findAll();
    }
    @GetMapping("/students/search/{student-name}")
    public List<Student>  findAllStudents(@PathVariable("student-name") String id){
        return repository.findAllByFirstnameContaining(id);
    }
    @ DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
         repository.deleteById(id);
    }



    // Assuming Order is a custom class

}
