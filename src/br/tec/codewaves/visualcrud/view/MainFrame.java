/*
 * Created by JFormDesigner on Mon Jan 08 10:55:39 BRT 2024
 */

package br.tec.codewaves.visualcrud.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import br.tec.codewaves.visualcrud.User;
import br.tec.codewaves.visualcrud.UserOperations;
import net.miginfocom.swing.*;

/**
 * @author magne
 */
public class MainFrame extends JFrame {
    UserOperations userOperations = new UserOperations();
    User user = new User();


    public MainFrame() {
        initComponents();
    }

    private void cleaner(ActionEvent e) {
        // TODO add your code here
    }

    private void create(ActionEvent e) {
        // TODO add your code here
        String userName = textName.getText();
        String userEmail = textEmail.getText();
        String userBirthDate = textBirthDate.getText();

        if (userOperations.validarEmail(userEmail)) {
            JOptionPane.showMessageDialog(null, "Atenção!\n" +
                    "Usuário com email duplicado\ndados não serão salvos!");
            cleanEntries();

        } else {
            if (isBirthdayDateOk(user, userBirthDate)) {
                User inputUser = new User(userName, userEmail,
                        formatLocalDate(userBirthDate));
                userOperations.saveUser(inputUser);

                JOptionPane.showMessageDialog(null,
                        "Usuário cadastrado com sucesso\n" +
                        "Nome: " + userName + "\nemail: " + userEmail +
                                "\nData Nascimento: " + userBirthDate);

                cleanEntries();

            } else {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }
        }
    }

    private void update(ActionEvent e) {
        // TODO add your code here
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
    }

    private void read(ActionEvent e) {
        // TODO add your code here
        ArrayList<User> dataBaseUsers;
        String readOut = "";

        dataBaseUsers = userOperations.getDataBaseUsers();

        for(User item : dataBaseUsers) {
            readOut += ("------" +
                    "\nNome: " + item.getUserName() +
                    "\ne-mail: " + item.getUserEmail() +
                    " Nascimento: " + item.getUserBirthDate() + "\n");
        }
        textMessage.setText(readOut);
    }

    private void right(ActionEvent e) {
        // TODO add your code here
    }

    private void left(ActionEvent e) {
        // TODO add your code here
    }

    private void search(ActionEvent e) {
        // TODO add your code here
    }

    private static boolean isBirthdayDateOk(User user,
                                            String inputBirthdayDate) {

        boolean isYearOk = user.checkYear(Integer.parseInt(inputBirthdayDate.substring(6, 10)));
        boolean isMonthOk = user.checkMonth(Integer.parseInt(inputBirthdayDate.substring(3, 5)));
        boolean isDayOk = user.checkDay(Integer.parseInt(inputBirthdayDate.substring(0, 2)),
                Integer.parseInt(inputBirthdayDate.substring(3, 5)),
                Integer.parseInt(inputBirthdayDate.substring(6, 10)));

        return isYearOk && isMonthOk && isDayOk;
    }

    private static LocalDate formatLocalDate(String inputBirthdayDate) {
        return LocalDate.of(
                Integer.parseInt(inputBirthdayDate.substring(6, 10)),
                Integer.parseInt(inputBirthdayDate.substring(3, 5)),
                Integer.parseInt(inputBirthdayDate.substring(0, 2)));
    }

    private void cleanEntries() {
        textEmail.setText("");
        textName.setText("");
        textBirthDate.setText("");
        textMessage.setText("");
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
        buttonCreate = new JButton();
        buttonSearch = new JButton();
        scrollPane1 = new JScrollPane();
        textMessage = new JTextArea();
        buttonCleaner = new JButton();
        buttonRead = new JButton();
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

        //---- label4 ----
        label4.setText("Data de Nascimento");
        contentPane.add(label4, "cell 0 3 2 1");

        //---- textBirthDate ----
        textBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textBirthDate, "cell 2 3");

        //---- buttonCreate ----
        buttonCreate.setText("Incluir");
        buttonCreate.addActionListener(e -> create(e));
        contentPane.add(buttonCreate, "cell 3 3 2 1");

        //---- buttonSearch ----
        buttonSearch.setText("Pesquisar");
        buttonSearch.addActionListener(e -> search(e));
        contentPane.add(buttonSearch, "cell 5 3 2 1");

        //======== scrollPane1 ========
        {

            //---- textMessage ----
            textMessage.setRows(5);
            scrollPane1.setViewportView(textMessage);
        }
        contentPane.add(scrollPane1, "cell 0 4 7 3");

        //---- buttonCleaner ----
        buttonCleaner.setText("Limpar tela");
        buttonCleaner.addActionListener(e -> cleaner(e));
        contentPane.add(buttonCleaner, "cell 0 7 2 1");

        //---- buttonRead ----
        buttonRead.setText("Listar");
        buttonRead.addActionListener(e -> read(e));
        contentPane.add(buttonRead, "cell 2 7");

        //---- buttonUpdate ----
        buttonUpdate.setText("Alterar");
        buttonUpdate.addActionListener(e -> update(e));
        contentPane.add(buttonUpdate, "cell 3 7 2 1");

        //---- buttonDelete ----
        buttonDelete.setText("Apagar");
        buttonDelete.addActionListener(e -> delete(e));
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
    private JLabel label4;
    private JFormattedTextField textBirthDate;
    private JButton buttonCreate;
    private JButton buttonSearch;
    private JScrollPane scrollPane1;
    private JTextArea textMessage;
    private JButton buttonCleaner;
    private JButton buttonRead;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
