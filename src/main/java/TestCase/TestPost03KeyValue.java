package TestCase;

import BaseUtil.Post03KeyValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPost03KeyValue {

    @Test
     public void TestPost03KeyValue()   {

        Post03KeyValue test = new Post03KeyValue();
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("mobileNo", "18962873440");
        NameValuePair nameValuePair2 = new BasicNameValuePair("maskMobile", "18962873440");
        NameValuePair nameValuePair3 = new BasicNameValuePair("maskMobileIndex", "");
        NameValuePair nameValuePair5 = new BasicNameValuePair("picCode", "");
        NameValuePair nameValuePair4 = new BasicNameValuePair("decSign", "585DE3D0FDF23039A9A2B12E024B85513F387B192856B6F5F28EBF2D88839E9F8F46788226A69B15BB468941DFBD390671B645B85233D429C7440C30777404CA64E768786D8D239DAD2DBD2F3FBAEA8170A92354233A1B232260F44B20FF179D72512BA472893B39EB92F76D92AB599172CB1771889C387FA8D1C09DC07B189D");
        param.add(nameValuePair);
        param.add(nameValuePair2);
        param.add(nameValuePair3);
        param.add(nameValuePair4);
        param.add(nameValuePair5);
        String httpResults = null;
        try {
            httpResults = test.request("POST", "https://c.pingan.com/ca/apply/generateOTP", param);
            JSONObject jsonObject = new JSONObject(httpResults);
            String responseCode = jsonObject.getString("responseCode");
            String responseMsg = jsonObject.getString("responseMsg");
            System.out.println(responseCode);
            System.out.println(responseMsg);

            Assert.assertEquals(responseCode,"3041");
            Assert.assertEquals(responseMsg,"60秒内无法重复发送短信验证码(错误码:3041)");

            //httpResults = httpResults.replaceAll("\"", "'");//为什么要将双引号转义为单引号
            //System.out.println(httpResults + '\n');
            //System.out.println("httpResults.getClass().toString()---" + httpResults.getClass().toString()+ '\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("That's all. Thank you.");
        }
    }
}
