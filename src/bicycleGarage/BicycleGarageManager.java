package bicycleGarage;

import java.time.Instant;
import java.util.Timer;

import interfaces.*;

public class BicycleGarageManager {
	
	BarcodePrinter printer;
	ElectronicLock entryLock;
	ElectronicLock exitLock;
	PinCodeTerminal terminal;
	StringBuilder code;
	Instant firstChar;

	public BicycleGarageManager() {
		code = new StringBuilder();
		
	}

	public void registerHardwareDrivers(BarcodePrinter printer,
			ElectronicLock entryLock, ElectronicLock exitLock,
			PinCodeTerminal terminal) {
		this.printer = printer;
		this.entryLock = entryLock;
		this.exitLock = exitLock;
		this.terminal = terminal;
	}

	public void entryCharacter(char c) {
		if(code.length() == 0) {
			firstChar = Instant.now();
		} else if (firstChar.isBefore(Instant.now().minusSeconds(5))){
			firstChar = Instant.now();
			code = new StringBuilder();
			System.out.println("Too slow");
			terminal.lightLED(0, 2);
		}
		code.append(c);
		
		if(code.length() == 4){
			System.out.println(code.toString()); //Jämför med databas, om pinkod finns öppnas entryLock
			code = new StringBuilder();
		}
	}

	public void exitBarcode(String code) {
		// TODO Auto-generated method stub

	}

	public void entryBarcode(String code) {
		printer.printBarcode(code);
	}
	
}
