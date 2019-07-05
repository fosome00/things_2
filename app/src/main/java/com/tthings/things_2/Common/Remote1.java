package com.tthings.things_2.Common;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.tthings.things_2.data.IRRemoteBtnCustom;

import java.util.ArrayList;

public class Remote1 {
    public static int position = -1;
    public static boolean change = false;
    public static RecyclerView.Adapter adapter = null;
    public static boolean click = true;
    public static String name = null;
    public static int last_position = -1;

    public static ArrayList<IRRemoteBtnCustom>  data = new ArrayList<>();
    public static Activity activity = null;

    public static void check_last_position()
    {
        if(last_position < position)
            last_position = position;
    }




    public static void change(){
        if(Remote1.change )
        {   IRRemoteBtnCustom obj;
            obj = data.get(position);
            obj.setBtnIcon(CommonIcon.icon);
            obj.setName(CommonIcon.name);
            obj.setAssign(true);
            data.set(position,obj) ;
            click = true;

            position = -1;
            CommonIcon.icon = 0;
            CommonIcon.name = null;
            change = false;
            adapter.notifyDataSetChanged();
        }

    }
}
