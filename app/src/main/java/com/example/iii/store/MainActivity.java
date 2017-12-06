package com.example.iii.store;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    productlist list = new productlist();
    
    String[] production = new String[list.getall().length];
    String[] sellprice = new String[list.getall().length];
    String[] setqty = new String[100];


    private View.OnClickListener summary_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int num1 = Integer.parseInt(pay.getText().toString());
            int num2 = Integer.parseInt(money.getText().toString());
            if(num1-num2 >=0){
                change.setText(""+(num1-num2));
            }else{
                change.setText(num1-num2+"(錢付不夠哦)");
            }
        }
    };
    private View.OnClickListener menu_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"哈哈哈哈~功能未開放",Toast.LENGTH_SHORT).show();
        }
    };

    public DialogInterface.OnClickListener btnReceiver_click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            product.setText(production[which]);
            price.setText(sellprice[which]);
            qty.requestFocus();
        }
    };

    private View.OnClickListener product_oclick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            qty.setText("");
            money.setText("");
            change.setText("");
            pay.setText("");
            price.setText("");
            int index=0;
            for(products p1 : list.getall()){
                production[index]=p1.getName();
                sellprice[index]=String.valueOf(p1.getPrice());
                index ++;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("請選擇商品");
            builder.setItems(production,btnReceiver_click);
            Dialog message = builder.create();
            message.show();

        }
    };
    private DialogInterface.OnClickListener btnReceiverqty_click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            qty.setText(setqty[which]);
            int a = Integer.parseInt(String.valueOf(price.getText()));
            int b = Integer.parseInt(setqty[which]);
            money.setText(String.valueOf(a*b));
        }
    };
    private View.OnClickListener qty_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(int i =0 ; i< setqty.length;i++){
                setqty[i]=String.valueOf(i+1);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("請選擇數量");
            builder.setItems(setqty,btnReceiverqty_click);
            Dialog message = builder.create();
            message.show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
        summary = (Button)findViewById(R.id.summary);
        summary.setOnClickListener(summary_onclick);
        menu = (Button)findViewById(R.id.menu);
        menu.setOnClickListener(menu_onclick);
        product = (EditText)findViewById(R.id.product);
        product.setOnClickListener(product_oclick);
        qty = (EditText)findViewById(R.id.qty);
        qty.setOnClickListener(qty_onclick);
        money = (EditText)findViewById(R.id.money);
        change = (EditText)findViewById(R.id.change);
        pay = (EditText)findViewById(R.id.pay);
        price = (EditText)findViewById(R.id.price);
    }

    Button summary,menu;
    EditText product,qty,money,change,pay,price;
}
