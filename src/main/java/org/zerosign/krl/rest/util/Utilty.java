package org.zerosign.krl.rest.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public final class Utilty {

    public static final long ParseTime(final String time) 
            throws ParseException {
        final String[] timeString = time.split(":");
        int hour = Integer.parseInt(timeString[0]), 
                minute = Integer.parseInt(timeString[1]),
                second = Integer.parseInt(timeString[2]);
        
        
        Calendar now = new GregorianCalendar();
        now.set(Calendar.HOUR_OF_DAY, hour);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, second);
        
        return now.getTimeInMillis();
    }

}
