package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    StudentList studentList;
    @BeforeEach
    void init() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน / เพิ่มพร้อมคะแนน")
    void testAddNewStudent() {
        studentList.addNewStudent("67xxxxxxxx", "One");
        assertTrue(!studentList.getStudents().isEmpty());
        studentList = new StudentList();
        studentList.addNewStudent("67xxxxxxxx", "Tester", 100);
        assertEquals(studentList.getStudents().get(0).getScore(), 100);
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วยชื่อ")
    void testFindStudentById() {
        studentList.addNewStudent("67xxxxxxxx", "One");

        Student s = new Student("67xxxxxxxx", "One");
        Student findStudent = studentList.findStudentById("67xxxxxxxx");
        assertEquals(findStudent.getId(), s.getId());
        assertEquals(findStudent.getName(), s.getName());
    }

    @Test
    @DisplayName("ทดสอบการกรองชื่อนักเรียนด้วยฟิลเตอร์")
    void testFilterByName() {
        studentList.addNewStudent("67xxxxxxx1", "Pobpa");
        studentList.addNewStudent("67xxxxxxx2", "Pobrak");
        studentList.addNewStudent("67xxxxxxx3", "Pobjer");
        studentList.addNewStudent("67xxxxxxx1", "Manod");
        StudentList filterStudents = studentList.filterByName("Pob");

        StudentList correctFilterStudent = new StudentList();
        correctFilterStudent.addNewStudent("67xxxxxxx1", "Pobpa");
        correctFilterStudent.addNewStudent("67xxxxxxx2", "Pobrak");
        correctFilterStudent.addNewStudent("67xxxxxxx3", "Pobjer");
        assertEquals(filterStudents.getStudents().toString(), correctFilterStudent.getStudents().toString());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนตาม Student ID")
    void testGiveScoreToId(){
        studentList.addNewStudent("67xxxxxxxx1", "Pobpa");
        studentList.giveScoreToId("67xxxxxxxx1", 100);
        assertEquals(studentList.getStudents().get(0).getScore(), 100);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดด้วย Student ID")
    void testViewGradeId(){
        studentList.addNewStudent("67xxxxxxxx3", "Manod", 65);
        assertEquals(studentList.getStudents().get(0).getScore(), 65);
    }
}