package org.zerosign.krl.rest.request;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public class StationListRequest extends Request {
    
    private static final String ENDPOINT = 
            "FEMDQg4aU1tWChcAUlcbWlJYblpOVFsJWRZpEkJQUg5IdAINAQhJS0ZQTARWTBBDUUNaClpMD1cCUAdYVQUGOjc0Mzc3NzAy";
    
    public StationListRequest() {
        super(RequestMethod.POST, ENDPOINT);
    }
}
