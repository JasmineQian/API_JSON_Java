package TestCase;

import BaseUtil.httpGetValueDemo;

import java.io.IOException;

public class TestHttpGetValue {

    public  static void main(String args[]){

        httpGetValueDemo get2 = new httpGetValueDemo();
        String httpResults2= null;
        try {
            httpResults2 = get2.requesteasy("GET","http://t.weather.sojson.com/api/weather/city","101030100");
            System.out.println("----------: "+httpResults2+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("That's all. Thank you.");
        }


    }

}
