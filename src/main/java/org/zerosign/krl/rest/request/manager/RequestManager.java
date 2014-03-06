package org.zerosign.krl.rest.request.manager;

import java.io.IOException;
import org.zerosign.krl.rest.request.Request;
import org.zerosign.krl.rest.request.TrainPositionRequest;
import org.zerosign.krl.rest.request.TrainScheduleTimeFrameRequest;
import org.zerosign.krl.rest.request.StationListRequest;
import org.zerosign.krl.rest.request.TrainScheduleListRequest;
import org.zerosign.krl.rest.response.Response;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public final class RequestManager {

    /**
     * 
     * @param stationId
     * @return
     * @throws IOException 
     */
    public Response fetchTrainPosition(String stationId) throws IOException {
        final Request request = new TrainPositionRequest(stationId);
        request.build();
        return request.execute();
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public Response fetchStations() throws IOException {
        final Request request = new StationListRequest();
        request.build();
        return request.execute();
    }
    
    /**
     * 
     * @param stationId
     * @param trainNumber
     * @return
     * @throws IOException 
     */
    public Response fetchTrainSchedule(String stationId, String trainNumber) 
            throws IOException {
        
        final Request request = new TrainScheduleListRequest(stationId, trainNumber);
        request.build();
        return request.execute();
    }
    
    
    /**
     * 
     * @param stationId
     * @param timeFrom
     * @param timeTo
     * @return
     * @throws IOException 
     */
    public Response fetchTrainScheduleByTimeFrame(String stationId, 
            String timeFrom, String timeTo)
            throws IOException {
        
        final Request request = new TrainScheduleTimeFrameRequest(stationId, 
                timeFrom, timeTo);
        request.build();
        return request.execute();
    }
}
