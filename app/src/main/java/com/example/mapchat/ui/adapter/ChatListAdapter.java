package com.example.mapchat.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mapchat.R;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author chenhong
 * @Date 2020/7/2618:20
 * @package com.example.mapchat.ui.adapter
 * @Desciption
 */
public class ChatListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ChatListAdapter(@Nullable List<String> data) {
        super(R.layout.layout_chat_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setText(R.id.tv_nickName, item.getNickname());
//        helper.setText(R.id.tv_content, item.getContent());
//        Glide.with(mContext).load(item.getUserHead()).into((RoundImageView) helper.getView(R.id.iv_head));
    }
}
