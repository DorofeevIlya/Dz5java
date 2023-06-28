package Seminar5dz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> spisok = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ADD Фамилия Телефон(без пробелов) | GET Фамилия | REMOVE Фамилия | LIST | EXIT");
        while (true) {
            System.out.print("Введите команду: ");
            String inputLine = scanner.nextLine();
            if ("EXIT".equals(inputLine)){ System.out.println("Программа завершена!"); break; }
            String[] arrayParam = inputLine.trim().split(" ");
            int paramCount = arrayParam.length; //
            String command = "", user = "", tel = "";
            if (paramCount > 0) { command = arrayParam[0];}
            if (paramCount > 1) { user = arrayParam[1];}
            if (paramCount > 2) { tel = arrayParam[2];}
            switch (command){
                case "ADD": //
                    if (paramCount != 3){ System.out.println("Неверное кол-во аргументов!"); continue; }
                    ArrayList<String> lstPhone;
                    if (spisok.get(user) == null){
                        lstPhone = new ArrayList<>();
                    } else {
                        lstPhone = spisok.get(user);
                    }
                    lstPhone.add(tel);
                    spisok.put(user,lstPhone);
                    continue;
                case "GET":
                    if (paramCount != 2){ System.out.println("Неверное кол-во аргументов!"); continue; }
                    if (spisok.get(user) == null) { System.out.println("Фамилия " + user + " не найдена"); continue; }
                    System.out.println(user + "=>" + spisok.get(user));
                    continue;
                case "REMOVE":
                    if (paramCount != 2){ System.out.println("Неверное кол-во аргументов!"); continue; }
                    if (spisok.get(user) == null) {
                        System.out.println("Фамилия " + user + " не найдена");
                    } else {
                        spisok.remove(user);
                        System.out.println("Запись с фамилией " + user + " удалена!");
                    }
                    continue;
                case "LIST":
                    if (spisok.isEmpty() == true) {
                        System.out.println("Список пуст");
                    } else {
                        System.out.println(spisok);
                    }
                    continue;
                default:
                System.out.println("Команда не существует!");
            }
        }
    }
}