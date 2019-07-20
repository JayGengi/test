package com.guoxun.airbaba.utils;

import android.content.Context;
import android.widget.ImageView;

import com.guoxun.airbaba.R;
import com.guoxun.airbaba.utils.glide.GlideUtils;
import com.youth.banner.loader.ImageLoader;


/**
 * 描述：
 *
 * @author jayGengi
 * @date 2018/4/23
 */
public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        //Glide 加载图片简单用法
//        Glide.with(context).load(path).into(imageView);
        GlideUtils.showImageView(context, R.mipmap.ic_error, (String) path,imageView);
    }

}