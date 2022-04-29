package model;

public class RechargeableBattery extends Battery implements Rechargeable{
	
	public final static char BATTERY_LITIO = 'l';
	
	public final static char BATTERY_NIQUEL_CADIO = 'n';
	
	public final static double FACTOR_LITIO = 0.92;
	
	public final static double FACTOR_NIQUEL_CADIO =  0.80;
	
	private char type;
	
	private int chargerNumber;
	
	
	public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){
		
		super(name, voltage, cost, capacity);
		
		this.chargerNumber = chargerNumber;
		
		this.type = type;
		
		
	}
	
	@Override
	public double CalculateusefulLifeCost(){
		
		double calculate = 0;
		
		if(type=='l'){
		calculate = (super.getCost()*super.getVoltage()*super.getCapacity())/(1000*chargerNumber*FACTOR_LITIO);
		
		
		}else{
		calculate = (super.getCost()*super.getVoltage()*super.getCapacity())/(1000*chargerNumber*FACTOR_NIQUEL_CADIO);
		}
		
		return calculate;
		
	}
	
	
	public String toString() {
		return " name " + super.getName() + " voltage " + super.getVoltage() + " cost " + super.getCost() + " capacity " +  super.getCapacity() + " type " +  type + " chargerNumber " +  chargerNumber + "Calculate life cost" + CalculateusefulLifeCost();
	}




}