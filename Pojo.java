package lav.one;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ashwin on 12/12/2017.
 */

public class Pojo {
    JSONArray topping;
    String name;
    JSONObject batters;
    String ppu;
    String type;
    String id;

    public JSONArray getTopping() {
        return topping;
    }

    public void setTopping(JSONArray topping) {
        this.topping = topping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getBatters() {
        return batters;
    }

    public void setBatters(JSONObject batters) {
        this.batters = batters;
    }

    public String getPpu() {
        return ppu;
    }

    public void setPpu(String ppu) {
        this.ppu = ppu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
