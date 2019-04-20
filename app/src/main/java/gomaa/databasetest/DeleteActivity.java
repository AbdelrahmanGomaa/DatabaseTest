package gomaa.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText etdele;
    DBconnection database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etdele = findViewById(R.id.etdele);
        database = new DBconnection(this);
    }


    public void back(View view) {

        Toast.makeText(this, "to Home", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void delete(View view) {
        String str1 = etdele.getText().toString();
        database.deleteName(str1);
        Toast.makeText(this, "user deleted", Toast.LENGTH_SHORT).show();
        etdele.setText("");
    }
}
