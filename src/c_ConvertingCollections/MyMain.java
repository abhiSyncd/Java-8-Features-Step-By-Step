package c_ConvertingCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyMain {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Nitin", 80000));
		list.add(new Employee(2, "Abhi", 50000));
		
		
		/**
		 * Converting List To List : Selecting Few Attributes
		 *  EmployeeDTO : Class contains only Name and salary attribute
		 */
		
		List<EmployeeDTO> list1 = list.stream()
                                          .map(emp -> new Employee(emp.getName(), emp.getSalary()))
                                          .collect(Collectors.toList());
		
		System.out.println(list1);
		
		
		/**
		 * Converting List to Map in Java 8 
		 */
		
		 Map<Integer, Employee> map1 = list.stream()
                                              .collect(Collectors.toMap(Employee::getId, employee->employee));
		
		System.out.println("ListToMap -> " + map1);
		
		
		/**
		 * Converting Map to List in Java 8
		 */
		Map<Integer , Employee> map2 = new HashMap<>();
		map2.put(1, new Employee(1, "Nitin", 80000));
		map2.put(2, new Employee(2, "Abhi", 50000));
		
		
		List<Employee> list2 = map2.entrySet().stream()
				       .map(e -> e.getValue())
				       .collect(Collectors.toList());
		
		System.out.println("MapToList -> " + list2);

	}

}
