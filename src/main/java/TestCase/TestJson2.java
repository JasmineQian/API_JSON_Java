package TestCase;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestJson2 {
    public static void main(String[] args) {

        String s = "{\"error\":0,\"status\":\"success\",\"results\":[{\"currentCity\":\"青岛\",\"index\":[{\"title\":\"穿衣\",\"zs\":\"较冷\",\"tipt\":\"穿衣指数\",\"des\":\"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。\"},{\"title\":\"紫外线强度\",\"zs\":\"最弱\",\"tipt\":\"紫外线强度指数\",\"des\":\"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。\"}],}]}";
        System.out.println(s);
        JSONObject jsonObject = new JSONObject(s);

        //提取出error为 0
        int error = jsonObject.getInt("error");
        System.out.println("error:" + error);

        //提取出status为 success
        String status = jsonObject.getString("status");
        System.out.println("status:" + status);

        //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象
        JSONArray result = jsonObject.getJSONArray("results");

        for (int i = 0; i < result.length(); i++) {
            //提取出currentCity为 青岛
            String currentCity = result.getJSONObject(i).getString("currentCity");
            System.out.println("currentCity:" + currentCity);

            //注意：index中的内容带有中括号[]，所以要转化为JSONArray类型的对象
            JSONArray index = result.getJSONObject(i).getJSONArray("index");

            for (int j = 0; j < index.length(); j++) {
                String title = index.getJSONObject(j).getString("title");
                System.out.println("title:" + title);
                String zs = index.getJSONObject(j).getString("zs");
                System.out.println("zs:" + zs);
                String tipt = index.getJSONObject(j).getString("tipt");
                System.out.println("tipt:" + tipt);
                String des = index.getJSONObject(j).getString("des");
                System.out.println("des:" + des);

            }
        }

    }
}
