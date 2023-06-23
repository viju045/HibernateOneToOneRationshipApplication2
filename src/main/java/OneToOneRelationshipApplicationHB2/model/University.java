package OneToOneRelationshipApplicationHB2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity//represent hole domain class
@Table(name = "university")//Create table in database
public class University {
    @Id//primary key of table
    @GeneratedValue(strategy = GenerationType.AUTO)//Auto increment of primary key in table
    private int university_Id;
    @OneToOne(mappedBy = "university")//represents a single-valued association where an instance of one entity is associated with an instance of another entity.
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)//hibernate to automatically manage the state of mapped entity whenever the state of its relationship owner entity is affected.
    private Student student;
    private String University_Name;
    private String University_Address;
    private String University_Email;

    public int getUniversity_Id() {
        return university_Id;
    }

    public void setUniversity_Id(int university_Id) {
        this.university_Id = university_Id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUniversity_Name() {
        return University_Name;
    }

    public void setUniversity_Name(String university_Name) {
        University_Name = university_Name;
    }

    public String getUniversity_Address() {
        return University_Address;
    }

    public void setUniversity_Address(String university_Address) {
        University_Address = university_Address;
    }

    public String getUniversity_Email() {
        return University_Email;
    }

    public void setUniversity_Email(String university_Email) {
        University_Email = university_Email;
    }
}
