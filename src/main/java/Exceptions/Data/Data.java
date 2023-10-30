package Exceptions.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Data {
    private ArrayList fio = new ArrayList<>(); //ФИО помещаем в массив
    private Date date; //дата рождения в соответствующем формате
    private Long phoneNumber; //Long - чтобы хватило места в памяти
    private String sex; //достаточно типа char, но вводится будет строка

    public ArrayList getFio() {
        return fio;
    }

    public void setFio(String string) {
        this.fio.add(string);
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        return fio.get(0) + " " + //фамилия
                fio.get(1) + " " + //имя
                fio.get(2) + " " + //отчество
                dateFormat.format(date) + " " + //дата рождения
                phoneNumber + " " + //номер телефона
                sex + "\n\r"; //пол
    }
}
