package assignment_3;

import java.util.*;

class EquipmentDetails{
	double equipmentValue[] = {80, 121, 1.80, 7, 25, 5, 120, 2, 114.26, 9.50, 5, 8, 19, 71.30, 13};
	String equipmentName[] = {"Life Jacket", "Box of food supply", "Litres of water", "Drinking vessel", "Fishing tackle", "Survival manual", "Compass","Bucket", "Hatchet", "Flare kit", "Electronic torch", "Whistle", "Tin opener", "Rescue quit", "SART", "Jack knife"};
	double sprinklerPrice = 2;
	double fireExtinguisherPrice = 35;
	
}
class Liner {
	double lengthOfShip = 0;
	double widthOfShip = 0;	
}

class highEndEmployees {
	int risk = 5;
	double cost = 4000;
}

class middleEndEmployees {
	int risk = 10;
	double cost = 2500;
}

class lowEndEmployees {
	int risk = 15;
	double cost = 1500;
}

class HugeLifeboat {
	int risk = 0;
	double cost = 50000;
	int equipments[] = {150, 7, 750, 150, 1, 1, 1, 2, 2, 1, 1, 1, 3, 2, 1, 1};
	int shipCapacity = 75;
}

class MediumLifeboat {
	int risk = 5;
	double cost =38000;
	int equipments[] = {113 , 5, 565, 113, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1};
	int shipCapacity = 50;
}

class SmallLifeboat { 
	int risk = 10;
	double cost =27000;
	int equipments[] = {75 , 4, (75*5), 75, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	int shipCapacity = 32;
}

class LifeRafts {
	int risk = 15;
	double cost =27000;
	int equipments[] = {35 , 2, (35*5), 35, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
	int shipCapacity = 15;
}

public class Assignment3Coding {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int decision;
		Liner ship = new Liner();	
		int typeOfTravel;
		int guests;
		int employees;
		double insuranceMoney;
		int employeeType;
		int lifeboatType;
		
		EquipmentDetails ed = new EquipmentDetails();
		display1();
			typeOfTravel = Integer.parseInt(sc.nextLine());
			while (typeOfTravel != 1 && typeOfTravel != 2) {
				System.out.print("Invalid, please input again.\n");
				typeOfTravel = Integer.parseInt(sc.nextLine());
			}
			//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			//	INTERNATIONAL
			//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			if(typeOfTravel == 1) {
				System.out.print("Please enter the length and width of ship \n With the format of (width length) : ");
				String s =sc.nextLine();
				String [] str = s.split(" ");
				ship.lengthOfShip = Double.parseDouble(str[0]);
				ship.widthOfShip = Double.parseDouble(str[1]);
				double[] array1 = firstCalculation(ship.lengthOfShip, ship.widthOfShip);
				System.out.print("\nPlease insert the number of guests that will be aboard on the ship : ");
				guests = Integer.parseInt(sc.nextLine());
				System.out.print("\nPlease insert the number of insurance money per-guests in the ship : ");
				insuranceMoney = Double.parseDouble(sc.nextLine());
				System.out.print("\nPlease insert the number of employees that will be employed on the ship : ");
				employees = Integer.parseInt(sc.nextLine());
				int totalPassengers = totalPassengers(guests, employees);
				System.out.print("\nPlease insert the type of employee that will be employed on the ship : ");
				System.out.print("\n1.High end employees\t2.Mid end employees\t3.Low end employees");
				employeeType = Integer.parseInt(sc.nextLine());
				while (employeeType != 1 && employeeType !=2 && employeeType != 3) {
					System.out.print("\nInvalid input, please try again");
					employeeType = Integer.parseInt(sc.nextLine());
				}
				//********************************
				//	HIGH END EMPLOYEES INTERNATIONAL
				//********************************
				if(employeeType == 1) {
					highEndEmployees te = new highEndEmployees();
					double employeeCost = te.cost * employees;
					System.out.println("You have chosen, High End Employees!");
					proceedScreen();
					decision = Integer.parseInt(sc.nextLine());
					while(decision != 1 && decision != 2) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					if(decision == 1) {
						System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
						System.out.print("\n1.Huge\t\t2.Medium");
						lifeboatType = Integer.parseInt(sc.nextLine());
						while(lifeboatType != 1 && lifeboatType != 2) {
							System.out.print("\nInvalid input, please try again");
							decision = Integer.parseInt(sc.nextLine());
						}
						//-----------------------------------------------
						//	HIGH END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
						//-----------------------------------------------
						if(lifeboatType == 1) {
							HugeLifeboat hl = new HugeLifeboat();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}else 
						//-----------------------------------------------
						//	HIGH END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
						//-----------------------------------------------
						if(lifeboatType == 2) {
							MediumLifeboat hl = new MediumLifeboat();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}
						
					} else
					if(decision == 2) {
						main(args);
					}
				}
			//********************************
			//	MEDIUM END EMPLOYEES INTERNATIONAL
			//********************************
			if(employeeType == 2) {
				middleEndEmployees te = new middleEndEmployees();
				double employeeCost = te.cost * employees;
				System.out.println("You have chosen, Medium End Employees!");
				proceedScreen();
				decision = Integer.parseInt(sc.nextLine());
				while(decision != 1 && decision != 2) {
					System.out.print("\nInvalid input, please try again");
					decision = Integer.parseInt(sc.nextLine());
				}
				if(decision == 1) {
					System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
					System.out.print("\n1.Huge\t\t2.Medium");
					lifeboatType = Integer.parseInt(sc.nextLine());
					while(lifeboatType != 1 && lifeboatType != 2) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 1) {
						HugeLifeboat hl = new HugeLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}else 
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 2) {
						MediumLifeboat hl = new MediumLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					
				} else
				if(decision == 2) {
					main(args);
				}
			}
			//********************************
			//	LOW END EMPLOYEES INTERNATIONAL
			//********************************
			if(employeeType == 3) {
				lowEndEmployees te = new lowEndEmployees();
				double employeeCost = te.cost * employees;
				System.out.println("You have chosen, Low End Employees!");
				proceedScreen();
				decision = Integer.parseInt(sc.nextLine());
				while(decision != 1 && decision != 2) {
					System.out.print("\nInvalid input, please try again");
					decision = Integer.parseInt(sc.nextLine());
				}
				if(decision == 1) {
					System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
					System.out.print("\n1.Huge\t\t2.Medium");
					lifeboatType = Integer.parseInt(sc.nextLine());
					while(lifeboatType != 1 && lifeboatType != 2) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 1) {
						HugeLifeboat hl = new HugeLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}else 
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 2) {
						MediumLifeboat hl = new MediumLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					
				} else
				if(decision == 2) {
					main(args);
				}
			}
		}
			//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			//	DOMESTIC
			//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			if(typeOfTravel==2) {
				System.out.print("Please enter the length and width of ship \n With the format of (width length) : ");
				String s =sc.nextLine();
				String [] str = s.split(" ");
				ship.lengthOfShip = Double.parseDouble(str[0]);
				ship.widthOfShip = Double.parseDouble(str[1]);
				double[] array1 = firstCalculation(ship.lengthOfShip, ship.widthOfShip);
				System.out.print("\nPlease insert the number of guests that will be aboard on the ship : ");
				guests = Integer.parseInt(sc.nextLine());
				System.out.print("\nPlease insert the number of insurance money per-guests in the ship : ");
				insuranceMoney = Double.parseDouble(sc.nextLine());
				System.out.print("\nPlease insert the number of employees that will be employed on the ship : ");
				employees = Integer.parseInt(sc.nextLine());
				int totalPassengers = totalPassengers(guests, employees);
				System.out.print("\nPlease insert the type of employee that will be employed on the ship : ");
				System.out.print("\n1.High end employees\t2.Mid end employees\t3.Low end employees");
				employeeType = Integer.parseInt(sc.nextLine());
				while (employeeType != 1 && employeeType !=2 && employeeType != 3) {
					System.out.print("\nInvalid input, please try again");
					employeeType = Integer.parseInt(sc.nextLine());
				}
				//********************************
				//	HIGH END EMPLOYEES DOMESTIC
				//********************************
				if(employeeType == 1) {
					highEndEmployees te = new highEndEmployees();
					double employeeCost = te.cost * employees;
					System.out.println("You have chosen, High End Employees!");
					proceedScreen();
					decision = Integer.parseInt(sc.nextLine());
					while(decision != 1 && decision != 2) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					if(decision == 1) {
						System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
						System.out.print("\n1.Huge\t\t2.Medium\t\t3.Small\t\t4.Liferafts");
						lifeboatType = Integer.parseInt(sc.nextLine());
						while(lifeboatType != 1 && lifeboatType != 2 && lifeboatType != 3 && lifeboatType != 4) {
							System.out.print("\nInvalid input, please try again");
							decision = Integer.parseInt(sc.nextLine());
						}
						//-----------------------------------------------
						//	HIGH END EMPLOYEES DOMESTIC HUGE LIFEBOAT
						//-----------------------------------------------
						if(lifeboatType == 1) {
							HugeLifeboat hl = new HugeLifeboat();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}else 
						//-----------------------------------------------
						//	HIGH END EMPLOYEES DOMESTIC MEDIUM LIFEBOAT
						//-----------------------------------------------
						if(lifeboatType == 2) {
							MediumLifeboat hl = new MediumLifeboat();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}
						//-----------------------------------------------
						//	HIGH END EMPLOYEES DOMESTIC SMALL LIFEBOAT
						//-----------------------------------------------
						if(lifeboatType == 3) {
							SmallLifeboat hl = new SmallLifeboat();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}
						//-----------------------------------------------
						//	HIGH END EMPLOYEES DOMESTIC LIFERAFTS
						//-----------------------------------------------
						if(lifeboatType == 4) {
							LifeRafts hl = new LifeRafts();
							int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
							int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
							System.out.println();
							System.out.println("==========================================================");
							System.out.println("Size and distance details : ");
							System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
							System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
							System.out.println();
							System.out.println("---------------------------------------------------------");
							System.out.println();
							System.out.println("Equipment details : ");
							System.out.println("Life boats that will be on the ship = " + lifeboats);
							System.out.println();
							System.out.println("Per-lifeboat equipment details : ");
							for (int i=0; i<ed.equipmentName.length; i++) {
								System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
							}
							System.out.println("Employees per life boat		= " + employeesPerLifeboat);
							System.out.println("========================================================== ");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
							if(decision == 1) {
								System.out.println();
								System.out.println("Receipt of equipment details");
								System.out.println("==========================================================");
								for(int i=0; i<hl.equipments.length; i++) {
									System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
								}
								System.out.println("==========================================================");
								proceedScreen();
								decision = Integer.parseInt(sc.nextLine());
								while(decision != 1 && decision != 2) {
									System.out.print("\nInvalid input, please try again\n");
									decision = Integer.parseInt(sc.nextLine());
								}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("Price details : ");
										System.out.println("Price of one sprinkler			=  USD 2.00");
										System.out.println("Price of one fire extinguisher		=  USD 35.00");
										System.out.println("Price of one life boat			=  USD " + hl.cost);
										for (int i=0; i<15;i++) {
											System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
										}
										System.out.println("==========================================================");
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											System.out.println("==========================================================");
											System.out.println("All equipments price details : ");
											System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
											System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
											System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
											double sum = 0;
											for (int i=0; i<15; i++) {
												System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
												sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
											}
											double totalPrice = sum + employeeCost;
											System.out.println("Total price of the whole equipment is : USD" + sum);
											System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
											System.out.println("---------------------------------------------------------");
											System.out.println("The whole budget would be : USD" + (sum + employeeCost));
											System.out.println("---------------------------------------------------------");
											System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
											proceedScreen();
											decision = Integer.parseInt(sc.nextLine());
											while(decision != 1 && decision != 2) {
												System.out.print("\nInvalid input, please try again\n");
												decision = Integer.parseInt(sc.nextLine());
											}
											if(decision == 1) {
												lastMethod(totalPrice, insuranceMoney, guests);
											}else 
											if(decision == 2){
												main(args);
											}
											
										}else
										if(decision == 2) {
											main(args);
										}
									}
									else
									if(decision == 2) {
										main(args);
									}
							}else
							if(decision == 2) {
								main(args);
							}
						}
						
					} else
					if(decision == 2) {
						main(args);
					}
				}
			//********************************
			//	MEDIUM END EMPLOYEES DOMESTIC
			//********************************
			if(employeeType == 2) {
				middleEndEmployees te = new middleEndEmployees();
				double employeeCost = te.cost * employees;
				System.out.println("You have chosen, Medium End Employees!");
				proceedScreen();
				decision = Integer.parseInt(sc.nextLine());
				while(decision != 1 && decision != 2) {
					System.out.print("\nInvalid input, please try again");
					decision = Integer.parseInt(sc.nextLine());
				}
				if(decision == 1) {
					System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
					System.out.print("\n1.Huge\t\t2.Medium\t\t3.Small\t\t4.Liferafts");
					lifeboatType = Integer.parseInt(sc.nextLine());
					while(lifeboatType != 1 && lifeboatType != 2 && lifeboatType != 3 && lifeboatType != 4) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES INTERNATIONAL HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 1) {
						HugeLifeboat hl = new HugeLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}else 
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES DOMESTIC MEDIUM LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 2) {
						MediumLifeboat hl = new MediumLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES DOMESTIC SMALL LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 3) {
						SmallLifeboat hl = new SmallLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES DOMESTIC LIFERAFTS
					//-----------------------------------------------
					if(lifeboatType == 4) {
						LifeRafts hl = new LifeRafts();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					
				} else
				if(decision == 2) {
					main(args);
				}
			}
			//********************************
			//	LOW END EMPLOYEES DOMESTIC
			//********************************
			if(employeeType == 3) {
				lowEndEmployees te = new lowEndEmployees();
				double employeeCost = te.cost * employees;
				System.out.println("You have chosen, Low End Employees!");
				proceedScreen();
				decision = Integer.parseInt(sc.nextLine());
				while(decision != 1 && decision != 2) {
					System.out.print("\nInvalid input, please try again");
					decision = Integer.parseInt(sc.nextLine());
				}
				if(decision == 1) {
					System.out.print("\nPlease insert the type of lifeboat you want to have in your liner : ");
					System.out.print("\n1.Huge\t\t2.Medium\t\t3.Small\t\t4.Liferafts");
					lifeboatType = Integer.parseInt(sc.nextLine());
					while(lifeboatType != 1 && lifeboatType != 2 && lifeboatType != 3 && lifeboatType != 4) {
						System.out.print("\nInvalid input, please try again");
						decision = Integer.parseInt(sc.nextLine());
					}
					//-----------------------------------------------
					//	LOW END EMPLOYEES DOMESTIC HUGE LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 1) {
						HugeLifeboat hl = new HugeLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}else 
					//-----------------------------------------------
					//	MEDIUM END EMPLOYEES DOMESTIC MEDIUM LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 2) {
						MediumLifeboat hl = new MediumLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					//-----------------------------------------------
					//	LOW END EMPLOYEES DOMESTIC SMALL LIFEBOAT
					//-----------------------------------------------
					if(lifeboatType == 3) {
						SmallLifeboat hl = new SmallLifeboat();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					//-----------------------------------------------
					//	LOW END EMPLOYEES DOMESTIC LIFERAFTS
					//-----------------------------------------------
					if(lifeboatType == 4) {
						LifeRafts hl = new LifeRafts();
						int lifeboats = lifeboatCalculation(totalPassengers, hl.shipCapacity);
						int employeesPerLifeboat = employeeCalculation(employees ,lifeboats);
						System.out.println();
						System.out.println("==========================================================");
						System.out.println("Size and distance details : ");
						System.out.println("Ship's 2D size\t\t\t\t\t= " + array1[0] + " meters");
						System.out.println("Ship's safe distance to an island \t\t= " + array1[1] + " meters");
						System.out.println();
						System.out.println("---------------------------------------------------------");
						System.out.println();
						System.out.println("Equipment details : ");
						System.out.println("Life boats that will be on the ship = " + lifeboats);
						System.out.println();
						System.out.println("Per-lifeboat equipment details : ");
						for (int i=0; i<ed.equipmentName.length; i++) {
							System.out.println(ed.equipmentName[i] + "\t\t = " + hl.equipments[i]);
						}
						System.out.println("Employees per life boat		= " + employeesPerLifeboat);
						System.out.println("========================================================== ");
						proceedScreen();
						decision = Integer.parseInt(sc.nextLine());
						while(decision != 1 && decision != 2) {
							System.out.print("\nInvalid input, please try again\n");
							decision = Integer.parseInt(sc.nextLine());
						}
						if(decision == 1) {
							System.out.println();
							System.out.println("Receipt of equipment details");
							System.out.println("==========================================================");
							for(int i=0; i<hl.equipments.length; i++) {
								System.out.println("Total " + ed.equipmentName[i] + "\t\t = " + (lifeboats* hl.equipments[i]));
							}
							System.out.println("==========================================================");
							proceedScreen();
							decision = Integer.parseInt(sc.nextLine());
							while(decision != 1 && decision != 2) {
								System.out.print("\nInvalid input, please try again\n");
								decision = Integer.parseInt(sc.nextLine());
							}
								if(decision == 1) {
									System.out.println("==========================================================");
									System.out.println("Price details : ");
									System.out.println("Price of one sprinkler			=  USD 2.00");
									System.out.println("Price of one fire extinguisher		=  USD 35.00");
									System.out.println("Price of one life boat			=  USD " + hl.cost);
									for (int i=0; i<15;i++) {
										System.out.println("Price of one" + ed.equipmentName[i] + "\t\t = USD " + ed.equipmentValue[i]);
									}
									System.out.println("==========================================================");
									proceedScreen();
									decision = Integer.parseInt(sc.nextLine());
									while(decision != 1 && decision != 2) {
										System.out.print("\nInvalid input, please try again\n");
										decision = Integer.parseInt(sc.nextLine());
									}
									if(decision == 1) {
										System.out.println("==========================================================");
										System.out.println("All equipments price details : ");
										System.out.println("Sprinklers		= " + (array1[2] * ed.sprinklerPrice));
										System.out.println("Fire Extinguishers	= " + (array1[3] * ed.fireExtinguisherPrice));
										System.out.println("Lifeboats		= " + (hl.cost * lifeboats));
										double sum = 0;
										for (int i=0; i<15; i++) {
											System.out.println(ed.equipmentName[i] + "\t\t = " + ((lifeboats * hl.equipments[i]) * ed.equipmentValue[i]));
											sum = sum + (lifeboats * hl.equipments[i]) * ed.equipmentValue[i];
										}
										double totalPrice = sum + employeeCost;
										System.out.println("Total price of the whole equipment is : USD" + sum);
										System.out.println("The total price of the whole crew of employees is : USD" + employeeCost);
										System.out.println("---------------------------------------------------------");
										System.out.println("The whole budget would be : USD" + (sum + employeeCost));
										System.out.println("---------------------------------------------------------");
										System.out.println("The risk of the ship getting caught into an accident : %" + (hl.risk + te.risk));
										proceedScreen();
										decision = Integer.parseInt(sc.nextLine());
										while(decision != 1 && decision != 2) {
											System.out.print("\nInvalid input, please try again\n");
											decision = Integer.parseInt(sc.nextLine());
										}
										if(decision == 1) {
											lastMethod(totalPrice, insuranceMoney, guests);
										}else 
										if(decision == 2){
											main(args);
										}
										
									}else
									if(decision == 2) {
										main(args);
									}
								}
								else
								if(decision == 2) {
									main(args);
								}
						}else
						if(decision == 2) {
							main(args);
						}
					}
					
				} else
				if(decision == 2) {
					main(args);
				}
			}
			}
	}
			
	
	static void display1() {
		System.out.print("Welcome to the ship safety equipment repairment system!\n");
		System.out.println("This program is meant to predict how many budget be put in the safety equipment of a cruise liner.");
		System.out.println("We will start by choosing the type of cruising you will do. \n Please select the type of travelling your liner will do : ");
		System.out.println("1.International cruising\t\t2.Domestic cruising");
	}
	
	static void display2International() {
		System.out.print("\nPlease insert the type of lifeboat you'd like on your liner");
		System.out.print("1.Huge Lifeboat\t\t2.Medium Lifeboat");
	}
	
	static void warningSign() {
		System.out.print("(Warning, if the option does not execute, please press the option twice)");
	}
	
	 static double[] firstCalculation(double lengthOfShip, double widthOfShip) {
		 double ship2DApproxSize = lengthOfShip + widthOfShip;
		 double distanceToBeAchieved = (ship2DApproxSize * 2)/5;
		 int sprinklerAprox =(int) (17 * ship2DApproxSize);
		 int fireExtinguisherApprox = (int) ((ship2DApproxSize * 5)/3);
		 return new double[] {ship2DApproxSize, distanceToBeAchieved, sprinklerAprox,fireExtinguisherApprox};
	 }
	 
	 static double money(double insuranceMoney, int guests) {
		 double moneyAcquired = guests * insuranceMoney;
		 return moneyAcquired;
	 }
	 
	 static void proceedScreen() {
		 System.out.println("Would you like to proceed ?");
		 System.out.print("\n1.Yes\t\t2.No");
	 }
	 
	 static int totalPassengers(int X,int Y) {
		 return X + Y;
	 }
	 
	 static int lifeboatCalculation(int X,int Y) {
		 return (int) (((X * 37.5)/100)/Y)*2;
	 }
	 
	 static int employeeCalculation(int X, int Y) {
		 return X/Y;
	 }
	 
	 static double employeePrice (int X, double Y) {
		 return X * Y;
	 }
	 
	 static void lastMethod(double totalPrice, double insuranceMoney, int guests) {
		 double totalRevenueOrLoss = insuranceMoney * guests - totalPrice;
		 System.out.print("Total revenue / loss of your budget is : USD ");
		 System.out.printf("%.2f", totalRevenueOrLoss);
		 System.out.println();
		 System.out.print("Please insert how many trips will your ship be doing in one year : ");
		 int tripsPerOneYear = Integer.parseInt(sc.nextLine());
		 double totalRevenueOrLossAfterSailing = (double) ((tripsPerOneYear * 5) * insuranceMoney) - totalPrice;
		 System.out.print("The total revenue / loss of your budget after 5 years is : USD ");
			System.out.printf("%.2f", totalRevenueOrLossAfterSailing);
			System.out.println();
			System.out.println("Thank you for using our services.");
			sc.close();
	 }
	
}
