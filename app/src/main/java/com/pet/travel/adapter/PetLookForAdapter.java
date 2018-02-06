package com.pet.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pet.travel.R;
import com.pet.travel.bean.PetLookforBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.ImageLoaderOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class PetLookForAdapter extends BaseAdapter {

    private Context mContext;
    private List<PetLookforBean> datas = new ArrayList<>();
    private final int MAX_HEIGHT = 200;

    public PetLookForAdapter(Context context) {
        this.mContext = context;
    }

    public void addData(List<PetLookforBean> list) {
        if (list != null) {
            datas.addAll(list);
        }
    }

    public void setData(List<PetLookforBean> list) {
        datas.clear();
        if (list != null) {
            datas.addAll(list);
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public PetLookforBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_pet_lookfor, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PetLookforBean item = getItem(position);
        String photos = "";
        if (item != null) {
            viewHolder.tv_type.setText("种类："+item.getType());
            String mInfo = "名字："+item.getName();
            float mAge = item.getAge();
            String mSex = item.getSex();//((item.getSex() == 2) ? "母" : "公");
            if (!TextUtils.isEmpty(mSex) && mAge > 0){
                if (mSex.equals("2"))
                    mSex = "母";
                else
                    mSex = "公";
                viewHolder.tv_name.setText("名字："+item.getName()+"("+mSex+"-"+item.getAge()+"岁"+")");
            } else if (!TextUtils.isEmpty(mSex) && mAge <= 0){
                if (mSex.equals("2"))
                    mSex = "母";
                else
                    mSex = "公";
                viewHolder.tv_name.setText("名字："+item.getName()+"("+mSex+")");
            } else if (TextUtils.isEmpty(mSex) && mAge > 0){
                viewHolder.tv_name.setText("名字："+item.getName()+"("+item.getAge()+"岁"+")");
            } else {
                viewHolder.tv_name.setText("名字："+item.getName());
            }
            viewHolder.tv_address.setText("遗失地址："+item.getAddress());
            viewHolder.tv_time.setText(item.getTime().toLocaleString());
            if (!TextUtils.isEmpty(item.getHeadurl()))
                photos = item.getHeadurl();
            if (!TextUtils.isEmpty(photos)) {
                String url = photos.split(",")[0];
                if (!TextUtils.isEmpty(url)) {
                    url = url.trim();
                    if (!url.startsWith("http://"))
                        photos = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
                    else
                        photos = url;
                }
            }
        }
        ImageLoader.getInstance().displayImage(photos, viewHolder.ivContent, ImageLoaderOptions.optionsItemDefault);
        return convertView;
    }

    private class ViewHolder {
        public ImageView ivContent;
        public TextView tv_type,tv_name,tv_address,tv_time;

        public ViewHolder(View view) {
            this.ivContent = (ImageView) view.findViewById(R.id.iv_content);
            this.tv_type = (TextView) view.findViewById(R.id.tv_type);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.tv_address = (TextView) view.findViewById(R.id.tv_address);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
        }
    }
}
