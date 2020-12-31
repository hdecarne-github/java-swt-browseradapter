/*
 * Copyright (c) 2020-2021 Holger de Carne and contributors, All Rights Reserved.
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
package de.carne.swt.browseradapter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Supplier;

import org.eclipse.swt.widgets.Composite;

import de.carne.swt.browseradapter.spi.BrowserAdapterProvider;

/**
 * Browser adapter class providing access to a {@linkplain BrowserInstance} created via
 * {@linkplain BrowserAdapterProvider#getInstance(Composite, int)}.
 */
public abstract class BrowserAdapter implements BrowserInstance, Supplier<Composite> {

	private final BrowserAdapterProvider provider;

	/**
	 * Constructs new {@linkplain BrowserAdapter} instance.
	 *
	 * @param provider the creating {@linkplain BrowserAdapterProvider} instance.
	 */
	protected BrowserAdapter(BrowserAdapterProvider provider) {
		this.provider = provider;
	}

	/**
	 * Gets all loaded {@linkplain BrowserAdapterProvider} instances.
	 *
	 * @return all loaded {@linkplain BrowserAdapterProvider} instances.
	 */
	public static Iterable<BrowserAdapterProvider> providers() {
		return ServiceLoader.load(BrowserAdapterProvider.class);
	}

	/**
	 * Gets a new {@linkplain BrowserAdapter} instance for the given provider names.
	 *
	 * @param parent the parent {@linkplain Composite} to use.
	 * @param style the style to use.
	 * @param providerNames the provider names to consider in order of preference (highest preference first).
	 * @return the created {@linkplain BrowserAdapter} instance.
	 * @throws IllegalArgumentException if no matching provider is found.
	 * @see BrowserAdapterProvider#getInstance(Composite, int)
	 */
	public static BrowserAdapter getInstance(Composite parent, int style, String... providerNames) {
		BrowserAdapterProvider matchingProvider = null;
		int matchingProviderNameIndex = providerNames.length;
		Iterator<BrowserAdapterProvider> providers = providers().iterator();

		while (matchingProviderNameIndex > 0 && providers.hasNext()) {
			BrowserAdapterProvider provider = providers.next();

			for (int providerNameIndex = 0; providerNameIndex < matchingProviderNameIndex; providerNameIndex++) {
				if (provider.name().equals(providerNames[providerNameIndex]) && provider.isAvailable()) {
					matchingProvider = provider;
					matchingProviderNameIndex = providerNameIndex;
					break;
				}
			}
		}
		if (matchingProvider == null) {
			throw new IllegalArgumentException("No matching provider found for: " + Arrays.toString(providerNames));
		}
		return matchingProvider.getInstance(parent, style);
	}

	/**
	 * Gets the {@linkplain BrowserAdapterProvider} instance used to create this instance.
	 *
	 * @return the {@linkplain BrowserAdapterProvider} instance used to create this instance.
	 */
	public BrowserAdapterProvider provider() {
		return this.provider;
	}

	/**
	 * Gets the {@linkplain Composite} associated with this instance.
	 *
	 * @return the {@linkplain Composite} associated with this instance.
	 */
	public abstract Composite getBrowserWidget();

	@Override
	public Composite get() {
		return getBrowserWidget();
	}

}
