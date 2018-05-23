

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;



public class Main {
	public static String rmName;
	public static int rmNum = 0;
	public static Scanner input = new Scanner(System.in);
	public static Room[] myHotel = new Room[10];
	
	public static void main(String[] args) {

		System.out.println("--------Welcome to hotel IIT--------");

		
		

		
		myHotel[0] = new Room();    // 10 lines could go in loop
		myHotel[1] = new Room();
		myHotel[2] = new Room();
		myHotel[3] = new Room();
		myHotel[4] = new Room();
		myHotel[5] = new Room();
		myHotel[6] = new Room();
		myHotel[7] = new Room();
		myHotel[8] = new Room();
		myHotel[9] = new Room();

		
		initialise(myHotel);

		boolean mainrun = true;
		while (mainrun) {

			String inputKey ="";
		

				do{

					System.out.println("Enter 'A' to register a guest to a room.");
					System.out.println("Enter 'E' to Display Empty rooms.");
					System.out.println("Enter 'V' to Display all rooms");
					System.out.println("Enter 'D' to remove guest from room");
					System.out.println("Enter 'F' to search room from guest name");
					System.out.println("Enter 'S' to Store program data in to file");
					System.out.println("Enter 'L' to Load program data from file");
					System.out.println("Enter 'O' to view rooms Ordered alphabetically by name");
					System.out.println("other key : Exit");

					inputKey= input.next();


				
		// depending on the user inputs i use if else structure to call methods
		 	
		 
				if(inputKey.equals("a")){
					addguest();

				}

				if(inputKey.equals("v")){
					
					viewguest();
				}


				if(inputKey.equals("e")){

					emptyrooms();
				}
				
				if(inputKey.equals("d")){
					
					deleteGuest();
				}
				
				if(inputKey.equals("f")){
					
					findGuest();
				}
				
				if(inputKey.equals("o")){
					Order();
				}
				
				
		     }while(!(inputKey.equals("x")));
		}
	}
	
		public static void addguest (){
		System.out.println("Enter room number ");
		rmNum = input.nextInt();
		
		if(rmNum<1 || rmNum>10){
			System.err.println("Invalid Input");
		}
		else if (rmNum < 10) {
	//adding customer to (n-1) room 	
		myHotel[rmNum-1].setroomNo(rmNum);
		System.out.println("Enter name for room " + rmNum + " :");
		rmName = input.next();
		myHotel[rmNum-1].setfName(rmName);
		}
		}
		
			
		
	//view guest list
		public static void viewguest (){
		int y=0;
		for(int x=0;x<myHotel.length;x++){
			y=x+1;
			if (myHotel[x].getfName().equals("e")){   

				System.out.println("room " + y + " is empty");

			}
			else{
				System.out.println("room " + y + " is occupied by "+myHotel[x].getfName());

			}
		}
		}
		
		
		
	//view empty rooms
		public static void emptyrooms (){
		for (int x = 0; x < 10; x++) {
			int y=x+1;
			if (myHotel[x].getfName().equals("e")){             
				System.out.println("room " + y + " is empty");
			}
			
		}
		}

		private static void deleteGuest(){
			Scanner dg = new Scanner(System.in);
			//ask room number to delete customer
			System.out.println("Ënter room number to delete guest: ");
			int input = dg.nextInt();
			if (rmNum < 10) {
				
				myHotel[rmNum-1].setroomNo(rmNum);
				//System.out.println("Enter name for room " + rmNum + " :");
				rmName = dg.next();
				myHotel[rmNum-1].setfName("e");
				
				System.out.println("");
			}	
			System.out.println("");
		}
		
		private static void findGuest(){
			Scanner fg = new Scanner(System.in);
			System.out.println("Enter name to find: ");
			
			String Name = fg.next();
			for (int x=0; x<10; x++){
				if(myHotel[x].getfName().equals(Name)){
					System.out.println("Room "+x+" is taken by "+myHotel[x].getfName());
				}else{
					System.out.println("No guest in the room");
				}
			}
		}
		
		/*private static void Save(){
			String filename = "\\passenger.txt";
			
			File desktop = new File(System.getProperty("user.home"), "Desktop");
			String filePath = desktop + filename;
			System.out.println("File saved in desktop under name passenger.txt");
			File file = new File(filePath);

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			
				for (Room pass : myHotel) {
					if(pass.getfName()!=null && pass.getroomNo()!=null){
						bw.write(pass.getfName()+ " ");
						bw.write(pass.getroomNo()+ "");
						bw.newLine();
					}
				}
			
			bw.close();

			System.out.println("\nAll the data was successfully saved to a text file.\n");
		} */
		
		private static void Order(){
			for(int x = 0; x<myHotel.length;x++){
			Arrays.sort(myHotel,Room.Comparator);
			
			if(!(myHotel[x].getfName().equals("e"))){
				
				System.out.println(myHotel[x].getroomNo()+" taken by "+myHotel[x].getfName());
			}
			
			}
		}
		
		private static void initialise( Room hotelRef[] ) {
			for (int x = 0; x < 10; x++ )
				{
				hotelRef[x].setfName("e");
				}
			System.out.println( "initilise ");
		}
}