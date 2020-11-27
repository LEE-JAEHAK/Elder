package com.makeus.elder.chat.interfaces;

import com.makeus.elder.chat.model.Chat;

import java.util.ArrayList;

public interface ChatView {

    void getChatSuccess(ArrayList<Chat> result);
    void getChatFailure(String message);
}
