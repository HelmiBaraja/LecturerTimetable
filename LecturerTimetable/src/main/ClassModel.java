package main;

public class ClassModel {
	
	@Override
	public String toString() {
		return "ClassModel [roomNo=" + roomNo + ", size=" + size + "]";
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public ClassModel(String roomNo, int size) {
		super();
		this.roomNo = roomNo;
		this.size = size;
	}

	private String roomNo;
	private int size;
	
	class Size{
		public final static int SMALL = 1;
		public final static int MEDIUM = 2;
		public final static int BIG = 3;

	}
}
