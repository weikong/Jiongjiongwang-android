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
import com.pet.travel.bean.PetServiceBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.ImageLoaderOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinzhendi-031 on 2016/12/14.
 */
public class PetBeautyAdapter extends BaseAdapter {

    private Context mContext;
    private List<PetServiceBean> datas = new ArrayList<>();
    private final int MAX_HEIGHT = 200;

    public PetBeautyAdapter(Context context) {
        this.mContext = context;
    }

    public void addData(List<PetServiceBean> list) {
        if (list != null) {
            datas.addAll(list);
        }
    }

    public void setData(List<PetServiceBean> list) {
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
    public PetServiceBean getItem(int position) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_pet_beauty, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PetServiceBean item = getItem(position);
        String photos = "";
        if (item != null) {
            viewHolder.tvTitle.setText(item.getName());
            if (!TextUtils.isEmpty(item.getThumb()))
                photos = item.getThumb();
            else
                photos = item.getPictures();
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
        ImageLoader.getInstance().displayImage(photos, viewHolder.ivContent, ImageLoaderOptions.optionsAdapterDefault);
//        ImageLoader.getInstance().displayImage(photos, viewHolder.ivContent, ImageLoaderOptions.optionsAdapterDefault, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String s, View view) {
//
//            }
//
//            @Override
//            public void onLoadingFailed(String s, View view, FailReason failReason) {
//
//            }
//
//            @Override
//            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
//                if (bitmap == null)
//                    return;
//                int width = bitmap.getWidth();
//                int height = bitmap.getHeight();
//                int bWidth = DisplayUtil.screenWidth - DisplayUtil.dp2px(2 * 12);
//                int bHeight = bWidth * height / width;
//                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                params.width = bWidth;
//                params.height = bHeight;
//            }
//
//            @Override
//            public void onLoadingCancelled(String s, View view) {
//
//            }
//        });
        return convertView;
    }

    private class ViewHolder {
        public ImageView ivContent;
        public TextView tvTitle;

        public ViewHolder(View view) {
            this.ivContent = (ImageView) view.findViewById(R.id.iv_content);
            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        }
    }
}
