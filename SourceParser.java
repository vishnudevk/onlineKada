package com.counter.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * @author Vishnudev.K
 *this method parse the next match date from the source code.
 * In future the sniplets should be added for getting the club crust
 */
public class SourceParser {

	private static String pageSrc;
	private static String siteUrl = "http://barcelonastream.com";
	private static String proxyHost = "labcore-vip.network.fedex.com";
	private static String proxyPort = "3128";
	
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MMM,dd,yyyy,HH:mm" );
	private static TimeZone timeZone = TimeZone.getTimeZone("UTC");
	
	
	public static void main(String[] args) throws ParseException, IOException {
		System.out.println(new Date());
		pageSrc = getBSPageSrc();
		getNetMatchSchedule(pageSrc);
		System.out.println(new Date());
	}

	
	/**Method used for getting page source of this Barcelona stream.
	 * set proxyHost and proxyPort if you proxy to access net
	 * @return
	 * @throws IOException
	 */
	private static String getBSPageSrc() throws IOException{
		StringBuilder pageSrc = new StringBuilder();
		if(proxyHost!=null && ! proxyHost.isEmpty())
			System.getProperties().put("http.proxyHost", proxyHost);
		if(proxyPort!=null && ! proxyPort.isEmpty())
			System.getProperties().put("http.proxyPort", proxyPort);
		
		if(System.getProperties().get("http.proxyHost")!=null && System.getProperties().get("http.proxyPort")!=null)
			System.out.println("Systme proxy settings : "+System.getProperties().get("http.proxyHost")+":"+System.getProperties().get("http.proxyPort"));
		
		URL url = new URL(siteUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            //System.out.println(inputLine);
        	pageSrc.append(inputLine);
        in.close();
        
		return pageSrc.toString();
	}
	
	
	/**Method used for getting the next match schedule date
	 * @param pageSrc
	 * @return
	 * @throws ParseException
	 */
	private static Date getNetMatchSchedule(String pageSrc) throws ParseException{
		int eventTimePosition = pageSrc.indexOf("eventTime: \""); 
		int dateEndPostion = pageSrc.indexOf("\",",eventTimePosition);
		String dateStr = pageSrc.substring(eventTimePosition+ 12 , dateEndPostion);
		System.out.println("Date going to be parsed "+dateStr);
		dateFormat.setTimeZone(timeZone);
	    Date date = dateFormat.parse(dateStr);
		System.out.println("Parsed date "+date);
		
		return date;
	}
	
	
}
