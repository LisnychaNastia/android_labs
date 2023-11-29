package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.adapter.UserAdapter
import com.example.recyclerviewdemo.databinding.ActivityMainBinding
import com.example.recyclerviewdemo.model.User

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        recyclerView = binding.rvUser
        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter
        userAdapter.setList(createUsers())
    }

    fun createUsers() : List<User>{
        val userList = ArrayList<User>()
        userList.add(User("Ivan","Drogobich"))
        userList.add(User("Boris","Nenchuk"))
        userList.add(User("Bogdan","Lopin"))
        userList.add(User("Anna","Krivorka"))
        userList.add(User("Nastya","Lisnycha"))

        return userList
    }


}