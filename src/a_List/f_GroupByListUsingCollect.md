# Employee.java

    public class Employee {  
      private String name;
      private String city;
      private String department;
      private int salary;
      
      // Getters | Setters
    }

# MyMain.java

    public class MyMain {
	public static void main(String[] args) {

	  List<Employee> empList = Arrays.asList(
             new Employee("Naveen"  , "Bangalore", "Finance" , 100000),
             new Employee("Vinod"   , "Indore"   , "IT"      , 80000),
             new Employee("Nitin"   , "Bangalore", "IT"      , 50000),
             new Employee("Abhishek", "Patna"    , "IT"      , 20000),
             new Employee("Saurav"  , "Dhanbad"  , "HR"      , 10000),
             new Employee("Gaurav"  , "Bokaro"   , "HR"      , 5000)
           );
        } 
    }

# Problem 1 : Group Employees by Department & Get all Employees   

    Map<String,List<Employee>> groupEmployeeByDepartment = new HashMap<>();
        
    groupEmployeeByDepartment =  empList.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment));
				     
    groupEmployeeByDepartment.forEach((key,value) -> System.out.println(key + ":" + value));

 Output : 

     {
       "Finance": [
	      { "name": "Naveen", "city": "Bangalore", "department": "Finance", "salary": 100000 }
	  ], 
	  
       "HR": [
	      {  "name": "Saurav", "city": "Dhanbad", "department": "HR", "salary": 10000 },
	      {  "name": "Gaurav", "city": "Bokaro",  "department": "HR", "salary": 5000  }
	  ],
	  
       "IT": [
	      { "name": "Vinod",    "city": "Indore",    "department": "IT", "salary": 80000 },
	      { "name": "Nitin",    "city": "Bangalore", "department": "IT", "salary": 50000 },
	      { "name": "Abhishek", "city": "Patna",     "department": "IT", "salary": 20000 }
	  ]
       }


# Problem 2 : Group Employees by Department & Get all Employee Names   

    Map<String, List<String>> groupEmployeeByDepartment = new HashMap<>();

    groupEmployeeByDepartment = empList.stream()
                                .collect(Collectors.groupingBy(
                                         Employee::getDepartment,
                                         Collectors.mapping(Employee::getName, Collectors.toList())
                                ));
							    

    Output : 
    {
     "Finance" : [ "Naveen" ],
     "HR"      : [ "Saurav", "Gaurav" ],
     "IT"      : [ "Vinod", "Nitin", "Abhishek" ]
    }
    
    
    The groupingBy operation in this example takes two parameters
    - a classification function
    - an instance of Collector


# Problem 3 : Sort Employee by Value (Name)

    Map<String,List<Employee>> groupEmployeeByDepartment = new HashMap<>();
    groupEmployeeByDepartment =  empList.stream()
                                 .sorted(Comparator.comparing(Employee::getName))         
                                 .collect(Collectors.groupingBy(Employee::getDepartment));

    //Decreasing Order : //.sorted(Comparator.comparing(Employee::getName).reversed())
    
   Output :
   
       {
        "Finance": [
	      { "name": "Naveen", "city": "Bangalore", "department": "Finance", "salary": 100000 }
	  ], 
	  
       "HR": [
              {  "name": "Gaurav", "city": "Bokaro",  "department": "HR", "salary": 5000  }
	      {  "name": "Saurav", "city": "Dhanbad", "department": "HR", "salary": 10000 },
	  ],
	  
       "IT": [
              { "name": "Abhishek", "city": "Patna",     "department": "IT", "salary": 20000 }
	      { "name": "Nitin",    "city": "Bangalore", "department": "IT", "salary": 50000 },
	      { "name": "Vinod",    "city": "Indore",    "department": "IT", "salary": 80000 }, 
	  ]
       }
       

# Problem 4 : Using FlatMap 
  
    Map<String,List<Employee>> groupEmployeeByDepartment = new HashMap<>();

    List<Employee> flatMapList = groupEmployeeByDepartment.values().stream()
                                 .flatMap(pList -> pList.stream())
				 .collect(Collectors.toList());

    System.out.println(flatMapList);

    /**
     * [
     *  {name=Naveen, city=Bangalore, department=Finance, salary=100000},
     *  {name=Saurav, city=Dhanbad, department=HR, salary=10000}, 
     *  {name=Gaurav, city=Bokaro, department=HR, salary=5000}, 
     *  {name=Vinod, city=Indore, department=IT, salary=80000}, 
     *  {name=Nitin, city=Bangalore, department=IT, salary=50000}, 
     *  {name=Abhishek, city=Patna, department=IT, salary=20000}
     * ]
     */
         

#
    More on Collectors 
    - Collectors.groupingBy()
    - Collectors.mapping()

    - Collectors.partitioningBy()
    - Collectors.counting() 
    - Collectors.maxBy()/minBy()
    - Collectors.joining()
    - Collectors.collectingAndThen()
    - Collectors.averagingInt() /averagingLong() /averagingDouble()

    Refer : 
    https://www.javabrahman.com/java-8/java-8-grouping-with-collectors-groupingby-method-tutorial-with-examples/
