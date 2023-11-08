package models;

import utils.Currency;
import utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Employee {
    public static int increment = 0;
    private int code;
    private String name;
    private int age;
    private String phone;
    private String email;
    private double basicSalary;

    public abstract double getSalary();

    public Employee() {
        increment++;
        this.code = increment;
        this.name = "";
        this.age = 0;
        this.phone = "";
        this.email = "";
        this.basicSalary = 0.0;
    }

    public Employee(String name, int age, String phone, String email, double basicSalary) {
        increment++;
        this.code = increment;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Code: " + code +
                ", Name: " + name +
                ", Age: " + age +
                ", Phone: " + phone +
                ", Email: " + email +
                ", Basic Salary: " + Currency.vndFormat(basicSalary);
    }

    public void action() {
        System.out.println("I am an employee");
    }

    public void inputInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.name = Validator.getString(br, "Name: ");
        this.age = Validator.getInt(br, "Age: ");
        this.phone = Validator.getString(br, "Phone: ");
        this.email = Validator.getEmail(br, "Email: ");
        this.basicSalary = Validator.getDouble(br, "Basic Salary: ");
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
