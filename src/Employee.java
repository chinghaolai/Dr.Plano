import java.util.Calendar;
import java.util.Comparator;

public class Employee {
	String name;
	double desiredEarnings;
	public Employee(String name, double desiredEarnings) {
		this.name = name;
		this.desiredEarnings = desiredEarnings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	public double getDesiredEarnings() {
		return desiredEarnings;
	}
	public void setDesiredEarnings(double desiredEarnings) {
		this.desiredEarnings = desiredEarnings;
	}
	public double compareTo(double desiredEarnings) {
		//ascending order
//		return (double)(this.desiredEarnings*100 - desiredEarnings*100);

		//descending order
		return (double)(desiredEarnings*100 - this.desiredEarnings*100);
	}
	public static Comparator<Employee> DesiredEarningsComparator = new Comparator<Employee>() {

		public int compare(Employee Employee1, Employee Employee2) {
		
			double getDesiredEarnings2 = Employee2.getDesiredEarnings();
			
			
			//descending order
			return (int)Employee1.compareTo(getDesiredEarnings2);
		}

	};
}
