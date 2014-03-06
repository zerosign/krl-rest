package org.zerosign.krl.rest.request;

/**
 *
 * @author zerosign
 * @since 6 March 2014
 * @version 1.0
 */
public class PlaceAutoCompleteRequest extends Request {

    private static final String ENDPOINT = "json";
    
    private static final String PLACE = "input";
    private static final String SENSOR = "sensor";
    private static final String KEY = "key";
    private static final String LANG = "language";
    
    public PlaceAutoCompleteRequest(String place) {
        super(RequestMethod.GET, ENDPOINT);
        addBodyParam(PLACE, place);
        addBodyParam(SENSOR, Boolean.FALSE.toString().toLowerCase());
        addBodyParam(KEY, place);
        addBodyParam(LANG, "INDONESIAN");
    }
    
}
