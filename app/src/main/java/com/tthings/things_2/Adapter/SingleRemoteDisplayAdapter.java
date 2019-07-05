package com.tthings.things_2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tthings.things_2.Common.Remote1;
import com.tthings.things_2.Common.RemoteList;
import com.tthings.things_2.R;
import com.tthings.things_2.data.CustomRemote;
import com.tthings.things_2.data.IRRemoteBtnCustom;

import java.util.ArrayList;

public class SingleRemoteDisplayAdapter extends RecyclerView.Adapter<SingleRemoteDisplayAdapter.ViewHolder> {
    private Context context;
    private int position;
    private int default_icon;
    private CustomRemote remote;
    private ArrayList<IRRemoteBtnCustom> irRemoteBtnCustoms;
    private ImageView led;

    public SingleRemoteDisplayAdapter(Context context, int position, int default_icon, ImageView led) {
        this.context = context;
        this.position = position;
        this.default_icon = default_icon;
        this.led = led;
        if (position > -1){
            this.remote = RemoteList.getRemote(position);
            this.irRemoteBtnCustoms = this.remote.getRemoteBtnCustom();
        }
        else
        {
            //this.remote = RemoteList.getRemote(position);
            this.irRemoteBtnCustoms = Remote1.data;

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.button_display,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        if (irRemoteBtnCustoms.get(i).isAssign())
        {
            viewHolder.imageView.setImageResource(irRemoteBtnCustoms.get(i).getBtnIcon());
            viewHolder.textView.setText(irRemoteBtnCustoms.get(i).getName());
            viewHolder.relativeLayout.setClickable(true);
            if (irRemoteBtnCustoms.get(i).getName().length() == 0)
            {
                viewHolder.textView.setVisibility(View.GONE);
                viewHolder.textView.setGravity(RelativeLayout.CENTER_IN_PARENT);
                viewHolder.relativeLayout.setGravity(RelativeLayout.CENTER_IN_PARENT);
            }
            if (irRemoteBtnCustoms.get(i).getBtnIcon() == 0)
            {
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.textView.setHeight(95);

            }

        }
        else
        {   viewHolder.imageView.setClickable(false);
            viewHolder.imageView.setImageResource(default_icon);
            viewHolder.textView.setText("");
            viewHolder.relativeLayout.setClickable(false);
            viewHolder.cardView.setVisibility(View.INVISIBLE);
            viewHolder.imageView.setVisibility(View.GONE);

        }


        /*if (((remote.getRemoteBtnCustom()).get(i)).isAssign())
            {
                viewHolder.imageView.setImageResource(((remote.getRemoteBtnCustom()).get(i)).getBtnIcon());
                viewHolder.textView.setText(((remote.getRemoteBtnCustom()).get(i)).getName());
            }
            else
            {
                viewHolder.imageView.setImageResource(default_icon);
                viewHolder.imageView.setClickable(false);
                viewHolder.relativeLayout.setClickable(false);
            }*/
    }

    @Override
    public int getItemCount() {
        if (position == -1) {
            Remote1.check_last_position();
            return Remote1.last_position+1;
        }
         else
            return remote.getLast_position()+1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.btnLayout);
            imageView = itemView.findViewById(R.id.btnIcon);
            textView = itemView.findViewById(R.id.btnName);
            cardView = itemView.findViewById(R.id.btnCardView);


            relativeLayout.setClickable(true);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    led.setImageResource(R.drawable.untitled);
                    Toast.makeText(context,"you Clicked "+irRemoteBtnCustoms.get(getAdapterPosition()).getName() ,Toast.LENGTH_SHORT).show();
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(led.getDrawable().equals(R.drawable.ic_arrow_drop_up_red_24dp) );

                            led.setImageResource(R.drawable.ic_arrow_drop_up_red_24dp);
                        }
                    },450);


                }
            });




        }
    }
}
