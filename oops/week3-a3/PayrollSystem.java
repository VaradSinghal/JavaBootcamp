import java.util.*;

abstract class Employee {
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary;
    protected String joinDate;
    protected boolean[] attendanceRecord;

    protected static int totalEmployees = 0;
    protected static String companyName = "TechCorp";
    protected static double totalSalaryExpense = 0.0;
    protected static int workingDaysPerMonth = 30;

    public Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.attendanceRecord = new boolean[workingDaysPerMonth];
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= workingDaysPerMonth) {
            attendanceRecord[day - 1] = present;
        }
    }

    public abstract double calculateSalary();

    public double calculateBonus() {
        int presentDays = 0;
        for (boolean b : attendanceRecord) {
            if (b) presentDays++;
        }
        double attendanceRate = (double) presentDays / workingDaysPerMonth;
        if (attendanceRate >= 0.9) return baseSalary * 0.2;
        if (attendanceRate >= 0.75) return baseSalary * 0.1;
        return 0.0;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        double total = salary + bonus;
        totalSalaryExpense += total;
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Company: " + companyName);
        System.out.println("Employee: " + empName + " (" + empId + ")");
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Calculated Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Pay: " + total);
        System.out.println("----------------\n");
    }

    public void requestLeave(int days) {
        System.out.println(empName + " requested " + days + " days leave.");
    }

    public String getDepartment() { return department; }
    public String getEmpName() { return empName; }
    public double getBaseSalary() { return baseSalary; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }
    @Override
    public double calculateSalary() {
        int presentDays = 0;
        for (boolean b : attendanceRecord) if (b) presentDays++;
        return (baseSalary / workingDaysPerMonth) * presentDays;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }
    @Override
    public double calculateSalary() {
        int presentDays = 0;
        for (boolean b : attendanceRecord) if (b) presentDays++;
        return (baseSalary / 20) * presentDays;
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
    }
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class Department {
    private String deptId;
    private String deptName;
    private Employee manager;
    private List<Employee> employees;
    private double budget;

    public Department(String deptId, String deptName, Employee manager, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.budget = budget;
        this.employees = new ArrayList<>();
        this.employees.add(manager);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculateDepartmentExpenses() {
        double sum = 0;
        for (Employee e : employees) {
            sum += e.calculateSalary() + e.calculateBonus();
        }
        return sum;
    }

    public String getDeptName() { return deptName; }
}

public class PayrollSystem {
    public static void calculateCompanyPayroll(List<Employee> employees) {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary() + e.calculateBonus();
        }
        System.out.println("Total Company Payroll: " + total);
    }

    public static void getDepartmentWiseExpenses(List<Department> departments) {
        System.out.println("\n--- Department Wise Expenses ---");
        for (Department d : departments) {
            System.out.println(d.getDeptName() + ": " + d.calculateDepartmentExpenses());
        }
    }

    public static void getAttendanceReport(List<Employee> employees) {
        System.out.println("\n--- Attendance Report ---");
        for (Employee e : employees) {
            int presentDays = 0;
            for (boolean b : e.attendanceRecord) if (b) presentDays++;
            System.out.println(e.getEmpName() + " | Present: " + presentDays + " days");
        }
    }

    public static void main(String[] args) {
        FullTimeEmployee e1 = new FullTimeEmployee("E001", "Alice", "IT", "Developer", 60000, "2022-01-01");
        PartTimeEmployee e2 = new PartTimeEmployee("E002", "Bob", "HR", "Assistant", 20000, "2023-03-01");
        ContractEmployee e3 = new ContractEmployee("E003", "Charlie", "Finance", "Consultant", 40000, "2023-06-01");

        Department d1 = new Department("D01", "IT", e1, 500000);
        Department d2 = new Department("D02", "HR", e2, 200000);
        Department d3 = new Department("D03", "Finance", e3, 300000);

        d1.addEmployee(e2);
        d2.addEmployee(e3);

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        List<Department> departments = Arrays.asList(d1, d2, d3);

        for (int i = 1; i <= 22; i++) e1.markAttendance(i, true);
        for (int i = 1; i <= 15; i++) e2.markAttendance(i, true);
        for (int i = 1; i <= 30; i++) e3.markAttendance(i, true);

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        calculateCompanyPayroll(employees);
        getDepartmentWiseExpenses(departments);
        getAttendanceReport(employees);

        e1.requestLeave(3);
    }
}
