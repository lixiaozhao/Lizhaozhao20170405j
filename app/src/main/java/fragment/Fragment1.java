package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwie.test.R;
import com.bwie.test.SecondActivity;

import java.util.List;

import adapter.Myadapt;
import beans.Bean;
import gsonUtils.Gsons;
import httpUtils.Https;
import httpUtils.Url;

/**
 * 类的用途：
 * 时间:  2017/4/5  9:20
 * 姓名:  李照照
 */
public class Fragment1 extends Fragment{

    private View view;
    private ListView list01;
    private List<Bean.DataBean> list;
   private Handler handler=new Handler(){
       private List<Bean.DataBean> list;

       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if (msg.what==1){
              String str=(String) msg.obj;
               Bean bean = Gsons.addBean(str, Bean.class);
               //得到集合
               list = bean.getData();
               //适配器
             Myadapt myadapt=   new Myadapt(getActivity(),list);
               list01.setAdapter(myadapt);

               //list01条目做监听
               list01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                      //点击条目跳转
                       Intent intent=new Intent(getActivity(), SecondActivity.class);
                       //传新闻标题
                       intent.putExtra("user",list.get(i).getFROMNAME()+"");

                       getActivity().startActivity(intent);
                   }
               });
           }

       }
   };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.item1,null);









        initView();
        return view;
    }

    private void initView() {
        list01 = (ListView) view.findViewById(R.id.list01);
        new Https(Url.url01,handler).getAdd();

    }
}
