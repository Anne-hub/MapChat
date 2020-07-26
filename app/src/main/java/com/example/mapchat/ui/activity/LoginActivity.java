package com.example.mapchat.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import com.example.basic.BaseActivity;
import com.example.mapchat.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;

/**
 * @author chenhong
 * @Date 2020/7/2616:48
 * @package com.example.mapchat.ui.activity
 * @Desciption
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_pass)
    EditText etPass;

    /**
     * 获取资源id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 初始化
     */
    @Override
    protected void initWork() {

        EMClient.getInstance().login("chenhong", "123", new EMCallBack() {
            @Override
            public void onSuccess() {
                //加载会话消息
                EMClient.getInstance().chatManager().loadAllConversations();
                EMClient.getInstance().groupManager().loadAllGroups();
                Log.i("hello", "onSuccess: ");
                startActivity(new Intent(getActivity(), MainActivity.class));
            }

            @Override
            public void onError(int i, String s) {
                Log.i("hello", "onSuccess: " + s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
