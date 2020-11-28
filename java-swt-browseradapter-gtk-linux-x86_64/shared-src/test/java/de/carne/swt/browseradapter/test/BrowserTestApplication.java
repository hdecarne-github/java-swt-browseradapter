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

	private static final String TEST_TEXT1 = "<html><body>Test1</body></html>";
	private static final String TEST_TEXT2 = "<html><body>Test2</body></html>";
	private static final String TEST_URL = "https://www.google.com";
	private static final String TEST_COOKIE = "test=true;path=/";
	private static final String TEST_COOKIE_NAME = "test";

	@Override
	public void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		this.browserHolder.set(BrowserAdapter.getInstance(shell, SWT.NONE, args));
		shell.setLayout(new FillLayout());
		shell.open();

		assertBrowserProvider(args);
		assertBrowserType();
		assertBrowserWidget(shell);
		assertBrowserText();
		assertBrowserUrl();
		assertBrowserNavigation();
		assertBrowserCookies();
		assertBrowserJavascript();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private void assertBrowserProvider(String[] args) {
		@SuppressWarnings("null") Set<String> expectedProviders = new HashSet<>(Arrays.asList(args));
		String actualProvider = this.browserHolder.get().provider().name();

		Assertions.assertTrue(expectedProviders.contains(actualProvider), "Unepexted browser type: " + actualProvider);
	}

	private void assertBrowserWidget(Shell shell) {
		Assertions.assertEquals(shell, this.browserHolder.get().getBrowserWidget().getParent());
	}

	private void assertBrowserType() {
		Set<String> expectedTypes = new HashSet<>(Arrays.asList("webkit", "ie"));
		String actualType = this.browserHolder.get().getBrowserType();

		Assertions.assertTrue(expectedTypes.contains(actualType), "Unepexted browser type: " + actualType);
	}

	private void assertBrowserText() {
		BrowserAdapter browser = this.browserHolder.get();

		browser.setText(TEST_TEXT1);

		Assertions.assertEquals(TEST_TEXT1, browser.getText());

		browser.setText(TEST_TEXT2, true);

		Assertions.assertEquals(TEST_TEXT2, browser.getText());
	}

	private void assertBrowserUrl() {
		BrowserAdapter browser = this.browserHolder.get();

		browser.setUrl(TEST_URL);

		Assertions.assertEquals(TEST_URL, browser.getUrl());

		browser.setUrl(TEST_URL, "", new String[] {});

		Assertions.assertEquals(TEST_URL, browser.getUrl());
	}

	private void assertBrowserNavigation() {
		BrowserAdapter browser = this.browserHolder.get();

		Assertions.assertFalse(browser.isBackEnabled());
		Assertions.assertFalse(browser.back());
		Assertions.assertFalse(browser.isForwardEnabled());
		Assertions.assertFalse(browser.forward());
	}

	private void assertBrowserCookies() {
		BrowserAdapter browser = this.browserHolder.get();

		browser.setCookie(TEST_COOKIE, TEST_URL);

		Assertions.assertEquals(TEST_COOKIE, browser.getCookie(TEST_COOKIE_NAME, TEST_URL));
	}

	private void assertBrowserJavascript() {
		BrowserAdapter browser = this.browserHolder.get();

		Assertions.assertTrue(browser.getJavascriptEnabled());

		browser.setJavascriptEnabled(false);

		Assertions.assertFalse(browser.getJavascriptEnabled());

		browser.setJavascriptEnabled(true);

		Assertions.assertTrue(browser.getJavascriptEnabled());
	}

}
