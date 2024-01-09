/*
 * Created by JFormDesigner on Mon Jan 08 10:55:39 BRT 2024
 */

package br.tec.codewaves.visualcrud.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.*;

/**
 * @author magne
 */
public class MainFrame extends JFrame {


    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Cesar
        label1 = new JLabel();
        label2 = new JLabel();
        textName = new JTextField();
        label3 = new JLabel();
        textEmail = new JTextField();
        buttonSearch = new JButton();
        label4 = new JLabel();
        textBirthDate = new JFormattedTextField();
        buttonLeft = new JButton();
        buttonRead = new JButton();
        buttonRight = new JButton();
        scrollPane1 = new JScrollPane();
        textMessage = new JTextArea();
        buttonCleaner = new JButton();
        buttonCreate = new JButton();
        buttonUpdate = new JButton();
        buttonDelete = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[50,fill]" +
            "[50,fill]" +
            "[100,fill]" +
            "[50,fill]" +
            "[50,fill]" +
            "[50,fill]" +
            "[50,fill]",
            // rows
            "[60]" +
            "[40]" +
            "[40]" +
            "[40]" +
            "[]" +
            "[47]" +
            "[]" +
            "[40]"));

        //---- label1 ----
        label1.setText("Visual CRUD by CodeWaves");
        label1.setFont(new Font("sansserif", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, "cell 1 0 6 1");

        //---- label2 ----
        label2.setText("Nome");
        contentPane.add(label2, "cell 0 1");
        contentPane.add(textName, "cell 1 1 6 1");

        //---- label3 ----
        label3.setText("Email");
        contentPane.add(label3, "cell 0 2");
        contentPane.add(textEmail, "cell 1 2 4 1");

        //---- buttonSearch ----
        buttonSearch.setText("Pesquisar");
        contentPane.add(buttonSearch, "cell 5 2 2 1");

        //---- label4 ----
        label4.setText("Data de Nascimento");
        contentPane.add(label4, "cell 0 3 2 1");

        //---- textBirthDate ----
        textBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textBirthDate, "cell 2 3");

        //---- buttonLeft ----
        buttonLeft.setText("<");
        contentPane.add(buttonLeft, "cell 3 3");

        //---- buttonRead ----
        buttonRead.setText("Listar");
        contentPane.add(buttonRead, "cell 4 3 2 1");

        //---- buttonRight ----
        buttonRight.setText(">");
        contentPane.add(buttonRight, "cell 6 3");

        //======== scrollPane1 ========
        {

            //---- textMessage ----
            textMessage.setRows(5);
            scrollPane1.setViewportView(textMessage);
        }
        contentPane.add(scrollPane1, "cell 0 4 7 3");

        //---- buttonCleaner ----
        buttonCleaner.setText("Limpar tela");
        contentPane.add(buttonCleaner, "cell 0 7 2 1");

        //---- buttonCreate ----
        buttonCreate.setText("Incluir");
        contentPane.add(buttonCreate, "cell 2 7");

        //---- buttonUpdate ----
        buttonUpdate.setText("Alterar");
        contentPane.add(buttonUpdate, "cell 3 7 2 1");

        //---- buttonDelete ----
        buttonDelete.setText("Apagar");
        contentPane.add(buttonDelete, "cell 5 7 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // personalizado
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visual CRUD - CodeWaves");

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Carlos Cesar
    private JLabel label1;
    private JLabel label2;
    private JTextField textName;
    private JLabel label3;
    private JTextField textEmail;
    private JButton buttonSearch;
    private JLabel label4;
    private JFormattedTextField textBirthDate;
    private JButton buttonLeft;
    private JButton buttonRead;
    private JButton buttonRight;
    private JScrollPane scrollPane1;
    private JTextArea textMessage;
    private JButton buttonCleaner;
    private JButton buttonCreate;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
