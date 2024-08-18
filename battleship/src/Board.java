public class Board{

    private String[][] squares = new String[10][10];
      
    public Board(){
        
     for (int r = 0; r < squares.length; r++)
     {
      for (int c = 0; c < squares[0].length; c++)
      {
        squares[r][c] = "-";
        }
     }      
    }
  
    public String toString(){
      String line = "";
  
      
      for (int r = 0; r < squares.length; r++)
      {
  
        for (int c = 0; c < squares[0].length; c++)
        {
          line = line + squares[r][c] + " ";
        }
          //System.out.println(line);
        line = line +"\n";
      }   
     
     
      return line;
    }
  
    public boolean addShip(int row, int col, int len, boolean horizontal){
    
      boolean emptycell = false;
      if(row < 0 || row > 9 || col < 0 || col > 9 || len > 10)
      {
        return false;
      }
      
      if(horizontal){
        if(len + col > 10){
          return false;
        }
        //check for empty target cells
        for (int i = col; i < (len + col); i++)
        {
          if(squares[row][i].equals("-")){
            emptycell = true;
  
          }
          else{
            return false;
          }
        } 
        if(emptycell == true){
          for (int i = col; i < (len + col); i++)
          { 
            
            squares[row][i] = "b";
            
          } 
        }
       }
       else{//vertical
        if(len + row > 10){
            return false;
        } 
        emptycell = false;
        
        for (int i = row; i < (len + row); i++)
        {
          if(squares[i][col].equals("-")){
            emptycell = true;
  
          }
          else{
            return false;
          }
        } 
        if(emptycell == true){
          for (int i = row; i < (len + row); i++)
          { 
            
            squares[i][col] = "b";
            
          } 
        }
       return true; 
      }
      return true;
    
    }
    public boolean foundShip(int len){
      int count = 0;
      //row by row scan
      for (int r = 0; r < squares.length; r++)
     {
        count = 0;
        for (int c = 0; c < squares[0].length; c++)
        {
          if(squares[r][c].equals("b"))
          {
            count++;
          }
          //if the next cell is empty then check then count to see if a ship was found
          //if not then reset the counter.  len = 3
          //b b b - - - - - b -
          //
          //
          else if (count == len )//found a ship
          {
            return true;
          }
          else count = 0;//reset counter
        }
        /* if(count == len )
        {
          return true;
        } */
     }      
     for (int c = 0; c < squares.length; c++)
     {
        count = 0;
        //col by col
        for (int r = 0; r < squares[0].length; r++)
        {
          if(squares[r][c].equals("b"))
          {
            count++;
          }
          //if the next cell is empty then check then count to see if a ship was found
          //if not then reset the counter.  len = 4
          //b b b - - - - - b - 
          //- - - - - - - - b - 
          //- - - - - - - - b - 
          //- - - - - - - - - - 
          //- - - - b - - - b - 
          else if (count == len )//found a ship
          {
            return true;
          }
          else count = 0;//reset counter
        }
        /* if(count == len )
        {
          return true;
        } */
     }      
      
      return false;
    }
/*  b b b - - - - - b - 
    - - - - - - - - b - 
    - - - - - - - - b - 
    - - - - - - - - - - 
    - - - - b - - - - - 
    - - - - b - - - - - 
    - - - - b - - - - - 
    - - - - b - - b - - 
    - - - - - - - b - - 
    - - - - - - - b - b    */
    public int shoot(int row, int col){
      
      if(row < 0 || row > 9 || col < 0 || col > 9){
        return -1;
      }
      if(squares[row][col].equals("-"))
      {
        squares[row][col] = "m";
        return 0;
      }
      else if(squares[row][col].equals("b"))
      {
        squares[row][col] = "x";
        return 1;
      }    
      else if(squares[row][col].equals("x") || squares[row][col].equals("m"))
      {
        return 2;
      }
      else{ 
        System.out.println("shoot: nothing found");

        return -1;
      }
    }
  
    public boolean gameOver(){
      for (int r = 0; r < squares.length; r++)
      {
          for (int c = 0; c < squares[0].length; c++)
          {
            if(squares[r][c].equals("b"))
            {
              //System.out.println("b found");
            
              return false;
            }
          }
      }      
      //System.out.println("b not found");
  
      return true;
    }
  
  }
  