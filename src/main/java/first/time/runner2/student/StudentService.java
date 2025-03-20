package first.time.runner2.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper){
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public  List<StudentResponseDto> findAllByFirstname(String name ){
        return repository.findAllByFirstnameContaining(name).stream().map(studentMapper::tostudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto saveStudent(  StudentDto dto){
        var student =studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }
    public StudentResponseDto findStudentById( Integer id){
        return repository.findById(id).map(studentMapper::tostudentResponseDto).orElse(null);
    }
    public List<StudentResponseDto> findallStudents(){
        return repository.findAll().stream().map(studentMapper::tostudentResponseDto).collect(Collectors.toList());

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
