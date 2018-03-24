package lav.one;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    ArrayList<Pojo> list;
    Context context;

    public SecondAdapter(ArrayList<Pojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SecondAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_secondadapter, parent, false);

        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pojo pojo = list.get(position);

        final JSONArray top = pojo.getTopping();
        final JSONObject bat = pojo.getBatters();

        holder.tvtopping.setText("topping");
        holder.tvname.setText(pojo.getName());
        holder.tvbatters.setText("batters");
        holder.tvppu.setText( pojo.getPpu());
        holder.tvtype.setText(pojo.getType());
        holder.tvid.setText(pojo.getId());

        holder.tvtopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ThirdMain.class);
                intent.putExtra("TOPPING", top.toString());
                Log.e("TOPPING",top.toString());
                context.startActivity(intent);
            }
        });

        holder.tvbatters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FiveMain.class);
                intent.putExtra("BATTER", bat.toString());
                Log.e("BATTER",bat.toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        int c = list.size();
        Log.e("C", String.valueOf(c));
        return c;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtopping;
        TextView tvname;
        TextView tvbatters;
        TextView tvppu;
        TextView tvtype;
        TextView tvid;

        public ViewHolder(View itemView) {
            super(itemView);
            tvtopping = (TextView)itemView.findViewById(R.id.tv_topping);
            tvname = (TextView)itemView.findViewById(R.id.tv_name);
            tvbatters = (TextView)itemView.findViewById(R.id.tv_batters);
            tvppu = (TextView)itemView.findViewById(R.id.tv_ppu);
            tvtype = (TextView)itemView.findViewById(R.id.tv_type);
            tvid = (TextView)itemView.findViewById(R.id.tv_id);
        }
    }
}
