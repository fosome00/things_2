package com.tthings.things_2.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tthings.things_2.Common.CommonIcon;
import com.tthings.things_2.R;

import java.util.ArrayList;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    final String TAG = "ADAPTER";
    private Context context;
    private int[] data;
    ArrayList<String> colorVal = new ArrayList<>();



    public IconAdapter(Context context, int[] data) {
        this.context = context;
        this.data = data;
        for (int i = 0; i < data.length; i++ ){

            colorVal.add("#5E5E5E");

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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        viewHolder.imageView.setImageResource(data[i]);
        viewHolder.imageView.setBackgroundColor(Color.parseColor(colorVal.get(i)));
        viewHolder.name.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout relativeLayout;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.btnName);
            imageView = itemView.findViewById(R.id.btnIcon);
            relativeLayout = itemView.findViewById(R.id.btnLayout);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (CommonIcon.position == -1 )
                    {
                        CommonIcon.position = getAdapterPosition();
                        CommonIcon.icon = data[getAdapterPosition()];
                        colorVal.set(CommonIcon.position,"#FF00FF00");

                        notifyDataSetChanged();
                    }
                    else if ( CommonIcon.position == getAdapterPosition()){
                        colorVal.set(CommonIcon.position,"#5E5E5E");
                        CommonIcon.position = -1;
                        CommonIcon.icon = 0;
                        notifyDataSetChanged();
                    }
                    else
                    {
                        colorVal.set(CommonIcon.position,"#5E5E5E");
                        CommonIcon.position = getAdapterPosition();
                        colorVal.set(CommonIcon.position,"#FF00FF00");
                        CommonIcon.icon = data[getAdapterPosition()];

                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
