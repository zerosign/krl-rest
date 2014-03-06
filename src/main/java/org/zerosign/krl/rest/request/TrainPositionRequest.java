package org.zerosign.krl.rest.request;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public final class TrainPositionRequest extends Request {

    private static final String ENDPOINT = 
            "cEAVVw5jQ1JGaFpcC0EQREJQEjhfQAdSTVFHDgl1QFhcRhEIXFxHGVNcWkZZRhBBUxhUAEBCWRBdFVsKAksPDQYCBVgBCAc6ZDllNWQ2OWY=";
    
    private static final String STATION_ID = "Station_id";
    
    public TrainPositionRequest(final String stationId) {
        super(RequestMethod.POST, ENDPOINT);
        addBodyParam(STATION_ID, stationId);
    }
    
    
    
}
