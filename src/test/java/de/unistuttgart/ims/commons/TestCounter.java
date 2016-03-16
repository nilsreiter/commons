/*******************************************************************************
 * Copyright 2016 by Nils Reiter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
