import java.util.ArrayList;
public class Operations extends Maths
{
  public Operations(ArrayList<Double> enterList)
  {
    super(enterList);
  }

  // Return the product of all numbers in numberList
  public double multiplication()
  {
    double product = 1.0;
    for (int i = 0; i < getNumberList().size(); i++)
    {
      product *= getNumberList().get(i);
    }
    return product;
  }
  
  // Determine if any number in numberList is a multiple of __. Return the number(s) or -1 if there is no multiple of __.
  public ArrayList<Double> divisibility(double factor)
  {
    // create an ArrayList to store multiples
    ArrayList<Double> multiples = new ArrayList<Double>();
    for (int i = 0; i < getNumberList().size(); i++)
    {
      if (getNumberList().get(i) % factor == 0)
        multiples.add(getNumberList().get(i));
    }
    return multiples;
  }

  public String linearSearchFile(double searchNum)
  {        
    int lineNum = 0;
    for (int i = 0; i < getNumberList().size(); i++)
    {
      if (getNumberList().get(i) == searchNum) lineNum = i + 1;
    }
    if (lineNum == 0) return (searchNum + " was not found in the list");
    return (searchNum + " was found on line " + lineNum + " in the unsorted list");
  }

  // Return true if the number target is in the list; otherwise, return false
  // Using a sorted list since numberList has been sorted before a recursive binary search
  // Use 0 as lowPosition and numberList.size() - 1 as highPosition in the main method
  public boolean recursiveBinarySearch(int lowPosition, int highPosition, double target)
  {
    if (lowPosition > highPosition)
      return false;
    else
    {
      int midPosition = (lowPosition + highPosition) / 2;
      if (getNumberList().get(midPosition) < target)
      {  
        return recursiveBinarySearch(midPosition + 1, highPosition, target);
      }
      else if (getNumberList().get(midPosition) > target)
      {
        return recursiveBinarySearch(lowPosition, midPosition - 1, target);
      }
    } 
    // if numberList.get(midPosition) == target
    return true;
  }
}
  
  