/*
 * Name : Shruti Subhash Salunkhe
 * Class : BE IT    Roll No. : 9004
 * Sub : Distributed System Lab
 * Problem Statement : Implement Berkeley algorithm for clock synchronization.
 */

package berkeley;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;  


public class berkeley_algo {
	public static void berkeleyAlgo(String servertime, String time1, String time2) {
        System.out.println("Server Clock   = " + servertime);
        System.out.println("Client Clock 1 = " + time1);
        System.out.println("Client Clock 2 = " + time2);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        try {
            /* Converting time to Milliseconds */
            long s = sdf.parse(servertime).getTime();
            long t1 = sdf.parse(time1).getTime();
            long t2 = sdf.parse(time2).getTime();
            /* Calcuating time differences w.r.t server */
            long st1 = t1 - s;
            System.out.println("t1 - s = "+st1/1000);
            long st2 = t2 - s;
            System.out.println("t2 - s = "+st2/1000);
            /* Fault tolerant Average */
            long aveg = (st1 + st2 + 0) / 3;
            System.out.println("(st1 + st2 + 0)/3 = "+aveg/1000);
            /* Adjustment */
            long adjserver = aveg+s;
            long adj_t1 = aveg-st1;
            long adj_t2 = aveg-st2;
            System.out.println("t1 adjustment = "+adj_t1/1000);
            System.out.println("t2 adjustment = "+adj_t2/1000);
            /* sync clock */
            System.out.println("Synchronized Server Clock  = "+sdf.format(new Date(adjserver)));
            System.out.println("Synchronized Client1 Clock = "+sdf.format(new Date(t1+adj_t1)));
            System.out.println("Synchronized Client2 Clock = "+sdf.format(new Date(t2+adj_t2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
    	System.out.print("Enter server time- ");  
    	String a= sc.nextLine();  
    	System.out.print("Enter client 1 time- ");  
    	String b= sc.nextLine();  
    	System.out.print("Enter client 2 time - ");  
    	String c= sc.nextLine();   
    	System.out.println("\n");
        berkeleyAlgo(a, b, c);
    }
}

/*
 * Output : 
Server Clock   = 03:00
Client Clock 1 = 03:19
Client Clock 2 = 02:50
t1 - s = 19
t2 - s = -10
(st1 + st2 + 0)/3 = 3
t1 adjustment = -16
t2 adjustment = 13
Synchronized Server Clock  = 03:03
Synchronized Client1 Clock = 03:03
Synchronized Client2 Clock = 03:03
 */
