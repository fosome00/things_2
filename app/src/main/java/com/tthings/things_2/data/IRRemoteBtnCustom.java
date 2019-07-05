package com.tthings.things_2.data;

import java.io.Serializable;

public class IRRemoteBtnCustom implements Serializable {

    private String name = "";
    private int btnIcon = -1;
    private String key = null;
    private boolean assign = false;

    public IRRemoteBtnCustom(int btnIcon) {
        this.btnIcon = btnIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBtnIcon() {
        return btnIcon;
    }

    public void setBtnIcon(int btnIcon) {
        this.btnIcon = btnIcon;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isAssign() {
        return assign;
    }

    public void setAssign(boolean assign) {
        this.assign = assign;
    }
}
