
package hqtest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import coverages.APDeductible;
import coverages.AdditionalCovAPercent;
import coverages.BaseRate;
import coverages.ConstructionType;
import coverages.CovSuper;
import coverages.CoverageA;
import coverages.CoverageB;
import coverages.CoverageC;
import coverages.CoverageD;
import coverages.CoverageE;
import coverages.CoverageF;
import coverages.OrdinanceCoveragePercentage;
import coverages.Plan;
import coverages.ProtDevBurglarAlarm;
import coverages.ProtDevSprinklers;
import coverages.ProtectionClass;
import coverages.Tier;
import coverages.Trampoline;
import coverages.WoodStove;

public final class Premium_Calculation {
    private static double Included_Coverage_Premium = 0.0;
    private static double Discount_Surcharge_Premium = 0.0;
    private static double Additional_Coverage_Premium = 0.0;
    private static double Total_Premium = 0.0;  
    
    
    
   
    
    
    private double RND(double Premium){        
        double RNDPremium = BigDecimal.valueOf(Premium).setScale(0, RoundingMode.HALF_UP).doubleValue();
        return RNDPremium;
    }
    
    
    public double CalcFac(double existingPremium, CovSuper coverageObject){
    	//CalcFac creates a new premium, which is then added to the existing premium after the value is returned.        
        double newPremium = existingPremium;         
    	newPremium = ((newPremium * coverageObject.getFactor()) - newPremium);    	
    	newPremium = BigDecimal.valueOf(newPremium).setScale(0, RoundingMode.HALF_UP).doubleValue();
    	//Round to nearest whole dollar.
    	return newPremium;
    }      
    
    
    
    
    
    
    public Premium_Calculation(CovSuper[] reg){
    	
        //--------------DECLARATIONS------------------
    	Included_Coverage_Premium = 0.0;
        Discount_Surcharge_Premium = 0.0;
        Additional_Coverage_Premium = 0.0;
        Total_Premium = 0.0;
        BaseRate Base_Rate = new BaseRate();
        ProtectionClass protClass = new ProtectionClass(); 
        Tier tier = new Tier();
        Plan plan = new Plan();
        CoverageA cova = new CoverageA();
        
        CoverageB covb = new CoverageB();
        CoverageC covc = new CoverageC();
        CoverageD covd = new CoverageD();
        
        
        
        
        CoverageE CovE = new CoverageE();
        CoverageF CovF = new CoverageF();
        
        APDeductible APDeductible = new APDeductible();
        OrdinanceCoveragePercentage Ordinance_Coverage_Percentage = new OrdinanceCoveragePercentage();
        ProtDevSprinklers sprinklers = new ProtDevSprinklers();
        
        
        ProtDevBurglarAlarm Alarms = new ProtDevBurglarAlarm();
        
        
        ConstructionType constType = new ConstructionType();
        
        AdditionalCovAPercent Additional_Coverage_Percentage = new AdditionalCovAPercent();
        WoodStove Wood_Stove = new WoodStove();
        Trampoline tramp = new Trampoline();
        
        
        double newPremium = 0.0;
        double BasePrem = 0.0;
        double AdjBasePrem = 0.0;
        
        //---------- END DECLARATIONS -------------------
        
        
        
        
        
        newPremium = RND(Base_Rate.getPremium());
        Base_Rate.setPremium(newPremium);
        
        newPremium = RND(newPremium * protClass.getFactor());
        protClass.setPremium(newPremium);
        
        newPremium = RND(newPremium * plan.getFactor());
        plan.setPremium(newPremium);
        
        newPremium = RND(newPremium * tier.getFactor());
        tier.setPremium(newPremium);
        
        
        
        newPremium = RND(newPremium * cova.getFactor());
        cova.setPremium(newPremium);
        
        Included_Coverage_Premium = newPremium;//Returns this newPremium for the total Coverage Premiums output. 
        BasePrem = newPremium;
        
        
       
        double Ordinance_Coverage_Percentage_Premium = CalcFac(BasePrem, Ordinance_Coverage_Percentage);
        Ordinance_Coverage_Percentage.setPremium(Ordinance_Coverage_Percentage_Premium);
        	
          
        
        AdjBasePrem = BasePrem;
        
        
        double Construction_Type_Premium = RND(CalcFac(AdjBasePrem, constType));
        constType.setPremium(Construction_Type_Premium);
        double Sprinklers_Premium = RND(CalcFac(AdjBasePrem, sprinklers));
        sprinklers.setPremium(Sprinklers_Premium);
        
        double Burglar_Alarm_Premium =  RND(CalcFac(AdjBasePrem, Alarms));
        Alarms.setPremium(Burglar_Alarm_Premium);
        
        
        double AP_Deductible_Premium = RND(CalcFac(AdjBasePrem, APDeductible));
        APDeductible.setPremium(AP_Deductible_Premium);
        
        
        Discount_Surcharge_Premium = Construction_Type_Premium + Sprinklers_Premium + Burglar_Alarm_Premium + AP_Deductible_Premium;
        Additional_Coverage_Premium += Wood_Stove.getPremium() + tramp.getPremium() + 
        		
        		
        		
        		
        		
        		
        	
        		covb.getPremium() + 
        		
        		covc.getPremium() + covd.getPremium() +
        		
                Ordinance_Coverage_Percentage.getPremium() + 
                Additional_Coverage_Percentage.getPremium() +                
                CovE.getPremium() + CovF.getPremium();

        
        Total_Premium = Included_Coverage_Premium + Discount_Surcharge_Premium + Additional_Coverage_Premium;
    }
    
    
    
    public static double getDiscountSurchargeTotal(){
        double prems = Discount_Surcharge_Premium;     
        return prems;
    }
    
    
    public static double getAdditionalPremiumTotal(){
        double prems = Additional_Coverage_Premium;       
        return prems;
    }
    
    
    public static double getCoveragesTotal(){        
        double prems = Included_Coverage_Premium;       
        return prems;
    }
    
    public static double getFinalTotal(){
        double prems = Total_Premium;
        return prems;
    }

    
    
}
