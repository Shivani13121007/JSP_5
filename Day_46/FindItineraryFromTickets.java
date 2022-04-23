import java.util.*;

public class FindItineraryFromTickets {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
		
		HashMap<String, Boolean> hm  = new HashMap<>();
		
		for(String src : map.keySet())
		{
		    String dest = map.get(src);
		    
		    hm.put(dest,false);
		    
		    if(hm.containsKey(src) == false)
		    {
		        hm.put(src,true);
		    }
		}
		
		String src = "";
		
		for(String val : hm.keySet())
		{
		    if(hm.get(val) == true)
		    {
		        src = val;
		    }
		}
		
		while(true)
		{
		    if(map.containsKey(src) == true)
		    {
		        System.out.print(src+" -> ");
		        src = map.get(src);
		    }
		    else{
		        System.out.print(src+".");
		        break;
		    }
		}
		
		
	
	
	
	
		
	}
}
