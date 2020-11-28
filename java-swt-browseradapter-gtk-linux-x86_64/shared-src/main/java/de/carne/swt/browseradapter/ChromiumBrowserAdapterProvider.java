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
package de.carne.swt.browseradapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.carne.swt.browseradapter.platform.PlatformHelper;
import de.carne.swt.browseradapter.spi.BrowserAdapterProvider;

/**
 * {@linkplain BrowserAdapterProvider} implementation providing access to the Chromium browser backend
 * ({@linkplain org.eclipse.swt.SWT#CHROMIUM}).
 * <p>
 * To be available this adapter requires the necessary
 * <a href="https://www.eclipse.org/swt/faq.php#howusechromium">Chromium libraries</a> to be installed.
 * </p>
 */
public class ChromiumBrowserAdapterProvider implements BrowserAdapterProvider {

	/**
	 * Chromium browser backend name.
	 */
	@SuppressWarnings("java:S1845")
	public static final String NAME = "Chromium";

	@Override
	public String name() {
		return NAME;
	}

	/**
	 * Determines whether the necessary prerequisites for using Chromium browser backend are met by the current runtime.
	 *
	 * @return {@code true}, if the Chromium based {@linkplain BrowserAdapter} implementation is available in the
	 * current runtime.
	 */
	public static boolean isChromiumAvailable() {
		return PlatformHelper.isChromiumAvailable();
	}

	@Override
	public boolean isAvailable() {
		return isChromiumAvailable();
	}

	@Override
	public BrowserAdapter getInstance(Composite parent, int style) {
		return new DefaultBrowserAdapter(this, new Browser(parent, style | SWT.CHROMIUM));
	}

}
