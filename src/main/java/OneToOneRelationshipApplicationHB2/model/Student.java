package OneToOneRelationshipApplicationHB2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
//This is my second One To One relationship application in hibernate.
@Entity//Represent Hole domain class
@Table(name = "stud")//Create Table in DataBase.
public class Student {
    @Id//its primary key of table.
    @GeneratedValue(generator = "gen")//Auto increment primary key.
    //@GenericGenerator -> A hibernate annotation used to denote custom generator.
    @GenericGenerator(name ="gen",strategy = "foreign",parameters ={@org.hibernate.annotations.Parameter(name = "property",value = "university")} )

    private int Student_Id;
    private String First_Name;
    private String last_Name;
    private String College_Name;
   private String code;
   @OneToOne//represents a single-valued association where an instance of one entity is associated with an instance of another entity.
   @PrimaryKeyJoinColumn// Hibernate is used to specify the primary key of the associated entity as the foreign key of the current entity.
   private University university;

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getCollege_Name() {
        return College_Name;
    }

    public void setCollege_Name(String college_Name) {
        College_Name = college_Name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
