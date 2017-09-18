package com.example.kwon_younghoon.udt_meeting;

/**
 * Created by kwon-younghoon on 2017. 9. 18..
 */

public class FriendData {
    private int image;
    private String nikname;
    private String name;
    private String number;

    public FriendData(int image, String name ,String nikname, String number) {
        this.image = image;
        this.name = name;
        this.nikname = nikname;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public String getNikname() {
        return nikname;
    }

    public String getName() { return name; }

    public String getNumber() {
        return number;
    }

//    public void setNikname(String nikname) {
//        this.nikname = nikname;
//    }
}
