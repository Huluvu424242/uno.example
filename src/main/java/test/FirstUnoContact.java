package test;

import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.frame.FrameSearchFlag;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.text.XText;
import com.sun.star.text.XTextDocument;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

/******************************************************************************
 |FirstUnoContact.java|  -  TODO description

 begin                : |15.02.2009|
 copyright            : (C) |2009| by |SchubertT006|
 email                : |development@thomas-michel.info|
 ******************************************************************************/
/******************************************************************************
 *                                                                            *
 *   This program is free software; you can redistribute it and/or modify     *
 *   it under the terms of the Lesser GNU General Public License as published *
 *   by the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                      *
 *                                                                            *
 ******************************************************************************/

/** 
 * @author SchubertT006
 *
 */
public class FirstUnoContact {

    public static void main(String[] args) {
        execution();
    }

    /**
     * 
     */
    private static void execution() {
        try {
            // get the remote office component context
            XComponentContext context = Bootstrap.bootstrap();

            System.out.println("Connected to a running office ...");

            XMultiComponentFactory factory = context.getServiceManager();

            String available = (factory != null ? "available" : "not available");
            System.out.println("remote ServiceManager is " + available);

            Object desktop = factory.createInstanceWithContext(
                    "com.sun.star.frame.Desktop", context);
            XComponentLoader loader = (XComponentLoader) UnoRuntime
                    .queryInterface(XComponentLoader.class, desktop);

            XComponent writer = loader.loadComponentFromURL(
                    "private:factory/swriter", "_blank", FrameSearchFlag.ALL,
                    new PropertyValue[] {});
            
            XTextDocument document = (XTextDocument) UnoRuntime.queryInterface(
                    XTextDocument.class, writer);
            XText textCursor=document.getText();
            textCursor.setString("Hallo ich bin Dein Office !!!");
           

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}

/**
* ChangeLog
* 
* $Revision:$
* 
*/
