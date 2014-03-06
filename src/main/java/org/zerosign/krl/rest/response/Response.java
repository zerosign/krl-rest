package org.zerosign.krl.rest.response;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public final class Response {

    public static enum ResponseCode {

        CORRECT_REQUEST(200),
        BAD_REQUEST(400),
        NOT_FOUND(404),
        UNKNOWN(499);

        ResponseCode(int value) {
            this.value = value;
        }

        private final int value;

        public final int getValue() {
            return value;
        }
        
        public static final ResponseCode GetResponseCode(int value) {
            
            ResponseCode code = ResponseCode.UNKNOWN;
            
            if(value == CORRECT_REQUEST.value) {
                code = CORRECT_REQUEST;
            }
            else if(value == BAD_REQUEST.value) {
                code = BAD_REQUEST;
            }
            else if(value == NOT_FOUND.value) {
                code = NOT_FOUND;
            }
            else if(value == UNKNOWN.value) {
                code = UNKNOWN;
            }
            
            return code;
        }
    }

    private ResponseCode code;
    private String response;
    private String message;

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = ResponseCode.GetResponseCode(code);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" + "code=" + code + ", response=" + response + 
                ", message=" + message + '}';
    }

    
    
}
