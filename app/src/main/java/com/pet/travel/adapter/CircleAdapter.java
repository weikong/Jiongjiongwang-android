package com.pet.travel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.pet.travel.R;
import com.pet.travel.bean.CircleBean;
import com.pet.travel.config.ServerConfig;
import com.pet.travel.util.DisplayUtil;
import com.pet.travel.util.ImageLoaderOptions;
import com.pet.travel.view.CustomGridView;

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
//            if (!TextUtils.isEmpty(photos)) {
//                String url = photos.split(",")[0];
//                if (!TextUtils.isEmpty(url)) {
//                    url = url.trim();
//                    if (!url.startsWith("http://"))
//                        photos = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
//                    else
//                        photos = url;
//                }
//            }
            showImagesData(item, photos, viewHolder.ivContent, viewHolder.gridView, viewHolder.adapter);
//            ImageLoader.getInstance().displayImage(photos, viewHolder.ivContent, ImageLoaderOptions.optionsAdapterDefault);

        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView ivHeader;
        public TextView tvName;
        public TextView tvTime;
        public TextView tvDesc;
        public TextView tvAddress;
        public RelativeLayout layout_imgs;
        public ImageView ivContent;
        public CustomGridView gridView;
        public LoadImagesAdapter adapter;

        public ViewHolder(View view) {
            this.ivHeader = (ImageView) view.findViewById(R.id.iv_header_icon);
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvTime = (TextView) view.findViewById(R.id.tv_time);
            this.tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            this.tvAddress = (TextView) view.findViewById(R.id.tv_address);
            this.layout_imgs = (RelativeLayout) view.findViewById(R.id.layout_imgs);
            this.ivContent = (ImageView) view.findViewById(R.id.iv_content);
            this.gridView = (CustomGridView) view.findViewById(R.id.gridview);
            adapter = new LoadImagesAdapter(view.getContext());
            gridView.setAdapter(adapter);
        }
    }

    public void showImagesData(CircleBean circleBean, String urls, final ImageView imageView, CustomGridView gridView, LoadImagesAdapter adapter) {
        if (TextUtils.isEmpty(urls)) {
            imageView.setVisibility(View.GONE);
            gridView.setVisibility(View.GONE);
            return;
        }
        String[] list = urls.split(",");
        if (list.length == 1) {
            imageView.setVisibility(View.VISIBLE);
            gridView.setVisibility(View.GONE);
            String url = list[0];
            if (!TextUtils.isEmpty(url)) {
                url = url.trim();
                if (!url.startsWith("http://"))
                    url = String.format(ServerConfig.HTTP_DOWNLOAD_FILE_2, url);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            ImageLoader.getInstance().displayImage(url, imageView, ImageLoaderOptions.optionsItemDefault, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {

                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    if (bitmap == null)
                        return;
                    int w = bitmap.getWidth();
                    int h = bitmap.getHeight();
                    if (w == 0 || h == 0)
                        return;
                    int maxHeight = DisplayUtil.dp2px(MAX_HEIGHT);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    int viewWidth = DisplayUtil.screenWidth - DisplayUtil.dp2px(8);
                    int viewHeight = viewWidth * h / w;
                    if (viewHeight > maxHeight) {
                        params.height = maxHeight;
                        params.width = params.height * w / h;
                    } else {
                        params.width = viewWidth;
                        params.height = viewHeight;
                    }
                }

                @Override
                public void onLoadingCancelled(String s, View view) {

                }
            });
        } else if (list.length > 1) {
            imageView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            adapter.setDataCircleBean(circleBean);
            adapter.notifyDataSetChanged();
        }
    }
}
