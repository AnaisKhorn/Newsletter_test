import adapters.Article
import adapters.ArticleAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import networks.ArticleRepository

class ArticlesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var planetes = resources.getStringArray(R.array.planetes)
        val spinner : Spinner  = view.findViewById(R.id.spinner_frag)
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, planetes)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(context, "Vous n'avez rien selectionné", Toast.LENGTH_LONG).show()    }
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(context, "Vous avez selectionné ${planetes[position]}", Toast.LENGTH_LONG).show()
            }
        }

        val recyclerView : RecyclerView = view.findViewById(R.id.recycler)

        val articles = listOf<Article>(Article("coucou" ,"c'est moi"), Article("test", "testezifdjujferjfi_edzsçjfzefoij_rueijfezjiofds"),
            Article("cc", "cc"), Article("ff", "ff"))

        val adapterRecycler = ArticleAdapter(articles)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterRecycler

    }

/*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            getData()
        }
    }

    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result)
        }
    }

    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {}
    } */
}



