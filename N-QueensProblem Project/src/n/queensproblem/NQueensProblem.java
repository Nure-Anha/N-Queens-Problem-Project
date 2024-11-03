package n.queensproblem;
import java.awt.*;               //for using beep function
import java.util.*;


public class NQueensProblem {
    
      public static final String ANSI_RESET = "\u001B[0m";     //Declaring ANSI_RESET for reset the color
     public static final String ANSI_BLUE = "\u001b[44m";    //Declaring the color
     
   
     public static void solution(char board[][], int n)
    {
         Toolkit.getDefaultToolkit().beep();
             
             try{
                 Thread.sleep(200);               
             }                                            
             catch(InterruptedException r){         /*Whether the thread is interrupted 
                                                     so we throw an InterrupedException*/ 
                 System.out.print("r");
             }
             
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(ANSI_BLUE+"  "+board[i][j]+"  "+ ANSI_RESET);
            System.out.println();
        }
    }
    public static boolean isSafe(char board[][], int row, int column, int n)
    {
        int i,j;
        /*horizontal*/
        for(j=0;j<column;j++)
        {
            if(board[row][j]=='Q') 
                return false;
        }
        /*vertical*/
        for(i=0;i<row;i++)
        {
            if(board[i][column]=='Q') 
                return false;
        }
         /*upper left*/
        for(i=row,j=column; i>=0 && j>=0; i--,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        /*lower left*/
        for(i=row,j=column; i<n && j>=0; i++,j--)
        {
            if(board[i][j]=='Q') return false;
        }
        /*upper right*/
        for(i=row,j=column; i>=0 && j<n; i--,j++)
        {
            if(board[i][j]=='Q') 
                return false;
        }
        /*lower right*/
         for(i=row,j=column; i<n && j<n ; i++,j++)
        {
            if(board[i][j]=='Q') 
                return false;
        } 
        return true;
    }
    
    // Backtracking Approach 
    public static boolean solveNQueens(char board[][], int column, int n)
    {
        if(column>=n) 
            return true;
        for(int i=0;i<n;i++)
        {
            if(isSafe(board,i,column,n))
            {
                board[i][column]='Q';
                if(solveNQueens(board, column+1,n)) 
                    return true;
                board[i][column]='-';
            }
        }
        return false;
       
    }

    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);
        
            Toolkit.getDefaultToolkit().beep();
             
             try{
                 Thread.sleep(200);
             }
             catch(InterruptedException r){
                 System.out.print("r");
             }
         
        System.out.println("\t\t\t\t\t\t**************************************"); 
        System.out.println("\t\t\t\t\t\t     WELCOME TO NXN CHESSBOARD"); 
        System.out.println("\t\t\t\t\t\t**************************************"); 
        System.out.println("\n> [1]Display");
        System.out.print("\n> Press 1 for display the N-Queen Problem chessboard :");
        int x = sc.nextInt();
        if(x==1)
        {
            System.out.println("\n\t\t\t\t\t\t       Start   \t\t\t");
        }
        else
        {
            System.exit(0);
        }
        
        int n;
         for(int t=0;t<100;t++){
        System.out.print("\n\t\t\t  For How Many Numbers of Queen, You Want To Display The Chessboard :");
        
        n=sc.nextInt();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='-';
        
        Toolkit.getDefaultToolkit().beep();
             
             try{
                 Thread.sleep(200);
             }
             catch(InterruptedException r){
                 System.out.print("r");
             }
             
        if(solveNQueens(board,0,n)) solution(board,n);
        else System.out.println("\tSorry! There's No Solution Exists");
    }
  }
}
