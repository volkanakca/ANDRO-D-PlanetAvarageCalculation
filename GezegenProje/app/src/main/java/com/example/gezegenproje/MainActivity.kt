package com.example.gezegenproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import java.math.BigInteger
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val KILO_To_POUND=2.2045
    val MARS=0.38
    val VENUS=0.91
    val JUPITER=2.34
    val POUND_TO_KILO=0.453592

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cbVenus.setOnClickListener(this)
        cbMars.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)





    }
    fun kiloToPound(kilo:Double):Double{
        return kilo*KILO_To_POUND

    }
    fun poundToKilo(pound:Double):Double{
        return pound*POUND_TO_KILO
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean= v.isChecked
        var kullaniciKilo=edtKilo.text.toString().toDouble()
        var kullaniciPound=kiloToPound((kullaniciKilo))

        if(!TextUtils.isEmpty(edtKilo.text.toString())){
            when(v.id){
                R.id.cbMars-> if(isChecked ){
                    cbJupiter.isChecked=false
                    cbVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.cbVenus-> if(isChecked ){
                    cbJupiter.isChecked=false
                    cbMars.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.cbJupiter-> if(isChecked){
                    cbMars.isChecked=false
                    cbVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
            }
        }


    }
    fun hesaplaAgirlikPound(pound:Double,checkBox:CheckBox){
        var sonuc: Double=0.0
        when(checkBox.id){
            R.id.cbMars->sonuc=pound*MARS
            R.id.cbJupiter->sonuc=pound*JUPITER
            R.id.cbVenus->sonuc=pound*VENUS
            else->sonuc=0.0

        }
        var sonucTokilo=poundToKilo(sonuc)
        tvSonuc.text=sonucTokilo.toString()

    }
}