/**
 * @brief : Statistics of all the persons arrived, all those who gave up, and totalWaitingTime of others
 */
class Statistics
{
	private int noOfPersons;			//total number of persons arrived
	private int noOfPersonsGaveUp;		//total number of persons who gave up and left
	private int totalWaitingTime;		//total waiting time of the others
        private int floorDist;
        
        private int time;

        public static String returnText ;
	/**
	 * @return noOfPersons
	 */
	public int getNoOfPersons()
	{
		return noOfPersons;
	}

        public int getTime(){
            return time;
        }
	/**
	 * @return noOfPersonsGaveUp
	 */
	public int getNoOfPersonsGaveUp()
	{
		return noOfPersonsGaveUp;
	}

	/**
	 * @return totalWaitingTime
	 */
	public int getTotalWaitingTime()
	{
		return totalWaitingTime;
	}

	/**
	 * @param noOfPersons
	 */
	public void setNoOfPersons(int noOfPersons)
	{
		this.noOfPersons = noOfPersons;
	}

	/**
	 * @param noOfPersonsGaveUp
	 */
	public void setNoOfPersonsGaveUp(int noOfPersonsGaveUp)
	{
		this.noOfPersonsGaveUp = noOfPersonsGaveUp;
	}

	/**
	 * @param totalWaitingTime
	 */
	public void setTotalWaitingTime(int totalWaitingTime)
	{
		this.totalWaitingTime = totalWaitingTime;
	}

        public void setTime(int time){
            this.time = time;
        }
	/**
	 * @brief : initially everything is 0.
	 */
	public Statistics()
	{
		noOfPersons = 0;
		noOfPersonsGaveUp = 0;
		totalWaitingTime = 0;
	}

	
	public void printStatistics()
	{
            //information info = new information();
            returnText = "  Total Persons Entered : " + noOfPersons + "\n Total Number of Persons who gave up : "+ noOfPersonsGaveUp + "\n Total Waiting Time : "+ totalWaitingTime + "\n The total time that was used was " + time;
//            return returnText;
            System.out.println("" + returnText);
            //info.setFinalStats(returnText);
            //System.out.println("" + info.getFinalStats());
//            info.setinfo(info.getInfo() + returnText);
//		System.out.println("Total Persons Entered : "+ noOfPersons);
//		System.out.println("Total Number of Persons who gave up : "	+ noOfPersonsGaveUp);
//		System.out.println("Total Waiting Time : "+ totalWaitingTime);
//                System.out.println("The total time that was used was " + time);
	}
        
        //uses kinematics equation 
        // s= 0.5(u+v) t
        //rearranged to 
        // t = (2s) / (u+v)
        public int timeToCoverDist(int DistBetweenFloors, int initialVel, int currentVel){
            
            this.floorDist = DistBetweenFloors; 
            
            int timeToCover = (2* this.floorDist) / (initialVel + currentVel );
            
            return timeToCover;
        }

}