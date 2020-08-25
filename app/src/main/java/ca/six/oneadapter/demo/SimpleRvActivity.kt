package ca.six.oneadapter.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.six.oneadapter.lib.OneAdapter
import ca.six.oneadapter.lib.RvViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class SimpleRvActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = (1..20).map { "ReccylerView Item $it" }
        rvSimple.layoutManager = LinearLayoutManager(this)
        val adapter: OneAdapter<String> = object : OneAdapter<String>(R.layout.item_rv_one, data) {
            override fun apply(vh: RvViewHolder, value: String, position: Int) {
                vh.setText(R.id.tv_rv_item, value)
            }
        }
        rvSimple.setAdapter(adapter)
    }
}