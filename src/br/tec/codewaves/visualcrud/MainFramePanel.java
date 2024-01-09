/*
 * Created by JFormDesigner on Mon Jan 08 09:59:02 BRT 2024
 */

package br.tec.codewaves.visualcrud;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.*;

/**
 * @author magne
 */
public class MainFramePanel extends JPanel {
    public MainFramePanel() {
        initComponents();

        MaskFormatter maskDate = null;
        try {
            maskDate = new MaskFormatter("##/##/####");
            maskDate.setPlaceholderCharacter('_');
            textBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory
                    (maskDate));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void create(ActionEvent e) {
        // TODO add your code here
    }

    private void read(ActionEvent e) {
        // TODO add your code here
    }

    private void update(ActionEvent e) {
        // TODO add your code here
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Cesar
        label1 = new JLabel();
        label2 = new JLabel();
        textName = new JTextField();
        label3 = new JLabel();
        textEmail = new JTextField();
        label4 = new JLabel();
        textBirthDate = new JFormattedTextField();
        scrollPane1 = new JScrollPane();
        textMessage = new JTextArea();
        buttonCreate = new JButton();
        buttonRead = new JButton();
        buttonUpdate = new JButton();
        buttonDelete = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing //NON-NLS
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red //NON-NLS
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName( //NON-NLS
        )))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "hidemode 3", //NON-NLS
            // columns
            "[98,fill]" + //NON-NLS
            "[98,fill]" + //NON-NLS
            "[98,fill]" + //NON-NLS
            "[98,fill]", //NON-NLS
            // rows
            "[75]" + //NON-NLS
            "[]" + //NON-NLS
            "[]" + //NON-NLS
            "[]" + //NON-NLS
            "[96]" + //NON-NLS
            "[]")); //NON-NLS

        //---- label1 ----
        label1.setText("Visual CRUD by CodeWaves"); //NON-NLS
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 11f));
        add(label1, "cell 0 0 4 1,alignx center,growx 0"); //NON-NLS

        //---- label2 ----
        label2.setText("Nome"); //NON-NLS
        add(label2, "cell 0 1"); //NON-NLS
        add(textName, "cell 1 1 3 1"); //NON-NLS

        //---- label3 ----
        label3.setText("E-mail"); //NON-NLS
        add(label3, "cell 0 2"); //NON-NLS
        add(textEmail, "cell 1 2 3 1"); //NON-NLS

        //---- label4 ----
        label4.setText("Data de Nascimento"); //NON-NLS
        add(label4, "cell 0 3"); //NON-NLS
        add(textBirthDate, "cell 1 3"); //NON-NLS

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textMessage);
        }
        add(scrollPane1, "cell 0 4 4 1"); //NON-NLS

        //---- buttonCreate ----
        buttonCreate.setText("Incluir"); //NON-NLS
        buttonCreate.addActionListener(e -> create(e));
        add(buttonCreate, "cell 0 5"); //NON-NLS

        //---- buttonRead ----
        buttonRead.setText("Listar"); //NON-NLS
        buttonRead.addActionListener(e -> read(e));
        add(buttonRead, "cell 1 5"); //NON-NLS

        //---- buttonUpdate ----
        buttonUpdate.setText("Alterar"); //NON-NLS
        buttonUpdate.addActionListener(e -> update(e));
        add(buttonUpdate, "cell 2 5"); //NON-NLS

        //---- buttonDelete ----
        buttonDelete.setText("Apagar"); //NON-NLS
        buttonDelete.addActionListener(e -> delete(e));
        add(buttonDelete, "cell 3 5"); //NON-NLS
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Carlos Cesar
    private JLabel label1;
    private JLabel label2;
    private JTextField textName;
    private JLabel label3;
    private JTextField textEmail;
    private JLabel label4;
    private JFormattedTextField textBirthDate;
    private JScrollPane scrollPane1;
    private JTextArea textMessage;
    private JButton buttonCreate;
    private JButton buttonRead;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
