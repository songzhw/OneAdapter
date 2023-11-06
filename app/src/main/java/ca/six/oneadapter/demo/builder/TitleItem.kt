package ca.six.oneadapter.demo.builder

import android.widget.Toast
import ca.six.oneadapter.demo.R
import ca.six.oneadapter.lib.RvViewHolder
import ca.six.oneadapter.lib.builder.BuilderItem

class TitleItem(val title: String) : BuilderItem {
    override fun getViewType() = R.layout.item_rv_one

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tv_rv_item, title)
    }

}


data class Description(val desp: String, val imageResId: Int)

class DescriptionItem(val despcription: Description) : BuilderItem {
    override fun getViewType() = R.layout.item_desp

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tvItem, despcription.desp)
        holder.setSrc(R.id.ivItem, despcription.imageResId)
        holder.setClickListener(R.id.tvItem) {
            Toast.makeText(it.context, "click: ${despcription.desp}", Toast.LENGTH_SHORT).show()
        }
    }
}