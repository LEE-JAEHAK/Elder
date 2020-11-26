package com.makeus.elder.call.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CallResponse {

    @SerializedName("result")
    Result result;

    @SerializedName("isSuccess")
    boolean isSuccess;

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    public class Result {
        @SerializedName("idx")
        int idx;

        @SerializedName("elder_idx")
        int elder_idx;

        @SerializedName("visit_time")
        String visit_time;

        @SerializedName("visit_date")
        String visit_date;

        @SerializedName("visit_content")
        String visit_content;

        public int getIdx() {
            return idx;
        }

        public int getElder_idx() {
            return elder_idx;
        }

        public String getVisit_time() {
            return visit_time;
        }

        public String getVisit_date() {
            return visit_date;
        }

        public String getVisit_content() {
            return visit_content;
        }
    }

    public Result getResult() {
        return result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
