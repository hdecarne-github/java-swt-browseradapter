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
package de.carne.swt.browseradapter.test;

import org.junit.jupiter.api.Assertions;

import de.carne.test.swt.tester.SWTTest;
import de.carne.test.swt.tester.accessor.ShellAccessor;

/**
 * Abstract base class for all kinds of browser tests.
 */
abstract class BrowserTest extends SWTTest {

	protected void testBrowser(String... args) {
		Script script = script(new BrowserTestApplication());

		script.add(this::doWaitShellClosable, this::doCloseShell);
		script.args(args);
		script.execute();

		Assertions.assertTrue(script.passed());
	}

	private ShellAccessor doWaitShellClosable() {
		traceAction();

		return accessShell(BrowserTestApplication.TITLE_COMPLETED);
	}

	private void doCloseShell(ShellAccessor shell) {
		traceAction();

		shell.close();
	}

}
