package com.aula.ponto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.aula.ponto.db_service.DBService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.io.print as print1

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        // Iniciando a classe
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Iniciando o DB
        val helper = DBService(applicationContext)
        val db = helper.readableDatabase
        val rs = db.rawQuery("SELECT * from user", null)

        // Iniciando o calendário para pegar as datas.
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        // Lista com os edit_text que estão na tela, para inserir no DB depois.
        val listEditText: MutableList<EditText> = mutableListOf()

        // Lista com as horas que já estão na tela, para inserir no DB depois.
        var listRegisteredHours: MutableList<String> = mutableListOf()

        // Hora - Título
        val linearLayoutH = LinearLayout(this)
        val hourTitle = TextView(this)
        hourTitle.textSize = 20f
        hourTitle.text = getString(R.string.current_hour)
        hourTitle.setPadding(25)
        hourTitle.minWidth = 450
        linearLayoutH.addView(hourTitle)

        // Hora - Atual
        val hourTextView = TextView(this)
        hourTextView.textSize = 20f
        hourTextView.text = "$currentHour:$currentMinute - $currentDay/$currentMonth/$currentYear"
        hourTextView.setPadding(25)
        linearLayoutH.addView(hourTextView)

        linearLayoutVertical.addView(linearLayoutH)



        // Limpando o DB
        // db.delete("user", null, null)

        // Vendo se existe algo no DB
//        val cursor = db.rawQuery("SELECT * FROM user", null)
//        val itemList = mutableListOf<String>()
//        with(cursor) {
//            while (moveToNext()) {
//                val name = getString(getColumnIndexOrThrow("name"))
//                itemList.add(name.toString())
//                print1(name.toString())
//                Toast.makeText(applicationContext, name.toString(), Toast.LENGTH_SHORT).show()
//                println(name.toString())
//            }
//        }
//        cursor.close()



        // Matrícula - Título
        val linearLayoutH1 = LinearLayout(this)
        val matriculaTitle = TextView(this)
        matriculaTitle.textSize = 20f
        matriculaTitle.text = getString(R.string.registration_title)
        matriculaTitle.setPadding(25)
        matriculaTitle.minWidth = 450
        linearLayoutH1.addView(matriculaTitle)

        // Matrícula - Texto
        val matriculaText = TextView(this)
        matriculaText.textSize = 20f
        matriculaText.hint = "12345"
        matriculaText.setPadding(25)
        matriculaText.width = 680
        linearLayoutH1.addView(matriculaText)

        linearLayoutVertical.addView(linearLayoutH1)





        // Nome - Título
        val linearLayoutH3 = LinearLayout(this)
        val nomeTitle = TextView(this)
        nomeTitle.textSize = 20f
        nomeTitle.text = getString(R.string.name_title)
        nomeTitle.setPadding(25)
        nomeTitle.minWidth = 450
        linearLayoutH3.addView(nomeTitle)

        // Nome - Texto
        val nomeText = TextView(this)
        nomeText.textSize = 20f
        nomeText.hint = "Luis Otavio Zimermann"
        nomeText.setPadding(25)
        nomeText.width = 680
        nomeText.minWidth = 450
        linearLayoutH3.addView(nomeText)
        linearLayoutVertical.addView(linearLayoutH3)



        // Departamento - Título
        val linearLayoutH4 = LinearLayout(this)
        val departamentoTitle = TextView(this)
        departamentoTitle.textSize = 20f
        departamentoTitle.text = getString(R.string.department_title)
        departamentoTitle.setPadding(25)
        departamentoTitle.minWidth = 450
        linearLayoutH4.addView(departamentoTitle)

        // Departamento - Texto
        val departamentoText = TextView(this)
        departamentoText.textSize = 20f
        departamentoText.hint = "Dados"
        departamentoText.setPadding(25)
        departamentoText.width = 680
        linearLayoutH4.addView(departamentoText)

        linearLayoutVertical.addView(linearLayoutH4)





        // Cargo - Título
        val linearLayoutH5 = LinearLayout(this)
        val cargoTitle = TextView(this)
        cargoTitle.textSize = 20f
        cargoTitle.text = getString(R.string.role_title)
        cargoTitle.setPadding(25)
        cargoTitle.minWidth = 450
        linearLayoutH5.addView(cargoTitle)

        // Cargo - Texto
        val cargoText = TextView(this)
        cargoText.textSize = 20f
        cargoText.hint = "DBA"
        cargoText.setPadding(25)
        cargoText.width = 680
        linearLayoutH5.addView(cargoText)

        linearLayoutVertical.addView(linearLayoutH5)

        // Campos das horas.
        for (i in 1..8) {
            val horaCalculada: Int = (17 - i)

            if (currentHour >= horaCalculada) {

                if (horaCalculada > 12){
                    val linearLayoutH1 = LinearLayout(this)

                    val newTextView = TextView(this)
                    newTextView.textSize = 20f
                    newTextView.text = "$horaCalculada H"
                    newTextView.setPadding(25)
                    linearLayoutH1.addView(newTextView)

                    val newEditText = EditText(this)
                    newEditText.textSize = 20f
                    newEditText.hint = "$horaCalculada H"
                    newEditText.setPadding(25)
                    newEditText.width = 680
                    linearLayoutH1.addView(newEditText)

                    linearLayoutVertical.addView(linearLayoutH1)

                    listEditText.add(newEditText)
                }

                else {
                    val linearLayoutH1 = LinearLayout(this)

                    val tvdynamic = TextView(this)
                    tvdynamic.textSize = 20f
                    tvdynamic.text = "${horaCalculada-1} H"
                    tvdynamic.setPadding(25)
                    linearLayoutH1.addView(tvdynamic)

                    val etdynamic = EditText(this)
                    etdynamic.textSize = 20f
                    etdynamic.hint = "${horaCalculada-1} H"
                    etdynamic.setPadding(25)
                    etdynamic.width = 680
                    linearLayoutH1.addView(etdynamic)

                    linearLayoutVertical.addView(linearLayoutH1)
                }
            }
        }

        // Quando clica no botão
        id_save_btn.setOnClickListener {

            println("AGORA É $currentHour:$currentMinute - $currentDay/$currentMonth/$currentYear")

//            val cv = ContentValues()
//            cv.put("activity", editText8h.text.toString())
//            cv.put("", editText8h.text.toString())
//            cv.put("activity", editText8h.text.toString())
//            db.insert("activity", null, cv)

            // Limpando o DB
            // db.delete("activity", null, null)

            Toast.makeText(applicationContext, "Atividades salvas.", Toast.LENGTH_SHORT).show()


        }

        // Fechando a conexão
        rs.close()
    }
}