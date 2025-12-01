package model.data;

public class Fedora extends Linux {

    public Fedora(String version) {
        super("Fedora", version, "KDE Plasma");
    }

    public Fedora(String version, String desktopEnvironmentName) {
        super("Fedora", version, desktopEnvironmentName);
    }

    @Override
    public void getBootInfo() {
        System.out.println("Booting " + name + " " + version);
    };
}
