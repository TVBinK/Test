package com.bink.layouts


import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var userName: EditText
    lateinit var button: Button
    lateinit var result: TextView
    lateinit var image: ImageView
    lateinit var boxMale: CheckBox
    lateinit var boxFemale: CheckBox
    lateinit var spinner: Spinner
    lateinit var showToast: Button
    lateinit var showSnackbar: Button
    lateinit var myLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.editTextuserName)
        button = findViewById(R.id.buttonRegister)
        result = findViewById(R.id.textViewResult)
        image = findViewById(R.id.imageViewRegister)
        boxMale = findViewById(R.id.checkBoxMale)
        boxFemale = findViewById(R.id.checkBoxFemale)
        spinner = findViewById(R.id.spinner)
        showToast = findViewById(R.id.buttonToastMessage)
        myLayout = findViewById(R.id.myLayout)
        showSnackbar = findViewById(R.id.buttonSnackbarMessage)

        // Set Gender
        var Gender: String? = null


        boxMale.setOnClickListener{
            if(boxMale.isChecked){
                Gender = "Male"
                boxFemale.isChecked = false
            }
        }
        boxFemale.setOnClickListener{
            if(boxFemale.isChecked){
                Gender = "Female"
                boxMale.isChecked = false
            }
        }

//        // Set Spinner
//
//        var arrayAdapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.countries,
//            android.R.layout.simple_spinner_item
//        )
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = arrayAdapter
//
//        spinner.onItemSelectedListener = this

       // button main
        button.setOnClickListener {

             var name: String = userName.text.toString()
             //result.setText("Result: "+name+" "+Gender)
             if(boxMale.isChecked){
                 image.setImageResource(R.drawable.second)
             }
            else  {
                image.setImageResource(R.drawable.first)
             }

        }
        // button toast message
        showToast.setOnClickListener{
           makeText(applicationContext,"This is Toast Message", LENGTH_LONG).show()
        }
        // button snackbar message
        showSnackbar.setOnClickListener {
               Snackbar
                   .make(myLayout, "This is Snackbar Message", Snackbar.LENGTH_INDEFINITE)
                   .setAction("Close",View.OnClickListener {  }).show()
        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var countries: String = parent?.getItemAtPosition(position).toString()
        result.text = countries
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}