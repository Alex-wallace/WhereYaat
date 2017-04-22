package ca.wallacemohawcollege.alex.whereya;

/**
 * Created by Stephen on 4/22/2017.
 */

public class locTable {
    int Id;
    int owner;
    String name;
    String lat;
    String lon;

    public int getId() {
        return Id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }



}
