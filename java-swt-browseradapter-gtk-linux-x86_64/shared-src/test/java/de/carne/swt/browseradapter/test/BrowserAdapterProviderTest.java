/*
 * Copyright (c) 2020 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.swt.browseradapter.test;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.carne.swt.browseradapter.BrowserAdapter;
import de.carne.swt.browseradapter.ChromiumBrowserAdapterProvider;
import de.carne.swt.browseradapter.PlatformBrowserAdapterProvider;
import de.carne.swt.browseradapter.WebKitBrowserAdapterProvider;
import de.carne.swt.browseradapter.spi.BrowserAdapterProvider;

/**
 * Test {@linkplain BrowserAdapterProvider} class.
 */
class BrowserAdapterProviderTest {

	@Test
	void testProviders() {
		Iterator<BrowserAdapterProvider> providers = BrowserAdapter.providers().iterator();

		Assertions.assertTrue(providers.hasNext());

		testProvider(providers.next());

		Assertions.assertTrue(providers.hasNext());

		testProvider(providers.next());

		Assertions.assertTrue(providers.hasNext());

		testProvider(providers.next());

		Assertions.assertFalse(providers.hasNext());
	}

	private void testProvider(BrowserAdapterProvider provider) {
		String providerName = provider.name();

		if (PlatformBrowserAdapterProvider.NAME.equals(providerName)) {
			Assertions.assertTrue(provider.isAvailable());
		} else if (WebKitBrowserAdapterProvider.NAME.equals(providerName)) {
			Assertions.assertEquals(WebKitBrowserAdapterProvider.isWebKitAvailable(), provider.isAvailable());
		} else if (ChromiumBrowserAdapterProvider.NAME.equals(providerName)) {
			Assertions.assertEquals(ChromiumBrowserAdapterProvider.isChromiumAvailable(), provider.isAvailable());
		} else {
			Assertions.fail("Unexpected browser backend: " + providerName);
		}
	}

}
