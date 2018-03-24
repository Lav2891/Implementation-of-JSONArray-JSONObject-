package lav.one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class Four_Adapter extends RecyclerView.Adapter<Four_Adapter.ViewHolder> {
    ArrayList<PojoTop> list;
    Context context;

    public Four_Adapter(ArrayList<PojoTop> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Four_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_fouradapter, parent, false);

        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e("LIST SIZE", String.valueOf(list.size()));
        PojoTop poj = list.get(position);
        String type = poj.getType();
        String id = poj.getId();

        holder.tvtype.setText(type);
        holder.tvid.setText(id);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvtype, tvid;

        public ViewHolder(View itemView) {
            super(itemView);
            tvtype = (TextView)itemView.findViewById(R.id.tv_type);
            tvid = (TextView)itemView.findViewById(R.id.tv_id);
        }
    }
}
