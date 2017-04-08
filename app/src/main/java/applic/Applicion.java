package applic;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 类的用途：
 * 时间:  2017/4/5  10:12
 * 姓名:  李照照
 */
public class Applicion extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(con);
    }
}
