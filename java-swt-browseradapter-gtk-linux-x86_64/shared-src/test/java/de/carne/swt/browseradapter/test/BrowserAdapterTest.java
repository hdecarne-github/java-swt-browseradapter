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

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.carne.swt.browseradapter.BrowserAdapter;
import de.carne.test.swt.DisableIfThreadNotSWTCapable;

/**
 * Test {@linkplain BrowserAdapter} class.
 */
@DisableIfThreadNotSWTCapable
class BrowserAdapterTest {

	@Test
	void testUnknownProvder() {
		Display display = new Display();
		Shell shell = new Shell(display);

		Assertions.assertThrows(SWTException.class, () -> {
			BrowserAdapter.getInstance(shell, SWT.NONE, "unknown");
		});
		shell.close();
		display.dispose();
	}

}
