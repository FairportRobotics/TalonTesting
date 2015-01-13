package org.fairportfirst.frc2015.TalonTest.subsystems;

import org.fairportfirst.frc2015.TalonTest.commands.ExampleCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	CANTalon talonOne = new CANTalon(5);

	public ExampleSubsystem() {
		talonOne.changeControlMode(ControlMode.Speed);
		talonOne.setPID(0, 0, 0);
		talonOne.enableControl();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ExampleCommand());
	}

	public void setRegulatedSpeed(double speed) {

		if (talonOne.isControlEnabled()) {
			talonOne.set(speed);
		}else{
			talonOne.enableControl();
			talonOne.set(speed);
		}
	}
	
	public void setUnRegulatedSpeed(double speed){
		if(talonOne.isControlEnabled()){
			talonOne.disableControl();
			talonOne.set(speed);
		}else{
			talonOne.set(speed);
		}
	}

	public String getDeugInfo(){
		String s = "";
		
		s += "Talon Set Speed: " + talonOne.get() + " Encoder Speed: " + talonOne.getEncVelocity();
		
		return s;
	}
	
}
