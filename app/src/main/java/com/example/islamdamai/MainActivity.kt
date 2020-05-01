package com.example.islamdamai

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.islamdamai.jaringan.ClientAsyncTask
import com.example.islamdamai.model.DaftarKota
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var Hari: TextView? = null
    private var Jam: TextView? = null
    private lateinit var asmaul: CardView
    private lateinit var kisah: CardView
    private lateinit var ibadah: CardView
    private lateinit var tentang: CardView
    var handler: Handler? = null
    var runnable: Runnable? = null
    private var listDaftarKota: MutableList<DaftarKota>? = null
    private var mDaftarKotaAdapter: ArrayAdapter<DaftarKota>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Hari = findViewById(R.id.hari1)
        Jam = findViewById(R.id.jam1)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        asmaul = findViewById(R.id.asmaul)
        kisah = findViewById(R.id.kisah12)
        ibadah = findViewById(R.id.ibadah_ramadhan)
        tentang = findViewById(R.id.tentang2)

        ibadah.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

        tentang.setOnClickListener {
            startActivity(Intent(this, TentangActivity::class.java))
        }

        kisah.setOnClickListener {
            startActivity(Intent(this, KisahActivity::class.java))
        }
        asmaul.setOnClickListener {
            startActivity(Intent(this, AsmaulActivity::class.java))
        }

        listDaftarKota = ArrayList()
        mDaftarKotaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,

                listDaftarKota as ArrayList<DaftarKota>
        )
        mDaftarKotaAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        kotaIni.adapter = mDaftarKotaAdapter
        kotaIni.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val kotaIni = mDaftarKotaAdapter!!.getItem(position)
                if (kotaIni != null) {
                    loadJadwal(kotaIni.id)

                }
            }

        }
        loadKota()
        MenujuRamadhan()


    }

    private fun loadJadwal(id: Int?) {
        try {
            val idKota = id.toString()
            val kuren = SimpleDateFormat("yyyy-MM-dd")
            val tanggal = kuren.format(Date())
            val link = "https://api.banghasan.com/sholat/format/json/jadwal/kota/$idKota/tanggal/$tanggal"
            val uy = ClientAsyncTask(this, object : ClientAsyncTask.OnPostExecuteListener {
                override fun onPostExecute(result: String) {

                    Log.d("JadwalData", result)
                    try {
                        val jsonObj = JSONObject(result)
                        val objJadwal = jsonObj.getJSONObject("jadwal")
                        val obData = objJadwal.getJSONObject("data")


                        isya.text = obData.getString("isya")
                        subuh.text = obData.getString("subuh")
                        zuhur.text = obData.getString("dzuhur")
                        ashar.text = obData.getString("ashar")
                        maghrib.text = obData.getString("maghrib")


                        Log.d("dataJadwal", obData.toString())

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

            })
            uy.execute(link)
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }


    private fun MenujuRamadhan() {
        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                handler!!.postDelayed(this, 1000)
                try {
                    @SuppressLint("SimpleDateFormat") val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
                    val ramdhan = simpleDateFormat.parse("2020-5-24")
                    val date = Date()
                    if (!date.after(ramdhan)) {
                        var diff = ramdhan.time - date.time
                        val days = diff / (24 * 60 * 60 * 1000)
                        diff -= days * (24 * 60 * 60 * 1000)
                        val hours = diff / (60 * 60 * 1000)
                        Hari!!.text = "" + String.format("%02d", days)
                        Jam!!.text = "" + String.format("%02d", hours)
                    } else {
                        //hilang setelah selesai
                        menuViewGone()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        handler!!.postDelayed(runnable, 1 * 1000.toLong())
    }

    private fun menuViewGone() {
        findViewById<View>(R.id.kl).visibility = View.GONE
    }

    private fun loadKota() {
        try {
            val url = "https://api.banghasan.com/sholat/format/json/kota"
            val task = ClientAsyncTask(this, object : ClientAsyncTask.OnPostExecuteListener {
                override fun onPostExecute(result: String) {

                    Log.d("KotaData", result)
                    try {
                        val jsonObj = JSONObject(result)
                        val jsonArray = jsonObj.getJSONArray("kota")
                        var daftarKota: DaftarKota?
                        for (i in 0 until jsonArray.length()) {
                            val obj = jsonArray.getJSONObject(i)
                            daftarKota = DaftarKota()
                            daftarKota.id = obj.getInt("id")
                            daftarKota.nama = obj.getString("nama")
                            listDaftarKota!!.add(daftarKota)
                        }
                        mDaftarKotaAdapter!!.notifyDataSetChanged()

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

            })
            task.execute(url)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}