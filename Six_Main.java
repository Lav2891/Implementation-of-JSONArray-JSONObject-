package lav.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class Six_Main extends AppCompatActivity {
    TextView type, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        type = (TextView)findViewById(R.id.type_tv);
        id = (TextView)findViewById(R.id.id_tv);

        String obj22 = getIntent().getStringExtra("OBJ2");
        Log.e("OBJ22", obj22);

        try {
            JSONObject objx = new JSONObject(obj22);
            Log.e("OBJX", String.valueOf(objx));
            String xtype = objx.getString("type");
            String xid = objx.getString("id");
            type.setText(xtype);
            id.setText(xid);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
