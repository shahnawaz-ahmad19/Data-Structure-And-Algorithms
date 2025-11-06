package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {
  public static void main(String[] args) {
    List<Employee> employees = Arrays.asList(
        new Employee(101, "Ram", "IT", 55000, 28, "Male", 2020),
        new Employee(102, "Sita", "HR", 48000, 32, "Female", 2018),
        new Employee(103, "Raju", "Finance", 60000, 35, "Male", 2015),
        new Employee(104, "Priya", "IT", 75000, 30, "Female", 2019),
        new Employee(105, "Kiran", "Sales", 45000, 27, "Male", 2021),
        new Employee(106, "Asha", "Finance", 68000, 29, "Female", 2017),
        new Employee(107, "Rohan", "IT", 80000, 33, "Male", 2016));

    List<Employee> employeesgreaterthan28 = employees.stream()
        .filter(employee -> employee.getAge() > 28)
        .collect(Collectors.toList());
    System.out.println(employeesgreaterthan28);

    Map<String, Double> avgSalaryByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.averagingDouble(Employee::getSalary)));
    System.out.println(avgSalaryByDepartment);

    // gender 

    Map<String, Long> genderCount = employees.stream()
        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    System.out.println(genderCount);

    // List of employee who joined after 2019

    List<Employee> recentJoinee = employees.stream()
        .filter(employee -> employee.getYearOfJoining() > 2019).collect(Collectors.toList());
    System.out.println(recentJoinee);

    // highest paid employee in each department

    Map<String, Optional<Employee>> highestPaid = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    System.out.println(highestPaid);

    // total salry paid by department

    Map<String, Double> salary = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment,
            Collectors.summingDouble(Employee::getSalary)));
    System.out.println(salary);

    // name of all employee in IT department

    List<String> names = employees.stream()
        .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
        .map(employee -> employee.getName())
        .collect(Collectors.toList());
    System.out.println(names);

    // Youngest male employee in finane

    Optional<Employee> youngestEmployee = employees.stream()
        .filter(employee -> employee.getGender().equalsIgnoreCase("Male")
            && employee.getDepartment().equalsIgnoreCase("Finance"))
        .min(Comparator.comparing(Employee::getAge));
    System.out.println(youngestEmployee);

    // dept wise employee name

    Map<String, List<String>> namesDeptWise = employees.stream()
        .collect(
            Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
    System.out.println(namesDeptWise);

    // Employee Salary statistics

    DoubleSummaryStatistics stats = employees.stream()
        .collect(Collectors.summarizingDouble(Employee::getSalary));
    System.out.println(stats);

  }

}
