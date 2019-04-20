package gomaa.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivty extends AppCompatActivity {
    EditText editText, etName;
    TextView textView, txtName;

    DBconnection database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activty);

        editText = findViewById(R.id.usernameSearch);
        textView = findViewById(R.id.textView6);
        etName = findViewById(R.id.etName);
        txtName = findViewById(R.id.textView5);
        database = new DBconnection(this);
    }

    public void back(View view) {

        Toast.makeText(this, "to search", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void search(View view) {

        String str1 = editText.getText().toString();
        String str2 = database.searchData(str1);
        textView.setText(str2);
    }

    public void searchName(View view) {

        String str1 = etName.getText().toString();
        String str2 = database.searchName(str1);
        txtName.setText(str2);
    }
}
