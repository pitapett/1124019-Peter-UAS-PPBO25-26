package view;

import java.util.ArrayList;
import model.data.Device;
import model.data.Fedora;
import model.data.Ubuntu;
import model.data.Windows;
import model.data.exceptions.EmptyListException;
import model.data.exceptions.InvalidMenuSelectionException;
import model.data.interfaces.IDeviceController;
import utils.CLIUtil;

public class DeviceView {
    IDeviceController deviceController;

    public DeviceView(IDeviceController deviceController) {
        this.deviceController = deviceController;
    }

    public void render() {
        mainMenuHandling();
    }

    public void mainMenu() {
        System.out.println("------------------");
        System.out.println("Menu: ");
        System.out.println("1. Tambah Device");
        System.out.println("2. Tampilkan semua Device");
        System.out.println("3. Tampilkan semua Device terurut berdasarkan OS");
        System.out.println("0. Keluar");
    }

    public void mainMenuHandling() {
        int menu = -1;
        while (menu != 0) {
            mainMenu();
            menu = CLIUtil.getInt();
            try {
                switch (menu) {
                    case 1:
                        deviceController.addDevice(addDeviceHandling());
                        break;

                    case 2:
                        try {
                            printDeviceList(deviceController.getAllDevice());
                        } catch (EmptyListException e) {
                            System.out.println("list is empty");
                        }

                        break;

                    case 3:
                        try {
                            printDeviceList(deviceController.getSortedDeviceList());
                        } catch (EmptyListException e) {
                            System.out.println("list is empty");
                        }
                        break;
                    case 0:

                        break;

                    default:
                        throw new InvalidMenuSelectionException();
                }
            } catch (InvalidMenuSelectionException imse) {
                System.out.println("invalid choice of menu, please try again");
            }

        }
    }

    public Device addDeviceHandling() {
        System.out.println("Masukkan nama pengguna: ");
        String name = CLIUtil.getString();

        System.out.println("Pilih OS: 1. Window, 2. Ubuntu, 3. Fedora");
        int choiceOS = 0;
        boolean validOSChoice = false;
        while (!validOSChoice) {
            try {
                choiceOS = CLIUtil.getInt();
                if (choiceOS < 1 || choiceOS > 3) {
                    throw new InvalidMenuSelectionException();
                }
                validOSChoice = true;
            } catch (InvalidMenuSelectionException imse) {
                System.out.println("please choose a valid OS");
            }
        }

        System.out.println("Masukkan versi: ");
        String version = CLIUtil.getString();

        switch (choiceOS) {
            case 1:
                Windows windowsOS = new Windows(version);
                return new Device(name, windowsOS);

            case 2:
                Ubuntu ubuntuOS = new Ubuntu(version);
                return new Device(name, ubuntuOS);

            case 3:
                Fedora fedoraOS = new Fedora(version);
                return new Device(name, fedoraOS);
            default:
                return null;
        }
    }

    public void printDeviceList(ArrayList<Device> deviceList) {
        for (Device device : deviceList) {
            device.printDeviceInfo();
        }
    }

}
