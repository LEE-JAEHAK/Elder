package com.makeus.elder.contact;


import com.makeus.elder.contact.interfaces.ContactActivityView;
import com.makeus.elder.contact.interfaces.ContactRetrofitInterface;
import com.makeus.elder.contact.models.ContactResponse;
import com.makeus.elder.contact.models.RequestContact;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeus.elder.src.ApplicationClass.getRetrofit;


public class ContactService {
    final ContactActivityView contactActivityView;

    public ContactService(ContactActivityView contactActivityView) {
        this.contactActivityView = contactActivityView;
    }

    void postUser(RequestContact requestContact) {
        final ContactRetrofitInterface contactRetrofitInterface = getRetrofit().create(ContactRetrofitInterface.class);
        contactRetrofitInterface.postContact(requestContact).enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                final ContactResponse contactResponse = response.body();
                if (contactResponse == null) {
                    contactActivityView.validateUserFail(response.message());
                    return;
                }
                contactActivityView.validateUserSuccess(contactResponse.getIsSuccess(), contactResponse.getCode(), contactResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
                contactActivityView.validateUserFail(t.getMessage());
            }
        });
    }
}
