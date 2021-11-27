import java.util.ArrayList;
import java.util.List;

public class StudentGB implements Student{

    private String name;
    private List<Course> courses;


    public StudentGB(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses == null ? new ArrayList<>(0) : courses;

    }

    //public StudentGB(String name) {
    //  this.name = name;}

    @Override
    public String toString() {
        return  name + courses;
    }

    @Override
    public List<List<StudentGB>> getName() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        CourseGB courseGB1 = new CourseGB("Java. Быстрый старт");
        CourseGB courseGB2= new CourseGB("Основы языка Python");

        CourseGB courseGB3 = new CourseGB("Основы языка C#");
        CourseGB courseGB4 = new CourseGB("Java.Уровень2");
        CourseGB courseGB5 = new CourseGB("С#. Мини- программы");
        CourseGB courseGB6 = new CourseGB("JavaCore");

        List<CourseGB>courseGBS= new ArrayList<>();
        courseGBS.add(courseGB1);
        courseGBS.add(courseGB2);
        courseGBS.add(courseGB3);
        courseGBS.add(courseGB4);
        courseGBS.add(courseGB5);
        courseGBS.add(courseGB6);
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }


}