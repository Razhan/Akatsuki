package com.sora.util.akatsuki;

import android.os.Bundle;

/**
 * For types not supported by Akatsuki, you can implement this interface and
 * either register it globally by annotating it with {@link TypeConverter} or
 * specify the converter directly using {@link With#value()}
 * 
 * @param <T>
 *            the target type
 */
public interface TypeConverter<T> {

	/**
	 * Saves the given type
	 * 
	 * @param bundle
	 *            the bundle to save to
	 * @param t
	 *            the instance
	 * @param key
	 *            a generated key; this key is guaranteed not to collide with
	 *            any other fields
	 */
	void save(Bundle bundle, T t, String key);

	/**
	 * Restores the given type
	 * 
	 * @param bundle
	 *            the bundle holding the saved instance
	 * @param initializer
	 *            the initializer value(possibly null)
	 * @param key
	 *            the exact key provided in
	 *            {@link #save(Bundle, Object, String)}
	 * @return the restored instance
	 */
	T restore(Bundle bundle, T initializer, String key);

	/**
	 * Annotation default for {@link With#value()}, this is not the class you
	 * are looking for
	 */
	final class DummyTypeConverter implements TypeConverter<Void> {

		@Override
		public void save(Bundle bundle, Void ignored, String key) {
			throw new RuntimeException("DummyTypeConverter should not be used directly");
		}

		@Override
		public Void restore(Bundle bundle, Void ignored, String key) {
			throw new RuntimeException("DummyTypeConverter should not be used directly");
		}

	}
}
