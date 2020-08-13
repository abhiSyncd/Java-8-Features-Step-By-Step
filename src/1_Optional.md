## 1 - What is an Optional  

    Java 8 has introduced a new class Optional<T> in the java.util package.
    The Optional<T> is a wrapper class that stores an object of type T. The object may or may not be present in the optional.


## 2 - Ways to Create Optional

     a)Using empty() method. 
          - Optional <Person> person = Optional.empty();


     b)Using of() method 
         - Person person = new Person();
           Optional<Person> optional = Optional.of(person);


     c)Using ofNullable() method | PREFERRED over Others 
        - Person person = new Person();
          Optional<Person> optional = Optional.ofNullable(person);

        - Here
          Case I  : If person is Not-Null : optional will return the Optional, containing the specified value.
          Case II : If person is null     : optional will return an empty Optional (i.e Optional.empty) , Thus NullPointerException is never thrown 
          



## 3 - Methods added in Optional class


     1)isPresent()
		- check if the optional contains a value or if it is null.
		   If optional contains a value : Return TRUE
		   

		- Example)
		  Optional<Person> optional = getPerson();
		  if(optional.isPresent()){
		     System.out.println(optional.get.getName())
		   }
     	 
         
     2)IfPresent(Consumer<? super T> consumer) 
     
     
     3)get()
	       -  returns a value if it is present in this Optional. Otherwise, it throws NoSuchElementException.
		  It is risky to use this method without checking if the value is present or not using isPresent() method

	       - Example 
		 Optional<String> optional = Optional.ofNullable(null);
		 System.out.println(optional.get()); // This will throw exception because optional contains a null value.

     
     4)orElse(T other)

	       - returns the value present in the optional. If no value is present, then a default value provided as a parameter is returned.

	       - Example 
		  Optional<String> optional = Optional.ofNullable(null);
		  System.out.println(optional.orElse("default sting"));  // default string : This will return the default value.

	  
	  
      5)orElseGet(Supplier<? extends T> other)
       
		- Returns the value present in the optional. If no value is present, then the value calculated from the supplier provided as a parameter is returned.

		- Example
		  public class MyMain {
			public static String getDefaultValue() {
				return "default";
			}

			public static void main(String[] args) throws Exception {
				Optional<String> optional = Optional.ofNullable(null);
				System.out.println(optional.orElseGet(MyMain::getDefaultValue)); // default : This will return the default value.
			}

		}
	
	
     6)orElseThrow(Supplier<? extends T> other) 
     
	       - returns the value present in the optional. If no value is present, then it throws the exception created by the provided supplier.

	       - Example)
		  Optional<String> optional = Optional.ofNullable(null);
		  System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));

     
     7)filter(Predicate<? super T> predicate)
     
	       - method is used to check if the value in our optional matches a particular condition. 
		 If yes, then the optional with the value is returned. Otherwise, an empty optional is returned.

	       - Example)
		 Optional<String> optional = Optional.ofNullable("orange");
		 System.out.println(optional.filter(str -> str.equals("orange")));  // Optional[orange] :: Since filter condition is matched, this will return the optional.
		 System.out.println(optional.filter(str -> str.equals("apple")));   // Optional.empty   :: Since filter condition is not matched, this will return empty optional.
	  
    
    
     8)map(Function<? super T, ? extends U> mapper)
     
	       - if a value is present, apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result.
		 Otherwise, return an empty Optional

	       - Example)
		 Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));  // Creating an Optional of Employee object.
			 optional
			 .map(emp -> emp.getSalary()) // Fetching the salary from employee object.
			 .filter(sal -> sal > 10000) // Checking if the salary is greater than 10000.
			 .ifPresent(System.out::println); // 20000



       
       
     9)flatMap(Function<? super T, Optional<U&>> mapper) 
     
     
     
     
## 4 - Use Case : Example 

     i)Wrapping an object in an Optional avoids NullPointerException during Run Time and
       There is no need to explicity check Null-Pointer-Exception for an object
           Refer: https://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/






