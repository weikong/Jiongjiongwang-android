package com.pet.travel.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.pet.travel.util.DisplayUtil;
import com.pet.travel.util.ImageLoaderOptions;


/**
 * Created by kongwei on 2017/2/16.
 */

public class App extends Application {

    private static final java.lang.String TAG = "App";
    public static App instance = null;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DisplayUtil.displayScreen(this);
        initImageLoader(this);
    }

    public static void initImageLoader(Context context) {
        int maxMemory = 0;
        int maxImageMemoryCacheSize = (maxMemory == 0) ? ImageLoaderOptions.MAX_IMAGE_DISK_CACHE_SIZE : (maxMemory / 8);
//		File cacheDir = StorageUtils.getOwnCacheDirectory(appContext, "Melinked/imageloader/Cache");
// 				.diskCache(new UnlimitedDiskCache(cacheDir)) //自定义缓存路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).memoryCache(new LruMemoryCache(maxImageMemoryCacheSize))
                .memoryCacheExtraOptions(ImageLoaderOptions.MAX_IMAGE_WIDTH, ImageLoaderOptions.MAX_IMAGE_HEIGHT)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
//				.diskCacheSize(ImageLoaderOptions.MAX_IMAGE_DISK_CACHE_SIZE)//缓存的文件占sdcard大小
//				.diskCacheFileCount(ImageLoaderOptions.MAX_IMAGE_DISK_FILE_COUNT)//缓存的文件数量
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO) //LIFO:后进先出 --  FIFO:先入先出
                .build();

        ImageLoader.getInstance().init(config);
    }
}
