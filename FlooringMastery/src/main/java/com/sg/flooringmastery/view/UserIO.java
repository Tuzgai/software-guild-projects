package com.sg.flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Stuart
 */
public interface UserIO {

    void print(String message);

    void println(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    char readChar(String prompt);
    
    String readString(String prompt);
    
    BigDecimal readBigDecimal(String prompt);
    
    BigDecimal readBigDecimalOrNewline(String prompt);
    
    LocalDate readLocalDate();
}
