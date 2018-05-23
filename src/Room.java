

import java.util.Comparator;


public class Room {

    String fName;
    //private String mainName;
    int guests;
    int roomNo;

    public Object getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getgstRoom() {
        return guests;
    }

    public void setgstRoom(int gstRoom) {
        this.guests = gstRoom;
    }

    public int getroomNo() {
        return roomNo;
    }

    public void setroomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    
    public static Comparator<Room> Comparator = new Comparator<Room>(){
    	
    	public int compare(Room o1, Room o2){
    		
    		return ((String) o1.getfName()).compareTo((String) o2.getfName());
    	}
    	
    };

	
}
    
    
   