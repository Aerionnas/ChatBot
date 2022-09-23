package lib;

/**
This contains a library of useful operations on Numeric Arrays
@author Tim Hickey

*/
public class NumArray {


    /**
      returns the index of the largest int in the array vals
      @param vals an array of ints
      @return the index of the largest double in vals
    */
    public static int indexOfMax(int[] vals){
        int indexOfMax = 0;
        for(int i=1; i<vals.length; i++){
            if (vals[i]>vals[indexOfMax]) {
                indexOfMax=i;
            }
        }
        return indexOfMax;
    }

    /**
      returns the index of the largest double in the array vals
      @param vals an array of doubles
      @return the index of the largest double in vals
    */
    public static int indexOfMax(double[] vals){
        int indexOfMax = 0;
        for(int i=1; i<vals.length; i++){
            if (vals[i]>vals[indexOfMax]) {
                indexOfMax=i;
            }
        }
        return indexOfMax;
    }

    /**
    max(vals) -- takes an array of ints and returns the largest value stored in the array
    @param vals an array of integers
    @return the largest element in vals
    */
    public static int max(int[] vals){
        int iom = indexOfMax(vals);
        return vals[iom];
    }

    /**
    max(vals) -- takes an array of doubles and returns the largest value stored in the array
    @param vals an array of integers
    @return the largest element in vals
    */
    public static double max(double[] vals){
        int iom = indexOfMax(vals);
        return vals[iom];
    }


    /**
    prints the 1d array of ints in a nice form
    @param vals  an array of integers
    */
    public static void printArray(int[] vals){
        TextIO.putf("[ ");
        for(int i=0; i<vals.length-1; i++){
            TextIO.putf("%d, ",vals[i]);
        }
        TextIO.putf("%d ]",vals[vals.length-1]);
    }

    /**
    prints the 1d array of ints in a nice form
    @param vals  an array of integers
    */
    public static void printArray(double[] vals){
        TextIO.putf("[ ");
        for(int i=0; i<vals.length-1; i++){
            TextIO.putf("%f, ",vals[i]);
        }
        TextIO.putf("%f ]",vals[vals.length-1]);
    }



}
