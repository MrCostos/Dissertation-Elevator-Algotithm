/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class information {
    private String info ;
    private String FinalStats ;
    
    public String getInfo (){
        return info;
    }
    
    public String getFinalStats(){
        return FinalStats;
    }
    
    public void setFinalStats(String stats){
        this.FinalStats = stats;
    }
    
    public void setinfo(String newInfo){
        this.info = newInfo;
    }
}
