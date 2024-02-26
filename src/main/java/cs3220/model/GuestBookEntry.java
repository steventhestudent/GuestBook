package cs3220.model;

public class GuestBookEntry {
	private static int uuid = 0;
	public int id;
	public String name;
	public String msg;
	public GuestBookEntry(String _name, String _msg) {
		name = _name;
		msg = _msg;
		id = uuid++;
	}
}
