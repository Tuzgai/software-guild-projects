package UserIOLab;

import java.util.Scanner;

/**
 *
 * @author Stuart
 */
public class userIOImpl implements UserIO {

    Scanner scn;

    userIOImpl() {
        scn = new Scanner(System.in);
    }

    userIOImpl(Scanner scan) {
        scn = scan;
    }
    
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Double.parseDouble(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number - " + e);
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input;
        do {
            print(prompt);
            while (true) {
                try {
                    input = Double.parseDouble(scn.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    println("Please enter a valid number - " + e);
                }
            }
        } while (!(input >= min && input <= max));

        return input;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Float.parseFloat(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number - " + e);
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float input;
        do {
            print(prompt);
            while (true) {
                try {
                    input = Float.parseFloat(scn.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    println("Please enter a valid number - " + e);
                }
            }
        } while (!(input >= min && input <= max));

        return input;
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number - " + e);
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input;
        do {
            print(prompt);
            while (true) {
                try {
                    input = Integer.parseInt(scn.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    println("Please enter a valid number - " + e);
                }
            }
        } while (!(input >= min && input <= max));

        return input;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Long.parseLong(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number - " + e);
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input;
        do {
            print(prompt);
            while (true) {
                try {
                    input = Long.parseLong(scn.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    println("Please enter a valid number - " + e);
                }
            }
        } while (!(input >= min && input <= max));

        return input;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scn.nextLine();
    }

}
