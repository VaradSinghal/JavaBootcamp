class MedicalStaff {
    protected String name;
    protected String staffId;

    public MedicalStaff(String name, String staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    public void shiftSchedule() {
        System.out.println(name + " (ID: " + staffId + ") shift scheduled.");
    }

    public void accessIDCard() {
        System.out.println(name + " accessed ID card.");
    }

    public void processPayroll() {
        System.out.println(name + "'s payroll processed.");
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, String staffId) {
        super(name, staffId);
    }

    public void diagnose() {
        System.out.println(name + " is diagnosing a patient.");
    }

    public void prescribeMedicine() {
        System.out.println(name + " prescribed medicine.");
    }

    public void performSurgery() {
        System.out.println(name + " is performing surgery.");
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, String staffId) {
        super(name, staffId);
    }

    public void administerMedicine() {
        System.out.println(name + " administered medicine.");
    }

    public void monitorPatients() {
        System.out.println(name + " is monitoring patients.");
    }

    public void assistProcedure() {
        System.out.println(name + " is assisting in procedure.");
    }
}

class Technician extends MedicalStaff {
    public Technician(String name, String staffId) {
        super(name, staffId);
    }

    public void operateEquipment() {
        System.out.println(name + " is operating equipment.");
    }

    public void runTests() {
        System.out.println(name + " is running tests.");
    }

    public void maintainInstruments() {
        System.out.println(name + " is maintaining instruments.");
    }
}

class Administrator extends MedicalStaff {
    public Administrator(String name, String staffId) {
        super(name, staffId);
    }

    public void scheduleAppointments() {
        System.out.println(name + " scheduled appointments.");
    }

    public void manageRecords() {
        System.out.println(name + " is managing records.");
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalStaff[] staff = new MedicalStaff[4];
        staff[0] = new Doctor("Dr. Alice", "D101");
        staff[1] = new Nurse("Nurse Bob", "N202");
        staff[2] = new Technician("Tech Carol", "T303");
        staff[3] = new Administrator("Admin Dave", "A404");

        for (MedicalStaff m : staff) {
            m.shiftSchedule();
            m.accessIDCard();
            m.processPayroll();
            System.out.println();
        }
    }
}
