package fr.mbds.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.mbds.newsletter.adapters.CategoryAdapter
import fr.mbds.newsletter.model.Category
import fr.mbds.newsletter.R

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        val articles = listOf(
            Category(name = "sex",       image = "https://picsum.photos/200?random=1"),
            Category(name = "politic",   image = "https://picsum.photos/200?random=2"),
            Category(name = "economy",   image = "https://picsum.photos/200?random=3"),
            Category(name = "education", image = "https://picsum.photos/200?random=4"),
            Category(name = "pandemic",  image = "https://picsum.photos/200?random=5"),
            Category(name = "sciences",  image = "https://picsum.photos/200?random=6"),
            Category(name = "ecology",   image = "https://picsum.photos/200?random=7"),
            Category(name = "health",    image = "https://picsum.photos/200?random=8")
        )

        val adapterRecycler = CategoryAdapter(articles)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapterRecycler
    }
}