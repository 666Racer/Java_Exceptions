package Exceptions;

import java.io.FileWriter;

public class Recorder {
    private String string;
    private Parser parser;

    public Recorder(String string) {
        this.string = string;
        this.parser = new Parser(string);
    }
    public void recording(){
        try (FileWriter fileWriter = new FileWriter(parser.getData().
                getFio().
                get(0). //создаём имя файла с фамилией человека
                toString() + ".txt", true)) {
            fileWriter.append(parser.getData().toString());
            System.out.println("Запись завершена");
        } catch (Exception e){
            e.getMessage();
        }
    }
}
