public class Estudiante extends Persona{
	
	protected String carne;
	protected String carrera;

	public Estudiante(String nombre, String cedula, int edad, String carne, String carrera){
		super(nombre, cedula, edad);
		this.carne = carne;
		this.carrera = carrera;
	}

	public void saludar(){
		String datos = "Hola me llamo " + nombre + " mi carné es: " + carne;
		System.out.println(datos);
	}
}