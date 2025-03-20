package first.time.runner2.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(schoolDto dto){
        return new School(dto.name());
    }
    public schoolDto schoolDto(School school){
        return new schoolDto(school.getName());
    }
}
