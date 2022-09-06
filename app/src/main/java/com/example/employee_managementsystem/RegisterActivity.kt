package com.example.employee_managementsystem

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.*

class RegisterActivity : AppCompatActivity() {


    private lateinit var inputMethodManager: InputMethodManager
    private lateinit var screen :LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        val main_button : Button = findViewById(R.id.main_button)
        val register_button : Button = findViewById(R.id.register_button)

        main_button.setOnClickListener{
            finish()
        }

         screen = findViewById(R.id.screen)
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        register_button.setOnClickListener() {

            //社員IDのバリデーションチェック
            val employeeId: EditText = findViewById(R.id.editTextEmployeeID)
            val employeeRegex = """^YZ[0-9]{8}$""".toRegex()
            if(emptyCheck(employeeId, "社員ID")){

            } else if (digitsCheck(employeeId)){

            } else if(regexpCheck(employeeId, "社員ID",employeeRegex)){

            }
            /*emptyCheck(employeeId, "社員ID")
            digitsCheck(employeeId)
            regexpCheck(employeeId, "社員ID",employeeRegex)*/


            //社員名(姓)のバリデーションチェック
            val familyName: EditText = findViewById(R.id.editTextFamilyName)
            if(emptyCheck(familyName, "社員名（姓）")){

            } else if(maxDigitsCheck(familyName, 25, "社員名（姓）")){

            }
            /*emptyCheck(familyName, "社員名（姓）")
            maxDigitsCheck(familyName, 25, "社員名（姓）")*/

            //社員名(名)のバリデーションチェック
            val firstName: EditText = findViewById(R.id.editTextFirstName)
            if(emptyCheck(firstName, "社員名（名）")){

            } else if (maxDigitsCheck(firstName, 25, "社員名（名）")){

            }
            /*emptyCheck(firstName, "社員名（名）")
            maxDigitsCheck(firstName, 25, "社員名（名）")*/

            //所属セクションのチェック
            val section: Spinner = findViewById(R.id.spinner)
            val textView: TextView = findViewById(R.id.textViewdebug)
            textView.setText(section.getSelectedItemId().toString())


            //メールアドレスのバリデーションチェック
            val mail: EditText = findViewById(R.id.editTextEmailAddress)
            val mailRegex = """^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+""".toRegex()
            if(emptyCheck(mail, "メールアドレス")){

            } else if(maxDigitsCheck(mail, 256, "メールアドレス")){

            } else if(regexpCheck(mail,"メールアドレス", mailRegex)){

            }
            /*emptyCheck(mail, "メールアドレス")
            maxDigitsCheck(mail, 256, "メールアドレス")
            regexpCheck(mail,"メールアドレス", mailRegex)*/


            //性別のバリデーションチェック
            val radioGroup: RadioGroup = findViewById(R.id.sexRadioGroup)
            val sex: Int = radioGroup.getCheckedRadioButtonId()

            if (sex == -1) {
                /*// 選択されているラジオボタンの取得
                val radioButton: RadioButton = findViewById(sex)

                // ラジオボタンのテキストを取得
                val text: String = radioButton.getText().toString()*/

                Toast.makeText(this, "性別を正しく入力してください", Toast.LENGTH_LONG)

            }
        }
    }

    override fun onTouchEvent(event: MotionEvent):Boolean{
        inputMethodManager.hideSoftInputFromWindow(screen.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS)
        screen.requestFocus()
        return false
    }

    //Toastを使用
    fun emptyCheck(text: EditText, name: String):Boolean {
        if (text.toString() == "") {
            var nameMessage: CharSequence = name + "を入力してください"
            var nameError: Toast = Toast.makeText(this, nameMessage, Toast.LENGTH_LONG)
            nameError.show()
            return true
        }
        return false
    }

    //桁数(10文字)を判定する
    fun digitsCheck(text: EditText) :Boolean{
        if (text.length() != 10) {
            Toast.makeText(this,"社員IDは10文字で入力してください", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

    //最大桁数を判定する
    fun maxDigitsCheck(text: EditText, num: Int, name: String) :Boolean{
        if (text.length() > num) {
            Toast.makeText(this, name + "は" + num + "文字以内で入力してください" , Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

    //書式を判定する
    fun regexpCheck(text:EditText, name:String, format:Regex) :Boolean{
        if (!(format.matches(text.toString()))) {
            Toast.makeText(this, name + "を正しく入力してください", Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }

}