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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = listOf(
            Category(name = "Politique", image = "https://picsum.photos/500/300"),
            Category(name = "Economie", image = "https://picsum.photos/500/300"),
            Category(name = "Education", image = "https://picsum.photos/500/300"),
            Category(name = "Pandémie", image = "https://picsum.photos/500/300"),
            Category(name = "Sciences", image = "https://picsum.photos/500/300"),
            Category(name = "Ecologie", image = "https://picsum.photos/500/300"),
            Category(name = "Santé", image = "https://picsum.photos/500/300"),
        )

        val adapterRecycler = CategoryAdapter(articles)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapterRecycler
    }

}