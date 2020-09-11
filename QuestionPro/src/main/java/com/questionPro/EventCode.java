package com.questionPro;

public class EventCode {
    private String code = null;

    private String reason = null;

    public EventCode(String code, String reason) {
        this.code=code;
        this.reason=reason;
    }


    public static class Application {
        public  static final EventCode ERROR_IN_BEST_FETCHING_STORYID = new EventCode("APP001","Failed to fetch the best story Ids");

    }
}
