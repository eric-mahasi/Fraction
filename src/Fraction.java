import java.util.Scanner;

/**
 * Created by eric on 12/10/16.
 * This is a program that performs simple calculations on fractions.
 */
public class Fraction {
    //class variables
    private int denominator, numerator;

    /***
     * These constructors initialise the variables such that we can't have a denominator of zero
     * The first one takes no arguments and by default sets the denominator to 1.
     * The second one takes arguments( could be user input) and sets the varaibles to those values
     */
    public Fraction() {
        denominator = 1;
    }

    public Fraction(int a, int b) {
        this.numerator = a;

        if (denominator != 0) {
            this.denominator = b;
        } else {
            System.out.println("The denominator can not be zero");
        }

    }
    //getter and setter methods for the variables

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Fraction fraction = new Fraction();
        Fraction fraction1 = new Fraction();
        int numerator;
        int numerator1;
        int denominator;
        int denominator1;

        //Welcome message for the user
        System.out.println("Welcome.\nThis program will add any two simple fractions. Start by entering values for the first fraction");
        //getting values for the first fraction
        System.out.println("Please enter a value for the numerator");
        numerator = userInput.nextInt();
        fraction.setNumerator(numerator);
        System.out.println("Now enter a value for the denominator");
        denominator = userInput.nextInt();
        fraction.setDenominator(denominator);

        //now let's get the values for the second fraction
        System.out.println("Give us now values for the second fraction\nPlease enter a value for the numerator");
        numerator1 = userInput.nextInt();
        fraction1.setNumerator(numerator1);
        System.out.println("Now enter a value for the denominator");
        denominator1 = userInput.nextInt();
        fraction1.setDenominator(denominator1);
        userInput.close();

        addition(fraction, fraction1);
        multiply(fraction, fraction1);
        compare(fraction, fraction1);
        simplify(fraction);
        simplify(fraction1);
    }


    //method that adds the two fractions
    //we work this using the formula a/b + c/d = (ad + bc)/bd
    public static void addition(Fraction fraction, Fraction fraction1) {

        int a = (fraction.getNumerator() * fraction1.getDenominator() + fraction.getDenominator() * fraction1.getNumerator());
        int b = (fraction.getDenominator() * fraction1.getDenominator());
        System.out.println("The result of addition is " + a + "/" + b);
    }

    //the method that multiplies two fractions
    //the formula used is a/b * c/d = ac/bd
    public static void multiply(Fraction fraction, Fraction fraction1) {
        int a = (fraction.getNumerator() * fraction1.getNumerator());
        int b = (fraction.getDenominator() * fraction1.getDenominator());
        System.out.println("The result of multiplication is " + a + "/" + b);

    }

    //this method simplifies the fraction
    //using the GCD, we divide the numerator and denominator by it until we have a simplified fraction
    public static void simplify(Fraction fraction) {
        int a;
        int b;
        int d = GCD(fraction.getNumerator(), fraction.getDenominator());
        a = fraction.getNumerator() / d;
        b = fraction.getDenominator() / d;
        System.out.println("The fraction " + fraction.getNumerator() + "/" + fraction.getDenominator() + " can be simplified to " + a + "/" + b);
    }

    //a function to find the GCD of two numbers. It helps us in simplifying a fraction
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else return GCD(b, a % b);

    }

    //this method compares the two fractions and returns the larger of the two
    //it simply converts the fractions to decimal values and compares which is larger
    public static void compare(Fraction fraction, Fraction fraction1) {
        double a = (fraction.getNumerator() / fraction.getDenominator());
        double b = (fraction1.getNumerator() / fraction1.getDenominator());

        if (a > b) {
            System.out.println("The larger fraction is " + fraction.getNumerator() + "/" + fraction.getDenominator());
        } else {
            System.out.println(fraction1.getNumerator() + "/" + fraction1.getDenominator() + " is the larger fraction");
        }
    }
}

