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

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.swt.browser.AuthenticationListener;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.browser.VisibilityWindowListener;
import org.eclipse.swt.widgets.Composite;

import de.carne.swt.browseradapter.spi.BrowserAdapterProvider;

class DefaultBrowserAdapter extends BrowserAdapter {

	private final Browser browser;

	DefaultBrowserAdapter(BrowserAdapterProvider provider, Browser browser) {
		super(provider);
		this.browser = browser;
	}

	@Override
	public String getBrowserType() {
		return this.browser.getBrowserType();
	}

	@Override
	public String getText() {
		return this.browser.getText();
	}

	@Override
	public boolean setText(String html) {
		return this.browser.setText(html);
	}

	@Override
	public boolean setText(String html, boolean trusted) {
		return this.browser.setText(html, trusted);
	}

	@Override
	public String getUrl() {
		return this.browser.getUrl();
	}

	@Override
	public boolean setUrl(String url) {
		return this.browser.setUrl(url);
	}

	@Override
	public boolean setUrl(String url, String postData, String[] headers) {
		return this.browser.setUrl(url, postData, headers);
	}

	@Override
	public void stop() {
		this.browser.stop();
	}

	@Override
	public void refresh() {
		this.browser.refresh();
	}

	@Override
	public boolean isBackEnabled() {
		return this.browser.isBackEnabled();
	}

	@Override
	public boolean back() {
		return this.browser.back();
	}

	@Override
	public boolean isForwardEnabled() {
		return this.browser.isForwardEnabled();
	}

	@Override
	public boolean forward() {
		return this.browser.forward();
	}

	@Override
	public void clearSessions() {
		Browser.clearSessions();
	}

	@Override
	@Nullable
	public String getCookie(String name, String url) {
		return Browser.getCookie(name, url);
	}

	@Override
	public boolean setCookie(String value, String url) {
		return Browser.setCookie(value, url);
	}

	@Override
	public boolean getJavascriptEnabled() {
		return this.browser.getJavascriptEnabled();
	}

	@Override
	public void setJavascriptEnabled(boolean enabled) {
		this.browser.setJavascriptEnabled(enabled);
	}

	@Override
	public boolean execute(String script) {
		return this.browser.execute(script);
	}

	@Override
	@Nullable
	public Object evaluate(String script) {
		return this.browser.evaluate(script);
	}

	@Override
	@Nullable
	public Object evaluate(String script, boolean trusted) {
		return this.browser.evaluate(script, trusted);
	}

	@Override
	public boolean close() {
		return this.browser.close();
	}

	@Override
	public void addAuthenticationListener(AuthenticationListener listener) {
		this.browser.addAuthenticationListener(listener);
	}

	@Override
	public void removeAuthenticationListener(AuthenticationListener listener) {
		this.browser.removeAuthenticationListener(listener);
	}

	@Override
	public void addCloseWindowListener(CloseWindowListener listener) {
		this.browser.addCloseWindowListener(listener);
	}

	@Override
	public void removeCloseWindowListener(CloseWindowListener listener) {
		this.browser.removeCloseWindowListener(listener);
	}

	@Override
	public void addLocationListener(LocationListener listener) {
		this.browser.addLocationListener(listener);
	}

	@Override
	public void removeLocationListener(LocationListener listener) {
		this.browser.removeLocationListener(listener);
	}

	@Override
	public void addOpenWindowListener(OpenWindowListener listener) {
		this.browser.addOpenWindowListener(listener);
	}

	@Override
	public void removeOpenWindowListener(OpenWindowListener listener) {
		this.browser.removeOpenWindowListener(listener);
	}

	@Override
	public void addProgressListener(ProgressListener listener) {
		this.browser.addProgressListener(listener);
	}

	@Override
	public void removeProgressListener(ProgressListener listener) {
		this.browser.removeProgressListener(listener);
	}

	@Override
	public void addStatusTextListener(StatusTextListener listener) {
		this.browser.addStatusTextListener(listener);
	}

	@Override
	public void removeStatusTextListener(StatusTextListener listener) {
		this.browser.removeStatusTextListener(listener);
	}

	@Override
	public void addTitleListener(TitleListener listener) {
		this.browser.addTitleListener(listener);
	}

	@Override
	public void removeTitleListener(TitleListener listener) {
		this.browser.removeTitleListener(listener);
	}

	@Override
	public void addVisibilityWindowListener(VisibilityWindowListener listener) {
		this.browser.addVisibilityWindowListener(listener);
	}

	@Override
	public void removeVisibilityWindowListener(VisibilityWindowListener listener) {
		this.browser.removeVisibilityWindowListener(listener);
	}

	@Override
	public Composite getBrowserWidget() {
		return this.browser;
	}

}
