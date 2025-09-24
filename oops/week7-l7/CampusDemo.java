class SmartDevice {
    protected String deviceId;

    public SmartDevice(String deviceId) {
        this.deviceId = deviceId;
    }

    public void status() {
        System.out.println("Smart Device [" + deviceId + "] is active.");
    }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String deviceId) {
        super(deviceId);
    }

    public void controlLighting() {
        System.out.println("Classroom [" + deviceId + "] lights adjusted.");
    }

    public void controlAC() {
        System.out.println("Classroom [" + deviceId + "] AC controlled.");
    }

    public void controlProjector() {
        System.out.println("Classroom [" + deviceId + "] projector turned on.");
    }
}

class SmartLab extends SmartDevice {
    public SmartLab(String deviceId) {
        super(deviceId);
    }

    public void manageEquipment() {
        System.out.println("Lab [" + deviceId + "] equipment managed.");
    }

    public void checkSafetySystems() {
        System.out.println("Lab [" + deviceId + "] safety systems checked.");
    }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String deviceId) {
        super(deviceId);
    }

    public void trackOccupancy() {
        System.out.println("Library [" + deviceId + "] occupancy tracked.");
    }

    public void checkBookAvailability() {
        System.out.println("Library [" + deviceId + "] book availability updated.");
    }
}

public class CampusDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[3];
        devices[0] = new SmartClassroom("CR101");
        devices[1] = new SmartLab("LAB202");
        devices[2] = new SmartLibrary("LIB303");

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartClassroom) {
                SmartClassroom c = (SmartClassroom) d;
                c.controlLighting();
                c.controlAC();
                c.controlProjector();
            } else if (d instanceof SmartLab) {
                SmartLab l = (SmartLab) d;
                l.manageEquipment();
                l.checkSafetySystems();
            } else if (d instanceof SmartLibrary) {
                SmartLibrary lib = (SmartLibrary) d;
                lib.trackOccupancy();
                lib.checkBookAvailability();
            }

            System.out.println();
        }
    }
}
