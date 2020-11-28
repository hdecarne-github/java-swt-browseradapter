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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.jupiter.api.Assertions;

import de.carne.swt.browseradapter.BrowserAdapter;
import de.carne.test.swt.tester.MainFunction;
import de.carne.util.Late;

class BrowserTestApplication implements MainFunction {

	private final Late<BrowserAdapter> browserHolder = new Late<>();

	@Override
	public void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		BrowserAdapter browser = this.browserHolder.set(BrowserAdapter.getInstance(shell, SWT.NONE, args));

		assertBrowserType();

		shell.setLayout(new FillLayout());
		shell.open();
		browser.setUrl("https://www.google.com");
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private void assertBrowserType() {
		Set<String> expectedBrowserTypes = new HashSet<>(Arrays.asList("webkit", "ie"));
		String actualBrowserType = this.browserHolder.get().getBrowserType();

		Assertions.assertTrue(expectedBrowserTypes.contains(actualBrowserType),
				"Unepexted browser type: " + actualBrowserType);
	}

}
