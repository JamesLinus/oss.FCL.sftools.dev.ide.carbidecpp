/*
* Copyright (c) 2005 Nokia Corporation and/or its subsidiary(-ies).
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of the License "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description: 
*
*/

package com.nokia.sdt.component.symbian.test.scripting;

import com.nokia.sdt.component.IComponent;
import com.nokia.sdt.component.adapter.IComponentScriptAdapter;
import com.nokia.sdt.component.property.ISequencePropertySource;
import com.nokia.sdt.component.symbian.scripting.ComponentWrappers;
import com.nokia.sdt.component.symbian.scripting.WrappedProperties;
import com.nokia.sdt.datamodel.adapter.IComponentInstance;
import com.nokia.sdt.scripting.*;
import com.nokia.sdt.testsupport.AdapterHelpers;
import com.nokia.sdt.testsupport.FileHelpers;

import org.eclipse.ui.views.properties.IPropertySource;

/**
 * Test that the scripting API for arrays works.
 * This uses properties passed as an argument 
 * 
 * 
 * 
 */
public class ScriptingArraysTest extends BaseScriptTest {
    private IComponent list;
    
    private IComponentInstance instance;
    private IPropertySource properties_;
    private IScriptContext context;
    private IScriptObject object;
    private IComponentArrayTest arr;
    private WrappedProperties properties;
    public interface IComponentArrayTest {
        public int getLength(WrappedProperties properties, String prop);
        public Object getElementAt(WrappedProperties properties, String prop, int index);
        public Object setElementAt(WrappedProperties properties, String prop, int index, Object value);
        public Object getElementAtSub(WrappedProperties properties, String prop, int index, String subProp);
        public Object setElementAtSub(WrappedProperties properties, String prop, int index, String subProp, Object value);
		public int resizeAndCheck(WrappedProperties properties, String string, int size);
    }

    public ScriptingArraysTest() throws Exception {
    }

     /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        list = set.lookupComponent("com.nokia.test.arrayTest");
        assertNotNull(list);
        
        String filename = "arrays_params.js";

        IComponentScriptAdapter adapter = (IComponentScriptAdapter) list.getAdapter(IComponentScriptAdapter.class);

        context = adapter.getContextForFile(FileHelpers.projectRelativeFile(BASE_DIR + filename), 
                null);
        assertNotNull(context);
        
    }

    private void getInstance(String name) throws ScriptException {
        instance = AdapterHelpers.findComponentInstance(dataModel, name);
        properties_ = AdapterHelpers.getPropertySource(instance);
        properties = ComponentWrappers.getInstance(dataModel).getWrappedProperties(properties_);
        
        object = context.getScope().createInstance("ArrayTest");
        assertNotNull(object);

        arr = (IComponentArrayTest) object.wrapObjectInInterface(IComponentArrayTest.class);
    }
    
    public void testIntArrayReading() throws Exception {
        getInstance("arrayTest");
        int retInt;
        Object retObj;
        
        retInt = arr.getLength(properties, "ints");
        assertEquals(3, retInt);
        
        retObj = arr.getElementAt(properties, "ints", 0);
        assertNotNull(retObj);
        assertTrue(retObj instanceof Number);
        assertEquals(2, ((Number)retObj).intValue());
        retObj = arr.getElementAt(properties, "ints", 1);
        assertNotNull(retObj);
        assertEquals(3, ((Number)retObj).intValue());
        retObj = arr.getElementAt(properties, "ints", 2);
        assertNotNull(retObj);
        assertEquals(5, ((Number)retObj).intValue());

    }

    public void testStringArrayReading() throws Exception {
        getInstance("arrayTest");
        int retInt;
        Object retObj;
        
        retInt = arr.getLength(properties, "strs");
        assertEquals(2, retInt);

        retObj = arr.getElementAt(properties, "strs", 0);
        assertNotNull(retObj);
        assertEquals("One", retObj.toString());

        retObj = arr.getElementAt(properties, "strs", 1);
        assertNotNull(retObj);
        assertEquals("Two", retObj.toString());

    }

    public void testCompoundArrayReading() throws Exception {
        getInstance("arrayTest");
        int retInt;
        Object retObj;
        
        retInt = arr.getLength(properties, "foos");
        assertEquals(1, retInt);
        
        retObj = arr.getElementAt(properties, "foos", 0);
        assertNotNull(retObj);
        
        assertTrue(retObj instanceof IPropertySource);
    }

    public void testIntArrayWriting() throws Exception {
        getInstance("arrayTest");
        int retInt;
        Object retObj;
        
        retInt = arr.getLength(properties, "ints");
        assertEquals(3, retInt);
        
        arr.setElementAt(properties, "ints", 1, new Integer(77));
        retObj = arr.getElementAt(properties, "ints", 1);
        assertNotNull(retObj);
        assertEquals(77, ((Number)retObj).intValue());

        // test conversion
        arr.setElementAt(properties, "ints", 1, new Double(66));
        retObj = arr.getElementAt(properties, "ints", 1);
        assertNotNull(retObj);
        assertEquals(66, ((Number)retObj).intValue());

        // test conversion #2
        arr.setElementAt(properties, "ints", 1, "45");
        retObj = arr.getElementAt(properties, "ints", 1);
        assertNotNull(retObj);
        assertEquals(45, ((Number)retObj).intValue());

    }

    public void testStrArrayWriting() throws Exception {
        getInstance("arrayTest");
        int retInt;
        Object retObj;
        
        retInt = arr.getLength(properties, "strs");
        assertEquals(2, retInt);
        
        arr.setElementAt(properties, "strs", 1, "never");
        retObj = arr.getElementAt(properties, "strs", 1);
        assertNotNull(retObj);
        assertEquals("never", retObj.toString());

        // test conversion
        arr.setElementAt(properties, "strs", 1, new Double(66));
        retObj = arr.getElementAt(properties, "strs", 1);
        assertNotNull(retObj);
        assertEquals("66.0", retObj.toString());

        // test conversion #2
        arr.setElementAt(properties, "strs", 1, new Integer(111));
        retObj = arr.getElementAt(properties, "strs", 1);
        assertNotNull(retObj);
        assertEquals("111", retObj.toString());
    }

    public void testCompoundArrayWriting() throws Exception {
        getInstance("arrayTest");
        Object retObj;
        
        retObj = arr.getElementAt(properties, "foos", 0);
        assertNotNull(retObj);
        
        assertTrue(retObj instanceof IPropertySource);
        IPropertySource ps = (IPropertySource)retObj;

        ps.setPropertyValue("f1", "555");
        
        arr.setElementAtSub(properties, "foos", 0, "f1", new Integer(789));
        retObj = arr.getElementAtSub(properties, "foos", 0, "f1");
        assertNotNull(retObj);
        assertTrue(retObj instanceof Number);
        assertEquals(789, ((Number)retObj).intValue());

        // later: test adding new compound element.  
        // Need support somewhere to do this cleanly from a Javascript point of view
        
    }
    
    public void testArrayWritingAndGrowing() throws Exception {
        getInstance("emptyTest");
        int retInt;
        Object retObj;

        retInt = arr.getLength(properties, "strs");
        assertEquals(0, retInt);
        
        // test growing an array
        arr.setElementAt(properties, "strs", 0, "ubuntu");

        retInt = arr.getLength(properties, "strs");
        assertEquals(1, retInt);

        retObj = arr.getElementAt(properties, "strs", 0);
        assertNotNull(retObj);
        assertEquals("ubuntu", retObj.toString());
    }

    public void testArrayResizing() throws Exception {
        getInstance("emptyTest");
        int retInt;

        retInt = arr.resizeAndCheck(properties, "strs", 5);
        assertEquals(5, retInt);
        ISequencePropertySource sps = (ISequencePropertySource) properties.getPropertyValue("strs");
        assertEquals(5, sps.size());

        retInt = arr.resizeAndCheck(properties, "strs", 1);
        assertEquals(1, retInt);
        sps = (ISequencePropertySource) properties.getPropertyValue("strs");
        assertEquals(1, sps.size());

    }
}
