package de.unistuttgart.ims.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCounter {

	@Test
	public void testString() {
		final Counter<String> cs = new Counter<String>();
		cs.add("a");
		cs.add("a");
		cs.add("b");
		cs.add("a");
		cs.add("a");
		assertEquals(4, (int) cs.get("a"));
		assertEquals(1, (int) cs.get("b"));
		cs.add("a");
		assertEquals(5, (int) cs.get("a"));
		assertEquals(1, (int) cs.get("b"));
		cs.subtract("a");
		cs.subtract("a");
		assertEquals(3, (int) cs.get("a"));
		assertEquals(1, (int) cs.get("b"));
		cs.subtract("b");
		assertEquals(0, (int) cs.get("b"));
		cs.subtract("b");
		assertEquals(-1, (int) cs.get("b"));

		assertEquals(3, (int) cs.getMax().getFirst());
		assertEquals("a", cs.getMax().getSecond().iterator().next());
	}
}
