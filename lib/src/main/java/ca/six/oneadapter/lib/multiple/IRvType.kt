package ca.six.oneadapter.lib.multiple

import ca.six.oneadapter.lib.RvViewHolder

interface IRvType {
    fun getLayoutResId(): Int
    fun render(vh: RvViewHolder, datum: Any, position: Int)
}