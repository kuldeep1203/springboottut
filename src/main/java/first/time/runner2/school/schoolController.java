package first.time.runner2.school;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class schoolController {

    private final SchoolService schoolService;

    public schoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public schoolDto create(@RequestBody schoolDto dto){
        return schoolService.createSchool(dto);
    }
    @GetMapping("/schools")
    public List<schoolDto> findallSchools(){
        return schoolService.findallSchools();
    }





}
