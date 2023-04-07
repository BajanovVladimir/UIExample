package forms.organizations;

import forms.utils.FormsUtils;
import models.Organization;
import models.OrganizationsRepository;
import models.Person;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactForm extends JFrame {
    private OrganizationsRepository organization;
    private String organizationName;
    private JComboBox updateComboBox;
    private JButton saveContactButton;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldPosition;
    private JTextField textFieldPerson;

    AddContactForm(OrganizationsRepository organization, String organizationName, JComboBox comboBox) {
        super("Добавить контакт");
        this.organization = organization;
        this.updateComboBox = comboBox;
        this.organizationName = organizationName;

        textFieldPerson = new JTextField(" ");
        JLabel personLabel = new JLabel("Ф.И.О");
        textFieldPhoneNumber = new JTextField(" ");
        JLabel phoneNumberLabel = new JLabel("Номер телефона");
        textFieldPosition = new JTextField(" ");
        JLabel positionLabel = new JLabel("Должность");
        saveContactButton = new JButton("Сохранить");
        saveContactButton.addActionListener(new SaveContactButtonPressed(this));

        Box organizationNameBox = Box.createVerticalBox();
        JLabel organizationLabel = new JLabel(organizationName);
        organizationNameBox.add(organizationLabel);
        organizationNameBox.add(Box.createVerticalStrut(30));

        Box textFieldsBox = Box.createVerticalBox();
        textFieldsBox.add(personLabel);
        textFieldsBox.add(Box.createVerticalStrut(6));
        textFieldsBox.add(textFieldPerson);
        textFieldsBox.add(Box.createVerticalStrut(12));
        textFieldsBox.add(positionLabel);
        textFieldsBox.add(Box.createVerticalStrut(6));
        textFieldsBox.add(textFieldPosition);
        textFieldsBox.add(Box.createVerticalStrut(12));
        textFieldsBox.add(phoneNumberLabel);
        textFieldsBox.add(textFieldPhoneNumber);
        textFieldsBox.add(Box.createVerticalStrut(12));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createVerticalGlue());
        buttonBox.add(saveContactButton);


        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(organizationNameBox);
        mainBox.add(textFieldsBox);
        mainBox.add(buttonBox);
        setContentPane(mainBox);
        pack();
        setLocation(300, 200);
    }
    private  class  SaveContactButtonPressed implements ActionListener {
        private JFrame contactFrame;
        SaveContactButtonPressed(JFrame frame){
            this.contactFrame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           Organization thisOrganization = organization.getOrganization(organizationName);
           String personName = textFieldPerson.getText();
           String positionName = textFieldPosition.getText();
           String phoneNumber = textFieldPhoneNumber.getText();
           Person newPerson = new Person(positionName,personName,phoneNumber);
           thisOrganization.addPerson(newPerson);
           String[] contactsArray = organization.getPersonsFromOrganizationArray(organizationName);
           FormsUtils.updateComboBox(updateComboBox,contactsArray);
           this.contactFrame.setVisible(false);
        }
    }

}
