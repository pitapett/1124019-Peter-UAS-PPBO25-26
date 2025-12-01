package model.data;

public class Device {
    private OperatingSystem operatingSystem;
    private String userName;

    public Device(String userName, OperatingSystem operatingSystem) {
        this.userName = userName;
        this.operatingSystem = operatingSystem;
    }

    public void printDeviceInfo(){
        System.out.print(userName + " booting: " );
        operatingSystem.getBootInfo();
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
    public String getUserName() {
        return userName;
    }
}
