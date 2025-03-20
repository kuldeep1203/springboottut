package first.time.runner2.studentProfile;


import first.time.runner2.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

    private StudentProfile(){}
    private StudentProfile(String bio){
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
