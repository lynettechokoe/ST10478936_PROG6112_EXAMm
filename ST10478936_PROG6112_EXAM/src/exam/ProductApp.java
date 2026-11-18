package exam;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame {
    JTextField txtName = new JTextField();
    JTextField txtPrice = new JTextField();
    JComboBox<String> cmbProducts = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MENU (Q2.4)
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        
        mb.add(fileMenu);
        mb.add(toolsMenu);
        setJMenuBar(mb);

        // GUI COMPONENTS (Q2.2)
        JLabel lblName = new JLabel("Customer Name:"); lblName.setBounds(20, 20, 120, 25); add(lblName);
        txtName.setBounds(150, 20, 200, 25); add(txtName);
        
        JLabel lblProduct = new JLabel("Select Product:"); lblProduct.setBounds(20, 60, 120, 25); add(lblProduct);
        cmbProducts.setBounds(150, 60, 200, 25); add(cmbProducts);
        
        JLabel lblPrice = new JLabel("Enter Price:"); lblPrice.setBounds(20, 100, 120, 25); add(lblPrice);
        txtPrice.setBounds(150, 100, 200, 25); add(txtPrice);
        
        btnProcess.setBounds(100, 150, 200, 30); add(btnProcess);

        // ACTIONS
        btnProcess.addActionListener(e -> processData());
        processItem.addActionListener(e -> processData());
        clearItem.addActionListener(e -> {
            txtName.setText("");
            txtPrice.setText("");
            cmbProducts.setSelectedIndex(0);
        });
    }

    private void processData() {
        try {
            String name = txtName.getText();
            String prod = cmbProducts.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            String output = "Customer Name: " + name + "\nProduct: " + prod + 
                            "\nVAT: R " + calc.GetVat() + "\nCOMMISSION: R " + calc.GetCommission() + 
                            "\nTOTAL: R " + calc.GetTotal();

            // Show Popup
            JOptionPane.showMessageDialog(this, output, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to File (Q2.3)
            try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
                out.println("DATA LOG\n***********************************");
                out.println(output);
                out.println("***********************************\n");
            } catch (IOException ex) { }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Price");
        }
    }

    public static void main(String[] args) {
        new ProductApp().setVisible(true);
    }
}