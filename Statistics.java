import java.util.ArrayList;
import java.lang.Math;

public class Statistics extends Maths
{
  public Statistics(ArrayList<Double> enterList)
  {
    super(enterList);
  }
  
  // methods

  // Returns the minimum in numberList
  public double min()
  {
    if (!isSorted())  bubbleSort();
    return(getNumberList().get(0));
  }

  // Returns the maximum in numberList
  public double max()
  {
    if (!isSorted())  bubbleSort();
    return(getNumberList().get(getNumberList().size() - 1));
  }

  // Returns the range of numberList
  public double range()
  {
    return ( max() - min() );
  }

  // Returns the mean of the numbers in numberList
  public double mean()
  {
    return (addition() / getNumberList().size());
  }

  // Returns the population standard deviation of the numbers in numberList
  public double populationStandardDeviation()
  {
    double numerator = 0;
    for (int i = 0; i < getNumberList().size(); i++)
    {
      numerator += Math.pow((getNumberList().get(i) - mean()), 2);
    }
    return ( Math.sqrt(numerator / getNumberList().size()) );
  }

  // Returns the sample standard deviation of the numbers in numberList
  public double sampleStandardDeviation()
  {
    double numerator = 0;
    for (int i = 0; i < getNumberList().size(); i++)
    {
      numerator += Math.pow((getNumberList().get(i) - mean()), 2);
    }
    return ( Math.sqrt(numerator / (getNumberList().size() - 1) ) );
  }

  // Returns the population variance (population standard deviation squared) of the numbers in numberList
  public double populationVariance()
  {
    return ( Math.pow(populationStandardDeviation(), 2));
  }

  // Returns the sample variance (sample standard deviation squared) of the numbers in numberList
  public double sampleVariance()
  {
    return ( Math.pow(sampleStandardDeviation(), 2));
  }

  // Returns the median of the numbers in numberList
  // Note: numberList is the sorted form of the user's list
  public double median(ArrayList<Double> list)
  {
    // numberList.size() == odd, then medianPosition = truncate n/2
    // numberList.size() == even, then medianPosition = avg of n/2 and (n/2 - 1)
    if (!isSorted())  bubbleSort();
    int size = list.size();
    if (size % 2 == 0)
    {
      return ( ( list.get(size/2) + list.get((size/2) - 1) ) /2);
    }
    else
    {
      return list.get(size /2);
    }
  }

  // Returns the first quartile (25th percentile) of the numbers in numberList
  public double firstQuartile()
  {
    ArrayList<Double> firstQuartileList = new ArrayList<Double>();
    // call Median method. lowestPosition = 0 and highestPosition = 
    if (!isSorted())  bubbleSort();
    int size = getNumberList().size();
    int lowestPosition = 0;
    int highestPosition;
    if (size % 2 == 0)
    {
      highestPosition = ((size/2) - 1);
    }
    else
    {
      highestPosition = ((size/2) - 1);
    }
    createList(getNumberList(), lowestPosition, highestPosition, firstQuartileList);
    return median(firstQuartileList);
  }

  // Returns the third quartile (75th percentile) of the numbers in numberList
  public double thirdQuartile()
  {
    if (!isSorted())  bubbleSort();
    ArrayList<Double> thirdQuartileList = new ArrayList<Double>();
    int size = getNumberList().size();
    int lowestPosition;
    int highestPosition = size-1;
    if (size % 2 == 0)
    {
      lowestPosition = (size/2);
    }
    else
    {
      lowestPosition = (size/2 + 1);
    }
  return (median(createList(getNumberList(), lowestPosition, highestPosition, thirdQuartileList)));
  }

  // Returns the interquartile range: Q3 (third quartile) - Q1 (first quartile)
  public double interquartileRange()
  {
    return (thirdQuartile() - firstQuartile());
  }

  // Returns the double value of the Pearson's Coefficient of Skewness, the formula for determine skewness
  public double pearsonCoefficientOfSkewness()
  {
    double difference = mean() - median(getNumberList());
    return ( (3 * difference) / sampleStandardDeviation() );
  }

  // Returns a boolean value (true or false) depending on whether the distribution of the data in the list is roughly symmetric
  // true == roughly symmetric, false == skewed
  // formula = Pearson's Coefficient of Skewness from above method
  public boolean isSymmetric()
  {
    if (Math.abs(pearsonCoefficientOfSkewness()) <= 0.5) 
    {
      return true;
    }
    return false;
  }

  // Returns "left-skewed" if mean < median and "right-skewed" if mean > median
  // Precondition: data is skewed; isSymmetric() == false
  public String directionOfSkew()
  {
    if (mean() < median(getNumberList()))
    {
      return "left-skewed";
    }
    else
    {
      return "right-skewed";
    }
  }

  // Returns what it the best way of measuring center (mean/median) and spread (standard deviation/interquartile range) for user's data
  // if data is roughly symmetric, mean/standard deviation; else, median/interquartile range
  public void whichMeasure()
  {
    if (isSymmetric())
    {
      System.out.println("The best measure of center for your data is the mean. The best measure of spread is the standard deviation.\n\tReason: The mean and standard deviation are nonresistant measures--affected by outliers/skew. Hence, they are better for symmetric data.");
    }
    else
    {
      System.out.println("The best measure of center for your data is the median. The best measure of spread is the interquartile range.\n\tReason: The median and interquartile range are resistant measures--not affected by outliers/skew. Hence, they are used for data that has outliers or is skewed.");
    }
  }

  // Returns outliers; -1 if there are no outliers
  public ArrayList<Double> outliers()
  {
    double low;
    double high;
    ArrayList<Double> outlierList = new ArrayList<Double>();
    if (isSymmetric())
    {
      // have used sample standard deviation
      low = mean() - (3*sampleStandardDeviation());
      high = mean() + (3*sampleStandardDeviation());
      for (int i = 0; i < getNumberList().size(); i++)
      {
        if (getNumberList().get(i) < low || getNumberList().get(i) > high)
        {
          outlierList.add(getNumberList().get(i));
        }
      }
    }
    else
    {
      high = thirdQuartile() + (1.5 * interquartileRange());
      low = firstQuartile() - (1.5 * interquartileRange());
      for (int i = 0; i < getNumberList().size(); i++)
      {
        if (getNumberList().get(i) < low || getNumberList().get(i) > high)
        {
          outlierList.add(getNumberList().get(i));
        }
      }
    }
    return outlierList;
  }

  public void summary()
  {
    //min
    System.out.println("Minimum value = "+min());
    //max
    System.out.println("Maximum value = "+max());
    //range
    System.out.println("Range = "+range());
    //mean
    System.out.println("Mean/average (μ/x̅) = "+mean());
    //standardDeviation
    System.out.println("Sample standard deviation (s) = "+sampleStandardDeviation());
    System.out.println("\tNOTE: Population standard deviation (σ) = "+populationStandardDeviation());
    //variance
    System.out.println("Sample variance (s^2) = "+sampleVariance());
    System.out.println("\tNOTE: Population variance (σ^2) = "+populationVariance());
    //1st quartile
    System.out.println("First quartile (Q1) = "+firstQuartile());
    //median(2nd quartile)
    System.out.println("Median/second quartile (M/Q2) = "+median(getNumberList()));
    //3rd quartile
    System.out.println("Third quartile (Q3) = "+thirdQuartile());
    //interquartileRange
    System.out.println("Interquartile range (IQR) = "+interquartileRange());
    //is it symmetric / which direction is it skewed
    if (isSymmetric()) System.out.println("The distribution is roughly symmetric");
    else
    {
      System.out.println("The distribution is "+directionOfSkew());
    }
    System.out.println("\tNOTE: The shape of a distribution should be assessed by a sketch rather than a numerical estimation. This estimation of the shape of the distribution is based on Pearson's Coefficient of Skewness. Considered skewed if Sk2 is greater than 0.5");
    //which measures to use
    if (isSymmetric())  
    {
      System.out.println("The best measure of center for your data is the mean. The best measure of spread is the standard deviation.");
    }
    else
    {
      System.out.println("The best measure of center for your data is the median. The best measure of spread is the interquartile range.");
    }
    //outliers
    if (outliers().isEmpty())  System.out.println("There are no outliers.");
    else
    {
      System.out.println("The outliers are " + outliers());
    }
  }
}
