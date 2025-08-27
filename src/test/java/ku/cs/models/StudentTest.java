package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;
    @BeforeEach
    void init() {
        s = new Student("67xxxxxxxx5", "Piyalin");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน  70.1")
    void testAddScore() {
        s.addScore(70.1);
        assertEquals(70.1, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด")
    void testCalculateGrade() {
        s.addScore(90);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบ ID")
    void TestIsId() {
        assertTrue(s.isId("67xxxxxxxx5"));
    }

    @Test
    @DisplayName("ทดสอบในชื่อว่าไม่มี String ตัวที่ระบุ")
    void TestIsName() {
        assertTrue(s.isNameContains("Piyalin"));
    }
}