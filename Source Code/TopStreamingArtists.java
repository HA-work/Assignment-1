// Name: Hassan Akbar
// EmplID: 23768057
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 1

//*********************************************************************************

 class TopStreamingArtists {
  
    private Artist first; // first artist in the list
    private Artist last; // last artist in the list
    private int count; // number of artists in the list
    private int songsRead; // number of songs read in
    private int totalViews; // total views of all artists
    
//*********************************************************************************  
    
 //No-Arg Constructor
 
 /* Method public TopStreamingArtists():
  * 
  * Input:
  *    None
  * Process:
  *    creates Artist object
  *    Sets Strings to null string
  *    sets int data members to 0
  * Output:
  *    None
  */    
    
    public TopStreamingArtists(){
      first = null;
      last = null;
      count = 0;
      songsRead = 0;
      totalViews = 0;
      
    }
    
    
//*********************************************************************************    
    
/* Method public boolean isEmpty():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the linked list is empty
  *    returns true if it is
  *    false if its not
  * Output:
  *    None
  */      
    
    
    
    public boolean isEmpty(){
     return (first == null);
    }
    
    
 //*********************************************************************************   
    
     
/* public void insertArtistLast(String name, String num, String v):
  * 
  * Input:
  *    String name the artist name
  *    String num the number of times the artist appeared
  *    String v the total views of the artist
  *    
  * Process:
  *    creates a new artist object
  *    if the list is empty it makes the object the first and last item
  *    if it is not it makes the new object the last item and makes the 
  *    objects point to eachother
  * 
  *    increments count
  *    adds to the song limit and total views
  * 
  *    the data being inserted is already sorted in alphabetical order
  *    so we use this method
  *   
  * Output:
  *    None
  */    
    
    // maybe better to make a linked list that sorts the data itself
    // more effort needed though
    
   public void insertArtistLast(String name, String num, String v){ 
    // Create the new node
    Artist add = new Artist(name, num, v);
    if( isEmpty() ) {
      last = add; // sets first artist as first and last
      first = add;
      count++;
      
      songsRead = songsRead + add.timesAppeared;
      totalViews = totalViews + add.artistViews;
      
    } else{
     
      last.next = add; // makes the last object's next point to the one to be added
      add.prev = last; // makes the new objects previous point to the last
      last = add; // makes last point to the one to be added
      count++; // increments artist count
      
      songsRead = songsRead + add.timesAppeared; // increases songs read in
      totalViews = totalViews + add.artistViews; // increases total views
      
    }
  
   }

//*********************************************************************************   
   
    
/* public void insertArtistFirst(String name, String num, String v):
  * 
  * Input:
  *    String name the artist name
  *    String num the number of times the artist appeared
  *    String v the total views of the artist
  *    
  * Process:
  *    creates a new artist object
  *    if the list is empty it makes the object the first and last item
  *    if it is not it makes the new object the first item and makes the 
  *    objects point to eachother
  * 
  *    increments count
  *    adds to the song limit and total views
  * 
  * Output:
  *    None
  */       
   
   // could add to the first and go in revrese order of the presorted items
   
   
   // not really needed and not used in my code
    public void insertArtistFirst(String name, String num, String v){ 
    
    Artist add = new Artist(name, num, v);
    if( isEmpty() ) {
      last = add;
      add.next = first;
      first = add;
      count++;
      
      songsRead = songsRead + add.timesAppeared;
      totalViews = totalViews + add.artistViews;
      
    } else{
     
      first.prev = add;
      add.next = first;
      first = add;
      count++;
      
      songsRead = songsRead + add.timesAppeared;
      totalViews = totalViews + add.artistViews;
      
      
    }
  
   }
   
   
//*********************************************************************************  
    
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the linked list
  * Output:
  *    None
  */       
    
   public String toString() {
     
    String str = String.format("Number of Songs Read in: %d %n", songsRead);
  
    String str2;
  
  
    str2 =  String.format("Number of Artists Read in: %d %n", count);
    str = str + str2;
    
   
    
    str2 =  String.format("Total Views: %d %n", totalViews);
    str = str + str2;
    
   
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
  
  
     
    str2 = String.format("%-25s %-25s %-25s %n","Artist Name","Times Appeared","Total Views");
     
    str = str + str2;
     
      
   
     
     
     //current starts from first
     Artist current = first;
     //move forward
     while(current != null) {
     
     
      //    for (int index = 0; index < count; index++){} // alternate loop using count
       
      str2 =  current.toString();
      str = str + str2;
       
      str2 =  String.format("%n");
      str = str + str2;
    
      
      current = current.next;
       
     }
    
    
     return str;
   
   }
   
//*********************************************************************************   
}
    
    
    
    
    
    
 