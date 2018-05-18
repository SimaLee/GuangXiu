package com.simalee.guangxiu.data.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String TAG = "SQLiteHelper";


    public SQLiteHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建版本表
        Log.d(TAG, "onCreate: db create");
        createTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //创建新增的数据库表
        createTable(db);
    }

    /**
     * 创建数据库表
     */
    private void createTable(SQLiteDatabase db){
        //创建版本号表
        db.execSQL(DBConstants.TableVersion.SQL_CREATE_TABLE);
        //创建广绣简要介绍表
        db.execSQL(DBConstants.TableIntroduction.SQL_CREATE_TABLE);

    }

}
