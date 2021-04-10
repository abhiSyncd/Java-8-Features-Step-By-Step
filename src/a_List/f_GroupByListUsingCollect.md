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

# Problem 1 : Group all Employees by Department       

    Map<String,List<Employee>> groupEmployeeByDepartment = new HashMap<>();
        
    groupEmployeeByDepartment =  empList.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment));
				     
    groupEmployeeByDepartment.forEach((key,value) -> System.out.println(key + ":" + value));
	
#
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

#
        List<Employee> flatMapList = personByDepartmentMap.values().stream()
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
         
   }

}



 /*
 
 Refer at end of this File * 
   Map<String,List<String>> GroupOnlyNamesByDepartment =  empList.stream()
							  .collect(Collectors.groupingBy(
								     Employee::getDepartment , 
								     Collectors.mapping(
								        Employee::getName,
								        Collectors.toList())));
															   
															   
  Output : 
  {
  "Finance" : [ "Naveen" ],
  "HR"      : [ "Saurav", "Gaurav" ],
  "IT"      : [ "Vinod", "Nitin", "Abhishek" ]
  }
  
  The groupingBy operation in this example takes two parameters
   i)a classification function
   ii)an instance of Collector
   
   For more info : https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 
*/
