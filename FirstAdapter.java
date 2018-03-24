package lav.one;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/11/2017.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder> {

    Context context;
    ArrayList<JSONObject> namelist;
    JSONArray response;
    Bundle bundle = new Bundle();

    public FirstAdapter(ArrayList<JSONObject> namelist, JSONArray response, Context context) {
        this.namelist = namelist;
        this.context = context;
        this.response = response;
    }

    @Override
    public FirstAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_first, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        JSONObject obj = namelist.get(position);
        try {
           final String n = obj.getString("name");
            holder.name1.setText(" "+n);
            holder.name1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, SecondMain.class);
                    intent.putExtra("namestring", n);
                   // intent.putExtra("RESPONSE", (Parcelable) response);

                       Log.e("TRY",response.toString());
                        intent.putExtra("RESPONSE",response.toString());

                    context.startActivity(intent);
                }
            });

            Log.e("GET",n);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return namelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name1;

        public ViewHolder(View itemView) {
            super(itemView);
            name1=(TextView)itemView.findViewById(R.id.tv_name1);
        }
    }
}
