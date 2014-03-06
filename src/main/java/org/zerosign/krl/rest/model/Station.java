package org.zerosign.krl.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author zerosign
 */
public class Station {
    
    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;
    
    public Station(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    
}
