package astorga.jonathan.examenc1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var cantidad: Int = 0
    var producto: String = ""
    var precio: Double = 0.0
    var i = 0


    /*var subTotal = findViewById<TextView>(R.id.txtSTFinal)
    var IVA = findViewById<TextView>(R.id.txtIVATotal)
    var total = findViewById<TextView>(R.id.txtCantTotal)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val agregar = findViewById<Button>(R.id.btnAgregar)
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val limpiar = findViewById<Button>(R.id.btnLimpiar)

        agregar.setOnClickListener{
            agregar()
            reiniciarValores()

        }
        calcular.setOnClickListener{
            calcular()
            reiniciarValores()
            calcular.visibility = View.INVISIBLE
            limpiar.visibility = View.VISIBLE
        }

        limpiar.setOnClickListener{
            reiniciarValores()
            limpiar.visibility = View.INVISIBLE
            calcular.visibility = View.INVISIBLE
        }


    }

    fun agregar(){
        cantidad = findViewById<EditText>(R.id.edtCantidad).toString().toInt()
        producto = findViewById<EditText>(R.id.edtProducto).toString()
        precio = findViewById<EditText>(R.id.edtPrecio).toString().toDouble()

        if (cantidad < 0 && cantidad != null && producto.isBlank() && precio < 0.0 && precio != null && i < 3){
            when(i){
                0 -> {
                    var num1 = findViewById<TextView>(R.id.txtNum1)
                    num1.setText("1")
                    var prod1 = findViewById<TextView>(R.id.txtProd1)
                    prod1.setText(producto)
                    var precio1 = findViewById<TextView>(R.id.txtPrecio1)
                    precio1.setText((cantidad*precio).toString())
                    i++
                }
                1 -> {
                    var num2 = findViewById<TextView>(R.id.txtNum2)
                    num2.setText("2")
                    var prod2 = findViewById<TextView>(R.id.txtProd2)
                    prod2.setText(producto)
                    var precio2 = findViewById<TextView>(R.id.txtPrecio2)
                    precio2.setText((cantidad*precio).toString())
                    i++
                }
                2 -> {
                    var num3 = findViewById<TextView>(R.id.txtNum3)
                    num3.setText("3")
                    var prod3 = findViewById<TextView>(R.id.txtProd3)
                    prod3.setText(producto)
                    var precio3 = findViewById<TextView>(R.id.txtPrecio3)
                    precio3.setText((cantidad*precio).toString())
                    i++
                }
            }
        }

    }

    fun calcular(){
        var subTotal = findViewById<TextView>(R.id.txtSTFinal)
        var IVA = findViewById<TextView>(R.id.txtIVATotal)
        var total = findViewById<TextView>(R.id.txtCantTotal)

        var pre1: Double = findViewById<TextView>(R.id.txtPrecio1).toString().toDouble()
        var pre2: Double = findViewById<TextView>(R.id.txtPrecio2).toString().toDouble()
        var pre3: Double = findViewById<TextView>(R.id.txtPrecio3).toString().toDouble()

        if (pre1 != 0.0 && pre2 != 0.0 && pre3 != 0.0){
            subTotal.setText((pre3 + pre1 + pre2).toString())
            IVA.setText(((16*subTotal.text.toString().toDouble())/100).toString())
            total.setText((subTotal.text.toString().toDouble()+IVA.text.toString().toDouble()).toString())

        }
    }

    fun reiniciarValores(){
        cantidad = 0
        producto = ""
        precio = 0.0
    }
}