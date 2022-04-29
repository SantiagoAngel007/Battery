package model;


public interface Rechargeable{
	
	
	public double CalculateusefulLifeCost(){
		if(type='l'){
		double calculate = (super.cost*super.getVoltage*super.getCapacity)/(1000*chargerNumber*ACTOR_LITIO);
		
		
		}else{
		double calculate = (super.getCost()*super.getVoltage()*super.getCapacity())/(1000*chargerNumber*FACTOR_NIQUEL_CADIO);
		}
		
		return calculate;
		
	}
	
	
}