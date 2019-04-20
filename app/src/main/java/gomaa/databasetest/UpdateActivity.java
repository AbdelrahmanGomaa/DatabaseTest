package gomaa.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText etOld, etNew;
    DBconnection database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etOld = findViewById(R.id.etOld);
        etNew = findViewById(R.id.etNew);
        database = new DBconnection(this);
    }

    public void update(View view) {
        String str1 = etOld.getText().toString();
        String str2 = etNew.getText().toString();
        database.updateName(str1, str2);
        Toast.makeText(this, "update Done", Toast.LENGTH_SHORT).show();
        etOld.setText("");
        etNew.setText("");
    }

    public void back(View view) {

        Toast.makeText(this, "to Home", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
