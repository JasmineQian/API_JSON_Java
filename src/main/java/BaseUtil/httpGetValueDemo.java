package BaseUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpGetValueDemo {


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

    public String requesteasy(String method, String url, String code) throws IOException {

        if (code != null && method == GET) {
            url = url.concat("/");
            url = url.concat(code);
            System.out.println("url is: "+url);
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
        conn.setRequestProperty("Cookie","slbcardapplynginx=d42e3d65735ab87f08824497f969fb1b");

        if (code != null && method == POST) {
            os = conn.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
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
        System.out.println(httpResults);

        return httpResults;
    }
}
