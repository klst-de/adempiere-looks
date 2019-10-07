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

import junit.framework.TestCase;

import com.jgoodies.binding.tests.event.PropertyChangeReport;
import com.jgoodies.binding.value.BindingConverter;
import com.jgoodies.binding.value.ConverterValueModel;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

/**
 * A test case for class {@link BindingConverter}.
 *
 * @author  Karsten Lentzsch
 * @version $Revision: 1.9 $
 */
public final class AbstractConverterTest extends TestCase {

    private ValueHolder subject;
    private ValueModel  converter;


    /**
     * @throws Exception  in case of an unexpected problem
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        subject = new ValueHolder();
        converter = new ConverterValueModel(subject,  new TestConverter());
    }

    /**
     * @throws Exception  in case of an unexpected problem
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        converter = null;
        subject = null;
    }


    // Tests ******************************************************************

    public void testGetValueConversion() {
        Integer value = new Integer(1);
        Object expectedConversion = "1";

        subject.setValue(value);
        assertEquals("The int " + value + " is converted to " + expectedConversion,
                expectedConversion,
                converter.getValue());
    }


    public void testSetValueConversion() {
        Object convertedValue = "1";
        Integer expectedValue = new Integer(1);

        converter.setValue(convertedValue);
        assertEquals("The converter value " + convertedValue + " is converted to " + expectedValue,
                expectedValue,
                subject.getValue());
    }


    public void testPropertyChangeEventConversion() {
        Integer oldSubjectValue = null;
        Integer newSubjectValue = new Integer(1);
        Object expectedOldValue = null;
        Object expectedNewValue = "1";

        subject.setValue(oldSubjectValue);
        PropertyChangeReport subjectReport = new PropertyChangeReport();
        PropertyChangeReport converterReport = new PropertyChangeReport();
        subject.addValueChangeListener(subjectReport);
        converter.addValueChangeListener(converterReport);

        subject.setValue(newSubjectValue);
        assertEquals("The old subject event value is " + oldSubjectValue,
                oldSubjectValue,
                subjectReport.lastOldValue());
        assertEquals("The old converter event value is " + expectedOldValue,
                expectedOldValue,
                converterReport.lastOldValue());

        assertEquals("The new subject event value is " + newSubjectValue,
               newSubjectValue,
                subjectReport.lastNewValue());
        assertEquals("The new converter event value is " + expectedNewValue,
                expectedNewValue,
                converterReport.lastNewValue());
    }


    // Test Converter *********************************************************

    /**
     * An example converter that converts Integers to their String
     * representations. Cannot convert {@code null}.
     */
    private static final class TestConverter implements BindingConverter {

        @Override
        public Object targetValue(Object sourceValue) {
            return sourceValue.toString();
        }

        @Override
		public Object sourceValue(Object targetValue) {
            return new Integer(Integer.parseInt((String) targetValue));
        }
    }

}

