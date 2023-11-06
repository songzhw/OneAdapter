package ca.six.oneadapter.lib.diff_builder

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ca.six.oneadapter.lib.RvViewHolder
import ca.six.oneadapter.lib.builder.BuilderItem

class DiffBuilderAdapter(
    val myDiff: DiffUtil.ItemCallback<BuilderItem>,
) : ListAdapter<BuilderItem, RvViewHolder>(myDiff) {

    override fun getItemViewType(position: Int): Int {
        val datum = getItem(position)
        return datum.getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder.createViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val datum = getItem(position)
        datum.render(holder)
    }

}