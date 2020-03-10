

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;



public class Control {
	
	private View m_view;
	
	
	public Control(View view)
	{
		
		m_view=view;
		
		view.addListener(new AddListener());
		view.subListener(new SubListener());
		view.mulListener(new MulListener());
		view.divListener(new DivListener());
		view.derListener(new DerListener());
		view.iListener(new IListener());
	}
	
	public static Polinom makePolinom(String[] input1)
	{
		
		List<Monom> x=new ArrayList<Monom>();
		
		int i=0;
		while(i<input1.length) 
		{
			Integer verif1=Integer.parseInt(input1[i]);
			Integer verif2=Integer.parseInt(input1[i+1]);
			x.add(new Monom(verif1.intValue(),verif2.intValue()));
			i+=2;
		}
		
		return new Polinom(x);
	}
	
	class AddListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String[] userInput1, userInput2;

			try
			{
				
				userInput1=m_view.getPoli1().split(" ",-2);
				userInput2=m_view.getPoli2().split(" ",-2);
			
				if(userInput1.length%2==1 ||userInput2.length%2==1)
				{
					throw new BadInp("NUU");
				}
				Polinom pol1=Control.makePolinom(userInput1);
				Polinom pol2=Control.makePolinom(userInput2);
				Polinom rezultat=new Polinom();
				
				rezultat=pol1.adunare(pol2);
				
				m_view.setResult(rezultat.toString());
				m_view.setRest("-");
				
			}catch(NumberFormatException exp)
			{
				m_view.showError("Bad input!");
			}
			catch(BadInp ex)
			{
				m_view.showError("You forgot to put 1 grade!");
			}
			
			
		}
	}
	
		class SubListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String[] userInput1, userInput2;

				try
				{
					
					userInput1=m_view.getPoli1().split(" ",-2);
					userInput2=m_view.getPoli2().split(" ",-2);
				
					if(userInput1.length%2==1 ||userInput2.length%2==1)
					{
						throw new BadInp("NUU");
					}
					Polinom pol1=Control.makePolinom(userInput1);
					Polinom pol2=Control.makePolinom(userInput2);
					Polinom rezultat=new Polinom();
					
					rezultat=pol1.scadere(pol2);
					
					m_view.setResult(rezultat.toString());
					m_view.setRest("-");
					
				}catch(NumberFormatException exp)
				{
					m_view.showError("Bad input!");
				}
				catch(BadInp ex)
				{
					m_view.showError("You forgot to put 1 grade!");
				}
				
				
			}
		}
		
class MulListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				String[] userInput1, userInput2;

				try
				{
					
					userInput1=m_view.getPoli1().split(" ",-2);
					userInput2=m_view.getPoli2().split(" ",-2);
					
					if(userInput1.length%2==1 ||userInput2.length%2==1)
					{
						throw new BadInp("NUU");
					}
					Polinom pol1=Control.makePolinom(userInput1);
					Polinom pol2=Control.makePolinom(userInput2);
					Polinom rezultat=new Polinom();
					
					rezultat=pol1.inmultire(pol2);
					
					m_view.setResult(rezultat.toString());
					m_view.setRest("-");
					
				}catch(NumberFormatException exp)
				{
					m_view.showError("Bad input!");
				}
				catch(BadInp ex)
				{
					m_view.showError("You forgot to put 1 grade!");
				}
				
				
			}
		}

class DivListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		String[] userInput1, userInput2;

		try
		{
			
			userInput1=m_view.getPoli1().split(" ",-2);
			userInput2=m_view.getPoli2().split(" ",-2);
	
			if(userInput1.length%2==1 ||userInput2.length%2==1)
			{
				throw new BadInp("NUU");
			}
			Polinom pol1=Control.makePolinom(userInput1);
			Polinom pol2=Control.makePolinom(userInput2);
			Polinom rezultat=new Polinom();
			Polinom rest=new Polinom();
			
			rezultat=(pol1.impartire(pol2)).get(0);
			rest=(pol1.impartire(pol2)).get(1);
			
			m_view.setResult(rezultat.toString());
			m_view.setRest(rest.toString());
			
		}catch(NumberFormatException exp)
		{
			m_view.showError("Bad input!");
		}
		catch(BadInp ex)
		{
			m_view.showError("You forgot to put 1 grade!");
		}
		
		
	}
}

class DerListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		String[] userInput1;

		try
		{
			
			userInput1=m_view.getPoli1().split(" ",-2);
			if(userInput1.length%2==1 )
			{
				throw new BadInp("NUU");
			}
			Polinom pol1=Control.makePolinom(userInput1);
			Polinom rezultat=new Polinom();
			
			rezultat=pol1.derivare();
			
			m_view.setResult(rezultat.toString());
			m_view.setRest("-");
			
		}catch(NumberFormatException exp)
		{
			m_view.showError("Bad input!");
		}
		catch(BadInp ex)
		{
			m_view.showError("You forgot to put 1 grade!");
		}
		
		
	}
}

class IListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		String[] userInput1;

		try
		{
			
			userInput1=m_view.getPoli1().split(" ",-2);
			if(userInput1.length%2==1 )
			{
				throw new BadInp("NUU");
			}
			Polinom pol1=Control.makePolinom(userInput1);
			Polinom rezultat=new Polinom();
			
			rezultat=pol1.integrare();
			
			m_view.setResult(rezultat.toString());
			m_view.setRest("-");
			
		}catch(NumberFormatException exp)
		{
			m_view.showError("Bad input!");
		}
		catch(BadInp ex)
		{
			m_view.showError("You forgot to put 1 grade!");
		}
		
		
	}
}


}
	





