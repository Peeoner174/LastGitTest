package io.yostajsc.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

import io.yostajsc.chat.adapter.ChatAdapter;
import io.yostajsc.chat.models.Chat;

public class ChatActivity extends AppCompatActivity {


    private RecyclerView rvList;
    private Random random;
    private ChatAdapter adapter = null;

    private EditText editMessage;


    private AppCompatImageView imageSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        onApplyViews();
    }

    private void onApplyViews() {

        editMessage = (EditText) findViewById(R.id.edit_message);
        rvList = (RecyclerView) findViewById(R.id.recycler_view);
        imageSend = (AppCompatImageView) findViewById(R.id.image_send);
        imageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSend();
            }
        });
        random = new Random();

        this.adapter = new ChatAdapter(this);
        for (int i = 0; i < 20; i++) {
            this.adapter.add(new Chat<>(
                    "http://nguoinoitieng.vn/images/item/tieu-su-son-tung-m-tp.jpg",
                    "Hello + " + i,
                    random.nextInt(2)));
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(true);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setAdapter(this.adapter);
        rvList.setHasFixedSize(true);

    }

    private void onSend() {
        String chatContent = editMessage.getText().toString();
        adapter.add(new Chat<>(
                "http://nguoinoitieng.vn/images/item/tieu-su-son-tung-m-tp.jpg",
                chatContent, 0));
        rvList.smoothScrollToPosition(adapter.getItemCount());
    }
}
