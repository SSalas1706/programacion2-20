public class Docente extends Persona{
	private int codigo;
	private String unidadAcademica;

	public Docente(String nombre, String cedula, int edad, 
		int codigo, String unidadAcademica){

		super(nombre,cedula,edad);
		this.codigo = codigo;
		this.unidadAcademica = unidadAcademica;
	}

	public void saludar(){
		System.out.println("Llamo al saludar del papá desde docente");
		super.saludar();
		System.out.println("Mi unidad académica es: "+ this.unidadAcademica);
	}

	public void saludar2(){
		System.out.println("Mi codigo es: "+ this.codigo);
	}

	public static void main (String [] args){
		Persona p1 = new Persona("Adrian", "1-4020-4992", 20 );
		System.out.println(p1);
		p1.saludar();

		Docente d1 = new Docente("Andrea", "2-3033-8693", 25, 1234, "ECCI");
		System.out.println(d1);
		d1.saludar();

		Estudiante e1 = new Estudiante("María", "4-2938-2932", 19, "C01922", "Computación");
		System.out.println(e1);
		e1.saludar();

		Persona persona2 = new Estudiante("César", "2-3920-1827", 23, "B89292", "Computación");

		Persona [] personas = new Persona[4];
		personas[0] = p1;
		personas[1] = d1;
		personas[2] = e1;
		personas[3] = persona2;
		System.out.println();
		for (int i = 0 ; i < personas.length; i++){
			if (personas[i] instanceof Persona){
				System.out.println(i+" es una instancia de persona");
			}
			if (personas[i] instanceof Estudiante){
				System.out.println(i+" es una instancia de estudiante");
			}
			if (personas[i] instanceof Docente){
				System.out.println(i+" es una instancia de Docente");
				Docente docente = (Docente)personas[i];
				if (docente instanceof Persona){
					System.out.println("Sigue siendo instancia de persona");
				}
				docente.saludar2();
			}

			personas[i].saludar();
			System.out.println();
		}

	}
}