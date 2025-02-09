/*
 * Copyright (c) 2009-2014 JGoodies Software GmbH. All Rights Reserved.
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

package com.jgoodies.common.base;

import org.junit.Test;

/**
 * Tests the {@link Preconditions} class.
 *
 * @author  Karsten Lentzsch
 */
@SuppressWarnings("static-method")
public final class PreconditionsTest {

    @Test
    public void checkValidArgument() {
        int count = 1;
        Preconditions.checkArgument(count > 0, "a message");
    }


    @Test(expected=IllegalArgumentException.class)
    public void checkInvalidArgument() {
        int count = 0;
        Preconditions.checkArgument(count > 0, "a message");
    }


    @Test
    public void checkNonNull() {
        Preconditions.checkNotNull("Hello", "a message");
    }


    @Test(expected=NullPointerException.class)
    public void checkNull() {
        Preconditions.checkNotNull(null, "a message");
    }


    @Test
    public void checkValidState() {
        boolean locked = true;
        Preconditions.checkArgument(locked, "a message");
    }


    @Test(expected=IllegalStateException.class)
    public void checkInvalidState() {
        boolean locked = false;
        Preconditions.checkState(locked, "a message");
    }


}
