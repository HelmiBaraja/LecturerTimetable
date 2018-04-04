package main;

public class ClassRoomModel {
	private int id;

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
	public int getSizeIndex() {
		return size;
	}
	public String getSizeString() {
		return Size.sizes[getSizeIndex()];
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public ClassRoomModel(String roomNo, int size) {
		super();
		this.roomNo = roomNo;
		this.size = size;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String roomNo;
	private int size;
	
	public static class Size{
		public final static  String[] sizes = { "Small","Medium","Big"};
		public final static int SMALL = 0;
		public final static int MEDIUM = 1;
		public final static int BIG = 2;

	}
}
