package org.zerosign.krl.rest.request;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public final class TrainScheduleTimeFrameRequest extends Request {

    private static final String ENDPOINT
            = "bVMWU1ZBFk9UVARVQ0JaBgRESxkHBlETREBYDAVOWkBaVwYRWUkTQE5AFQAcXwZDWlZXElVeRRdVElsODUsPDQYCBVgBCAc6NzBhYzIyODQ=";

    private static final String STATION_ID = "Station_id";
    private static final String TIME_FROM = "Time_from";
    private static final String TIME_TO = "Time_to";

    public TrainScheduleTimeFrameRequest(final String stationId, final String timeFrom,
            final String timeTo) {
        super(RequestMethod.POST, ENDPOINT);

        addBodyParam(STATION_ID, stationId);
        addBodyParam(TIME_FROM, timeFrom);
        addBodyParam(TIME_TO, timeTo);
    }

}
