package forms.organizations;


import forms.utils.FormsUtils;
import models.OrganizationsRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrganizationForm extends JFrame {
    private OrganizationsRepository organizations;
    private JComboBox<String> comboBoxOrganization = new JComboBox<>();
    private JComboBox<String> comboBoxPersons = new JComboBox<>();
    private JButton addOrgButton = new JButton("Добавить организацию");
    private JButton addPersonButton = new JButton("Добавить контакт");


    public OrganizationForm(OrganizationsRepository organizations) {
        super("Организации");
        this.organizations = organizations;

        Box scrollBoxOrg = Box.createVerticalBox();
        scrollBoxOrg.add(addOrgButton);
        addOrgButton.addActionListener(new AddOrgButtonPressed(comboBoxOrganization,this));
        scrollBoxOrg.add(Box.createVerticalStrut(12));
        scrollBoxOrg.add(comboBoxOrganization);
        String[] organizationArray = organizations.getOrganizationNamesArray();
        for (int i = 0; i < organizationArray.length; i++) {
            comboBoxOrganization.addItem(organizationArray[i]);
        }
        String item = (String) comboBoxOrganization.getSelectedItem();
        String[] persons;
        if (item != null) {
            persons = organizations.getPersonsFromOrganizationArray(item);
            comboBoxOrganization.addActionListener(comboBoxListener);
            scrollBoxOrg.add(Box.createHorizontalStrut(12));
        } else {
            persons = new String[0];
        }

        Box scrollBoxPerson = Box.createVerticalBox();
        scrollBoxPerson.add(addPersonButton);
        addPersonButton.addActionListener(new AddPersonButtonPressed(this));
        scrollBoxPerson.add(Box.createVerticalStrut(12));
        scrollBoxPerson.add(comboBoxPersons);
        FormsUtils.updateComboBox(comboBoxPersons,persons);
//        for (int i = 0; i < persons.length; i++) {
//            comboBoxPersons.addItem(persons[i]);
//        }

        Box mainScrollBox = Box.createHorizontalBox();
        mainScrollBox.add(scrollBoxOrg);
        mainScrollBox.add(Box.createHorizontalStrut(12));
        mainScrollBox.add(scrollBoxPerson);
        //comboBoxOrganization.setPreferredSize(comboBoxPersons.getPreferredSize());


        Box buttonBox = Box.createHorizontalBox();
        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Отмена");
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(okButton);
        buttonBox.add(Box.createHorizontalStrut(12));
        buttonBox.add(cancelButton);


        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        // mainBox.add(addButtonBox);
        mainBox.add(mainScrollBox);
        mainBox.add(Box.createVerticalStrut(80));
        mainBox.add(buttonBox);
        setContentPane(mainBox);
        pack();
        setLocation(300, 200);

    }

    public JComboBox<String> getComboBoxOrganization() {
        return comboBoxOrganization;
    }

    ActionListener comboBoxListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox box = (JComboBox) e.getSource();
            String item = (String) box.getSelectedItem();
            if (item != null) {
                String[] persons = organizations.getPersonsFromOrganizationArray(item);
                FormsUtils.updateComboBox(comboBoxPersons, persons);
                pack();
            }
        }
    };
    private class AddOrgButtonPressed implements ActionListener{
        JComboBox<String> comboBox;
        JFrame thisFrame;
        AddOrgButtonPressed(JComboBox<String> comboBox,JFrame thisFrame){
            this.comboBox = comboBox;
            this.thisFrame = thisFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AddOrganizationForm addOrganizationForm = new AddOrganizationForm(organizations,comboBox,thisFrame);
            addOrganizationForm.setVisible(true);
        }
    }
    private class AddPersonButtonPressed implements ActionListener{
        private OrganizationForm organizationFrame;
        AddPersonButtonPressed(OrganizationForm frame){
            this.organizationFrame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String organizationName = (String) organizationFrame.comboBoxOrganization.getSelectedItem();
            AddContactForm addPersonForm = new AddContactForm(organizations,organizationName ,organizationFrame.comboBoxPersons);
            addPersonForm.setVisible(true);
        }
    }

}
