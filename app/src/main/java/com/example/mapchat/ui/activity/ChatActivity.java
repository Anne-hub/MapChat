package com.example.mapchat.ui.activity;

import android.os.Bundle;

import com.example.basic.BaseActivity;
import com.example.mapchat.R;
import com.example.mapchat.ui.fragment.ChatFragment;
import com.hyphenate.EMMessageListener;
import com.hyphenate.easeui.ui.EaseChatFragment;

/**
 * @author chenhong
 * @Date 2020/7/2618:50
 * @package com.example.mapchat.ui.activity
 * @Desciption
 */
public class ChatActivity extends BaseActivity {
    /**
     * 获取资源id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.framgnt_chat;
    }

    public static ChatActivity activityInstance;

    private Bundle extras;
    /**
     * 初始化
     */
    @Override
    protected void initWork() {
        activityInstance = this;
        ChatFragment chatf = new ChatFragment();
        //获取从上个界面获取的参数，传给聊天界面。
        extras = getIntent().getExtras();
        chatf.setArguments(extras);
        //这个监听是接收到消息就给消息设置拓展属性。
        //chatf.setChatFragmentListener(helper);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_contains,chatf).commit();
    }

    /**
     * 继承环信的聊天页面
     * 实现消息监听和聊天页面的标题上显示的对方昵称
     *
     *
     */
    public static class ChatFragment extends EaseChatFragment implements EMMessageListener {
        /**
         * 设置聊天页面的title上面的昵称
         */
        @Override
        protected void setUpView() {
            super.setUpView();
            //titleBar.setTitle(name);

        }

    }

}
