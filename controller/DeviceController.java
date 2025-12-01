package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.data.Device;
import model.data.exceptions.EmptyListException;
import model.data.interfaces.IDeviceController;

public class DeviceController implements IDeviceController {
    private ArrayList<Device> deviceList;

    public DeviceController() {
        this.deviceList = new ArrayList<>();
    }

    @Override
    public ArrayList<Device> getAllDevice() throws EmptyListException {
        if (deviceList.isEmpty()) {
            throw new EmptyListException();
        }
        return deviceList;
    }

    @Override
    public ArrayList<Device> getSortedDeviceList() throws EmptyListException {
        if (deviceList.isEmpty()) {
            throw new EmptyListException();
        }

        ArrayList<Device> dupeDeviceList = deviceList;

        Collections.sort(dupeDeviceList, new Comparator<Device>() {

            @Override
            public int compare(Device o1, Device o2) {

                int osNameComparator = o1.getOperatingSystem().getName().compareTo(o2.getOperatingSystem().getName());
                if (osNameComparator != 0) {
                    return osNameComparator;
                }

                int osVerComparator = Double.compare(Double.parseDouble(o1.getOperatingSystem().getVersion()),
                        Double.parseDouble(o2.getOperatingSystem().getVersion()));

                return osVerComparator;
            }

        });

        return dupeDeviceList;
    }

    @Override
    public void addDevice(Device device) {
        deviceList.add(device);
    }

}
