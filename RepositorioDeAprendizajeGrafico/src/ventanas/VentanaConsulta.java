/**
 * 
 */
package ventanas;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Logica;

/**
 * @author HENAO
 *
 */
public class VentanaConsulta extends JFrame  implements ActionListener{

	private Container contenedor;
	JLabel titulo;
	JTextField cajaTexto;
	JTextArea area,areaResultado;	
	JButton boton;
	 private JScrollPane scroll,scroll2;
	 Logica miLogica;
	public VentanaConsulta()
	{
        contenedor=getContentPane();
        contenedor.setLayout(null);
		titulo = new JLabel();
		
	    titulo.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
	    titulo.setText("CONSULTAR LECCION APRENDIDA ");
	    titulo.setBounds(60, 10, 430, 40);
	    
	    cajaTexto=new JTextField();
	    cajaTexto.setBounds(260, 80, 90, 25);
	    
	    boton=new JButton();
	    boton.setText("Consultar");
	    boton.setBounds(360, 80, 90, 25);
	    boton.addActionListener(this);
	    
	    scroll= new JScrollPane();
	    
	    area = new JTextArea();
	    area.setColumns(20);
	    area.setLineWrap(true);
	    area.setRows(5);
	    area.setWrapStyleWord(true);
	    
	    scroll.setViewportView(area);
	    scroll.setBounds(40, 80, 200, 100);
	    
	    scroll2= new JScrollPane();
	    
	    areaResultado = new JTextArea();
	    areaResultado.setColumns(20);
	    areaResultado.setLineWrap(true);
	    areaResultado.setRows(5);
	    areaResultado.setWrapStyleWord(true);
	    
	    scroll2.setViewportView(areaResultado);
	    scroll2.setBounds(40, 200, 400, 200);
	       
	    contenedor.add(scroll);
	    contenedor.add(scroll2);
	    contenedor.add(titulo);
	    contenedor.add(cajaTexto);
	    contenedor.add(boton);
	   // show();   					
		setTitle("REPOSITORIO DE APRENDIZAJE");
		setSize(520,500);				
	    }
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton)
		{
			consultarTema();
		}
	}

	public void muestraTemas(String consultarTema) {
		area.setText(consultarTema);
	}
	
	public void consultarTema() {
		int ingreso=0;
		try {
		
		ingreso= Integer.parseInt(cajaTexto.getText());
		areaResultado.setText(miLogica.realizaBusqueda(ingreso-1));
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setLogica(Logica miLogica) {
		this.miLogica=miLogica;
	}

}
