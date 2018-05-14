package com.simalee.guangxiu.data.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class SQLiteHelper extends SQLiteOpenHelper {


    public SQLiteHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建版本表
        db.execSQL(DBConstants.TableVersion.SQL_CREATE_TABLE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
