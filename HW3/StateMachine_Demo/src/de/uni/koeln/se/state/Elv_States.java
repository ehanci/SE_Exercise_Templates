package de.uni.koeln.se.state;

import java.util.concurrent.TimeUnit;

public class Elv_States {
	
	public  String Moving_up = "Moving_up";
	public  String Moving_down = "Moving_down";
	public  String Determining_movement = "Determining_movement";
	public  String Arrival = "Arrival";
	public	String Checking_validity = "Checking_input_validity";
	public  String Current_State;
	
	public boolean check_input_validity(int dest_floor) {
		Current_State = Checking_validity;
		System.out.println("Current State: " + Current_State);
		if((dest_floor < 0) || (dest_floor > 10)) {
			return false;
		}
		
		return true;
	}
	
	public void movement(int dest_floor){
		Current_State = Determining_movement;
		System.out.println("Current State: " + Current_State);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int direction = Elevator.current_Floor - dest_floor;
		if(direction < 0) {
			Current_State = Moving_up;
			System.out.println("Current State :" + Current_State);
			moving_up(dest_floor);
		}
		if(direction > 0) {
			Current_State = Moving_down;
			System.out.println("Current State: " + Current_State);
			moving_down(dest_floor);
		}
		if(direction == 0) {
			Current_State = Arrival;
			System.out.println("Current State: " + Current_State);
			System.out.println("Sie befinden sich bereits in der Zieletage!");
		}
		
		
	}
	
	public void moving_up(int dest_floor) {
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dest_floor != Elevator.current_Floor) {
			System.out.println("Moving up" + " to floor " + (Elevator.current_Floor+1));
			Elevator.current_Floor = Elevator.current_Floor+1;
			moving_up(dest_floor);
		}
		Current_State = Arrival;	
		
	}
	
	public void moving_down(int dest_floor) {
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dest_floor != Elevator.current_Floor) {
			System.out.println(Moving_down + " to floor " + (Elevator.current_Floor-1));
			Elevator.current_Floor = Elevator.current_Floor-1;
			moving_down(dest_floor);
		}
		Current_State = Arrival;
		
	}


	
	
}
