/*
 * Copyright (C) 2017 Marc Magon
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

package com.jwebmp.examples.payaramicro;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import fish.payara.micro.PayaraMicro;
import fish.payara.micro.PayaraMicroRuntime;
import fish.payara.micro.data.InstanceDescriptor;

import java.util.logging.Level;

public class HelloWorld
		extends Page
{
	public HelloWorld()
	{
		super("Hello World!");
		add(new Paragraph("Hello World"));
	}

	public static void main(String[] args)
	{
		try
		{
			LogFactory.configureConsoleColourOutput(Level.FINE);

			PayaraMicroRuntime runtime = PayaraMicro.bootstrap();
			InstanceDescriptor descriptor = runtime.getLocalDescriptor();
			System.out.println("Payara started at " + descriptor.getHttpPorts());

			GuiceContext.inject();
		}

		catch (Exception ex)
		{
			LogFactory.getLog(HelloWorld.class.getName())
			          .log(Level.SEVERE,
			               null, ex);
			ex.printStackTrace();
		}
	}
}
