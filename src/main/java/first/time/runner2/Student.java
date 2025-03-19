package first.time.runner2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
        @Id//defines primary key for the table
        @GeneratedValue
        private Integer id;
        @Column(name="c_fname",
        length = 20
        )
        private String firstname ;
        private String lastname;

        @Column(unique  = true)
        private String email;
        private Integer age ;

        @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
        private StudentProfile studentProfile;

        @ManyToOne
        @JoinColumn(name = "school_id")//school_id will act as a foreign key in the student table
        @JsonBackReference
        private School school;

        public void  setSchool(School school){
                this.school = school;
        }

        public School getSchool(){
                return this.school;
        }

        public StudentProfile getStudentProfile(){
                return this.studentProfile;
        }
        public void setStudentProfile(StudentProfile studentProfile){
                this.studentProfile = studentProfile;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }



}