package com.example.employee_managementsystem

import android.app.Activity
import android.app.Application
import android.widget.EditText
import android.widget.Toast

class Validation : Application() {


    //空文字を判定する
    //setErrorメソッドを使用
    /*fun emptyCheck(text:EditText, name:String){
        if(text.toString()==""){
            text.setError(name +"を入力してください")
        }
    }*/

    //Toastを使用
    fun emptyCheck(text: EditText, name: String) {
        if (text.toString() == "") {
            var nameMessage: CharSequence = name + "を入力してください"
            var nameError: Toast = Toast.makeText(this, nameMessage, Toast.LENGTH_LONG)
            nameError.show()
        }
    }


    //桁数(10文字)を判定する
    fun digitsCheck(text: EditText) {
        if (text.length() != 10) {
            text.setError("社員IDは10文字で入力してください")
        }
    }


    //最大桁数を判定する
    fun maxDigitsCheck(text: EditText, num: Int, name: String) {
        if (text.length() > num) {
            text.setError(name + "は" + num + "文字以内で入力してください")
        }
    }


    //重複を判定する
    /*fun duplicationCheck(name:String){

    }*/


    //書式を判定する

    /*fun regexpCheck(text:EditText, name:String, format:String){
        var regex = Regex(format)
        if(!(regex.matches(text.toString()))){
            text.setError(name + "を正しく入力してください")
        }
    }*/

    //社員IDの書式を判定
    /*fun idRegexpCheck(text:EditText){

        }*/

    //所属セクションの書式を判定
    /* fun sectionCheck(value:Int){
         var regex = Regex("^[1-3]$")
         if(!(regex.matches(value.toString()))){

         }
     }*/

    //メールアドレスの書式を判定


    //性別の書式を判定
}