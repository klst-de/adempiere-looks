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

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import junit.framework.TestCase;

import com.jgoodies.binding.beans.PropertyUnboundException;

/**
 * A test case for class {@link com.jgoodies.binding.beans.PropertyException}.
 *
 * @author Karsten Lentzsch
 * @version $Revision: 1.12 $
 */
public final class PropertyExceptionTest extends TestCase {

    // Constructor Tests ******************************************************

    @SuppressWarnings("unused")
    public static void testConstructWithoutCause() {
        new PropertyUnboundException("Message");
    }

    @SuppressWarnings("unused")
    public static void testConstructWithCause() {
        new PropertyUnboundException("Message", new IllegalArgumentException(
                "The root cause's message"));
    }

    // Printing Tests *********************************************************

    public static void testPrintWithoutCause() {
        Exception e = new PropertyUnboundException("Message");
        OutputStream out = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(out));
        e.printStackTrace(new PrintWriter(out));
    }

    public static void testPrintWithCause() {
        Exception e = new PropertyUnboundException("Message",
                new IllegalArgumentException("The root cause's message"));
        OutputStream out = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(out));
        e.printStackTrace(new PrintWriter(out));
    }


}
