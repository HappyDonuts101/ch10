public class FractionDriver{
	public static void main(String[] args){
		Fraction f1 = new Fraction(2,5);
		Fraction f2 = new Fraction(1,3);

		Fraction f6 = new Fraction(100,101);
		Fraction f7 = new Fraction (6,7);

		System.out.println(f1);
        System.out.println(f2);

		Fraction product = Fraction.mult(f2, f2);
        System.out.println(product);

        Fraction quotient = Fraction.vivi(f1, f2);
        System.out.println(quotient);

        Fraction quotient1 = Fraction.vivi(f6,f7);
        System.out.println(quotient1);
		System.out.println(Fraction.GCF(6,7));


		System.out.println(Fraction.GCF(2,200));

        System.out.println(product.toDouble());

		System.out.println(Fraction.add(f1, f2));
		System.out.println(Fraction.subtract(f1, f2));

		Fraction f8 = new Fraction(252,105);
		f8.reduce();
		System.out.println(f8);

		}
