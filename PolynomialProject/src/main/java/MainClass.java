import java.util.*;

import Control.Control;
import Model.Monom;
import Model.Polinom;
import View.View;

public class MainClass {

	public static void main(String[] args) {
		
		List<Monom> x=new ArrayList<Monom>();
		x.add(new Monom(3,3));
		x.add(new Monom(-2,2));
		x.add(new Monom(6,0));
	//	x.add(new Monom(-3,0));
		
		List<Monom> y=new ArrayList<Monom>();
		y.add(new Monom(1,2));
		y.add(new Monom(-1,0));
	
		Polinom a=new Polinom(x);
		Polinom b=new Polinom(y);
		Polinom c=b.adunare(a);
		Polinom d=a.scadere(b);
		Polinom e=a.inmultire(b);
		List <Polinom> f=a.impartire(b);
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println("adunare: "+c);
		System.out.println("scadere: "+d);
		System.out.println(e);
		System.out.println("cat: "+f.get(0));
		System.out.println("rest: "+f.get(1));
	//	System.out.println(a.integrare());
	//	System.out.println((a.integrare()).derivare());
		
		
		
		
		
		View view=new View();
		Control control=new Control(view);
		view.setVisible(true);

	}

}
