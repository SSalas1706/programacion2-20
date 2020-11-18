import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ObraDeArteImagen {
 
	private static final int ANCHO = 800;
 	private static final int ALTO = 600;
// 	private static final int MIN = 0;
// 	private static final int MAX = 6;
// 	private static final int SUBMATRIZ = 25;
// 	private int[][] dibujo = null;

 	JFrame f = null;
 
 	private BufferedImage imagen = null;

 	public ObraDeArteImagen(){
 		try{
 			imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_ARGB);
 			llenarFondo();
 			BufferedImage carta = ImageIO.read(new File("10_of_hearts.png"));
 			colocarImagen(carta, 50,50);

 			BufferedImage carta2 = ImageIO.read(new File("9_of_spades.png"));
 			colocarImagen(carta2, 100,100);

 			colocarImagen(carta2, 150,150);
 		}
 		catch(Exception e){
 			System.err.println("Error: "+ e);
 		}

 		JPanel pane = new JPanel(){
 			@Override
 			protected void paintComponent(Graphics g){
 				super.paintComponent(g);
 				g.drawImage(imagen, 0,0, null);
 			}
 		};

 		f = new JFrame("Mi obra de arte");
 		f.add(pane);
 		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		f.setSize(ANCHO,ALTO);
 		f.repaint();
 		f.setVisible(true);
 	}

 	public void colocarImagen(BufferedImage imagen, int x, int y){
 		for (int i = 0; i < imagen.getWidth(); i++){
 			for (int j = 0; j < imagen.getHeight(); j++){
 				this.imagen.setRGB(x+i,y+j, imagen.getRGB(i,j));
 			}
 		}
 	}

 	public void llenarFondo(){
 		for (int i = 0 ; i < ANCHO ; i ++){
 			for (int j = 0 ; j < ALTO ; j ++){
 				imagen.setRGB(i,j, Color.WHITE.getRGB());
 			}
 		}
 	}
 
 
  	public static void main(String[] args){
	 	ObraDeArteImagen o = new ObraDeArteImagen();
  	}
}

