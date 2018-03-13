package io.yostajsc.chat.ui;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import io.yostajsc.chat.R;
import io.yostajsc.chat.models.Chat;

/**
 * Created by nphau on 3/16/17.
 */

public class ChatVH extends RecyclerView.ViewHolder {


    TextView textView;

    TextView textTime;

    AppCompatImageView imageView;

    public ChatVH(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.text_view);
        textTime = (TextView) itemView.findViewById(R.id.text_time);
        imageView = (AppCompatImageView) itemView.findViewById(R.id.image_view);

    }


    public void bind(Chat<String> chat) {
        textView.setText(chat.getData());
    }

}
