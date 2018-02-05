package com.pet.travel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.pet.travel.R;
import com.pet.travel.bean.CircleBean;
import com.pet.travel.bean.UrlDrawableBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.DisplayUtil;
import com.pet.travel.util.ImageLoaderOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class LoadImagesAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> datas = new ArrayList<>();
    private String mInages = "";
    private CircleBean circleBean = null;
    private Map<Integer, UrlDrawableBean> mUrlDrawableMap = new HashMap<>();

    public LoadImagesAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list) {
        datas.clear();
        mInages = "";
        if (list != null) {
            datas.addAll(list);
            for (String s : list)
                mInages += s + ",";
        }
    }

    public void setDataCircleBean(CircleBean bean) {
        mInages = "";
        datas.clear();
        circleBean = bean;
        if (bean == null)
            return;
        String thumbs = bean.getThumbs();
        String photos = bean.getPhotos();
        if (TextUtils.isEmpty(thumbs))
            thumbs = photos;
        if (!TextUtils.isEmpty(thumbs)) {
            String[] t = thumbs.split(",");
            for (String s : t) {
                mInages += s + ",";
                datas.add(s);
            }
        }
        if (!TextUtils.isEmpty(photos)) {
            String[] p = photos.split(",");
            for (int i = 0; i < p.length; i++) {
                UrlDrawableBean urlDrawableBean = new UrlDrawableBean();
                urlDrawableBean.setPosition(i);
                urlDrawableBean.setFilePath(p[i]);
                mUrlDrawableMap.put(i, urlDrawableBean);
            }
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_load_image_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String content = getItem(position);
        if (!TextUtils.isEmpty(content)) {
            content = content.trim();
            if (!content.startsWith("http://"))
                content = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, content);
        }
        ImageLoader.getInstance().displayImage(content, viewHolder.imageView, ImageLoaderOptions.optionsItemDefault, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                UrlDrawableBean bean = mUrlDrawableMap.get(position);
                if (bean.getDrawable() == null) {
                    Drawable drawable = new BitmapDrawable(bitmap);
                    bean.setDrawable(drawable);
                }
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
        final String finalUrl = content;
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }

    private class ViewHolder {
        public ImageView imageView;

        public ViewHolder(View view) {
            this.imageView = (ImageView) view.findViewById(R.id.iv_icon);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.imageView.getLayoutParams();
            params.height = DisplayUtil.screenWidth / 3;
        }
    }
}
