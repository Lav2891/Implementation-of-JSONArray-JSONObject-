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

public class FiveAdapter extends RecyclerView.Adapter<FiveAdapter.ViewHolder> {
    ArrayList<JSONObject> list;
    Context context;

    public FiveAdapter(ArrayList<JSONObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_fiveadapter, parent, false);

        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      //  Log.e("SIZZEEE", String.valueOf(list.size()));

        final JSONObject obj2 = list.get(position);


       holder.tvtype.setText(obj2.toString());
        holder.tvtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Six_Main.class);
                intent.putExtra("OBJ2", obj2.toString());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtype;

        public ViewHolder(View itemView) {
            super(itemView);
            tvtype=(TextView)itemView.findViewById(R.id.tv_type);

        }
    }
}
