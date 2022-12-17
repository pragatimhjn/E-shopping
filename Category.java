package project_pkg;

import java.util.ArrayList;
import java.util.LinkedList;
//Category of Items
public class Category {
    String cat_type; 
    String seller;
    private ArrayList<Item> items;             //ArrayList of Items
    
    //Constructor
    public Category(String cat_type, String seller ) {
        this.cat_type = cat_type;
        this.seller = seller;
        this.items = new ArrayList<Item>();
        
    }
    public Category(){
     //constructor overloading
    	
    }

    public Item findItem(String item_name){

        for(Item available_item : items){
            if(available_item.getItem_name().equals(item_name)) return available_item;
        }
        return null;
    }
    
    public boolean addItem(String item_name,String item_brand, double price){
        if(findItem(item_name) == null){
            items.add(new Item(item_name,item_brand,price));
//            System.out.println(item_name + "successfully added to the list");
            return true;
        }
        else {
           System.out.println("Item with name "+ item_name+ " already exists in the items list");
            return false;
        }
    }

    public boolean addToCart(int itemNumber, LinkedList<Item> Cart){
        int index = itemNumber - 1;
        if(index > 0 && index <= this.items.size()){
            Cart.add(this.items.get(index));
            return true;
        }
//        System.out.println("this category does not have item with  Item Number "+itemNumber);
        return false;
    }

    public boolean addToCart(String item_name, LinkedList<Item> Cart){
        for(Item available_item : this.items){
            if (available_item.getItem_name().equals(item_name)){
                Cart.add(available_item);
                return true;
            }
        }
        System.out.println("There is no such item in this category: "+item_name);
        return false;
        
    }
  public void show() {
      for (int i = 0; i < items.size(); i++) { 
              System.out.println(items.get(i) + " "); 
          } 
          System.out.println(); 
      } 

  
}