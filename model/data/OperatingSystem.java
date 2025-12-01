package model.data;

public abstract class OperatingSystem {
    public String name;
    public String version;
    public OperatingSystem(String name, String version){
        this.name = name;
        this.version = version;
    }

    public abstract void getBootInfo();

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
