package com.makeus.elder.chat;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.makeus.elder.R;
import com.makeus.elder.src.BaseActivity;
import com.makeus.elder.chat.adapter.ChatAdapter;
import com.makeus.elder.chat.interfaces.ChatView;
import com.makeus.elder.chat.model.Chat;

import java.util.ArrayList;

public class ChatActivity extends BaseActivity implements ChatView {

    private RecyclerView mChatRv;
    private ChatAdapter mChatAdapter;
    private ArrayList<Chat> mChatList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_elder);

        mChatList = new ArrayList<>();
        mChatRv = findViewById(R.id.chat_rv);
        mChatAdapter = new ChatAdapter(this, mChatList, new ChatAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

            }
        });
        mChatRv.setAdapter(mChatAdapter);
    }

    public void chatOnClick(View view) {
        switch (view.getId()) {
            case R.id.chat_iv_mic:
                break;
        }
    }

    @Override
    public void getChatSuccess(ArrayList<Chat> result) {
        hideProgressDialog();
        mChatList.clear();
        mChatList.addAll(result);
        mChatAdapter.notifyDataSetChanged();
    }

    @Override
    public void getChatFailure(String message) {
        hideProgressDialog();
        showCustomToast(message);
    }
}
