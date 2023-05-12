package data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Student{
    final String name;
    final String surname;
    final int course;

    Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }


}

public class MapTest {


    public static void main(String[] args) {

        Student st1 = new Student2("Mark", "Yolberg", 2);
        Student st2 = new Student2("Dima", "Cock", 4);
        Student st3 = new Student2("Tania", "loh", 1);
        Student st4 = new Student2("John", "Kennedy", 3);
        Student st5 = new Student2("Lelik", "Bolik", 4);
        Student st6 = new Student2("Igor", "Man", 1);
        Student st7 = new Student2("Chris", "Mack", 3);
        Student st8 = new Student2("Nick", "Outhead", 0);
        Student st9 = new Student2("Mad", "Wolf", 1);

        Map <Double,Student> m1 = new TreeMap<>();
        m1.put(0.1, st1);
        m1.put(5.5,st2);
        m1.put(2.3,st3);
        m1.put(1.2, st4);
        m1.put(3.4,st5);
        m1.put(5.2,st6);
        m1.put(1.4, st7);
        m1.put(1.6,st8);
        m1.put(5.8,st9);
        m1.put(6.2,new Student2("Kayce", "Locef", 2));
        //System.out.println(m1);
        m1.forEach((key, value) -> System.out.println("Mark: " + key + value));
        System.out.println("=================================================");
        m1.remove(1.4);
        m1.forEach((key, value) -> System.out.println("Mark: " + key + value));
        System.out.println(m1.containsValue(new Student2("Nick", "Outhead", 0)));

        //Map m2 = new HashMap<Integer,String>();
    }
}
/*class student {
    String Name = Name;

}*/
class Student2 extends Student{
    Student2(String name, String surname, int course) {
        super(name, surname, course);
    }
    @Override
    public String toString() {
        return "\n" + "name: " + name
                + "\n surname: " + surname +
                "\n course: " + course + "\n";
    }



}