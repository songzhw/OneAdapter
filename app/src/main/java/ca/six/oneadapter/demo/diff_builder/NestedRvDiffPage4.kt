package ca.six.oneadapter.demo.diff_builder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.six.oneadapter.demo.R
import ca.six.oneadapter.lib.builder.BuilderItem
import ca.six.oneadapter.lib.diff_builder.DiffBuilderAdapter
import ca.six.oneadapter.lib.diff_builder.DiffBuilderCallback
import kotlinx.android.synthetic.main.actv_rv_btn.*

class NestedRvDiffPage4 : AppCompatActivity(R.layout.actv_rv_btn) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = arrayListOf(
            InvestDayBuilderItem(InvestDay("11th")),
            InvestItemBuildItem(arrayListOf(InvestItem("brunch", "$4.00"),
                InvestItem("supper", "$13.00"))),

            InvestDayBuilderItem(InvestDay("12th")),
            InvestItemBuildItem(arrayListOf(InvestItem("朝ごはん", "$4.50"),
                InvestItem("昼ごはん", "$12.50"),
                InvestItem("晩ごはん", "$20.00"))),

            InvestDayBuilderItem(InvestDay("14th")),
            InvestItemBuildItem(arrayListOf(InvestItem("apple", "$5.20"),
                InvestItem("bus", "$3.50"),
                InvestItem("train", "$200.00"),
                InvestItem("snack", "$15.00"))),
        )
        val investDiff =  DiffBuilderCallback(arrayListOf(
            InvestDayBuilderItem::isSame, InvestItemBuildItem::isSame
        ))
        val adapter = DiffBuilderAdapter(investDiff)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        adapter.submitList(data)

        btn1.text = "delete 1"
        btn1.setOnClickListener {
            val list2 = copy(data)
            list2.removeAt(1) //即删除了第一个子list, 即第一天的全部支出都删除了
            adapter.submitList(list2)
        }

        btn2.text = "change 1"
        btn2.setOnClickListener {
            val list3 = copy(data)
            (list3[0] as InvestDayBuilderItem).obj = InvestDay("21st")
            (list3[1] as InvestItemBuildItem).list[1].money = "¥3.99"
            (list3[1] as InvestItemBuildItem).list.add(0, InvestItem("豆浆", "¥0.50"))
            adapter.submitList(list3)
        }

    }

    private fun copy(data: List<BuilderItem>): ArrayList<BuilderItem> {
        val ret = arrayListOf<BuilderItem>()
        data.forEach {
            if(it is InvestDayBuilderItem) {
                ret.add(InvestDayBuilderItem(it.obj))
            } else if(it is InvestItemBuildItem) {
                val items = ArrayList(it.list.map {InvestItem(it.name, it.money)})
                ret.add(InvestItemBuildItem(items))
            }
        }
        return ret
    }
}