import java.util.*;


/**
 * @author nitin 
 *
 */
class Simulation
{
	
	
	
	int numberOfFloors ; 			// floor numbers will be from 0 to numberOfFloors-1
	int numberOfElevators ;
	int totalTime;					//time for which simulation will run
	static int AmountOfPeople;              //states how many people are to be using the lifts over a certain time frame
        int peopleTraffic;

        int amountOfPeopleLeft;                  //used to check if the another person in the simlulation can be added
                
        private List<Floor> floorList = new ArrayList<Floor>(numberOfFloors);
	private List<Elevator> elevatorList = new ArrayList<Elevator>(numberOfElevators);
	private LinkedList<Event> eventsQueue = new LinkedList<Event>();
	
	private Statistics statistics = new Statistics();		//initially everything is 0

	
	/**
	 * @param numberOfFloors
	 * @param numberOfElevators
	 * @param totalTime
	 */
	public Simulation(int numberOfFloors, int numberOfElevators, int totalTime, int AmountOfPeople, int peopleTraffic)
	{
		super();
		this.numberOfFloors = numberOfFloors;
		this.numberOfElevators = numberOfElevators;
		this.totalTime = totalTime;
                this.AmountOfPeople = AmountOfPeople;
                this.peopleTraffic = peopleTraffic; 
                
	}


	/**
	 * @return floorList
	 */
	public List<Floor> getFloorList()
	{
		return floorList;
	}

	/**
	 * @return elevatorList
	 */
	public List<Elevator> getElevatorList()
	{
		return elevatorList;
	}

	/**
	 * @param floorList
	 */
	public void setFloorList(List<Floor> floorList)
	{
		this.floorList = floorList;
	}

	/**
	 * @param elevatorList
	 */
	public void setElevatorList(List<Elevator> elevatorList)
	{
		this.elevatorList = elevatorList;
	}

	/**
	 * @return eventsQueue
	 */
	public LinkedList<Event> getEventsQueue()
	{
		return eventsQueue;
	}

	/**
	 * @param eventsQueue
	 */
	public void setEventsQueue(LinkedList<Event> eventsQueue)
	{
		this.eventsQueue = eventsQueue;
	}

	/**
	 * @brief : create floors, elevators, and add an event of type ElevatorsChangeState in the event queue
	 */
	private void initialize()
	{
		createFloors();
		createElevators();
		Event event = new ElevatorsChangeState(elevatorList, floorList, statistics, numberOfFloors, numberOfElevators);
		eventsQueue.addFirst(event);
	}

	
	private void createFloors()
	{
		for (int floorNo = 0; floorNo < numberOfFloors; floorNo++)
		{
			Floor floor = new Floor();
			floor.setFloorNo(floorNo);
			floor.setUpButtonPressed(false);
			floor.setDownButtonPressed(false);

			floorList.add(floor);
		}
	}

	
	private void createElevators()
	{
		for (int elevatorNo = 1; elevatorNo <= numberOfElevators; elevatorNo++)
		{
			Elevator elevator = new Elevator();
			elevator.setElevatorNumber(elevatorNo);
			elevator.setCurrentFloorNo(0);
			elevator.setElevatorState(ElevatorState.stationary);

			elevatorList.add(elevator);
		}
	}

        //Event Returns null if the the stated amount of people is surpassed
	private Event generatePerson()
	{
            //Checks if the simulated number of people have been done, if not creates a person, else returns a null value. 
            if (Simulation.AmountOfPeople <= amountOfPeopleLeft) {
                
                Random randomNumber = new Random();
                //Peak Traffic start traffic
                if (peopleTraffic == 1){
                    
                    //*************TODO: Need to insert posisson distributioon at this point*****************
                    
                    Event newEvent = new PersonArrives();
                    Person person = new Person();
                    Floor floor = new Floor();
                    
                    int startFloor = 0;
                    int endFloor = randomNumber.nextInt((this.numberOfFloors+1));
                    
                    //this may need to change -> possible research needed 
                    int minLimit = this.numberOfFloors*3;
                    int maxLimit = this.numberOfFloors*5;
                    
                    int randomWaitingTime = randomNumber.nextInt(maxLimit - minLimit + 1) + minLimit;
                    
                    person.setSourceFloorNo(startFloor);
                    person.setDestinationFloorNo(endFloor);
                    person.setMaxWaitingTime(randomWaitingTime);
                    person.setTimePastInWaiting(0);

                    floor = floorList.get(startFloor);

                    ((PersonArrives) newEvent).setFloor(floor);
                    ((PersonArrives) newEvent).setPerson(person);

                    return newEvent;
                    
                }
                
                //peak end traffic 
                if (peopleTraffic == 2){
                    //*************TODO: Need to insert posisson distributioon at this point*****************
                    
                    Event newEvent = new PersonArrives();
                    Person person = new Person();
                    Floor floor = new Floor();
                    
                    int startFloor = randomNumber.nextInt((this.numberOfFloors+1));
                    int endFloor = 0;
                    
                    //this may need to change -> possible research needed 
                    int minLimit = this.numberOfFloors*3;
                    int maxLimit = this.numberOfFloors*5;
                    
                    int randomWaitingTime = randomNumber.nextInt(maxLimit - minLimit + 1) + minLimit;
                    
                    person.setSourceFloorNo(startFloor);
                    person.setDestinationFloorNo(endFloor);
                    person.setMaxWaitingTime(randomWaitingTime);
                    person.setTimePastInWaiting(0);

                    floor = floorList.get(startFloor);

                    ((PersonArrives) newEvent).setFloor(floor);
                    ((PersonArrives) newEvent).setPerson(person);

                    return newEvent;
                }
                
                //random traffic
                if (peopleTraffic == 3){
                    
                    //*************TODO: Need to insert posisson distributioon at this point*****************
                    
                    Event newEvent = new PersonArrives();
                    Person person = new Person();
                    Floor floor = new Floor();
                    
                    int startFloor = randomNumber.nextInt((this.numberOfFloors));
                    int endFloor = randomNumber.nextInt((this.numberOfFloors));
                    
                    //prevents start floor and end floor from being the same. 
                    while (startFloor == endFloor){
                        endFloor = randomNumber.nextInt((this.numberOfFloors));
                    }
                    
                    //this may need to change -> possible research needed 
                    int minLimit = this.numberOfFloors*3;
                    int maxLimit = this.numberOfFloors*5;
                    
                    int randomWaitingTime = randomNumber.nextInt(maxLimit - minLimit + 1) + minLimit;
                    
                    person.setSourceFloorNo(startFloor);
                    person.setDestinationFloorNo(endFloor);
                    person.setMaxWaitingTime(randomWaitingTime);
                    person.setTimePastInWaiting(0);

                    floor = floorList.get(startFloor);

                    ((PersonArrives) newEvent).setFloor(floor);
                    ((PersonArrives) newEvent).setPerson(person);

                    return newEvent;
                    
                }
                amountOfPeopleLeft++;
            } 
            
            return null;
	}
            
            
            
            //using poissons distribution
            
//            //please see for random number generator https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
//		Random generator = new Random();
//		double randomNumber = generator.nextDouble();
//                System.out.println(randomNumber);
//		//the probability of returning null is 0.5
//		if (randomNumber > 0.5)
//		{
//			return null;
//		}
//
//		
//		Event newEvent = new PersonArrives();
//		Person person = new Person();
//		Floor floor = new Floor();
//
//		/*
//		 * randomly generate source and destination floor of the person but 
//		 * ensure that both are different
//		 */
//		int sourceFloorNo = generator.nextInt(numberOfFloors);
//		int destinationFloorNo = generator.nextInt(numberOfFloors);
//		//Checks if the source and desitination are the same, otherwise assigns a new random number 
//                while (sourceFloorNo == destinationFloorNo)
//		{
//			destinationFloorNo = generator.nextInt(numberOfFloors);
//		}
//
//		
//		// for a person the maxWaitingTime can be in the range numberOfFloors*3 to numberOfFloors*5
//		int minLimit = this.numberOfFloors*3;
//		int maxLimit = this.numberOfFloors*5;
//		int maxWaitingTime = generator.nextInt(maxLimit - minLimit + 1) + minLimit;
//
//		
//		person.setSourceFloorNo(sourceFloorNo);
//		person.setDestinationFloorNo(destinationFloorNo);
//		person.setMaxWaitingTime(maxWaitingTime);
//		person.setTimePastInWaiting(0);
//
//		floor = floorList.get(sourceFloorNo);
//
//		((PersonArrives) newEvent).setFloor(floor);
//		((PersonArrives) newEvent).setPerson(person);
//
//		return newEvent;
            


	
	
	public void simulate()
	{
		int personNo = 1;
		initialize();

		for (int time = 0; time < totalTime;)
		{
			
			Event eventToExecute = eventsQueue.removeFirst();	//event queue will never be empty
			
			/*
			 * if event is not of type ElevatorsChangeState,
			 * after the execution of the event, a PersonArrives event will be 
			 * generated with probability of 0.5, and will be added to the front of the queue.
			 */
			if (!(eventToExecute instanceof ElevatorsChangeState))
			{
				if (eventToExecute instanceof PersonArrives)
				{
					((PersonArrives) eventToExecute).getPerson().setPersonNo(personNo);
					personNo++;
				}
				
				eventToExecute.happen();
				Event event = generatePerson();
				if (event != null)
				{
					eventsQueue.addFirst(event);
					statistics.setNoOfPersons(statistics.getNoOfPersons() + 1);
				}
			}
			
			
			/*
			 * if event is of type ElevatorsChangeState, it will always be only event in the queue
			 * after its execution, time will be incremented. and another event of same type will be 
			 * added to the queue.Then a PersonArrives event will be created with probability 0.5 and 
			 * will be added in front of the queue, for persons arriving at that moment.
			 * in the end, PersonsGiveUpAndLeave event will be added in the front of the queue
			 * for the persons who gave up in this time unit.
			 */
			else
			{
				time++;
				System.out.println();
				System.out.println("Time : " + (time ));
				eventToExecute.happen();
				
				Event elevatorNextChange = new ElevatorsChangeState(elevatorList, floorList, statistics, numberOfFloors, numberOfElevators);
				eventsQueue.addFirst(elevatorNextChange);
				Event event = generatePerson();
				if (event != null)
				{
					eventsQueue.addFirst(event);
					statistics.setNoOfPersons(statistics.getNoOfPersons() + 1);
				}
				Event personsGiveUp = new PersonsGiveUpAndLeave(floorList, statistics);
				eventsQueue.addFirst(personsGiveUp);
			}
		}
		
		//print final statistics
		System.out.println();
		System.out.println("Final statistics : ");
		statistics.printStatistics();
		
	}
	
	/**
	 * @param args : numberOfFloors, numberOfElevators, timeForSimulation
	 */
	public static void main (String [] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of floors.");
		int floors = scanner.nextInt();
		
		System.out.println("Enter number of elevators.");
		int elevators = scanner.nextInt();
		
		System.out.println("Enter time for simulation.");
		int timeForSimulation = scanner.nextInt();
                
                System.out.println("Please enter the amount of people in this time frame");
                int AmountOfPeople = scanner.nextInt();
                
                System.out.println("Please 1 for peak morning traffic, 2 for peak afternoon traffic, 3 for random traffic");
                int peopleTraffic = scanner.nextInt();
		
		Simulation simulation = new Simulation(floors,elevators,timeForSimulation, AmountOfPeople, peopleTraffic);
		simulation.simulate();
	}
	

}
