		
		public class Employee {

		    private String name;
		    private String city;
		    private Integer salary;
		    private String department;

		    //Constructors

		    //Getters

		    @Override
		    public String toString() {
			return "{name=" + name + ", city=" + city + ", salary=" + salary + ", department=" + department + "}";
		    }

		}
	
##

                List<Employee> empList = Arrays.asList(
                new Employee("Naveen"  , "Bangalore" , 100000  ,  "Finance"),
                new Employee("Vinod"   , "Bangalore" , 80000   ,  "IT"),
                new Employee("Nitin"   , "Bangalore" , 50000   ,  "IT"),
                new Employee("Abhishek", "Bangalore" , 20000   ,  "IT"),
                new Employee("Saurav"  , "Bangalore" , 10000   ,  "HR"),
                new Employee("Gaurav"  , "Bokaro"    , 5000    ,  "HR")
                );

##

        /**
         * 1 - More Operations : Map,Filter,Sorted,Limit,Collect 
         */
		List<Employee> empList2 = 
				 empList.stream() 
				.filter(employee -> "Bangalore".equals(employee.getCity()))
				.limit(4)
				.map(e -> new Employee(e.getName().toLowerCase(), e.getCity()))
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		
		
		System.out.println(empList2);
		
##
		
       /**
        * 2 - Print Employee with Maximum or Minimum Salary : max() , min()  
        */
	   Employee employeeWithMaxSalary = empList
					.stream()
					.max(Comparator.comparing(Employee::getSalary))
					.orElseThrow(NoSuchElementException::new);
		
		
	   System.out.println("Employee with Max salalry" + employeeWithMaxSalary);
		
	
	
##

	/**
	 * Get 3 Employees with Lowest Salary 
	 */
	    List<Employee> empList3 = empList.stream() 
				.sorted(Comparator.comparing(Employee::getSalary))
				.limit(3)
				.collect(Collectors.toList());
		
		
	    System.out.println(empList3);
	
	
##
	
	 /**
	  * Get 3 Employees with Top salaries
	  */
	     List<Employee> empList4 = empList.stream() 
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.limit(3)
				.collect(Collectors.toList());
		
		
	     System.out.println(empList4);
    