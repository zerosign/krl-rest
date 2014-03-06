package org.zerosign.krl.rest.request.manager;

import java.io.FileWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.zerosign.krl.rest.response.Response;

/**
 *
 * @author zerosign
 */
public class RequestManagerTest {
    
    public RequestManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fetchTrainPosition method, of class RequestManager.
     */
    @Test
    @Ignore
    public void testFetchTrainPosition() throws Exception {
        System.out.println("fetchTrainPosition");
        String stationId = "";
        RequestManager instance = new RequestManager();
        Response expResult = null;
        Response result = instance.fetchTrainPosition(stationId);
        assertEquals(expResult, result);
    }

    /**
     * Test of fetchStations method, of class RequestManager.
     */
    @Test
    public void testFetchStations() throws Exception {
        System.out.println("fetchStations");
        RequestManager instance = new RequestManager();
        Response expResult = null;
        Response result = instance.fetchStations();
        System.out.println(result);
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of fetchTrainSchedule method, of class RequestManager.
     */
    @Test
    @Ignore
    public void testFetchTrainSchedule() throws Exception {
        System.out.println("fetchTrainSchedule");
        String stationId = "";
        String trainNumber = "";
        RequestManager instance = new RequestManager();
        Response expResult = null;
        Response result = instance.fetchTrainSchedule(stationId, trainNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of fetchTrainScheduleByTimeFrame method, of class RequestManager.
     */
    @Test
    public void testFetchTrainScheduleByTimeFrame() throws Exception {
        System.out.println("fetchTrainScheduleByTimeFrame");
        String stationId = "BOI";
        String timeFrom = "01:00";
        String timeTo = "12:00";
        RequestManager instance = new RequestManager();
        Response expResult = null;
        Response result = instance.fetchTrainScheduleByTimeFrame(stationId, timeFrom, timeTo);
        System.out.println(result);
        assertNotEquals(expResult, result);
        
        try(FileWriter writer = new FileWriter("output.json")) {
            writer.write(result.getMessage());
            
        }
        
    }
    
}
