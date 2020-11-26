package com.makeus.elder.contact.interfaces;

import com.makeus.elder.contact.models.ContactResponse;
import com.makeus.elder.contact.models.RequestContact;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ContactRetrofitInterface {
    @POST("/elder/contact")
    Call<ContactResponse> postContact(@Body RequestContact params);
}
