/*
 *  Copyright 2001-2005 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.time;

import org.goda.time.Chronology;
import org.goda.time.DateTimeField;
import org.goda.time.DateTimeZone;
import org.goda.time.chrono.BaseChronology;
import org.goda.time.chrono.ISOChronology;

/**
 * Mock class for unit testing.
 * 
 * @author Stephen Colebourne
 */
class MockNullZoneChronology extends BaseChronology {

    public DateTimeZone getZone() {
        return null;
    }
    public Chronology withUTC() {
        return this;
    }
    public Chronology withZone(DateTimeZone zone) {
        return this;
    }
    public DateTimeField dayOfMonth() {  // for DateMidnight test
        return ISOChronology.getInstance().dayOfMonth();
    }
    public String toString() {
        return "";
    }

}
