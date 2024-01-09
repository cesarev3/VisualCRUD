package br.tec.codewaves.visualcrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.text.MaskFormatter;

public class CreateFrame extends JFrame {
    private JTextField textEmail;
    private JLabel labelEmail;
    private JTextField textName;
    private JLabel labelName;
    private JLabel labelBirthDate;
    private JButton buttonInput;
    private JLabel labelMessage;
    private JPanel createPanel;
    private JButton buttonCleaner;
    private JFormattedTextField textBirthDate;


    public CreateFrame() {
        //adicionado pelos videos
        setContentPane(createPanel);
        setTitle("First CRUD");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        UserOperations userOperations = new UserOperations();

//        original do NetBeans
//        try {
//            textBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory
//                    (new javax.swing.text.MaskFormatter("##/##/####")));
//        } catch (java.text.ParseException ex) {
//            ex.printStackTrace();
//        }

        MaskFormatter maskDate = null;
        try {
            maskDate = new MaskFormatter("##/##/####");
            maskDate.setPlaceholderCharacter('_');
            textBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory
                    (maskDate));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }


        buttonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userEmail = textEmail.getText();
                String userName = textName.getText();
                String userBirthDate = textBirthDate.getText();

                if (userOperations.validarEmail(userEmail)) {
                    JOptionPane.showMessageDialog(null, "Atenção!\n" +
                            "Usuário com email duplicado\ndados não serão salvos!");

                } else {
                    User inputUser = new User(
                            userName, userEmail, LocalDate.of(1998, 7, 22));

                    userOperations.saveUser(inputUser);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso\n" +
                            "Nome: " + userName + "\nemail: " + userEmail + "\nData Nascimento: " + userBirthDate);



                }
                textEmail.setText("");
                textName.setText("");
                textBirthDate.setText("");
                labelMessage.setText("");

            }
        });

        buttonCleaner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEmail.setText("");
                textName.setText("");
                textBirthDate.setText("");
                labelMessage.setText("");

            }
        });

    }

    public static void main(String[] args) {
        CreateFrame createFrame = new CreateFrame();
        createFrame.setVisible(true);
        SwingUtilities.invokeLater(() -> new CreateFrame().setVisible(true));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
