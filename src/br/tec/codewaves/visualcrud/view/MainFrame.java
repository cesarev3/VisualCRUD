/*
 * Created by JFormDesigner on Mon Jan 08 10:55:39 BRT 2024
 */

package br.tec.codewaves.visualcrud.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        textEmail.setText("");
        textName.setText("");
        textBirthDate.setText("");
        textMessage.setText("");
    }

    private void create(ActionEvent e) {
        // TODO add your code here
        String userName = textName.getText();
        String userEmail = textEmail.getText();
        String userBirthDate = textBirthDate.getText();

        if (userOperations.validarEmail(userEmail)) {
            JOptionPane.showMessageDialog(null, """
                    Atenção!
                    Usuário com email duplicado
                    dados não serão salvos!""");

        } else if (!user.isBirthdayDateOk(user, userBirthDate)) {
            JOptionPane.showMessageDialog(null, "Data inválida!");

        } else {
            User inputUser = new User(userName, userEmail,
                    user.stringToLocalDate(userBirthDate));

            int answer = JOptionPane.showConfirmDialog(null,
                    "Cadastrar o usuário?\n" +
                            "Nome: " + userName + "\nemail: " + userEmail +
                            "\nData Nascimento: " + userBirthDate);

            if (answer == JOptionPane.YES_OPTION) {
                userOperations.saveUser(inputUser);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
                cleanEntries();
            }
        }
    }

    private void update(ActionEvent e) {
        // TODO add your code here
        String userName = textName.getText();
        String userEmail = textEmail.getText();
        String userBirthDate = textBirthDate.getText();

        if (!userOperations.validarEmail(userEmail)) {
            JOptionPane.showMessageDialog(null, "Atenção!\n" +
                    "Email não faz parte do banco de dados. Inclua antes de atualizar");

        } else if (!user.isBirthdayDateOk(user, userBirthDate)) {
            JOptionPane.showMessageDialog(null, "Data inválida!");

        } else {
            User inputUser = new User(userName, userEmail,
                    user.stringToLocalDate(userBirthDate));

            int answer = JOptionPane.showConfirmDialog(null,
                    "Atualizar o usuário?\n" +
                            "Nome: " + userName + "\nemail: " + userEmail +
                            "\nData Nascimento: " + userBirthDate);

            if (answer == JOptionPane.YES_OPTION) {
                userOperations.updateUser(inputUser);
                JOptionPane.showMessageDialog(null, "Usuário atualizado!");
                cleanEntries();
            }
        }
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
        String userName = textName.getText();
        String userEmail = textEmail.getText();
        String userBirthDate = textBirthDate.getText();

        if (!userOperations.validarEmail(userEmail)) {
            JOptionPane.showMessageDialog(null,
                    "Atenção!\n" + "Usuário não faz parte do banco de dados." +
                            " Inclua antes de atualizar");

        } else {
            int answer = JOptionPane.showConfirmDialog(null,
                    "Excluir o usuário?\n" +
                            "Nome: " + userName + "\nemail: " + userEmail +
                            "\nData Nascimento: " + userBirthDate);

            if (answer == JOptionPane.YES_OPTION) {
                userOperations.removeUser(userEmail);
                JOptionPane.showMessageDialog(null, "Usuário excluído!");
                cleanEntries();
            }
        }
    }

    private void read(ActionEvent e) {
        // TODO add your code here
        List<User> dataBaseUsers;
        StringBuilder readOut = new StringBuilder();

        dataBaseUsers = userOperations.getDataBaseUsers();

        for(User item : dataBaseUsers) {
            readOut.append("Nome: ").append(item.getUserName())
                    .append("\ne-mail: ").append(item.getUserEmail())
                    .append(" | Nascimento: ")
                    .append(user.localDateToPanel(item.getUserBirthDate()))
                    .append(" | ")
                    .append(user.calculateAge(item.getUserBirthDate()))
                    .append(" anos").append("\n-------\n");
        }
        textMessage.setText(readOut.toString());
    }

    private void search(ActionEvent e) {
        // TODO add your code here
        List<User> dataBaseUsers = userOperations.getDataBaseUsers();
        List<String> inputList = new ArrayList<>();

        if (!textName.getText().isEmpty()) {
            searchByName(dataBaseUsers, inputList);
        } else {
            searchByEmail(dataBaseUsers, inputList);
        }
    }

    private void cleanEntries() {
        textEmail.setText("");
        textName.setText("");
        textBirthDate.setText("");
        textMessage.setText("");
    }

    private void searchByName(List<User> dataBaseUsers, List<String> inputList) {

        for(User user : dataBaseUsers) {
            inputList.add(user.getUserName());
        }

        String userName = textName.getText();
        List<String> foundNames = inputList.stream().filter(
                nome -> nome.toLowerCase().contains(userName.toLowerCase())).toList();

        if (foundNames.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nenhum usuário localizado");
        } else {

            StringBuilder readOut = new StringBuilder();
            String searchName;

            for (String searchItem : foundNames) {
                searchName = searchItem;
                for (User item : userOperations.getDataBaseUsers()) {
                    if (searchName.equals(item.getUserName())) {
                        readOut.append("Nome: ").append(item.getUserName())
                                .append("\ne-mail: ").append(item.getUserEmail())
                                .append(" | Nascimento: ")
                                .append(user.localDateToPanel(item.getUserBirthDate()))
                                .append(" | ")
                                .append(user.calculateAge(item.getUserBirthDate()))
                                .append(" anos\n-------\n");

                        textName.setText(item.getUserName());
                        textEmail.setText(item.getUserEmail());
                        textBirthDate.setText(user.localDateToText(
                                item.getUserBirthDate()));
                    }
                }
            }
        textMessage.setText(readOut.toString());
        }
    }

    private void searchByEmail(List<User> dataBaseUsers, List<String> inputList) {

        for(User user : dataBaseUsers) {
            inputList.add(user.getUserEmail());
        }

        String userName = textEmail.getText();
        List<String> foundNames = inputList.stream().filter(
                nome -> nome.toLowerCase().contains(userName.toLowerCase())).toList();

        if (foundNames.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nenhum usuário localizado");
        } else {

            StringBuilder readOut = new StringBuilder();
            String searchName;

            for (String searchItem : foundNames) {
                searchName = searchItem;
                for (User item : userOperations.getDataBaseUsers()) {
                    if (searchName.equals(item.getUserEmail())) {
                        readOut.append("Nome: ").append(item.getUserName())
                                .append("\ne-mail: ").append(item.getUserEmail())
                                .append(" | Nascimento: ")
                                .append(user.localDateToPanel(item.getUserBirthDate()))
                                .append(" | ")
                                .append(user.calculateAge(item.getUserBirthDate()))
                                .append(" anos\n-------\n");

                        textName.setText(item.getUserName());
                        textEmail.setText(item.getUserEmail());
                        textBirthDate.setText(user.localDateToText(
                                item.getUserBirthDate()));
                    }
                }
            }
        textMessage.setText(readOut.toString());
        }
    }
    private void populateDataBase() {
        Random random = new Random();

        String[] maleNames = {"Miguel", "Arthur", "Gael", "Heitor", "Theo",
                "Davi", "Gabriel", "Bernardo", "Samuel", "Joao Miguel"};
        String[] femaleNames = {"Helena", "Alice", "Laura", "Maria Alice",
                "Valentina", "Heloisa", "Maria Clara", "Maria Cecilia",
                "Maria Julia", "Sophia"};
        String[] lastNames = {"Silva", "Cavalcanti", "Oliveira", "Santos",
                "Souza", "Lima", "Costa", "Pereira", "Carvalho", "Rodrigues"};

        for (int i = 0; i < 50; i++) {
            String testUserName;
            int gender = random.nextInt(2);
            if (gender == 0) {
                testUserName = (maleNames[random.nextInt(10)] + " " +
                        lastNames[random.nextInt(10)]);
            } else {
                testUserName = (femaleNames[random.nextInt(10)] + " " +
                        lastNames[random.nextInt(10)]);
            }


            String[] splitName = testUserName.split(" ");
            String testUserEmail = (splitName[0].trim()).toLowerCase() +
                    (random.nextInt(9000) + 1000) + "@email.com";

            int testUserYear = random.nextInt(100) + 1924;
            int testUserMonth = random.nextInt(12) + 1;
            int testUserDay = random.nextInt(28) + 1;


            if (!userOperations.validarEmail(testUserEmail)) {
                User inputUser = new User(testUserName, testUserEmail, LocalDate.of(testUserYear,
                        testUserMonth, testUserDay));
                userOperations.saveUser(inputUser);
            }
        }
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
            "[70,fill]" +
            "[70,fill]" +
            "[110,fill]" +
            "[70,fill]" +
            "[70,fill]" +
            "[70,fill]" +
            "[70,fill]",
            // rows
            "[54]" +
            "[]" +
            "[50]" +
            "[50]" +
            "[50]" +
            "[60]" +
            "[60]" +
            "[60]" +
            "[40]"));

        //---- label1 ----
        label1.setText("Visual CRUD");
        label1.setFont(new Font("sansserif", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, "cell 0 0 7 1");

        //---- label2 ----
        label2.setText("Nome");
        label2.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(label2, "cell 0 2");

        //---- textName ----
        textName.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(textName, "cell 1 2 6 1");

        //---- label3 ----
        label3.setText("Email");
        label3.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(label3, "cell 0 3");

        //---- textEmail ----
        textEmail.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(textEmail, "cell 1 3 4 1");

        //---- label4 ----
        label4.setText("Nascimento em");
        label4.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(label4, "cell 0 4 2 1");

        //---- textBirthDate ----
        textBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
        textBirthDate.setFont(new Font("sansserif", Font.PLAIN, 18));
        contentPane.add(textBirthDate, "cell 2 4");

        //---- buttonCreate ----
        buttonCreate.setText("Incluir");
        buttonCreate.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonCreate.addActionListener(e -> create(e));
        contentPane.add(buttonCreate, "cell 3 4 2 1");

        //---- buttonSearch ----
        buttonSearch.setText("Pesquisar");
        buttonSearch.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonSearch.addActionListener(e -> search(e));
        contentPane.add(buttonSearch, "cell 5 4 2 1");

        //======== scrollPane1 ========
        {

            //---- textMessage ----
            textMessage.setRows(9);
            textMessage.setFont(new Font("sansserif", Font.PLAIN, 16));
            scrollPane1.setViewportView(textMessage);
        }
        contentPane.add(scrollPane1, "cell 0 5 7 3");

        //---- buttonCleaner ----
        buttonCleaner.setText("Limpar tela");
        buttonCleaner.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonCleaner.addActionListener(e -> {
			cleaner(e);
			cleaner(e);
		});
        contentPane.add(buttonCleaner, "cell 0 8 2 1");

        //---- buttonRead ----
        buttonRead.setText("Listar");
        buttonRead.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonRead.addActionListener(e -> read(e));
        contentPane.add(buttonRead, "cell 2 8");

        //---- buttonUpdate ----
        buttonUpdate.setText("Alterar");
        buttonUpdate.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonUpdate.addActionListener(e -> update(e));
        contentPane.add(buttonUpdate, "cell 3 8 2 1");

        //---- buttonDelete ----
        buttonDelete.setText("Excluir");
        buttonDelete.setFont(new Font("sansserif", Font.PLAIN, 18));
        buttonDelete.addActionListener(e -> delete(e));
        contentPane.add(buttonDelete, "cell 5 8 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // personalizado
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visual CRUD - CodeWaves");

        MaskFormatter maskDate;
        try {
            maskDate = new MaskFormatter("##/##/####");
            maskDate.setPlaceholderCharacter('_');
            textBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory
                    (maskDate));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        populateDataBase();

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
