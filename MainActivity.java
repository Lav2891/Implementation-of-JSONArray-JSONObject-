package lav.one;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button name;
    RecyclerView recyclerView;
    LinearLayoutManager lm;
    FirstAdapter adapter;
    ArrayList<JSONObject> namelist = new ArrayList<>();
    private ProgressDialog pDialog;
    String URL = "http://www.json-generator.com/api/json/get/cqVreZptBu?indent=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(Button)findViewById(R.id.b_name);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        lm=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method();
                Log.e("ONCLICK","clicked");
            }
        });

    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    private void method() {
        showProgressDialog();
        Log.e("METHOD","in1");
        JsonArrayRequest jsonarrayrequest = new JsonArrayRequest(Request.Method.GET, URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("METHOD","in2");
                int length = response.length();
                Log.e("ARRAY",response.toString());

                try {
                    Log.e("LENGTH", String.valueOf(length));
                    for (int i=0; i<length;i++) {
                        JSONObject x = response.getJSONObject(i);
                        Log.e("OBJECT", x.toString());
                        String s = x.getString("name");
                        Log.e("METHOD", s);
                        // String name = x.getString("name");
                        //Log.e("PUT",name);
                        namelist.add(x);
                    }
                    adapter = new FirstAdapter(namelist, response, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    hideProgressDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", String.valueOf(error));
                hideProgressDialog();
            }
        }) {
          /*  @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/JSON");
                map.put("Content-Length", "72");
                return map;
            }*/
        };
        AppController.getInstance().addToRequestQueue(jsonarrayrequest,"OUT");
    }

}
