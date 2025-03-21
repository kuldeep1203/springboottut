package first.time.runner2.student;

import first.time.runner2.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public StudentResponseDto tostudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstname(),
                student.getLastname(),
                student.getEmail());
    }

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }
}
