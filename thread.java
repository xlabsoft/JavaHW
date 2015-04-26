import java.util.*;
import java.util.concurrent.TimeUnit;
public class MainProg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int dsLength = 1000000;
		int[] numDataStorage = new int[dsLength];
		String[] strDataStorage = new String[dsLength];
		for (int i=0; i<dsLength; i++){
			 numDataStorage[i] = i;
			 strDataStorage[i] = String.valueOf(i); 
		}
		
		shuffleArray(numDataStorage);
		
		for (int i=0; i<dsLength; i++){			 
			 strDataStorage[i] =  String.valueOf(numDataStorage[i]); 
		}
		System.out.println(strDataStorage[33]);
		System.out.println(strDataStorage[333]);
		System.out.println(strDataStorage[3333]);
					  
		  List<Integer> arlist = new ArrayList<>();
		  for (int i : numDataStorage) {
			  arlist.add(i);
		  }
		  
		  System.out.print("ArrayList ");
		  search(arlist);
		  
		  List<Integer> linklist = new LinkedList<>();
		  for (int i : numDataStorage) {
			  linklist.add(i);
		  }
		  
		 System.out.print("LinkedList ");
		 search(linklist);
		  
		  Runnable r1 = new Runnable() {
			
	            @Override
	            public void run() {
	                search(arlist);
	                System.out.println("r1");
	            }
	        };
	        
	        Runnable r2 = new Runnable() {
				
	        	@Override
	        	public void run() {
		              search(linklist);
		              System.out.println("r2");
		            }
		        };
	        
	        Thread[] ths = new Thread[2];	        
	            ths[0] = new Thread(r1);
	            ths[1] = new Thread(r2);
	            
	        for (int i = 0; i < 2; i++) {
	            ths[i].start();
	        }
	        System.out.println("started");
	        
	        for (int i = 0; i < 2; i++) {
	            ths[i].join();
	        }
	               
	        System.out.println("finished");

	}

	public static void search(List<Integer> array) {
		int half = 500000;
		int count = 100;
		long srArifm = 0;
		long srArifmN = 0;
		for (int c=1; c <= count; c++)
		{
			long start = System.currentTimeMillis();
			long startN = System.nanoTime();
			
			array.get(half);
			
			long delta = System.currentTimeMillis() - start;
			long deltaN = System.nanoTime() - startN;
			//long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(end - start);
			srArifm += delta; 
			srArifmN += deltaN;
		}
		  System.out.println("Search by Index Took: " + srArifm/count  + "ms ("+ srArifmN/count  + "ns)");
		  
	}
	
	public static void shuffleArray(int[] array) {
		  List<Integer> list = new ArrayList<>();
		  for (int i : array) {
		    list.add(i);
		  }

		  Collections.shuffle(list);

		  for (int i = 0; i < list.size(); i++) {
		    array[i] = list.get(i);
		  }    
		}
}
