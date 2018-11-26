package com.example.milene.calculaimc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
    }

    public void calculaIMC(View v){
        try {
            float peso = Float.parseFloat(edtPeso.getText().toString());
            float altura = Float.parseFloat(edtAltura.getText().toString());
            float imc = peso / (altura * altura);
            String resposta = situacaoIMC(imc);

            AlertDialog alerta = new AlertDialog.Builder(MainActivity.this).create();
            alerta.setTitle("O resultado obtido foi: ");
            alerta.setMessage(resposta);
            alerta.setButton(AlertDialog.BUTTON_NEUTRAL, "ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alerta.show();
        } catch (Exception ex){

        }//final try catch
    } // final da class calculaIMC

    public String situacaoIMC(float imc){

        String situacao;

        if(imc < 17){
            situacao = "Muito Abaixo do peso";
        }else if(imc >= 17 && imc < 18.49){
            situacao = "Abaixo do peso";
        }else if(imc > 18.49 && imc <= 24.99){
            situacao = "Peso normal";
        }else if(imc > 24.99 && imc <= 29.99){
            situacao = "Acima do peso";
        }else if (imc > 29.99 && imc <= 34.99){
            situacao = "Obesidade I";
        }else if (imc > 34.99 && imc <= 39.99){
            situacao = "Obesidade II (severa)";
        }else{
            situacao = "Obesidade III (mórbida)";
        }
        return  situacao;
    } // final class situacaoIMC


}//final da classe principal
