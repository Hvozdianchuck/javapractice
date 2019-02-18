package advanced2;

import java.io.*;

public class ExampleExternalizer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(( new File("temp.txt"))));
         house.writeExternal(objectOutputStream);
         objectOutputStream.close();
         ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("temp.txt")));
         House house2 = new House();
         house2.readExternal(objectInputStream);
         objectInputStream.close();
        System.out.println(house2);
    }


    static class House implements Externalizable{
   int rooms;
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.write(rooms);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         rooms=in.readInt();
        }
    }
}
