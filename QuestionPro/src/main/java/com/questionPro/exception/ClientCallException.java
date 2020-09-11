package com.questionPro.exception;

import com.questionPro.EventCode;

public class ClientCallException extends  Exception{
    public ClientCallException(EventCode eventCode) {
        super(String.valueOf(eventCode));
    }

    public ClientCallException(EventCode eventCode, Throwable cause) {
        super(String.valueOf(eventCode));
        initCause(cause);
    }

}
