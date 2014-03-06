package org.zerosign.krl.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author zerosign
 */
public final class TrainPosition {
    
    @SerializedName("train")
    private Train train;
    
    @SerializedName("direction")
    private String direction;
    
    @SerializedName("position")
    private String position;
    
    @SerializedName("track")
    private String track;
    
}
