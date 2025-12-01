package model.data;

public class Windows extends OperatingSystem {

    public Windows(String version) {
        super("Windows", version);
    }

    @Override
    public void getBootInfo() {
        System.out.println("Booting " + name + " " + version);
    }

}
