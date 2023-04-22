package Hw3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Presenter {

    private String name = "no data";
    private String surName = "no data";
    private String patronymic = "no data";
    private String birthDay = "no data";
    private long phoneNumber = 0;
    private char gender = '-';

    private Viever viever;

    public Presenter(Viever viever) {
        this.viever = viever;
    }

    public void run() {
        boolean flag = true;
        String[] temp;
        while (flag) {
            temp = viever.getInfoConsole().split(" ");
            if (checkingtTheAmountOfData(temp) == -2) {
                viever.littleData();
                continue;
            }
            if (checkingtTheAmountOfData(temp) == -1) {
                viever.lotsOfData();
                continue;
            } else {
                try {
                    dataVerification(temp);
                } catch (DateException e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат в строке \"Телефон\"");
                    continue;
                } catch (GenderException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                flag = false;
                try {
                    saver();
                } catch (IOException e) {
                    System.out.println("Ошибка чтения/записи");
                    e.printStackTrace();
                }
            }
        }
    }

    private int checkingtTheAmountOfData(String[] info) {
        if (info.length < 6) {
            return -2;
        } else if (info.length > 6) {
            return -1;
        } else
            return 0;

    }

    private void dataVerification(String[] data) throws NumberFormatException, GenderException, DateException {
        this.name = data[0];
        this.surName = data[1];
        this.patronymic = data[2];

        this.birthDay = checkDate(data[3]);
        this.phoneNumber = Long.parseLong(data[4]);
        this.gender = checkGender(data[5]);
        viever.closeScanner();

    }

    private char checkGender(String data) throws GenderException {

        if (data.equals("f") || data.equals("m")) {
            return data.charAt(0);
        } else {
            throw new GenderException("Неверный формат данных в строке \"Пол\"");
        }
    }

    private String checkDate(String data) throws DateException {
        // дата_рождения - строка формата dd.mm.yyyy
        if (data.length() != 10) {
            throw new GenderException("Неверный формат данных в строке \"Дата\"");
        }
        if (data.charAt(2) != '.' || data.charAt(5) != '.') {
            throw new GenderException("Неверный формат данных в строке \"Дата\"");
        }
        boolean flag = true;
        for (char i : data.substring(0, 2).toCharArray()) {
            if (!Character.isDigit(i)) {
                flag = false;
            }
        }

        for (char i : data.substring(3, 5).toCharArray()) {
            if (!Character.isDigit(i)) {
                flag = false;
            }
        }

        for (char i : data.substring(6, 10).toCharArray()) {
            if (!Character.isDigit(i)) {
                flag = false;
            }
        }
        if (flag == false) {
            throw new GenderException("Неверный формат данных в строке \"Дата\"");
        }
        return data;
    }

    private void saver() throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("<" + surName + ">");
        builder.append("<" + name + ">");
        builder.append("<" + patronymic + ">");
        builder.append("<" + birthDay + ">");
        builder.append(" ");
        builder.append("<" + phoneNumber + ">");
        builder.append("<" + gender + ">");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("" + surName + ".txt", true)) ) {

            writer.write(builder.toString());
            writer.newLine();
        }
    }
}
