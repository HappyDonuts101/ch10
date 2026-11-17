public class FractionDriver {

	public static void main(String [] args) {
		
	Fraction f = new Fraction();
	
	Fraction f1 = new Fraction(1,2);
	Fraction f2 = new Fraction(1,3);
	f2.denominator = 0;
	System.out.println(f1.numerator + "/" + f1.denominator);	
    System.out.println(f2.numerator + "/" + f2.denominator);
   
	
}



}
