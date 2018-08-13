import api.getValue;
import api.getCityWeather;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase {


    public String httpResult= null, weatherinfo= null, city=null,exp_city = null;
    public static String cityCode="";
    public static getCityWeather weather=new getCityWeather();

    @Test(groups = { "BaseCase"})
    public void getShenZhen_Succ() throws IOException {
        exp_city="深圳";
        cityCode="101280601";
        System.out.println("【正常用例】:获取"+exp_city+"天气成功!");
        httpResult=weather.getHttpRespone(cityCode);
        System.out.println("请求地址: "+weather.geturl());
        System.out.println("返回结果: "+httpResult);
        weatherinfo=getValue.getJsonValue(httpResult, "weatherinfo");
        city=getValue.getJsonValue(weatherinfo, "city");
        System.out.println("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city);
    }

    @Test(groups = { "BaseCase"})
    public void getBeiJing_Succ() throws IOException{
        exp_city="北京";
        cityCode="101010100";
        Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
        httpResult=weather.getHttpRespone(cityCode);
        Reporter.log("请求地址: "+weather.geturl());
        Reporter.log("返回结果: "+httpResult);
        weatherinfo=getValue.getJsonValue(httpResult, "weatherinfo");
        city=getValue.getJsonValue(weatherinfo, "city");
        Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city);
    }

    @Test(groups = { "BaseCase"})
    public void getShangHai_Succ() throws IOException{
        exp_city="上海";
        cityCode="101020100";
        Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
        httpResult=weather.getHttpRespone(cityCode);
        Reporter.log("请求地址: "+weather.geturl());
        Reporter.log("返回结果: "+httpResult);
        weatherinfo=getValue.getJsonValue(httpResult, "weatherinfo");
        city=getValue.getJsonValue(weatherinfo, "city");
        Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city);
    }
}
