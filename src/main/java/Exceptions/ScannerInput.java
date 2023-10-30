package Exceptions;

import java.util.Scanner;

public class ScannerInput {
    private String string;
    private Recorder recorder;
    private Scanner sc;

    public ScannerInput() {
        this.sc = new Scanner (System.in);
        System.out.println("Введите в любом порядке: " +
                "Фамилию, имя, отчество, " +
                "дату рождения (в формате: дд.мм.гггг), " +
                "номер телефона, " +
                "пол (в формате: f или m)");

        this.string = sc.nextLine();
        this.recorder = new Recorder(string);
        recorder.recording();
    }
}
