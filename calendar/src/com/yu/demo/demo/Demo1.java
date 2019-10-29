package src.com.yu.demo.demo;

public class Demo1 {

    private String stuId;
    public void setStuId(String stuId) throws Exception { // 1
        if (stuId.length() != 4) { // 2
			throw new Exception("学号必须为4位!"); // 3
        } else {
            this.stuId = stuId;     //4
        }
    }



}
