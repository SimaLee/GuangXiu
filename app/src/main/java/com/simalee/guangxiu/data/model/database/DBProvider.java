package com.simalee.guangxiu.data.model.database;

import android.content.Context;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class DBProvider {

    private static final String TAG = "DBProvider";


    private SQLiteHelper mHelper = null;
    private static volatile DBProvider sInstance = null;

    private DBProvider(Context context){
        mHelper = new SQLiteHelper(context,DBConstants.DATABASE_NAME,DBConstants.DATABASE_VERSION);
    }

    public static DBProvider getInstance(Context context){
        if (sInstance == null){
            synchronized(DBProvider.class){
                if (sInstance == null){
                    sInstance = new DBProvider(context);
                }
            }
        }
        return sInstance;
    }

    public SQLiteHelper getSQLiteHelper(){
        return mHelper;
    }


}
