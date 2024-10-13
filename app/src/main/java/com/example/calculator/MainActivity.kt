package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var operationVal = "0"
    var resultVal = ""
    var operatorSign = ""
    var savedVal = "0"
    lateinit var operationText: TextView
    lateinit var resultText: TextView
    lateinit var operatorSignText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        operationText = findViewById(R.id.operationsView)
        resultText = findViewById(R.id.resultsView)
        operatorSignText = findViewById(R.id.operatorSign)
        setValues()

        val buttonSignChange: Button = findViewById(R.id.signChange)
        buttonSignChange.setOnClickListener {
            if(operationVal.toDouble() != 0.0){
                var res = operationVal.toDouble()*-1
                operationVal = res.toString()
                setValues()
            }
        }

        val buttonMS: Button = findViewById(R.id.btnMS) as Button
        buttonMS.setOnClickListener {
            savedVal = operationVal
        }

        val buttonMR: Button = findViewById(R.id.btnMR) as Button
        buttonMR.setOnClickListener {
            operationVal = savedVal
            setValues()
        }

        val buttonMC: Button = findViewById(R.id.btnMC) as Button
        buttonMC.setOnClickListener {
            savedVal = "0"
        }

        val buttonDel: Button = findViewById(R.id.btnDel) as Button
        buttonDel.setOnClickListener{
            operationVal = "0"
            resultVal = ""
            operatorSign = ""
            setValues()
        }

        val buttonBack: Button = findViewById(R.id.backspace) as Button
        buttonBack.setOnClickListener{
            operationVal = operationVal.dropLast(1)
            if(operationVal.length < 1){
                operationVal = "0"
            }
            setValues()
        }

        val buttonSum: Button = findViewById(R.id.btnSum) as Button
        buttonSum.setOnClickListener {
            if(resultVal == "") {
                resultVal = operationVal
            } else {
                var res = calculation()
                resultVal = res.toString()
            }
            operatorSign = "+"
            operationVal = "0"
            setValues()
        }

        val buttonSub: Button = findViewById(R.id.btnSub) as Button
        buttonSub.setOnClickListener {
            if(resultVal == "") {
                resultVal = operationVal
            } else {
                var res = calculation()
                resultVal = res.toString()
            }
            operatorSign = "-"
            operationVal = "0"
            setValues()
        }

        val buttonMult: Button = findViewById(R.id.btnMult) as Button
        buttonMult.setOnClickListener {
            if(resultVal == "") {
                resultVal = operationVal
            } else {
                var res = calculation()
                resultVal = res.toString()
            }
            operatorSign = "*"
            operationVal = "0"
            setValues()
        }

        val buttonDiv: Button = findViewById(R.id.btnDiv) as Button
        buttonDiv.setOnClickListener {
            if(resultVal == "") {
                resultVal = operationVal
            } else {
                var res = calculation()
                resultVal = res.toString()
            }
            operatorSign = "/"
            operationVal = "0"
            setValues()
        }

        val buttonRes: Button = findViewById(R.id.btnResult) as Button
        buttonRes.setOnClickListener {
            operationVal = calculation().toString()
            resultVal = ""
            operatorSign = ""
            setValues()
        }

        val buttonComma: Button = findViewById(R.id.btnComma)
        buttonComma.setOnClickListener {
            operationVal += "."
            setValues()
        }

        val button1: Button = findViewById(R.id.btn1) as Button
        button1.setOnClickListener{
            addVal("1")
        }

        val button2: Button = findViewById(R.id.btn2) as Button
        button2.setOnClickListener{
            addVal("2")
        }

        val button3: Button = findViewById(R.id.btn3) as Button
        button3.setOnClickListener{
            addVal("3")
        }

        val button4: Button = findViewById(R.id.btn4) as Button
        button4.setOnClickListener{
            addVal("4")
        }

        val button5: Button = findViewById(R.id.btn5) as Button
        button5.setOnClickListener{
            addVal("5")
        }

        val button6: Button = findViewById(R.id.btn6) as Button
        button6.setOnClickListener{
            addVal("6")
        }

        val button7: Button = findViewById(R.id.btn7) as Button
        button7.setOnClickListener{
            addVal("7")
        }

        val button8: Button = findViewById(R.id.btn8) as Button
        button8.setOnClickListener{
            addVal("8")
        }

        val button9: Button = findViewById(R.id.btn9) as Button
        button9.setOnClickListener{
            addVal("9")
        }

        val button0: Button = findViewById(R.id.btn0) as Button
        button0.setOnClickListener{
            addVal("0")
        }
    }

    fun setValues(){
        operationText.text = operationVal.toString()
        resultText.text = resultVal.toString()
        operatorSignText.text = operatorSign.toString()
    }

    fun addVal(value: String){
        if(operationVal.length < 10){
            if(operationVal.toDouble() != 0.0 || operationVal.contains(".")){
                operationVal += value
            } else {
                operationVal = value
            }
            setValues()
        }
    }

    fun calculation(): Double {
        var res = 0.0
        if (operatorSign == "+"){
            res = resultVal.toDouble() + operationVal.toDouble()
        } else if(operatorSign == "-"){
            res = resultVal.toDouble() - operationVal.toDouble()
        } else if(operatorSign == "*"){
            res = resultVal.toDouble() * operationVal.toDouble()
        } else if(operatorSign == "/"){
            if(operationVal.toDouble() == 0.0){
                res = 0.0
            } else{
                res = resultVal.toDouble() / operationVal.toDouble()
            }
        }
        return res
    }
}