package br.tec.codewaves.visualcrud;

import java.time.DateTimeException;
import java.time.LocalDate;

public class User {

    private String userName;

    private String userEmail;

    private LocalDate userBirthDate;

    public User(){
    }

    public User(String userName, String userEmail, LocalDate userBirthDate) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
    }

    public boolean checkMonth (int inputMonth) {
        if (inputMonth >= 1 && inputMonth <= 12) return true;
        else {
            throw new DateTimeException("data inválida");
        }
    }

    public boolean checkYear (int inputYear) {
        LocalDate currentYear = LocalDate.now();
        return (inputYear >= 1900 && inputYear <= currentYear.getYear());
    }

    public boolean checkDay(int inputDay, int inputMonth, int inputYear) {
        int daysInMonth;
        boolean dayIsOk = false;
        switch (inputMonth) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                daysInMonth = 31;
                if (inputDay >= 1 && inputDay <= daysInMonth) dayIsOk = true;
                break;

            case 4: case 6:
            case 9: case 11:
                daysInMonth = 30;
                if (inputDay >= 1 && inputDay <= daysInMonth) dayIsOk = true;
                break;

            case 2:
                if ((inputYear % 4 == 0 && inputYear % 100 != 0) ||
                        inputYear % 400 == 0) {
                    daysInMonth = 29;
                }
                else daysInMonth = 28;

                if (inputDay >= 1 && inputDay <= daysInMonth) dayIsOk = true;
                break;
        }
        return dayIsOk;
    }

    public boolean isBirthdayDateOk(User user,
                                            String inputBirthdayDate) {

        boolean isYearOk = user.checkYear(Integer.parseInt(inputBirthdayDate.substring(6, 10)));
        boolean isMonthOk = user.checkMonth(Integer.parseInt(inputBirthdayDate.substring(3, 5)));
        boolean isDayOk = user.checkDay(Integer.parseInt(inputBirthdayDate.substring(0, 2)),
                Integer.parseInt(inputBirthdayDate.substring(3, 5)),
                Integer.parseInt(inputBirthdayDate.substring(6, 10)));

        return isYearOk && isMonthOk && isDayOk;
    }

    public LocalDate stringToLocalDate(String inputBirthdayDate) {
        return LocalDate.of(
                Integer.parseInt(inputBirthdayDate.substring(6, 10)),
                Integer.parseInt(inputBirthdayDate.substring(3, 5)),
                Integer.parseInt(inputBirthdayDate.substring(0, 2)));
    }

    public String localDateToText(LocalDate inputBirthdayDate) {
        String birthDay;
        if (inputBirthdayDate.getDayOfMonth() < 10) {
            birthDay = "0" + String.valueOf(inputBirthdayDate.getDayOfMonth());
        } else {
            birthDay = String.valueOf(inputBirthdayDate.getDayOfMonth());
        }

        String birthMonth;
        if (inputBirthdayDate.getMonthValue() < 10) {
            birthMonth = "0" + String.valueOf(inputBirthdayDate.getMonthValue());
        } else {
            birthMonth = String.valueOf(inputBirthdayDate.getMonthValue());
        }

        return birthDay + birthMonth + String.valueOf(inputBirthdayDate.getYear());
    }

    public String localDateToPanel(LocalDate inputBirthdayDate) {
        String stringDate = localDateToText(inputBirthdayDate);
        return stringDate.substring(0, 2) + "/" + stringDate.substring(2, 4) +
                "/" + stringDate.substring(4, 8);
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public LocalDate getUserBirthDate() {
        return this.userBirthDate;
    }



}