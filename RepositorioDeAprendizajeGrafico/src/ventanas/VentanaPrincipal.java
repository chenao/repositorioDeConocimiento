package ventanas;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Logica;


public class VentanaPrincipal  extends JFrame  implements ActionListener{

	
	private Container contenedor;
	JLabel titulo;
	JTextField a,b,num;
	private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenuItem itemRegistrar,itemConsultar, itemSalir;
	Logica miLogica;
    
	public VentanaPrincipal()
	{
		miLogica= new Logica();
		
        contenedor=getContentPane();
        contenedor.setLayout(null);
		initComponents();
		titulo = new JLabel();
		   
	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    titulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
	    titulo.setText("REPOSITORIO DE APRENDIZAJE");
	    titulo.setBounds(40, 10, 430, 40);
	        
	    contenedor.add(titulo);
	       					
		setTitle("REPOSITORIO DE APRENDIZAJE");
		setSize(520,200);
		show();
				
	    }
	private void initComponents() {
		 barraMenu = new JMenuBar();
	     menuArchivo = new JMenu();
	     itemRegistrar = new JMenuItem();
	     itemConsultar = new JMenuItem();
	     itemSalir = new JMenuItem();
	              
	     itemConsultar.setText("Consultar Lección");
	     menuArchivo.add(itemConsultar);
	     menuArchivo.addSeparator();
	     	        
	     itemRegistrar.setText("Registrar Lección");
	     menuArchivo.add(itemRegistrar);
	     menuArchivo.addSeparator();
	     
	     itemSalir.setText("Salir");
	     menuArchivo.add(itemSalir);
	     menuArchivo.addSeparator();
	       
	     menuArchivo.setText("Archivo");
	     barraMenu.add(menuArchivo);
	     
	     itemConsultar.addActionListener(this);
	     itemSalir.addActionListener(this);
	     setJMenuBar(barraMenu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itemConsultar)
		{
			String temas=miLogica.muestraTemas();		
			VentanaConsulta consulta=new VentanaConsulta();
			consulta.setLogica(miLogica);
			consulta.muestraTemas(temas);
			consulta.setVisible(true);
		}
		
		if(e.getSource()==itemSalir)
		{
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro que desea salir?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				System.exit(0);
			}
		}
	}


}
