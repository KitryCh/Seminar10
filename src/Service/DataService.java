package Service;

import Model.Student;
import Model.Teacher;
import Model.Type;
import Model.User;

import java.util.ArrayList;
import java.util.List;
public class DataService {
    private List<User> userList;

    public void create(String firstName, String lastName, String middleName, Type type) {
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }
    }

    public User getUserById(Type type, int id) {
        boolean itsStudent = Type.STUDENT == type;
        User currentuser = null;

        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id) {
                currentuser = user;
            }
            if (user instanceof Student && !itsStudent && ((Student) user).getStudentId() == id) {
                currentuser = user;
            }
        }
        return currentuser;
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public List<User> getAllStudent(){
        List<User> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }
    private int getFreeId(Type type) {
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && !itsStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }
}
