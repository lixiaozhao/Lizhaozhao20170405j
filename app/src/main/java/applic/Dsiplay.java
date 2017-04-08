package applic;

import com.bwie.test.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * 类的用途：
 * 时间:  2017/4/5  10:14
 * 姓名:  李照照
 */
public class Dsiplay {
    public  static DisplayImageOptions options(){
        DisplayImageOptions dio=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher).build();
        return  dio;
    }
}
