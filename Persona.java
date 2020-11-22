public class Persona{
	
	protected String nombre;
	protected String cedula;
	protected int edad;

	public Persona(){
		nombre = "desconocido";
		edad = 0;
		cedula = "";
	}

	public Persona(String nombre, String cedula, int edad){
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setCedula(String cedula){
		this.cedula = cedula;
	}

	public void setEdad(int edad){
		this.edad = edad;
	}

	public String getNombre(){
		return nombre;
	}

	public String getCedula(){
		return cedula;
	}
	
	public int getEdad(){
		return edad;
	}
	



	public void bautizar(String nombre){
		this.nombre = nombre;
	}

	public void cumplirAnyos(){
		edad = edad + 1;
	}

	public void saludar(){
		System.out.println("Hola me llamo " + nombre + " y tengo " + edad + " años");
	}


}