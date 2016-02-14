package com.baogg.bob.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button btnLogin,btnCancel ;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)this.findViewById(R.id.btnLogin);

        btnCancel  = (Button)this.findViewById(R.id.btnCancel);
        final EditText txtUser = (EditText)this.findViewById(R.id.txtUser);
        final EditText txtPassword = (EditText)this.findViewById(R.id.txtPassword);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //如果用户名密码等于baogg,则成功
                if (txtUser.getText().toString().equals("baogg") && txtPassword.getText().toString().equals("baogg")) {
                    Toast.makeText(getApplicationContext(), "You clicked OK", Toast.LENGTH_LONG).show();
                } else {
                    //Toast.makeText(MainActivity.this, txtUser.getText(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this, txtPassword.getText(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "You clicked Fail", Toast.LENGTH_LONG).show();


                    txtUser.setVisibility(View.VISIBLE);
                    txtUser.setBackgroundColor(Color.RED);
                    counter--;
                    //txtUser.setText(Integer.toString(counter));

                    if (counter == 0) {
                        btnLogin.setEnabled(false);
                    }
                }


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void showDialog(String txtYes){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(txtYes);

        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "You clicked yes button", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
