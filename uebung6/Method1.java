/**First part of the exercise
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
 
public class Method1
{
    final static int SIZE_TABLE_MAX = 100;
    double[] table;
    double gap;
    
     /**
    * Method main
    *
    * @param sizeTable (int), table (double[])
    * @return results to the different methods (String)
    */
    public static String calculateArithmAverAndOthers (double[] table, int sizeTable)
    {
        double arithmeticAverage = calculateArithmeticAverage(sizeTable,table);
        double furthestNumber = furthestNumberFrom(sizeTable,table);
        double closestNumber = closestNumberFrom(sizeTable, table);
        return  "Arithmetic average : " + arithmeticAverage + 
                "\nFurthest number from the arithmetic average : " + furthestNumber +
                "\nClosest number from the arithmetic average : " + closestNumber;
    }
    
     /**
    * Method calculateArithmeticAverage
    *
    * @param sizeTable (int), table (double[])
    */
    public static double calculateArithmeticAverage (int sizeTable, double[] table)
    {
        double sumTotalTable = 0.0;
        for (int i = 0; i < sizeTable; i++)
        {
            sumTotalTable += table[i];
        }
        double arithmeticAverage = sumTotalTable / sizeTable;
        return arithmeticAverage;
    }
    
     /**
    * Method furthestNumberFrom
    *
    * @param table (double[])
    * @return maximum (double)
    */
    public static double furthestNumberFrom (int sizeTable, double[] table)
    {
        double maximum = 0.0;
        double furthest = 0.0;
        double index = 0.0;
        double average = calculateArithmeticAverage(sizeTable,table);
        for (int i = 0; i < sizeTable; i++)
        {
            index = maximum;
            maximum = maximum(calculateGap(average,table[i]),calculateGap(average,furthest));
            if (maximum != index)
            {
                furthest = table[i];
            }
        }
        return furthest;
    }
    
     /**
    * Method closestNumberFrom
    *
    * @param table (double[])
    * @return minimum (double)
    */
    public static double closestNumberFrom (int sizeTable, double[] table)
    {
        double minimum = 0.0;
        double closest = 0.0;
        double index = 0.0;
        double average = calculateArithmeticAverage(sizeTable,table);
        for (int i = 0; i < sizeTable; i++)
        {
            index = minimum;
            minimum = minimum(calculateGap(average,table[i]),calculateGap(average,closest));
            if (minimum != index)
            {
                closest = table[i];
            }
        }
        return closest;
    }
    
     /**
    * Method minimum
    *
    * @param number (double), minimum (double)
    * @return minimum (double)
    */
    public static double minimum (double number, double minimum)
    {
        if (number <= minimum)
        {
            minimum = number;
        }
        return minimum;
    }
    
     /**
    * Method maximum
    *
    * @param number (double), maximum (double)
    * @return maximum (double)
    */
    public static double maximum (double number, double maximum)
    {
        if (number >= maximum)
        {
            maximum = number;
        }
        return maximum;
    }
    
     /**
    * Method calculateGap
    *
    * @param average (double), number (double)
    * @return gap (double)
    */
    public static double calculateGap (double average, double number)
    {
        double gap = average - number;
        return gap;
    }
}