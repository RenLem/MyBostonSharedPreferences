package omy.boston.mybostonsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView_nickname;
    private TextView textView_password;
    private TextView textView_displayingSaved;
    private EditText editText_nickname;
    private EditText editText_password;
    private Button button_save;
    private Button button_dispaySaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grabWidgets();
    }

    protected void grabWidgets(){
        textView_nickname = (TextView) findViewById(R.id.textView_nickname);
        textView_password = (TextView) findViewById(R.id.textView_password);
        textView_displayingSaved = (TextView) findViewById(R.id.textView_displayingSaved);

        editText_nickname = (EditText) findViewById(R.id.editText_nickname);
        editText_password = (EditText) findViewById(R.id.editText_password);

        button_save = (Button) findViewById(R.id.button_save);
        button_dispaySaved = (Button) findViewById(R.id.button_displaySaved);
    }

    //This metod will save nickname & password to object named sharedPref in to "nickPass" file
    public void saveNickPass(View view){
        SharedPreferences sharedPref = getSharedPreferences("nickPass", Context.MODE_PRIVATE);

        //This object will wright to "nickPass" file
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nickname", editText_nickname.getText().toString());
        editor.putString("password", editText_password.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    //This metod will display nickname & password saved in object sharedPref in file "nickPass"
    public void dispayNickPass(View view){
        SharedPreferences sharedPref = getSharedPreferences("nickPass", Context.MODE_PRIVATE);

        String nickname = sharedPref.getString("nickname", "");
        String password = sharedPref.getString("password", "");
        textView_displayingSaved.setText("Nockname: " + nickname + "\n" + "Password: " + password);
    }
}
