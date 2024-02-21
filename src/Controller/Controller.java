package Controller;

import Model.Student;
import Model.StudyGroup;
import Model.Teacher;
import Service.StudyGroupService;
import Model.Type;
import Model.User;
import Service.DataService;
import View.StudentView;

import java.util.List;

public class Controller {
    private final DataService service = new DataService();

    private final StudentView view = new StudentView();

    private final StudyGroupService studyGroupService = new StudyGroupService();

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        return studyGroupService.createStudyGroup(teacherId, studentIds);
    }

    public void createStudent(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }

    public void getAllStudent() {
        List<User> userList = service.getAllStudent();
        for (User user : userList) {
            Student student = (Student) user;
            view.printOnConsole(student);
        }
    }
}
