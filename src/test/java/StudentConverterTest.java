

import org.junit.Test;
import org.uc_7.model.Student;
import org.uc_7.service.StudentConverter;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class StudentConverterTest {

    List<Student> expectedStudents;

    @Test
    public void testStudentIsHighAchiever() {
        expectedStudents = new StudentConverter().convertStudents(List.of(new Student("John", 21, 91)));
        assertTrue(expectedStudents.get(0).isHonorRoll());
    }

    @Test
    public void testStudentIsExceptionalYoungHighAchiever() {
        expectedStudents = new StudentConverter().convertStudents(List.of(new Student("Dan", 17, 91)));
        assertTrue(expectedStudents.get(0).isExceptional());
    }

    @Test
    public void testStudentIsPassed() {
        expectedStudents = new StudentConverter().convertStudents(List.of(new Student("Van", 17, 88)));
        assertTrue(expectedStudents.get(0).isPassed());
    }

    @Test
    public void testStudentIsFailed() {
        expectedStudents = new StudentConverter().convertStudents(List.of(new Student("Sam", 17, 66)));
        assertFalse(expectedStudents.get(0).isPassed());
    }

    @Test
    public void testStudentsListIsEmpty() {
        expectedStudents = new StudentConverter().convertStudents(Collections.emptyList());
        assertTrue(expectedStudents.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testStudentsListIsNullValue() {
        new StudentConverter().convertStudents(null);
    }
}
