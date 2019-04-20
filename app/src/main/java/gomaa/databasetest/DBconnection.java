package gomaa.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBconnection {
    DBinfo DbInfo;

    public DBconnection(Context context) {
        DbInfo = new DBinfo(context);

    }

    public long dataInsert(String fullname, String username, String password) {
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBinfo.names, fullname);
        contentValues.put(DBinfo.username, username);
        contentValues.put(DBinfo.password, password);
        long id = sqLiteDatabase.insert(DBinfo.tableName, null, contentValues);
        return id;
    }

    public String viewData(){
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();

        String [] colums ={DBinfo.UID, DBinfo.names,DBinfo.username,DBinfo.password};
        Cursor cursor= sqLiteDatabase.query(DBinfo.tableName,colums,null,null,null,null,null);
        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext()){
            int uid=cursor.getInt(0);
            String namee=cursor.getString(1);
            String usernamee=cursor.getString(2);
            String paswordd=cursor.getString(3);

            stringBuffer.append(uid+" : "+namee+" -  "+usernamee+" -- "+paswordd+ "\n");
        }
        return stringBuffer.toString();
    }





    public String searchData(String name){
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();

        String [] colums ={DBinfo.names,DBinfo.username,DBinfo.password};
        Cursor cursor= sqLiteDatabase.query(DBinfo.tableName,colums,DbInfo.username+" = '"+name+"'",null,null,null,null);
        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext()){

            int index1=cursor.getColumnIndex(DbInfo.names);
            int index2=cursor.getColumnIndex(DbInfo.username);
            int index3=cursor.getColumnIndex(DbInfo.password);
            String fullName=cursor.getString(index1);
            String userName=cursor.getString(index2);
            String passwOrd=cursor.getString(index3);
            stringBuffer.append(fullName+" - "+userName+" -  "+passwOrd+"\n");
        }
        return stringBuffer.toString();
    }



    public String searchName(String name){
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();

        String [] colums ={DBinfo.names,DBinfo.username,DBinfo.password};
        Cursor cursor= sqLiteDatabase.query(DBinfo.tableName,colums,DbInfo.names+" = '"+name+"'",null,null,null,null);
        StringBuffer stringBuffer= new StringBuffer();
        while (cursor.moveToNext()){

            int index1=cursor.getColumnIndex(DbInfo.names);
            int index2=cursor.getColumnIndex(DbInfo.username);
            int index3=cursor.getColumnIndex(DbInfo.password);
            String fullName=cursor.getString(index1);
            String userName=cursor.getString(index2);
            String passwOrd=cursor.getString(index3);
            stringBuffer.append(fullName+" - "+userName+" -  "+passwOrd+"\n");
        }
        return stringBuffer.toString();
    }

    public int updateName(String oldname , String newname){
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DbInfo.username,newname);
        String [] whreArgs ={oldname};
        int count=sqLiteDatabase.update(DbInfo.tableName,contentValues,DbInfo.username+" =? ",whreArgs);

        return count;
    }


    public int deleteName(String name){
        SQLiteDatabase sqLiteDatabase = DbInfo.getWritableDatabase();

        String [] whreArgs ={name};

        int count=sqLiteDatabase.delete(DbInfo.tableName,DbInfo.username+" =? ",whreArgs);

        return count;
    }


    static class DBinfo extends SQLiteOpenHelper {

        private static final String dataBase_Name = "Abdelrahman";
        private static final String tableName = "abdo";
        private static final int dataBase_Version = 4;
        private static final String UID = "id";
        private static final String names = "Name";
        private static final String username = "Username";
        private static final String password = "Password";
        private static final String DROB_TABLE = "DROP TABLE IF EXISTS " + tableName;
        private static final String CREATE_TABLE = "CREATE TABLE " + tableName +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + names + " VARCHAR(255), " + username + " VARCHAR(255), " + password + " VARCHAR(255));";
        private Context context;

        public DBinfo(Context context) {
            super(context, dataBase_Name, null, dataBase_Version);
            this.context = context;
            Toast.makeText(context, "this is constructor", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                Toast.makeText(context, "onCreate method ", Toast.LENGTH_SHORT).show();
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {

                Toast.makeText(context, "due to: " + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            try {
                Toast.makeText(context, "onUpgrade method ", Toast.LENGTH_SHORT).show();
                db.execSQL(DROB_TABLE);
                onCreate(db);
            } catch (SQLException e) {

                Toast.makeText(context, "due to: " + e, Toast.LENGTH_SHORT).show();
            }
        }
    }


}
