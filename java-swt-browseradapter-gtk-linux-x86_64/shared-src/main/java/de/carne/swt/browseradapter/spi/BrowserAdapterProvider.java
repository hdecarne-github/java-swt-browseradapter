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
package de.carne.swt.browseradapter.spi;

import org.eclipse.swt.widgets.Composite;

import de.carne.swt.browseradapter.BrowserAdapter;

/**
 * {@linkplain BrowserAdapter} service provider interface.
 */
public interface BrowserAdapterProvider {

	/**
	 * Gets this provider's name.
	 *
	 * @return this provider's name.
	 */
	String name();

	/**
	 * Determines whether this provider's {@linkplain BrowserAdapter} implementation is available in the current
	 * runtime.
	 *
	 * @return {@code true}, if this provider's {@linkplain BrowserAdapter} implementation is available in the current
	 * runtime.
	 */
	boolean isAvailable();

	/**
	 * Gets a new {@linkplain BrowserAdapter} instance.
	 *
	 * @param parent the parent {@linkplain Composite} to use.
	 * @param style the style to use.
	 * @return the created {@linkplain BrowserAdapter} instance.
	 * @throws IllegalStateException if this provider's {@linkplain BrowserAdapter} implementation is not available in
	 * the current runtime.
	 * @see #isAvailable()
	 */
	BrowserAdapter getInstance(Composite parent, int style);

}
