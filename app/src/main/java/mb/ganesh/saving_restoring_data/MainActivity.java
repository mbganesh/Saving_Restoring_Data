package mb.ganesh.saving_restoring_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_ROLL = "rollno_key";
    private static final String KEY_NAME = "name_key";

    int rollno;
    String name;

    EditText roll_et , name_et;
    TextView roll_tv , name_tv;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll_et = (EditText) findViewById(R.id.rollnoID_edit);
        name_et = (EditText) findViewById(R.id.nameID_edit);

        roll_tv = (TextView) findViewById(R.id.display_rollno);
        name_tv = (TextView) findViewById(R.id.display_name);

        if (savedInstanceState != null){
            String save_RollNO = savedInstanceState.getString(KEY_ROLL);
            roll_tv.setText(save_RollNO);

            String save_Name = savedInstanceState.getString(KEY_NAME);
            name_tv.setText(save_Name);
        } else {
            Toast.makeText(getApplicationContext(),"Entry your data",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle saveData) {
        saveData.putString(KEY_ROLL , roll_et.getText().toString());
        saveData.putString(KEY_NAME , name_et.getText().toString());
        super.onSaveInstanceState(saveData);
    }

    public void saveData(View v){
        roll_tv.setText(roll_et.getText().toString().trim());
        name_tv.setText(name_et.getText().toString().trim());
    }
}
