/*
 * Copyright 2001-2005 Stephen Colebourne Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.goda.time;

import junit.framework.TestSuite;

import org.goda.time.chrono.ISOChronology;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * This class is a Junit unit test for DurationField.
 * @author Stephen Colebourne
 */
public class TestDurationField extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "org.goda.Goda";
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }

  public static TestSuite suite() {
    return new TestSuite(TestDurationField.class);
  }

  @Override
  protected void gwtSetUp() throws Exception {
  }

  @Override
  protected void gwtTearDown() throws Exception {
  }

  //-----------------------------------------------------------------------
  public void test_subtract() throws Exception {
    DurationField fld = ISOChronology.getInstanceUTC().millis();
    assertEquals(900, fld.subtract(1000L, 100));
    assertEquals(900L, fld.subtract(1000L, 100L));
    assertEquals((1000L - Integer.MAX_VALUE), fld.subtract(1000L, Integer.MAX_VALUE));
    assertEquals((1000L - Integer.MIN_VALUE), fld.subtract(1000L, Integer.MIN_VALUE));
    assertEquals((1000L - Long.MAX_VALUE), fld.subtract(1000L, Long.MAX_VALUE));
    try {
      fld.subtract(-1000L, Long.MIN_VALUE);
      fail();
    } catch (ArithmeticException ex) {
    }
  }

}
