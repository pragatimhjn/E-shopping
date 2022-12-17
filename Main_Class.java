package project_pkg;
import java.io.FileWriter;
import java.util.*;

import Crud.MenuList;


public class Main_Class {

    private static ArrayList<Category> categories = new ArrayList<>();

    public static void main(String[] args) {

    	System.out.println("***************************************************************************************");
    	System.out.println("");
        System.out.println("                        Welcome to Online Shopping Project by Pragati");
    	System.out.println("");
    	System.out.println("***************************************************************************************");
    	System.out.println("");
    	
        //Creating and Adding items to first category    	
        Category category_1 = new Category("Cloths","Amazon");

        category_1.addItem("Red-Jacket","Columbia",1200.00);
        category_1.addItem("Denim","Levis",1500.00);
        category_1.addItem("T-shirt","US Polo",800.00);
        category_1.addItem("Saree","Hastkala",1150.00);
        category_1.addItem("Dress","Kriya",2500.00);
        category_1.addItem("Pants","FabIndia",3000.00);
        category_1.addItem("Kurti","Orly",1600.00);
        category_1.addItem("Scarf","Aurelia",499.99);
        category_1.addItem("Silk-Saree","Lila Sarees",5000.00);

        categories.add(category_1); 
        
        //Creating and Adding items to second category    	
        Category category_2 = new Category("Shoes","Flipkart");

        category_2.addItem("Running-Shoes","Nike",1999.99);
        category_2.addItem("Leather-Shoes","Hush Puppies",1500.00);
        category_2.addItem("Casual-Walking-Shoes","Skechers",2800.00);
        category_2.addItem("Boots","Bata",1200.00);
        category_2.addItem("Loafers","Reebok",2300.00);
        category_2.addItem("Sandals","Puma",999.99);
        category_2.addItem("Ballet-Flats","Fila",1700.00);
        category_2.addItem("Flip-Flops","Adidas",1150.00);
        category_2.addItem("High-Heels","Happy Heels",1299.00);
        category_2.addItem("Sneakers","New Balance",3000.00);

        categories.add(category_2);
        
        //Creating and Adding items to second category    	
        Category category_3 = new Category("Handbags","Myntra");
        category_3.addItem("Sling-Bag","Lavie",999.99);
        category_3.addItem("Tote-Bag","Baggit",1499.99);
        category_3.addItem("Handbag1","ABC",1900.00);
        
        categories.add(category_3);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


    	System.out.println("");

        System.out.println("------------------------------List of All Categories and Seller----------------------");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


        java.util.Iterator itr =  categories.iterator();
    	System.out.println("");
        int count = 1;
        while (itr.hasNext())
        {
         
       	 Category c =  (Category) itr.next();
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}


       	 System.out.println(count+". "+c.cat_type + ":" + c.seller);
       	 count++;
        }
    	System.out.println("");


        LinkedList<Item> cart_1 = new LinkedList<>();

        categories.get(0).addToCart("Red-Jacket",cart_1);
        categories.get(0).addToCart("Saree",cart_1);
        categories.get(0).addToCart("Scarf",cart_1);
        categories.get(1).addToCart("Boots",cart_1);
        categories.get(1).addToCart("Running-Shoes",cart_1);
        categories.get(1).addToCart("Sandals",cart_1);
        
        System.out.println(" ");
        System.out.println("======================================================================================");
        System.out.println(" ");

		try
		{
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


        display(cart_1);
        
//        LinkedList<Item> cart_2 = new LinkedList<>();
//        System.out.println("======================================");
//        display(cart_2);
 
        
    }

    private static void display(LinkedList<Item> Cart){

        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean next = true;
        ListIterator<Item> listIterator = Cart.listIterator();
        
        if(Cart.size() == 0){
         System.out.println("Add items to the cart..");
         
       }else {
          System.out.println("Display Item in Cart: " + listIterator.next().toString());
          System.out.println("");
          }
        printMenu();        
        Db d = new Db();

        int ch;
        while(!quit){
        	System.out.println("Enter Your Choice To Continue Shopping:");
        	ch  = sc.nextInt();

            switch (ch){
            case 1:
//            	Show all items
            {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Showing All Items List");
            System.out.println("----------------------------------------------------------------------");

            for (int i=0;i<categories.size();i++) {
            System.out.println(categories.get(i).cat_type);
            System.out.println();

            categories.get(i).show();
     		try
     		{
     			Thread.sleep(2000);
     		}
     		catch(Exception e)
     		{
     			System.out.println(e);
     		}

            }
            break;
            }
            case 2:
            	//Add to cart
            {
            	System.out.println("Please add item to cart:");
//               LinkedList<Item> cart_1 = new LinkedList<>();
                String cat_choice;
                System.out.println("Choose Category:");
                cat_choice = sc.next();                   
                
                for(int i=0;i<categories.size();i++){
                if (categories.get(i).cat_type.equals(cat_choice)){
                	String user_choice;
                    System.out.println("Enter item to be added:");
                    user_choice= sc.next();
                    categories.get(i).addToCart(user_choice,Cart);
                   display(Cart);
                }
                }
                System.out.println("This category is not in the list");

                 break;

            }


             case 3:
//            	Display All Items in Cart
             	System.out.println("Added items to your shopping cart:");
                printItemsList(Cart);
                break;
              case 4:
            	// Display Current Item in Cart

                if(next){
                    if(listIterator.hasPrevious()){
                        System.out.println("Now displaying "+listIterator.previous().toString());
                        next = false;
                    }else {
                        System.out.println("We are at the start of the list");
                    }
                }else {
                    if(listIterator.hasNext()){
                        System.out.println("Now displaying "+listIterator.next().toString());
                        next = true;
                    }else {
                        System.out.println("No current item to show..");
                    }
                }
                printMenu();

                break;


               case 5:
            	    //Display Next Item in Cart
                    if(!next){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        next = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Currently Displaying "+listIterator.next().toString());
                    }else {
                        System.out.println("Something went wrong..No next item to show ");
                        next = false;
                    }
                    printMenu();

                    break;
                case 6:
//                	Display Previous Item in Cart
                    if(next){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        next = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now displaying "+listIterator.previous().toString());
                    }else {
                        System.out.println("This is first item,can't show previous item");
                        next = false;
                    }
                    printMenu();

                    break;
                case 7:
                	//Remove item from cart
                    if (Cart.size() >0){
                        listIterator.remove();
                        System.out.println("Item removed");
                        if(listIterator.hasNext()){
                            System.out.println("Now Displaying "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("Now Displaying "+listIterator.previous().toString());
                        }
                    }
                    
//                    System.out.println("This is empty cart");
                    printMenu();
                        break;

                case 8:
                	//Payment
                {
                    System.out.println("Thank You For Shopping With Us");
   
                	System.out.println("Redirected To Payment Page");
                       quit = true;
                        
                    }
                break;
                case 9:
//                Display All Categories

                {
                    System.out.println("List of All Categories and Seller: ");
                    java.util.Iterator itr =  categories.iterator();
                    while (itr.hasNext())
                    {
                   	 Category c =  (Category) itr.next();
                   	 System.out.println(c.cat_type + ":" + c.seller);
                    }
                    printMenu();

                   break;                   	
                }

                                
                case 10:
//                	Print Menu List
                    printMenu();
                    break;
                case 11:
                {
                	
                    System.out.println("Adding Customer..");
                    d.add_record();
                    
                    break;
                }
                case 12:
                {
                	
                    System.out.println("Updating Customer..");
                    d.edit_record();
                    
                    break;
                }
                case 13:
                {
                	
                    System.out.println("Displaying All Customers..");
                    d.display_records();
                    
                    break;
                }
                case 14:
                {
                	
                    System.out.println("Deleting Customer..");
                    d.remove_record();
                    
                    break;
                }
                case 15:
                {
                	
                    System.out.println("Thank You For Shopping With Us");
                    quit = true;
                    break;
                }
                
                case 16:
                {
                	
                    System.out.println("File Handling");
                    try 
                    {
                   	 FileWriter f = new FileWriter("E:/Java/File Handling/project.txt");                    
                     f.write("List of All Categories and Seller:\n ");

                   	 java.util.Iterator itr =  categories.iterator();
                   	 while (itr.hasNext())
                     {
                    	 Category c =  (Category) itr.next();
                     
                        f.write("    Category :  "+c.cat_type);
                        f.write("    Seller :  "+c.seller);
                        f.write("\n");
                        
                     }
                 f.close();
                   System.out.println("New Data written in file successfully");

                    }
                    catch (Exception e)
                    {
                   	 System.out.println(e);
                    }


                    break;
                }


                default:
                	System.out.println("Please Enter Valid Choice to Continue Shopping!!!");

                    }
        }
}

    private static void printMenu(){
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

        System.out.println("======================================================================================");
 		try
 		{
 			Thread.sleep(200);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("Available Choices\n ");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("1 - Display Categorywise Items List \n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("2 - Add to Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("3 - Display All Items in Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("4 - Display Current Item in Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("5 - Display Next Item in Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("6 - Diplay Previous Item in Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("7 - Remove Current Item in Cart\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("8 - Proceed to Payment\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("9 - Display All Categories\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("10 - Display MenuList \n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("11 - Add Customer\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("12 - Update Customer Info\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("13 - Display Customer Info\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("14 - Delete Customer Info\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("15 - Exit\n");
 		try
 		{
 			Thread.sleep(500);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}

        System.out.println("16 - Add data to file");

        
    }

    private static void printItemsList(LinkedList<Item> Cart){
        Iterator<Item> iterator = Cart.iterator();
        System.out.println("----------------------------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------------");
    }


}