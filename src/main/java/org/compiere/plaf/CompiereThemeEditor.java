/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.plaf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;

//import org.adempiere.plaf.AdempierePLAF;
//import org.compiere.swing.CButton;
import org.compiere.swing.CDialog;
import org.compiere.swing.CPanel;
import org.compiere.swing.FontChooser;

/**
 *  Java Theme Editor.
 *  Edit the attributes and save them in Ini.properties.
 *  Does not set background of AdempiereColorUI.
 *
 *  @author     Jorg Janke
 *  @version    $Id: AdempiereThemeEditor.java,v 1.3 2006/07/30 00:52:24 jjanke Exp $
 */
public class CompiereThemeEditor extends CDialog
	implements ActionListener
{
//	public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				// Create and set up the windows
//				JDialog jDialog = new CompiereThemeEditor(null);
////				jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//				jDialog.pack();
//				jDialog.setVisible(true);
//			}
//		});
//	}
	
	private static final long serialVersionUID = 6865599987532875192L;
	private static Logger log = Logger.getLogger(CompiereThemeEditor.class.getName());

	/**
	 *  Constructor
	 *  @param  owner Frame owner
	 */
	public CompiereThemeEditor(JDialog owner) {
		super(owner, s_res.getString(CompiereThemeEditor.class.getSimpleName()), true); // (Dialog owner, String title, boolean modal)
		try {
			jbInit();
			loadTheme();
			dynInit();
			StaticUtils.showCenterScreen(this);
		} catch (Exception e) {
			log.warning(e.getMessage());
			e.printStackTrace();
		}
	} // AdempiereThemeEditor

	static ResourceBundle   s_res = ResourceBundle.getBundle("org.compiere.plaf.PlafRes");

	private JButton primary1 = new JButton();
	private JButton primary2 = new JButton();
	private JButton primary3 = new JButton();
	private JButton secondary1 = new JButton();
	private JButton secondary2 = new JButton();
	private JButton secondary3 = new JButton();
	private JButton controlFont = new JButton();
	private JButton systemFont = new JButton();
	private JButton userFont = new JButton();
	private JButton smallFont = new JButton();
	private JButton mandatory = new JButton();
	private JButton error = new JButton();
	private JButton windowFont = new JButton();
	private JButton menuFont = new JButton();
	private JButton white = new JButton();
	private JButton black = new JButton();
	private CPanel confirmPanel = new CPanel();

	private JButton inactive = new JButton();
	private JButton txt_ok = new JButton();
	private JButton txt_error = new JButton();
	private JButton bCancel = StaticUtils.getCancelButton();
	private JButton bOK = StaticUtils.getOKButton();
	private FlowLayout confirmLayout = new FlowLayout();
	private CPanel centerPanel = new CPanel();
	private CPanel metalColorPanel = new CPanel();
	private BorderLayout centerLayout = new BorderLayout();
	private CPanel adempiereColorPanel = new CPanel();
	private TitledBorder metalColorBorder;
	private TitledBorder adempiereColorBorder;
	private GridLayout metalColorLayout = new GridLayout();
	private GridLayout adempiereColorLayout = new GridLayout();
	private CPanel fontPanel = new CPanel();
	private GridLayout fontLayout = new GridLayout();
	private TitledBorder fontBorder;
	private JButton info = new JButton();

	/**
	 *  Static Init
	 *  @throws Exception
	 */
	private void jbInit() throws Exception
	{
		metalColorBorder = new TitledBorder(s_res.getString("MetalColors"));
		adempiereColorBorder = new TitledBorder(s_res.getString("AdempiereColors"));
		fontBorder = new TitledBorder(s_res.getString("AdempiereFonts"));
		fontPanel.setBorder(fontBorder);
		fontPanel.setOpaque(false);

		// defaultCloseOperation must be one of: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, or DISPOSE_ON_CLOSE
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//
		primary1.setToolTipText(s_res.getString("Primary1Info"));
		primary1.setText(s_res.getString("Primary1"));
		primary1.addActionListener(this);
		primary2.setToolTipText(s_res.getString("Primary2Info"));
		primary2.setText(s_res.getString("Primary2"));
		primary2.addActionListener(this);
		primary3.setToolTipText(s_res.getString("Primary3Info"));
		primary3.setText(s_res.getString("Primary3"));
		primary3.addActionListener(this);
		secondary1.setToolTipText(s_res.getString("Secondary1Info"));
		secondary1.setText(s_res.getString("Secondary1"));
		secondary1.addActionListener(this);
		secondary2.setToolTipText(s_res.getString("Secondary2Info"));
		secondary2.setText(s_res.getString("Secondary2"));
		secondary2.addActionListener(this);
		secondary3.setToolTipText(s_res.getString("Secondary3Info"));
		secondary3.setText(s_res.getString("Secondary3"));
		secondary3.addActionListener(this);
		controlFont.setToolTipText(s_res.getString("ControlFontInfo"));
		controlFont.setText(s_res.getString("ControlFont"));
		controlFont.addActionListener(this);
		systemFont.setToolTipText(s_res.getString("SystemFontInfo"));
		systemFont.setText(s_res.getString("SystemFont"));
		systemFont.addActionListener(this);
		userFont.setToolTipText(s_res.getString("UserFontInfo"));
		userFont.setText(s_res.getString("UserFont"));
		userFont.addActionListener(this);
		smallFont.setText(s_res.getString("SmallFont"));
		smallFont.addActionListener(this);
		mandatory.setToolTipText(s_res.getString("MandatoryInfo"));
		mandatory.setText(s_res.getString("Mandatory"));
		mandatory.addActionListener(this);
		error.setToolTipText(s_res.getString("ErrorInfo"));
		error.setText(s_res.getString("Error"));
		error.addActionListener(this);
		info.setToolTipText(s_res.getString("InfoInfo"));
		info.setText(s_res.getString("Info"));
		info.addActionListener(this);
		windowFont.setText(s_res.getString("WindowTitleFont"));
		windowFont.addActionListener(this);
		menuFont.setText(s_res.getString("MenuFont"));
		menuFont.addActionListener(this);
		white.setToolTipText(s_res.getString("WhiteInfo"));
		white.setText(s_res.getString("White"));
		white.addActionListener(this);
		black.setToolTipText(s_res.getString("BlackInfo"));
		black.setText(s_res.getString("Black"));
		black.addActionListener(this);
		inactive.setToolTipText(s_res.getString("InactiveInfo"));
		inactive.setText(s_res.getString("Inactive"));
		inactive.addActionListener(this);
		txt_ok.setToolTipText(s_res.getString("TextOKInfo"));
		txt_ok.setText(s_res.getString("TextOK"));
		txt_ok.addActionListener(this);
		txt_error.setToolTipText(s_res.getString("TextIssueInfo"));
		txt_error.setText(s_res.getString("TextIssue"));
		txt_error.addActionListener(this);
		//
		confirmPanel.setLayout(confirmLayout);
		confirmLayout.setAlignment(FlowLayout.RIGHT);
		centerPanel.setLayout(centerLayout);
		metalColorPanel.setBorder(metalColorBorder);
		metalColorPanel.setOpaque(false);
		metalColorPanel.setLayout(metalColorLayout);
		adempiereColorPanel.setLayout(adempiereColorLayout);
		adempiereColorPanel.setBorder(adempiereColorBorder);
		adempiereColorPanel.setOpaque(false);
		metalColorLayout.setColumns(3);
		metalColorLayout.setHgap(5);
		metalColorLayout.setRows(3);
		metalColorLayout.setVgap(5);
		adempiereColorLayout.setColumns(4);
		adempiereColorLayout.setHgap(5);
		adempiereColorLayout.setRows(2);
		adempiereColorLayout.setVgap(5);
		fontPanel.setLayout(fontLayout);
		fontLayout.setColumns(3);
		fontLayout.setHgap(5);
		fontLayout.setRows(2);
		fontLayout.setVgap(5);
		centerLayout.setVgap(5);
		fontBorder.setTitle(s_res.getString("Fonts"));
		confirmPanel.setOpaque(false);
		this.getContentPane().add(confirmPanel, BorderLayout.SOUTH);
		confirmPanel.add(bCancel, null);
		confirmPanel.add(bOK, null);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(metalColorPanel,  BorderLayout.NORTH);
		metalColorPanel.add(primary1, null);
		metalColorPanel.add(primary2, null);
		metalColorPanel.add(primary3, null);
		metalColorPanel.add(secondary1, null);
		metalColorPanel.add(secondary2, null);
		metalColorPanel.add(secondary3, null);
		metalColorPanel.add(white, null);
		metalColorPanel.add(black, null);
		centerPanel.add(adempiereColorPanel, BorderLayout.CENTER);
		adempiereColorPanel.add(txt_error, null);
		centerPanel.add(fontPanel, BorderLayout.SOUTH);
		fontPanel.add(controlFont, null);
		fontPanel.add(systemFont, null);
		fontPanel.add(menuFont, null);
		fontPanel.add(userFont, null);
		fontPanel.add(windowFont, null);
		fontPanel.add(smallFont, null);
		adempiereColorPanel.add(error, null);
		adempiereColorPanel.add(inactive, null);
		adempiereColorPanel.add(txt_ok, null);
		adempiereColorPanel.add(mandatory, null);
		adempiereColorPanel.add(info, null);
		
		bCancel.addActionListener(this);
		bOK.addActionListener(this);
	}   //  jbInit

	/**
	 *  Load Theme from current Setting (if MetalLookAndFeel)
	 */
	private void loadTheme() {
		if (UIManager.getLookAndFeel() instanceof MetalLookAndFeel) {
			log.config("LookAndFeel is instanceof MetalLookAndFeel");
			// AdempiereTheme.setTheme();
		} else {
			log.config("Not a Metal Theme: "+UIManager.getLookAndFeel().toString());
			primary1.setEnabled(false);
			primary2.setEnabled(false);
			primary3.setEnabled(false);
			secondary1.setEnabled(false);
			secondary2.setEnabled(false);
			secondary3.setEnabled(false);
		}
	} // loadTheme

	/**
	 *  Dynamic Init
	 */
	private void dynInit()
	{
		//  Colors
		primary1.setBackground(CompiereTheme.primary1);
		primary2.setBackground(CompiereTheme.primary2);
		primary3.setBackground(CompiereTheme.primary3);
		secondary1.setBackground(CompiereTheme.secondary1);
		secondary2.setBackground(CompiereTheme.secondary2);
		secondary3.setBackground(CompiereTheme.secondary3);
		//
		white.setBackground(CompiereTheme.white);
		black.setBackground(CompiereTheme.secondary3);
		black.setForeground(CompiereTheme.black);
		//
		error.setBackground(CompiereTheme.error);
		mandatory.setBackground(CompiereTheme.mandatory);
		inactive.setBackground(CompiereTheme.inactive);
		info.setBackground(CompiereTheme.info);
		//
		txt_ok.setBackground(CompiereTheme.white);
		txt_ok.setForeground(CompiereTheme.txt_ok);
		txt_error.setBackground(CompiereTheme.white); //	AdempierePLAF.getFieldBackground_Normal()
		txt_error.setForeground(CompiereTheme.txt_error);

		//  Fonts
		controlFont.setFont(CompiereTheme.controlFont);
		systemFont.setFont(CompiereTheme.systemFont);
		userFont.setFont(CompiereTheme.userFont);
		smallFont.setFont(CompiereTheme.smallFont);
		menuFont.setFont(CompiereTheme.menuFont);
		windowFont.setFont(CompiereTheme.windowFont);
	}   //  dynInit

	/**
	 *  Action Listener
	 *  @param e
	 */
	public void actionPerformed(ActionEvent e)
	{
		//  Confirm
		if (e.getSource() == bOK)
		{
			//CompiereTheme.saveEx();
			dispose();
			return;
		}
		//  Cancel
		else if (e.getSource() == bCancel)
		{
			dispose();
			return;
		}

		try {                   //  to capture errors when Cancel in JColorChooser

		if (e.getSource() == primary1)
		{
			CompiereTheme.primary1 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Primary1"), CompiereTheme.primary1));
		}
		else if (e.getSource() == primary2)
		{
			CompiereTheme.primary2 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Primary2"), CompiereTheme.primary2));
		}
		else if (e.getSource() == primary3)
		{
			CompiereTheme.primary3 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Primary3"), CompiereTheme.primary3));
		}
		else if (e.getSource() == secondary1)
		{
			CompiereTheme.secondary1 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Secondary1"), CompiereTheme.secondary1));
		}
		else if (e.getSource() == secondary2)
		{
			CompiereTheme.secondary2 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Secondary2"), CompiereTheme.secondary2));
		}
		else if (e.getSource() == secondary3)
		{
			CompiereTheme.secondary3 = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Secondary3"), CompiereTheme.secondary3));
		}

		else if (e.getSource() == error)
		{
			CompiereTheme.error = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Error"), CompiereTheme.error));
		}
		else if (e.getSource() == mandatory)
		{
			CompiereTheme.mandatory = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Mandatory"), CompiereTheme.mandatory));
		}
		else if (e.getSource() == inactive)
		{
			CompiereTheme.inactive = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Inactive"), CompiereTheme.inactive));
		}
		else if (e.getSource() == info)
		{
			CompiereTheme.info = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Info"), CompiereTheme.info));
		}

		else if (e.getSource() == black)
		{
			CompiereTheme.black = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("Black"), CompiereTheme.black));
		}
		else if (e.getSource() == white)
		{
			CompiereTheme.white = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("White"), CompiereTheme.white));
		}
		else if (e.getSource() == txt_ok)
		{
			CompiereTheme.txt_ok = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("TextOK"), CompiereTheme.txt_ok));
		}
		else if (e.getSource() == txt_error)
		{
			CompiereTheme.txt_error = new ColorUIResource(JColorChooser.showDialog
				(this, s_res.getString("TextIssue"), CompiereTheme.txt_error));
		}

		else if (e.getSource() == controlFont)
		{
			CompiereTheme.controlFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("ControlFont"), CompiereTheme.controlFont));
		}
		else if (e.getSource() == systemFont)
		{
			CompiereTheme.systemFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("SystemFont"), CompiereTheme.systemFont));
		}
		else if (e.getSource() == userFont)
		{
			CompiereTheme.userFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("UserFont"), CompiereTheme.userFont));
		}
		else if (e.getSource() == smallFont)
		{
			CompiereTheme.smallFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("SmallFont"), CompiereTheme.smallFont));
		}
		else if (e.getSource() == menuFont)
		{
			CompiereTheme.menuFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("MenuFont"), CompiereTheme.menuFont));
		}
		else if (e.getSource() == windowFont)
		{
			CompiereTheme.windowFont = new FontUIResource(FontChooser.showDialog
				(this, s_res.getString("WindowTitleFont"), CompiereTheme.windowFont));
		}

		} catch (Exception ee) {}   //  to capture errors when Cancel in JColorChooser

		dynInit();
	}   //  actionPerformed

}   //  AdempiereThemeEditor
