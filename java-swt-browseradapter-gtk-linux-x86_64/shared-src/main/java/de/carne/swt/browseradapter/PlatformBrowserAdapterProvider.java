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

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.carne.swt.browseradapter.spi.BrowserAdapterProvider;

/**
 * {@linkplain BrowserAdapterProvider} implementation providing access to the platform's standard browser.
 * <p>
 * This encapsulates the standard SWT Browser widget's functionality.
 * </p>
 */
public class PlatformBrowserAdapterProvider implements BrowserAdapterProvider {

	/**
	 * Platform browser backend name.
	 */
	@SuppressWarnings("java:S1845")
	public static final String NAME = "Platform";

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public BrowserAdapter getInstance(Composite parent, int style) {
		return new DefaultBrowserAdapter(this, new Browser(parent, style));
	}

}
