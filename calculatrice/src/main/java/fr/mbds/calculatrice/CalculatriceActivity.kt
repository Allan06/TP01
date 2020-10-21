package fr.mbds.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculatriceActivity : AppCompatActivity() {

    lateinit var expression:TextView
    lateinit var resultat:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculatrice)

        expression = findViewById<TextView>(R.id.expression)
        resultat = findViewById<TextView>(R.id.resultat)

        // La meilleure partie du code
        val b0 = findViewById<Button>(R.id.b0)
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        val b5 = findViewById<Button>(R.id.b5)
        val b6 = findViewById<Button>(R.id.b6)
        val b7 = findViewById<Button>(R.id.b7)
        val b8 = findViewById<Button>(R.id.b8)
        val b9 = findViewById<Button>(R.id.b9)

        val begale = findViewById<Button>(R.id.b10)
        val bplus = findViewById<Button>(R.id.b11)
        val bmoins = findViewById<Button>(R.id.b12)
        val bmult = findViewById<Button>(R.id.b13)
        val bdiv = findViewById<Button>(R.id.b14)

        // Je suis un DEVELOPPEUR
        b0.setOnClickListener{
            expression.append(b0.text.toString())
        }

        b1.setOnClickListener{
            expression.append(b1.text.toString())
        }

        b2.setOnClickListener{
            expression.append(b2.text.toString())
        }
        b3.setOnClickListener{
            expression.append(b3.text.toString())
        }
        b4.setOnClickListener{
            expression.append(b4.text.toString())
        }
        b5.setOnClickListener{
            expression.append(b5.text.toString())
        }
        b6.setOnClickListener{
            expression.append(b6.text.toString())
        }
        b7.setOnClickListener{
            expression.append(b7.text.toString())
        }

        b8.setOnClickListener{
            expression.append(b8.text.toString())
        }

        b9.setOnClickListener{
            expression.append(b9.text.toString())
        }

        begale.setOnClickListener{
            resultat.text = ""
            calculer()
        }

        bplus.setOnClickListener{
            expression.append(bplus.text.toString())
        }

        bmoins.setOnClickListener{
            expression.append(bmoins.text.toString())
        }

        bmult.setOnClickListener{
            expression.append(bmult.text.toString())
        }

        bdiv.setOnClickListener{
            expression.append(bdiv.text.toString())
        }
    }


    fun estOperateur(operateur: Char):Boolean{
        return operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/'
    }

    fun operation(op1:Int, op2:Int, operateur:Char):Int {
        return when (operateur) {
            '+' -> op1 + op2
            '-' -> op1 - op2
            'x' -> op1 * op2
            '/' -> op1 / op2

            else -> -1
        }
    }

    fun calculer(){

        var car:Char
        var nombre1: String = ""
        var nombre2: String = ""
        var ope: Char = ' '
        var c:Int = 0
        while (c < expression.length()){
            car = expression.text.toString()[c]

            if (car.isDigit()) {
                while ( c < expression.length() && expression.text.toString()[c].isDigit()) {
                    nombre1 += expression.text.toString()[c]
                    c++
                }
            }

            else if (estOperateur(car)) {
                ope = car
                nombre2 = nombre1
                nombre1 = ""
                c++
            }
        }

        resultat.append(operation(nombre1.toInt(), nombre2.toInt(), ope).toString())
        //expression.text = ""
    }
}