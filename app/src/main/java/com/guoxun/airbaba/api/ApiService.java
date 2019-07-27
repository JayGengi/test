package com.guoxun.airbaba.api;

import com.guoxun.airbaba.db.User;
import com.guoxun.airbaba.mvp.model.bean.AdListEntity;
import com.guoxun.airbaba.mvp.model.bean.CategoryEntity;
import com.guoxun.airbaba.mvp.model.bean.ShopListEntity;
import com.guoxun.airbaba.net.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    /**
     *  首页-厂家直销（商铺列表）
     */
    @GET("Index/shopList")
    Observable<ShopListEntity> getShopListInfo(@Query("page") int page);

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("Login/login")
    Observable<BaseResponse<User>> getLoginInfo(@FieldMap Map<String, Object> map);

    /**
     * 发送验证码
     */
    @FormUrlEncoded
    @POST("Login/sendLine")
    Observable<BaseResponse<String>> getSendLineInfo(@FieldMap Map<String, Object> map);

    /**
     *  商品分类：第一级分类
     */
    @GET("Goods/categoryList")
    Observable<CategoryEntity> getCategoryInfo();

    /**
     *  广告列表
     */
    @GET("Index/adList")
    Observable<AdListEntity> getAdListInfo(@Query("types") String types,@Query("pid") String pid);
}