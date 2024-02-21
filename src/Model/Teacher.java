package Model;

public class Teacher extends User {

    public Teacher(String firstName, String lastName, String middleName, int teacherId) {
        super(firstName, lastName, middleName);
        this.teacherId = teacherId;
    }

    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
