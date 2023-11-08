package models;

import utils.Currency;
import utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Verifier extends Employee {
    private int errorNumber;

    public Verifier() {
        super();
        this.errorNumber = 0;
    }

    public Verifier(String name, int age, String phone, String email, double basicSalary, int errorNumber) {
        super(name, age, phone, email, basicSalary);
        this.errorNumber = errorNumber;
    }

    @Override
    public double getSalary() {
        return this.getBasicSalary() + this.errorNumber * 150000;
    }

    public void verifierMethod() {
        System.out.println("Hello Verifier");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Error Number: " + errorNumber +
                ", Salary: " + Currency.vndFormat(getSalary()) +
                " (Verifier)";
    }

    @Override
    public void inputInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter verifier information:");
        super.inputInformation();
        this.errorNumber = Validator.getInt(br, "Error Number: ");
    }

    @Override
    public void action() {
        System.out.println("Test Code");
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }
}
