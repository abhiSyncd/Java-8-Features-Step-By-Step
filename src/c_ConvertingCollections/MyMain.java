package c_ConvertingCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyMain {

	public static void main(String[] args) {

		/**
		 * Converting List to Map in Java 8 
		 */
		List<Employee> list1 = new ArrayList<>();
		list1.add(new Employee(1, "Nitin", 80000));
		list1.add(new Employee(2, "Abhi", 50000));
		
		 Map<Integer, Employee> map1 = list1.stream()
				                      .collect(Collectors.toMap(Employee::getId, employee->employee));
		
		System.out.println("ListToMap -> " + map1);
		
		/**
		 * Converting Map to List in Java 8
		 */
		Map<Integer , Employee> map2 = new HashMap<>();
		map2.put(1, new Employee(1, "Nitin", 80000));
		map2.put(2, new Employee(2, "Abhi", 50000));
		
		
		List<Employee> list2 = 	map2.entrySet().stream()
						       .map(e -> e.getValue())
						       .collect(Collectors.toList());
		
		System.out.println("MapToList -> " + list2);
		
		 
		 
		

	}

}
