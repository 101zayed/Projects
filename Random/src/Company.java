
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Company {

	static JTextField IDtextField = new JTextField(10);
	static JTextField AGEtextField = new JTextField(10);
	static JTextField NAMEtextField = new JTextField(10);
	static JTextField FILEtextField = new JTextField(10);
	static JTextArea t1 = new JTextArea(10, 13);
	static JFrame frame;

	static String filename = FILEtextField.getText();
	static int press = 0;

	static String whatID = "";
	static JLabel imglabel = new JLabel();

	public static void main(String[] args) {

		frame = new JFrame("Employees information");

		resetpic();
		JButton Save = new JButton("Save");
		JButton Load = new JButton("Load");
		// ImageIcon image = new ImageIcon("EmployeePictures/student.png");

	/*	String[] Gender = { "Female", "Male", "Select" };

		JComboBox genList = new JComboBox(Gender);
		genList.setSelectedIndex(3);*/

		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(IDtextField.getText());
				int age = Integer.parseInt(AGEtextField.getText());
				String name = NAMEtextField.getText();

				String hi = "testing";

				Employees employee = new Employees();
				employee.setId(id);
				employee.setName(name);
				employee.setAge(age);
				// employee.test(hi);

				try {

					File file = new File(FILEtextField.getText() + ".xml");
					JAXBContext jc = JAXBContext.newInstance(Employees.class);
					Marshaller jaxbMarshaller = jc.createMarshaller();
					t1.setText("file " + FILEtextField.getText() + " saved!");

					jaxbMarshaller.setProperty(
							Marshaller.JAXB_FORMATTED_OUTPUT, true);

					jaxbMarshaller.marshal(employee, file);
					jaxbMarshaller.marshal(employee, System.out);
					IDtextField.setText("");
					AGEtextField.setText("");
					NAMEtextField.setText("");
					resetpic();
				} catch (JAXBException k) {

					k.printStackTrace();
				}
			}
		});

		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w) {
				try {

					File file = new File(FILEtextField.getText() + ".xml");
					JAXBContext jaxbContext = JAXBContext
							.newInstance(Employees.class);
					filename = FILEtextField.getText().toString();
					Unmarshaller unmarshal = jaxbContext.createUnmarshaller();
					Employees employee = (Employees) unmarshal.unmarshal(file);

					String strA = Integer.toString(employee.id);
					whatID = "EmployeePictures/" + strA + ".png";

					String strB = Integer.toString(employee.getAge());

					t1.setText("");
					t1.append("ID: " + strA);
					t1.append("\n" + "Age: " + strB);
					t1.append("\n" + "Name: " + employee.name);
					// t1.append("\n" + employee.getTest());
					System.out.println(filename);
					IDtextField.setText("");
					AGEtextField.setText("");
					NAMEtextField.setText("");
					displaypic();

				} catch (JAXBException r) {
					r.printStackTrace();
				}

			}

		});

		Insets insets = frame.getInsets();
		t1.setEditable(false);
		JLabel IDlabel = new JLabel("ID:");
		JLabel AGElabel = new JLabel("Age:");
		JLabel NAMElabel = new JLabel("Name:");
		JLabel FILElabel = new JLabel("File Name:");
		JLabel Loadlabel = new JLabel();

		Loadlabel.setText("Console:");

		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);

		frame.add(Save);
		frame.add(Load);
		frame.add(IDtextField);
		frame.add(IDlabel);
		frame.add(AGEtextField);
		frame.add(AGElabel);
		frame.add(NAMEtextField);
		frame.add(NAMElabel);
		frame.add(FILEtextField);
		frame.add(FILElabel);
		frame.add(t1);
		frame.add(Loadlabel);

		Dimension size = Save.getPreferredSize();
		Save.setBounds(500 + insets.left, 25 + insets.top, size.width,
				size.height);

		/*****/

		/******/
		size = Load.getPreferredSize();
		Load.setBounds(500 + insets.left, 50 + insets.top, size.width,
				size.height);

		/******/
		size = FILEtextField.getPreferredSize();
		FILEtextField.setBounds(500 + insets.left, 5 + insets.top, size.width,
				size.height);

		size = FILElabel.getPreferredSize();
		FILElabel.setBounds(440 + insets.left, 5 + insets.top, size.width,
				size.height);

		size = NAMEtextField.getPreferredSize();
		NAMEtextField.setBounds(200 + insets.left, 50 + insets.top, size.width,
				size.height);
		size = NAMElabel.getPreferredSize();
		NAMElabel.setBounds(160 + insets.left, 50 + insets.top, size.width,
				size.height);

		size = AGEtextField.getPreferredSize();
		AGEtextField.setBounds(200 + insets.left, 80 + insets.top, size.width,
				size.height);
		size = AGElabel.getPreferredSize();
		AGElabel.setBounds(170 + insets.left, 80 + insets.top, size.width,
				size.height);
		size = IDtextField.getPreferredSize();
		IDtextField.setBounds(200 + insets.left, 110 + insets.top, size.width,
				size.height);
		size = IDlabel.getPreferredSize();
		IDlabel.setBounds(180 + insets.left, 110 + insets.top, size.width,
				size.height);

		size = t1.getPreferredSize();
		t1.setBounds(200 + insets.left, 200 + insets.top, size.width,
				size.height);
		size = Loadlabel.getPreferredSize();
		Loadlabel.setBounds(200 + insets.left, 180 + insets.top, size.width,
				size.height);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	public static void displaypic() {

		JPanel panel = (JPanel) frame.getContentPane();
		imglabel.setIcon(new ImageIcon(whatID));// your image here

		panel.add(imglabel);
		Insets insets = frame.getInsets();
		Dimension size = imglabel.getPreferredSize();

		imglabel.setBounds(5 + insets.left, 5 + insets.top, size.width,
				size.height);
	}

	public static void resetpic() {

		JPanel panel = (JPanel) frame.getContentPane();

		imglabel.setIcon(new ImageIcon("EmployeePictures/nopic.png"));
		panel.add(imglabel);
		Insets insets = frame.getInsets();
		Dimension size = imglabel.getPreferredSize();

		imglabel.setBounds(5 + insets.left, 5 + insets.top, size.width,
				size.height);
	}

}
