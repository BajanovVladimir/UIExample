package forms.main_form;

import forms.access_form.AccessWindow;

import javax.swing.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    super("Основное меню");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JTable table = new JTable(new PersonTableModel());
    JScrollPane scrollPane = new JScrollPane(table);
    Box boxTable = Box.createHorizontalBox();
    boxTable.add(scrollPane);
    Box boxButton = Box.createHorizontalBox();
    JButton buttonExit = new JButton("Exit");
    boxButton.add(Box.createHorizontalGlue());
    boxButton.add(buttonExit);
    boxButton.add(Box.createHorizontalStrut(12));
    Box mainBox = Box.createVerticalBox();
    mainBox.add(boxTable);
    mainBox.add(Box.createVerticalStrut(12));
    mainBox.add(boxButton);
    mainBox.add(Box.createVerticalStrut(12));
    setContentPane(mainBox);
    pack();
    setSize(600,400);
    setLocation(300,100);

  }
  public void modalAccessFrame(){
   AccessWindow accessWindow = new AccessWindow(this);
   accessWindow.setVisible(true);
  }

}
