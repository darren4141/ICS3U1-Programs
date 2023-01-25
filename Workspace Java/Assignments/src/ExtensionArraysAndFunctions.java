

//====================================================================================================================================================================
//"Bubble Tea" Program - Function, Array, and Try/Catch extension
//Darren Liu
//October 31st, 2022
//Java 4.6.1
//====================================================================================================================================================================
//Problem definition:   Help the sales staff determine the price of a bubble tea order, including multiple similar or different items based on the customer's
//                      specifications. The program must ask for the customer's name, type of tea, type of topping, number of teas, flavours, and toppings.
//                      Output a reciept at the end including all order information and price calculations.
 
//Extensions:           Solve the program using functional and procedural methods
//                      Use arrays/lists in the solving of the program
//                      Error proof the input using Try/Catch
 
//Input:                Name
//                      Type of tea
//                      Flavour of tea
//                      Topping choice
//                      Size choice
//                      Tip amount choice
 
//Output:               Receipt including all of the orders, phone number, store name, all of the prices, tax and tip calculations
//                      User friendly prompts (Welcome, what would you like?) with the user's name to make the program more personal
//                      Menu with all options and prices
//                      'Funny' prompts each time a user chooses a topping
//                      List of choices for the user                      
 
//====================================================================================================================================================================
//List of variables:    Arrays storing information about each drink:
//                          - (item)MENU = A String array that stores the menu elements to be outputted for a certain category (flavour, toppings, size)
//                          - (item)S = A String array that stores the name of the elements in a certain category. This must be seperate from the MENU array as these are
//                            to be added to the reciept, meaning things displayed about an element on the menu cannot show up on the reciept. (units, capitalization, additional messages)
//                          - (item)MESSAGES = A String array of the messages to be displayed when certain items are ordered
//                          - (item)PRICES = A double array containing all of the prices of elements in a category. Some prices are meant to be added on and others are meant to be multipliers.
//                          - (item)MAINMESSAGE = A string containing the main message to be outputted at the start of a category's selection, eg: the message displayed when it is time to choose flavour
//                      NOTE ON THESE VARIABLES: some of them are not constants and are therefore not capitalized as they contain the user's name in the string and must be
//                      updated when a new person orders and the name variable changes
 
//                      chosen = a boolean variable used in every switch case in combination with a do-while construct to ensure that when the default case is triggered
//                      the loop runs again and the user can input again
 
//                      choice = an int variable used to store the choice of the user and put it through the switch case
//                      typeBaseChoice = an int variable used to store the user's choice of base liquid
//                      mainChoice = an int variable used to store the very first choice from the user (1. menu 2. order 3. exit)
 
//                      numOfToppings = an int counter used with logic operators for grammar
//                      stringToppings = a String used to store the list of toppings and format them nicely when the user orders multiple toppings
 
//                      drinkPrice = a double variable used to store the accumulative price of the drink as the user chooses more things about their tea
 
//                      totalPrice = an accumulative double variable used to store the combined price of all of the drinks
 
//                      TAX = tax rate multiplier stored in a double constant
 
//                      hst, tipAmount, total = double variables used for math calculations at the end of the program
 
//                      tipChoice = the amount the user chooses to tip stored in an int
 
//                      name = the user's name stored in a String
 
//                      SHOPNAME = the name of the shop, stored in a String constant in case of any spontaneous rebrands
 
//                      PHONENUM = the shop's phone number, stored in a String constant in case of any spontaneous changes
 
//                      baseTea = a String variable used to store the name of the order, it is added onto throughout the program
 
//                      specialNumber = an int variable that stores the number of the special flavour of the day. It is randomly generated
 
//                      numberRefunded = user inputted number of bubble tea's to refund if the quantity of a refunded item is larger than 1 stored in an int
 
//                      refundItemNumber = the index of the item the user wants to refund, stored in an int
 
//                      stringAdd = a String variable inside of the orderMenu function that stores the String of the option to be added. The stringAdd variable is returned
 
//                      LinkedLists:    customerNames: the names of the customers - to be outputted on the receipt, type String
//                                      orders: the orders of the customers - to be outputted on the receipt, type String
//                                      orderPrices: the prices of each order - to be outputted on the receipt, type Double
//                                      quantities: the amount of each order - to be outputted on the receipt, type int
//                                      currentItems: the current additional items on the bubble tea, to be printed at the end of each order, type String
//                                      currentPrices: the prices of the additional items on the bubble tea, it is String as it is stored using DecimalFormat as it is just for display, type String
//====================================================================================================================================================================
//import some packages for input, decimal formatting, and linkedlists
import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
 
public class ExtensionArraysAndFunctions{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //declare static BufferedReader object as we must use it within other methods as well as the main method
    static DecimalFormat moneyFormat = new DecimalFormat(".00"); //declare static DecimalFormat object as we must use it within other methods as well as the main method
 
    //VARIABLES EXPLAINED AT THE TOP
    static LinkedList<String> customerNames = new LinkedList<String>();
    static LinkedList<Integer> quantities = new LinkedList<Integer>();
    static LinkedList<String> orders = new LinkedList<String>();
    static LinkedList<Double> orderPrices = new LinkedList<Double>();
    static LinkedList<String> currentItems = new LinkedList<String>();
    static LinkedList<String> currentPrices = new LinkedList<String>();
   
    static final String PHONENUM = "647-BBL-TEA";
    static final String SHOPNAME = "Darren's delicious bubble tea";
    static double hst, tipAmount, total;
    static double totalPrice = 0;
    static double drinkPrice = 0;
 
 
    static boolean chosen = true;
    static int choice;
    static String name;
 
    static String baseTea;
    static String stringAdd="";
 
    static double tipPercentage = 0;
 
 
 
    public static void main(String[]args) throws IOException{//main method
 
        //GENERAL VARIABLES - EXPLAINED AT THE TOP
        final double TAX = 0.13;
        int amount = 0;
        int numOfToppings = 0;
        int tipChoice = 0;
 
        //TOPPING VARIABLES
        String stringToppings = "";
        String addTopping;
 
        //REFUND VARIABLES
        String refundChoice;
        int refundItemNumber = 0;
        int numberRefunded;
       
        //MENU CHOICE VARIABLES
        int typeBaseChoice;
        int mainChoice = 0;
 
 
        //DECLARE OIL GROUP VARIABLES
        final String [] OILMENU = {"Burger oil", "Crude oil", "Olive oil"};
        final String [] OILS = {"burger oil", "crude oil", "olive oil"};
        final String [] OILMESSAGES = {
            "We cooked an entire burger and threw it out just to gather this oil",
            "This one is my personal favourite of the three",
            "This stuff is so expensive nowadays"
        };
        final double [] OILPRICES = {17, 25, 18};
        final String OILMAINMESSAGE = "You want an oil drink? Okay.\nWhat type of oil base would you like?";
 
        //DECLARE THIN LIQUID GROUP VARIABLES
        final String[] THINLIQUIDMENU= {"Rainwater", "Disinfectant", "Saltwater"};
        final String[] THINLIQUIDS= {"rainwater", "disinfectant", "saltwater"};
        String[] thinLiquidMessages = {
            "This option saves us money",
            "I hope you're not planning on drinking this",
            ""
        };
        final double [] THINLIQUIDPRICES = {6, 12, 8};
        String thinLiquidMainMessage = "";
       
        //DECLARE THICK LIQUID GROUP VARIABLES
        final String[] THICKLIQUIDMENU= {"Ink", "Sewage waste", "Soap"};
        final String[] THICKLIQUIDS= {"ink", "sewage waste", "soap"};
        final String[] THICKLIQUIDMESSAGES = {
            "I heard this stuff will make your insides black",
            "Did you know they pay us to take this stuff?",
            "Just because it smells good doesn't mean it'll taste good"
        };
        final double [] THICKLIQUIDPRICES = {20, 1, 10};
        String thickLiquidMainMessage = "";
       
        //DECLARE FLAVOUR GROUP VARIABLES
        final String[] FLAVOURMENU = {"Cheese", "Ketchup", "Aluminium", "Pickle", "Sriracha", "Spoiled milk", "Mold", "Fish"};
        final String[] FLAVOURS = {"cheese", "ketchup", "aluminium", "pickle", "sriracha", "spoiled milk", "mold", "fish"};
        String[] flavourMessages = {
            "",
            "I wonder if you actually like this stuff",
            "This is good if you like the taste of day-old gum",
            "These are actually homemade!",
            "",
            "",
            "We grow this in the back",
            "",
        };
        final double [] FLAVOURPRICES = {7, 2, 4, 3, 5, 7, 1, 6};
        String flavourMainMessage = "";
 
        //DECLARE TOPPING GROUP VARIABLES
        final String[] TOPPINGMENU = {"Wood chips", "Tylenol", "Assorted cubed meat", "Cucumber", "Chalk", "None"};
        final String[] TOPPINGS = {"wood chips", "Tylenol", "assorted cubed meat", "cucumber", "chalk", "no toppings"};
        String[] toppingMessages = {
            "Be careful of blisters inside of your throat",
            "",
            "",
            "This one is actually pretty normal",
            "I like the texture of chalk",
            "All done ordering toppings!"
        };
        final double [] TOPPINGPRICES = {2, 10, 5, 3, 3, 0};
        final String TOPPINGMAINMESSAGE = "Choose a topping <or select \"no toppings\" to stop";
 
        //DECLARE SIZE GROUP VARIABLES
        final String[] SIZEMENU = {"Needle's worth (3mL)(needle included)", "Tablespoon(measuring cup included)", "Bathtub's worth (180L)(Bathtub included)"};
        final String[] SIZES = {"needle's worth of", "tablespoon of", "bathtub full of"};
        String[] sizeMessages = {
            "Please don't inject this",
            "Here is your measuring cup",
            ""
        };
        final double[] SIZEPRICES = {0.5, 1, 100};
        String sizeMainMessage = "";
       
        //choose the random flavour of the day
        int specialNumber= (int)Math.floor(Math.random()*(7-1)+0);
        FLAVOURPRICES[specialNumber] /= 2;//cut the price in half
 
        //WELCOME
        System.out.println("Welcome to "+SHOPNAME+"!");//UFP's
        System.out.println("What is your name?  <or enter \"exit\" to exit>");
        name = br.readLine();//input name
 
        if(!name.equals("exit")){//don't give them this choice if their name is exit
            do{
	           chosen = true;
	           System.out.println("Welcome "+name+"! What would you like today?");
	           System.out.println(".---------------------------------------------------.");//printf to make it look nice
	           System.out.printf("|%-8s |%-40s |%n", "OPTION", "ACTION");
	           System.out.println("|---------+-----------------------------------------|");
	           System.out.printf("|%-8s |%-40s |%n", "1.", "Menu");
	           System.out.printf("|%-8s |%-40s |%n", "2.", "Order");
	           System.out.printf("|%-8s |%-40s |%n", "3.", "Exit");
	           System.out.println("'---------------------------------------------------'");
	           
	           try{//try the input to catch when a string is inputted
	        	   mainChoice = Integer.parseInt(br.readLine()); //input choice
	           }catch(Exception e){//triggers when a string is entered instead of an int
	        	   System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
	        	   chosen = false;
	           }
	           
	           if(mainChoice > 3){
	        	   System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
	        	   chosen = false;
	           }
	           
            }while(!chosen);
        }else{//their name is exit
        	mainChoice = 3;//we won't enter the while loop if exit is entered as the name
        }
 
        while(mainChoice != 3 && !name.equals("exit")){//conditions: mainChoice is not 3 AND name does not equal "exit"
       
            //CLEAR LINKED LISTS
            currentItems.clear();
            currentPrices.clear();;
 
            //UPDATE VARIABLES WITH NAME, AS THEY MUST BE UPDATED EACH TIME A NEW NAME IS ENTERED
            thinLiquidMessages[2] = "What is wrong with you "+name;
            thinLiquidMainMessage = "On a diet today "+name+"?\nWhat type of thin liquid would you like?";
            thickLiquidMainMessage = "Thick liquids are better for your throat.\nWhat type of thick liquid would you like " +name+"?";
            flavourMessages[0] = "I guess "+name+" is one of those people will eat cheese with anything...";
            flavourMessages[4] = "Hey everyone, "+name+" has good spice tolerance! Suprising. No one cares.";
            flavourMessages[5] = "Alright "+name+" I think you need to see the doctor";
            flavourMessages[7] = "Lucky you "+name+"! I caught this one this morning";
            flavourMainMessage = name+", guess what time it is. It's time to choose from our delicious flavours!\nWhat flavour would you like?";
            toppingMessages[1] = "Bad headache "+name+"?";
            toppingMessages[2] = "You don't need this much protien "+name;
            sizeMessages[2] = "Feeding a whole party are we "+name+"?";
            sizeMainMessage = "Almost done "+name+"!\nWhat size would you like today?\nFinal cost is multiplied based on size";
           
            //UFP telling them know what the special of the day is
            System.out.println(FLAVOURS[specialNumber].toUpperCase()+" IS THE SPECIAL FLAVOUR OF THE DAY. IT IS 50% OFF AT A NEW PRICE OF: $" +  moneyFormat.format(FLAVOURPRICES[specialNumber]));
            
            switch(mainChoice){//switch for the main choice
                case 1://CHOSE MENU
                    //output the menu, used functions to do it, function will be explained at the function
                    System.out.println("MENU:");
                    printMenu(3, "OILS", OILMENU, OILPRICES, false);
                    printMenu(3, "THIN LIQUIDS", THINLIQUIDMENU, THINLIQUIDPRICES, false);
                    printMenu(3, "THICK LIQUIDS", THICKLIQUIDMENU, THICKLIQUIDPRICES, false);
                    printMenu(8, "FLAVOURS", FLAVOURMENU, FLAVOURPRICES, false);
                    printMenu(5, "TOPPINGS", TOPPINGMENU, TOPPINGPRICES, false);
                    printMenu(3, "SIZES", SIZEMENU, SIZEPRICES, true);
                    break;//to avoid default case
 
                case 2:
                    do{//do loop in case they enter in invalid option
                        chosen = true; //loop won't run again as long as valid option is entered
                        System.out.println("What type of liquid would you like today "+name+"?");//UFP
                        System.out.println(".---------------------------------------------------.");
                        System.out.printf("|%-8s |%-40s |%n", "OPTION", "MENU");//menu UFP using printf
                        System.out.println("|---------+-----------------------------------------|");
                        System.out.printf("|%-8s |%-40s |%n", "1.", "Oil");
                        System.out.printf("|%-8s |%-40s |%n", "2.", "Thin liquid");
                        System.out.printf("|%-8s |%-40s |%n", "3.", "Thick liquid");
                        System.out.println("'---------------------------------------------------'");
 
                        try{//try the input to catch when a string is inputted
                            typeBaseChoice = Integer.parseInt(br.readLine());//input option for which type of liquid they would like
                        }catch(Exception e){//triggers when a string is entered instead of an int
                            System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                            chosen = false;//run the do loop again if they entered an invalid option
                            continue;
                        }
           
                        switch(typeBaseChoice){//switch case using their choice of base liquid
                            case 1://EACH CASE WE RUN THE SAME FUNCTION JUST WITH DIFFERENT PARAMETERS, SO IT WILL PROMPT FOR DIFFERENT ACTIONS
                                baseTea = orderMenu(3, OILS, OILMENU, OILMESSAGES, OILPRICES, OILMAINMESSAGE, false);
                                //call orderMenu function with the return type String, it will return what the user ordered and we can directly add it to our baseTea string
                                break;//to avoid default
                            case 2:
                                baseTea = orderMenu(3, THINLIQUIDS, THINLIQUIDMENU, thinLiquidMessages, THINLIQUIDPRICES, thinLiquidMainMessage, false);
                                break;
                            case 3:
                                baseTea = orderMenu(3, THICKLIQUIDS, THICKLIQUIDMENU, THICKLIQUIDMESSAGES, THICKLIQUIDPRICES, thickLiquidMainMessage, false);
                                break;
                            default:
                                System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                                chosen = false;//run the do loop again if they entered an invalid option
                        }
                    }while(!chosen);//condition, while not chosen
                   
                    System.out.println(FLAVOURS[specialNumber].toUpperCase()+" IS THE SPECIAL FLAVOUR OF THE DAY. IT IS 50% OFF AT A NEW PRICE OF: $" +  moneyFormat.format(FLAVOURPRICES[specialNumber]));
                    baseTea = orderMenu(8, FLAVOURS, FLAVOURMENU, flavourMessages, FLAVOURPRICES, flavourMainMessage, false) + " " + baseTea;
 
                    numOfToppings = 0;
                    do{//loop toppings until "no toppings" is chosen
                        numOfToppings++;
                        addTopping = orderMenu(6, TOPPINGS, TOPPINGMENU, toppingMessages, TOPPINGPRICES, TOPPINGMAINMESSAGE, false);
                   
                        if(!addTopping.equals("no toppings")){//don't add the topping if they select "no toppings"
                            if(numOfToppings == 1){//selection for grammar
                                stringToppings = stringToppings + addTopping;
                            }else{
                                stringToppings = stringToppings + ", " + addTopping;
                            }
                        }
                   
                    }while(!addTopping.equals("no toppings"));//keep running the loop until "no toppings" is chosen
                   
                    if(numOfToppings > 1) baseTea = baseTea + " with " + stringToppings; //update our baseTea variable, use the word "with" to make it sound better
                    //if statement for grammar
 
                    baseTea = orderMenu(3, SIZES, SIZEMENU, sizeMessages, SIZEPRICES, sizeMainMessage, true) +" "+ baseTea;
                    //call orderMenu function with the return type String, it will return what the user ordered and we can directly add it to our baseTea string
                    System.out.println(name+", you ordered a: " + baseTea);//UFP
 
                    System.out.println(".--------------------------------------------------.");
                    System.out.printf("|%-40s |%-8s|%n", "Addition:", "Price");//using printf to format nicely
                    System.out.println("|-----------------------------------------+--------|");
 
                    for(int i = 0; i < currentItems.size(); i++){//iterate through linked list
                        System.out.printf("|%-40s |%-8s|%n", currentItems.get(i), currentPrices.get(i));//output all of the additions and their prices
                    }
                    System.out.println("'--------------------------------------------------'");
                    System.out.println("Your total cost is: $" + moneyFormat.format(drinkPrice));//UFP
                   
                    do{//loop for errorchecking
                    	chosen = true;//loop will always run once unless there is an exception
                        System.out.println("How many of these would you like? <max 50>");
                        try{//try the input to catch when a string is inputted
                            amount = Integer.parseInt(br.readLine());
                        }catch(Exception e){//triggers when a string is entered instead of an int
                            System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                            chosen = false;
                        }
                        if(amount > 50){//errorchecking for exceptional values
                            System.out.println("That's too many! Enter a smaller number");
                            chosen = false;
                        }
 
                    }while(!chosen);//loop will run as long as chosen is false
                   
                    System.out.println("Alright, "+amount+" of these added to your order!");//UFP
 
                    break;//break from case 2
                   
                case 3:
                    System.out.println("Goodbye "+name+"! We expect to see you again!");//UFP
                    break;
 
                default:
                    System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
 
            }//end of main choice switch case
 
            if(mainChoice == 2){//we don't want to update the receipt if they looked at the menu or decided to exit
	            quantities.add(amount);
	            customerNames.add(name); //ADD ELEMENTS FROM THIS ITERATION TO THE LINKED LIST SO THAT THEY CAN BE PRINTED ON THE RECEIPT
	            orders.add(baseTea);
	            orderPrices.add(drinkPrice);
            }
            totalPrice += (drinkPrice*amount);//increment total price by drink price
           
            if(mainChoice == 2){//IF THEY ASKED FOR THE MENU OR EXITED, DON'T ASK FOR THEIR NAME AGAIN
                System.out.println("Welcome to "+SHOPNAME+"!");
                System.out.println("What is your name? <or enter \"exit\" to exit>");
                name = br.readLine(); //input name
            }
           
            //RESET VARIABLES TO PREVENT VARIABLES CARRYING OVER
            baseTea = "";
            drinkPrice = 0;
            mainChoice = 0;
            typeBaseChoice = 0;
            stringToppings = "";
           
            if(!name.equals("exit")){//don't run this prompt if they entered 'exit' as their name
                System.out.println("Welcome "+name+"! What would you like today?");
                System.out.println(".---------------------------------------------------.");//printf to make it look nice
                System.out.printf("|%-8s |%-40s |%n", "OPTION", "ACTION");
                System.out.println("|---------+-----------------------------------------|");
                System.out.printf("|%-8s |%-40s |%n", "1.", "Menu");
                System.out.printf("|%-8s |%-40s |%n", "2.", "Order");
                System.out.printf("|%-8s |%-40s |%n", "3.", "Exit");
                System.out.println("'---------------------------------------------------'");
 
                do{
                    chosen = true;
                    try{//try the input to catch when a string is inputted
                        mainChoice = Integer.parseInt(br.readLine()); //input choice  
                    }catch(Exception e){//triggers when a string is entered instead of an int
                        System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                        chosen = false;
                    }
                    if(mainChoice > 3){
                        System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                        chosen = false;
                    }
                }while(!chosen);
            }else{
                mainChoice = 3;//set main choice to false so that while loop will not run
            }
 
        }//end of main while loop (mainChoice)
       
        if(orders.size() != 0){//don't ask them to tip if they didnt order anything
 
            do{
                chosen = true;
                System.out.println("That's everything for today?");//goodbye message
                System.out.println("You feel the cashier's stare burn into you...");//the Ontario special
                System.out.println("Go ahead and tip!");//the Ontario special
                System.out.println("TIP: ");
                System.out.println("1. Good. (10%)");
                System.out.println("2. Great! (15%)");
                System.out.println("3. Amazing! (20%)");
                System.out.println("4. Wonderful! (25%)");
                System.out.println("5. Choose custom amount");
           
                try{//try the input to catch when a string is inputted
                    tipChoice = Integer.parseInt(br.readLine());//input tip choice option
                }catch(Exception e){//triggers when a string is entered instead of an int
                	System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                    chosen = false;
                }
                if(tipChoice > 5){
                    System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                    chosen = false;
                }
            }while(!chosen);
     
            tip(tipChoice);//function tipChoice calculates the tip percentage with one parameter
     
            //calculate tax, tip, total
            hst = totalPrice * TAX;
            tipAmount = totalPrice * tipPercentage;
            total = totalPrice + hst + tipAmount;
     
            printReceipt();//printReceipt function just prints a formatted receipt
 
            System.out.println("Would you like to refund any items? \n<y>: yes \n<any other key>: no");
            refundChoice = br.readLine();
            while(refundChoice.equals("y")){
                System.out.println("Which item would you like to refund?");
                for(int i = 0; i < orders.size(); i++){//iterate through the size of LinkedList order
                    System.out.println("\n"+(i+1)+". "+customerNames.get(i)+"'s order: ");//customerNames.get(i) will cover all of the elements in the array as the for loop iterates
                    System.out.println(orders.get(i));//same idea as previous line
                    System.out.println(">> QTY: "+quantities.get(i));//same idea as previous line
                    System.out.println(">> $"+moneyFormat.format(orderPrices.get(i)));//same idea as previous line, but we use our moneyFormat object to format the decimal
                }
                refundItemNumber = Integer.parseInt(br.readLine());
                refundItemNumber--;//SINCE ARRAY INDEXES START AT 0 AND OUR LIST STARTS AT 1
 
                //REMOVE REFUNDED ITEMS FROM LINKEDLIST AND REMOVE REFUNDED COSTS FROM TOTALCOST
 
                if(quantities.get(refundItemNumber)<=1){//if the item we are refunding only has a quantity of 1
                    //reset all of the variables and lower the price
                    customerNames.remove(refundItemNumber);
                    orders.remove(refundItemNumber);
                    totalPrice -= orderPrices.get(refundItemNumber)*quantities.get(refundItemNumber);
                    quantities.remove(refundItemNumber);
                    orderPrices.remove(refundItemNumber);
                }else{//if the item we are refunding has a quantity greater than 1
                    System.out.println("You ordered " + quantities.get(refundItemNumber) + " drinks. How many would you like to refund?");//ask them how many they would like to refund
                    numberRefunded = Integer.parseInt(br.readLine());//take input
                    if(quantities.get(refundItemNumber) <= numberRefunded){//if we are refunding every item
                        //reset all of the variables and lower the price
                        customerNames.remove(refundItemNumber);
                        orders.remove(refundItemNumber);
                        totalPrice -= orderPrices.get(refundItemNumber)*quantities.get(refundItemNumber);
                        quantities.remove(refundItemNumber);
                        orderPrices.remove(refundItemNumber);
                    }else{
                        quantities.set(refundItemNumber, quantities.get(refundItemNumber)-numberRefunded);//set the quantity number to "numberRefunded" less than before
                        totalPrice -= orderPrices.get(refundItemNumber) * numberRefunded;
                    }
 
                }
 
 
	            //RECALCULATE TOTAL
	            hst = totalPrice * TAX;
	            tipAmount = totalPrice * tipPercentage;
	            total = totalPrice + hst + tipAmount;
 
	                System.out.println("Your new receipt:");
	            for(int i = 0; i < orders.size(); i++){//iterate through the size of LinkedList order
                    System.out.println("\n"+(i+1)+". "+customerNames.get(i)+"'s order: ");//customerNames.get(i) will cover all of the elements in the array as the for loop iterates
                    System.out.println(orders.get(i));//same idea as previous line
                    System.out.println(">> QTY: "+quantities.get(i));//same idea as previous line
                    System.out.println(">> $"+moneyFormat.format(orderPrices.get(i)));//same idea as previous line, but we use our moneyFormat object to format the decimal
	            }
 
                System.out.println("Would you like to refund any items? \n<y>: yes \n<any other key>: no");
                refundChoice = br.readLine();
            }
 
            System.out.println("Here is your final receipt!");
            printReceipt();//printReceipt function just prints a formatted receipt
 
            System.out.println("Thanks for coming to "+SHOPNAME);
 
        }else{
        System.out.println("Buy something next time!");//UFP
        }
    }//end of main method
 
 
    static String orderMenu(int length, String[] options, String[] menu, String[] messages, double[] prices, String greeting, boolean isMultiplier) throws IOException{
    //THIS FUNCTION IS A GENERALIZED ORDER MENU FOR ALL ORDERS
    //Parameters:   length: the amount of items on the menu
    //              options: an array of the possible items we can add to the drink
    //              menu: an array of the possible items we display on the menu
    //              messages: an array of the different messages we display for different orders
    //              prices: an array of the prices of each topping/flavour/etc
    //              greeting: the messages displayed at the beginning of the menu prompt
    //              isMultiplier: just used to distinguish between the menu options that add and the menu options that multiply, throughout the method we have to calculate and display accoringly
   
        do{    
            chosen = true;//set chosen to true so we exit the loop as long as we dont enter an invalid option
            System.out.println(greeting);//UFP
            System.out.println(".--------------------------------------------------------------.");
            System.out.printf("|%-8s |%-40s |%-8s  |%n", "OPTION", "MENU", "PRICE");//printf to print menu header
            System.out.println("|---------+-----------------------------------------+----------|");
 
            for(int i = 0; i <length; i++){//ITERATE 'LENGTH' TIMES THOROUGH EACH MENU ITEM AND PRICE
                if(!isMultiplier){//if it is not a multiplier menu option
                System.out.printf("|%-8s |%-40s |+$%-8s|%n", (i+1) + ".", menu[i], moneyFormat.format(prices[i]));//print it with a plus sign
                }else{//if not
                System.out.printf("|%-8s |%-40s |x%-8s |%n", (i+1) + ".", menu[i], moneyFormat.format(prices[i]));//print it with a multiplication sign
                }
            }
            System.out.println("'--------------------------------------------------------------'");
           
	        try{//try the input to catch when a string is inputted
	            choice = Integer.parseInt(br.readLine());//input choice after menu is outputted
	        }catch(Exception e){//triggers when a string is entered instead of an int//NumberFormatException
	            System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
	            chosen = false;//DO WHILE LOOP WILL RUN AGAIN
	            continue;//don't need to run selection if input is invalid
	        }
 
            switch(choice){//switch case for corresponding choice
                case 1:
                    if(length >= 1){
                        System.out.println(messages[0]);//display the message they see when they order this item
                        stringAdd = options[0]; //ready to return this value (the name of what they ordered)
                        currentItems.add(menu[0]);
                        if(!isMultiplier){//if it is not a multiplier type:
                            drinkPrice += prices[0];//add to the total
                            currentPrices.add("+$"+moneyFormat.format(prices[0]));
                        }else{//if not
                            drinkPrice *= prices[0];//multiply the total
                            currentPrices.add("x"+moneyFormat.format(prices[0]));
                        }
                        break;//BREAK INSIDE THE IF STATEMENT - THIS IS IMPORTANT BECAUSE IF THEY ENTER SOMETHING LARGER THAN LENGTH, IT WON'T BREAK AND WILL TRIGGER THE DEFAULT CASE WHICH ERRORCHECKS
                    }
                case 2:
                    if(length >= 2){
                        System.out.println(messages[1]);
                        stringAdd = options[1];
                        currentItems.add(menu[1]);
                        if(!isMultiplier){
                            drinkPrice += prices[1];
                            currentPrices.add("+$"+moneyFormat.format(prices[1]));
                        }else{
                            drinkPrice *= prices[1];
                            currentPrices.add("x"+moneyFormat.format(prices[1]));
                        }                        
                        break;
                    }                
                case 3:
                    if(length >= 3){
                        System.out.println(messages[2]);
                        stringAdd = options[2];
                        currentItems.add(menu[2]);
                        if(!isMultiplier){
                            drinkPrice += prices[2];
                            currentPrices.add("+$"+moneyFormat.format(prices[2]));
                        }else{
                            drinkPrice *= prices[2];
                            currentPrices.add("x"+moneyFormat.format(prices[2]));
                        }
                        break;
                    }    
                case 4:
                    if(length >= 4){
                        System.out.println(messages[3]);
                        stringAdd = options[3];
                        currentItems.add(menu[3]);
                        if(!isMultiplier){
                            drinkPrice += prices[3];
                            currentPrices.add("+$"+moneyFormat.format(prices[3]));
                        }else{
                            drinkPrice *= prices[3];
                            currentPrices.add("x"+moneyFormat.format(prices[3]));
                        }
                        break;
                    }    
                case 5:
                    if(length >= 5){
                        System.out.println(messages[4]);
                        stringAdd = options[4];
                        currentItems.add(menu[4]);
                        if(!isMultiplier){
                            drinkPrice += prices[4];
                            currentPrices.add("+$"+moneyFormat.format(prices[4]));
                        }else{
                            drinkPrice *= prices[4];
                            currentPrices.add("x"+moneyFormat.format(prices[4]));
                        }
                        break;
                    }  
                case 6:
                    if(length >= 6){
                        System.out.println(messages[5]);
                        stringAdd = options[5];
                        currentItems.add(menu[5]);
                        if(!isMultiplier){
                            drinkPrice += prices[5];
                            currentPrices.add("+$"+moneyFormat.format(prices[5]));
                        }else{
                            drinkPrice *= prices[5];
                            currentPrices.add("x"+moneyFormat.format(prices[5]));
                        }
                        break;
                    }  
                case 7:
                    if(length >= 7){
                        System.out.println(messages[6]);
                        stringAdd = options[6];
                        currentItems.add(menu[6]);
                        if(!isMultiplier){
                            drinkPrice += prices[6];
                            currentPrices.add("+$"+moneyFormat.format(prices[6]));
                        }else{
                            drinkPrice *= prices[6];
                            currentPrices.add("x"+moneyFormat.format(prices[6]));
                        }
                        break;
                    }    
                case 8:
                    if(length >= 8){
                        System.out.println(messages[7]);
                        stringAdd = options[7];
                        currentItems.add(menu[7]);
                        if(!isMultiplier){
                            drinkPrice += prices[7];
                            currentPrices.add("+$"+moneyFormat.format(prices[7]));
                        }else{
                            drinkPrice *= prices[7];
                            currentPrices.add("x"+moneyFormat.format(prices[7]));
                        }
                        break;
                    }    
                default:
                    System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                    chosen = false;//DO WHILE LOOP WILL RUN AGAIN
                }//end of switch case
       
        }while(!chosen);//while option has not been chosen
        return stringAdd;//return the topping/flavour chosen to be added to the baseTea
    }//end of orderMenu method
 
    static void tip(int tipChoice) throws IOException{
    //method to select tip percentage based on parameter tipChoice, which is inputted by the user
        do{//do loop to make sure they enter a valid number before we move on
            chosen = true;//do loop will not run as long as a valid option is entered
            switch(tipChoice){//switch case for tip amount choice
                case 1:
                    tipPercentage = 0.1;//set tip percentage based on choice
                    break;
                case 2:
                    tipPercentage = 0.15;
                    break;
                case 3:
                    tipPercentage = 0.2;
                    break;
                case 4:
                    tipPercentage = 0.25;
                    break;
                case 5:
                    do{
                        System.out.println("How much would you like to tip? Not zero right "+name+"? I have a family to feed");
                        System.out.print("<don't add a % sign>");
                       
                        chosen = true;
                        try{//try the input to catch when a string is inputted
                        	tipPercentage = Integer.parseInt(br.readLine());//let them choose their percentage
                        }catch(Exception e){//triggers when a string is entered instead of an int
                            System.out.println("Hey! Tipping shouldn't be treated as a joke. I work very hard");//UFP if they don't select a menu option
                            chosen = false;
                            continue;
                        }
                        if(tipPercentage < 0 || tipPercentage > 500){//errorcheck exceptional values, upper range is 500 because some very generous people might tip more than 100%
                            System.out.println("Hey! Tipping shouldn't be treated as a joke. I work very hard");//UFP if they don't select a menu option
                            chosen = false;
                        }
                    }while(!chosen);
                    tipPercentage /= 100;//convert percentage to decimal for operation
                    break;
                    default:
                        System.out.println("Listen here "+name+", stop messing around and select a valid option before I kick you out of the store");//UFP if they don't select a menu option
                        chosen = false;//make it unable to exit the loop as they still need to input a valid option
            }//end of tip choice switch
        }while(!chosen);//while option has not been chosen
 
    }//end of tip method
 
    static void printMenu(int length, String type, String[] menu, double[] prices, boolean isMultiplier){
    //THIS MENU PRINTS THE MENU FOR A CERTAIN CATEGORY, MEANT TO BE CALLED MULTIPLE TIMES FOR MULTIPLE CATEGORIES
    //parameters:   length: the amount of items in this category
    //              type: the name of the category, to be outputted at the top
    //              menu: the items on the menu - to be printed
    //              prices: the prices on the menu - to be printed
    //              isMultiplier: changes some outputs based on if the category adds prices or multiplies the total
   
    	System.out.println(type);//output the category at the top
 
        System.out.println(".--------------------------------------------------------------.");
        System.out.printf("|%-8s |%-40s |%-8s  |%n", "OPTION", "MENU", "PRICE");//printf to print menu header
        System.out.println("|---------+-----------------------------------------+----------|");
 
        for(int i = 0; i <length; i++){//iterate through all of the elements in the category
            if(!isMultiplier){//if it is not a multiplier type category
                System.out.printf("|%-8s |%-40s |+$%-8s|%n", (i+1) + ".", menu[i], moneyFormat.format(prices[i]));//print it with a plus sign
            }else{//if not
                System.out.printf("|%-8s |%-40s |x%-8s |%n", (i+1) + ".", menu[i], moneyFormat.format(prices[i]));//print it with a multiplication sign
            }
        }
        System.out.println("'--------------------------------------------------------------'");
    }//end of printMenu method
   
    static void printReceipt(){
    //FUNCTION USED TO PRINT THE RECIEPT
    	System.out.println("RECEIPT");
    	System.out.println("\n===========================================================================");
    	System.out.println(SHOPNAME);//output SHOPNAME constant
        System.out.println("\"Delicious Teas!\"");
        System.out.println("201 Town Centre Blvd, Markham, ON");
        System.out.println("Tel: "+PHONENUM);//output PHONENUM constant
        System.out.println("===========================================================================");
        for(int i = 0; i < orders.size(); i++){//iterate through the size of LinkedList order
            System.out.println(customerNames.get(i)+"'s order: ");//customerNames.get(i) will cover all of the elements in the array as the for loop iterates
            System.out.println(orders.get(i));//same idea as previous line
            System.out.println(">> QTY: "+quantities.get(i));//same idea as previous line
            System.out.println(">> $"+moneyFormat.format(orderPrices.get(i)));//same idea as previous line, but we use our moneyFormat object to format the decimal
        }
       
        System.out.println("===========================================================================");
        System.out.println("Subtotal: $"+moneyFormat.format(totalPrice));//format to two decimal places
        System.out.println("HST: $"+moneyFormat.format(hst));
        System.out.println("Tip: $"+moneyFormat.format(tipAmount));
        System.out.println("Total: $"+moneyFormat.format(total));
        System.out.println("===========================================================================");
    }//end of printRecipt method
}//end of class