/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegisResQ.presentation;

/**
 * Darren Baker
 * Updated: 10/8/23
 */
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import RegisResQ.application.*;
import RegisResQ.persistence.*;
import javax.swing.JOptionPane;
import java.util.*;


public class MainUI extends javax.swing.JFrame {

    private ArrayList<Animal> animals = null;
    private AnimalTableModel model = new AnimalTableModel();
    private int selectedRow = -1;
    private AnimalDao database = new AnimalDao();
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        
        animals = database.getAll();
        model.setAnimals(animals);
        animalsTable.setModel(model);
        model.fireTableDataChanged();
        animalsTable.setColumnSelectionAllowed(false);
        animalsTable.setRowSelectionAllowed(true);
        
        /*Adds a listener that checks for row selection, then populates
        the text fields and combo boxes with the selected rows properties*/
        animalsTable.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseClicked(java.awt.event.MouseEvent evt) {
             String date;
             String month, day, year;
             int row = animalsTable.rowAtPoint(evt.getPoint());
             
             if (row >= 0) {
                 selectedRow = row;
                 // sets text fields
                 breedTextField.setText(model.getValueAt(row, 1).toString());
                 nameTextField.setText(model.getValueAt(row, 2).toString());
                 date = model.getValueAt(row, 4).toString();
                 yearTextField.setText(date.split("-")[0]);
                 monthTextField.setText(date.split("-")[1]);
                 dayTextField.setText(date.split("-")[2]);
                 // sets selection for the Species combo box
                 typeComboBox.setSelectedItem(model.getValueAt(row, 0));
                 //if value of sterilized is true, sets the combo box selection to "Yes"
                 if (Boolean.parseBoolean(model.getValueAt(row, 3).toString()) == true) {
                    sterilizedComboBox.setSelectedItem("Yes");
                 }
                 else {
                    sterilizedComboBox.setSelectedItem("No"); 
                 }
             }
          }
         });
        
        // Set column width
        animalsTable.setAutoCreateRowSorter(true);
        animalsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        animalsTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        animalsTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        animalsTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        animalsTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        
        // Set mnemonic keybinds for labels
        nameLabel.setDisplayedMnemonic('n');
        nameLabel.setLabelFor(nameTextField);
        breedLabel.setDisplayedMnemonic('b');
        breedLabel.setLabelFor(breedTextField);
        dateLabel.setDisplayedMnemonic('r');
        dateLabel.setLabelFor(monthTextField);
        typeLabel.setDisplayedMnemonic('t');
        typeLabel.setLabelFor(typeComboBox);
        sterilizedLabel.setDisplayedMnemonic('s');
        sterilizedLabel.setLabelFor(sterilizedComboBox);
        
        // Set mnemonic keybinds for buttons
        fileMenu.setMnemonic('f');
        exitMenuItem.setMnemonic('x');
        addButton.setMnemonic('a');
        modifyButton.setMnemonic('m');
        deleteButton.setMnemonic('d');
        exitButton.setMnemonic('x');
        
        // Add focus listeners to select all default text when a text box is accessed
        monthTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (monthTextField.getText().equals("MM") )
                monthTextField.selectAll();
            }
            @Override
            public void focusLost(FocusEvent arg0) {
            // Do nothing when focus is lost
            }
            
        });
        
        dayTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (dayTextField.getText().equals("DD") )
                dayTextField.selectAll();
            }
            @Override
            public void focusLost(FocusEvent arg0) {
            // Do nothing when focus is lost
            }
            
        });
        
        yearTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (yearTextField.getText().equals("YYYY") )
                yearTextField.selectAll();
            }
            @Override
            public void focusLost(FocusEvent arg0) {
            // Do nothing when focus is lost
            }
            
        });
            
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        animalsTable = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        breedLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        sterilizedLabel = new javax.swing.JLabel();
        breedTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        dayTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox<>();
        sterilizedComboBox = new javax.swing.JComboBox<>();
        clearButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        fileMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        animalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Breed", "Name", "Sterilized", "Arrived"
            }
        ));
        jScrollPane1.setViewportView(animalsTable);

        nameLabel.setText("Name");

        breedLabel.setText("Breed");

        dateLabel.setText("Arrival Date");

        typeLabel.setText("Type of Animal");

        sterilizedLabel.setText("Spayed/Neutered");

        monthTextField.setText("MM");

        dayTextField.setText("DD");

        yearTextField.setText("YYYY");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dog", "Cat" }));

        sterilizedComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        clearButton.setText("Clear");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        fileMenuBar.add(fileMenu);

        setJMenuBar(fileMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sterilizedLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(breedLabel)
                                        .addGap(86, 86, 86))
                                    .addComponent(dateLabel)
                                    .addComponent(typeLabel))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(breedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(sterilizedComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)
                                            .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breedLabel)
                    .addComponent(breedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sterilizedLabel)
                    .addComponent(sterilizedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(modifyButton)
                    .addComponent(deleteButton)
                    .addComponent(exitButton))
                .addGap(0, 83, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Method for adding functionality to file menu exit button
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    // Method for adding functionality to add button
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        Animal animal;
        String date;
        Boolean sterilizedValue;
        
        date = yearTextField.getText() + "-" + monthTextField.getText() + "-" +
                dayTextField.getText();
        sterilizedValue = (Boolean)(sterilizedComboBox.getSelectedItem().toString().equals("Yes"));
        if (typeComboBox.getSelectedItem().toString().equals("Dog")) {
            animal = new Dog(breedTextField.getText(), nameTextField.getText(),
            sterilizedValue, date);
        }
        else {
            animal = new Cat(breedTextField.getText(), nameTextField.getText(),
            sterilizedValue, date);
        }
        if (animal.validate() == false) {
            System.err.println("Error: Animal Data Invalid");
            JOptionPane.showMessageDialog(null, "Error: Animal Data Invalid");
            return;
        }
        if (database.add(animal) == false) {
            System.err.println("Error: Animal could not be added to database");
            JOptionPane.showMessageDialog(null, "Error: Animal could not be added to database");
            return;
        }
        
        animals.add(animal);
        selectedRow = -1;
        model.setAnimals(animals);
        model.fireTableDataChanged();
        nameTextField.setText("");
        breedTextField.setText("");
        monthTextField.setText("MM");
        dayTextField.setText("DD");
        yearTextField.setText("YYYY");
        typeComboBox.setSelectedIndex(0);
        sterilizedComboBox.setSelectedIndex(0);
        
    }//GEN-LAST:event_addButtonActionPerformed
    
    //method for adding functionality to modify button
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed

        if (selectedRow < 0)
            return;
       Animal animal;
       String date;
       Boolean sterilizedValue;
       
       animal = animals.get(selectedRow);
       animal.setBreed(breedTextField.getText());
       animal.setName(nameTextField.getText());
       date = yearTextField.getText() + "-" + monthTextField.getText() + "-" +
                dayTextField.getText();
       sterilizedValue = (Boolean)(sterilizedComboBox.getSelectedItem().toString().equals("Yes"));
       animal.setDateArrived(date);
       animal.setSterilized(sterilizedValue);
       
       if (animal.validate() == false) {
           System.err.println("Error: Animal Data Invalid");
           JOptionPane.showMessageDialog(null, "Error: Animal Data Invalid");
           return;
       }
       if (database.update(animal) == false) {
           System.err.println("Error: Animal could not be updated in database");
           JOptionPane.showMessageDialog(null, "Error: Animal could not be updatd in database");
           return;
       }
       selectedRow = -1;
       model.fireTableDataChanged();
       nameTextField.setText("");
       breedTextField.setText("");
       monthTextField.setText("MM");
       dayTextField.setText("DD");
       yearTextField.setText("YYYY");
       typeComboBox.setSelectedIndex(0);
       sterilizedComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_modifyButtonActionPerformed
    
    // Method for adding functionality to delete button
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        if (selectedRow < 0)
            return;
        
        int selectedOption;
        Animal animal;
        animal = animals.get(selectedRow);
        
        selectedOption = JOptionPane.showConfirmDialog(null, 
                "Delete the selected row?", "Yes/No",
                JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            animals.remove(selectedRow);
            model.fireTableDataChanged();
            database.delete(animal);
            selectedRow = -1;
            nameTextField.setText("");
            breedTextField.setText("");
            monthTextField.setText("MM");
            dayTextField.setText("DD");
            yearTextField.setText("YYYY");
            typeComboBox.setSelectedIndex(0);
            sterilizedComboBox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    // method for adding functionality to main exit button
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable animalsTable;
    private javax.swing.JLabel breedLabel;
    private javax.swing.JTextField breedTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar fileMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> sterilizedComboBox;
    private javax.swing.JLabel sterilizedLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
