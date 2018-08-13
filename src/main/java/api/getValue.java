package api;


import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;

public class getValue {

    /**
     * 解析Json内容
     * @return JsonValue 返回JsonString中JsonId对应的Value
     **/

    public static String getJsonValue(String JsonString, String JsonId) {
        String JsonValue ="";
        if (JsonString == null || JsonString.trim().length() < 1) {
            System.out.println("please inout JsonString");
            return null;
        }
        try {
            JSONObject obj = new JSONObject(JsonString);
            JsonValue = obj.getString(JsonId);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return JsonValue;
    }

}
