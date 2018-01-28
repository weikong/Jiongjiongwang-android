package com.pet.travel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pet.travel.R;
import com.pet.travel.bean.CircleBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.ImageLoaderOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class CircleAdapter extends BaseAdapter {

    private Context mContext;
    private List<CircleBean> datas = new ArrayList<>();
    private final int MAX_HEIGHT = 200;

    public CircleAdapter(Context context) {
        this.mContext = context;
    }

    public void addData(List<CircleBean> list) {
        if (list != null) {
            datas.addAll(list);
        }
    }

    public void setData(List<CircleBean> list) {
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
    public CircleBean getItem(int position) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_circle_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CircleBean item = getItem(position);
        if (item != null) {
            viewHolder.tvName.setText(item.getAccount());
            viewHolder.tvTime.setText(item.getCreateTime() == null ? "" : item.getCreateTime().toLocaleString());
            viewHolder.tvDesc.setText(item.getDescription());
            if (!TextUtils.isEmpty(item.getAddress())) {
                viewHolder.tvAddress.setVisibility(View.VISIBLE);
                viewHolder.tvAddress.setText(item.getAddress());
            } else
                viewHolder.tvAddress.setVisibility(View.GONE);
            ImageLoader.getInstance().displayImage("", viewHolder.ivHeader, ImageLoaderOptions.optionsLanuchHeader);

            String photos = "";
            if (!TextUtils.isEmpty(item.getThumbs()))
                photos = item.getThumbs();
            else
                photos = item.getPhotos();
            if (!TextUtils.isEmpty(photos)) {
                String url = photos.split(",")[0];
                if (!TextUtils.isEmpty(url)) {
                    url = url.trim();
                    if (!url.startsWith("http://"))
                        photos = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
                }
            }
            ImageLoader.getInstance().displayImage(photos, viewHolder.ivContent, ImageLoaderOptions.optionsAdapterDefault);

        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView ivHeader;
        public TextView tvName;
        public TextView tvTime;
        public TextView tvDesc;
        public TextView tvAddress;
        public LinearLayout layout_imgs;
        public ImageView ivContent;

        public ViewHolder(View view) {
            this.ivHeader = (ImageView) view.findViewById(R.id.iv_header_icon);
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvTime = (TextView) view.findViewById(R.id.tv_time);
            this.tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            this.tvAddress = (TextView) view.findViewById(R.id.tv_address);
            this.layout_imgs = (LinearLayout) view.findViewById(R.id.layout_imgs);
            this.ivContent = (ImageView) view.findViewById(R.id.iv_content);
        }
    }
}
