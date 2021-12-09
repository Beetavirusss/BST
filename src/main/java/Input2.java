import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;

public class Input2 extends Thread{

	Vector<String> vector=new Vector<>();
	Vector<String> v3=new Vector<>();
	Map<String,Integer> mp=new TreeMap<>();
	
	public Input2(BST obj) {
		// TODO Auto-generated constructor stub
		run(obj);
	}

	public void run(BST Tree)
	{
		System.out.println("Thread 3 is Running\n\n");
		
		String Path="C:\\Users\\abeeh\\eclipse-workspace\\A3\\src\\main\\java\\2.txt";
		String Line="";
		try {
			BufferedReader buffer=new BufferedReader(new FileReader(Path));
			try {
				while ((Line=buffer.readLine())!=null)
				{
					vector.add(Line);
					StringTokenizer defaultTokenizer = new StringTokenizer(Line);
					while(defaultTokenizer.hasMoreTokens())
					{
						v3.add(defaultTokenizer.nextToken());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		for (int i=0;i<v3.size();i++)
		{
			String a="";
			a=v3.elementAt(i);
			if(Tree.search(a))
			{
				if(mp.containsKey(a))
					{
					    mp.put(a, mp.get(a)+1);
					}
				else
					{
					    mp.put(a,1);
					}
			}
		}
		
		for(Map.Entry<String,Integer> entry:
            mp.entrySet())
		{
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	public void display()
	{
	
		System.out.println(v3);
	}
	
	public void displaymap()
	{
		for(Map.Entry<String,Integer> entry:
            mp.entrySet())
		{
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	public boolean search(String a)
	{
		if(v3.contains(a))
			return true;
		return false;
	}
	
}