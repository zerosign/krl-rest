package org.zerosign.krl.rest.model;

/**
 *
 * @author zerosign
 */
public class Train {
    
    /**
     * 
     */
    public static enum TrainClass  {
        CL(1);
        
        /**
         * 
         * @param value 
         */
        TrainClass(int value) {
            this.value = value;
        }
        
        /**
         * 
         * @param value
         * @return 
         */
        public static final TrainClass GetTrainClass(int value) {
            TrainClass type = CL;
            if(value == CL.value) {
                type = CL;
            }
            return type;
        }
        
        int value;
    }
    
    private Long id;
    private String name;
    private TrainClass type;
}
