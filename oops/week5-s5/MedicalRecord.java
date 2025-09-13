import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// a. Immutable MedicalRecord class
public final class MedicalRecord implements Serializable {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies,
                         String[] medicalHistory, LocalDate birthDate, String bloodType) {
        if (recordId == null || recordId.isEmpty() || patientDNA == null || bloodType == null || birthDate == null) {
            throw new IllegalArgumentException("Invalid medical record data");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies != null ? Arrays.copyOf(allergies, allergies.length) : new String[0];
        this.medicalHistory = medicalHistory != null ? Arrays.copyOf(medicalHistory, medicalHistory.length) : new String[0];
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPatientDNA() {
        return patientDNA;
    }

    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }

    public String[] getMedicalHistory() {
        return Arrays.copyOf(medicalHistory, medicalHistory.length);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public final boolean isAllergicTo(String substance) {
        for (String a : allergies) {
            if (a.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", birthDate=" + birthDate +
                ", bloodType='" + bloodType + '\'' +
                ", allergies=" + Arrays.toString(allergies) +
                ", medicalHistory=" + Arrays.toString(medicalHistory) +
                '}';
    }
}

// b. Patient class with privacy levels
class Patient implements Serializable {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    // Emergency admission constructor
    public Patient(String patientId, String currentName) {
        this(patientId, currentName, null, null, 0, null, null);
    }

    // Standard admission constructor
    public Patient(String patientId, String currentName, String emergencyContact,
                   String insuranceInfo, int roomNumber, String attendingPhysician,
                   MedicalRecord medicalRecord) {
        if (patientId == null || patientId.isEmpty() || currentName == null || currentName.isEmpty()) {
            throw new IllegalArgumentException("Invalid patient data");
        }
        this.patientId = patientId;
        this.currentName = currentName;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = attendingPhysician;
        this.medicalRecord = medicalRecord;
    }

    // Transfer admission constructor
    public Patient(String patientId, String currentName, MedicalRecord medicalRecord) {
        this(patientId, currentName, null, null, 0, null, medicalRecord);
    }

    public String getPatientId() {
        return patientId;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        if (currentName == null || currentName.isEmpty()) throw new IllegalArgumentException("Invalid name");
        this.currentName = currentName;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        if (roomNumber < 0) throw new IllegalArgumentException("Invalid room number");
        this.roomNumber = roomNumber;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }

    String getBasicInfo() {
        return "Patient: " + currentName + ", Room: " + roomNumber;
    }

    public String getPublicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", currentName='" + currentName + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", insuranceInfo='" + insuranceInfo + '\'' +
                ", roomNumber=" + roomNumber +
                ", attendingPhysician='" + attendingPhysician + '\'' +
                ", medicalRecord=" + (medicalRecord != null ? medicalRecord.getRecordId() : "None") +
                '}';
    }
}

// d. Separate medical staff classes
class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certifications);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Set<String> getCertifications() {
        return new HashSet<>(certifications);
    }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = new ArrayList<>(qualifications);
    }

    public String getNurseId() {
        return nurseId;
    }

    public String getShift() {
        return shift;
    }

    public List<String> getQualifications() {
        return new ArrayList<>(qualifications);
    }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = new ArrayList<>(accessPermissions);
    }

    public String getAdminId() {
        return adminId;
    }

    public List<String> getAccessPermissions() {
        return new ArrayList<>(accessPermissions);
    }
}

// e. HospitalSystem class with access control
class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();
    public static final String POLICY_PRIVACY = "HIPAA_COMPLIANCE";

    public boolean admitPatient(Object patient, Object staff) {
        if (!(patient instanceof Patient)) return false;
        if (!validateStaffAccess(staff, patient)) return false;
        Patient p = (Patient) patient;
        patientRegistry.put(p.getPatientId(), p);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        if (staff instanceof Doctor) return true;
        if (staff instanceof Nurse) return patient != null;
        if (staff instanceof Administrator) return true;
        return false;
    }

    Patient getPatient(String patientId) {
        return (Patient) patientRegistry.get(patientId);
    }
}

