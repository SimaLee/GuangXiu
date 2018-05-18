package com.simalee.guangxiu.data.model.database;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public interface DBConstants {

    String DATABASE_NAME = "guangxiu.db";
    int DATABASE_VERSION = 1;

    String SEPERATOR = ",";

    //版本信息表
    interface TableVersion {

        String TABLE_NAME = "version";
        String COLUMN_ID = "id";
        String COLUMN_NAME = "name";
        String COLUMN_OLD_VERSION = "oldVersion";
        String COLUMN_NEW_VERSION = "newVersion";
        String COLUMN_DESCRIPTION = "description";

        //版本号
        String SQL_CREATE_TABLE =
                "create table if not exists " +TABLE_NAME +
                        "("
                        +COLUMN_ID + " integer primary key autoincrement" + SEPERATOR
                        +COLUMN_NAME + " text NOT NULL"+ SEPERATOR
                        +COLUMN_OLD_VERSION + " integer NOT NULL "+ SEPERATOR
                        +COLUMN_NEW_VERSION + " integer NOT NULL "+ SEPERATOR
                        +COLUMN_DESCRIPTION + " text"
                        +")";

        String SQL_DROP_TABLE = "drop table " + TABLE_NAME;

    }

    /**
     * 广绣简要介绍
     */
    interface TableIntroduction{

        String TABLE_NAME = "simpleIntroduction";
        String COLUMN_ID = "id";
        String COLUMN_VERSION = "version";
        String COLUMN_DESCRIPTION = "desc";
        String COLUMN_BACKGROUND = "backgroundUrl";

        String SQL_CREATE_TABLE =
                "create table if not exists " +TABLE_NAME +
                        "("
                        +COLUMN_ID + " integer primary key autoincrement" + SEPERATOR
                        +COLUMN_VERSION + " integer UNIQUE NOT NULL"+ SEPERATOR
                        +COLUMN_DESCRIPTION + " text " + SEPERATOR
                        +COLUMN_BACKGROUND + " text "
                        +")";

        String SQL_DROP_TABLE = "drop table " + TABLE_NAME;

    }





}
