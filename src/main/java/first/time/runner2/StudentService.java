package first.time.runner2;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper){
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(  StudentDto dto){
        var student =studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }
    public Student findStudentById( Integer id){
        return repository.findById(id).orElse(new Student());
    }
    public List<Student> findallStudents(){
        return repository.findAll();
    }

    public List<Student>  findAllStudents(String id){
        return repository.findAllByFirstnameContaining(id);
    }

    public void delete(
          Integer id
    ){
        repository.deleteById(id);
    }

}
