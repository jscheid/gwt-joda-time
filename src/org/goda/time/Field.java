package org.goda.time;

/**
 *
 * @author joneg01
 */
public abstract class Field {

    /**
     * Get the name of the field.
     * <p>
     * By convention, names are plural.
     *
     * @return field name
     */
    public abstract String getName();

    /**
     * Returns true if this field is supported.
     *
     * @return true if this field is supported
     */
    public abstract boolean isSupported();

    /**
     * Computes the difference between two instants, as measured in the units
     * of this field. Any fractional units are dropped from the result. Calling
     * getDifference reverses the effect of calling add. In the following code:
     *
     * <pre>
     * long instant = ...
     * int v = ...
     * int age = getDifference(add(instant, v), instant);
     * </pre>
     *
     * The value 'age' is the same as the value 'v'.
     *
     * @param minuendInstant the milliseconds from 1970-01-01T00:00:00Z to
     * subtract from
     * @param subtrahendInstant the milliseconds from 1970-01-01T00:00:00Z to
     * subtract off the minuend
     * @return the difference in the units of this field
     */
    public abstract int getDifference(long minuendInstant, long subtrahendInstant);

    /**
     * Computes the difference between two instants, as measured in the units
     * of this field. Any fractional units are dropped from the result. Calling
     * getDifference reverses the effect of calling add. In the following code:
     *
     * <pre>
     * long instant = ...
     * long v = ...
     * long age = getDifferenceAsLong(add(instant, v), instant);
     * </pre>
     *
     * The value 'age' is the same as the value 'v'.
     *
     * @param minuendInstant the milliseconds from 1970-01-01T00:00:00Z to
     * subtract from
     * @param subtrahendInstant the milliseconds from 1970-01-01T00:00:00Z to
     * subtract off the minuend
     * @return the difference in the units of this field
     */
    public abstract long getDifferenceAsLong(long minuendInstant, long subtrahendInstant);

    /**
     * Adds a value (which may be negative) to the instant.
     *
     * @param instant the milliseconds from 1970-01-01T00:00:00Z to add to
     * @param value the value to add, in the units of the field
     * @return the updated milliseconds
     */
    public abstract long add(long instant, int value);

    /**
     * Adds a value (which may be negative) to the instant.
     *
     * @param instant the milliseconds from 1970-01-01T00:00:00Z to add to
     * @param value the value to add, in the units of the field
     * @return the updated milliseconds
     */
    public abstract long add(long instant, long value);

    /**
     * Get a suitable debug string.
     *
     * @return debug string
     */
    public abstract String toString();

}
