
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}

    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be positive");
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getFullName() {
        return (firstName != null ? firstName : "") + " " +
               (lastName != null ? lastName : "");
    }

    public long getYearsOfService() {
        if (hireDate == null) return 0;
        LocalDate hireLocal = hireDate.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(hireLocal, LocalDate.now());
    }

    public String getFormattedSalary() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(salary);
    }

    public void setFullName(String fullName) {
        if (fullName != null && fullName.trim().contains(" ")) {
            String[] parts = fullName.trim().split(" ", 2);
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            throw new IllegalArgumentException("Full name must include first and last name");
        }
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E001");
        emp1.setFirstName("Alice");
        emp1.setLastName("Johnson");
        emp1.setSalary(75000);
        emp1.setDepartment("HR");
        emp1.setHireDate(new Date(120, 0, 1));
        emp1.setActive(true);

        EmployeeBean emp2 = new EmployeeBean("E002", "Bob", "Smith",
                85000, "IT", new Date(118, 5, 15), true);

        System.out.println(emp1.getFullName() + " - Salary: " + emp1.getFormattedSalary());
        System.out.println(emp2.getFullName() + " - Years of Service: " + emp2.getYearsOfService());

        try {
            emp1.setSalary(-5000);
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        EmployeeBean[] employees = {emp1, emp2};
        Arrays.sort(employees, (a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        System.out.println("Sorted by salary: " + Arrays.toString(employees));

        System.out.println("Active employees:");
        Arrays.stream(employees)
                .filter(EmployeeBean::isActive)
                .forEach(System.out::println);

        System.out.println("\n=== Reflection Utility Demo ===");
        JavaBeanProcessor.printAllProperties(emp1);
        EmployeeBean emp3 = new EmployeeBean();
        JavaBeanProcessor.copyProperties(emp1, emp3);
        System.out.println("Copied employee: " + emp3);
    }
}

class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        try {
            Method[] methods = emp.getClass().getMethods();
            for (Method m : methods) {
                if ((m.getName().startsWith("get") || m.getName().startsWith("is"))
                        && m.getParameterCount() == 0) {
                    Object value = m.invoke(emp);
                    String propertyName = m.getName()
                            .replaceFirst("get", "")
                            .replaceFirst("is", "");
                    System.out.println(propertyName + " = " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        try {
            Method[] methods = source.getClass().getMethods();
            for (Method m : methods) {
                if ((m.getName().startsWith("get") || m.getName().startsWith("is"))
                        && m.getParameterCount() == 0) {
                    Object value = m.invoke(source);
                    String propertyName = m.getName()
                            .replaceFirst("get", "")
                            .replaceFirst("is", "");
                    try {
                        Method setter = target.getClass().getMethod("set" + propertyName, m.getReturnType());
                        setter.invoke(target, value);
                    } catch (NoSuchMethodException ignored) {}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
