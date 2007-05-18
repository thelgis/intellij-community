package org.jetbrains.idea.maven.core.util;

import javax.swing.*;

public class ComboBoxUtil {

  private static class Item {
    private final String value;
    private final String label;

    private Item(String value, String label) {
      this.value = value;
      this.label = label;
    }

    public String getValue() {
      return value;
    }

    public String toString() {
      return label;
    }
  }

  public static void addToModel(DefaultComboBoxModel model, Object value, String label) {
    model.addElement(new Item(String.valueOf(value), label));
  }

  public static void addToModel(DefaultComboBoxModel model, Object[][] array) {
    for (Object[] objects : array) {
      addToModel(model, objects[0], String.valueOf(objects[1]));
    }
  }

  public static void select(DefaultComboBoxModel model, String value) {
    for (int i = 0; i < model.getSize(); i++) {
      Item comboBoxUtil = (Item)model.getElementAt(i);
      if (comboBoxUtil.getValue().equals(value)) {
        model.setSelectedItem(comboBoxUtil);
        return;
      }
    }
  }

  public static String getSelectedString(DefaultComboBoxModel model) {
    return ((Item)model.getSelectedItem()).getValue();
  }
}
