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

import java.util.TimeZone;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * Entry point for all tests in Joda Time.
 * @version $Revision: -1 $ $Date: $
 * @author Stephen Colebourne
 */
public class TestAllPackages extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "org.goda.Goda";
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(org.goda.time.TestAll.suite());
    suite.addTest(org.goda.time.chrono.TestAll.suite());
    suite.addTest(org.goda.time.chrono.gj.TestAll.suite());
    suite.addTest(org.goda.time.convert.TestAll.suite());
    suite.addTest(org.goda.time.field.TestAll.suite());
    suite.addTest(org.goda.time.format.TestAll.suite());
    suite.addTest(org.goda.time.tz.TestAll.suite());
    return suite;
  }

  public static void main(String args[]) {
    // setup a time zone other than one tester is in
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));

    // run tests
    String[] testCaseName = {TestAllPackages.class.getName()};
    junit.textui.TestRunner.main(testCaseName);
  }

}
