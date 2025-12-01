package model.data;

public class Ubuntu extends Linux {

    public Ubuntu( String version) {
        super("Ubuntu", version, "Gnome");

    }

    public Ubuntu( String version, String desktopEnvironmentName) {
        super("Ubuntu", version, desktopEnvironmentName);
    }

    @Override
    public void getBootInfo() {
        System.out.println("Booting " + name + " " + version);
    };
}
