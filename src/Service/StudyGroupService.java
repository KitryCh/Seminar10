package Service;

import Model.StudyGroup;
import Model.Student;
import Model.Teacher;
import Model.Type;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {
    private final DataService service = new DataService();

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = (Teacher) service.getUserById(Type.TEACHER, teacherId);
        List<Student> students = new ArrayList<>();
        for (int studentId : studentIds) {
            students.add((Student) service.getUserById(Type.STUDENT, studentId));
        }
        return new StudyGroup(teacher, students);
    }
}