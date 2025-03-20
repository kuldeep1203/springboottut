package first.time.runner2.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepostiory  schoolRepostiory;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepostiory schoolRepostiory ,  SchoolMapper schoolMapper){
        this.schoolRepostiory = schoolRepostiory;
        this.schoolMapper = schoolMapper;
    }

    public schoolDto createSchool(schoolDto dto){
        var school = schoolMapper.toSchool(dto);
        var savedSchool = schoolRepostiory.save(school);
        return dto;
    }

    public List<schoolDto> findallSchools(){
        return schoolRepostiory.findAll().stream().map(schoolMapper::schoolDto).collect(Collectors.toList());
    }
}
