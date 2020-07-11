package com.lakj.comspace.simpletextclient;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;

public class finalize_order extends Activity {
    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;
    boolean d,b,c;
    Info info;
    static int time_taken;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceOrders;
    private DatabaseReference mReff;

    static String temp_order_view;
    long maxid=0;
    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        tn();
        show_Order();
        tot_v();
        tt();
        oo=this;
        info=new Info();
        info.setPrice(all_total);
        info.setTableno(SlimpleTextClientActivity.tablex);
        info.setOrder(temp_order_view);
        info.setTime(time_taken);
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceOrders=mDatabase.getReference().child("table");

        mReff=mDatabase.getReference().child("log");
        mReferenceOrders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //mReferenceOrders.push().setValue(SlimpleTextClientActivity.tablex);
        //mReferenceOrders.push().setValue(info);

    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            d=true;
            fin_order_string = fin_order_string + "chocolate ice cream-" + String.valueOf(Dessert.chocolate_ice_cream) + ",";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            d=true;
            fin_order_string = fin_order_string + "vannila ice cream-" + String.valueOf(Dessert.vanilla_ice_cream) + ",";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            d=true;
            fin_order_string = fin_order_string + "strawberry ice cream-" + String.valueOf(Dessert.strawberry_ice_cream) + ",";
        }
        if (Dessert.falooda > 0) {
            d=true;
            fin_order_string = fin_order_string + "falooda-" + String.valueOf(Dessert.falooda) + ",";
        }
        if (Dessert.brownie_fudge > 0) {
            d=true;
            fin_order_string = fin_order_string + "brownie fudge-" + String.valueOf(Dessert.brownie_fudge) + ",";
        }
        if (Dessert.alpine_chocolate > 0) {
            d=true;
            fin_order_string = fin_order_string + "alpine chocolate-" + String.valueOf(Dessert.alpine_chocolate) + ",";
        }
        if (Dessert.devils_delight > 0) {
            d=true;
            fin_order_string = fin_order_string + "devils delite-" + String.valueOf(Dessert.devils_delight) + ",";
        }

        if (Dessert.black_forest > 0) {
            d=true;
            fin_order_string = fin_order_string + "black forest-" + String.valueOf(Dessert.black_forest) + ",";
        }
        if (Dessert.chocolate_lava > 0) {
            d=true;
            fin_order_string = fin_order_string + "chocolate lava-" + String.valueOf(Dessert.chocolate_lava) + ",";
        }

        if (Dessert.dutch_almond > 0) {
            d=true;
            fin_order_string = fin_order_string + "dutch almond-" + String.valueOf(Dessert.dutch_almond) + ",";
        }
        if (N_Veg.chicken_burger > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken burger-" + String.valueOf(N_Veg.chicken_burger) + ",";
        }
        if (N_Veg.chicken_bbq_pizza > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken bbq pizza-" + String.valueOf(N_Veg.chicken_bbq_pizza) + ",";
        }
        if (N_Veg.chicken_tikka > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken tikka-" + String.valueOf(N_Veg.chicken_tikka) + ",";
        }
        if (N_Veg.fried_fish_rice > 0) {
            b=true;
            fin_order_string = fin_order_string + "fried fish rice-" + String.valueOf(N_Veg.fried_fish_rice) + ",";
        }
        if (N_Veg.kolhapuri_chicken > 0) {
            b=true;
            fin_order_string = fin_order_string + "kolhapur chicken-" + String.valueOf(N_Veg.kolhapuri_chicken) + ",";
        }
        if (N_Veg.chicken_noodles > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken noodles-" + String.valueOf(N_Veg.chicken_noodles) + ",";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken fried rice-" + String.valueOf(N_Veg.chicken_fried_rice) + ",";
        }

        if (N_Veg.chicken_lollipop > 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken lollipop-" + String.valueOf(N_Veg.chicken_lollipop) + ",";
        }

        if (N_Veg.chicken_biryani> 0) {
            b=true;
            fin_order_string = fin_order_string + "chicken biryani-" + String.valueOf(N_Veg.chicken_biryani) + ",";
        }
        if (N_Veg.mutton_biryani> 0) {
            b=true;
            fin_order_string = fin_order_string + "mutton biryani-" + String.valueOf(N_Veg.mutton_biryani) + ",";
        }

        if (Veg.roti > 0) {
            b=true;
            fin_order_string = fin_order_string + "roti-" + String.valueOf(Veg.roti) + ",";
        }
        if (Veg.butter_roti > 0) {
            b=true;
            fin_order_string = fin_order_string + "butter roti-" + String.valueOf(Veg.butter_roti) + ",";
        }
        if (Veg.paneer_tikka > 0) {
            b=true;
            fin_order_string = fin_order_string + "paneer tikka-" + String.valueOf(Veg.paneer_tikka) + ",";
        }

        if (Veg.veg_pulao > 0) {
            b=true;
            fin_order_string = fin_order_string + "veg pulao-" + String.valueOf(Veg.veg_pulao) + ",";
        }
        if (Veg.mutter_paneer> 0) {
            b=true;
            fin_order_string = fin_order_string + "mutter paneer-" + String.valueOf(Veg.mutter_paneer) + ",";
        }
        if (Veg.veg_noodles> 0) {
            b=true;
            fin_order_string = fin_order_string + "veg noodles-" + String.valueOf(Veg.veg_noodles) + ",";
        }

        if (Veg.veg_fried_rice> 0) {
            b=true;
            fin_order_string = fin_order_string + "veg fried rice-" + String.valueOf(Veg.veg_fried_rice) + ",";
        }
        if (Veg.veg_burger> 0) {
            b=true;
            fin_order_string = fin_order_string + "veg burger-" + String.valueOf(Veg.veg_burger) + ",";
        }
        if (Veg.veg_biryani> 0) {
            b=true;
            fin_order_string = fin_order_string + "veg briyani-" + String.valueOf(Veg.veg_biryani) + ",";
        }

        if (Veg.paneer_kofta> 0) {
            b=true;
            fin_order_string = fin_order_string + "paneer kofta-" + String.valueOf(Veg.paneer_kofta) + ",";
        }
        if (Starters.veg_crispy > 0) {
            c=true;
            fin_order_string = fin_order_string + "veg crispy-" + String.valueOf(Starters.veg_crispy) + ",";
        }
        if (Starters.chicken_crispy > 0) {
            c=true;
            fin_order_string = fin_order_string + "chicken crispy-" + String.valueOf(Starters.chicken_crispy) + ",";
        }
        if (Starters.paneer_chilly > 0) {
            c=true;
            fin_order_string = fin_order_string + "paneer chilly-" + String.valueOf(Starters.paneer_chilly) + ",";
        }
        if (Starters.masala_papad > 0) {
            c=true;
            fin_order_string = fin_order_string + "masala papad-" + String.valueOf(Starters.masala_papad) + ",";
        }
        if (Starters.veg_soup > 0) {
            c=true;
            fin_order_string = fin_order_string + "veg soup-" + String.valueOf(Starters.veg_soup) + ",";
        }
        if (Starters.chicken_soup > 0) {
            c=true;
            fin_order_string = fin_order_string + "chicken soup-" + String.valueOf(Starters.chicken_soup) + ",";
        }
        if (Starters.tomato_soup > 0) {
            c=true;
            fin_order_string = fin_order_string + "tomato soup-" + String.valueOf(Starters.tomato_soup) + ",";
        }
        if (Starters.cheese_pakoda > 0) {
            c=true;
            fin_order_string = fin_order_string + "cheese pakoda-" + String.valueOf(Starters.cheese_pakoda) + ",";
        }
        if (Starters.paneer_pakoda > 0) {
            c=true;
            fin_order_string = fin_order_string + "paneer pakoda-" + String.valueOf(Starters.paneer_pakoda) + ",";
        }
        if (Starters.chicken_chilly > 0) {
            c=true;
            fin_order_string = fin_order_string + "chicken chilly-" + String.valueOf(Starters.chicken_chilly) + ",";
        }
        temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        if(b==true){
            time_taken=30;
        }
        if(c==true && b==false){
            time_taken=15;
        }
        if(d==true && c==false && b==false ){
            time_taken=10;
        }
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("\ntotal price:" + "₹" +(finalize_order.all_total));

    }
    public void tn(){
        TextView tv = (TextView) findViewById(R.id.tn);
        tv.setText("Your table no " + "is:  " +(SlimpleTextClientActivity.tablex));
    }
    public void tt(){
        TextView tv=(TextView)findViewById(R.id.ttaken);
        tv.setText("\nTime taken: "+(finalize_order.time_taken));
    }


    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;

    EditText Ed= (EditText) findViewById(R.id.personalp);

    personal_preferances=Ed.getText().toString();

    final Object o = this;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to confirm this order?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                      messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total)+"|"+personal_preferances;
                        ; // get the text message on the text field
                   // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                        SendMessage sendMessageTask = new SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((finalize_order) o, thankyou.class);
                        startActivity(nextact);
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
    AlertDialog alert = builder.create();
    alert.show();
    String currentDate = new SimpleDateFormat("YYYY-MM-dd", Locale.GERMAN).format(new Date());
    String currentTime = String.valueOf(System.currentTimeMillis());
    mReferenceOrders.child(String.valueOf(SlimpleTextClientActivity.tablex)).setValue(info);
    mReff.push().setValue(info);
}
}