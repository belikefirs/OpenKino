package com.components;

import java.io.*;

public class Desiariseble {
    private SpecialCard specialCard;
    private SpecialCard specialCard1;

    public Desiariseble(SpecialCard specialCard) {
        this.specialCard = specialCard;
    }


    public void whenSerializingAndDeserializing_ThenObjectIsTheSame()
            throws IOException, ClassNotFoundException {

        FileOutputStream fileOutputStream
                = new FileOutputStream("src/file/yourfile.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(specialCard);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("src/file/yourfile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        specialCard1 = (SpecialCard) objectInputStream.readObject();
        objectInputStream.close();
    }

    public SpecialCard getSpecialCard1() {
        return specialCard1;
    }
}
