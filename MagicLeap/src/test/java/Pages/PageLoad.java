package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.lang.time.StopWatch;

public class PageLoad {
	Long SumResTime= 0l;
	ArrayList<Long> arrList;
	
	public ArrayList<Long> getresponse(String urlString, int repeat) throws IOException{
		
		URL url = new URL(urlString);
        arrList = new ArrayList<Long>();
		
        for (int i=1;i<=repeat;i++){
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("GET");
	       
	        StopWatch pageLoad = new StopWatch();
	        pageLoad.start();
	        httpCon.connect();
	        pageLoad.stop();
	      
	        Long pageLoadTime_ms = pageLoad.getTime();
	        arrList.add(pageLoadTime_ms);
	        //System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
	        //System.out.println("Response time");
		}
		return arrList;
	}
		
	public String pageLoadTimes(ArrayList<Long> arrList){
			
		for(long t:arrList){
			SumResTime= SumResTime + t;
		}
	    Long minLTime = arrList.get(0);
	    Long maxLTime = arrList.get(0);
	    Long avgLTime = SumResTime/arrList.size();
	        //System.out.println(arrList.size());	        
	    for(long i: arrList) 
	    {
	        if(i < minLTime)
	           	minLTime = i;
	        if(i > maxLTime) 
	          	maxLTime = i;
	    }
	    Long avgTransactionTime = (minLTime+maxLTime)/2;
	    
	   // System.out.println("Minimum Pay Load Time is (milliSeconds) = " + minLTime);
       // System.out.println("Maximum Pay Load Time is (milliSeconds) = " + maxLTime);
       // System.out.println("Average Pay load Time is (milliSeconds) = " + avgLTime);
       // System.out.println("Average Transition Time is (milliSeconds) = " + avgTransactionTime);
        String result = "Minimum Pay Load Time is (milliSeconds) = " + minLTime + "<br>Maximum Pay Load Time is (milliSeconds) = " + maxLTime+
        		 "<br>"+"Average Pay load Time is (milliSeconds) = " + avgLTime + "<br>Average Transition Time is (milliSeconds) = " + avgTransactionTime;
	   return result; 
	}
}
