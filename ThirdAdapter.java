package lav.one;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.ViewHolder> {
    ArrayList<JSONObject> list;
    Context context;

    public ThirdAdapter(ArrayList<JSONObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ThirdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_thirdadapter, parent, false);

        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e("SIZE ARRAY", String.valueOf(list.size()));
        final JSONObject topobj = list.get(position);
        Log.e("OBJECT LIST", String.valueOf(topobj));

        /*
        JSONObject zero = pojotop.getObjzero();
        Log.e("ZERO", String.valueOf(zero));
        JSONObject one = pojotop.getObjone();
        JSONObject two = pojotop.getObjtwo();
        JSONObject three = pojotop.getObjthree();
        JSONObject four = pojotop.getObjfour();
        JSONObject five = pojotop.getObjfive();
        JSONObject six = pojotop.getObjsix();*/

        holder.tvzero.setText(topobj.toString());
     /*   holder.tvone.setText("ONE");
        holder.tvtwo.setText("TWO");
        holder.tvthree.setText("THREE");
        holder.tvfour.setText("FOUR");
        holder.tvfive.setText("FIVE");
        holder.tvsix.setText("SIX");*/

        holder.tvzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Four_Main.class);
                intent.putExtra("TOPOBJ", topobj.toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvzero;

        public ViewHolder(View itemView) {
            super(itemView);
            tvzero=(TextView)itemView.findViewById(R.id.tv_zero);

        }
    }
}
