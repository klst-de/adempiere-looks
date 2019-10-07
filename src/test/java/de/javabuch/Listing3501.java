package de.javabuch;
/* Listing3501.java - Kapitel 35 - Swing: Grundlagen
 * Quelle:
Handbuch der Java-Programmierung, 3. Auflage, Addison Wesley, Version 3.0.1
© 1998-2003 Guido Krüger, http://www.javabuch.de
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicIconFactory;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.jdesktop.swingx.JXLoginPane;

import com.bulenkov.darcula.DarculaLaf;
import com.bulenkov.darcula.DarculaMetalTheme;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.BrownSugar;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import gov.nasa.arc.mct.gui.impl.HidableTabbedPane;
import lookandfeel.TestTheme;

public class Listing3501 extends JFrame 
//	implements ActionListener //ist mit Lambda nicht mehr notwendig!
	{
	
	private static final long serialVersionUID = -4238082996703714212L;
	
    private JButton loginLauncher;
	private DemoLoginService loginService;
	private JXLoginPane loginPane;
	private void createLoginPaneDemo() {
	    loginService = new DemoLoginService();
	    loginPane = new JXLoginPane(loginService);
        loginLauncher = new JButton("Login");
        loginLauncher.setName("launcher");
        //add(loginLauncher, BorderLayout.NORTH);
        getContentPane().add(loginLauncher, BorderLayout.EAST);
        bind();
	}
    private void bind() {
        loginLauncher.addActionListener(event -> {
//        		new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JXLoginPane.showLoginDialog(LoginPaneDemo.this, loginPane);
//            }
        	JXLoginPane.showLoginDialog(this, loginPane);
        });
//        Bindings.createAutoBinding(READ,
//                allowLogin, BeanProperty.create("selected"),
//                service, BeanProperty.create("validLogin")).bind();
    }

	private static final String[] MONTHS = { 
			"Januar", "Februar", "März", "April", "Mai", "Juni", 
			"Juli", "August", "September", "Oktober", "November", "Dezember" };

	private static final String METAL = "Metal";
	private static final String NIMBUS = "Nimbus";	// NimbusLookAndFeel
	private static final String SYNTH = "Synth";	// SynthLookAndFeel does not directly provide a look, all painting is delegated.
	// MultiLookAndFeel

	JLabel msg = new JLabel();

	private static final String JavaCup16 = "icons/JavaCup16.png";
	private static final String imageDelayed = "icons/image-delayed.png"; // Landschaft
	private static final String imageFailed = "icons/image-failed.png";
	
	Icon icon = new ImageIcon(BasicIconFactory.class.getResource(imageDelayed));
	JLabel img = new JLabel(new ImageIcon(BasicIconFactory.class.getResource(JavaCup16)));	
	HidableTabbedPane hidableTabbedPane;
	JButton buttonToggle;
	JButton buttonTabPlace;
	
	public Listing3501() {
		super("Mein erstes Swing-Programm");

		// Panel zur Namenseingabe hinzufügen
		// HidableTabbedPane extends JPanel
		JPanel namePanel = new JPanel();
		
		// statt new ImageIcon("triblue.gif") :
		//Icon icon = BasicIconFactory.getCheckBoxIcon();
		JLabel label = new JLabel("Name:", icon, SwingConstants.LEFT);		
		namePanel.add(label);
		
		JTextField tf = new JTextField(30);
		tf.setToolTipText("Geben Sie ihren Namen ein");
		namePanel.add(tf);

		buttonTabPlace = new JButton("tabPlace",new ImageIcon(BasicIconFactory.class.getResource(imageFailed)));
		buttonTabPlace.addActionListener(event -> {
			if(hidableTabbedPane.getTabPlacement()==JTabbedPane.TOP) {
				hidableTabbedPane.setTabPlacement(JTabbedPane.LEFT);
			} else {
				hidableTabbedPane.setTabPlacement(JTabbedPane.TOP);
			}
		});
		buttonToggle = new JButton("toggle");
		JPanel hiddenPanel = new JPanel();
		hiddenPanel.setLayout(new BorderLayout());
		hiddenPanel.add(buttonToggle, BorderLayout.NORTH);
		hiddenPanel.add(new JTextField(30), BorderLayout.CENTER);
		namePanel.add(hiddenPanel);
		buttonToggle.setToolTipText("ein- /ausschalten HidableTabbedPane");
		buttonToggle.addActionListener(event -> {
			if(hidableTabbedPane.isTabsShown()) {
				hidableTabbedPane.removeTabAt(1);
			} else {
				//hidableTabbedPane.addTab("sichtbar machen", img);
				hidableTabbedPane.addTab("sichtbar machen", buttonTabPlace);
				// TODO : Layout fehler bei Nimbus !!!!!!!!!
				SwingUtilities.updateComponentTreeUI(this);
			}
			this.pack();
		});

		namePanel.setBorder(BorderFactory.createEtchedBorder());
		
		// HidableTabbedPane funktionieren nur mit JTabbedPane.TOP!
		hidableTabbedPane = new HidableTabbedPane("HidableTabbedPane",namePanel);
//		hidableTabbedPane.setTabPlacement(JTabbedPane.LEFT); // default is TOP
		// es geht nicht mit new HidableTabbedPane(); ... addTab("title", namePanel); ... .addTab("sichtbar machen", img);
		// aber so:
//		HidableTabbedPane hidableTabbedPane = new HidableTabbedPane();
//		hidableTabbedPane.addTab("sichtbar machen", img); // uncomment
//		hidableTabbedPane.addTab("title", namePanel);
//		hidableTabbedPane.removeTabAt(0);
		getContentPane().add(hidableTabbedPane, BorderLayout.NORTH);

		createLoginPaneDemo();
		// Monatsliste hinzufügen
		JList<String> list = new JList<String>(MONTHS);
		list.setToolTipText("Wählen Sie ihren Geburtsmonat aus");
		getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);

		// Panel mit den Buttons hinzufügen
		JPanel buttonPanel = new JPanel();
// Nimbus zuerst wg. Layout fehler bei Nimbus
//		try {
//			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
////            AffineTransform transform = new AffineTransform();
////            transform.scale(-1, 1);
////            transform.rotate(Math.toRadians(90));
//			this.setFont(new Font("SansSerif", Font.PLAIN, 12));
//			hidableTabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 12));
//			// ???? hidableTabbedPane.extendTabsToBase
//			// RootPane.font 	Font SansSerif 12
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
		JButton buttonMetal = new JButton(METAL);
		String crossPlatformLookAndFeelClassName = UIManager.getCrossPlatformLookAndFeelClassName();
		// Set cross-platform Java L&F (also called "Metal")
		//button1.addActionListener(event -> updateLaF("javax.swing.plaf.metal.MetalLookAndFeel"));
		buttonMetal.addActionListener(event -> updateLaF(crossPlatformLookAndFeelClassName, new DefaultMetalTheme()));
		buttonMetal.setToolTipText("Metal-Look-and-Feel aktivieren");
		buttonPanel.add(buttonMetal);

		JButton buttonTest = new JButton("Test");
		buttonTest.addActionListener(event -> updateLaF(crossPlatformLookAndFeelClassName, new TestTheme()));
		buttonTest.setToolTipText("Metal-Look-and-Feel Test-theme aktivieren");
		buttonPanel.add(buttonTest);
		
//		JButton buttonOcean = new JButton("Ocean"); // was ist hier der Unterschied? TODO
//		buttonOcean.addActionListener(event -> {
////            MetalLookAndFeel.setCurrentTheme(new TestTheme());
//            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
//			try {
//				UIManager.setLookAndFeel(new MetalLookAndFeel());
//			} catch (UnsupportedLookAndFeelException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
//            
////			boolean defaultLookAndFeelDecorated = true;
////			JFrame.setDefaultLookAndFeelDecorated(defaultLookAndFeelDecorated);       
//			msg.setText("Ocean Metal-Look-and-Feel theme:"+MetalLookAndFeel.getCurrentTheme().toString());
//			SwingUtilities.updateComponentTreeUI(this);
//			this.pack();
////			updateLaF(crossPlatformLookAndFeelClassName);
//		});
//		buttonOcean.setToolTipText("Ocean Metal-Look-and-Feel aktivieren");
//		buttonPanel.add(buttonOcean);

		/*
Set the theme used by MetalLookAndFeel. 

After the theme is set, MetalLookAndFeel needs to be re-installed and the uis need to be recreated. 
The followingshows how to do this: 
   MetalLookAndFeel.setCurrentTheme(theme);

   // re-install the Metal Look and Feel
   UIManager.setLookAndFeel(new MetalLookAndFeel());

   // Update the ComponentUIs for all Components. This
   // needs to be invoked for all windows.
   SwingUtilities.updateComponentTreeUI(rootComponent);
 

 */
		JButton button2 = new JButton("Motif");
		button2.addActionListener(event -> updateLaF(MotifLookAndFeel.class.getName()));
		button2.setToolTipText("Motif-Look-and-Feel aktivieren");
		buttonPanel.add(button2);
		
		JButton button3 = new JButton("Windows");
//		button3.addActionListener(event -> updateLaF(WindowsLookAndFeel.class.getName()));
		// see https://github.com/bulenkov/Darcula
		button3.addActionListener(event -> updateLaF(DarculaLaf.class.getName(), new DarculaMetalTheme()));
		button3.setToolTipText("Windows-Look-and-Feel aktivieren");
		buttonPanel.add(button3);
		
		JButton button4 = new JButton("GTK");
		button4.addActionListener(event -> updateLaF("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"));
		button4.setToolTipText("GTK-Look-and-Feel aktivieren");
		buttonPanel.add(button4);
		
		JButton buttonPlastic = new JButton("Plastic");
		buttonPlastic.addActionListener(event -> updateLaF(PlasticLookAndFeel.class.getName(), new SkyBluer()));
		buttonPlastic.setToolTipText("Plastic-Look-and-Feel aktivieren");
		buttonPanel.add(buttonPlastic);

		// https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html
		JButton buttonNimbus = new JButton(NIMBUS);
		buttonNimbus.addActionListener(event -> updateLaF(NimbusLookAndFeel.class.getName()));
		buttonNimbus.setToolTipText("Nimbus-Look-and-Feel aktivieren");
		buttonPanel.add(buttonNimbus);
		
		JButton buttonSynth = new JButton(SYNTH);
		// klassisch:
		//button5.addActionListener(this);
		// lambda:
		buttonSynth.addActionListener(event -> {
			System.out.println(event.toString());
			updateLaF("javax.swing.plaf.synth.SynthLookAndFeel");
		});
		buttonSynth.setToolTipText("Synth-Look-and-Feel aktivieren");
		buttonPanel.add(buttonSynth);
		
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
//		getContentPane().add(buttonPanel, BorderLayout.SOUTH); => controlPanel

		// button & msg controlPanel hinzufügen
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(buttonPanel, BorderLayout.CENTER);
		controlPanel.add(msg, BorderLayout.SOUTH);
//		msg.setText("?");
		
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
		
		// Windows-Listener
		addWindowListener(new WindowClosingAdapter(true));
		// public interface WindowListener extends EventListener hat mehrere Methoden, daher geht es nicht so
/*
		this.addWindowListener( event -> {
				event.getWindow().setVisible(false);
				event.getWindow().dispose();
				System.exit(0);
		});


https://stackoverflow.com/questions/30259812/can-we-use-the-lambda-expression-for-windowlistener-if-yes-how-if-no-why-can

A lambda expression can substitute a functional interface (i.e. an interface with a single non default method). 
Therefore WindowAdapter, which has multiple methods (windowActivated(WindowEvent e), 
windowClosed(WindowEvent e), windowClosing(WindowEvent e), ...), can't be substituted by a lambda expression.

 */
	}

	/*
	 * initialisiert auch MetalLookAndFeel theme,
	 * damit ist der Bug behoben, dass nach Plastic die Schrift nicht verändert wird
	 */
	private void updateLaF(String plaf, MetalTheme theme) {
        MetalLookAndFeel.setCurrentTheme(theme);
        updateLaF(plaf);
	}
	
	private void updateLaF(String plaf) {
        //MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
		// LAF umschalten
		try {
//			UIManager.getInstalledLookAndFeels();
			UIManager.setLookAndFeel(plaf);
			msg.setText(plaf);
//			UIManager.getDefaults() ...
//			System.out.println(UIManager.getDefaults().toString());
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println(e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
			msg.setText(e.toString());
		} catch (InstantiationException e) {
			System.err.println(e.toString());
		} catch (IllegalAccessException e) {
			System.err.println(e.toString());
		}
//		this.revalidate();
//		this.repaint();
//        AffineTransform transform = new AffineTransform();
//        transform.scale(-1, 1);
//        transform.rotate(Math.toRadians(90));
		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
	}
	
//	public void actionPerformed(ActionEvent event) {
//		String cmd = event.getActionCommand();
//		try {
//			// PLAF-Klasse auswählen
//			String plaf = "unknown";
//			if (cmd.equals(METAL)) {
//				plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
//			} else if (cmd.equals(NIMBUS)) {
//				plaf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
//			} else if (cmd.equals(SYNTH)) {
//				plaf = "javax.swing.plaf.synth.SynthLookAndFeel";
//			} else if (cmd.equals("Motif")) {
//				plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//			} else if (cmd.equals("Windows")) {
//				plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//			}
//			// LAF umschalten
//			UIManager.setLookAndFeel(plaf);
//			SwingUtilities.updateComponentTreeUI(this);
//		} catch (UnsupportedLookAndFeelException e) {
//			System.err.println(e.toString());
//		} catch (ClassNotFoundException e) {
//			System.err.println(e.toString());
//		} catch (InstantiationException e) {
//			System.err.println(e.toString());
//		} catch (IllegalAccessException e) {
//			System.err.println(e.toString());
//		}
//	}

	public static void main(String[] args) {
		Listing3501 frame = new Listing3501();
		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
	}
}