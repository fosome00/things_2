package com.tthings.things_2.AlertDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.R;

public class RemoteNameDialog extends AppCompatDialogFragment {

    Reply reply;

    EditText editText;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_remote_name, null);
        editText = view.findViewById(R.id.dialogRemoteName);
        builder.setView(view);
        builder.setTitle("New Remote");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if(editText.getText().toString().length() == 0)
               {
                   RemoteNameDialog remoteNameDialog = new RemoteNameDialog();
                   remoteNameDialog.show(((AppCompatActivity)getContext()).getSupportFragmentManager(), "Remote Name");

               }
                else {

                   Remote1.name = editText.getText().toString();
                   reply.reply_wait(editText.getText().toString());
                   reply.save();
               }
            }
        });


    return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        reply = (Reply) context;
    }

    public interface Reply{
        void reply_wait(String text);
        void save();
    }

}
