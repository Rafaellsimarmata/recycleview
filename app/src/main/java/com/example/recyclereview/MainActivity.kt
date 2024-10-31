package com.example.recyclereview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFaculty: RecyclerView
    private val list = ArrayList<Faculty>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFaculty = findViewById(R.id.rv_faculty)
        rvFaculty.setHasFixedSize(true)

        list.addAll(getListFaculty())
        showRecyclerList()
    }

    private fun getListFaculty(): ArrayList<Faculty> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDean = resources.getStringArray(R.array.data_dean)
        val listFaculty = ArrayList<Faculty>()
        for (i in dataName.indices) {
            val faculty = Faculty(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataDean[i])
            listFaculty.add(faculty)
        }
        return listFaculty
    }

    private fun showRecyclerList() {
        rvFaculty.layoutManager = LinearLayoutManager(this)
        val listFacultyAdapter = ListFacultyAdapter(list)
        rvFaculty.adapter = listFacultyAdapter

        listFacultyAdapter.setOnItemClickCallback(object: ListFacultyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Faculty) {
                showSelectedFaculty(data)
            }
        })
    }

    private fun showSelectedFaculty(faculty: Faculty) {
        Toast.makeText(this,faculty.name, Toast.LENGTH_SHORT).show()
    }
}