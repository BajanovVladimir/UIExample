package forms.utils;

import javax.swing.*;

public class FormsUtils {
    public static void updateComboBox(JComboBox comboBox, String[] dataArray){
        comboBox.removeAllItems();
        for (String s : dataArray) {
            comboBox.addItem(s);
        }

    }
}
