/*
 * Copyright (c) 2002-2015 JGoodies Software GmbH. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of JGoodies Software GmbH nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jgoodies.binding.tests;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import junit.framework.TestCase;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

/**
 * A test case for class {@link Bindings}.
 *
 * @author  Karsten Lentzsch
 * @version $Revision: 1.11 $
 */
public final class BindingsTest extends TestCase {


    private static final String TEXT_WITH_NEWLINE =
        "First line\nsecond line";

    private static final String TEXT_WITHOUT_NEWLINE =
        TEXT_WITH_NEWLINE.replace('\n', ' ');



    /**
     * Checks that the enablement of a JCheckBox is in synch
     * with the enablement of its model after Binding#bind.
     */
    public static void testCheckBoxEnablementInSynchWithModel() {
        JCheckBox box = new JCheckBox();
        box.setEnabled(false);
        Bindings.bind(box, new ValueHolder());
        assertButtonEnablementInSynchWithModel(box);
    }


    public static void testCheckBoxRetainsProperties() {
        JCheckBox box = new JCheckBox("Anna");
        String actionCommand = "command";
        box.setActionCommand(actionCommand);
        box.setMnemonic('A');
        box.setDisplayedMnemonicIndex(3);
        assertEquals("Old action command", actionCommand, box.getActionCommand());
        assertEquals("Old mnemonic",       'A', box.getMnemonic());
        assertEquals("Old mnemonic index", 3,   box.getDisplayedMnemonicIndex());
        Bindings.bind(box, new ValueHolder());
        assertEquals("New action command", actionCommand, box.getActionCommand());
        assertEquals("New mnemonic",       'A', box.getMnemonic());
        assertEquals("New mnemonic index", 3,   box.getDisplayedMnemonicIndex());
    }


    /**
     * Checks that the enablement of a JCheckBoxMenuItem is in synch
     * with the enablement of its model after Binding#bind.
     */
    public static void testCheckBoxItemEnablementInSynchWithModel() {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem();
        item.setEnabled(false);
        Bindings.bind(item, new ValueHolder());
        assertButtonEnablementInSynchWithModel(item);
    }


    public static void testCheckBoxMenuItemRetainsProperties() {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem("Anna");
        String actionCommand = "command";
        item.setActionCommand(actionCommand);
        item.setMnemonic('A');
        item.setDisplayedMnemonicIndex(3);
        assertEquals("Old action command", actionCommand, item.getActionCommand());
        assertEquals("Old mnemonic",       'A', item.getMnemonic());
        assertEquals("Old mnemonic index", 3,   item.getDisplayedMnemonicIndex());
        Bindings.bind(item, new ValueHolder());
        assertEquals("New action command", actionCommand, item.getActionCommand());
        assertEquals("New mnemonic",       'A', item.getMnemonic());
        assertEquals("New mnemonic index", 3,   item.getDisplayedMnemonicIndex());
    }


    /**
     * Checks that the enablement of a JRadioButton is in synch
     * with the enablement of its model after Binding#bind.
     */
    public static void testRadioButtonEnablementInSynchWithModel() {
        JRadioButton radio = new JRadioButton();
        radio.setEnabled(false);
        Bindings.bind(radio, new ValueHolder(), null);
        assertButtonEnablementInSynchWithModel(radio);
    }


    public static void testRadioButtonRetainsProperties() {
        JRadioButton radio = new JRadioButton("Anna");
        String actionCommand = "command";
        radio.setActionCommand(actionCommand);
        radio.setMnemonic('A');
        radio.setDisplayedMnemonicIndex(3);
        assertEquals("Old action command", actionCommand, radio.getActionCommand());
        assertEquals("Old mnemonic",       'A', radio.getMnemonic());
        assertEquals("Old mnemonic index", 3,   radio.getDisplayedMnemonicIndex());
        Bindings.bind(radio, new ValueHolder(), Boolean.TRUE);
        assertEquals("New action command", actionCommand, radio.getActionCommand());
        assertEquals("New mnemonic",       'A', radio.getMnemonic());
        assertEquals("New mnemonic index",  3,  radio.getDisplayedMnemonicIndex());
    }


    /**
     * Checks that the enablement of a JRadioButtonMenuItem is in synch
     * with the enablement of its model after Binding#bind.
     */
    public static void testRadioButtonMenuItemEnablementInSynchWithModel() {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem();
        item.setEnabled(false);
        Bindings.bind(item, new ValueHolder(), null);
        assertButtonEnablementInSynchWithModel(item);
    }


    public static void testRadioButtonMenuItemRetainsProperties() {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem("Anna");
        String actionCommand = "command";
        item.setActionCommand(actionCommand);
        item.setMnemonic('A');
        item.setDisplayedMnemonicIndex(3);
        assertEquals("Old action command", actionCommand, item.getActionCommand());
        assertEquals("Old mnemonic",       'A', item.getMnemonic());
        assertEquals("Old mnemonic index", 3,   item.getDisplayedMnemonicIndex());
        Bindings.bind(item, new ValueHolder(), Boolean.TRUE);
        assertEquals("New action command", actionCommand, item.getActionCommand());
        assertEquals("New mnemonic",       'A', item.getMnemonic());
        assertEquals("New mnemonic index",  3,  item.getDisplayedMnemonicIndex());
    }


    public static void testBoundTextAreaRetainsNewlines() {
        ValueModel subject = new ValueHolder(TEXT_WITH_NEWLINE);
        JTextArea textArea = new JTextArea();
        Bindings.bind(textArea, subject);
        assertEquals("The text area's text contains newlines.",
                TEXT_WITH_NEWLINE, textArea.getText());
    }


    public static void testBoundTextFieldFiltersNewlines() {
        ValueModel subject = new ValueHolder(TEXT_WITH_NEWLINE);
        JTextField textField = new JTextField();
        Bindings.bind(textField, subject);
        assertEquals("The text field's text contains no newlines.",
                TEXT_WITHOUT_NEWLINE, textField.getText());
    }


    // Helper Code ************************************************************

    /**
     * Checks that the enablement of the given button is in synch
     * with the enablement of its model, an instance of ToggleButtonModel.
     *
     * @param button  the button to check
     */
    private static void assertButtonEnablementInSynchWithModel(AbstractButton button) {
        assertEquals("Enabled state of component and model must be in synch.",
                button.isEnabled(),
                button.getModel().isEnabled());
    }


}

