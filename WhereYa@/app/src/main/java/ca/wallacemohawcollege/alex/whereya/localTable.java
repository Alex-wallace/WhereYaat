package ca.wallacemohawcollege.alex.whereya;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by alex_ on 20/04/2017.
 */
public class localTable {

    public int Id;
    int owner;
    String name;
    String Address;
    String Lat;
    String Long;



    localTable(int Id,int owner,String name,String Address,String Lat,String Long){
        this.Id = Id;
        this.owner = owner;
        this.name = name;
        this.Address = Address;
        this.Lat = Lat;
        this.Long = Long;

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public int getId() {
        return Id;
    }


}
