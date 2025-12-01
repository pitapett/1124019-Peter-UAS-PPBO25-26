package model.data.interfaces;

import java.util.ArrayList;

import model.data.Device;
import model.data.exceptions.EmptyListException;

public interface IDeviceController {
    public ArrayList<Device> getAllDevice() throws EmptyListException;
    public ArrayList<Device> getSortedDeviceList() throws EmptyListException;
    public void addDevice(Device device);
}