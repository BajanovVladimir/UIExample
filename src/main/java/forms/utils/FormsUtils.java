package forms.utils;

import javafx.scene.control.ComboBox;
import models.OrganizationsRepository;

import javax.swing.*;

public class FormsUtils {
    public static void updateComboBox(JComboBox comboBox, String[] dataArray){
        comboBox.removeAllItems();
        for (int i = 0; i < dataArray.length; i++) {
            comboBox.addItem(dataArray[i]);
        }

    }
}
