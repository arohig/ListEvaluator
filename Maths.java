import java.util.ArrayList;
public class Maths
{
  // create ArrayList instance variable
  private ArrayList<Double> numberList;

  public Maths(ArrayList<Double> enterList)
  {
    numberList = enterList;
  }

  public ArrayList<Double> getNumberList()
  {
    return numberList;
  }

  public void setNumberList(double num)
  {
    numberList.add(num);
  }

  // Return the sum of all numbers in numberList
  public double addition()
  {
    double sum = 0.0;
    for (int i = 0; i < getNumberList().size(); i++)
    {
      sum += getNumberList().get(i);
    }
    return sum;
  }

  // Sorts number in numberList using bubble sort
  public void bubbleSort()
  {
    for (int n = 0; n < getNumberList().size() - 1; n++)
    {
      for (int i = 0; i < getNumberList().size() - n - 1; i++)
      {
        if (getNumberList().get(i) > getNumberList().get(i+1))
        {
          // swap
          double curNum = getNumberList().get(i);
          numberList.set(i, getNumberList().get(i+1));
          numberList.set(i+1, curNum);
        }
      }
    }
  }

  // Returns true if the list is sorted (increasing order)
  public boolean isSorted()
  {
    for (int i = 0; i < getNumberList().size() - 1; i++)
    {
      if (getNumberList().get(i) > getNumberList().get(i+1))  return false;
    }
    return true;
  }

  // Creating a newList arrayList, which holds numbers from index firstIndex to lastIndex in the originalList
  public ArrayList<Double> createList(ArrayList<Double> origList, int firstIndex, int lastIndex, ArrayList<Double> newList)
  {
    for (int i = firstIndex; i <= lastIndex; i++)
    {
      double origValue = origList.get(i);
      newList.add(origValue);
    }
    return newList;
  }
}