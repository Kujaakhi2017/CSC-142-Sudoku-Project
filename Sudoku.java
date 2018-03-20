import java.util.Arrays; // needed to sort, clone and convert the array to String.

/**
 * The Sudoku class is used to check whether a
 given sudoku solution is valid or not.
 * Date modified: March 19th, 2018
 * @author Akash Kumar
 * @author James McCarthy
 * @author Keyshawn Wright
 * @version 1.0
 */
public class Sudoku
{
  private int[][] sudokuArray = new int[9][9]; // 9x9 sudoku puzzle.
  private int sudokuSize = 9;                  // size of each subgrid.
  private int[] temp = new int[sudokuSize];    // to hold temporary array of size sudokuSize.

  /**
   * The Sudoku constructor takes
     2D array of ints as a parameter and uses it
     to initialize a private 2D array.
   * @param sudokuSolution the sudoku solution being tested.
   */
  public Sudoku(int[][] sudokuSolution)
  {
    // copy elements of sudokuSolution into sudokuArray.
    for(int i = 0; i < sudokuSolution.length; ++i)
    {
      for(int j = 0; j < sudokuSolution[0].length; ++j)
      {
        sudokuArray[i][j] = sudokuSolution[i][j];
      }
    }
  }

  /**
   * The isValidSolution method checks to see if the
     sudoku solution is correct.
   * @return true if valid, false if invalid.
   */
  public boolean isValidSolution()
  {
    boolean validSudoku = false; // flag.

    /* for testing...delete when homework is finished.
    if(areRowsValid())
      return true;
    */
    
    // if all 3 conditions of sudoku puzzle are met, set flag to true.
    if(areRowsValid() && areColumnsValid() && areGridsValid())
    {
      validSudoku = true;
    }

    return validSudoku;
  }

 // checks if rows in the sudoku puzzle are valid.
  private boolean areRowsValid()
  {
    boolean rowFlag = true; // assume to be true unless proven otherwise.
    return rowFlag;
  }

  // checks if columns in the sudoku puzzle are valid.
  private boolean areColumnsValid()
  {
    boolean columnFlag = true; // assume to be true unless proven otherwise.
    return columnFlag;
  }

  // checks if grids in the sudoku puzzle are valid.
  private boolean areGridsValid()
  {
    boolean gridFlag = true; // assume to be true unless proven otherwise.

    for(int outerRow = 0; outerRow < sudokuSize; outerRow += 3)
    {
      for (int outerColumn = 0; outerColumn < sudokuSize; outerColumn += 3)
      {
        int tempIndex = -1; // 1 less than 0, the first index.
        for (int innerRow = 0; innerRow < sudokuSize / Math.sqrt(sudokuSize); ++innerRow)    // 9/sqrt(9) = 9/3 = 3
        {
          for (int innerColumn = 0; innerColumn < sudokuSize / Math.sqrt(sudokuSize); ++innerColumn) // 9/sqrt(9) = 9/3 = 3
          {
            // initialize the 9 elements of temp/grid array.
            temp[++tempIndex] = sudokuArray[innerRow + outerRow][innerColumn + outerColumn];
          }
        }

        Arrays.sort(temp); // sort the grid array. 1st grid: {5,3,4,6,7,2,1,9,8} -> {1,2,3,4,5,6,7,8,9}
        // go through each element in the grid array.
        for (int i = 0; i < sudokuSize; ++i)
        {
          // if an element value in column array does not match its (index+1), set flag to false.
          if (temp[i] != i + 1)
          {
            gridFlag = false;
          }
        }
      } // end outerColumn for loop.
    } // end outerRow for loop.
    return gridFlag;
  } // end areGridsValid method.

  /**
   * The getSudokuSize method gets the size of
     each subgrid in the sudoku puzzle.
   * @return the sudoku size.
   */
  public int getSudokuSize()
  {
    return sudokuSize;
  }

  /**
   * The showSudoku method prints out the contents
     of the 2D array field onto the console.
   */
  public void showSudoku()
  {
  
  }

} // end Sudoku class
