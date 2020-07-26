package com.example.mapchat.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.basic.BaseFragment;
import com.example.mapchat.R;
import com.example.mapchat.ui.activity.ChatActivity;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCmdMessageBody;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMGroupReadAck;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.Utils;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author chenhong
 * @Date 2020/7/2615:36
 * @package com.example.mapchat.ui.fragment
 * @Desciption
 */
public class ChatFragment extends BaseFragment {


    @BindView(R.id.rv_WeChat)
    RecyclerView rvChat;

    private EaseConversationListFragment cf;

    /**
     * 获取资源id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.framgnt_chat;
    }

    /**
     * 初始化
     */
    @Override
    protected void initWork() {
        cf = new EaseConversationListFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_contains, cf).commit();

        EMClient.getInstance().chatManager().addMessageListener(emMessageListener);



        cf.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                // 聊天需要的bundle对象
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(EaseConstant.EXTRA_USER_ID, conversation.getLastMessage().getUserName());
                bundle.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
                intent.putExtras(bundle);
                /**
                 * 从会话列表跳转到聊天页面
                 * 首先要判断最后一条信息是接收还是发送消息
                 * 然后分情况传递头像和昵称
                 *
                 */
//                EMMessage lastMessage = conversation.getLastMessage();
//                if (lastMessage.direct() == EMMessage.Direct.RECEIVE) {
//                    try {
//                        intent.putExtra(Utils.FROM_AVATER, lastMessage.getStringAttribute(Utils.FROM_AVATER));
//                        intent.putExtra(Utils.FROM_NICHENG, lastMessage.getStringAttribute(Utils.FROM_NICHENG));
//                    } catch (HyphenateException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        intent.putExtra(Utils.FROM_AVATER, lastMessage.getStringAttribute(Utils.TO_AVATER));
//                        intent.putExtra(Utils.FROM_NICHENG, lastMessage.getStringAttribute(Utils.TO_NICHENG));
//                    } catch (HyphenateException e) {
//                        e.printStackTrace();
//                    }
//                }
                startActivity(intent);
            }
        });

    }

    private EMMessageListener emMessageListener = new EMMessageListener() {
        @Override
        public void onMessageReceived(List<EMMessage> list) {
            //在环信包下的消息列表中对消息对象进行了筛选。将第0个消息存为32个8账号的消息，
            // 从消息列表中取出第0个消息对象。（第0个消息就是存有32个8该账号的消息对象）
            EMMessage emMessage = list.get(0);
            String s = emMessage.getBody().toString();
            try {
                //这里是订单消息
                EMConversation conversation = EMClient.getInstance().chatManager().getConversation("88888888888888888888888888888888");
                //未读的消息数量普通消息
                //unreadMsgCount = conversation.getUnreadMsgCount();
                Log.i("123---", s + "---from:" + emMessage.getFrom() + "---to:" + emMessage.getTo() + "---nicheng:" + emMessage.getStringAttribute("from_nicheng"));
            } catch (Exception e) {
                cf.refresh();
                Log.i("123---", s + "---from:" + emMessage.getFrom() + "---to:" + emMessage.getTo());
            }
            cf.refresh();
        }

        //透传消息的
        @Override
        public void onCmdMessageReceived(List<EMMessage> list) {

        }

        @Override
        public void onMessageRead(List<EMMessage> list) {

        }

        @Override
        public void onGroupMessageRead(List<EMGroupReadAck> list) {

        }

        @Override
        public void onReadAckForGroupMessageUpdated() {

        }

        @Override
        public void onMessageDelivered(List<EMMessage> list) {

        }

        @Override
        public void onMessageRecalled(List<EMMessage> list) {

        }

        @Override
        public void onMessageChanged(EMMessage emMessage, Object o) {

        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
