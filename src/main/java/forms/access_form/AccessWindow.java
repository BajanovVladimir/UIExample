package forms.access_form;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessWindow extends JFrame {
    JTextField loginTextField;
    JPasswordField passwordTextField;

    public AccessWindow(JFrame frame){
        super("Вход в систему");
        frame.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //-------------------------------------------------------------------------------------
        Box loginBox = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Пользователь:");
        loginTextField = new JTextField(15);
        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));
        loginBox.add(loginTextField);
        //------------------------------------------------------------------------------
        Box passwordBox = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordTextField = new JPasswordField(15);
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(6));
        passwordBox.add(passwordTextField);
        //---------------------------------------------------------------------------
        Box buttonBox = Box.createHorizontalBox();
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ButtonOkPressed(this,frame));
        JButton cancelButton = new JButton("Отмена");
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(okButton);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancelButton);
        //---------------------------------------------------------------------------
        passwordLabel.setPreferredSize(loginLabel.getPreferredSize());
        //---------------------------------------------------------------------------
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(loginBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(passwordBox);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(buttonBox);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocation(450,200);
    }

    private class ButtonOkPressed implements ActionListener {
        private JFrame accessFrame;
        private JFrame frame;
        ButtonOkPressed(JFrame accessFrame,JFrame frame){
            this.accessFrame = accessFrame;
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(loginTextField.getText().equals("admin")){
                accessFrame.setVisible(false);
                frame.setEnabled(true);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Не верный пользователь или пароль");
            }
        }
    }


}
