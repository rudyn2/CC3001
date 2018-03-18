import java.util.Scanner;

public class Fraccion {
	public int num;
	public int den;
	
	public Fraccion(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public Fraccion(String frac) {
		String[] numden = frac.split("/");
		this.num = Integer.parseInt(numden[0]);
		this.den = Integer.parseInt(numden[1]);
		
		
	}
	
	public static int mcd(int a, int b) {
		if (b==0) {
			return a;
		}
		else {
			return mcd(b, a%b);
		}
		
	}
	
	public void simplificar() {
		int b = mcd(this.num, this.den);
		this.num /= b;
		this.den /= b;
	}
	
	public Fraccion suma(Fraccion other) {
		int nuevoDen = this.den*other.den;
		int nuevoNum = this.num*other.den + other.num*this.den;
		Fraccion suma = new Fraccion(nuevoNum, nuevoDen);
		suma.simplificar();
		return suma;
	}
	
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("n? ");
		
		int n = sc.nextInt();
		
		Fraccion res = new Fraccion(0,1);
		
		for(int i=1; i <= n; i++) {
			
			System.out.println("Fraccion "+ i + "? ");
			String frac = sc.next();
			Fraccion otra = new Fraccion(frac);
			res = res.suma(otra);
				
		}
		
		System.out.println("La suma total es: " + res.toString());
		
	}
}


