package com.example.stock_market_prediction_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

public class MainActivity extends AppCompatActivity {

    EditText stockSymbolEditText, dateEditText;
    TextView resultsTextView;

    static {
        System.loadLibrary("tensorflow_inference");
    }
    private static  final String MODEL_FILE = "file:///android_asset/optimized_stock_prediction.pb";
    private static  final String INPUT_NODE = "x_input";
    private static  final int[] INPUT_SHAPE = {1, 5};
    private static  final String OUTPUT_NODE = "y_output";
    private TensorFlowInferenceInterface inferenceInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stockSymbolEditText = findViewById(R.id.stock_symbol_edit_text);
        dateEditText = findViewById(R.id.date_edit_text);
        resultsTextView = findViewById(R.id.text_view);

        inferenceInterface = new TensorFlowInferenceInterface();
        inferenceInterface.initializeTensorFlow(getAssets(), MODEL_FILE);
    }

    public void predictAction(View view) {

    }




}