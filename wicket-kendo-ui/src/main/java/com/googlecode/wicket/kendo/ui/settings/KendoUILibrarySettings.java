/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.kendo.ui.settings;

import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.settings.def.JavaScriptLibrarySettings;

import com.googlecode.wicket.kendo.ui.resource.KendoUIJavaScriptResourceReference;

/**
 * Default implementation of {@link IKendoUILibrarySettings}.<br/>
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class KendoUILibrarySettings extends JavaScriptLibrarySettings implements IKendoUILibrarySettings
{
	private static KendoUILibrarySettings instance = null;

	/**
	 * INTERNAL USE<br/>
	 * Gets the {@link KendoUILibrarySettings} instance
	 *
	 * @return the {@link KendoUILibrarySettings} instance
	 */
	public static synchronized KendoUILibrarySettings get()
	{
		if (KendoUILibrarySettings.instance == null)
		{
			KendoUILibrarySettings.instance = new KendoUILibrarySettings();
		}

		return KendoUILibrarySettings.instance;
	}

	private ResourceReference commonCssReference = null;
	private ResourceReference themeCssReference = null;

	/**
	 * Constructor
	 */
	public KendoUILibrarySettings()
	{
	}

	@Override
	public ResourceReference getKendoUIJavaScriptReference()
	{
		return KendoUIJavaScriptResourceReference.get();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return <tt>null</tt> by default
	 * @see #setKendoUICommonStyleSheetReference(ResourceReference)
	 */
	@Override
	public ResourceReference getKendoUICommonStyleSheetReference()
	{
		return this.commonCssReference;
	}

	/**
	 * Sets the Kendo UI common stylesheet resource reference
	 *
	 * @param reference the {@link ResourceReference}
	 */
	public void setKendoUICommonStyleSheetReference(ResourceReference reference)
	{
		this.commonCssReference = reference;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return <tt>null</tt> by default
	 * @see #setKendoUIThemeStyleSheetReference(ResourceReference)
	 */
	@Override
	public ResourceReference getKendoUIThemeStyleSheetReference()
	{
		return this.themeCssReference;
	}

	/**
	 * Sets the Kendo UI theme stylesheet resource reference
	 *
	 * @param reference the {@link ResourceReference}
	 */
	public void setKendoUIThemeStyleSheetReference(ResourceReference reference)
	{
		this.themeCssReference = reference;
	}
}
