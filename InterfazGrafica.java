import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class InterfazGrafica implements ActionListener{

	private JButton botonAbrir;
	private JButton botonGuardar;
	private JTextField textoUnaLinea;
	private JTextArea textoMultilinea;

	public InterfazGrafica(){
		JFrame ventana = new JFrame();
		ventana.setLayout(null);
		ventana.setBounds(400, 150, 600, 600); // x,y,ancho, alto

		botonAbrir = new JButton("Abrir");
		botonAbrir.setBounds(150, 50,100,30);// x,y,ancho, alto
		botonAbrir.addActionListener(this);
		ventana.getContentPane().add(botonAbrir);


		botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(260, 50,100,30);// x,y,ancho, alto
		botonGuardar.addActionListener(this);
		ventana.getContentPane().add(botonGuardar);

		textoUnaLinea = new JTextField();
		textoUnaLinea.setBounds(10,90, 570,30);
		ventana.getContentPane().add(textoUnaLinea);

		textoMultilinea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textoMultilinea);

		scroll.setBounds(10,130, 570,400);
		ventana.getContentPane().add(scroll);

		ventana.setVisible(true);
	}

	private void abrirArchivo(){
		String ruta = this.textoUnaLinea.getText();
		LectorDeArchivos lector = new LectorDeArchivos(ruta);
		String contenido = lector.leerArchivo();
		this.textoMultilinea.setText(contenido);
		lector.cerrar();
	}

	private void guardarArchivo(){
		String ruta = this.textoUnaLinea.getText();
		EscritorDeArchivos escritor = new EscritorDeArchivos(ruta, false);
		escritor.escribir(this.textoMultilinea.getText());
		escritor.cerrar();
	}

	public void actionPerformed(ActionEvent evento){
		System.out.println("Evento: "+ evento);
		String nombreEvento = evento.getActionCommand();
		System.out.println("Nombre: "+ nombreEvento);	
		Object quienLlama = evento.getSource();
		if(quienLlama == botonAbrir){
			abrirArchivo();
		}
		else if(quienLlama == botonGuardar){
			guardarArchivo();
		}
	}

	public static void main (String args[]){
		InterfazGrafica interfaz = new InterfazGrafica();
	}

}