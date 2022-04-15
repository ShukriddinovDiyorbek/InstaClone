package fragments

import adapter.FavoriteAdapter
import adapter.HomeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import model.Post

class FavoriteFragment : Fragment() {
    lateinit var root: View
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_favorite, container, false)
        initViews()
        return root
    }

    private fun initViews() {
        recyclerView = root.findViewById(R.id.recyclerFavorite)
        recyclerView.layoutManager = GridLayoutManager(activity,1)

        refreshAdapter(loadPosts())
    }
    private fun refreshAdapter(items: ArrayList<Post>) {
        val adapter = FavoriteAdapter(this,items)
        recyclerView.adapter = adapter

    }

    private fun loadPosts(): ArrayList<Post> {
        val items = ArrayList<Post>()
        items.add(Post("Here we go","https://images.unsplash.com/photo-1518684079-3c830dcef090?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        items.add(Post("Here we go","https://images.unsplash.com/photo-1541432901042-2d8bd64b4a9b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=834&q=80"))
        items.add(Post("Here we go","https://images.unsplash.com/photo-1457885208630-7f09c8b8ba2b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=521&q=80"))
        return items
    }
}