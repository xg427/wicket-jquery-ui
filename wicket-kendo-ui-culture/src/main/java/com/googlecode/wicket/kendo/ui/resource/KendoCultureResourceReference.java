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
package com.googlecode.wicket.kendo.ui.resource;

import java.util.List;
import java.util.Locale;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import com.googlecode.wicket.kendo.ui.KendoCulture;
import com.googlecode.wicket.kendo.ui.settings.KendoUILibrarySettings;

/**
 * The resource reference for the Kendo Globalize javascript library.<br/>
 * <br/>
 * <b>Warning:</b> When (jQuery) globalize.js is registered before Kendo scripts, then Kendo will use globalize.js features instead of Kendo Globalization.
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class KendoCultureResourceReference extends JQueryPluginResourceReference
{
	private static final long serialVersionUID = 1L;

	public static final String FILENAME_PATTERN = "cultures/kendo.culture.%s.js";

	/**
	 * Constructor
	 *
	 * @param locale the {@link Locale}
	 */
	public KendoCultureResourceReference(Locale locale)
	{
		this(locale.toLanguageTag()); // java7
	}

	/**
	 * Constructor
	 *
	 * @param culture the {@link KendoCulture}
	 */
	public KendoCultureResourceReference(KendoCulture culture)
	{
		this(culture.toString());
	}

	/**
	 * Constructor
	 *
	 * @param culture the culture, ie: 'fr' or 'fr-FR'
	 */
	public KendoCultureResourceReference(String culture)
	{
		super(KendoCultureResourceReference.class, String.format(FILENAME_PATTERN, culture));
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		List<HeaderItem> dependencies = super.getDependencies();
		dependencies.add(JavaScriptHeaderItem.forReference(KendoUILibrarySettings.get().getJavaScriptReference()));

		return dependencies;
	}
}