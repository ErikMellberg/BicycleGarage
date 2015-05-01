package bicycleGarage;

import interfaces.*;

public class BicycleGarageManager {
	
	BarcodePrinter printer;

	public BicycleGarageManager() {
		
	}

	public void registerHardwareDrivers(BarcodePrinter printer,
			ElectronicLock entryLock, ElectronicLock exitLock,
			PinCodeTerminal terminal) {
		this.printer = printer;
	}

	public void entryCharacter(char c) {
		System.out.println(c);
	}

	public void exitBarcode(String code) {
		// TODO Auto-generated method stub

	}

	public void entryBarcode(String code) {
		printer.printBarcode(code);
	}
}
