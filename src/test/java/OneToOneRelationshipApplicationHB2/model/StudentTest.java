package OneToOneRelationshipApplicationHB2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class StudentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Student}
     *   <li>{@link Student#setCode(String)}
     *   <li>{@link Student#setCollege_Name(String)}
     *   <li>{@link Student#setFirst_Name(String)}
     *   <li>{@link Student#setLast_Name(String)}
     *   <li>{@link Student#setStudent_Id(int)}
     *   <li>{@link Student#setUniversity(University)}
     *   <li>{@link Student#getCode()}
     *   <li>{@link Student#getUniversity()}
     *   <li>{@link Student#getCollege_Name()}
     *   <li>{@link Student#getFirst_Name()}
     *   <li>{@link Student#getLast_Name()}
     *   <li>{@link Student#getStudent_Id()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        actualStudent.setCode("Code");
        actualStudent.setCollege_Name("College Name");
        actualStudent.setFirst_Name("Jane");
        actualStudent.setLast_Name("Doe");
        actualStudent.setStudent_Id(1);
        Student student = new Student();
        student.setCode("Code");
        student.setCollege_Name("College Name");
        student.setFirst_Name("Jane");
        student.setLast_Name("Doe");
        student.setStudent_Id(1);
        University university = new University();
        student.setUniversity(university);
        University university2 = new University();
        university2.setStudent(student);
        university2.setUniversity_Address("42 Main St");
        university2.setUniversity_Email("jane.doe@example.org");
        university2.setUniversity_Id(1);
        university2.setUniversity_Name("University Name");
        Student student2 = new Student();
        student2.setCode("Code");
        student2.setCollege_Name("College Name");
        student2.setFirst_Name("Jane");
        student2.setLast_Name("Doe");
        student2.setStudent_Id(1);
        student2.setUniversity(university2);
        University university3 = new University();
        university3.setStudent(student2);
        university3.setUniversity_Address("42 Main St");
        university3.setUniversity_Email("jane.doe@example.org");
        university3.setUniversity_Id(1);
        university3.setUniversity_Name("University Name");
        actualStudent.setUniversity(university3);
        assertEquals("Code", actualStudent.getCode());
        University university4 = actualStudent.getUniversity();
        Student student3 = university4.getStudent();
        assertEquals("Code", student3.getCode());
        University university5 = student3.getUniversity();
        Student student4 = university5.getStudent();
        assertEquals("Code", student4.getCode());
        assertEquals("College Name", actualStudent.getCollege_Name());
        assertEquals("College Name", student3.getCollege_Name());
        assertEquals("College Name", student4.getCollege_Name());
        assertEquals("Jane", actualStudent.getFirst_Name());
        assertEquals("Jane", student3.getFirst_Name());
        assertEquals("Jane", student4.getFirst_Name());
        assertEquals("Doe", actualStudent.getLast_Name());
        assertEquals("Doe", student3.getLast_Name());
        assertEquals("Doe", student4.getLast_Name());
        assertEquals(1, actualStudent.getStudent_Id());
        assertEquals(1, student3.getStudent_Id());
        assertEquals(1, student4.getStudent_Id());
        assertSame(university3, university4);
        assertSame(university2, university5);
        assertSame(university, student4.getUniversity());
    }
}

