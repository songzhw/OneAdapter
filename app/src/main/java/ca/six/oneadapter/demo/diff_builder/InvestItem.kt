package ca.six.oneadapter.demo.diff_builder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.six.oneadapter.demo.R
import ca.six.oneadapter.lib.OneAdapter
import ca.six.oneadapter.lib.RvViewHolder
import ca.six.oneadapter.lib.builder.BuilderItem
import ca.six.oneadapter.lib.diff_builder.MatchEachDiffResult

data class InvestItem(var name: String, var money: String)

class InvestItemBuildItem(val list: ArrayList<InvestItem>) : BuilderItem {
    override fun getViewType(): Int = R.layout.item_expend_month

    override fun render(vh: RvViewHolder) {
        vh.setVisibility(R.id.tvDay, View.GONE)
        val rv = vh.getView<RecyclerView>(R.id.rvDay)
        val ctx = rv.context
        rv.layoutManager = LinearLayoutManager(ctx)
        rv.adapter = object : OneAdapter<InvestItem>(R.layout.item_expend_day, list) {
            override fun apply(vh: RvViewHolder, value: InvestItem, position: Int) {
                vh.setText(R.id.tvName, value.name)
                vh.setText(R.id.tvAmount, value.money)
            }
        }
    }

    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is InvestItemBuildItem && now is InvestItemBuildItem) {
                if (old.list.size != now.list.size) MatchEachDiffResult.MATCHED_FALSE
                val isSameContent = old.list.zip(now.list).all { (e1, e2) ->
                    e1.name == e2.name && e1.money == e2.money
                }
                return if (isSameContent) MatchEachDiffResult.MATCHED_TRUE else MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }

}