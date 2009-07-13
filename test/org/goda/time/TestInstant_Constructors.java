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

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestSuite;

import org.goda.time.chrono.ISOChronology;
import org.goda.time.convert.ConverterManager;
import org.goda.time.convert.MockZeroNullIntegerConverter;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * This class is a Junit unit test for Instant.
 * @author Stephen Colebourne
 */
public class TestInstant_Constructors extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "org.goda.Goda";
  }

  private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
  private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  // 1970-06-09
  private long TEST_TIME_NOW = (31L + 28L + 31L + 30L + 31L + 9L - 1L) * DateTimeConstants.MILLIS_PER_DAY;

  // 1970-04-05
  private long TEST_TIME1 = (31L + 28L + 31L + 6L - 1L) * DateTimeConstants.MILLIS_PER_DAY + 12L * DateTimeConstants.MILLIS_PER_HOUR + 24L
      * DateTimeConstants.MILLIS_PER_MINUTE;

  // 1971-05-06
  private long TEST_TIME2 = (365L + 31L + 28L + 31L + 30L + 7L - 1L) * DateTimeConstants.MILLIS_PER_DAY + 14L
      * DateTimeConstants.MILLIS_PER_HOUR + 28L * DateTimeConstants.MILLIS_PER_MINUTE;

  private DateTimeZone zone = null;
  private Locale locale = null;

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }

  public static TestSuite suite() {
    return new TestSuite(TestInstant_Constructors.class);
  }

  @Override
  protected void gwtSetUp() throws Exception {
    DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
    zone = DateTimeZone.getDefault();
    locale = Locale.getDefault();
    DateTimeZone.setDefault(LONDON);
    TimeZone tz = TimeZone.getTimeZone(LONDON.getID());
    java.util.TimeZone.setDefault(tz);
    Locale.setDefault(Locale.UK);
  }

  @Override
  protected void gwtTearDown() throws Exception {
    DateTimeUtils.setCurrentMillisSystem();
    DateTimeZone.setDefault(zone);
    TimeZone tz = TimeZone.getTimeZone(LONDON.getID());
    java.util.TimeZone.setDefault(tz);
    Locale.setDefault(locale);
    zone = null;
  }

  //-----------------------------------------------------------------------
  /**
   * Test constructor ()
   */
  public void testConstructor() throws Throwable {
    Instant test = new Instant();
    assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
    assertEquals(TEST_TIME_NOW, test.getMillis());
  }

  //-----------------------------------------------------------------------
  /**
   * Test constructor (long)
   */
  public void testConstructor_long1() throws Throwable {
    Instant test = new Instant(TEST_TIME1);
    assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
    assertEquals(TEST_TIME1, test.getMillis());
  }

  /**
   * Test constructor (long)
   */
  public void testConstructor_long2() throws Throwable {
    Instant test = new Instant(TEST_TIME2);
    assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
    assertEquals(TEST_TIME2, test.getMillis());
  }

  //-----------------------------------------------------------------------
  /**
   * Test constructor (Object)
   */
  public void testConstructor_Object() throws Throwable {
    Date date = new Date(TEST_TIME1);
    Instant test = new Instant(date);
    assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
    assertEquals(TEST_TIME1, test.getMillis());
  }

  /**
   * Test constructor (Object)
   */
  public void testConstructor_invalidObject() throws Throwable {
    try {
      new Instant(new Object());
      fail();
    } catch (IllegalArgumentException ex) {
    }
  }

  /**
   * Test constructor (Object=null)
   */
  public void testConstructor_nullObject() throws Throwable {
    Instant test = new Instant((Object) null);
    assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
    assertEquals(TEST_TIME_NOW, test.getMillis());
  }

  /**
   * Test constructor (Object=null)
   */
  public void testConstructor_badconverterObject() throws Throwable {
    try {
      ConverterManager.getInstance().addInstantConverter(MockZeroNullIntegerConverter.INSTANCE);
      Instant test = new Instant(new Integer(0));
      assertEquals(ISOChronology.getInstanceUTC(), test.getChronology());
      assertEquals(0L, test.getMillis());
    } finally {
      ConverterManager.getInstance().removeInstantConverter(MockZeroNullIntegerConverter.INSTANCE);
    }
  }

}
