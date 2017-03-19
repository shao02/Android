package com.example.hello.design_material;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hello.design_material.domain.BroadcastMsg;

import java.util.List;

/**
 * Created by xu_s on 3/16/17.
 */

public class BroadCastMsgsAdapter extends RecyclerView.Adapter<BroadCastMsgsAdapter.ViewHolder>{
    private List<BroadcastMsg> broadcastMsg;

    public BroadCastMsgsAdapter(List<BroadcastMsg> broadcastMsg){
        this.broadcastMsg = broadcastMsg;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    public void updateList(List<BroadcastMsg> broadcastMsg){
        this.broadcastMsg = broadcastMsg;
    }

    @Override
    public BroadCastMsgsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.broadcast_msg,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        CardView cardView = holder.cardView;
        ImageView profile_image = (ImageView) cardView.findViewById(R.id.profile_image);
        TextView userName_text = (TextView) cardView.findViewById(R.id.username);
        TextView datetime_text  = (TextView) cardView.findViewById(R.id.datetime);
        TextView content  = (TextView) cardView.findViewById(R.id.broadcast_content);

        Resources resources = cardView.getResources();
        final int resourceId = resources.getIdentifier(broadcastMsg.get(position).getProfile_image(), "drawable",
                cardView.getContext().getPackageName());
        profile_image.setImageDrawable(resources.getDrawable(resourceId));
        userName_text.setText(broadcastMsg.get(position).getUserName());
        datetime_text.setText(broadcastMsg.get(position).getBroadcast_dateTime());
        content.setText(broadcastMsg.get(position).getBroadcast_content());
    }

    @Override
    public int getItemCount(){
        return broadcastMsg.size();
    }
}
