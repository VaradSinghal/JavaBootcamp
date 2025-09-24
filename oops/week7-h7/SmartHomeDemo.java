class SmartDevice {
    protected String deviceId;

    public SmartDevice(String deviceId) {
        this.deviceId = deviceId;
    }

    public void status() {
        System.out.println("Smart Device [" + deviceId + "] is online.");
    }
}

class SmartTV extends SmartDevice {
    public SmartTV(String deviceId) {
        super(deviceId);
    }

    public void changeChannel(int channel) {
        System.out.println("TV [" + deviceId + "] changed to channel " + channel);
    }

    public void adjustVolume(int volume) {
        System.out.println("TV [" + deviceId + "] volume set to " + volume);
    }

    public void openStreamingApp(String app) {
        System.out.println("TV [" + deviceId + "] opened " + app);
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String deviceId) {
        super(deviceId);
    }

    public void setTemperature(double temp) {
        System.out.println("Thermostat [" + deviceId + "] temperature set to " + temp + "°C");
    }

    public void setHumidity(double humidity) {
        System.out.println("Thermostat [" + deviceId + "] humidity set to " + humidity + "%");
    }

    public void enableEnergySaving(boolean enable) {
        System.out.println("Thermostat [" + deviceId + "] energy saving mode: " + (enable ? "ON" : "OFF"));
    }
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String deviceId) {
        super(deviceId);
    }

    public void monitorCameras() {
        System.out.println("Security [" + deviceId + "] cameras are monitoring.");
    }

    public void activateAlarm() {
        System.out.println("Security [" + deviceId + "] alarm activated!");
    }

    public void controlAccess(String user, boolean grant) {
        System.out.println("Security [" + deviceId + "] access for " + user + ": " + (grant ? "GRANTED" : "DENIED"));
    }
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String deviceId) {
        super(deviceId);
    }

    public void setCookingTime(int minutes) {
        System.out.println("Kitchen [" + deviceId + "] cooking time set to " + minutes + " mins");
    }

    public void setTemperature(double temp) {
        System.out.println("Kitchen [" + deviceId + "] temperature set to " + temp + "°C");
    }

    public void chooseRecipe(String recipe) {
        System.out.println("Kitchen [" + deviceId + "] selected recipe: " + recipe);
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice[] devices = new SmartDevice[4];
        devices[0] = new SmartTV("TV01");
        devices[1] = new SmartThermostat("TH02");
        devices[2] = new SmartSecurity("SEC03");
        devices[3] = new SmartKitchen("KIT04");

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartTV tv) {
                tv.changeChannel(5);
                tv.adjustVolume(20);
                tv.openStreamingApp("Netflix");
            } else if (d instanceof SmartThermostat th) {
                th.setTemperature(22.5);
                th.setHumidity(50);
                th.enableEnergySaving(true);
            } else if (d instanceof SmartSecurity sec) {
                sec.monitorCameras();
                sec.activateAlarm();
                sec.controlAccess("John", true);
            } else if (d instanceof SmartKitchen kit) {
                kit.setCookingTime(45);
                kit.setTemperature(180);
                kit.chooseRecipe("Pasta");
            }

            System.out.println();
        }
    }
}
