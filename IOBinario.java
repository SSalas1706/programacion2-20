import java.io.*;
public class IOBinario{
	
	public void escribir(Carta carta, String archivo){
		try{
			ObjectOutputStream escritor = new ObjectOutputStream(
				new FileOutputStream(archivo));
			escritor.writeObject(carta);
			escritor.close();
		}
		catch(IOException e){
			System.err.println("Ocurrió un error: "+ e);
		}
	}

	public Carta leer(String archivo){
		Carta carta = null;
		try{
			ObjectInputStream lector = new ObjectInputStream(
				new FileInputStream(archivo));

			Object objeto = lector.readObject();
			carta = (Carta)objeto;
			lector.close();
		}
		catch(IOException e){
			System.err.println("Ocurrió un error al leer: "+ e);
		}
		catch(ClassNotFoundException e){
			System.err.println("Ocurrió un error al hacer casting: "+ e);
		}
		return carta;
	}



	public static void main (String args[]){
		IOBinario io = new IOBinario();
		Carta carta = new Carta(3,"Corazones");
		io.escribir(carta, "3Corazones");

		Carta carta2 = io.leer("3Corazones");
		System.out.println(carta2);

	}
}