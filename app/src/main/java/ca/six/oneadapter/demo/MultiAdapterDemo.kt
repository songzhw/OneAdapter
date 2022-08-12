package ca.six.oneadapter.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.six.oneadapter.lib.RvViewHolder
import ca.six.oneadapter.lib.multiple.IRvType
import ca.six.oneadapter.lib.multiple.MultipleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MultiAdapterDemo : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = arrayListOf(
            Yang("001"), Yin("1A"), Yin("1B"), Yin("1C"),
            Yang("002"), Yin("2A"), Yin("2B"), Yin("2C"), Yin("2D"),
            Yang("003"), Yin("3A"), Yin("3B"), Yin("3C"), Yin("3D"),
            Yang("004"), Yin("4A"), Yin("4B"),
            Yang("005"), Yin("5A"), Yin("5B"), Yin("5C"), Yin("5D"), Yin("5E"),
        )
        val typeTitle = object : IRvType {
            override fun getLayoutResId(): Int = R.layout.item_rv_title
            override fun render(vh: RvViewHolder, datum: Any, position: Int) {
                vh.setText(R.id.tvRvTitle, (datum as Yang).title)
            }
        }
        val typeContent = object : IRvType {
            override fun getLayoutResId(): Int = R.layout.item_rv_one
            override fun render(vh: RvViewHolder, datum: Any, position: Int) {
                vh.setText(R.id.tv_rv_item, (datum as Yin).name)
            }
        }
        val types = mapOf(Yang::class.java to typeTitle, Yin::class.java to typeContent)

        rvSimple.layoutManager = LinearLayoutManager(this)
        val adapter = MultipleAdapter(data, types)
        rvSimple.adapter = adapter

    }
}

class Yin(val name: String)
class Yang(val title: String)