package com.sg.warmups;

/**
 *
 * @author Stuart
 */
public class IntToBinary {

    public String intToBinary(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        int upperLimit = (int) Math.sqrt(n); // it would be better to calculate log 2 here

        for (int i = upperLimit; i >= 0; i--) {
            int test = (int) Math.pow(2, i);

            if (n - test >= 0) {
                sb.append("1");
                n -= test;
                leadingZero = false;
            } else {
                if (!leadingZero) {
                    sb.append("0");
                }
            }
        }

        return sb.toString();
    }
    
    public String intToBinaryRecursive(int n) {
        if(n == 0) return "0";
        if(n == 1) return "1";
        if(n/2 == 0 && n%2 == 1) return "1";
        
        return intToBinaryRecursive(n/2);
    }
}
