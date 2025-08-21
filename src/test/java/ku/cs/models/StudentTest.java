package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;
    @BeforeEach
    void init() {
        s = new Student("67xxxxxxxx", "Tester");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน  40.1")
    void testAddScore() {
        s.addScore(40.1);
        assertEquals(40.1, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด")
    void testCalculateGrade() {
        Student s = new Student("67xxxxxxxx", "Tester");
        s.addScore(90);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบ ID")
    void TestIsId() {
        assertTrue(s.isId("67xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบ isName")
    void TestIsName() {
        assertTrue(s.isNameContains("Tester"));
    }
}