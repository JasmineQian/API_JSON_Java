package TestCase;

import BaseUtil.Get02KeyValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestGet02KeyValue {

    public static void main(String args[]) {

        Get02KeyValue get = new Get02KeyValue();
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("phone", "18962873440");
        param.add(nameValuePair);
        String httpResults = null;
        try {
            httpResults = get.request("GET", "https://pintuan.msparis.com/Api/God/getCode", param);
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
