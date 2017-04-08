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
public class Fragment3 extends Fragment{
    private List<Bean.DataBean> list;
    private View view;
    private ListView list03;
    private Handler handler=new Handler(){
        private List<Bean.DataBean> list;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                String str=(String) msg.obj;
                Bean bean = Gsons.addBean(str, Bean.class);
                list = bean.getData();
                Myadapt myadapt=   new Myadapt(getActivity(),list);
                list03.setAdapter(myadapt);

                //list01条目做监听
                list03.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

        view = inflater.inflate(R.layout.item3,null);

        initView();
        return view;
    }

    private void initView() {
        list03 = (ListView) view.findViewById(R.id.list03);
        new Https(Url.url03,handler).getAdd();
    }
}
