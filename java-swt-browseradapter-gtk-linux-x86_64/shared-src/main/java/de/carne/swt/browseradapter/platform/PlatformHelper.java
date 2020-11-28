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
package de.carne.swt.browseradapter.platform;

import org.eclipse.swt.SWT;

import de.carne.util.Exceptions;
import de.carne.util.Lazy;

/**
 * Utility class providing platform specific functions.
 */
public abstract class PlatformHelper {

	private static final Lazy<PlatformHelper> INSTANCE_HOLDER = new Lazy<>(PlatformHelper::getInstance);

	private static PlatformHelper getInstance() {
		PlatformHelper instance;

		try {
			String platform = SWT.getPlatform();
			String platformName = PlatformHelper.class.getPackage().getName() + "." + platform + "."
					+ platform.substring(0, 1).toUpperCase() + platform.substring(1)
					+ PlatformHelper.class.getSimpleName();

			instance = Class.forName(platformName).asSubclass(PlatformHelper.class).getConstructor().newInstance();
		} catch (ReflectiveOperationException e) {
			throw Exceptions.toRuntime(e);
		}
		return instance;
	}

	/**
	 * Constructs a new {@linkplain PlatformHelper} instance.
	 */
	protected PlatformHelper() {
		// Nothing to do here
	}

	/**
	 * Checks whether the WebKit browser backend is available.
	 *
	 * @return {@code true} if the WebKit browser backend is available.
	 */
	public static boolean isWebKitAvailable() {
		return INSTANCE_HOLDER.get().internalIsWebKitAvailable();
	}

	/**
	 * Checks whether the WebKit browser backend is available.
	 *
	 * @return {@code true} if the WebKit browser backend is available.
	 */
	protected boolean internalIsWebKitAvailable() {
		return false;
	}

	/**
	 * Checks whether the Chromium browser backend is available.
	 *
	 * @return {@code true} if the Chromium browser backend is available.
	 */
	public static boolean isChromiumAvailable() {
		return INSTANCE_HOLDER.get().internalIsChromiumAvailable();
	}

	/**
	 * Checks whether the Chromium browser backend is available.
	 *
	 * @return {@code true} if the Chromium browser backend is available.
	 */
	protected boolean internalIsChromiumAvailable() {
		boolean isAvailable = false;

		try {
			Class.forName("org.eclipse.swt.browser.ChromiumImpl");
			isAvailable = true;
		} catch (Exception e) {
			Exceptions.ignore(e);
		}
		return isAvailable;
	}

}
