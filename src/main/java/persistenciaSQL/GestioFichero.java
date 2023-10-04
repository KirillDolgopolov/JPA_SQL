package persistenciaSQL;

import java.io.*;

import entities.Floristeria;

public class GestioFichero {

	public static void writeFloristeria(Floristeria floristeria) {

		ObjectOutputStream oos;

		{
			try {
				oos = new ObjectOutputStream(new FileOutputStream("persistencia.txt"));
				oos.writeObject(floristeria);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static Floristeria readFloristeria() {

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("persistencia.txt"));
			Floristeria floristeria = (Floristeria) ois.readObject();
			return floristeria;
		
		} catch (Exception e) {
			return null;
		}

	}

}
