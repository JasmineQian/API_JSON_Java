package api;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class getResponse {

    private static final int READ_TIMEOUT = 100000;
    private static final int CONNECT_TIMEOUT = 150000;
    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String HEAD = "HEAD";
    private URL url = null;
    private HttpURLConnection conn = null;
    private OutputStream os = null;
    private BufferedWriter writer = null;
    private InputStream is = null;
    private int responseCode = 0;
    private String reponseMessage = null;
    String line = "";
    String httpResults = "";

    public String request(String method, String url, List<NameValuePair> params) throws IOException {

        if (params != null && method == GET) {
            url = url.concat("?");
            url = url.concat(getQuery(params));
            System.out.println("-----------"+url.toString());
        }

        this.url = new URL(url);
        //HttpURLConnection conn = this.url.openConnection();
        conn = (HttpURLConnection) this.url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Charset", "utf-8");
        conn.setRequestProperty("Accept-Charset", "utf-8");
        conn.setRequestProperty("User-Agent","");
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        if (params != null && method == POST) {
            os = conn.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            os.close();
        }

        conn.connect();
        responseCode = conn.getResponseCode();
        reponseMessage = conn.getResponseMessage();

        System.out.println("-----------responseCode:"+responseCode);
        System.out.println("-----------reponseMessage:"+reponseMessage);
        System.out.println("-----------getRequestMethod:"+conn.getRequestMethod());


        /*
    Exception in thread "main" java.net.ProtocolException: Cannot write output after reading input.
	at sun.net.www.protocol.http.HttpURLConnection.getOutputStream0(HttpURLConnection.java:1330)
	at sun.net.www.protocol.http.HttpURLConnection.getOutputStream(HttpURLConnection.java:1309)
	at api.getResponse.request(getResponse.java:64)
	at api.getResponse.main(getResponse.java:112)
         */

        //System.out.println("-----------getInputStream"+conn.getInputStream());
        //System.out.println("-----------getOutputStream"+conn.getOutputStream());
        InputStreamReader streamReader =new InputStreamReader(conn.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);
        while ((line = reader.readLine()) != null) {
            httpResults = httpResults + line.toString();
        }
        System.out.println("-----------httpResults:"+httpResults);

        return httpResults;
    }



    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params){

            if (first){
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.getName(),"UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(),"UTF-8"));
        }
        System.out.println(getClass().toString());
        System.out.println("-----------getQuery"+result.toString());
        return result.toString();
    }


    public static void main(String args[]) throws IOException {





    }
}
