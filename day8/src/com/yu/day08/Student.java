package src.com.yu.day08;

public class Student extends src.com.yu.day08.Person {

    private  String stuNo;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }


    public Student(String name, int age, String gender, String stuNo) {
        super(name, age, gender);
        this.stuNo = stuNo;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("学号:"+stuNo);
    }
}
