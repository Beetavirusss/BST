import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Vector;

class Vocab extends Thread {

	public Vocab(BST obj) {
		// TODO Auto-generated constructor stub
		run(obj);
	}

	public void run(BST Tree)
	{
		System.out.println("Thread 1 is Running\n\n");
		//BST Tree = new BST();
		String Path="C:\\Users\\abeeh\\eclipse-workspace\\A3\\src\\main\\java\\Vocab.txt";
		String Line="";
		try 
		{
			BufferedReader buffer=new BufferedReader(new FileReader(Path));
			try {
				
				while ((Line=buffer.readLine())!=null)
				{
					Tree.addNode(Line);
				}
			} 
			
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void display(BST Tree)
	{
		Tree.preorder();
	}
	
	
}