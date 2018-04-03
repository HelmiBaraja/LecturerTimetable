package misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	public static String getStringDate(Date date) {
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = null;
		   try{
			dateString = sdfr.format( date );
		   }catch (Exception ex ){
			System.out.println(ex);
		   }
	     return dateString;
	  }
}
