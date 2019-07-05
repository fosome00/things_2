package com.tthings.things_2.AlertDialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tthings.things_2.Adapter.IconAdapter;
import com.tthings.things_2.Common.CommonIcon;
import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.R;

public class AddIconDialog extends AppCompatDialogFragment {

    final String TAG = "AddIconDialog.java : ";

    RecyclerView recyclerView;
    EditText editText;
    private int error = 0;
    Button button;
    LinearLayout dialogIconLinearLayout;
    RelativeLayout dialogItemRelativeLayout;
    Context context;
    @SuppressLint("ValidFragment")
    public AddIconDialog(int error) {
        this.error = error;
    }

    public AddIconDialog() {
    }

    int[] data_icon_list = {R.drawable.ic_arrow_up, R.drawable.ic_arrow_down,R.drawable.ic_arrow_right, R.drawable.ic_arrow_left,R.drawable.audio_left, R.drawable.audio_left, R.drawable.audio_left2, R.drawable.audio_play, R.drawable.audion_right, R.drawable.audio_right2, R.drawable.audio_stop, R.drawable.back, R.drawable.ic_action_record_pressed, R.drawable.ic_action_record, R.drawable.audio_eject, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp, R.drawable.ic_volume_mute_black_24dp, R.drawable.ic_volume_up_black_24dp, R.drawable.ic_power_settings_new_black_24dp,};


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view;
        error = 0;

        if (error == 0){
             view = inflater.inflate(R.layout.icon_list, null);
        }
        else {
            view = inflater.inflate(R.layout.icon_list_error, null);
            error = 0;
        }
        editText = view.findViewById(R.id.newButtonName);


        builder.setView(view);
        builder.setTitle("New Button");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CommonIcon.position = -1;
                CommonIcon.icon = 0;
                Remote1.click = true;
            }
        });
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

           if (editText.getText().toString().length() != 0 || Remote1.data.get(Remote1.position).getName().length() != 0) {
               Log.d(TAG, "the final value is : " + CommonIcon.position);
               if(editText.getText().toString().length() != 0)
                   CommonIcon.name = editText.getText().toString();
               else
                   CommonIcon.name = Remote1.data.get(Remote1.position).getName();
               Remote1.change = true;
               Remote1.check_last_position();
               CommonIcon.position = -1;
               Remote1.change();
           }
           else
           {   AddIconDialog addIconDialog = new AddIconDialog(1);

               addIconDialog.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "ADD ICON");

               CommonIcon.position = -1;
               CommonIcon.icon = 0;
               Remote1.click = true;

           }


            }
        });



        context = getContext();
        recyclerView = view.findViewById(R.id.rvIconListAlertDialog);
        editText = view.findViewById(R.id.newButtonName);
        editText.setText(CommonIcon.name,null);
        button = view.findViewById(R.id.select_icon_button);
        dialogIconLinearLayout = view.findViewById(R.id.select_icon_layout);
        dialogItemRelativeLayout = view.findViewById(R.id.icon_list_outer_layout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = v;

                recyclerView.setVisibility(View.VISIBLE);
                dialogItemRelativeLayout.setMinimumHeight(500);
                dialogIconLinearLayout.setVisibility(View.GONE);
                GridLayoutManager layoutManager = new GridLayoutManager(context, 7);
                recyclerView.setLayoutManager(layoutManager);
                RecyclerView.Adapter adapter = new IconAdapter(context, data_icon_list);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                try {
                    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });

        return builder.create();
    }
}