package com.example.basic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.BatchUpdateException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * activity 基类
 *
 * @author chenhong
 * @Date 2020/7/2614:26
 * @package com.example.basic
 * @Desciption
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseInterface {

    //view注解
    protected Unbinder unbinder;
    //上下文
    public Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        activity = this;
        unbinder = ButterKnife.bind(this);
        initWork();
    }


    /**
     * 获取资源id
     */
    protected abstract int getLayoutId();


    /**
     * 初始化
     */
    protected abstract void initWork();


    public Activity getActivity() {
        return activity;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != unbinder) {
            unbinder.unbind();
        }
    }


    @Override
    public void setText(TextView textView, String text) {
        textView.setText(text);
    }
}
