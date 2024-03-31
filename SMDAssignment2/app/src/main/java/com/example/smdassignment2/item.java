package com.example.smdassignment2;

import android.os.Parcel;
import android.os.Parcelable;

public class item implements Parcelable, Comparable<item> {

    private String Rname, loc, Phone , Des ;
    double Rating;
    

    public item() {
    }

    public item(String name, String loc, String Phone,String des, double rat ) {
        this.Rname = name;
        this.loc = loc;
        this.Phone = Phone;
        this.Des = des ;
        this.Rating = rat;
    }

    public String getName() {
        return Rname;
    }

    public void setName(String rname) {
        this.Rname = rname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getPhone() {
        return Phone;
    }


    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getDes() {
        return Des;
    }


    public void setDes(String d) {
        this.Des = d;
    }

    public double getrating() {
        return Rating;
    }

    public void setrating(double a) {
        this.Rating = a;
    }

    protected item(Parcel in) {
        Rname = in.readString();
        loc = in.readString();
        Phone = in.readString();
        Des = in.readString();
        Rating = in.readDouble();
    }

    public static final Creator<item> CREATOR = new Creator<item>() {
        @Override
        public item createFromParcel(Parcel in) {
            return new item(in);
        }

        @Override
        public item[] newArray(int size) {
            return new item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Rname);
        dest.writeString(loc);
        dest.writeString(Phone);
        dest.writeString(Des);
        dest.writeDouble(Rating);
    }


    @Override
    public int compareTo(item other) {
        // Compare items based on their ratings
        return Double.compare(other.getrating(), this.getrating());
    }
}


