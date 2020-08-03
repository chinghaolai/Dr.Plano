import java.util.Arrays;

public class SchedulingAlgorithm {

	public SchedulingAlgorithm() {
		// TODO Auto-generated constructor stub
	}
	
	//Check time overlapping
	public boolean CheckAviable(boolean[] JobList, Shift[] Shifts, int S) {
		boolean Aviable = true;
		for(int i=0; i<JobList.length; i++) {
			if(JobList[i]) {
				if (Shifts[i].end.compareTo(Shifts[S].start)==-1 || Shifts[i].start.compareTo(Shifts[S].end)==1) { // Would not be overlapped
					continue;
				}
				else {
					Aviable = false;
					break;
				}
			}
		}
		return Aviable;
	}
	
	public void AssignShift(Employee[] Employees, Shift[] Shifts) {
		boolean[][] JobList = new boolean [Employees.length][Shifts.length];
		double[] GetEarnings = new double[Employees.length]; 	// Current earnings for each employee
		int[] Assign_num = new int[Employees.length]; 			// # of assigned shifts for each employee
		int toolow = 10;										// Criteria of get too low earnings
		int times = 5;											// How many times to check unfair
		int i, j;
		boolean[] assigned = new boolean[Shifts.length];

		for(i = 0; i < Shifts.length; i++) {
			outerloop:
			for(j = 0; j < Employees.length; j++) {
				
				if (Assign_num[j] == 0) {
					Shifts[i].assignedEmployee = Employees[j];
					JobList[j][i] = true;
					Assign_num[j] += 1;
					GetEarnings[j] += Shifts[i].hourlyEarnings * 2;
					System.out.println("Shift #: "+ i +" is assigned successfuly!");
					assigned[i] = true;
					break outerloop;
				}else if(Employees[j].desiredEarnings > GetEarnings[j]){
					boolean Aviable = CheckAviable(JobList[j], Shifts, i);
					if(Aviable) {
						Shifts[i].assignedEmployee = Employees[j];
						JobList[j][i] = true;
						Assign_num[j] += 1;
						GetEarnings[j] += Shifts[i].hourlyEarnings * 2;
						System.out.println("Shift #: "+ i +" is assigned successfuly!");
						assigned[i] = true;
						break outerloop;
					}
				}

			}
			if (assigned[i] == false) {
				System.out.println("Shifts # " + i + " cannot be assigned!");
			}
		}
		// Try to evenly assign shifts.
		for (int t=0; t<times; t++) {
			outerloop2:
			for(j = Employees.length - 1 ; j >=0 ; j--) {
				
				if(Employees[j].desiredEarnings - GetEarnings[j] > toolow) {
					for(i = 0; i < Employees.length; i++) {
						if(GetEarnings[i] - Employees[i].desiredEarnings > 0) {
							for(int k=0; k < Shifts.length; k++) {
								if(JobList[i][k] == true) {
									boolean Aviable = CheckAviable(JobList[j], Shifts, k);
									if(Aviable) {
										GetEarnings[i] -= Shifts[k].hourlyEarnings * 2;
										GetEarnings[j] += Shifts[k].hourlyEarnings * 2;
										JobList[i][k] = false;
										JobList[j][k] = true;
										Shifts[k].assignedEmployee = Employees[j];
										break outerloop2;
									}
								}
							}
							
						}
							
					}
				}
			}
		}

		System.out.println("================================================");
		for(j = 0; j < Employees.length; j++) {
			System.out.println("------------------------------------------------");
			System.out.println("Employee name: " + Employees[j].name + "\nDesired earnings(Euros): " + Employees[j].desiredEarnings + "\nWill get earnings(Euros): " + GetEarnings[j]);
		}
		System.out.println("------------------------------------------------");
		System.out.println("================================================");
		for (i=0; i<Shifts.length; i++) {
			System.out.println("------------------------------------------------");
			System.out.println("Shift #: " + i);			
			System.out.println("Assigned employee name: " + Shifts[i].assignedEmployee.name);
		}
		System.out.println("================================================");
	}

}
