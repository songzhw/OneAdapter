package ca.six.oneadapter.lib.diff_builder

import androidx.recyclerview.widget.DiffUtil
import ca.six.oneadapter.lib.builder.BuilderItem

typealias CompareBuilderItemFunc = (BuilderItem, BuilderItem) -> MatchEachDiffResult

class DiffBuilderCallback(val parts: ArrayList<CompareBuilderItemFunc>) : DiffUtil.ItemCallback<BuilderItem>() {

    override fun areItemsTheSame(oldItem: BuilderItem, newItem: BuilderItem): Boolean {
        for (i in 0 until parts.size) {
            val result = parts[i](oldItem, newItem)
            if (result == MatchEachDiffResult.MATCHED_TRUE) return true
            else if (result == MatchEachDiffResult.MATCHED_FALSE) return false
            // else if(result == NOT_MATCHED) continue
        }
        return false
    }

    override fun areContentsTheSame(oldItem: BuilderItem, newItem: BuilderItem): Boolean {
        for (i in 0 until parts.size) {
            val result = parts[i](oldItem, newItem)
            if (result == MatchEachDiffResult.MATCHED_TRUE) return true
            else if (result == MatchEachDiffResult.MATCHED_FALSE) return false
            // else if(result == NOT_MATCHED) continue
        }
        return false
    }
}