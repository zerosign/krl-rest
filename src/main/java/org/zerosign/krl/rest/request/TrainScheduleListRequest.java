package org.zerosign.krl.rest.request;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public class TrainScheduleListRequest extends Request {

    private static final String ENDPOINT
            = "VWkVVQhBAR0DB1UGEAlFE0IIQx4XSg4OQw0CRxgUBAZwRgJRBFQFW2tVBVoWTR1ERlQcAlFGXAJQEVMNCFRIAAQCBlQODgcIOjNjZmZkNzkw";

    private static final String TRAIN_NUMBER = "No_ka";
    private static final String STATION_ID = "Station_id";

    public TrainScheduleListRequest(final String stationId, final String trainNumber) {
        super(RequestMethod.POST, ENDPOINT);
        
        addBodyParam(STATION_ID, stationId);
        addBodyParam(TRAIN_NUMBER, trainNumber);
    }

}
