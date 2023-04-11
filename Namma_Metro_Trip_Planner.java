import java.io.*;
import java.util.*;

class Namma_Metro_Trip_Planner
{

	
	// Public variables
	public static float fare = 0.0f;
	public static int depart, arrLine, arrival, lineSelect, platform, transitDepart, departTemp;
	public static boolean changeLines = false;
	public static String departingStn, arrivalStn, towards;
	public static char departing,arriving;
	
		// Staion names in String array - array names are Lines
		
		public static String purp[] = {"Baiyapanahalli","Swami Vivekananda Road","Indiranagar","Halasuru","Trinity","Mahatma Gandhi Road","Cubbon Park","Dr. B.R. Ambedkar Stn., Vidhana Soudha","Sir M. Visveshwaraya Stn., Central College","Nadaprabhu Kempegowda Stn., Majestic","Krantivira Sangolli Rayanna, Railway Station","Magadi Road","Sri. Balagangadharanatha Swamiji Stn., Hosahalli","Vijaynagar","Attiguppe", "Deepanjali Nagar","Mysuru Road","Nayandahalli","Rajarajeshwari Nagar","Jnanabharathi","Pattanagere","Kengeri Bus Terminal","Kengeri"};
		public static String green[] = {"Nagasandra","Dasarahalli","Jalahalli","Peenya Industry","Peenya","Goraguntepalya","Yeshwanthpur","Sandal Soap Factory","Mahalakshmi","Rajajinagar","Mahakavi Kuvempu Road","Srirampura","Mantri Square - Sampige Road","Nadaprabhu Kempegowda Stn., Majestic","Chickpete","Krishna Rajendra Market","National College","Lalbagh","South End Circle","Jayanagar","Rashtreeya Vidyalaya Road","Banashankari","Jaya Prakash Nagar","Yelachenahalli","Konanakute Cross","Doddakallasandra","Vajarahalli","Thalaghattapura","Silk Institute"};
		
		public static String impPurp[] = {};

	static Scanner sc = new Scanner(System.in);
	
	static void stationList(int lineSelect) // Called when user selects departure line and method displays list of dept. stns.
	{
				if(lineSelect == 1) //Purple Line Selection
		{
				for(int i = 1; i <= purp.length ; i++)
				System.out.println(i+" - "+purp[i - 1]);
		}
		
				if(lineSelect == 2) //Green Line Selection
		{
				for(int i = 1; i <= green.length ; i++)
				System.out.println(i+" - "+green[i - 1]);
		}
	} //method stationList() ends here...
	
	
	/*
		Main function contains - (i) Language Selection
	 
	 
	 */
	public static void main(String args[]) //main function
	{
		 int choi, lang, lineSelect;
		
		System.out.println("Welcome to Namma Metro Fare Calculator and Trip Planner");
		
		/*
		System.out.println("\nSelect Language: \n1.Kannada\n2.English");
		System.out.println("\nEnter Choice: ");
		lang = sc.nextInt();
		*/
		
		//switch(lang)
		//{
				//case 1;
				eng();
		//}
	
	
	}
	
	/*
		English Lang. method
		
		Step 1: User is requested to select a line (Purple / Green), this selection calls stationList method to
		display available station in requested line.
		
		Step 2: From the list of available stations, the user is requested to select a departure station
				
				Purple Line - case 1, Green Line - Case 2
				
				
				In Case 1: departing is set to 'P'
							& departingStn String is assigned to the departing stn. name
	 
	 */
	
	static void eng()
	{
			System.out.println("\n\n--------------------");
			System.out.println("\nSelect Departing Line: ");
			System.out.println("\n1. Purple Line (23 stns.)");
			System.out.println("2. Green Line (29 stns.)");

			
			do
			{
				System.out.print("\nEnter Choice: ");	
				lineSelect = sc.nextInt();
			}while(lineSelect <1 || lineSelect > 2 || lineSelect == 0);
			
			switch(lineSelect)
			{ // 1st switch-case for departure
					case 1: System.out.println("\nChoose Departing Station: ");
					stationList(lineSelect);

					departing = 'P';
					
					do
				{
					System.out.print("\nSelect Departing Station: ");
					depart = sc.nextInt();
				}while(depart < 1 || depart > 23 || depart == 0);
					
					departTemp = depart;
					
					departingStn = purp[depart - 1];
					
					System.out.println("\n\nChoose Arrival Line: ");
					System.out.println("\n1. Purple Line (23 stns.)");
					System.out.println("2. Green Line (29 stns.)");
					
					do
				{
					System.out.print("\nArrival Line: ");
					arrLine = sc.nextInt();
				}while(arrLine < 1 || arrLine > 2 || arrLine == 0);
				
					switch(arrLine)
					{ //2nd switch-case arrival
						case 1: stationList(arrLine);
								arriving = 'P';
								break;
								
						case 2: stationList(arrLine);
								arriving = 'G';
								break;
								
						default: System.out.println("Wrong");	
					}
					
					if(arrLine == 2)
					changeLines = true;
					
					System.out.print("\nSelect Arrival Station: ");					
					arrival = sc.nextInt();
					
					if(arrLine == 1)
					{
						if(depart < arrival)
					{
						towards = "Kengeri / Mysuru Road";
						platform = 2;
					}
	
						else
						{
						towards = "Baiyapanahalli";
						platform = 1;
						}
						
						arrivalStn = purp[arrival - 1];
					}
					
					else if(arrLine == 2)
					{
						if(depart < arrival)
					{
						towards = "Silk Institute / Yelechenahalli";
						platform = 2;
					}
					
						else
					{
						towards = "Nagasandra";
						platform = 1;
					}
						arrivalStn = green[arrival - 1];
					}
					
					fareCalc(depart, arrival);
					
					break; // breaking case 1 - Purple Line
					
					
					case 2: System.out.println("\nChoose Departing Station: ");
					stationList(lineSelect);

					departing = 'G';
					
					do
					{
						System.out.print("\nSelect Departing Station: ");
						depart = sc.nextInt();
					}while(depart < 1 || depart > 29 || depart == 0);
					departTemp = depart;
					
					departingStn = green[depart - 1];
					
					System.out.println("\n\nChoose Arrival Line: ");
					System.out.println("\n1. Purple Line (23 stns.)");
					System.out.println("2. Green Line (29 stns.)");
					
					do
				{
					System.out.println("Arrival Line: ");
					arrLine = sc.nextInt();
				}while(arrLine < 1 || arrLine > 2 || arrLine == 0);
				
				
					switch(arrLine)
					{ //3rd nested-switch, checks arrival line...
						case 1: stationList(arrLine);
								arriving = 'P';
								break;
								
						case 2: stationList(arrLine);
								arriving = 'G';
								break;
								
						default: System.out.println("Wrong");	
					}
					
					if(arrLine == 1)
					changeLines = true;
					
					System.out.print("\nSelect Arrival Station: ");					
					arrival = sc.nextInt();
					
					if(arrLine == 1)
					{
						if(depart < arrival)
					{
						towards = "Kengeri / Mysuru Road";
						platform = 2;
					}
	
						else
						{
						towards = "Baiyapanahalli";
						platform = 1;
						}
							
						arrivalStn = purp[arrival - 1];
					}
					
					else if(arrLine == 2)
					{
						if(depart < arrival)
					{
						towards = "Silk Institute / Yelechenahalli";
						platform = 2;
					}
					
						else
					{
						towards = "Nagasandra";
						platform = 1;
					}
						arrivalStn = green[arrival - 1];
					}
					
					fareCalc(depart, arrival);
					
					break; // breaking case 2 - Green Line
					
					
			}
						
					}	
							static void fareCalc(int depart, int arrival)
							{ //fare calculator...
								
								int stnsToCross = 0;
							if(departing == arriving)
							stnsToCross = Math.abs(depart - arrival);
							
							else if(departing == 'P' && arriving == 'G')
							{
									if(arrival < 14 || arrival > 14)
									stnsToCross = Math.abs(depart - 10) + Math.abs(arrival - 14);
							}
							
							else if(departing == 'G' && arriving == 'P') //cont
							{
									if(arrival < 10 || arrival > 10)
									stnsToCross = Math.abs(depart - 14) + Math.abs(arrival - 10);
							}
							
							if(stnsToCross == 1)
							fare = 10;
							
							else if(stnsToCross == 2 || stnsToCross == 3)
							fare = 15;
							
							else if(stnsToCross == 4)
							fare = 18;				
							
							else if(stnsToCross == 5)
							fare = 20;
				
							else if(stnsToCross == 7)
							fare = 22;
							
							else if(stnsToCross == 8)
							fare = 28;
							
							else if(stnsToCross == 9)
							fare = 30;
							
							else if(stnsToCross == 10)
							fare = 30;
							
							else if(stnsToCross == 11 || stnsToCross == 12)
							fare = 35;
							
							else if(stnsToCross == 13)
							fare = 38;
							
							else if(stnsToCross == 14)
							fare = 40;																																
							
							else if(stnsToCross == 15)
							fare = 42;
							
							else if(stnsToCross == 16 || stnsToCross == 17)
							fare = 45;
							
							else if(stnsToCross == 18 || stnsToCross == 19)
							fare = 50;
							
							else if(stnsToCross == 20)
							fare = 52;
							
							else if(stnsToCross == 21)
							fare = 55;
							
							else if(stnsToCross == 22)
							fare = 58;
							
							else if(stnsToCross == 23 || stnsToCross == 24 || stnsToCross == 25 || stnsToCross == 26 || stnsToCross == 27 || stnsToCross == 28)
							fare = 60;
									
									else if(depart == arrival)
									{
											System.out.println("\nYou're already at "+departingStn+"!");
											System.out.println("Try Again!");
											System.exit(0);
									}
							else
							System.out.println("\nSomething's not right!");
							 
							 //public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
							
							//System.out.println("\nDeparting: "+depart+"\nArrival: "+arrival);
							System.out.println("---------------------------------------------------");
							System.out.println("Departing from: "+departingStn+" \nArrival at: "+arrivalStn+"\n"+"Stations to Cross: "+stnsToCross+"\n\nTotal Trip Time approx.: "+(stnsToCross * 2)+" - "+((stnsToCross * 2)+5)+" mins "+"\nFare (Token) Rs.= "+fare+"\nFare (SmartCard) Rs.= "+(fare-(fare*0.05)));
							System.out.println("---------------------------------------------------");
							System.out.println("\nRoute:");
							if(departing == arriving)
							System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");

							route();
							System.out.println("\n---------------------------------------------------");
						}
						
						static void route()
						{
							
						if(departing == 'G' && arriving == 'G') //Printing Stn. names when both Departure and Arrival is at Green Lines.
						{
							if(depart - 1 < arrival - 1)
							{
								
							while(depart - 1 < arrival - 1)
							{
								System.out.print(" "+green[depart - 1]+" -->");
								depart++;
							}
						
						System.out.print(" "+arrivalStn);
							}
						
						if(depart - 1 > arrival)
						{
						while(depart - 1 > arrival - 1)
						{
							System.out.print(" "+green[depart - 1]+" -->");
							depart--;	
							
						}
						System.out.print(" "+arrivalStn);
					}
				}
				
						else if(departing == 'G' && arriving == 'P')//Printing Stn. names when Departure is from G line and Arrival is at P Line.
						{
							transitDepart = 9; // Majestic array
								//printing greenLine station till Majestic
								
						
										if(departTemp - 1 <= 13) // Checking for departures at and before Sampige Road
									{ 
										
										if(departTemp >=15) //Departures at and after Chickpete towards Nagasandra
										{
											towards = "Nagasandra";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
										}
										if(departTemp<=13) //Departures at and after Sampige Road towards Silk Institute
										{
											towards = "Silk Institute / Yelechenahalli";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										}
										
										
										while(departTemp - 1 <= 13)
										{
											System.out.print(" "+green[departTemp - 1]+" -->"); //Priniting stns. in ascending order if <=
											departTemp++;
											
										}
								System.out.println("\n\nChange at Nadaprabhu Kempegowda Stn., Majestic, for the Purple Line");
								
										
										if(arrival >=11)
										{
											towards = "Kengeri / Mysuru Road";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										
										
										
										while(transitDepart < arrival - 1) // Printing from Majestic to Arrival in ascending
										{
											System.out.print(" "+purp[transitDepart]+" -->");
											transitDepart++;
											
										}
										
										System.out.print(" "+arrivalStn);
										
										}
										
										if(arrival<=9)
										{
											towards = "Baiyapanahalli";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
											//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
											
										while(transitDepart > arrival - 1) //Printing from Majestic to Arrival in Descending
										{
											System.out.print(" "+purp[transitDepart]+" -->");
											transitDepart--;
											
										}
										
										System.out.print(" "+arrivalStn);
										}
										
										
									}
											
										
										if(depart - 1 >= 13) //Checking for departures at and after Chickpete
									{
										//System.out.println("Depart now equals:: "+depart);
										//System.out.println("\nThis is being executed... >=14");
										
										if(depart >=15)
										{
											towards = "Nagasandra";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
										}
										if(depart<=13)
										{
											towards = "Silk Institute / Yelechenahalli";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										}
										
										
										while(depart - 1 >= 13) //Example of Jayanagar to Majestic
										{
											System.out.print(" "+green[depart - 1]+" -->");
											depart--;
											
										}
								System.out.println("\n\nChange at Nadaprabhu Kempegowda Stn., Majestic, for the Purple Line");
								
										
										if(arrival >=11)
										{
											towards = "Kengeri / Mysuru Road";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										
										
										//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
										
										while(transitDepart < arrival - 1) //Priting from Majestic to Arrival purp
										{
											System.out.print(" "+purp[transitDepart]+" -->");
											transitDepart++;
											
										}
										
										System.out.print(" "+arrivalStn);
										
										}
										
										if(arrival<=9)
										{
											towards = "Baiyapanahalli";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
											//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
											
										while(transitDepart > arrival - 1) //Prinitng from Majestic to Arrival purp in descending
										{
											System.out.print(" "+purp[transitDepart]+" -->");
											transitDepart--;
											
										}
										
										System.out.print(" "+arrivalStn);
										}
										
									}				
						}
						
					
												else if(departing == 'P' && arriving == 'G')//cont
						{
							transitDepart = 13; // Majestic array
								//printing purpLine station till Majestic
								
						
										if(departTemp - 1 <= 9) // Checking for departures at and before Central Clg.
									{ 
										
										if(departTemp >=11) //Departures at and after Chickpete towards Nagasandra
										{
											towards = "Baiyapanahalli";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
										}
										if(departTemp<=9) //Departures at and after Sampige Road towards Silk Institute
										{
											towards = "Kengeri / Mysuru Road";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										}
										
										
										while(departTemp - 1 <= 9)
										{
											System.out.print(" "+purp[departTemp - 1]+" -->"); //Priniting stns. in ascending order if <=
											departTemp++;
											
										}
								System.out.println("\n\nChange at Nadaprabhu Kempegowda Stn., Majestic, for the Green Line");
								
										
										if(arrival >=15)
										{
											towards = "Silk Institute / Yelechenahalli";
											platform = 4;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										
										
										
										while(transitDepart < arrival - 1) // Printing from Majestic to Arrival in ascending
										{
											System.out.print(" "+green[transitDepart]+" -->");
											transitDepart++;
											
										}
										
										System.out.print(" "+arrivalStn);
										
										}
										
										if(arrival<=13)
										{
											towards = "Nagasandra";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
											//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
											
										while(transitDepart > arrival - 1) //Printing from Majestic to Arrival in Descending
										{
											System.out.print(" "+green[transitDepart]+" -->");
											transitDepart--;
											
										}
										
										System.out.print(" "+arrivalStn);
										}
										
										
									}
											
										
										if(depart - 1 >= 9) //Checking for departures at and after KSR Stn.
									{
										//System.out.println("Depart now  equals:: "+depart);
										//System.out.println("\nThis is being executed... >=14");
										
										if(depart >=11)
										{
											towards = "Baiyapnahalli";
											platform = 1;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
										}
										if(depart<=9)
										{
											towards = "Kengeri / Mysuru Road";
											platform = 2;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										}
										
										
										while(depart - 1 >= 9) //Example of 
										{
											System.out.print(" "+purp[depart - 1]+" -->");
											depart--;
											
										}
								System.out.println("\n\nChange at Nadaprabhu Kempegowda Stn., Majestic, for the Green Line");
								
										
										if(arrival >=15)
										{
											towards = "Silk Institute / Yelechenahalli";
											platform = 4;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
										
										
										//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
										
										while(transitDepart < arrival - 1) //Priting from Majestic to Arrival green
										{
											System.out.print(" "+green[transitDepart]+" -->");
											transitDepart++;
											
										}
										
										System.out.print(" "+arrivalStn);
										
										}
										
										if(arrival<=13)
										{
											towards = "Nagasandra";
											platform = 3;
											System.out.println("\nBoard trains going towards "+towards+" from Platform No. "+platform+"\n");
											
											//System.out.println("\nTransit Deprt: "+purp[transitDepart]);
											
										while(transitDepart > arrival - 1) //Prinitng from Majestic to Arrival green in descending
										{
											System.out.print(" "+green[transitDepart]+" -->");
											transitDepart--;
											
										}
										
										System.out.print(" "+arrivalStn);
										}
										
									}				
						}
						

						
						
						
						
						
						
						if(departing == 'P'  && arriving == 'P')
						{
							if(depart - 1 < arrival)
							{
								
							while(depart - 1 < arrival - 1)
							{
								System.out.print(" "+purp[depart - 1]+" -->");
								depart++;
							}
						
						System.out.print(" "+arrivalStn);
							}
						
						if(depart - 1 > arrival)
						{
						while(depart - 1 > arrival - 1)
						{
							System.out.print(" "+purp[depart - 1]+" -->");
							depart--;	
							
						}
						System.out.print(" "+arrivalStn);
					}
				}
					

					}
					
	
	

}


