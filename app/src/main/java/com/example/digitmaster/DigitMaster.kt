package com.example.digitmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.digitmaster.databinding.ActivityDigitMasterBinding
import com.google.android.material.snackbar.Snackbar
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class DigitMaster : AppCompatActivity() {

    lateinit var binding: ActivityDigitMasterBinding
    private var data = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digit_master)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_digit_master)

        binding.apply {

            btn0.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "0"
            }
            btn1.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "1"


            }

            btn2.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "2"


            }

            btn3.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "3"


            }

            btn4.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "4"


            }

            btn5.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "5"


            }

            btn6.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "6"


            }

            btn7.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "7"


            }

            btn8.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "8"


            }

            btn9.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = data + "9"


            }

            btnAc.setOnClickListener {

                inputTxt.text = ""
                outputTxt.text = ""

            }

            btnDot.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data."


            }

            btnPlus.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data+"

            }

            btnMinus.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data-"

            }

            btnModule.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data%"

            }

            btnMultiplication.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data×"

            }
            btnDivision.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data÷"


            }

            binding.btnPi.setOnClickListener {

                data = inputTxt.text.toString()
                inputTxt.text = "$data"+"π"


            }


            btnEqual.setOnClickListener {

                if (inputTxt.text == "") {

                } else {

                    try {
                        data = inputTxt.text.toString()

                        data = data!!.replace("×".toRegex(), "*")
                        data = data!!.replace("%".toRegex(), "/100")
                        data = data!!.replace("÷".toRegex(), "/")
                        data = data!!.replace("π".toRegex(), "3.14")

                        val rhino: Context = Context.enter()
                        rhino.optimizationLevel = -1

                        var finalResult = ""

                        val scriptable: Scriptable = rhino.initStandardObjects()
                        finalResult =
                            rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString()

                        outputTxt.text = finalResult

                    } catch (e: Exception) {

                        Snackbar.make(it, "Wrong Input", Snackbar.LENGTH_LONG).show()

                    }

                }


            }


        }


    }
    }
