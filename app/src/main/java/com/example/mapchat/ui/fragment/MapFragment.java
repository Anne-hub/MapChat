package com.example.mapchat.ui.fragment;

import com.example.basic.BaseFragment;
import com.example.mapchat.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

/**
 * 地图fragment
 *
 * @author chenhong
 * @Date 2020/7/2615:31
 * @package com.example.mapchat
 * @Desciption
 */
public class MapFragment extends BaseFragment {
    /**
     * 获取资源id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_map;
    }

    /**
     * 初始化
     */
    @Override
    protected void initWork() {
        //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
        EMMessage message = EMMessage.createTxtSendMessage("hello", "chenting");

        //发送消息
        EMClient.getInstance().chatManager().sendMessage(message);
    }
}
