package lav.one;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class FiveMain extends AppCompatActivity {
    RecyclerView rview;
    LinearLayoutManager lm;
    FiveAdapter adapter;
    PojoBat poj = new PojoBat();
    ArrayList<JSONObject> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rview = (RecyclerView)findViewById(R.id.rv);
        lm = new LinearLayoutManager(this);
        rview.setLayoutManager(lm);

        String bat = getIntent().getStringExtra("BATTER");
        Log.e("BATTER STRING", bat);

        try {
            Log.e("TRY","try");
            JSONObject obj = new JSONObject(bat);
            Log.e("OBJECT BATTER", String.valueOf(obj));
            JSONArray batter = obj.getJSONArray("batter");
            Log.e("ARRAY BATTER", String.valueOf(batter.length()));

            for (int i =0; i<batter.length();i++){
                JSONObject obj1 = batter.getJSONObject(i);
                list.add(obj1);
            }
adapter = new FiveAdapter(list,FiveMain.this);
            rview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
