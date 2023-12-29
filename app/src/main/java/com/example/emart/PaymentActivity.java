package com.example.emart;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridview.R;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity {
    Button payBtn;
    EditText amountEdt;
    ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // initialize Razorpay account.
        Checkout checkout = new Checkout();

        // set your id as below
        checkout.setKeyID("rzp_test_UXH4c4TWkxGe9Q");

        // set image
        checkout.setImage(R.drawable.ic_launcher_background);

        // initialize json object
        JSONObject object = new JSONObject();
        try {
            // to put name
            object.put("name", "Hey Colleagues");

            // put description
            object.put("description", "Test payment");

            // to set theme color
            object.put("theme.color", "#25383C");

            // put the currency
            object.put("currency", "INR");

            // put amount
            object.put("amount", "200000");

            // put mobile number
            object.put("prefill.contact", "8700386955");

            // put email
            object.put("prefill.email", "Vanshsaxena36@gmail.com");

            // open razorpay to checkout activity
            checkout.open(PaymentActivity.this, object);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
        animator.start();


    }

    public void onPaymentError(int i, String s) {
        // on payment failed.
        Intent intent = new Intent(PaymentActivity.this, ProductActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }

}