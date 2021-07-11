# Employee.java

    public class Employee { 
      private int id
      private String name;
      private int salary;
      
      // Getters | Setters
    }



# Creating Mock Data

    public class MyMain {
        public static void main(String[] args) {

            Map<Integer, Employee> map1 = new HashMap<>();
            map1.put(1, new Employee(1, "Nitin", 80000));
            map1.put(2, new Employee(2, "Abhi", 50000));
	    
            Map<Integer,Employee> map2 = new HashMap<>();
            map1.put(3, new Employee(3, "Saurav", 20000));
            map1.put(4, new Employee(4, "Gaurav", 10000));

            List<Map<Integer,Employee>> list = new ArrayList<>();
            list.add(map1);
            list.add(map2);

        }
    }
    
  Output : 
  
     [
        {
         "1": { "name": "Naveen", "city": "Bangalore", "department": "Finance", "salary": 100000 },
         "2": { "name": "Vinod",  "city": "Indore",    "department": "IT",      "salary": 80000 },
         "3": { "name": "Nitin",  "city": "Bangalore", "department": "IT",      "salary": 50000 }
        },
	
        {
         "4": { "name": "Abhishek", "city": "Patna",   "department": "IT", "salary": 20000 },
         "5": { "name": "Saurav",   "city": "Dhanbad", "department": "HR", "salary": 10000 },
         "6": { "name": "Gaurav",   "city": "Bokaro",  "department": "HR", "salary": 5000  }
        }
      ]


# Problem 1 : Flattening List<Map>

    Map<Integer, Employee> flattenedList = list.stream()
                                           .flatMap(object -> object.entrySet().stream())
                                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

## Output 1 : flattenedList
  
    {
      "1": { "name": "Naveen", "city": "Bangalore", "department": "Finance", "salary": 100000},
      "2": { "name": "Vinod",  "city": "Indore",    "department": "IT",      "salary": 80000 },
      "3": { "name": "Nitin",  "city": "Bangalore", "department": "IT",      "salary": 50000 },
      "4": { "name": "Abhishek", "city": "Patna",   "department": "IT",      "salary": 20000 },
      "5": { "name": "Saurav",   "city": "Dhanbad", "department": "HR",      "salary": 10000 },
      "6": { "name": "Gaurav",   "city": "Bokaro",  "department": "HR",      "salary": 5000  }
    }
    
## Output 2 : flattenedList.values()
 
    [
      "1": { "name": "Naveen", "city": "Bangalore", "department": "Finance", "salary": 100000},
      "2": { "name": "Vinod",  "city": "Indore",    "department": "IT",      "salary": 80000 },
      "3": { "name": "Nitin",  "city": "Bangalore", "department": "IT",      "salary": 50000 },
      "4": { "name": "Abhishek", "city": "Patna",   "department": "IT",      "salary": 20000 },
      "5": { "name": "Saurav",   "city": "Dhanbad", "department": "HR",      "salary": 10000 },
      "6": { "name": "Gaurav",   "city": "Bokaro",  "department": "HR",      "salary": 5000  }
    ]
    
