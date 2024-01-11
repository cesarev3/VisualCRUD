package br.tec.codewaves.visualcrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserOperations {

    private final List<User> dataBaseUsers;

    public UserOperations() {
        this.dataBaseUsers = new ArrayList<>();
    }

    public boolean validarEmail(String inputEmail) {

        for(User item : dataBaseUsers) {
            if (item.getUserEmail().equals(inputEmail)) {
                return true;
            }
        }
        return false;
    }

    public void removeUser(String inputEmail) {

        for(User item : dataBaseUsers) {
            if (item.getUserEmail().equals(inputEmail)) {
                this.dataBaseUsers.remove(item);
//                System.out.println(">>> usuário excluído!");
                break;
            }
        }
    }

    public void updateUser(User usuario) {

        int index = 0;
        for(User item : dataBaseUsers) {
            if (item.getUserEmail().equals(usuario.getUserEmail())) {
                break;
            }
            index ++;
        }
        this.dataBaseUsers.set(index, usuario);
//        System.out.println(">>> usuário atualizado!");
    }


    public void saveUser(User usuario) {
        dataBaseUsers.add(usuario);
//        System.out.println(">>> usuário cadastrado!");
    }



    public List<User> getDataBaseUsers() {
        return this.dataBaseUsers;
    }
}
