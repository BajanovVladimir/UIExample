package forms.organizations;

import forms.utils.FormsUtils;
import models.OrganizationsRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrganizationForm extends JFrame {
    private final OrganizationsRepository organization;
    private final JTextField textFieldOrgName = new JTextField(" ");
    private final JComboBox updateComboBox;

    public AddOrganizationForm(OrganizationsRepository organization, JComboBox comboBox, JFrame fatherFrame){
        super("Добавить организацию");
        this.organization = organization;
        this.updateComboBox = comboBox;

        JLabel textFieldLabel = new JLabel("Введите название организации");
        JButton saveButton = new JButton("Сохранить");
        JButton exitButton = new JButton("Выйти");

        Box textFieldBox = Box.createVerticalBox();
        textFieldBox.add(textFieldLabel);
        textFieldBox.add(Box.createHorizontalStrut(6));
        textFieldBox.add(textFieldOrgName);

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createVerticalGlue());
        buttonBox.add(saveButton);
        saveButton.addActionListener(new SaveButtonPressed(this,fatherFrame));
        buttonBox.add(Box.createVerticalStrut(12));
        buttonBox.add(exitButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(textFieldBox);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(buttonBox);
        setContentPane(mainBox);
        pack();
        setLocation(300, 200);
    }

    private class SaveButtonPressed implements ActionListener{
        private final JFrame frame;
        private final JFrame fatherFrame;
        SaveButtonPressed(JFrame frame, JFrame fatherFrame){
            this.frame = frame;
            this.fatherFrame = fatherFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(textFieldOrgName.getText().length() > 2) {
                organization.addOrganization(textFieldOrgName.getText());
                String[] orgArray = organization.getOrganizationNamesArray();
                FormsUtils.updateComboBox(updateComboBox, orgArray);
                fatherFrame.pack();
                this.frame.setVisible(false);
            }
        }
    }
}
