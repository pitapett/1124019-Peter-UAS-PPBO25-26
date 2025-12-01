package model.data;

public abstract class Linux extends OperatingSystem {
    public String desktopEnvironmentName;

    public Linux(String name, String version, String desktopEnvironmentName) {
        super(name, version);
        this.desktopEnvironmentName = desktopEnvironmentName;
    }

    
}
