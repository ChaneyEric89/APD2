package com.fitwidget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by ericchaney on 12/17/15.
 */
public class Service extends RemoteViewsService {



    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ViewFactory(getApplicationContext());
    }




}

