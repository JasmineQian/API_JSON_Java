package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class getCityWeather {

    private String url="";
    private HttpURLConnection conn = null;
    public String geturl() {
        return url;
    }

    public String getHttpRespone(String cityCode) throws IOException {
        String line = "";
        String httpResults = "";
        url=("http://www.weather.com.cn/data/cityinfo/" + cityCode + ".html");
        System.out.println("----------url:"+url);
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            DataOutputStream out = null;

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setUseCaches(true);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Charset", "utf-8");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("User-Agent","");

            System.out.println("getRequestMethod"+conn.getRequestMethod());

            // 建立实际的连接
            conn.connect();
            out = new DataOutputStream(conn.getOutputStream());
            out.flush();
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while ((line = reader.readLine()) != null) {
                httpResults = httpResults + line.toString();
            }
            reader.close();

            // 断开连接
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpResults;

    }

}