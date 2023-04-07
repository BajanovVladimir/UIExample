import javax.swing.*;

public class FirstUI  {
    public static void main(String[] args) {
        JFrame a = new JFrame("Yessss");

        JButton buttonClickMe = new JButton("Click me");
        buttonClickMe.setBounds(40,50,85,15);

        JTextField textFieldOne = new JTextField("Text");
        textFieldOne.setBounds(20,30,105,20);

        JScrollBar scrollBarOne = new JScrollBar();
        scrollBarOne.setBounds(20, 50,20,100);

        JMenu menu = new JMenu("Menu first");
        JMenuBar menuBar1 = new JMenuBar();
        JMenuItem menu1Item1 = new JMenuItem("Item1");
        JMenuItem menu1Item2 = new JMenuItem("Item2");
        menu.add(menu1Item1);
        menu.add(menu1Item2);
        menuBar1.add(menu);

        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        listModel1.addElement("Element1");
        listModel1.addElement("Element2");
        JList<String> list1 = new JList<>(listModel1);
        list1.setBounds(130,20,100,50);

        JLabel label1 = new JLabel("Label1");
        label1.setBounds(40,0,40,40);

        String courses[] = {"First", "Second","Three"};
        JComboBox comboBox = new JComboBox<>(courses);
        comboBox.setBounds(40,65,85,20);
//---------------------------------------------------------------------------------------------------
        a.add(buttonClickMe);
        a.add(textFieldOne);
        a.add(scrollBarOne);
        a.setJMenuBar(menuBar1);
        a.add(list1);
        a.add(label1);
        a.add(comboBox);
        a.setSize(300,200);
        a.setLayout(null);
        a.setVisible(true);
        //----------------------------------------------------------------

    }

}
