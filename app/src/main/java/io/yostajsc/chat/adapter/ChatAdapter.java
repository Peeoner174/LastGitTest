package io.yostajsc.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.yostajsc.chat.R;
import io.yostajsc.chat.models.Chat;
import io.yostajsc.chat.models.ChatType;
import io.yostajsc.chat.ui.ChatVH;

/**
 * Created by nphau on 3/16/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatVH> {

    private Context mContext;
    private List<Chat<String>> mList = null;

    public ChatAdapter(Context context) {
        this.mContext = context;
        this.mList = new ArrayList<>();
    }


    @Override
    public ChatVH onCreateViewHolder(ViewGroup parent, @ChatType int viewType) {

        View itemLayoutView = null;

        switch (viewType) {
            case ChatType.RECEIVE:
                itemLayoutView = LayoutInflater.from(mContext).inflate(R.layout.item_chat_receiver, null);
                break;
            case ChatType.SEND:
                itemLayoutView = LayoutInflater.from(mContext).inflate(R.layout.item_chat_sender, null);
                break;
            case ChatType.UNDEFINED:
                break;
        }

        itemLayoutView.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ChatVH(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ChatVH holder, int position) {
        holder.bind(mList.get(position));

    }


    @Override
    public int getItemViewType(int position) {
        if (this.mList == null)
            return ChatType.UNDEFINED;
        return mList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        if (this.mList == null)
            return 0;
        return this.mList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void replaceAll(List<Chat<String>> data) {
        if (this.mList == null)
            this.mList = new ArrayList<>();
        this.mList.clear();
        this.mList.addAll(data);
        notifyItemRangeChanged(0, mList.size());
    }

    public void add(Chat<String> chat) {
        if (this.mList == null)
            this.mList = new ArrayList<>();
        this.mList.add(chat);
        notifyItemInserted(this.mList.size() - 1);
    }
}
