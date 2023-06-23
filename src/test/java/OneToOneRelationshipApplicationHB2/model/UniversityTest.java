package OneToOneRelationshipApplicationHB2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class UniversityTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link University}
     *   <li>{@link University#setStudent(Student)}
     *   <li>{@link University#setUniversity_Address(String)}
     *   <li>{@link University#setUniversity_Email(String)}
     *   <li>{@link University#setUniversity_Id(int)}
     *   <li>{@link University#setUniversity_Name(String)}
     *   <li>{@link University#getStudent()}
     *   <li>{@link University#getUniversity_Address()}
     *   <li>{@link University#getUniversity_Email()}
     *   <li>{@link University#getUniversity_Id()}
     *   <li>{@link University#getUniversity_Name()}
     * </ul>
     */
    @Test
    void testConstructor() {
        University actualUniversity = new University();
        University university = new University();
        Student student = new Student();
        university.setStudent(student);
        university.setUniversity_Address("42 Main St");
        university.setUniversity_Email("jane.doe@example.org");
        university.setUniversity_Id(1);
        university.setUniversity_Name("University Name");
        Student student2 = new Student();
        student2.setCode("Code");
        student2.setCollege_Name("College Name");
        student2.setFirst_Name("Jane");
        student2.setLast_Name("Doe");
        student2.setStudent_Id(1);
        student2.setUniversity(university);
        University university2 = new University();
        university2.setStudent(student2);
        university2.setUniversity_Address("42 Main St");
        university2.setUniversity_Email("jane.doe@example.org");
        university2.setUniversity_Id(1);
        university2.setUniversity_Name("University Name");
        Student student3 = new Student();
        student3.setCode("Code");
        student3.setCollege_Name("College Name");
        student3.setFirst_Name("Jane");
        student3.setLast_Name("Doe");
        student3.setStudent_Id(1);
        student3.setUniversity(university2);
        actualUniversity.setStudent(student3);
        actualUniversity.setUniversity_Address("42 Main St");
        actualUniversity.setUniversity_Email("jane.doe@example.org");
        actualUniversity.setUniversity_Id(1);
        actualUniversity.setUniversity_Name("University Name");
        Student student4 = actualUniversity.getStudent();
        assertSame(student3, student4);
        University university3 = student4.getUniversity();
        Student student5 = university3.getStudent();
        assertSame(student2, student5);
        University university4 = student5.getUniversity();
        assertSame(student, university4.getStudent());
        assertEquals("42 Main St", actualUniversity.getUniversity_Address());
        assertEquals("42 Main St", university3.getUniversity_Address());
        assertEquals("42 Main St", university4.getUniversity_Address());
        assertEquals("jane.doe@example.org", actualUniversity.getUniversity_Email());
        assertEquals("jane.doe@example.org", university3.getUniversity_Email());
        assertEquals("jane.doe@example.org", university4.getUniversity_Email());
        assertEquals(1, actualUniversity.getUniversity_Id());
        assertEquals(1, university3.getUniversity_Id());
        assertEquals(1, university4.getUniversity_Id());
        assertEquals("University Name", actualUniversity.getUniversity_Name());
        assertEquals("University Name", university3.getUniversity_Name());
        assertEquals("University Name", university4.getUniversity_Name());
    }
}

