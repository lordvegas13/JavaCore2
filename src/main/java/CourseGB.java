public class CourseGB implements Course {
    private String nameCourser;

    public CourseGB(String nameCourser) {
        this.nameCourser = nameCourser;
    }

    @Override
    public String toString() {
        return  nameCourser ;

    }

    public String getNameCourser() {
        return nameCourser;
    }

    public void setNameCourser(String nameCourser) {
        this.nameCourser = nameCourser;
    }
}