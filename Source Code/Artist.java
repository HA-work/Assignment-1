// Name: Hassan Akbar
// EmplID: 23768057
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 1

//*********************************************************************************

 class Artist {
  
    private String name;
    public Artist next;
    public Artist prev;
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
      
      name = n;
     
      timesAppeared = Integer.parseInt(num);
      artistViews = Integer.parseInt(v);
     
      next = null;
      prev = null;
     
    }
    
//*********************************************************************************    
    
    
 /* Method String toString():
  * 
  * Input:
  *    None
  * Process:
  *    makes a formatted string
  * Output:
  *    Returns a formated string of the Artist object
  */
 //toString() method - uses String static method .format()
 public String toString() {
  String str = String.format("%-25s %-25d %-25d", name, timesAppeared,artistViews);
  
  return str;
 }

    
//*********************************************************************************   
    
}