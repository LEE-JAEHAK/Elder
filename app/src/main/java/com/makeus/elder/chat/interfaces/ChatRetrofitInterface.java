package com.makeus.elder.chat.interfaces;

import com.makeus.elder.chat.model.ChatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChatRetrofitInterface {

    @GET("/chat")
    Call<ChatResponse> getChatList();
}
