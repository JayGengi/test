package com.guoxun.airbaba.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import com.guoxun.airbaba.R
import com.guoxun.airbaba.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


/**
   * @description: 启动页
   * @author JayGengi
   * @date  2018/10/29 0029 上午 11:56
   * @email jaygengiii@gmail.com
   */

class SplashActivity : BaseActivity() {


    private var alphaAnimation:AlphaAnimation?=null


    override fun layoutId(): Int = R.layout.activity_splash

    override fun initData() {

    }

    @SuppressLint("SetTextI18n")
    override fun initView() {

        //渐变展示启动屏
        alphaAnimation= AlphaAnimation(0.3f, 1.0f)
        alphaAnimation?.duration = 2000
        alphaAnimation?.setAnimationListener(object : AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                redirectTo()
            }
            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationStart(animation: Animation) {}

        })
//        tv_version_name.text = "v${AppUtils.getVerName(MyApplication.context)}"
        if (alphaAnimation != null) {
            iv_web_icon.startAnimation(alphaAnimation)
        }
    }
    override fun start() {

    }

    fun redirectTo() {
        Log.d("JayGengi","JayGengi")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}