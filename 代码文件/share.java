package com.example.a1.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by 1 on 2017/4/12.
 */
public class share extends Activity {

     private Button shareshow;
     private Button backbtn;

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("小学生养成记");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我看完了“小学生养成记”的视频啦！~~快来和我一起看吧");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       // oks.setImagePath("手机存储/截屏/123.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是小学生养成记使用者");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        ShareSDK.initSDK(this);

        shareshow =(Button)findViewById(R.id.share_btn);
        shareshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
               Toast.makeText(getApplicationContext(),"请选择分享平台",Toast.LENGTH_SHORT).show();;
                showShare();
            }
        });

        final Intent intent = new Intent();

        backbtn =(Button)findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(share.this, Mainmap.class);
                share.this.startActivity(intent);
                //showPopForShare();
            }
        });
    }


}
