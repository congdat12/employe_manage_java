package manager;

import models.Employee;
import models.Programmer;
import models.Verifier;
import utils.Currency;
import utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public void inputEmployee() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Input a programmer");
        System.out.println("2. Input a verifier");
        int i;
        do {
            i = Validator.getInt(br, "Choice: ");
        } while ((i != 1) && (i != 2));

        Employee employee;
        if (i == 1)
            employee = new Programmer();
        else
            employee = new Verifier();

        employee.inputInformation();
        employees.add(employee);
    }

    public void showAllEmployeeList() {
        System.out.println("Show all Employee List:");
        for (Employee employee : employees)
            System.out.println(employee);
    }

    public void showAllProgrammerList() {
        System.out.println("Show all Employee List:");
        for (Employee employee : employees) {
            if (employee instanceof Programmer)
                System.out.println(employee);
        }
    }

    public void showAllVerifierList() {
        System.out.println("Show all Verifier List:");
        for (Employee employee : employees) {
            if (!(employee instanceof Verifier))
                continue;
            System.out.println(employee);
        }
    }

    public double averageSalary() {
        double sum = 0.0;
        for (Employee employee : employees)
            sum += employee.getSalary();
        return sum / employees.size();
    }

    public void listLowerAverageSalaryEmployee() {
        System.out.println("List Lower Average Salary Employee:");
        System.out.printf("(Average Salary = %s)\n", Currency.vndFormat(averageSalary()));
        for (Employee employee : employees) {
            if (employee.getSalary() < averageSalary())
                System.out.println(employee);
        }
    }

    public void sortEmployeeBySalaryAscending() {
        System.out.println("Sort Employee by Salary Ascending:");
        List<Employee> list1 = new ArrayList<>(employees);

//        Collections.sort(list1, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee emp1, Employee emp2) {
//                return emp1.getName().compareToIgnoreCase(emp2.getName());
//            }
//        });

        Collections.sort(list1, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (emp1.getSalary() > emp2.getSalary())
                    return 1;
                else if (emp1.getSalary() < emp2.getSalary())
                    return -1;
                else
                    return emp1.getName().compareToIgnoreCase(emp2.getName());
            }
        });

        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i));
    }
}
