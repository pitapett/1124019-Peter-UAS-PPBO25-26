import controller.DeviceController;
import view.DeviceView;

public class App {
    public static void main(String[] args) {
        DeviceController deviceController = new DeviceController();
        DeviceView deviceView = new DeviceView(deviceController);
        deviceView.render();
    }
}
