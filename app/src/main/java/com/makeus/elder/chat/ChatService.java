package com.makeus.elder.chat;

import android.content.Context;

import androidx.annotation.NonNull;

import com.makeus.elder.chat.interfaces.ChatRetrofitInterface;
import com.makeus.elder.chat.interfaces.ChatView;
import com.makeus.elder.chat.model.ChatResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeus.elder.src.ApplicationClass.getRetrofit;

public class ChatService {

    Context mContext;
    private ChatView mView;

    public ChatService(final ChatView view, Context context) {
        this.mView = view;
        this.mContext = context;
    }

    public void getChatList() {
        final ChatRetrofitInterface chatRetrofitInterface = getRetrofit().create(ChatRetrofitInterface.class);
        chatRetrofitInterface.getChatList().enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(@NonNull Call<ChatResponse> call, @NonNull Response<ChatResponse> response) {

                final ChatResponse scheduleResponse = response.body();
                if (scheduleResponse == null) {
                    mView.getChatFailure("빈 값");
                    return;
                }

                if (scheduleResponse.isSuccess()) {
                    mView.getChatSuccess(scheduleResponse.getResult());
                }
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {
                mView.getChatFailure("서버 연결 실패");
            }
        });
    }

}
