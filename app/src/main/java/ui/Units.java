package ui;


import android.annotation.SuppressLint;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Units {

        String getDateTime (String currentDate){

                String time=null;

            PrettyTime p = new PrettyTime(  );
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" , Locale.ENGLISH);
            try {

                Date date = simpleDateFormat.parse( currentDate );
                time=p.format( date );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return time;

        }
   static String getDatePerYear (String currentDate)
    {
        String myDate;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "E , d MMM yyyy",Locale.ENGLISH );

        try {
        Date date = new SimpleDateFormat( "yyyy-MM-dd",Locale.ENGLISH ).parse( currentDate );
            myDate=simpleDateFormat.format( date );
        } catch (ParseException e) {
            e.printStackTrace();
            myDate="currentDate";
        }

        return myDate;
    }
}


