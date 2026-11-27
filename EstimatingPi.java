public class EstimatingPi {
    public static void main(String[] args) {
        Fraction MILU = new Fraction(355, 113);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());

        Fraction approx = new Fraction(3, 1);   

        while (Math.abs(Math.PI - approx.toDouble()) >= EPSILON) {
            if (approx.toDouble() < Math.PI) {
                approx.setNum(approx.getNum() + 1);   
            } else {
                approx.setDen(approx.getDen() + 1);  
            }
        }

        System.out.println("Milu: " + MILU + " = " + MILU.toDouble());
        System.out.println("Closer fraction: " + approx + " = " + approx.toDouble());
        System.out.println("Math.PI = " + Math.PI);
    }
}

class Fraction {
    private int numerator, denominator;

    public Fraction() {
        setNum((int) (Math.random() * 9) + 1);
        setDen((int) (Math.random() * 9) + 1);
    }

    public Fraction(int n, int d) {
        setNum(n);
        setDen(d);
    }

    public Fraction(String n) {
        n = n.trim();
        int slash = n.indexOf("/");
        if (slash == -1) {
            numerator = Integer.parseInt(n);
            denominator = 1;
            return;
        }
        numerator = Integer.parseInt(n.substring(0, slash).trim());
        denominator = Integer.parseInt(n.substring(slash + 1).trim());
        if (denominator == 0) {
            denominator = 1;
            System.out.println("Denominator can't be zero");
        }
    }

    public Fraction(Fraction f) {
        numerator = f.numerator;
        denominator = f.denominator;
    }

    public static Fraction mult(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.numerator * b.numerator, a.denominator * b.denominator);
        result.reduce();
        return result;
    }

    public static Fraction mimi(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.numerator * b.denominator, a.denominator * b.numerator);
        result.reduce();
        return result;
    }

    public static Fraction add(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.numerator * b.denominator + b.numerator * a.denominator, a.denominator * b.denominator);
        result.reduce();
        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.numerator * b.denominator - b.numerator * a.denominator, a.denominator * b.denominator);
        result.reduce();
        return result;
    }

   
     */
    public boolean equals(Fraction f) {
        return numerator == f.numerator && denominator == f.denominator;
    }

    // accessor methods
    public int getNum() {
        return numerator;
    }

    public int getDen() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    // mutator methods
    public void setNum(int n) {
        numerator = n;
    }

    public void setDen(int d) {
        if (d != 0)
            denominator = d;
        else {
            denominator = 1;
            System.out.println(" Denominator can't be zero");
        }
    }

    public void reduce() {
        int g = GCF(numerator, denominator);
        numerator = numerator / g;
        denominator = denominator / g;
    }

    public static int GCF(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        return a;
    }
}
