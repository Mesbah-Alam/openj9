/*******************************************************************************
 * Copyright (c) 2019, 2019 IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] http://openjdk.java.net/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
package org.openj9.test.java_lang_constant;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DynamicConstantDesc;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

/**
 * This test Java.lang.constant.DynamicConstantDesc API added in Java 12 and
 * later versions.
 *
 * tested methods: 
 * - resolveConstantDesc
 */
public class Test_DynamicConstantDesc {
	public static Logger logger = Logger.getLogger(Test_DynamicConstantDesc.class);
	
	/*
	 * Test Java 12 API DynamicConstantDesc.resolveConstantDesc()
	 */
	@Test(groups = { "level.sanity" })
	public void testDynamicConstantDescResolveConstantDesc() throws Throwable {
		/* describe and resolve constant */
		DynamicConstantDesc desc = DynamicConstantDesc.ofNamed(ConstantDescs.BSM_PRIMITIVE_CLASS, "I",
				ConstantDescs.CD_Class, new ConstantDesc[0]);
		Class<?> resolvedClass = (Class<?>)desc.resolveConstantDesc(MethodHandles.lookup());

		/* verify that constant was resolve properly */
		logger.debug("testDynamicConstantDescResolveConstantDesc: resolved class is: " + resolvedClass.toString());
		Assert.assertTrue(resolvedClass.equals(int.class));
	}
}