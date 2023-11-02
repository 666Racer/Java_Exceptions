package Exceptions;


import Exceptions.Data.Data;
import Exceptions.Data.SizeMaxException;
import Exceptions.Data.SizeMinException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Parser {
    private String string;
    private Data data;

    public Parser(String string) {
        this.data = new Data();
        this.string = string;
        try {
            formatData(parsing(string));
        } catch (Exception e) {}
    }

    public String[] parsing(String string) throws Exception{ //проверка
        try {
            String [] arr;
            arr = string.split(" ");
            for (String temp:arr) {
                if(arr.length < 6){ //6 - магическое число, но это фамилиия, имя, отчество, дата, номер и пол
                    throw new SizeMinException();
                }
                if(arr.length > 6){ //6 - магическое число, но это фамилиия, имя, отчество, дата, номер и пол
                    throw new SizeMaxException();
                }
            }
            return arr;
        } catch (SizeMaxException e) {
            System.out.println("Слишком много данных");
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("Нет данных");
            e.printStackTrace();
        }catch (SizeMinException e){
            System.out.println("Слишком мало данных");
            e.printStackTrace();
        }return null;
    }

    public void formatData(String[]strings) throws Exception{ //можно проводить анализ того, что введено, с помощью исключений
        for (String el:strings){
            if(el.length() > 1) {
                try {
                    if(el.contains(".")){
                        DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
                        data.setDate(df.parse(el));
                        continue;
                    }
                    data.setPhoneNumber(Long.parseLong(el));
                } catch (NumberFormatException e) {
                    data.setFio(el);
                }catch (ParseException e){
                    System.out.println("Неверно введена дата");
                    e.printStackTrace();
                }
            }

                if ((el.toLowerCase().equals("f")) || (el.toLowerCase().equals("m"))){
                    data.setSex(el);
            }
            try{
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){ //если пол не f или m
                //System.out.println("Неверно введён пол, нужно f или m");
            }
        }
    }

    public Data getData() {
        return data;
    }
}
