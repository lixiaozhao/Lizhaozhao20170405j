package httpUtils;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 类的用途：
 * 时间:  2017/4/5  9:26
 * 姓名:  李照照
 */
public class Https extends Thread {
    public  String  url;
    public Handler handler;

    public Https(String url, Handler handler) {
        this.url = url;
        this.handler = handler;
    }

    private HttpURLConnection connection;
   public void  getAdd(){
       new Thread(new Runnable() {
           @Override
           public void run() {
              String str= getData(url);
               if (str!=null){
                   Message message=Message.obtain();
                   message.what=1;
                   message.obj=str;
                   handler.sendMessage(message);
               }
           }
       }).start();
   }
    public String getData(String url) {
        try {
            URL url1 = new URL(url);
            try {
                connection = (HttpURLConnection) url1.openConnection();
                //设置读取时间
                connection.setReadTimeout(5000);
                //设置连接超时
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("POST");
                if (connection.getResponseCode() == 200) {
                    InputStream stream = connection.getInputStream();
                    StringBuilder ss = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(stream, "utf-8"));
                    String con="";
                    while ((con=br.readLine())!=null){
                        ss.append(con);
                    }
                    return  ss.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                connection.disconnect();
            }
        }
        return null;
    }
}
