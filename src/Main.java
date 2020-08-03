import java.util.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] argv) {
		RandomDate RD = new RandomDate();
		RandomValues RV = new RandomValues();
		
		// Setup variables of Employees
		int Employee_num = 10; 	// # of employees
		int desiredEarnings_max = 90; 	// Max desiredEarnings
		int desiredEarnings_min = 30; 	// Min desiredEarnings
		Employee[] Employees = new Employee[Employee_num]; 															// Create Employee objects
		String[] names = {"Allen","Eric","Howard","Masoud","Nils","Mui","Milad","Mary","Jenny","Gray"}; 			// Give employees' names
		double[] desiredEarnings = RV.get_random_values(desiredEarnings_min, desiredEarnings_max, Employee_num); 	// Get random earnings
		
		// Setup Employees objects
		for (int i=0; i<Employee_num; i++) {
			Employees[i] = new Employee(names[i], desiredEarnings[i]);
			
//			System.out.println(Employees[i].name);
//			System.out.println(Employees[i].desiredEarnings);
//			System.out.println("");
		}
		
		Arrays.sort(Employees, Employee.DesiredEarningsComparator); // Sort employees by DesiredEarnings
		
//		for(Employee temp: Employees){
//			   System.out.println(temp.getDesiredEarnings());
//		}
		
		//Setup variables of Shift
		int Shift_num = 40;																	// # of shifts
		int Shift_hours = 2;																// hours of each shift
		int hourlyEarnings_max = 10; 														// Max hourlyEarnings
		int hourlyEarnings_min = 5; 														// Min hourlyEarnings
		int[] start_date = {2020, 8, 1, 0, 0, 0}; 											// Shift start date
		int[] end_date = {2020, 8, 4, 23, 59, 59}; 											// Shift end date
		Shift[] Shifts = new Shift[Shift_num];												// Create Shift objects
		int[][] random_datetime = RD.get_random_datetime(start_date, end_date, Shift_num);	// Get random date array
		double[] hourlyEarnings = RV.get_random_values(hourlyEarnings_min, hourlyEarnings_max, Shift_num); 	// Get random earnings
		
		
		
		// Setup Shift objects
		Calendar[] datetime_start = new Calendar[Shift_num];
		Calendar[] datetime_end = new Calendar[Shift_num];
		for (int i=0; i<Shift_num; i++) {
			datetime_start[i] = Calendar.getInstance();
			datetime_end[i] = Calendar.getInstance();
			datetime_start[i].set(random_datetime[i][0], random_datetime[i][1], random_datetime[i][2], random_datetime[i][3], random_datetime[i][4], random_datetime[i][5]);
			datetime_end[i].set(random_datetime[i][0], random_datetime[i][1], random_datetime[i][2], random_datetime[i][3], random_datetime[i][4], random_datetime[i][5]);
			datetime_end[i].add(datetime_end[i].HOUR_OF_DAY, Shift_hours);
			Shifts[i]= new Shift(datetime_start[i], datetime_end[i], hourlyEarnings[i], Employees[0]);
						
//			System.out.println(Shifts[i].start.getTime());
//			System.out.println(Shifts[i].end.getTime());
//			System.out.println(Shifts[i].hourlyEarnings);
//			System.out.println("");
		}
		
		Arrays.sort(Shifts, Shift.HourlyEarningsComparator); // Sort shifts by HourlyEarnings
		
//		for(Shift temp: Shifts){
//		   System.out.println(temp.getHourlyEarnings());
//		}
		
		SchedulingAlgorithm SA = new SchedulingAlgorithm();
		SA.AssignShift(Employees, Shifts);
	}
}
