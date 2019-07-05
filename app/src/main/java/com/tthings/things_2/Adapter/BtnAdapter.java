package com.tthings.things_2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tthings.things_2.AlertDialog.AddIconDialog;
import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.R;
import com.tthings.things_2.data.IRRemoteBtnCustom;

import java.util.ArrayList;

public class BtnAdapter extends RecyclerView.Adapter<BtnAdapter.ViewHolder>  {

    final String TAG = "BTN ADAPTER";
    private Context context;
    private ArrayList<IRRemoteBtnCustom> data;

    public BtnAdapter(Context context, ArrayList<IRRemoteBtnCustom> data) {
        this.context = context;
        this.data = data;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.button, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.icon.setImageResource(Remote1.data.get(i).getBtnIcon());
        if(Remote1.data.get(i).getName().length() == 0)
            viewHolder.name.setVisibility(View.GONE);
        else
        {
            viewHolder.name.setText(Remote1.data.get(i).getName());
            viewHolder.name.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return Remote1.data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;
        RelativeLayout layout;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.btnIcon);
            name = itemView.findViewById(R.id.btnName);
            layout = itemView.findViewById(R.id.btnLayout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Remote1.click || Remote1.position == -1)
                    {
                        layout.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Remote1.click = true;
                            }
                        },1000);
                        Remote1.click = false;
                        Remote1.position = getAdapterPosition();
                        AddIconDialog addIconDialog = new AddIconDialog();
                        //addIconDialog.onAttach(context);
                        addIconDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "ADD ICON");

                    }



                }
            });

        }


    }

}
