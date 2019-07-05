package com.tthings.things_2.Common;

import com.tthings.things_2.data.CustomRemote;
import com.tthings.things_2.data.IRRemoteBtnCustom;

import java.util.ArrayList;

public class RemoteList {

    public static ArrayList<CustomRemote> remotes = new ArrayList<>();

    public static void addRemote(ArrayList<IRRemoteBtnCustom> data, String name, int last_position)
    {
        CustomRemote obj = new CustomRemote(data);
        obj.setName(name);
        obj.setLast_position(last_position);
        remotes.add(obj);
    }

    public static CustomRemote getRemote(int position)
    {
        return remotes.get(position);
    }





}
