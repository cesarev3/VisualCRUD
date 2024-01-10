package br.tec.codewaves.visualcrud;

import br.tec.codewaves.visualcrud.view.MainFrame;

public class Application {

    public static void main(String[] args) {

        UserOperations userOperations = new UserOperations();

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }


}
