package com.example.micaelacavallo.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by micaela.cavallo on 29/01/2015.
 */
public class Sandwich implements Parcelable {
    private String bread;
    private Boolean tomato;
    private Boolean cheese;
    private Boolean lettuce;
    private Boolean bacon;
    private Boolean olives;
    private Boolean pickles;
    private Boolean onion;
    private Boolean egg;

    public Sandwich ()
    {
        setBread("wheat");
        setTomato(false);
        setCheese(false);
        setLettuce(false);
        setBacon(false);
        setOlives(false);
        setPickles(false);
        setOnion(false);
        setEgg(false);
    }

    public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>(){

        @Override
        public Sandwich createFromParcel(Parcel source) {
            return new Sandwich(source);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };

    private Sandwich (Parcel source){
        setBread(source.readString());
        setTomato((source.readInt()==1));
        setPickles((source.readInt()==1));
        setLettuce((source.readInt()==1));
        setCheese((source.readInt()==1));
        setBacon((source.readInt()==1));
        setOlives((source.readInt()==1));
        setOnion((source.readInt()==1));
        setEgg((source.readInt()==1));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getBread());
        dest.writeInt(getTomato() ?1:0);
        dest.writeInt(getPickles()?1:0);
        dest.writeInt(getLettuce() ?1:0);
        dest.writeInt(getCheese() ?1:0);
        dest.writeInt(getBacon() ?1:0);
        dest.writeInt(getOlives() ?1:0);
        dest.writeInt(getEgg() ?1:0);
        dest.writeInt(getOnion() ?1:0);
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public Boolean getTomato() {
        return tomato;
    }

    public void setTomato(Boolean tomato) {
        this.tomato = tomato;
    }

    public Boolean getCheese() {
        return cheese;
    }

    public void setCheese(Boolean cheese) {
        this.cheese = cheese;
    }

    public Boolean getLettuce() {
        return lettuce;
    }

    public void setLettuce(Boolean lettuce) {
        this.lettuce = lettuce;
    }

    public Boolean getBacon() {
        return bacon;
    }

    public void setBacon(Boolean bacon) {
        this.bacon = bacon;
    }

    public Boolean getOlives() {
        return olives;
    }

    public void setOlives(Boolean olives) {
        this.olives = olives;
    }

    public Boolean getPickles() {
        return pickles;
    }

    public void setPickles(Boolean pickles) {
        this.pickles = pickles;
    }

    public Boolean getOnion() {
        return onion;
    }

    public void setOnion(Boolean onion) {
        this.onion = onion;
    }

    public Boolean getEgg() {
        return egg;
    }

    public void setEgg(Boolean egg) {
        this.egg = egg;
    }
}
