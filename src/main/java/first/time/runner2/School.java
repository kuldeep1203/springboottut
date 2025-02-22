package first.time.runner2;


import jakarta.persistence.*;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private School(){}
    private School (String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
