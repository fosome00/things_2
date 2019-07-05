package com.tthings.things_2.data;

import java.util.ArrayList;

public class CustomRemote {

    public CustomRemote( ArrayList<IRRemoteBtnCustom> remoteBtnCustom) {
        this.remoteBtnCustom = new ArrayList<>();
        this.remoteBtnCustom.addAll(remoteBtnCustom);
    }

    private String name;
    private int id;
    private ArrayList<IRRemoteBtnCustom> remoteBtnCustom;
    private int row = 4;
    private int column = 10;
    private int last_position = 0;

    public int getLast_position() {
        return last_position;
    }

    public void setLast_position(int last_position) {
        this.last_position = last_position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<IRRemoteBtnCustom> getRemoteBtnCustom() {
        return remoteBtnCustom;
    }

    public void setRemoteBtnCustom(ArrayList<IRRemoteBtnCustom> remoteBtnCustom) {
        this.remoteBtnCustom = remoteBtnCustom;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
