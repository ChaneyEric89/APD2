package com.fitwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

/**
 * Created by eric chaney on 12/16/15.
 */
public class Provider extends AppWidgetProvider {

    public static final String ACTION_VIEW_ADD = "com.fitwidget.ACTION_VIEW_ADD";

    public static final String ACTION_VIEW_DETAILS = "com.fitwidget.ACTION_VIEW_DETAILS";

    public static final String EXTRA_ITEM = "com.fitwidget.WidgetProvider.EXTRA_ITEM";


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);


        if(intent.getAction().equals(ACTION_VIEW_ADD)) {
            Intent formIntent = new Intent(context, MainActivity.class);
            formIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(formIntent);

        }



    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for(int i = 0; i < appWidgetIds.length; i++) {

            int widgetId = appWidgetIds[i];

            Intent intent = new Intent(context, Service.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

            RemoteViews widgetView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            widgetView.setRemoteAdapter(R.id.entries_list, intent);
            widgetView.setEmptyView(R.id.entries_list, R.id.empty);

            Intent addIntent = new Intent(ACTION_VIEW_ADD);
            PendingIntent aIntent = PendingIntent.getBroadcast(context, 0, addIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            widgetView.setOnClickPendingIntent(R.id.widget_button, aIntent);


            appWidgetManager.updateAppWidget(widgetId, widgetView);
        }


        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }
}
