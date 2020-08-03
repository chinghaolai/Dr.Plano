import java.util.*;

public class Shift {
	Calendar start;
	Calendar end;
	double hourlyEarnings;
	Employee assignedEmployee;
	public Shift(Calendar start, Calendar end, double hourlyEarnings, Employee employees) {
		this.start = start;
		this.end = end;
		this.hourlyEarnings = hourlyEarnings;
		this.assignedEmployee = employees;
	}
	public Calendar getStart() {
		return start;
	}
	public void setStart(Calendar start) {
		this.start =start;
	}
	public Calendar getEnd() {
		return end;
	}
	public void setEnd(Calendar end) {
		this.end = end;
	}
	public double getHourlyEarnings() {
		return hourlyEarnings;
	}
	public void setHourlyEarnings(double hourlyEarnings) {
		this.hourlyEarnings = hourlyEarnings;
	}

	public double compareTo(double compareHourlyEarnings) {
		//ascending order
//		return (double)(this.hourlyEarnings*100 - compareHourlyEarnings*100);

		//descending order
		return (double)(compareHourlyEarnings*100 - this.hourlyEarnings*100);
	}
	public static Comparator<Shift> HourlyEarningsComparator = new Comparator<Shift>() {

		public int compare(Shift Shift1, Shift Shift2) {
		
			double hourlyEarnings2 = Shift2.getHourlyEarnings();
			
			//ascending order
			//return (int)Shift1.compareTo(hourlyEarnings2);
			
			//descending order
			return (int)Shift1.compareTo(hourlyEarnings2);
		}

	};
	
}
