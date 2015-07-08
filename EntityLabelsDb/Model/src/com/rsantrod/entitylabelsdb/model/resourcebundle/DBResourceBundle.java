package com.rsantrod.entitylabelsdb.model.resourcebundle;

import com.rsantrod.entitylabelsdb.model.AppModuleImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListResourceBundle;
import java.util.Map;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class DBResourceBundle extends ListResourceBundle {
    private Object[][] stored = null;

    public Object[][] getContents() {
        if (stored == null) {
            initResourceBundle();
        }
        return stored;
    }

    /** synchronized initialization of reading resource bundle */
    private synchronized void initResourceBundle() {
        Map map = new HashMap();
        map = getResourceBundle();

        // copy all values from map in object array
        if (map.size() == 0) {
            stored = new Object[0][0];
        } else {
            Object[][] returnValue = new Object[map.size()][2];
            int ii = 0;
            for (Iterator keyIter = map.keySet().iterator(); keyIter.hasNext();) {
                Object key = keyIter.next();
                returnValue[ii][0] = key;
                returnValue[ii][1] = map.get(key);
                ii++;
            }
            stored = returnValue;
        }
    }
    
    public String getLocaleCode() {
        return null;
    }

    private Map getResourceBundle() {
        String amDef = "com.rsantrod.entitylabelsdb.model.AppModule";
        String config = "AppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        Map map = ((AppModuleImpl) am).getResourceBundle(getLocaleCode());
        Configuration.releaseRootApplicationModule(am, false);
        return map;
    }
}

