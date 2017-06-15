//package ui
//
//import android.app.DatePickerDialog
//import android.arch.lifecycle.ViewModelProviders
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.view.View
//import android.widget.DatePicker
//import android.widget.EditText
//import android.widget.Toast
//
//import test.com.componentapp.R
//import kotlinx.android.synthetic.main.activity_add.*
//import java.util.Calendar
//import java.util.Date
//
//class AddActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
//
//    private var date: Date? = null
//    private var datePickerDialog: DatePickerDialog? = null
//    private var calendar: Calendar? = null
//
//    private var itemEditText: EditText? = null
//    private var nameEditText: EditText? = null
//
//    private var addBorrowViewModel: AddBorrowViewModel? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add)
//        calendar = Calendar.getInstance()
//        addBorrowViewModel = ViewModelProviders.of(this).get(AddBorrowViewModel::class.java!!)
//        datePickerDialog = DatePickerDialog(this, this@AddActivity, calendar!!.get(Calendar.YEAR), calendar!!.get(Calendar.MONTH), calendar!!.get(Calendar.DAY_OF_MONTH))
//        addBtn.setOnClickListener(View.OnClickListener {
//            if (itemEditText!!.text == null || nameEditText!!.text == null || date == null)
//                Toast.makeText(this@AddActivity, "Missing fields", Toast.LENGTH_SHORT).show()
//            else {
//                val addBorrow: Any = addBorrowViewModel!!.addBorrow(BorrowModel(0,
//                        itemEditText!!.text.toString(),
//                        nameEditText!!.text.toString(),
//                        date
//                ))
//                finish()
//            }
//        })
//        dateButton.setOnClickListener { datePickerDialog!!.show() }
//    }
//
//
//    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
//        calendar!!.set(Calendar.YEAR, year)
//        calendar!!.set(Calendar.MONTH, month)
//        calendar!!.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//        date = calendar!!.time
//
//    }
//}
