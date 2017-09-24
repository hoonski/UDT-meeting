package com.example.kwon_younghoon.udt_meeting;

/**
 * Created by kwon-younghoon on 2017. 9. 18..
 */

public class FriendData {
    private int image;
    private String nikname;
    private String name;
    private String number;

    public FriendData() {
        this.image = image;
        this.name = name;
        this.nikname = nikname;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public String getNikname() { return nikname; }

    public String getName() { return name; }

    public String getNumber() {
        return number;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
