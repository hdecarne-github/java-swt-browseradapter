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
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.browser.VisibilityWindowListener;

/**
 * Browser interface.
 */
public interface BrowserInstance {

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#getBrowserType()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#getBrowserType()}
	 */
	String getBrowserType();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#getText()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#getText()}
	 */
	String getText();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setText(String)}}
	 *
	 * @param html see {@linkplain org.eclipse.swt.browser.Browser#setText(String)}}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#setText(String)}}
	 */
	boolean setText(String html);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setText(String, boolean)}
	 *
	 * @param html see {@linkplain org.eclipse.swt.browser.Browser#setText(String, boolean)}
	 * @param trusted see {@linkplain org.eclipse.swt.browser.Browser#setText(String, boolean)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#setText(String, boolean)}
	 */
	boolean setText(String html, boolean trusted);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#getUrl()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#getUrl()}
	 */
	String getUrl();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setUrl(String)}
	 *
	 * @param url see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String)}
	 */
	boolean setUrl(String url);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setUrl(String, String, String[])}
	 *
	 * @param url see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String, String, String[])}
	 * @param postData see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String, String, String[])}
	 * @param headers see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String, String, String[])}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#setUrl(String, String, String[])}
	 */
	boolean setUrl(String url, String postData, String[] headers);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#stop()}
	 */
	void stop();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#refresh()}
	 */
	void refresh();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#isBackEnabled()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#isBackEnabled()}
	 */
	boolean isBackEnabled();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#back()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#back()}
	 */
	boolean back();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#isForwardEnabled()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#isForwardEnabled()}
	 */
	boolean isForwardEnabled();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#forward()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#forward()}
	 */
	boolean forward();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#clearSessions()}
	 */
	void clearSessions();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#getCookie(String, String)}
	 *
	 * @param name see {@linkplain org.eclipse.swt.browser.Browser#getCookie(String, String)}
	 * @param url see {@linkplain org.eclipse.swt.browser.Browser#getCookie(String, String)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#getCookie(String, String)}
	 */
	@Nullable
	String getCookie(String name, String url);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setCookie(String, String)}
	 *
	 * @param value see {@linkplain org.eclipse.swt.browser.Browser#setCookie(String, String)}
	 * @param url see {@linkplain org.eclipse.swt.browser.Browser#setCookie(String, String)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#setCookie(String, String)}
	 */
	boolean setCookie(String value, String url);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#getJavascriptEnabled()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#getJavascriptEnabled()}
	 */
	boolean getJavascriptEnabled();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#setJavascriptEnabled(boolean)}
	 *
	 * @param enabled see {@linkplain org.eclipse.swt.browser.Browser#setJavascriptEnabled(boolean)}
	 */
	void setJavascriptEnabled(boolean enabled);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#execute(String)}
	 *
	 * @param script see {@linkplain org.eclipse.swt.browser.Browser#execute(String)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#execute(String)}
	 */
	boolean execute(String script);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#evaluate(String)}
	 *
	 * @param script see {@linkplain org.eclipse.swt.browser.Browser#evaluate(String)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#evaluate(String)}
	 */
	@Nullable
	Object evaluate(String script);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#evaluate(String, boolean)}
	 *
	 * @param script see {@linkplain org.eclipse.swt.browser.Browser#evaluate(String, boolean)}
	 * @param trusted see {@linkplain org.eclipse.swt.browser.Browser#evaluate(String, boolean)}
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#evaluate(String, boolean)}
	 */
	@Nullable
	Object evaluate(String script, boolean trusted);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#close()}
	 *
	 * @return see {@linkplain org.eclipse.swt.browser.Browser#close()}
	 */
	boolean close();

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addAuthenticationListener(AuthenticationListener)}
	 *
	 * @param listener see
	 * {@linkplain org.eclipse.swt.browser.Browser#addAuthenticationListener(AuthenticationListener)}
	 */
	void addAuthenticationListener(AuthenticationListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeAuthenticationListener(AuthenticationListener)}
	 *
	 * @param listener see
	 * {@linkplain org.eclipse.swt.browser.Browser#removeAuthenticationListener(AuthenticationListener)}
	 */
	void removeAuthenticationListener(AuthenticationListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addCloseWindowListener(CloseWindowListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addCloseWindowListener(CloseWindowListener)}
	 */
	void addCloseWindowListener(CloseWindowListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeCloseWindowListener(CloseWindowListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeCloseWindowListener(CloseWindowListener)}
	 */
	void removeCloseWindowListener(CloseWindowListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addLocationListener(LocationListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addLocationListener(LocationListener)}
	 */
	void addLocationListener(LocationListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeLocationListener(LocationListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeLocationListener(LocationListener)}
	 */
	void removeLocationListener(LocationListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addOpenWindowListener(OpenWindowListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addOpenWindowListener(OpenWindowListener)}
	 */
	void addOpenWindowListener(OpenWindowListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeOpenWindowListener(OpenWindowListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeOpenWindowListener(OpenWindowListener)}
	 */
	void removeOpenWindowListener(OpenWindowListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addProgressListener(ProgressListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addProgressListener(ProgressListener)}
	 */
	void addProgressListener(ProgressListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeProgressListener(ProgressListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeProgressListener(ProgressListener)}
	 */
	void removeProgressListener(ProgressListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addStatusTextListener(StatusTextListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addStatusTextListener(StatusTextListener)}
	 */
	void addStatusTextListener(StatusTextListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeStatusTextListener(StatusTextListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeStatusTextListener(StatusTextListener)}
	 */
	void removeStatusTextListener(StatusTextListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addTitleListener(TitleListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#addTitleListener(TitleListener)}
	 */
	void addTitleListener(TitleListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeTitleListener(TitleListener)}
	 *
	 * @param listener see {@linkplain org.eclipse.swt.browser.Browser#removeTitleListener(TitleListener)}
	 */
	void removeTitleListener(TitleListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#addVisibilityWindowListener(VisibilityWindowListener)}
	 *
	 * @param listener see
	 * {@linkplain org.eclipse.swt.browser.Browser#addVisibilityWindowListener(VisibilityWindowListener)}
	 */
	void addVisibilityWindowListener(VisibilityWindowListener listener);

	/**
	 * See {@linkplain org.eclipse.swt.browser.Browser#removeVisibilityWindowListener(VisibilityWindowListener)}
	 *
	 * @param listener see
	 * {@linkplain org.eclipse.swt.browser.Browser#removeVisibilityWindowListener(VisibilityWindowListener)}
	 */
	void removeVisibilityWindowListener(VisibilityWindowListener listener);

}
