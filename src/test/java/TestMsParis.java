import api.getValue;
import api.getResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMsParis {


    public String httpResult= null;
    public static String mobile="";



    @Test
    public void getHttp() throws IOException {




        List<NameValuePair> param =new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("platform", "wap");
        param.add(nameValuePair);

        NameValuePair nameValuePair1 = new BasicNameValuePair("mobile","18962873440");
        param.add(nameValuePair1);


        getResponse get = new getResponse();
        get.request("GET", "http://api.v2.msparis.com/common/sms", param);



        }


    @Test
    public void getServer() throws IOException {

        String httpResult= null, city=null,exp_city = null;
        String cityCode="";

        List<NameValuePair> param = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("platform", "wap");
        param.add(nameValuePair);

        NameValuePair nameValuePair1 = new BasicNameValuePair("mobile", "18962873440");
        param.add(nameValuePair1);
        getResponse weather = new getResponse();
        httpResult =weather.request("GET", "http://www.weather.com.cn/data/cityinfo/101280601.html", param);

        exp_city="深圳";
        cityCode="101280601";
        System.out.println("请求地址: "+weather.getClass());
        System.out.println("返回结果: "+httpResult);
        String weatherinfo=getValue.getJsonValue(httpResult, "weatherinfo");
        System.out.println("weatherinfo: "+weatherinfo);
        city=getValue.getJsonValue(weatherinfo,"city");
        System.out.println("city: "+weatherinfo);
        System.out.println("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city);

    }


    @Test
    public void getHttps() throws IOException {

            getResponse get3 = new getResponse();
            List<NameValuePair> param3 =new ArrayList<NameValuePair>();
            NameValuePair nameValuePair3 = new BasicNameValuePair("phone", "18962873440");
            param3.add(nameValuePair3);
            get3.request("GET", "https://pintuan.msparis.com/Api/God/getCode", param3);
        }

}
