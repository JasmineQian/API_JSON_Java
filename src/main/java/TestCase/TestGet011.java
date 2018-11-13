package TestCase;

import BaseUtil.Get01Value;

import java.io.IOException;

public class TestGet011 {


    public  static void main(String args[]){

        Get01Value get = new Get01Value();
        String httpResults= null;
        try {
            httpResults = get.request("GET","http://www.weather.com.cn/data/cityinfo","101280601.html");
            System.out.println("----------: "+httpResults+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("That's all. Thank you.");
        }


    }

}

