package com.example.basic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
public abstract class BaseFragment extends Fragment implements BaseInterface {

    //view注解
    protected Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, view);
        initWork();

        return view;
    }

    /**
     * 获取资源id
     */
    protected abstract int getLayoutId();


    /**
     * 初始化
     */
    protected abstract void initWork();


    @Override
    public void onDestroy() {
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
