/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

/**
 *
 * @author johnw_000
 */
public class AirCompressor {
	private Compressor air;
	
	AirCompressor(){
		air = new Compressor(1,8); //Compressor  io port 1, relay port 1
		air.start();
	}
	public void compress(){
		if(!air.getPressureSwitchValue()){//if the pressure switch value < 95psi
			air.setRelayValue(Relay.Value.kOn);//start the compressor
			//air.setRelayValue(Relay.Value.kForward);
			//System.out.println("true");
		}else{//pressure switch value >= 115psi
			air.setRelayValue(Relay.Value.kOff);//stop compressor
			//System.out.println("false");
		}
	}
	public boolean getPressureValue(){
		return air.getPressureSwitchValue();
	}
}
