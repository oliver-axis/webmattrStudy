package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import webmattr.Webmattr;

/**
 * Created by admin on 2/15/16.
 */
public class AppEntryPoint implements EntryPoint {


    public void onModuleLoad() {

        Webmattr.init();

        // route to a page
        App.getRoutes().getAuth().getLogin().go();

    }
}
