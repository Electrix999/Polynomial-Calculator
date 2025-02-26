package View;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class View extends JFrame {

	private JLabel label1=new JLabel("Polinom 1:");
	private JLabel label2=new JLabel("Polinom 2:");
	private JLabel label3=new JLabel("Rezultat:");
	private JLabel label4=new JLabel("Rest:");
	private JLabel label5=new JLabel("   Format scriere polinom: ax^n+bx^n-1+...+cx+d, cu x nu X");
	private JTextField poliInput1=new JTextField(30);
	private JTextField poliInput2=new JTextField(30);
	private JTextField poliResult=new JTextField(30);
	private JTextField rest=new JTextField(10);
	private JButton addBtn=new JButton("ADD");
	private JButton subBtn=new JButton("SUB");
	private JButton mulBtn=new JButton("MUL");
	private JButton divBtn=new JButton("DIV");
	private JButton derBtn=new JButton("DER'");
	private JButton iBtn=new JButton("I");
	
	
	
	public View()
	{
		
		
		poliResult.setText("-");
		poliResult.setEditable(false);
		
		rest.setText("-");
		rest.setEditable(false);
		
		JPanel btnPanel=new JPanel(new FlowLayout());
		btnPanel.add(addBtn);
		btnPanel.add(subBtn);
		btnPanel.add(mulBtn);
		btnPanel.add(divBtn);
		btnPanel.add(derBtn);
		btnPanel.add(iBtn);
		
		
		
		JPanel panel2=new JPanel(new FlowLayout()); 
		panel2.add(label1);
		panel2.add(poliInput1);
		panel2.add(label2);
		panel2.add(poliInput2);
		panel2.add(label3);
		panel2.add(poliResult);
		panel2.add(label4);
		panel2.add(rest);
		
		
		JPanel bigPanel=new JPanel(new GridLayout(3,1));
		bigPanel.add(label5);
		bigPanel.add(panel2);
		bigPanel.add(btnPanel);
		this.setContentPane(bigPanel);
		this.pack();
		this.setTitle("Calculator Polinoame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public String getPoli1()//metoda de colectare a primului polinom
	{
		return poliInput1.getText();
	}
	public String getPoli2()//metoda colectare al doilea polinom
	{
		return poliInput2.getText();
	}
	
	public void setResult(String newResult)//setare rezultat 
	{
		poliResult.setText(newResult);
	}
	
	public void setRest(String newResult)//setare rest
	{
		rest.setText(newResult);
	}
	public void showError(String message)//metoda pt afisarea erorilor in GUI
	{
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void addListener(ActionListener add)
	{
		addBtn.addActionListener(add);
	}
	public void subListener(ActionListener sub)
	{
		subBtn.addActionListener(sub);
	}
	public void mulListener(ActionListener mul)
	{
		mulBtn.addActionListener(mul);
	}
	public void divListener(ActionListener div)
	{
		divBtn.addActionListener(div);
	}
	public void derListener(ActionListener der)
	{
		derBtn.addActionListener(der);
	}
	public void iListener(ActionListener i)
	{
		iBtn.addActionListener(i);
	}
}
