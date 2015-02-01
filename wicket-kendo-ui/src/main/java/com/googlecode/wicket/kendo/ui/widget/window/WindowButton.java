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
package com.googlecode.wicket.kendo.ui.widget.window;

import org.apache.wicket.markup.html.form.IFormSubmittingComponent;
import org.apache.wicket.util.io.IClusterable;

import com.googlecode.wicket.kendo.ui.KendoIcon;

/**
 * Provides the button object that can be used in {@link MessageWindow}
 *
 * @author Sebastien Briquet - sebfz1
 */
public class WindowButton implements IClusterable
{
	private static final long serialVersionUID = 1L;

	/** default icon */
	private static final String ICON = KendoIcon.NONE;

	/**
	 * Helper that creates a new {@link WindowButton}
	 * 
	 * @param text the button's text
	 * @param formProcessing whether the form will be validated and updated
	 * @return a new {@link WindowButton}
	 */
	public static WindowButton of(String text, boolean formProcessing)
	{
		return WindowButton.of(text, ICON, formProcessing);
	}

	/**
	 * Helper that creates a new {@link WindowButton}
	 * 
	 * @param text the button's text
	 * @param icon the button's icon
	 * @param formProcessing whether the form will be validated and updated
	 * @return a new {@link WindowButton}
	 */
	public static WindowButton of(String text, String icon, boolean formProcessing)
	{
		WindowButton button = new WindowButton(text, icon);

		return button.setDefaultFormProcessing(formProcessing);
	}

	private final String text;
	private String icon;
	private boolean enabled;
	private boolean visible = true;
	private boolean formProcessing = true;

	/**
	 * Constructor
	 *
	 * @param text the button's text
	 */
	public WindowButton(String text)
	{
		this(text, ICON, true);
	}

	/**
	 * Constructor
	 *
	 * @param text the button's text
	 * @param icon the button's icon
	 */
	public WindowButton(String text, String icon)
	{
		this(text, icon, true);
	}

	/**
	 * Constructor
	 *
	 * @param text the button's text
	 * @param enabled indicates whether the button is enabled
	 */
	public WindowButton(String text, boolean enabled)
	{
		this(text, ICON, enabled);
	}

	/**
	 * Constructor
	 *
	 * @param text the button's text
	 * @param icon the button's icon
	 * @param enabled indicates whether the button is enabled
	 */
	public WindowButton(String text, String icon, boolean enabled)
	{
		this.text = text;
		this.icon = icon;
		this.enabled = enabled;
	}

	// Properties //

	/**
	 * Gets the button's icon
	 *
	 * @return the button's icon
	 */
	public String getIcon()
	{
		return this.icon;
	}

	/**
	 * Sets the button's icon
	 *
	 * @param icon the css class (ie: k-i-<i>icon</i>)
	 */
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	/**
	 * Gets the button's text
	 * 
	 * @return the button's text
	 */
	public String getText()
	{
		return this.text;
	}

	/**
	 * Indicates whether the button is enabled
	 *
	 * @return true or false
	 */
	public boolean isEnabled()
	{
		return this.enabled;
	}

	// TODO: setEnabled(boolean enabled, AjaxRequestTarget target)

	/**
	 * Indicates whether the button is visible
	 *
	 * @return true or false
	 */
	public boolean isVisible()
	{
		return this.visible;
	}

	// TODO: #setVisible(boolean visible, AjaxRequestTarget target)

	/**
	 * Indicates whether the form will be validated and updated.
	 * 
	 * @return true by default
	 * @see IFormSubmittingComponent#getDefaultFormProcessing()
	 */
	public boolean getDefaultFormProcessing()
	{
		return this.formProcessing;
	}

	/**
	 * Set the default form processing
	 * 
	 * @param processing true or false
	 * @return this, for chaining
	 */
	public WindowButton setDefaultFormProcessing(boolean processing)
	{
		this.formProcessing = processing;

		return this;
	}

	// Methods //

	/**
	 * Indicates whether this {@link WindowButton} is equal to another {@link WindowButton}.<br/>
	 * Are considered equals buttons having the same text representation, which is the text supplied to the constructor (if {@link #toString()} is not overridden).
	 *
	 * @param object the {@link WindowButton} to compare to
	 * @return true if considered as equal
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object instanceof WindowButton)
		{
			return this.match(object.toString());
		}

		return super.equals(object);
	}
	
	@Override
	public int hashCode()
	{
		return this.toString().hashCode();
	}

	/**
	 * Indicates whether this {@link WindowButton} text representation ({@link #toString()}) match to the supplied text.
	 *
	 * @param text the text to compare to
	 * @return true if equal
	 */
	public boolean match(String text)
	{
		return text.equals(this.toString()); // let throw a NPE
	}

	@Override
	public String toString()
	{
		return this.text;
	}
}