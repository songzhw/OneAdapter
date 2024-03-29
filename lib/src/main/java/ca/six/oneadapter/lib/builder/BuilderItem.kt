package ca.six.oneadapter.lib.builder

import ca.six.oneadapter.lib.RvViewHolder

// 要有CF参数, 所以不能是interface (即不能利用IRvType)
interface BuilderItem {
    abstract fun getViewType(): Int
    abstract fun render(holder: RvViewHolder)
}