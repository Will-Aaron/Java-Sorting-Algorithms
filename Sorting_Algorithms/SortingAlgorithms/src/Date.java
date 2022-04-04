
public class Date implements Comparable<Date>{

	public int year;
	public int month;
	public int day;
	//Keep in mind these aren't determined as public or private, testing out what happens if they aren't listed as such
	
	public Date(int yr, int mnth, int dy) {
		day = dy; month = mnth; year = yr;
	}
	
	public void set_date(int yr, int mnth, int dy) {
		day = dy; month = mnth; year = yr;
	}
	
	public int year() { return year;}
	public int month() {return month;}
	public int day() {return day;}
	
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	

	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		if (this.year > o.year){ return 1;}
		if (this.year < o.year) {return -1;}
		if (this.month > o.month) { return 1;}
		if (this.month < o.month) { return -1;}
		if (this.day > o.day) { return 1;}
		if (this.day < o.day) { return -1;}
		return 0;
	}
	
	

}
