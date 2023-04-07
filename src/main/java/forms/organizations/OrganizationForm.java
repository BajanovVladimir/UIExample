package forms.organizations;

import forms.utils.FormsUtils;
import models.OrganizationsRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrganizationForm extends JFrame {
    private final OrganizationsRepository organizations;
    private final JComboBox<String> comboBoxOrganization = new JComboBox<>();
    private final JComboBox<String> comboBoxPersons = new JComboBox<>();


    public OrganizationForm(OrganizationsRepository organizations) {
        super("Организации");
        this.organizations = organizations;

        Box scrollBoxOrg = Box.createVerticalBox();
        JButton addOrgButton = new JButton("Добавить организацию");
        scrollBoxOrg.add(addOrgButton);
        addOrgButton.addActionListener(new AddOrgButtonPressed(comboBoxOrganization,this));
        scrollBoxOrg.add(Box.createVerticalStrut(12));
        scrollBoxOrg.add(comboBoxOrganization);
        String[] organizationArray = organizations.getOrganizationNamesArray();
        for (String s : organizationArray) {
            comboBoxOrganization.addItem(s);
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
        JButton addPersonButton = new JButton("Добавить контакт");
        scrollBoxPerson.add(addPersonButton);
        addPersonButton.addActionListener(new AddPersonButtonPressed(this));
        scrollBoxPerson.add(Box.createVerticalStrut(12));
        scrollBoxPerson.add(comboBoxPersons);
        FormsUtils.updateComboBox(comboBoxPersons,persons);

        Box mainScrollBox = Box.createHorizontalBox();
        mainScrollBox.add(scrollBoxOrg);
        mainScrollBox.add(Box.createHorizontalStrut(12));
        mainScrollBox.add(scrollBoxPerson);


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
        private final OrganizationForm organizationFrame;
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
