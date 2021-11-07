package com.sonu.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var lastNumber=false
    var lastDot=false
    var checkMinus=0
    var checkOtherThanMinus=false
    var opera="0"

    lateinit var txtResult:TextView
    lateinit var btnOne:Button
    lateinit var btnTwo:Button
    lateinit var btnThree:Button
    lateinit var btnDivide:Button
    lateinit var btnFour:Button
    lateinit var btnFive:Button
    lateinit var btnSix:Button
    lateinit var btnMulti:Button
    lateinit var btnEight:Button
    lateinit var btnNine:Button
    lateinit var btnSeven:Button
    lateinit var btnSub:Button
    lateinit var btnZero:Button
    lateinit var btnClr:Button
    lateinit var btnAdd:Button
    lateinit var btnDot:Button
    lateinit var btnEqual:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult=findViewById(R.id.txtResult)
        btnOne=findViewById(R.id.btnOne)
        btnTwo=findViewById(R.id.btnTwo)
        btnThree=findViewById(R.id.btnThree)
        btnDivide=findViewById(R.id.btnDivide)
        btnFour=findViewById(R.id.btnFour)
        btnFive=findViewById(R.id.btnFive)
        btnSix=findViewById(R.id.btnSix)
        btnMulti=findViewById(R.id.btnMulti)
        btnSeven=findViewById(R.id.btnSeven)
        btnEight=findViewById(R.id.btnEight)
        btnNine=findViewById(R.id.btnNine)
        btnSub=findViewById(R.id.btnSub)
        btnZero=findViewById(R.id.btnZero)
        btnClr=findViewById(R.id.btnCLR)
        btnAdd=findViewById(R.id.btnAdd)
        btnDot=findViewById(R.id.btnDot)
        btnEqual=findViewById(R.id.btnEqual)
        btnOne.setOnClickListener {
            txtResult.append((it as  Button).text)
            lastNumber=true

        }
        btnTwo.setOnClickListener {
            lastNumber=true
            txtResult.append("2")
        }
        btnThree.setOnClickListener {
            txtResult.append("3")
            lastNumber=true
        }
        btnFour.setOnClickListener {
            txtResult.append("4")
            lastNumber=true
        }
        btnDivide.setOnClickListener {
            if(lastNumber && !checkOtherThanMinus){
                txtResult.append("/")
                checkOtherThanMinus=true
            }
            lastDot=false
            lastNumber=false

        }
        btnFive.setOnClickListener {
            txtResult.append("5")
            lastNumber=true
        }
        btnSix.setOnClickListener {
            txtResult.append("6")
            lastNumber=true
        }
        btnSeven.setOnClickListener {
            txtResult.append("7")
            lastNumber=true
        }
        btnEight.setOnClickListener {
            txtResult.append("8")
            lastNumber=true
        }
        btnNine.setOnClickListener {
            txtResult.append("9")
            lastNumber=true
        }
        btnMulti.setOnClickListener {
            if(lastNumber && !checkOtherThanMinus){
                txtResult.append("*")
                checkOtherThanMinus=true
            }

            lastDot=false
            lastNumber=false
        }
        btnSub.setOnClickListener {
            if(!checkOtherThanMinus&&lastNumber){
                txtResult.append("-")
                checkMinus++
                lastDot=false
                lastNumber=false
                checkOtherThanMinus=true
            }



        }
        btnAdd.setOnClickListener {
            opera="+"
            if(lastNumber && !checkOtherThanMinus){
                txtResult.append("+")
                checkOtherThanMinus=true
            }

            //txtResult.append("+")
            lastDot=false
            lastNumber=false
        }
        btnEqual.setOnClickListener {
            if(lastNumber){
                var result:String=txtResult.text.toString()
                try{
                    if(result.contains("-")){
                        val splitvalue=result.split("-")
                        var num1=splitvalue[0]
                        var num3=splitvalue[1]
                        txtResult.text=(num1.toDouble()-num3.toDouble()).toString()
                    }
                    else if(result.contains("+")){
                        val splitvalue=result.split("+")
                        var num1=splitvalue[0]
                        var num3=splitvalue[1]
                        txtResult.text=(num1.toDouble()+num3.toDouble()).toString()
                    }
                    else if(result.contains("*")){
                        val splitvalue=result.split("*")
                        var num1=splitvalue[0]
                        var num3=splitvalue[1]
                        txtResult.text=(num1.toDouble()*num3.toDouble()).toString()
                    }
                    else if(result.contains("/")){
                        val splitvalue=result.split("*")
                        var num1=splitvalue[0]
                        var num3=splitvalue[1]
                        txtResult.text=(num1.toDouble()/num3.toDouble()).toString()
                    }
                    else{
                        Toast.makeText(this, "Please Enter Digit Carefully", Toast.LENGTH_SHORT).show()
                    }

                }
                catch (e:Exception){
                    Toast.makeText(this, "Please Enter Digit Carefully", Toast.LENGTH_SHORT).show()
                }
                finally {
                    lastNumber=false
                    lastDot=false
                    checkOtherThanMinus=false
                    checkMinus=0
                    opera="0"


                }
            }
            //txtResult.append("=")

        }
        btnDot.setOnClickListener {
            if(lastNumber && !lastDot) {
                txtResult.append(".")
                lastDot=true
                lastNumber=false
            }
        }
        btnClr.setOnClickListener {
            txtResult.text=""
            lastDot=false
            lastNumber=false
            checkMinus=0
            checkOtherThanMinus=false
            //txtResult.append("clr")
        }
        btnZero.setOnClickListener {
            txtResult.append("0")
            lastNumber=true
        }

    }
}