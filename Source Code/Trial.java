// Name: Hassan Akbar
// EmplID: 23768057
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 1

//*********************************************************************************

import java.io.*; // import file class
import java.util.Scanner; // import scanner

public class Trial {
  
//*********************************************************************************
 public static void main(String[] args) throws IOException {
   

   // array list with artist and track objects would be better for this assignment
   // quicksort would also be a better sorting method to use

   // sense we are using an array we either need to set the size
   // or read the data once to count the items
   // an arraylist would be better for this
   // could remove song limit
   // makes it harder to count though with methods
   // because of local variables
   // an arraylist would fix this aswell by making an object
   // with the array list
   
   int songLimit = 50;
   // can be increased
   // could be removed but would then need to read the data first to see ehat
   // size array to make
   // arraylist of artist objects that have track objects would be more ideal
   // an arraylist can also grow and shrink
   // can also just set a high songLimit
   
   int cols = 3;  //  name, appears, views data members
   int rows = songLimit; // artist records
   String[][] myList = new String[rows][cols]; //String 2D array


   // since we have an array of strings it would be difficult to store more data
   // ideally a array list of class artists with track objects as a data member would be better
   
   
  
     
//*********************************************************************************     
     
   // open and read the input file
   // could be made a method
   // this makes it easier to keep track of counts because we are using an array though
   // could make a method that returns an object with the relevant data though
   File inFile = new File("input.txt");
     
   // reading input in main so it is easier to count the artists and songs
   // a normal array makes this difficult

   //create Scanner object
   Scanner sc = new Scanner(inFile);
       
   String line;
     
   line = sc.nextLine();// skip unneeded line
   line = sc.nextLine(); // skip unneeded line
   // 3rd line is where the data starts
     
   int count = 0;  // number of songs read in
   int artistCount = 0; // number of artists read in
   int totalViews = 0;
   
     
   while (sc.hasNext() && count < songLimit ) {
      
     //read next line of data 
     line = sc.nextLine();
       
     // data stored as
     // position,    track name,    artist,     streams,      url
   
     String[] tokens = line.split(","); //tokenize a String using method split()
     // problem with splitting when song names have , in the title
     // can't think of a way to account for it
     // could count the number of tokens and if it is greater than index 4
     // this means a problem happened
     // dont know how to tell where the problem happened and correct for it though
     // can use the array.length data member to see how many tokens are made
     // if length is gretater > that 5 there is a problem
     // could skip this entry
     // not sure how to fix it without actually seeing where the problem is
   
     String artistName = tokens[2];
   
     artistName = artistName.replaceAll("\"" , "");
     //remove the "" around some names
   
     String views = tokens[3];
   
     int v = Integer.parseInt(views);
   
     totalViews = totalViews + v;
   
     boolean newArtist = true;
   
     for (int index = 0; index < artistCount; index++){
      // checking if the artist name is repeated
      // could be done seperately but probably better to search while making 
      // the array 
     
      if (myList[index][0].equals(artistName)){
       
        int times = Integer.parseInt(myList[index][1]);
        times++;
       
        int artistViews = v + Integer.parseInt(myList[index][2]);
       
        myList[index][1] = "" + times ;
        myList[index][2] = "" + artistViews ;
       
        newArtist = false;
       
      }
     
    }
   
    if (newArtist){
     
      myList[artistCount][0] = artistName;
      myList[artistCount][1] = "1";
      myList[artistCount][2] = views;
     
      artistCount++; // artist count up
     
    }
   
    count++;// song count up
   
 
   }
     
     
   sc.close();
   
//*********************************************************************************        
   // print initial array
   // the array is unsorted
   // arrays are difficult to deal with because they can only contain one type of data
   // array list would be better
   // could make this a method
     
     
     
   PrintWriter outFile = new PrintWriter("myoutput1.txt");   // file
   // PrintWriter outFile = new PrintWriter(System.out); // screen
     
    
     
   outFile.println(" Hassan Akbar"); 
   outFile.println(" CISC 3130");
   outFile.println(" Professor Chuang");
   outFile.println(" HW 1");
   outFile.println();
     
     
   outFile.println("Number of Songs Read in: " + songLimit);
     
   outFile.println("Number of Artists Read in: " + artistCount);
     
   outFile.println("Total Views: " + totalViews);
     
   outFile.println();
     
   outFile.printf("%-25s %-25s %-25s", "Artist Name","Times Appeared","Views");
     
   outFile.println();
   // done to artist limit so null is not printed
   for (int index = 0; index < artistCount; index++){
       
       outFile.printf("%-25s %-25s %-25s",
                     myList[index][0],myList[index][1],myList[index][2]);
       outFile.println();
       outFile.flush();
       
   }
     
     
     
     
    outFile.flush();
    outFile.close();
     
     
    //close the output file
     
     
//*********************************************************************************    
    // sort the array in alphabetical order
    // could make this a method
    // bubble sort could use another sort
    // quicksort would be better
    // easier to sort the data before putting it in the list
    // for a linkedlist that sorts insertion sort would probably be good
    // will use compareToIgnoreCase
    // this is so a name that begins with lower case will be in proper alphabetical
    // order
    // other wise A to Z and then a-z will be the order
    // this is not intuitive for an alphabetical list
    
    String temp1;
    String temp2;
    String temp3;
    
    for (int index = 0; index < artistCount; index++){
        
      for (int j = 0; j < artistCount - 1 ; j++){
          
        if (myList[j+1][0].compareToIgnoreCase(myList[j][0]) < 0) { // ignore case
            
          temp1 = myList[j+1][0];
          temp2 = myList[j+1][1];
          temp3 = myList[j+1][2];
            
            
          myList[j+1][0] = myList[j][0];
          myList[j+1][1] = myList[j][1];
          myList[j+1][2] = myList[j][2];
              
          myList[j][0] = temp1;
          myList[j][1] = temp2;
          myList[j][2] = temp3;
              
        }
        
        
        
      }
     
           
    }
   
     
//*********************************************************************************     
     
    // fill the linked list 
    // could be made a method  
     
    TopStreamingArtists linkedList= new TopStreamingArtists() ;
     
        
    for (int index = 0; index < artistCount; index++){
       
       linkedList.insertArtistLast(myList[index][0],myList[index][1],myList[index][2]);
       // insert the artist from the array into the linkedlist
       
    }
     
//*********************************************************************************     
    // print linked list
    // printing to a different file than the unsorted array
     
   
    PrintWriter outFile2 = new PrintWriter("myoutput2.txt");   // file
     
    outFile2.println(" Hassan Akbar"); // print info to output file
    outFile2.println(" CISC 3130");
    outFile2.println(" Professor Chuang");
    outFile2.println(" HW 1");
    outFile2.println();
     
    outFile2.println("Printed Linked List in Alphabetical Order");
     
    outFile2.println(linkedList);
     
    outFile2.flush();
    outFile2.close();
      
      
//*********************************************************************************
     
    System.out.println("****************************************"+
                       "*********************************************");
    System.out.println("The program is terminating");
    System.out.println("********************************************"+
                       "********************************************");
    // outputs to the screen the program has finished
     
 }
 

     
//*********************************************************************************
 
}





 