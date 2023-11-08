import manager.EmployeeManager;
import models.Employee;
import models.Programmer;
import models.Verifier;
import utils.MenuUtil;
import utils.Validator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> employees = new ArrayList<>();

        employees.add(new Programmer("A", 21, "123", "a@a.b", 1000000, 10));
        employees.add(new Programmer("B", 22, "123", "a@a.b", 1300000, 10));
        employees.add(new Programmer("C", 23, "123", "a@a.b", 1600000, 10));
        employees.add(new Verifier("D", 24, "123", "a@a.b", 1000000, 25));
        employees.add(new Verifier("E", 25, "123", "a@a.b", 1300000, 36));
        employees.add(new Verifier("F", 26, "123", "a@a.b", 1600000, 40));

        EmployeeManager employeeManager = new EmployeeManager(employees);

//        for (Employee employee : employees) {
//            if (employee instanceof Programmer) {
//                Programmer pr = (Programmer)employee;
//                pr.programmerMethod();
//            } else {
//                Verifier vr = (Verifier)employee;
//                vr.verifierMethod();
//            }
//        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(sdf.format(date));

        int i;
        do {
            MenuUtil.printMenu();
            do {
                i = Validator.getInt(br, "Choice: ");
                if ((i < 1) || (i > 7))
                    System.out.println("Enter a number from 1 to 7");
            } while ((i < 1) || (i > 7));

            switch (i) {
                case 1 -> employeeManager.inputEmployee();
                case 2 -> employeeManager.showAllEmployeeList();
                case 3 -> employeeManager.showAllProgrammerList();
                case 4 -> employeeManager.showAllVerifierList();
                case 5 -> employeeManager.listLowerAverageSalaryEmployee();
                case 6 -> employeeManager.sortEmployeeBySalaryAscending();
                default -> System.out.print("Program is finished");
            }
            System.out.println();
        } while (i != 7);
    }
}
