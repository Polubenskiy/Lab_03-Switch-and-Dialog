package com.example.lab03_switch_and_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkBoxes;
    EditText[] priceProduct, countProduct;
    Float[]  price;

    RadioButton rb_Message, rb_Toast;
    AlertDialog.Builder dialog;
    //  Polubenskiy Lab_03 - Switch and Dialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBoxes = new CheckBox[4];
        priceProduct = new EditText[4];
        countProduct = new EditText[4];
        price = new Float[4];

        rb_Message = findViewById(R.id.rb_Message);
        rb_Toast = findViewById(R.id.rb_Toast);

        checkBoxes[0] = findViewById(R.id.checkBox_0);
        checkBoxes[1] = findViewById(R.id.checkBox_1);
        checkBoxes[2] = findViewById(R.id.checkBox_2);
        checkBoxes[3] = findViewById(R.id.checkBox_3);

        priceProduct[0] = findViewById(R.id.editTextNumber_0);
        priceProduct[1] = findViewById(R.id.editTextNumber_1);
        priceProduct[2] = findViewById(R.id.editTextNumber_2);
        priceProduct[3] = findViewById(R.id.editTextNumber_3);

        countProduct[0] = findViewById(R.id.editTextNumber_00);
        countProduct[1] = findViewById(R.id.editTextNumber_01);
        countProduct[2] = findViewById(R.id.editTextNumber_02);
        countProduct[3] = findViewById(R.id.editTextNumber_03);

        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Cheque");
        dialog.setPositiveButton("OK", null);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.check);
    }

    //  Polubenskiy Lab_03 - Switch and Dialog
    public void onCalc(View v)
    {
        float    q;
        double sum = 0;
        String str = "";
        for (int i = 0; i < checkBoxes.length; i++)
        {
            if (checkBoxes[i].isChecked())
            {
                if (countProduct[i].getText().toString().equals("0") || priceProduct[i].getText().toString().equals("0") || countProduct[i].getText().toString().isEmpty() || priceProduct[i].getText().toString().isEmpty())
                {
                   // sumProduct.setText("Zero value not");
                    Toast toast = Toast.makeText(getApplicationContext(), "Поле пустое, заполните пожалуйста!", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                price[i] = Float.parseFloat(priceProduct[i].getText().toString());
                q = Float.parseFloat(countProduct[i].getText().toString());
                sum += q * price[i];
                str += checkBoxes[i].getText() + ": " + countProduct[i].getText() + " x " + priceProduct[i].getText() + " = " + q * price[i] + " p " +"\n";
            }
        }
        sum = Math.round(sum);
        str += "Total coast: " + sum;
        if (rb_Message.isChecked())
        {
            dialog.setMessage(str);
            dialog.create().show();
        }
        else if (rb_Toast.isChecked())
        {
            Toast toast = Toast.makeText(getApplicationContext(), str , Toast.LENGTH_LONG);
            toast.show();
        }
    }
    //  Polubenskiy Lab_03 - Switch and Dialog
    public void setRadioButtonClick(View v)
    {
        switch((String)v.getTag())
        {
            case "1":
                rb_Toast.setChecked(false);
                break;
            case "2":
                rb_Message.setChecked(false);
                break;
        }
    }
}