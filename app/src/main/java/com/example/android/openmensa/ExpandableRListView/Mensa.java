package com.example.android.openmensa.ExpandableRListView;

import android.os.Parcel;
import android.os.Parcelable;

public class Mensa implements Parcelable {

    private String name;
    private String city;
    private String coordinate1;
    private String coordinate2;
    private String address;

    public Mensa(String name, String city, String coordinate1, String coordinate2, String address) {
        this.name = name;
        this.city = city;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
        this.address = address;
    }

    protected Mensa(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinate1() {
        return coordinate1;
    }

    public String getCoordinate2() {
        return coordinate2;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Mensa)) return false;

        Mensa mensa = (Mensa) obj;

        return getName() != null ? getName().equals(mensa.getName()) : mensa.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mensa> CREATOR = new Creator<Mensa>() {
        @Override
        public Mensa createFromParcel(Parcel in) {
            return new Mensa(in);
        }

        @Override
        public Mensa[] newArray(int size) {
            return new Mensa[size];
        }
    };
}
