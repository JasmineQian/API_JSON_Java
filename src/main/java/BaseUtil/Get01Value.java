package BaseUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get01Value {


    private static final int READ_TIMEOUT = 100000;
    private static final int CONNECT_TIMEOUT = 150000;
    public static final String GET = "GET";
    private URL url = null;
    private HttpURLConnection conn = null;
    private OutputStream os = null;
    private BufferedWriter writer = null;
    private InputStream is = null;
    private int responseCode = 0;
    private String reponseMessage = null;
    String line = "";
    String httpResults = "";

    public String request(String method, String url, String code) throws IOException {

        if (code != null && method == GET) {
            url = url.concat("/");
            url = url.concat(code);
            System.out.println("url is: "+url);
        }

        this.url = new URL(url);
        //HttpURLConnection conn = this.url.openConnection();
        conn = (HttpURLConnection) this.url.openConnection();
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);

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
}
