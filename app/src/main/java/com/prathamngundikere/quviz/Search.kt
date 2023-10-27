package com.prathamngundikere.quviz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamngundikere.quviz.adapter.SearchAdapter
import com.prathamngundikere.quviz.datamodel.Topic
import com.prathamngundikere.quviz.util.searchlist
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.Locale
import kotlin.coroutines.coroutineContext

class Search : Fragment(R.layout.fragment_search) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var mList: List<Topic>
    private lateinit var adapter: SearchAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.searchview_recyclerview)
        searchView = view.findViewById(R.id.searchview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        mList = searchlist()
        adapter = SearchAdapter(mList)
        recyclerView.adapter = adapter
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(p0)
                return true
            }
        })
    }
    private fun filterList(query : String?){
        if (query != null){
            val filterledList = mutableListOf<Topic>()
            for (i in mList){
                if(i.name.toLowerCase(Locale.ROOT).contains(query)){
                    filterledList.add(i)
                }
            }
            if(filterledList.isEmpty()){
                Toast.makeText(context, "Data not found", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filterledList)
            }
        }
    }
}