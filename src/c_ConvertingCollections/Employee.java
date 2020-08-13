package c_ConvertingCollections;

public class Employee {

	private Integer Id;
	private String name;
	private Integer salary;

	public Employee(Integer id, String name, Integer salary) {
		super();
		Id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public Integer getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "[Id=" + Id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}
