package first.time.runner2;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class schoolController {

    private final SchoolRepostiory  schoolRepostiory;

    public schoolController(SchoolRepostiory schoolRepostiory) {
        this.schoolRepostiory = schoolRepostiory;
    }

    @PostMapping("/schools")
    public schoolDto create(@RequestBody schoolDto dto){
        var school = toSchool(dto);
        var savedSchool = schoolRepostiory.save(school);
        return dto;
    }
    @GetMapping("/schools")
    public List<schoolDto> findallSchools(){
        return schoolRepostiory.findAll().stream().map(this::schoolDto).collect(Collectors.toList());
    }

    private schoolDto schoolDto(School school){
        return new schoolDto(school.getName());
    }

    private School toSchool(schoolDto dto){
        return new School(dto.name());
    }

}
