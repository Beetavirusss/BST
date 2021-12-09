import java.util.Scanner;
import java.util.Vector;

public class MainThread extends Thread {
	
	public static void main (String[] args) throws InterruptedException
	{
		BST obj=new BST();
		Vocab t1=new Vocab(obj);
		
		t1.start();
		t1.join();
		
		Input1 t2=new Input1(obj);
		
		t2.start();
		t2.join();
		
		Input2 t3=new Input2(obj);
		
		t3.start();
		t3.join();
		
		@SuppressWarnings("resource")
		Scanner a=new Scanner(System.in);
		int choice=0;
		do {
			System.out.print
			(
					"\n\nPress 1 to Display the BST from Vocablary"
					+ "\nPress 2 to Display the Vectors from Input Files 1 and 2"
					+ "\nPress 3 to view matches and frequency"
					+ "\nPress 4 to search"
					+ "\nPress 5 to Exit"		+ "\n\n\n"
		    );
			
		choice=a.nextInt();
		
		switch(choice)
		{
		
		case 1:
			t1.display(obj);
			break;
		case 2:
			t2.display();
			t3.display();
			break;
			
		case 3:
			t2.displaymap();
			t3.displaymap();
			break;
		case 4:
			String query="";
			
			System.out.print("Enter the Word you want to Search\n\n");
			query= query + a.next();
			
			if(t2.search(query))
			{
				System.out.print("\nFound in InputFile1\n\n");
			}
			
			if(t3.search(query))
			{
				System.out.print("\nFound in InputFile2\n\n");
			}
			
			else
				System.out.print("\nNot found in an files\n\n");

			break;

		case 5:
			return;
		
		}
	}
		while (choice!=5);
		
		
		
}
}