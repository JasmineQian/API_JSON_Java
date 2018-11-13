package BaseUtil;

import org.apache.http.NameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class Post04JsonKeyValue {

    private static final int READ_TIMEOUT = 100000;
    private static final int CONNECT_TIMEOUT = 150000;
    public static final String POST = "POST";
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

        this.url = new URL(url);
        System.out.println("-----------"+url.toString());
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
        result.append('{');
        System.out.println("-----------result: "+result.toString());
        boolean first = true;

        for (NameValuePair pair : params){

            if (first){
                first = false;
            } else {
                result.append(",");
            }
            result.append("\"");
            result.append(URLEncoder.encode(pair.getName(),"UTF-8"));
            result.append("\"");
            result.append(":");
            result.append("\"");
            //result.append(URLEncoder.encode(pair.getValue(),"UTF-8"));
            result.append(pair.getValue());
            result.append("\"");
        }
        result.append('}');
        System.out.println(getClass().toString());
        System.out.println("-----------getQuery: "+result.toString());
        return result.toString();
    }

}

