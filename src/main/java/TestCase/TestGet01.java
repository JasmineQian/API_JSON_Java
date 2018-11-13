package TestCase;

import BaseUtil.Get01Value;

import java.io.IOException;

public class TestGet01 {

    public  static void main(String args[]){

        Get01Value get = new Get01Value();
        String httpResults= null;
        try {
            httpResults = get.request("GET","http://t.weather.sojson.com/api/weather/city","101030100");
            System.out.println("----------: "+httpResults+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("That's all. Thank you.");
        }
    }
}
