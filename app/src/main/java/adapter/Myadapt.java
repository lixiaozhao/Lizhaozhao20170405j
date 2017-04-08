package adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import applic.Dsiplay;
import beans.Bean;

/**
 * 类的用途：
 * 时间:  2017/4/5  10:04
 * 姓名:  李照照
 */
public class Myadapt extends BaseAdapter{

    public Context context;
    public List<Bean.DataBean> list;
    public Myadapt(Context context, List<Bean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;
        if (view==null){
            view=View.inflate(context, R.layout.login,null);
            holder=new ViewHolder();
            holder.image01= (ImageView) view.findViewById(R.id.image01);
            holder.text01= (TextView) view.findViewById(R.id.text01);
            holder.text02= (TextView) view.findViewById(R.id.text02);
            holder.text03= (TextView) view.findViewById(R.id.text03);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        ImageLoader.getInstance().displayImage(list.get(i).getIMAGEURL(),holder.image01, Dsiplay.options());
        holder.text01.setText(list.get(i).getFROMNAME());
        holder.text02.setText(list.get(i).getSUBTITLE());
        holder.text03.setText(list.get(i).getSHOWTIME());
        return view;
    }

    class  ViewHolder{
        ImageView image01;
        TextView text01;
        TextView text02;
        TextView text03;

    }
}
