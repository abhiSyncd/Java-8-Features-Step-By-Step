
## 1 - Map,Filter,Sorted,Limit,Collect

    List<Employee> empList2 = empList.stream()
                             .filter(employee -> "Bangalore".equals(employee.getCity()))
			     .limit(4)
			     .map(e -> new Employee(e.getName().toLowerCase(), e.getCity()))
                             .sorted(Comparator.comparing(Employee::getName))
                             .collect(Collectors.toList());
		
		
## 2 - Print Employee with Maximum or Minimum Salary : max() , min() 

    Employee employeeWithMaxSalary = empList.stream()
                             .max(Comparator.comparing(Employee::getSalary))
                             .orElseThrow(NoSuchElementException::new);
			
## 3 - Employees with Lowest Salary

    List<Employee> empList3 = empList.stream()
                             .sorted(Comparator.comparing(Employee::getSalary))
			     .limit(3)
			     .collect(Collectors.toList());
			
	
## 4 - Get 3 Employees with Top salaries

      List<Employee> empList4 = empList.stream() 
                             .sorted(Comparator.comparing(Employee::getSalary).reversed())
                              .limit(3)
			      .collect(Collectors.toList());
