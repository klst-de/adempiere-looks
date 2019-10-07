package org.compiere.plaf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.compiere.swing.ColorBlind;
import org.compiere.swing.ExtendedTheme;

public class StaticUtils {

	static ResourceBundle   s_res = ResourceBundle.getBundle("org.compiere.plaf.PlafRes");

	/**
	 *  Center Window on Screen and show it
	 *  @param window window
	 */
	// aus AdempierePLAF
	public static void showCenterScreen (Window window)
	{
		window.pack();
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension wSize = window.getSize();
		window.setLocation(((sSize.width-wSize.width)/2), ((sSize.height-wSize.height)/2));
		window.toFront();
		window.setVisible(true);
	}

	/**
	 *  Create OK Button
	 *  @return OK button
	 */
	// aus AdempierePLAF
	public static JButton getOKButton()
	{
		JButton b = new JButton();
		b.setIcon(new ImageIcon(StaticUtils.class.getResource("icons/Ok24.gif")));
		b.setMargin(new Insets(0,10,0,10));
		b.setToolTipText (s_res.getString("OK"));
		return b;
	}   //  getOKButton

	/**
	 *  Create Cancel Button
	 *  @return Cancel button
	 */
	// aus AdempierePLAF
	public static JButton getCancelButton()
	{
		JButton b = new JButton();
		b.setIcon(new ImageIcon(StaticUtils.class.getResource("icons/Cancel24.gif")));
		b.setMargin(new Insets(0,10,0,10));
		b.setToolTipText (s_res.getString("Cancel"));
		return b;
	}   //  getCancelButton

	/**
	 *  Return Normal field background color "text".
	 *  Windows = white
	 *  @return Color
	 */
	// aus AdempierePLAF
	public static Color getFieldBackground_Normal()
	{
		//  window => white
		return ColorBlind.getDichromatColor(UIManager.getColor("text"));
	}   //  getFieldBackground_Normal

	/**
	 *  Return Inactive field background color
	 *  @return Color
	 */
	// aus AdempierePLAF
	public static Color getFieldBackground_Inactive()
	{
		Color c = UIManager.getColor(ExtendedTheme.INACTIVE_BG_KEY);
		if ( c != null )
			return ColorBlind.getDichromatColor(c);
		else
			return getFieldBackground_Normal();
	}   //  getFieldBackground_Inactive
}
