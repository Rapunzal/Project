import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int option;
		int subOption;
		System.out.println("                 Locked Me.com : File menu Application");
		System.out.println("                 Application Developer : Priyanka Gupta");
		//System.out.println("                 ---------------------------------------");
		do {
			System.out.println("                ======================================");
			System.out.println("Choose your option");
			System.out.println("1-Display your Current file name.");
			System.out.println("2-Display user interface.");
			System.out.println("3-Exit");
			try {
			option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				//System.out.println("Enter the directory path");
				//String path=sc.next();
				String path="/Users/rakesh";
				File file=new File(path);
				String[] listOfFile=file.list();
				if(listOfFile==null) {
					System.out.println("Path provided Is Empty or invalid");
				}else {
				System.out.println("Displaying files in ascending order.");
				System.out.println("=====================================");
				String tmp;
				for(int i=0;i<listOfFile.length;i++) 
				{
					for(int j=i+1;j<listOfFile.length;j++) 
					{
						if(listOfFile[i].compareTo(listOfFile[j])>0)
						{
							tmp=listOfFile[i];
							listOfFile[i]=listOfFile[j];
							listOfFile[j]=tmp;
						}
					}
				}
				for(String str:listOfFile) {
					System.out.println(str);
				}
				}
				break;
			}
			case 2:
			{
				do{
				System.out.println("Displaying user interface to add,delete and search");
				//Interface to perform various operations
				System.out.println("================================================");
				System.out.println("Choose operation to perfom on file");
				System.out.println("------------------------------------");
				System.out.println("4- Add the file");
				System.out.println("5-Delete the file");
				System.out.println("6-Search the file");
				System.out.println("7- Back to main menu");
				subOption=sc.nextInt();
				
				switch(subOption) 
				{
				case 4:
				{
					//Logic to add the input file
					System.out.println("Enter the file you want to add.");
					String fileName=sc.next();
					File obj=new File(fileName);
					try {
						if(obj.createNewFile()) {
							System.out.println("File Created");
						}
						else {
							System.out.println("File already exists");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("File not created");
						e.printStackTrace();
					}
					break;
				}
				case 5:
				{
					//Delete the file
					System.out.println("Enter the file name to delete");
					String fileName=sc.next();
					try {
						boolean result=Files.deleteIfExists(Paths.get(fileName));;
					if(result)
					{
						System.out.println("File successfully deleted.");
					}
					else 
					{
							System.out.println("file not found");
					} 
					}
					catch(NoSuchFileException e) 
					{
						System.out.println("File not found");
					}
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						System.out.println("Invalid permission.");
					}
					
					break;
				}
				case 6:
				{
					//Search the file
					System.out.println("Enter the file to be searched");
					String fileName=sc.next();
					File f=new File(fileName);
					if(f.exists()) {
						System.out.println("File found");
					}else {
						System.out.println("FIle not found");
					}
					break;
				}
				case 7:
				{
					//return to main menu
					System.out.println("returning to main menu..");
					break;
				}
				default:
				{
					System.out.println("Enter value between 4 to 7");
				}
				}
				System.out.println("-----------------------------");
				}while(true);
			
			}
			
			case 3:
			{
				System.out.println("Exitting the program");
				sc.close();
				return;
			}
			}
			
			}
	
			catch(InputMismatchException e) {
				System.out.println("Please enter a valid input");
				option=sc.nextInt();
			}catch(Exception e) {
				//System.out.println("Enter valid option value");
				//option=sc.nextInt();
			}
			
		}while(true);
		
	}

}
