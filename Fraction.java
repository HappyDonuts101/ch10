public class Fraction {
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int num, int denom) {
        checkDenom(denom);
        numerator = num;
        denominator = denom;
        fixSign();
    }

    public Fraction(String text) {
        text = text.trim();
        int slash = text.indexOf("/");
        int num;
        int denom;
        try {
            if (slash == -1) {
                num = Integer.parseInt(text);
                denom = 1;
            } else {
                num = Integer.parseInt(text.substring(0, slash).trim());
                denom = Integer.parseInt(text.substring(slash + 1).trim());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a valid fraction: \"" + text + "\"");
        }
        checkDenom(denom);
        numerator = num;
        denominator = denom;
        fixSign();
    }

    public Fraction(Fraction other) {
        this(other.numerator, other.denominator);
    }

    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction other = (Fraction) obj;
        return numerator * other.denominator == other.numerator * denominator;
    }

    public void reduce() {
        int g = gcf(numerator, denominator);
        numerator /= g;
        denominator /= g;
    }

    public void setNum(int num) {
        numerator = num;
    }

    public void setDenom(int denom) {
        checkDenom(denom);
        denominator = denom;
        fixSign();
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.numerator * b.numerator,
                                       a.denominator * b.denominator);
        result.reduce();
        return result;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        if (b.numerator == 0) {
            throw new ArithmeticException("Cannot divide by a zero fraction");
        }
        Fraction reciprocal = new Fraction(b.denominator, b.numerator);
        return multiply(a, reciprocal);
    }

    public static Fraction add(Fraction a, Fraction b) {
        int num = a.numerator * b.denominator + b.numerator * a.denominator;
        int denom = a.denominator * b.denominator;
        Fraction result = new Fraction(num, denom);
        result.reduce();
        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction negB = new Fraction(-b.numerator, b.denominator);
        return add(a, negB);
    }

    private static int gcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) {
            return 1;
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    private static void checkDenom(int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
    }

    private void fixSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
}
