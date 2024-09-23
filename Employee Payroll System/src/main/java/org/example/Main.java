package org.example;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary= monthlySalary;
    }

    @Override

    public double calculateSalary(){
         return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
    class PayrollSystem{
        private ArrayList<Employee> employeeList;

        public PayrollSystem(){
            employeeList = new ArrayList<>();
        }

        public void addEmployee(Employee employee){
            employeeList.add(employee);
        }

        public void removeEmployee(int id){
            Employee employeeToRemove = null;
            for(Employee employee:employeeList){
                if(employee.getId()==id) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if(employeeToRemove != null){
                employeeList.remove(employeeToRemove);
            }
        }

        public void displayEmployees(){
            for(Employee employee: employeeList){
                System.out.println(employee);
            }
        }


    }


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rahul",1,70000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Saransh",2,85000);
        FullTimeEmployee emp3 = new FullTimeEmployee("Rishabh",3,95000);
        FullTimeEmployee emp4 = new FullTimeEmployee("Harsh",4,65000);
        FullTimeEmployee emp5 = new FullTimeEmployee("Vikrant",5,35000);
        PartTimeEmployee emp6 = new PartTimeEmployee("Raj",6,40,1000);
        PartTimeEmployee emp7 = new PartTimeEmployee("Rajesh",7,30,1000);
        PartTimeEmployee emp8 = new PartTimeEmployee("Rakesh",8,60,1000);
        PartTimeEmployee emp9 = new PartTimeEmployee("Arpit",9,70,1000);
        PartTimeEmployee emp10 = new PartTimeEmployee("Dipankar",10,80,1000);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees:");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details");
        payrollSystem.displayEmployees();
    }
}