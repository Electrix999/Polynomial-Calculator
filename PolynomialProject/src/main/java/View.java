import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class View extends JFrame {

	private JLabel label1=new JLabel("Polinom 1:");
	private JLabel label2=new JLabel("Polinom 2:");
	private JLabel label3=new JLabel("Rezultat:");
	private JTextField poliInput1=new JTextField(30);
	private JTextField poliInput2=new JTextField(30);
	private JTextField poliResult=new JTextField(30);
	private JButton addBtn=new JButton("ADD");
	private JButton subBtn=new JButton("SUB");
	private JButton mulBtn=new JButton("MUL");
	private JButton divBtn=new JButton("DIV");
	private JButton derBtn=new JButton("DER'");
	private JButton iBtn=new JButton("I");
	
	private Model model;
	
	public View(Model model)
	{
		this.model=model;
		model.setValue(Model.INITIAL_VALUE);
		poliResult.setText("-");
		poliResult.setEditable(false);
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
		
		JPanel bigPanel=new JPanel(new GridLayout(2,1));
		bigPanel.add(panel2);
		bigPanel.add(btnPanel);
		this.setContentPane(bigPanel);
		this.pack();
		this.setTitle("Calculator Polinoame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void reset()
	{
		poliResult.setText(Model.INITIAL_VALUE);
	}
	
	public String getPoli1()
	{
		return poliInput1.getText();
	}
	public String getPoli2()
	{
		return poliInput2.getText();
	}
	
	public void setResult(String newResult)
	{
		poliResult.setText(newResult);
	}
	public void showError(String message)
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
