package project_pkg;

public class Item {
	    //class variables
        private String item_name;
   		private String item_brand;
        private double price;
        //constructor
		public Item(String item_name, String item_brand, double price) {
			this.item_name = item_name;
			this.item_brand = item_brand;
			this.price = price;
		}
		public Item() {
			//constructor overloading
		}
		//getter methods
		 public String getItem_name() {
				return item_name;
			}
		public String getItem_brand() {
				return item_brand;
			}
		public double getPrice() {
				return price;
			}
	  //method to display item description
		@Override
		public String toString() {
			return "Item Name:" + item_name + ",  Brand:" + item_brand + ",  Price:" + price ;

		}
		
			
        
}
