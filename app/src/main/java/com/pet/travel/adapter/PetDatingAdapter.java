package com.pet.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pet.travel.R;
import com.pet.travel.bean.PetDatingBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.ImageLoaderOptions;
import com.pet.travel.view.imageview.RoundAngleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class PetDatingAdapter extends BaseAdapter {

    private Context mContext;
    private List<PetDatingBean> datas = new ArrayList<>();
    private final int MAX_HEIGHT = 200;

    public PetDatingAdapter(Context context) {
        this.mContext = context;
    }

    public void addData(List<PetDatingBean> list) {
        if (list != null) {
            datas.addAll(list);
        }
    }

    public void setData(List<PetDatingBean> list) {
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
    public PetDatingBean getItem(int position) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_pet_dating, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PetDatingBean item = getItem(position);
        String photos = "";
        if (item != null) {
            viewHolder.tv_pet_type.setText(item.getType());
            viewHolder.tv_pet_name.setText(item.getName());
            viewHolder.tv_pet_age.setText(item.getAge()+"岁");
            String mSex = item.getSex();
            if (!TextUtils.isEmpty(mSex)) {
                if (mSex.equals("2"))
                    mSex = "母";
                else
                    mSex = "公";
                viewHolder.tv_pet_sex.setText(mSex);
                viewHolder.tv_pet_sex.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tv_pet_sex.setVisibility(View.INVISIBLE);
            }
            viewHolder.tv_pet_desc.setText(item.getDescription());
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
        ImageLoader.getInstance().displayImage(photos, viewHolder.iv_header, ImageLoaderOptions.optionsAdapterDefault);
        return convertView;
    }

    private class ViewHolder {
        public RoundAngleImageView iv_header;
        public TextView tv_pet_type, tv_pet_name, tv_pet_age, tv_pet_sex, tv_pet_desc;

        public ViewHolder(View view) {
            this.iv_header = (RoundAngleImageView) view.findViewById(R.id.iv_header);
            this.tv_pet_type = (TextView) view.findViewById(R.id.tv_pet_type);
            this.tv_pet_name = (TextView) view.findViewById(R.id.tv_pet_name);
            this.tv_pet_age = (TextView) view.findViewById(R.id.tv_pet_age);
            this.tv_pet_sex = (TextView) view.findViewById(R.id.tv_pet_sex);
            this.tv_pet_desc = (TextView) view.findViewById(R.id.tv_pet_desc);
        }
    }
}
