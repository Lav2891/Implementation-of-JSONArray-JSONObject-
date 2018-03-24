package lav.one;

import android.os.Bundle;
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

public class ThirdMain extends AppCompatActivity {
    JSONArray topping;
    ArrayList<JSONObject> list = new ArrayList<>();
    RecyclerView rview;
    LinearLayoutManager lm;
    ThirdAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rview = (RecyclerView)findViewById(R.id.rv);
        lm = new LinearLayoutManager(this);
        rview.setLayoutManager(lm);

        String top = getIntent().getStringExtra("TOPPING");
        Log.e("TOPPING STRING", top);

        try {
            topping = new JSONArray(top);
            Log.e("ARRAY TOPPING SIZE", String.valueOf(topping.length()));

            for (int i=0;i<topping.length();i++){
                JSONObject topobj = topping.getJSONObject(i);
             list.add(topobj);
                Log.e("TOPPING LIST", String.valueOf(list));
            }
            adapter = new ThirdAdapter(list,ThirdMain.this);
            rview.setAdapter(adapter);

             /*   JSONObject zero = topping.getJSONObject(0);
            Log.e("ZERO MAIN", String.valueOf(zero));
            JSONObject one = topping.getJSONObject(1);
            JSONObject two = topping.getJSONObject(2);
            JSONObject three = topping.getJSONObject(3);
            JSONObject four = topping.getJSONObject(4);
            JSONObject five = topping.getJSONObject(5);
            JSONObject six = topping.getJSONObject(6);*/

         /*   pojotop.setObjzero(zero);
            Log.e("POJO","xxx");
            pojotop.setObjone(one);
            pojotop.setObjtwo(two);
            pojotop.setObjthree(three);
            pojotop.setObjfour(four);
            pojotop.setObjfive(five);
            pojotop.setObjsix(six);

            list.add(pojotop);
Log.e("LIST TOPPING", String.valueOf(list));
            adapter = new ThirdAdapter(list,ThirdMain.this);
            rview.setAdapter(adapter);
            Log.e("END","end");*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
