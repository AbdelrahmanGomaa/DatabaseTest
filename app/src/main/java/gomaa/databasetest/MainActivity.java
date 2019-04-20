package gomaa.databasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fullname, username, password;
    DBconnection dataBase;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fullname = findViewById(R.id.FullName);
        username = findViewById(R.id.UserName);
        password = findViewById(R.id.Password);

        textview = findViewById(R.id.display);
        dataBase = new DBconnection(this);

    }

    public void save(View view) {

        String full_name = fullname.getText().toString();
        String user_name = username.getText().toString();
        String pass_word = password.getText().toString();


        long id = dataBase.dataInsert(full_name, user_name, pass_word);

        if (id < 0) {
            Toast.makeText(this, "Error ! not inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Successfullt inserted", Toast.LENGTH_SHORT).show();
        }

        fullname.setText("");
        username.setText("");
        password.setText("");
    }

    public void dataView(View view) {
        String data = dataBase.viewData();
        textview.setText(data);

    }


    public void searchh(View view) {

        Toast.makeText(this, "to search", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, SearchActivty.class);
        startActivity(i);
    }

    public void update(View view) {

        Toast.makeText(this, "to update", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, UpdateActivity.class);
        startActivity(i);
    }

    public void delete(View view) {

        Toast.makeText(this, "to delete", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, DeleteActivity.class);
        startActivity(i);
    }
}
