package org.zerosign.krl.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author zerosign
 */
public final class TrainSchedule {
    
    @SerializedName("train")
    private Train train;
    
    @SerializedName("time")
    private Long time;
    
    @SerializedName("direction")
    private String direction;
    
}
