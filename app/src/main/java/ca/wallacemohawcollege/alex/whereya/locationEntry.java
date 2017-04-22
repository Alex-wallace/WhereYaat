package ca.wallacemohawcollege.alex.whereya;

import com.microsoft.azure.storage.table.TableServiceEntity;

/**
 * Created by Stephen on 12/4/2016.
 */
public class locationEntry extends TableServiceEntity {
    public locationEntry(long locationId, String name) {
        this.partitionKey = String.valueOf(locationId);
        this.rowKey = name;
    }

    public locationEntry() { }

    String address;
    double rightLat;
    double rightLong;
    double leftLat;
    double leftLong;
    String[] floors;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRightLat() {
        return rightLat;
    }

    public void setRightLat(double rightLat) {
        this.rightLat = rightLat;
    }

    public double getRightLong() {
        return rightLong;
    }

    public void setRightLong(double rightLong) {
        this.rightLong = rightLong;
    }

    public double getLeftLat() {
        return leftLat;
    }

    public void setLeftLat(double leftLat) {
        this.leftLat = leftLat;
    }

    public double getLeftLong() {
        return leftLong;
    }

    public void setLeftLong(double leftLong) {
        this.leftLong = leftLong;
    }

    public String[] getFloors() {
        return floors;
    }

    public void setFloors(String[] floors) {
        this.floors = floors;
    }
}
