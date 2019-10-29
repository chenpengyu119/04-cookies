package src.com.yu.day08;

public class Person<T> implements Comparable{
	private String name;
	private int age;
	private String gender;

	public Person(){

	}

	@Override
	public int compareTo(Object o) {
		Person person=(Person )o;
		if (this.age<person.age){
			return -1;
		}else if (this.age>person.age){
			return 1;
		}else {
			return this.name.compareTo(person.name);
		}
	}

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}

	public void show(){

		toString();
	}


}