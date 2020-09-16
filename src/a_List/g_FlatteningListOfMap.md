

	
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
			return "{Id=" + Id + ", name=" + name + ", salary=" + salary + "}";
		}

		}

##

                
		Map<Integer, Employee> map1 = new HashMap<>();
		map1.put(1, new Employee(1, "Nitin", 80000));
		map1.put(2, new Employee(2, "Abhi", 50000));

		Map<Integer, Employee> map2 = new HashMap<>();
		map1.put(3, new Employee(3, "Saurav", 20000));
		map1.put(4, new Employee(4, "Gaurav", 10000));

		List<Map<Integer, Employee>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		

		Map<Integer, Employee> flattenedList = list.stream()
				                       .flatMap(object -> object.entrySet().stream())
				                       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(flattenedList.values());
		
----------------------------------------------------------------------------------------------------------------------


               Output :
	       
		[
		 {Id=1, name=Nitin,  salary=80000}, 
		 {Id=2, name=Abhi,   salary=50000}, 
		 {Id=3, name=Saurav, salary=20000}, 
		 {Id=4, name=Gaurav, salary=10000}
		]

		
