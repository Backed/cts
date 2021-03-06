/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dot.junit.opcodes.invoke_direct_range;

import dot.junit.DxTestCase;
import dot.junit.DxUtil;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_12;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_13;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_16;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_2;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_21;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_6;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_7;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_8;
import dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_9;

public class Test_invoke_direct_range extends DxTestCase {

    /**
     * @title private method call
     */
    public void testN2() {
        T_invoke_direct_range_2 t = new T_invoke_direct_range_2();
        assertEquals(345, t.run());
    }


    /**
     * @title Check that new frame is created by invoke_direct_range
     */
    public void testN7() {
        T_invoke_direct_range_21 t = new T_invoke_direct_range_21();
        assertEquals(1, t.run());
    }



    /**
     * @title objref is null
     */
    public void testE3() {
        T_invoke_direct_range_8 t = new T_invoke_direct_range_8();
        try {
            assertEquals(5, t.run());
            fail("expected NullPointerException");
        } catch (NullPointerException e) {
            // expected
        }
    }

    /**
     * @title Native method can't be linked
     */
    public void testE5() {
        T_invoke_direct_range_9 t = new T_invoke_direct_range_9();
        try {
            assertEquals(5, t.run());
            fail("expected UnsatisfiedLinkError");
        } catch (UnsatisfiedLinkError e) {
            // expected
        }
    }

    /**
     * @constraint A14
     * @title invalid constant pool index
     */
    public void testVFE1() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_3");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint A15
     * @title invoke-direct may not be used to invoke &lt;clinit&gt;
     */
    public void testVFE3() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_4");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B4
     * @title invoke-direct target must be in self or superclass
     */
    public void testVFE4() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_6
        //@uses dot.junit.opcodes.invoke_direct_range.TSuper
        try {
            new T_invoke_direct_range_6();
            fail("expected NoSuchMethodError");
        } catch (NoSuchMethodError t) {
        }
    }

    /**
     * @constraint B1
     * @title number of arguments
     */
    public void testVFE5() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_5");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B1
     * @title int is passed instead of obj ref
     */
    public void testVFE6() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_10");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }


    /**
     * @constraint B9
     * @title number of arguments passed to method
     */
    public void testVFE8() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_14");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B9
     * @title types of arguments passed to method
     */
    public void testVFE9() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_24");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B10
     * @title assignment incompatible references when accessing protected method
     */
    public void testVFE10() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_25
        //@uses dot.junit.opcodes.invoke_direct_range.TPlain
        //@uses dot.junit.opcodes.invoke_direct_range.TSuper
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_25");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B5
     * @title  Superclass' method call
     */
    public void testVFE11() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_25
        //@uses dot.junit.opcodes.invoke_direct_range.TSuper
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_1");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint A23
     * @title number of registers
     */
    public void testVFE12() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_15");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }


    /**
     * @constraint n/a
     * @title Attempt to call undefined method.
     */
    public void testVFE13() {
        try {
            new T_invoke_direct_range_7().run();
            fail("expected NoSuchMethodError");
        } catch (NoSuchMethodError t) {
        }
    }

    /**
     * @constraint n/a
     * @title Method has different signature.
     */
    public void testVFE14() {
        try {
            new T_invoke_direct_range_16().run();
            fail("expected NoSuchMethodError");
        } catch (NoSuchMethodError t) {
        }
    }

    /**
     * @constraint n/a
     * @title Attempt to invoke static method. Java throws IncompatibleClassChangeError
     * on first access but Dalvik throws VerifyError on class loading.
     */
    public void testVFE15() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_11");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }


    /**
     * @constraint n/a
     * @title Attempt to invoke private method of superclass. Java throws IllegalAccessError
     * on first access but Dalvik throws VerifyError on class loading.
     */
    public void testVFE16() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_12
        //@uses dot.junit.opcodes.invoke_direct_range.TSuper
        try {
            new T_invoke_direct_range_12().run();
            fail("expected IllegalAccessError");
        } catch (IllegalAccessError t) {
        }
    }


    /**
     * @constraint n/a
     * @title Attempt to invoke abstract method
     */
    public void testVFE17() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_13
        //@uses dot.junit.opcodes.invoke_direct_range.TAbstract
        try {
            new T_invoke_direct_range_13().run();
            fail("expected NoSuchMethodError");
        } catch (NoSuchMethodError t) {
        }
    }

    /**
     * @constraint B5
     * @title An instance initializer must only be invoked on an uninitialized instance.
     */
    public void testVFE18() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_17");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B8
     * @title attempt to access inherited instance field before <init> is called
     */
    public void testVFE19() {
        //@uses dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_18
        //@uses dot.junit.opcodes.invoke_direct_range.TSuper
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_18");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint A14
     * @title attempt to invoke interface method
     */
    public void testVFE20() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_26");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint B6
     * @title instance methods may only be invoked on already initialized instances.
     */
    public void testVFE21() {
        try {
            Class.forName("dot.junit.opcodes.invoke_direct_range.d.T_invoke_direct_range_27");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }
}
