package lav.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class Four_Main extends AppCompatActivity {
    JSONObject object;
    PojoTop pojoTop = new PojoTop();
    ArrayList<PojoTop> list = new ArrayList<>();
    RecyclerView rview;
    LinearLayoutManager lm;
    Four_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        rview = (RecyclerView)findViewById(R.id.rv);
        lm = new LinearLayoutManager(this);
        rview.setLayoutManager(lm);

        String topobj = getIntent().getStringExtra("TOPOBJ");
        Log.e("TOP OBJ", topobj);

        try {
            object = new JSONObject(topobj);
            String type = object.getString("type");
            String id = object.getString("id");
            Log.e("TYPE",type);
            pojoTop.setType(type);
            pojoTop.setId(id);
            list.add(pojoTop);

            adapter=new Four_Adapter(list,Four_Main.this);
            rview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
