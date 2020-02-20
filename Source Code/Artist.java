// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 1

//*********************************************************************************

 class Artist {
  
    private String name; // artist name
    public Artist next; // next artist in the list
    public Artist prev; // previous artist in the list
    public int timesAppeared; // could be String but int is better
    public int artistViews;
    
//*********************************************************************************    
    
 //No-Arg Constructor
 
 /* Method public Artist():
  * 
  * Input:
  *    None
  * Process:
  *    creates Artist object
  *    Sets Strings data members to null string
  *    sets int values to 0
  * Output:
  *    None
  */
    
    public Artist() {
  
     name = "";
     timesAppeared = 0;
     artistViews = 0;
     next = null;
     prev = null;

   }
    
    
//*********************************************************************************    
//Parametized Constructor
 
 /* Method public Artist(String n, String num, String v):
  * 
  * Input:
  *    String n the artists name
  *    String num the times the artist appeared
  *    String v the views of the artist
  * Process:
  *    creates Artist object
  *    Sets the parameters to the input
  *    parses String that represent numbers
  * Output:
  *    None
  */
   
    public Artist(String n, String num, String v){
      
      name = n; // set artist name
     
      timesAppeared = Integer.parseInt(num); // set artist times appeared need to parse the Sting
      artistViews = Integer.parseInt(v); // set the number of views need to parse the String
     
      next = null; // set next to null
      prev = null; // set prev to null
     
    }
    
//*********************************************************************************    
    
    
 /* Method String toString():
  * 
  * Input:
  *    None
  * Process:
  *    makes a formatted string
  * Output:
  *    Returns a formated string of the Artist object for printing
  */
 //toString() method - uses String static method .format()
 public String toString() {
  String str = String.format("%-25s %-25d %-25d", name, timesAppeared,artistViews);
  
  return str;
 }

    
//*********************************************************************************   
    
}
