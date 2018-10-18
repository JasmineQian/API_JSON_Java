package TestCase;

import BaseUtil.httpKeyValueDemo;
import BaseUtil.httpPostKeyValueDemo;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHttpPostKeyValue {

    public static void main(String args[]) {

        httpPostKeyValueDemo get = new httpPostKeyValueDemo();
        List<NameValuePair> param = new ArrayList<NameValuePair>();
        NameValuePair nameValuePair = new BasicNameValuePair("mobileNo", "18962873440");
        NameValuePair nameValuePair2 = new BasicNameValuePair("maskMobile", "18962873440");
        NameValuePair nameValuePair3 = new BasicNameValuePair("maskMobileIndex", "");
        //NameValuePair nameValuePair4 = new BasicNameValuePair("decSign", "");
        NameValuePair nameValuePair4 = new BasicNameValuePair("decSign", "CD90222BA98F7DBAEF924E93C95C8A75D7C68FA901A36CADD03EAE16710411A4CA89FCBF6F72853BFA7E8F45D23482C50D5A7A93D391D0A69255D63814FDEC23C87228251621BA602351DDA77E3C8D6FA0B2570C88B53952DBE9F7E54ABEDE178C3C8BF22F3342B3A70C75C5002214E9E2F8F4E647D27CF949DBF4E5DA442091");
        param.add(nameValuePair);
        param.add(nameValuePair2);
        param.add(nameValuePair3);
        param.add(nameValuePair4);
        String httpResults = null;
        try {
            httpResults = get.request("POST", "https://c.pingan.com/ca/apply/generateOTP", param);
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
