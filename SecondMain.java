package lav.one;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/11/2017.
 */

public class SecondMain extends AppCompatActivity {

    RecyclerView rview;
    LinearLayoutManager lm;
    SecondAdapter adapter;

    Pojo pojo;
    JSONArray response;
    ArrayList<Pojo> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        rview = (RecyclerView)findViewById(R.id.rv);
        lm = new LinearLayoutManager(this);
        rview.setLayoutManager(lm);

        final String str = String.valueOf(getIntent().getStringExtra("namestring"));
        Log.e("SECOND STRING", str);

      /*  response = getIntent().getParcelableExtra("RESPONSE");
        Log.e("RESPONSE", String.valueOf(response));*/

        String x = getIntent().getStringExtra("RESPONSE");
        Log.e("THIRD STRING",x);

        try {
            response = new JSONArray(x);
            Log.e("RESPONSE", String.valueOf(response));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        pojo = new Pojo();
        Log.e("ARRAY SIZE", String.valueOf(response.length()));
        for (int i=0;i<response.length();i++) {
            try {
                Log.e("TRY","try");
                JSONObject object = response.getJSONObject(i);
               // JSONArray topping = object.getJSONArray("topping");
                String name = object.getString("name");
                Log.e("NAME",name);
                if(name.equals(str)){
                    Log.e("FINAL NAME",name);
                    JSONArray topping = object.getJSONArray("topping");
                    Log.e("FINAL TOPPING", String.valueOf(topping));
                    String ppu = object.getString("ppu");
                    Log.e("FINAL PPU",ppu);
                    JSONObject batters = object.getJSONObject("batters");
                    Log.e("FINAL BATTERS", String.valueOf(batters));
                    String type = object.getString("type");
                    Log.e("FINAL TYPE",type);
                    String id = object.getString("id");
                    Log.e("FINAL ID",id);

                    pojo.setTopping(topping);
                    pojo.setName(name);
                     pojo.setBatters(batters);
                     pojo.setPpu(ppu);
                    pojo.setType(type);
                    pojo.setId(id);

                    list.add(pojo);
                }
                //JSONObject batters = object.getJSONObject("batters");
                //String ppu = object.getString("ppu");
               // String type = object.getString("type");
               // String id = object.getString("id");

              // pojo.setTopping(topping);
               // pojo.setName(name);
              // pojo.setBatters(batters);
               // pojo.setPpu(ppu);
                //pojo.setType(type);
                //pojo.setId(id);

               // list.add(pojo);



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter = new SecondAdapter(list,SecondMain.this);
        rview.setAdapter(adapter);

    }

        }



