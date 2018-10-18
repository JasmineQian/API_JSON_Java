package TestCase;

import BaseUtil.httpKeyValueDemo;
import BaseUtil.httpPostKeyValueDemo;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHttpPostKeyValue2 {

    public static void main(String args[]) {

        httpPostKeyValueDemo postKeyValueDemo = new httpPostKeyValueDemo();
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("name", "宜家用户");
        NameValuePair nameValuePair2 = new BasicNameValuePair("mobile", "10011123562");
        NameValuePair nameValuePair3 = new BasicNameValuePair("signature", "0FA9A3869F9855954889A65682DB1DDB");
        param.add(nameValuePair);
        param.add(nameValuePair2);
        param.add(nameValuePair3);
        String httpResults = null;
        try {
            httpResults = postKeyValueDemo.request("POST", "https://ydddde/getCustomerAddress", param);
            System.out.println(httpResults + '\n');
            httpResults = httpResults.replaceAll("\"", "'");//为什么要将双引号转义为单引号
            System.out.println(httpResults + '\n');
            System.out.println("httpResults.getClass().toString()---" + httpResults.getClass().toString()+ '\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("That's all. Thank you.");
        }


    }
}
