public class Test3 {

    public static void main(String[] args) {
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();
        HugeInteger h3 = new HugeInteger();
        h1.parse("12345678987654321");
        h2.parse("819");
        System.out.printf(" %8s:%40s%n", "h1", h1);
        System.out.printf(" %8s:%40s%n", "h2", h2);
        HugeInteger.add(h1,h2,h3);
        System.out.printf(" %8s:%40s%n", "h1+h2", h3);
        HugeInteger.subtract(h1,h2,h3);
        System.out.printf(" %8s:%40s%n", "h1-h2", h3);
        System.out.printf(" %s is GREATER THAN %s:%b%n", h1, h2, HugeInteger.isGreaterThan(h1,h2));
        System.out.printf(" %s is LESS THAN %s:%b%n", h1, h2, HugeInteger.isLessThan(h1,h2));
        h3.parse("0");
        System.out.printf(" %s is ZERO:%b%n", h3, h3.isZero());

        Rational r1 = new Rational(4,-6);
        Rational r2 = new Rational(-3,15);
        Rational r3 = new Rational(0,-2);
        Rational r4 = new Rational();
        Rational r5 = new Rational();
        Rational r6 = new Rational();
        Rational r7 = new Rational();
        System.out.printf(" r1: %s%n", r1);
        System.out.printf(" r2: %s%n", r2);
        System.out.printf(" r3: %s%n", r3.toString());
        Rational.add(r1,r2,r4);
        System.out.printf(" r4: %s%n", r4);
        Rational.subtract(r1,r2,r5);
        System.out.printf(" r5: %s%n", r5);
        Rational.multiply(r1,r2,r6);
        System.out.printf(" r6: %s%n", r6);
        Rational.divide(r1,r3,r7);
        System.out.printf(" r7: %s%n", r7);
    }
}


class Rational {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if(denominator == 0)
            throw new IllegalArgumentException(" denominator zero does not exist!");
        int gcd = gcd(numerator,denominator);
        setNumerator(numerator/gcd);
        this.denominator = denominator/gcd;
    }

    public Rational() {
        numerator = 1;
        denominator = 1;
    }

    private static int gcd(int a, int b) {
        int r = a%b;
        while(r != 0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static void add(Rational r1, Rational r2, Rational r3){
        int numerator = r1.getNumerator()*r2.getDenominator() +
                r1.getDenominator()*r2.getNumerator();
        int denominator = r1.getDenominator()*r2.getDenominator();
        int gcd = gcd(numerator,denominator);
        r3.setNumerator(numerator/gcd);
        r3.setDenominator(denominator/gcd);
    }

    public static void subtract(Rational r1, Rational r2, Rational r3){
        int numerator = r1.getNumerator()*r2.getDenominator() -
                r1.getDenominator()*r2.getNumerator();
        int denominator = r1.getDenominator()*r2.getDenominator();
        int gcd = gcd(numerator,denominator);
        r3.setNumerator(numerator/gcd);
        r3.setDenominator(denominator/gcd);
    }

    public static void multiply(Rational r1, Rational r2, Rational r3){
        int numerator = r1.getNumerator()*r2.getNumerator();
        int denominator = r1.getDenominator()*r2.getDenominator();
        int gcd = gcd(numerator,denominator);
        r3.setNumerator(numerator/gcd);
        r3.setDenominator(denominator/gcd);
    }

    public static void divide(Rational r1, Rational r2, Rational r3){
        int numerator = r1.getNumerator()*r2.getDenominator();
        int denominator = r1.getDenominator()*r2.getNumerator();
        if(denominator == 0){
            throw new IllegalArgumentException(" denominator zero does not exist!");
        }
        int gcd = gcd(numerator,denominator);
        r3.setNumerator(numerator/gcd);
        r3.setDenominator(denominator/gcd);
    }

    public String fractionalRepresentation() {
        return getNumerator() + "/" + getDenominator();
    }

    public String decimalRepresentation(int precision) {
        if(precision <= 0)
            throw new IllegalArgumentException(" precision must be greater than zero!");
        String string = "%." + precision + "f";
        return String.format(string, (double)getNumerator()/getDenominator());
    }

    @Override
    public String toString(){
        return String.format("fractional (%s); decimal (%s)",
                fractionalRepresentation(), decimalRepresentation(4));
    }

}


class HugeInteger {
    private static final int LENGTH = 40;
    private int[] digit = new int[LENGTH];

    public void parse(String string) {
        int length = string.length();
        for (int j = 0; j < length; j++)
            setDigit(j, Character.getNumericValue(string.charAt(length - j - 1)));
        for (int j = length; j < LENGTH; j++)
            setDigit(j,0);
    }

    public int getDigit(int j) {
        return digit[j];
    }

    public void setDigit(int j, int value) {
        digit[j] = value;
    }

    @Override
    public String toString() {
        if (isZero()) return "0";
        String s = "";
        int j = LENGTH-1;
        while (getDigit(j) == 0) j--;
        for (;j >= 0; j--)
            s += getDigit(j);
        return s;
    }

    public boolean isZero() {
        for (int j = 0; j < LENGTH; j++)
            if (getDigit(j) != 0) return false;
        return true;
    }

    public static void add(HugeInteger h1, HugeInteger h2, HugeInteger h3) {
        int sum = 0;
        for (int j = 0; j < LENGTH; j++) {
            sum += h1.getDigit(j) + h2.getDigit(j);
            if (sum > 9) {
                h3.setDigit(j,sum%10);
                sum = 1;
            }
            else {
                h3.setDigit(j,sum);
                sum = 0;
            }
        }
    }

    public static void subtract(HugeInteger h1, HugeInteger h2, HugeInteger h3) {
        if (compare(h1,h2) == 2)
            throw new IllegalArgumentException(" The result is going to be a negative number!");
        int dif = 0;
        for (int j = 0; j < LENGTH; j++) {
            dif += h1.getDigit(j) - h2.getDigit(j);
            if (dif < 0) {
                h3.setDigit(j,dif + 10);
                dif = -1;
            }
            else {
                h3.setDigit(j,dif);
                dif = 0;
            }
        }
    }

    public static boolean isEqualto(HugeInteger h1, HugeInteger h2) {
        if(compare(h1,h2) == 0) return true;
        return false;
    }

    public static boolean isNotEqualto(HugeInteger h1, HugeInteger h2) {
        if(compare(h1,h2) == 0) return false;
        return true;
    }

    public static boolean isGreaterThan(HugeInteger h1, HugeInteger h2) {
        if(compare(h1,h2) == 1) return true;
        return false;
    }

    public static boolean isLessThan(HugeInteger h1, HugeInteger h2) {
        if(compare(h1,h2) == 2) return true;
        return false;
    }

    public static boolean isGreaterThanOrEqualTo(HugeInteger h1, HugeInteger h2) {
        return !isLessThan(h1,h2);
    }

    public static boolean isLessThanOrEqualTo(HugeInteger h1, HugeInteger h2) {
        return !isGreaterThan(h1,h2);
    }

    public static int compare(HugeInteger h1, HugeInteger h2) {
        for (int j = LENGTH-1; j >= 0; j--) {
            if (h1.getDigit(j) > h2.getDigit(j)) return 1;
            if (h1.getDigit(j) < h2.getDigit(j)) return 2;
        }
        return 0;
    }
}
