
import java.util.*;
import java.text.DecimalFormat;

public class Polinom {
	private List<Monom> poli=new ArrayList<Monom>();
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public Polinom()
	{
		
	}
	
	public Polinom(List<Monom> poli) {
		super();
		this.poli = poli;
	}
	
	public List<Monom> getPoli() {
		return poli;
	}
	
	public void adauga(Monom x)
	{
			poli.add(x);
	}
	

	public Polinom adunare(Polinom x)
	{
		int i=0,j=0;
		Polinom newPoli=new Polinom();
		while(i<poli.size() || j<x.getPoli().size())
		{
			if(i>=poli.size())
			{
				newPoli.adauga(x.getPoli().get(j));
				j++;
			}
			else if(j>=x.getPoli().size())
			{
				newPoli.adauga(poli.get(i));
				i++;
			}
			else
		 	{
				if(poli.get(i).getGrad()>x.getPoli().get(j).getGrad())//se ia gradul maxim dintre cel 2 poligoane
				{
					//daca gradul si coef in urma adunarii a 2 monoame da 0, inseamna ca monomul cu grad mai mare e unic si se trece in noul polinom
						newPoli.adauga(poli.get(i));
					i++;
				}
				else if(poli.get(i).getGrad()<x.getPoli().get(j).getGrad())
				{
					//daca gradul si coef in urma adunarii a 2 monoame da 0, inseamna ca monomul cu grad mai mare e unic si se trece in noul polinom
						newPoli.adauga(x.getPoli().get(j));
					j++;
				}
				else//daca gradele monoamelor selectate de la cele 2 polinoame sunt egale inseamna case face adunare intre monoame, rezultatul se trece in polinomul nou format
				{
					newPoli.adauga(poli.get(i).adunare(x.getPoli().get(j)));
					i++;
					j++;
				}
			}
				
			
				
			
		}
		return newPoli;
	}
	
	public Polinom scadere(Polinom x)//scaderea e o adunare in care se schimba semnul coeficientilor celui de al doilea polinom
	{
		int i=0,j=0;
		
		List<Monom> listaX=new ArrayList<Monom>();//listaX=lista care contine monoamele polinomului x cu semnul coef schimbat 
		
		Polinom newPoli=new Polinom();
		
		for(Monom listM:x.getPoli())
		{
			listaX.add(new Monom(-listM.getCoef(),listM.getGrad()));
		}
		
		while(i<poli.size() || j<listaX.size())
		{
			
			if(i>=poli.size())
			{
				newPoli.adauga(listaX.get(j));
				j++;
			}
			else if(j>=listaX.size())
			{
				newPoli.adauga(poli.get(i));
				i++;
			}
			else
			
			{
				if(poli.get(i).getGrad()>listaX.get(j).getGrad())//se ia gradul maxim dintre cel 2 poligoane
				{
					
					{
						newPoli.adauga(poli.get(i));
					}
					i++;
				}
				else if(poli.get(i).getGrad()<listaX.get(j).getGrad())
				{
					
						newPoli.adauga(listaX.get(j));
					j++;
				}
				else//daca gradele monoamelor selectate de la cele 2 polinoame sunt egale inseamna case face adunare intre monoame, rezultatul se trece in polinomul nou format
				{
					newPoli.adauga(poli.get(i).adunare(listaX.get(j)));
					i++;
					j++;
				}	
			}
			
			
		}
		return newPoli;
	}
	
	public Polinom inmultire(Polinom x)
	{
		List<Monom> listaX=new ArrayList<Monom>();
		listaX=x.getPoli();
		
		Polinom newPoli=new Polinom();
		
		
		for(Monom monom:poli)
		{
			Polinom newPoliCopy=new Polinom();
			for(Monom lMonom:listaX)
			{
				newPoliCopy.adauga(monom.inmultire(lMonom));
				
			}
			
	    	newPoli=newPoli.adunare(newPoliCopy);
			
		}
		return newPoli;
		
	}
	
	public Polinom impartire(Polinom x)
	{
		
		
		Polinom newPoli=new Polinom();
		
		Polinom rest=this;
		while(rest.getPoli().get(0).getGrad()!=0)
		{
			
			Polinom cat=new Polinom();
			
			cat.adauga(rest.getPoli().get(0).impartire(x.getPoli().get(0)));
			rest=rest.scadere(cat.inmultire(x));
				
	    	newPoli=newPoli.adunare(cat);
	    	
	    	if(rest.getPoli().get(0).getGrad()<x.getPoli().get(0).getGrad())
	    	{
	    		break;
	    	}
			
		}
		return newPoli;
		
	}
	
	public Polinom derivare()
	{
		Polinom newPoli=new Polinom();
		for(Monom monom:poli)
		{
			newPoli.adauga(monom.derivare());
		}
		return newPoli;
	}
	
	public Polinom integrare()
	{
		Polinom newPoli=new Polinom();
		for(Monom monom:poli)
		{
			newPoli.adauga(monom.integrare());
		}
		return newPoli;
	}
	
	public int equals(Polinom x)
	{
		int i=0;
		for(Monom lista:x.getPoli())
		{
			if(lista.getCoef()!= poli.get(i).getCoef() || lista.getGrad()!=poli.get(i).getGrad())
			{
				return 0;
			}
			i++;
		}
		if(i<poli.size()) {
			return 0;
		}
		return 1;
	}
	
	public String toString()
	{
		String a="";
		for(Monom listM:poli)
		{
			if(listM.getCoef()>0)
			{
				if(listM.getGrad()==0)
				{
					a=a+"+"+df2.format(listM.getCoef());
				}
				else
				{
					a=a+"+"+df2.format(listM.getCoef())+"X"+"^"+listM.getGrad();
				}
				
			}
			else if(listM.getCoef()<0)
			{
				if(listM.getGrad()==0)
				{
					a=a+df2.format(listM.getCoef());
				}
				else
				{
					a=a+df2.format(listM.getCoef())+"X"+"^"+listM.getGrad();
				}
				
			}
		}
		return a;
	}
	

}
