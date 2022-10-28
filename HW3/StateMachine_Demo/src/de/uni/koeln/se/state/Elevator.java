package de.uni.koeln.se.state;

import de.uni.koeln.se.main.Main;

public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
		this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	arrive_atFloor(this.dest_Floor);


	}

	private void arrive_atFloor(int dest_Floor) {
		boolean check = State.check_input_validity(dest_Floor);
		
		if(check ==true) {
			State.movement(dest_Floor);
			System.out.println("Current State: " + State.Current_State);
			System.out.println("Arrived at floor " + Elevator.current_Floor);
		}
		
		else {
			System.out.println("Floor "+ dest_Floor + " does not exist!");
		}
	}

	
}
