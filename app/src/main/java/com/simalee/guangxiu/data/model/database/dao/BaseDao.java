package com.simalee.guangxiu.data.model.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.simalee.guangxiu.data.model.database.DBProvider;
import com.simalee.guangxiu.data.model.database.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public abstract class BaseDao<T> {

    protected SQLiteHelper mHelper;

    public BaseDao(Context context){
        mHelper = DBProvider.getInstance(context).getSQLiteHelper();
    }

    /**
     * 插入数据
     * @param tableName
     * @param nullColumnHack
     * @param values
     * @return
     */
    public long insert(String tableName, String nullColumnHack, ContentValues values){

        long ret = 0;
        SQLiteDatabase database = mHelper.getWritableDatabase();
        database.beginTransaction();

        try {

            ret = database.insert(tableName,nullColumnHack,values);
            database.setTransactionSuccessful();

        } catch (RuntimeException e) {
            e.printStackTrace();

        } finally {
            database.endTransaction();
        }

        return ret;
    }

    /**
     * 根据条件查询数据
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @param limit
     * @return
     */
    public  List<T> query(String table,String[] columns,
                             String selection,String[] selectionArgs,
                             String groupBy,String having,
                             String orderBy,Integer limit){

        List<T> resultList = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (limit != null){
                cursor = mHelper.getReadableDatabase()
                        .query(table, columns,
                                selection, selectionArgs,
                                groupBy, having, orderBy,limit+"");
            }else{
                cursor = mHelper.getReadableDatabase()
                        .query(table, columns,
                                selection, selectionArgs,
                                groupBy, having, orderBy);
            }
            resultList = queryResult(cursor);

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {

            if (cursor != null){
                cursor.close();
            }

        }

        return resultList;
    }

    /**
     * 用于转换对象
     * @param cursor
     * @return
     */
    abstract  List<T> queryResult(Cursor cursor);

    /**
     * 更新数据
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int update(String table,ContentValues values,String whereClause,String[] whereArgs){

        int ret = 0;
        SQLiteDatabase database = mHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            ret = database.update(table, values, whereClause, whereArgs);
            database.setTransactionSuccessful();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            database.endTransaction();

        }
        return ret;
    }

    /**
     * 删除一项数据
     * @param table
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int delete(String table,String whereClause,String[] whereArgs){
        int ret = 0;

        SQLiteDatabase database = mHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            database.delete(table, whereClause, whereArgs);
            database.setTransactionSuccessful();

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {

            database.endTransaction();

        }
        return ret;
    }
}
