package ca.six.oneadapter.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import ca.six.oneadapter.lib.OneDiffAdapter
import ca.six.oneadapter.lib.RvViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class DiffOneRvActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        }

        val adapter = object : OneDiffAdapter<String>(diffCallback, R.layout.item_rv_one) {
            override fun apply(vh: RvViewHolder, value: String, position: Int) {
                vh.setText(R.id.tv_rv_item, value)
            }
        }

        rvSimple.layoutManager = LinearLayoutManager(this)
        rvSimple.adapter = adapter
        val data = (1..20).map { "ReccylerView Item $it" }
        adapter.refresh(data)


    }
}