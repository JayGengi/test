package com.guoxun.airbaba.ui.activity.home.goods

import android.graphics.drawable.ColorDrawable
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import com.guoxun.airbaba.setBackgroundAlpha
import com.guoxun.airbaba.ui.adapter.HomePageAdapter
import com.guoxun.airbaba.ui.fragment.goods.GoodsCommentFragment
import com.guoxun.airbaba.ui.fragment.goods.GoodsDetailFragment
import com.guoxun.airbaba.ui.fragment.goods.GoodsInfoFragment
import kotlinx.android.synthetic.main.activity_free_design.*
import kotlinx.android.synthetic.main.activity_goods_details.*
import java.util.*

/**
  * 免费设计
  * @auther JayGengi
  * 2019/7/19 0019 上午 11:09
  * @email jaygengiii@gmail.com
  */
class GoodsDetailsActivity : BaseActivity(),View.OnClickListener{

    private val titles = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()
    override fun layoutId(): Int {
        return R.layout.activity_goods_details
    }

    override fun initView() {
        mLayoutStatusView = multipleStatusView

        fragments.add(GoodsInfoFragment())
        fragments.add(GoodsCommentFragment())
        fragments.add(GoodsDetailFragment())
        titles.add("商品")
        titles.add("评价")
        titles.add("详情")
        viewpager.adapter = HomePageAdapter(supportFragmentManager).apply {
            setData(fragments, titles)
        }
        viewpager.offscreenPageLimit = titles.size
        //底部横线与字体宽度一致
        sliding_tabs.setViewPager(viewpager)

        add_shop_car.setOnClickListener(this)
        buy.setOnClickListener(this)
    }

    override fun start() {
        initData()
    }
    override fun initData() {

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.add_shop_car ->{
                openPop()
            }
            R.id.buy ->{
                openPop()
            }
        }
    }


    /** 弹出底部对话框 */
    private fun openPop(){
        val popView : View = LayoutInflater . from (this).inflate(
                R.layout.window_goods_buy_or_add, null)
        val rootView :View  = popView.findViewById (R.id.goods_bottom) // 當前頁面的根佈局
        val cancel : ImageView = popView.findViewById (R.id.cancel)
        val popupWindow  = PopupWindow (popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setBackgroundAlpha(this,0.5f)//设置屏幕透明度
        popupWindow.setBackgroundDrawable(ColorDrawable())
        popupWindow.isFocusable = true// 点击空白处时，隐藏掉pop窗口
        // 顯示在根佈局的底部
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM , 0,0)
        popupWindow.setOnDismissListener {
            // popupWindow隐藏时恢复屏幕正常透明度
            setBackgroundAlpha(this,1f)//设置屏幕透明度
        }
        cancel.setOnClickListener {
            popupWindow.dismiss()
        }
    }
}
