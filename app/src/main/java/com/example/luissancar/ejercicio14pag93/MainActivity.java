package com.example.luissancar.ejercicio14pag93;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.editText);

    }

    public void grabar(View view){
        try {
            OutputStreamWriter fichero = new OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE));
            fichero.write(et1.getText().toString());
            fichero.flush();
            fichero.close();
        }
        catch (IOException e){

            Toast toast = Toast.makeText(this, "Error: "+e.getMessage().toString(), Toast.LENGTH_LONG);
            toast.show();
            finish();

        }
        Toast toast = Toast.makeText(this, "Ok", Toast.LENGTH_LONG);
        toast.show();
        finish();

    }
}
