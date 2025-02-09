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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A test suite for all tests related to the JGoodies Binding framework.
 *
 * @author  Karsten Lentzsch
 * @version $Revision: 1.45 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    AbstractConverterTest.class,
    AbstractTableAdapterTest.class,
    BasicComponentFactoryTest.class,
    BeanAdapterTest.class,
    BeanUtilsTest.class,
    BinderTest.class,
    BindingsTest.class,
    BoundedRangeAdapterTest.class,
    BufferedValueModelTest.class,
    CombinedTest.class,
    ComboBoxAdapterTest.class,
    ConverterFactoryTest.class,
    ExtendedPropertyChangeSupportTest.class,
    IndirectPropertyChangeSupportTest.class,
    IndirectListModelTest.class,
    PreferencesAdapterTest.class,
    PresentationModelTest.class,
    PropertyAdapterTest.class,
    PropertyConnectorTest.class,
    PropertyExceptionTest.class,
    RadioButtonAdapterTest.class,
    ReflectionTest.class,
    SelectionInListTest.class,
    SingleListSelectionAdapterTest.class,
    SpinnerAdapterFactoryTest.class,
    TextComponentConnectorTest.class,
    ToggleButtonAdapterTest.class,
    TriggerTest.class,
    ValueChangeTest.class,
    ValueHolderTest.class
})
public final class AllBindingTests {

    // Just a suite definition class.

}
