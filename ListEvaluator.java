import java.util.ArrayList;
import java.util.Scanner;

public class ListEvaluator {
    public static void main(String[] args)
    {
        ArrayList<Double> userList = new ArrayList<Double>();
        Scanner input = new Scanner(System.in);
        boolean yes = true;

        // list options
        while (yes)
        {
            System.out.println("Select a list to analyze:\n\t1.Average hourly earnings (including overtime) for employees paid by the hour, 2019 Canada\n\t2.Average hourly earnings (including overtime) for salaried employees, 2019 Canada\n\t3.Input numbers for a new list");
            System.out.println("Do you choose list 1, 2, or 3? Type the number.");
            String numberOfList = input.nextLine();
            if (Integer.parseInt(numberOfList) == 1)
            {
                userList.add(28.39);
                userList.add(41.76);
                userList.add(43.28);
                userList.add(33.81);
                userList.add(26.10);
                userList.add(20.53);
                userList.add(27.27);
                userList.add(28.89);
                userList.add(29.11);
                userList.add(23.95);
                userList.add(31.15);
                userList.add(22.67);
                userList.add(19.86);
                userList.add(28.72);
                userList.add(19.62);
                userList.add(16.26);
                userList.add(23.26);
                System.out.println("\nAverage hourly earnings for employees paid by the hour, 2019 Canada. By industry.\nVisit https://www150.statcan.gc.ca/t1/tbl1/en/cv!recreate.action?pid=1410020601&selectedNodeIds=2D1,3D4,3D10,3D17,3D21,3D34,3D144,3D215,3D253,3D267,3D284,3D295,3D307,3D321,3D331,3D354,3D367,3D377,3D393&checkedLevels=0D1&refPeriods=20190101,20190101&dimensionLayouts=layout2,layout2,layout3,layout2&vectorDisplay=false for more details.");
                break;
            }

            else if (Integer.parseInt(numberOfList) == 2)
            {
                userList.add(28.67);
                userList.add(63.49);
                userList.add(55.06);
                userList.add(38.27);
                userList.add(38.89);
                userList.add(33.51);
                userList.add(33.06);
                userList.add(38.58);
                userList.add(39.97);
                userList.add(31.95);
                userList.add(40.53);
                userList.add(32.91);
                userList.add(34.68);
                userList.add(32.08);
                userList.add(33.58);
                userList.add(23.52);
                userList.add(33.22);
                System.out.println("\nAverage hourly earnings (including overtime) for salaried employees, 2019 Canada. By industry.\nVisit https://www150.statcan.gc.ca/t1/tbl1/en/cv!recreate.action?pid=1410021001&selectedNodeIds=2D4,2D10,2D17,2D21,2D34,2D144,2D215,2D253,2D267,2D284,2D295,2D307,2D321,2D331,2D354,2D367,2D377,2D393&checkedLevels=0D1&refPeriods=20190101,20190101&dimensionLayouts=layout2,layout3,layout2&vectorDisplay=false for more details.");
                break;
            }

            // user input
            else if (Integer.parseInt(numberOfList) == 3)
            {
                System.out.println("How many numbers are in your list? (at least 3)");
                String numOfNums = input.nextLine();
                System.out.println("Great! Enter the integers in your list. Press press enter after typing each number.");
                // repeat user input numOfNums times
                for (int i = 0; i < Integer.parseInt(numOfNums); i++)
                {
                    String num = input.nextLine();
                    userList.add(Double.parseDouble(num));
                }
                break;
            }

            else
            {
                System.out.println("Invalid.");
            }
        }

        System.out.println("\nThe list contains the following numbers: "+userList);

        while (yes)
        {
            System.out.println("\nWhat action would you like to perform on the list?\n\t1.Mathematical Operations\n\t2.Statistical Analysis");
            System.out.println("Type either 1 or 2 to display the options available in the category. Type -1 to exit the program.");
            String numberOfAction = input.nextLine();
            if (Integer.parseInt(numberOfAction) == 1)
            {
                Operations listForOperations = new Operations(userList);
                System.out.println("1. Find the sum of all numbers in the list\n2. Find the product of all numbers in the list.\n3. Determine if any numbers in the list are multiples of __.\n4. Search for a number in the file.");
                System.out.println("Enter a number from 1 to 4 to select an option, type 0 to exit Mathematical Operations, or write -1 to exit the program");
                String choiceNum = input.nextLine();
                while (Integer.parseInt(choiceNum) != 0)
                {
                    if (Integer.parseInt(choiceNum) == 1)
                    {
                        System.out.println("The sum of all numbers in the list is: "+listForOperations.addition());
                    }
                    else if (Integer.parseInt(choiceNum) == 2)
                    {
                        System.out.println("The product of all numbers in the list is: "+listForOperations.multiplication());
                    }
                    else if (Integer.parseInt(choiceNum) == 3)
                    {
                        System.out.println("What is the factor you are looking for?");
                        String factor = input.nextLine();
                        if (listForOperations.divisibility(Double.parseDouble(factor)).isEmpty())
                        {
                            System.out.println("There are no multiples of "+Double.parseDouble(factor)+" in the list.");
                        }
                        else
                        {
                            System.out.println("The multiples of "+Double.parseDouble(factor)+" in the list are "+listForOperations.divisibility(Double.parseDouble(factor)));
                        }
                    }
                    else if (Integer.parseInt(choiceNum) == 4)
                    {
                        System.out.println("What number are you looking for?");
                        String searchNum = input.nextLine();
                        if (listForOperations.isSorted())
                        {
                            if ( listForOperations.recursiveBinarySearch(0, userList.size() - 1, Double.parseDouble(searchNum)) )
                            {
                                System.out.println(searchNum+" is in the list");
                            }
                            else
                            {
                                System.out.println(searchNum+" is not in the list");
                            }
                        }
                        else
                        {
                            System.out.println(listForOperations.linearSearchFile(Double.parseDouble(searchNum)));
                        }
                    }
                    else if (Integer.parseInt(choiceNum) == -1)
                    {
                        yes = false;
                        break;
                    }
                    System.out.println("Would you like to try again? (Type YES or NO)");
                    String tryAgain = input.nextLine();
                    if (tryAgain.toLowerCase().equals("no"))
                    {
                        System.out.println("Type 0 to exit Mathematical Operations or -1 to exit the program");
                        choiceNum = input.nextLine();
                    }
                    else if (tryAgain.toLowerCase().equals("yes"))
                    {
                        System.out.println("Enter an option for Mathematical Operations from 1 to 4.");
                        choiceNum = input.nextLine();
                    }
                }
            }

            else if (Integer.parseInt(numberOfAction) == 2)
            {
                // create Statistics object
                Statistics listForStatistics = new Statistics(userList);
                // display all options
                System.out.println("1. Find the mean of the list\n2. Find the standard deviation from the mean\n3. Find the median of the list\n4. Find the interquartile range\n5. Is the distribution skewed or roughly symmetric? \n6. Find out what it the best way of measuring center (mean/median) and spread (standard deviation/interquartile range) for the data\n7. Find outliers (if there are any)\n8. Receive a summary of the analysis");
                System.out.println("Enter a number from 1 to 8 to select an option, type 0 to exit Statistical Analysis, or write -1 to exit the program");
                String choiceNum = input.nextLine();
                while (Integer.parseInt(choiceNum) != 0)
                {
                    if (Integer.parseInt(choiceNum) == 1)
                    {
                        System.out.println("The mean/average is "+ listForStatistics.mean());
                    }
                    else if (Integer.parseInt(choiceNum) == 2)
                    {
                        System.out.println("The sample standard deviation is "+listForStatistics.sampleStandardDeviation());
                        System.out.println("\tNOTE: The population standard deviation is "+listForStatistics.populationStandardDeviation());
                    }
                    else if (Integer.parseInt(choiceNum) == 3)
                    {
                        System.out.println("The median is "+listForStatistics.median(userList));
                    }
                    else if (Integer.parseInt(choiceNum) == 4)
                    {
                        System.out.println("The interquartile range is " + listForStatistics.interquartileRange());
                    }
                    else if (Integer.parseInt(choiceNum) == 5)
                    {
                        if (listForStatistics.isSymmetric()) System.out.println("The distribution is roughly symmetric");
                        else
                        {
                            System.out.println("The distribution is "+listForStatistics.directionOfSkew());
                        }
                        System.out.println("\tNOTE: The shape of a distribution should be assessed by a sketch rather than a numerical estimation. Our estimation of the shape of the distribution is based on Pearson's Coefficient of Skewness. Sk2 for this list = "+listForStatistics.pearsonCoefficientOfSkewness()+". Considered skewed if Sk2 is greater than 0.5");
                    }
                    else if (Integer.parseInt(choiceNum) == 6)
                    {
                        listForStatistics.whichMeasure();
                    }
                    else if (Integer.parseInt(choiceNum) == 7)
                    {
                        if (listForStatistics.outliers().isEmpty())  System.out.println("There are no outliers.");
                        else
                        {
                            System.out.println("The outliers are " + listForStatistics.outliers());
                        }
                    }
                    else if (Integer.parseInt(choiceNum) == 8)
                    {
                        listForStatistics.summary();
                    }
                    else if (Integer.parseInt(choiceNum) == -1)
                    {
                        yes = false;
                        break;
                    }
                    System.out.println("Would you like to try again? (Type YES or NO)");
                    String tryAgain = input.nextLine();
                    if (tryAgain.toLowerCase().equals("no"))
                    {
                        System.out.println("Type 0 to exit Statistical Analysis or -1 to exit the program");
                        choiceNum = input.nextLine();
                    }
                    else if (tryAgain.toLowerCase().equals("yes"))
                    {
                        System.out.println("Enter an option for Statistical Analysis from 1 to 8.");
                        choiceNum = input.nextLine();
                    }
                }
            }

            else if (Integer.parseInt(numberOfAction) == -1)
            {
                yes = false;
            }

            else
            {
                System.out.println("Invalid.");
            }

        }
    }
}
