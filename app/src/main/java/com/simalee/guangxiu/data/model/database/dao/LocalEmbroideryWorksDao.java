package com.simalee.guangxiu.data.model.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.model.database.DBConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/23.
 */

public class LocalEmbroideryWorksDao extends BaseDao<LocalEmbroideryWork> {
    private static final String TAG = "LocalEmbroideryWorksDao";

    public LocalEmbroideryWorksDao(Context context) {
        super(context);
    }

    public boolean insertLocalEmbroideryWork(LocalEmbroideryWork localEmbroideryWork){


        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.LocalEmbroideryWorks.COLUMN_TYPE,localEmbroideryWork.getType());
        contentValues.put(DBConstants.LocalEmbroideryWorks.COLUMN_AUTHOR_NAME,localEmbroideryWork.getAuthorName());
        contentValues.put(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_NAME,localEmbroideryWork.getWorkName());
        contentValues.put(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_DES,localEmbroideryWork.getWorkDes());
        contentValues.put(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_PATH,localEmbroideryWork.getWorkPath());

        long ret = insertWithOnConflict(DBConstants.LocalEmbroideryWorks.TABLE_NAME,null,contentValues, SQLiteDatabase.CONFLICT_REPLACE);

        if (ret == -1){
            return false;
        }
        return true;
    }

    public List<LocalEmbroideryWork> getLocalEmbroideryWorks(){

        List<LocalEmbroideryWork> results = query(DBConstants.LocalEmbroideryWorks.TABLE_NAME,null,null,null,null,null,null,null);

        if (results != null && results.size() >0){
            return results;
        }

        return null;
    }

    @Override
    List<LocalEmbroideryWork> queryResult(Cursor cursor) {
        List<LocalEmbroideryWork> result = new ArrayList<>();
        LocalEmbroideryWork work;
        while(cursor.moveToNext()){
            work = new LocalEmbroideryWork();

            work.setId(cursor.getInt(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_ID)));
            work.setType(cursor.getInt(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_TYPE)));
            work.setAuthorName(cursor.getString(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_AUTHOR_NAME)));
            work.setWorkName(cursor.getString(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_NAME)));
            work.setWorkDes(cursor.getString(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_DES)));
            work.setWorkPath(cursor.getString(cursor.getColumnIndex(DBConstants.LocalEmbroideryWorks.COLUMN_WORK_PATH)));

            result.add(work);
        }
        return result;
    }
}
