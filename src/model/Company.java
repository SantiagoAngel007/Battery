package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
		int counterB = 0;
		int counterR = 0;
		int counterF = 0;
		if(batteries != null){
			for(int i=0; i< MAX_BATTERIES; i++){
				if (batteries[i] instanceof RechargeableBattery){
					counterR++;
                }
			}
		}
		
		if(batteries != null){
			for(int i=0; i< MAX_BATTERIES; i++){
				if (batteries[i] instanceof Battery){
					counterB++;
                }
			}
		}
		
		
		counterF = counterB - counterR;
		
    	return "Normal Batterys = "+ counterF + " Rechargeable Battery = " + counterR + "\n"  ;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
		for (int i = 0; i<MAX_BATTERIES; i++){
			
			if (batteries[i]!=null){
				str += batteries[i].toString() + "\n";
			}
			
			
		}
    	return str;
    }
    
	
	public double calculateUsefulPromLifeCost(){
		double num = 0;
		//double 
		for (int i = 0; i<MAX_BATTERIES; i++){
			if (batteries[i]!=null){
				if (batteries[i] instanceof RechargeableBattery){
				num += ((RechargeableBattery)(batteries[i])).calculateusefulLifeCost();
				}
			}
		}
		
		return num;
	}
	
	
	public double calculateAverage(){
		
		double average = (calculateUsefulPromLifeCost())/(getAmountOfBatterys());
		
		return average;
	}
	
	
	public int getAmountOfBatterys(){
		int counter = 0;
		if(batteries != null){
			for(int i=0; i< MAX_BATTERIES; i++){
				if (batteries[i] instanceof Battery){
					counter++;
                }
			}
		}
		return counter;
	}
	
	
	
	
}
