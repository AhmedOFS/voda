package com.example.voda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var airlineutil : AirlineUtil = AirlineUtil()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        airlineutil.loadValues(airlineutil.getRetrofitClient())




        var rec = findViewById<RecyclerView>(R.id.rec)

        rec.layoutManager = LinearLayoutManager(this)
var adapter = RecViewAdapter(this, airlineutil.Airlines)
        rec.adapter = adapter

      var  addAirLine = findViewById<FloatingActionButton>(R.id.add)
     val param=   addAirLine.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0,0,100,100)

        val dialog = BottomSheetDialog(this)
        addAirLine.setOnClickListener {

            // on below line we are creating a new bottom sheet dialog.


            // on below line we are inflating a layout file which we have created.
            val viewx = layoutInflater.inflate(R.layout.bottomsheet, null)

var dismiss = viewx.findViewById<Button>(R.id.btns)

           // dialog.setCancelable(false)
            dismiss.setOnClickListener {
                // on below line we are calling a dismiss
                // method to close our dialog.
                dialog.dismiss()
            }


            // on below line we are setting
            // content view to our view.
            dialog.setContentView(viewx)

            // on below line we are calling
            // a show method to display a dialog.
            dialog.show()




        }





var search = findViewById<Button>(R.id.go)
        var text = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edit_text)
        search.setOnClickListener{
            var result : MutableList<Airline> = mutableListOf()
         var query=   text.text.toString()
            for(Airline in airlineutil.Airlines){

                if(Airline.name.lowercase().contains(query.lowercase())){
                    result.add(Airline)

                }
            }

            adapter.mList=result
            adapter.notifyDataSetChanged()

        }




    }
}