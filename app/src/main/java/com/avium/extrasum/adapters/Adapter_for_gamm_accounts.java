package com.avium.extrasum.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avium.extrasum.R;
import com.avium.extrasum.modelclasses.Gammaccountsmodelclass;
import com.avium.extrasum.spark.SparkAdapter;
import com.avium.extrasum.spark.SparkView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_for_gamm_accounts extends RecyclerView.Adapter<Adapter_for_gamm_accounts.GAMMACCOUNTSHOLDER> {
    List<Gammaccountsmodelclass> gammaccountsmodelclasses;
    Context context;
    int displaySize;


    public Adapter_for_gamm_accounts(List<Gammaccountsmodelclass> gammaccountsmodelclasses, Context context) {
        this.gammaccountsmodelclasses = gammaccountsmodelclasses;
        this.context = context;
    }


    @NonNull
    @Override
    public GAMMACCOUNTSHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_for_gamm_accounts, parent, false);

        return new GAMMACCOUNTSHOLDER(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GAMMACCOUNTSHOLDER holder, int position) {
        Gammaccountsmodelclass modelclass = gammaccountsmodelclasses.get(position);
        holder.profileImage.setImageResource(modelclass.getProfilrpic());
        holder.rank.setText(modelclass.getRank());
        holder.group.setText(modelclass.getTradinggroup());
        holder.since.setText(modelclass.getSinceyears());
        holder.investorscount.setText(modelclass.getInvestors());
        holder.percentage.setText(modelclass.getPercentage());
        holder.gain.setText(modelclass.getGainweek());
        holder.capital.setText(modelclass.getCapital());
        holder.equity.setText(modelclass.getEquity());
        holder.slots.setText(modelclass.getDepslots());
        holder.graph.setFillType(SparkView.FillType.DOWN);
        holder.graph.setAdapter(new GraphAdapter(modelclass.getGraphs()));
    }



    public void setDisplayCount(int numberOfEntries) {
        displaySize = numberOfEntries;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(displaySize > gammaccountsmodelclasses.size())
            return gammaccountsmodelclasses.size();
        else if (displaySize == gammaccountsmodelclasses.size())
            return gammaccountsmodelclasses.size();
        else
            return displaySize;
    }
    public class GAMMACCOUNTSHOLDER extends RecyclerView.ViewHolder {

        @BindView(R.id.profile_image)
        CircleImageView profileImage;
        @BindView(R.id.rank)
        TextView rank;
        @BindView(R.id.group)
        TextView group;
        @BindView(R.id.since)
        TextView since;
        @BindView(R.id.investorscount)
        TextView investorscount;
        @BindView(R.id.percentage)
        TextView percentage;
        @BindView(R.id.gain)
        TextView gain;
        @BindView(R.id.graph)
        SparkView graph;
        @BindView(R.id.capital)
        TextView capital;
        @BindView(R.id.equity)
        TextView equity;
        @BindView(R.id.slots)
        TextView slots;

        public GAMMACCOUNTSHOLDER(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class GraphAdapter extends SparkAdapter {
        private final float[] yData;
        private final Random random;
        public GraphAdapter(float[] yData) {
            random = new Random();
            this.yData = yData;
            randomize();
        }
        private void randomize() {
            for (int i = 0, count = yData.length; i < count; i++) {
                yData[i] = random.nextFloat();
            }
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return yData.length;
        }

        @Override
        public Object getItem(int index) {
            return yData[index];
        }

        @Override
        public float getY(int index) {
            return yData[index];
        }
    }


}
