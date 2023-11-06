package ca.six.oneadapter.demo.diff_builder

import ca.six.oneadapter.demo.R
import ca.six.oneadapter.lib.RvViewHolder
import ca.six.oneadapter.lib.builder.BuilderItem
import ca.six.oneadapter.lib.diff_builder.MatchEachDiffResult

data class InvestDay(var name: String)

class InvestDayBuilderItem(var obj: InvestDay) : BuilderItem(obj) {
    override fun getViewType(): Int = R.layout.item_builder_title

    override fun render(vh: RvViewHolder) {
        vh.setText(R.id.tvTitle, obj.name)
    }

    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is InvestDayBuilderItem && now is InvestDayBuilderItem) {
                if (old.obj.name == now.obj.name) return MatchEachDiffResult.MATCHED_TRUE
                else return MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }
}